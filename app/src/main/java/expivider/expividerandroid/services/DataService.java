package expivider.expividerandroid.services;

import android.app.DownloadManager;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.List;

import expivider.expividerandroid.model.Post;
import expivider.expividerandroid.observer.IObserver;
import expivider.expividerandroid.response.ResponseListener;

public class DataService implements IDataService {

    private final String BASE_URL = "https://expivider.herokuapp.com";
    private final String LOGIN_URL = "/login";
    private final String POSTS_URL = "/posts";

    private static IDataService instance;
    private RequestQueue queue;
    private static Context mCtx;
    private CookieManager manager;

    private DataService(Context context) {
        mCtx = context;
        queue = getRequestQueue();

        //Cookiehandling...
        manager = new CookieManager();
        CookieHandler.setDefault(manager);
    }


    public static IDataService getInstance(Context context) {
        if(instance == null) {
            //Used param to set whatever firstly consumed applicationcontext
            instance = new DataService(context);
        }

        return instance;
    }





    @Override
    public void login(String username, String password, IObserver source) {

        if(username == null || password == null) {
            return;
        }

        JSONObject loginPost = new JSONObject();
        try {
            loginPost.put("email", username);
            loginPost.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, BASE_URL+LOGIN_URL, loginPost, new ResponseListener<JSONObject>(source), new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.i("Error", error.toString());
                    }
                });

        //Node.js API can sleep op to 1 minute
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public RequestQueue getRequestQueue() {
        if(queue == null) {
            //this ensures that we get the application context based on whatever app context used...
            queue = Volley.newRequestQueue(mCtx.getApplicationContext());
            Log.i("queue", "queue got set");
        }
        return queue;
    }

    @Override
    public void getPosts(final ArrayAdapter<Post> adapter) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL + POSTS_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                //Conversion of json array of posts to Post objects and add to the param adapter...
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Post>>() {}.getType();
                List<Post> posts =  gson.fromJson(response.toString(), listType);

                for(Post post : posts) {
                    Log.i("Post", post.toString());
                    adapter.add(post);
                }

            }},
                new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Error", error.toString());
                }

        });

        addToRequestQueue(jsonArrayRequest);

    }

    @Override
    public void createPost(String title, String description, String type, IObserver source) {

        JSONObject post = new JSONObject();

        try {
            post.put("title", title);
            post.put("description", description);
            post.put("type", type);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL + POSTS_URL, post, new ResponseListener<JSONObject>(source), new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error Request", error.toString());
            }
        });

        addToRequestQueue(jsonObjectRequest);
    }

    private <T> void addToRequestQueue(Request<T> req) {
        Log.i("queue", req.toString());
        getRequestQueue().add(req);
    }
}
