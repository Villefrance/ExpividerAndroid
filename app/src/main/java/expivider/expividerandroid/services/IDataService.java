package expivider.expividerandroid.services;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

public interface IDataService {

    void login(String username, String password);

    RequestQueue getRequestQueue();

    <T> void addToRequestQueue(Request<T> req);
}
