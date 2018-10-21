package kumar.vikash.gmailfacebooklogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class Success extends AppCompatActivity {

    private TextView status;
    private Button logout;
    private GoogleApiClient mGoogleApiClient;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        status=(TextView)findViewById(R.id.status);
        logout=(Button)findViewById(R.id.btn_logout);
        final Intent myIntent = getIntent();
        status.setText("Login Using  "+myIntent.getStringExtra("myExtra")+"!");
        preferences =getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = preferences.edit();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myIntent.getStringExtra("myExtra").equalsIgnoreCase("Facebook")){

                    LoginManager.getInstance().logOut();
                    editor.clear();
                    editor.commit();
                    Intent intent = new Intent(Success.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if (myIntent.getStringExtra("myExtra").equalsIgnoreCase("Google")) {
                    Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                            new ResultCallback<Status>() {
                                @Override
                                public void onResult(Status status) {
                                    editor.clear();
                                    editor.commit();
                                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            });

                }
                }
        });

    }
    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }
}
