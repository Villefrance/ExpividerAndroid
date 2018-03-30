package expivider.expividerandroid.services;

import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import java.util.List;

import expivider.expividerandroid.model.Post;
import expivider.expividerandroid.observer.IObserver;

public interface IDataService {

    void login(String username, String password, IObserver source);

    RequestQueue getRequestQueue();

    void getPosts(ArrayAdapter<Post> adapter);

    void createPost(String title, String description, String type, IObserver source);

}
