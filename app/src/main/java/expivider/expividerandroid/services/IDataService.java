package expivider.expividerandroid.services;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import expivider.expividerandroid.observer.IObserver;

public interface IDataService {

    void login(String username, String password, IObserver source);

    RequestQueue getRequestQueue();

}
