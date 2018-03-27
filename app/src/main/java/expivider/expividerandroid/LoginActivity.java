package expivider.expividerandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import expivider.expividerandroid.services.DataService;
import expivider.expividerandroid.services.IDataService;

public class LoginActivity extends AppCompatActivity {

    private IDataService dataService = DataService.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void submitCredentials() {

        //Find string values of credentials
        TextView emailInput = (TextView) findViewById(R.id.emailInput);
        TextView passwordInput = (TextView) findViewById(R.id.passwordInput);

        String rawEmail = emailInput.getText().toString();
        String rawPassword = passwordInput.getText().toString();

        //Processing login request...
        dataService.login(rawEmail, rawPassword);
    }
}
