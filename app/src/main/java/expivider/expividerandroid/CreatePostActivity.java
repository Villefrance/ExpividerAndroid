package expivider.expividerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import expivider.expividerandroid.observer.IObserver;

public class CreatePostActivity extends AppCompatActivity implements IObserver{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

    }

    @Override
    public void completedRequest() {
        Intent intent = new Intent(this, PostsActivity.class);
        startActivity(intent);
    }
}
