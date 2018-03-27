package expivider.expividerandroid.services;

import android.content.ContentProvider;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DataService implements IDataService {

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
    public void login(String username, String password) {

    }

    @Override
    public RequestQueue getRequestQueue() {
        if(queue == null) {
            //this ensures that we get the application context based on whatever appcontext used...
            queue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return queue;
    }

    @Override
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
