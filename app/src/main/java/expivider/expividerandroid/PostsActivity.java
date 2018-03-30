package expivider.expividerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import expivider.expividerandroid.model.Post;
import expivider.expividerandroid.observer.IObserver;
import expivider.expividerandroid.services.DataService;
import expivider.expividerandroid.services.IDataService;

public class PostsActivity extends AppCompatActivity implements IObserver {

    private IDataService dataService = DataService.getInstance(this);

    private ArrayAdapter<Post> adapter;
    private List<Post> posts;
    private ListView postListView;
    private AppCompatActivity postActivivy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        postActivivy = this;

        postListView = (ListView) findViewById(R.id.postListView);

        posts = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, posts);

        postListView.setAdapter(adapter);

        //Datasevice call parsing the adapter
        dataService.getPosts(adapter);

        //Add onItemClickListener to the listview
        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(postActivivy, SinglePostActivity.class);
                Post selectedPost = (Post) postListView.getAdapter().getItem(i);

                intent.putExtra("post", selectedPost);

                startActivity(intent);

            }
        });
    }


    public void createPost(View view) {
        Intent intent = new Intent(this, CreatePostActivity.class);


        startActivity(intent);
    }

    @Override
    public void completedRequest() {

    }
}
