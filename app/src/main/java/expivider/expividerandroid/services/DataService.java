package expivider.expividerandroid.services;

import android.app.DownloadManager;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import expivider.expividerandroid.observer.IObserver;
import expivider.expividerandroid.response.ResponseListener;

public class DataService implements IDataService {

    private final String BASE_URL = "https://expivider.herokuapp.com";
    private final String LOGIN_URL = "/login";
    private final String POSTS_URL = "/posts";

    private static IDataService instance;
    private RequestQueue queue;
    private static Context mCtx;

    private DataService(Context context) {
        mCtx = context;
        queue = getRequestQueue();

        //Neeed to setup cache here based on the queue...
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
                (Request.Method.POST, BASE_URL+LOGIN_URL, loginPost, new ResponseListener(source), new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.i("Error", error.toString());
                    }
                });

        addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public RequestQueue getRequestQueue() {
        if(queue == null) {
            //this ensures that we get the application context based on whatever appcontext used...
            queue = Volley.newRequestQueue(mCtx.getApplicationContext());
            Log.i("queue", "queue got set");
        }
        return queue;
    }

    private <T> void addToRequestQueue(Request<T> req) {
        Log.i("queue", req.toString());
        getRequestQueue().add(req);
    }
}
