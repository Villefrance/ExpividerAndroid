package expivider.expividerandroid.response;

import android.util.Log;

import com.android.volley.Response;

import org.json.JSONObject;

import expivider.expividerandroid.observer.IObserver;

public class ResponseListener implements Response.Listener<JSONObject> {

    private IObserver source;

    public ResponseListener(IObserver source) {
        this.source = source;
    }

    @Override
    public void onResponse(JSONObject object) {

        Log.i("response", object.toString());
        //checking response
        source.startIntent();
    }
}
