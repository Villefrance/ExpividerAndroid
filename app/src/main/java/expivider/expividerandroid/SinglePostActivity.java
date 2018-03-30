package expivider.expividerandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import expivider.expividerandroid.model.Application;
import expivider.expividerandroid.model.Post;

public class SinglePostActivity extends AppCompatActivity {

    private Post selectedPost;
    private List<Application> applications;
    private ArrayAdapter<Application> applicationArrayAdapter;
    private ListView applicationList;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post);

        applications = new ArrayList<>();
        applicationArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, applications);

        applicationList = findViewById(R.id.applicationsList);
        title = findViewById(R.id.titleOfPost);



        applicationList.setAdapter(applicationArrayAdapter);

        selectedPost = (Post) getIntent().getSerializableExtra("post");

        title.setText(selectedPost.getTitle());

        for(Application app : selectedPost.getApplications()) {
            applicationArrayAdapter.add(app);
        }

    }
}
