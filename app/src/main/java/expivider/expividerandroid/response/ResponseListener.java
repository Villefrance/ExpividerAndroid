package expivider.expividerandroid.response;

import android.util.Log;

import com.android.volley.Response;

import expivider.expividerandroid.observer.IObserver;

public class ResponseListener<T> implements Response.Listener<T> {

    private IObserver source;

    public ResponseListener(IObserver source) {
        this.source = source;
    }

    @Override
    public  void onResponse(T object) {

        Log.i("response", object.toString());
        //checking response
        source.completedRequest();
    }
}
