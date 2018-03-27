package expivider.expividerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.sql.SQLOutput;

import expivider.expividerandroid.observer.IObserver;
import expivider.expividerandroid.services.DataService;
import expivider.expividerandroid.services.IDataService;

public class LoginActivity extends AppCompatActivity implements IObserver{

    private IDataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataService = DataService.getInstance(this);
    }

    public void submitCredentials(View view) {

        Log.i("Button", "The button got pressed");


        //Find string values of credentials
        TextView emailInput = (TextView) findViewById(R.id.emailInput);
        TextView passwordInput = (TextView) findViewById(R.id.passwordInput);

        String rawEmail = emailInput.getText().toString();
        String rawPassword = passwordInput.getText().toString();

        //Processing login request...
        dataService.login(rawEmail, rawPassword, this);

        Log.i("dataservice", "got passed servicecall");
    }

    @Override
    public void completedRequest() {
        Intent intent = new Intent(this, PostsActivity.class);

        startActivity(intent);
    }
}
