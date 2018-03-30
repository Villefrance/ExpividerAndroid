package expivider.expividerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import expivider.expividerandroid.observer.IObserver;
import expivider.expividerandroid.services.DataService;

public class CreatePostActivity extends AppCompatActivity implements IObserver{

    private EditText postTitleText;
    private EditText postDescriptionText;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        postTitleText = findViewById(R.id.postTitle);
        postDescriptionText = findViewById(R.id.postDescription);
        radioGroup = findViewById(R.id.radioGroup);

    }

    public void createPost(View view) {

        String title = postTitleText.getText().toString();
        String description = postDescriptionText.getText().toString();

        //getting checked radioBtn
        int radioBtnId = radioGroup.getCheckedRadioButtonId();
        View radioBtn = radioGroup.findViewById(radioBtnId);
        int idx = radioGroup.indexOfChild(radioBtn);

        RadioButton r = (RadioButton) radioGroup.getChildAt(idx);
        String type = r.getText().toString();

        DataService.getInstance(this).createPost(title, description, type, this);
    }

    @Override
    public void completedRequest() {
        Intent intent = new Intent(this, PostsActivity.class);
        startActivity(intent);
    }
}
