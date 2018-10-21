package kumar.vikash.gmailfacebooklogin;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 420;

    private GoogleApiClient mGoogleApiClient;

    private SignInButton btnSignIn;

    public LoginButton loginButton;
    public Button fb, google;
    public CallbackManager callbackManager;
    public String id, name, email, gender, birthday;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();

        fb = (Button) findViewById(R.id.fb);
        google = (Button) findViewById(R.id.google);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        //saving user details
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        String status=pref.getString("key_name","null");
        if (status.equalsIgnoreCase("Facebook")||status.equalsIgnoreCase("Google")){
            Intent myIntent = new Intent( this, Success.class);
            myIntent.putExtra("myExtra", status);
            startActivity(myIntent);
            finish();
        }
        loginButton.registerCallback(callbackManager, new FacebookCallback< LoginResult >() {@Override
        public void onSuccess(LoginResult loginResult) {

            editor.putString("key_name", "Facebook");
            editor.commit(); // commit changes
            Intent myIntent = new Intent( MainActivity.this, Success.class);
            myIntent.putExtra("myExtra", "Facebook");
            startActivity(myIntent);
            finish();
        }
            @Override
            public void onCancel() {
                System.out.println("onCancel");
            }
            @Override
            public void onError(FacebookException exception) {
                Log.v("LoginActivity", exception.getCause().toString());
            }
        });
        //Google Login

        initializeControls();
        initializeGPlusSettings();
    }
    private void initializeControls(){
        btnSignIn = (SignInButton) findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(this);
    }
    private void initializeGPlusSettings(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        btnSignIn.setSize(SignInButton.SIZE_STANDARD);
        btnSignIn.setScopes(gso.getScopeArray());
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    private void handleGPlusSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            //get all required user details from acct
            GoogleSignInAccount acct = result.getSignInAccount();
            editor.putString("key_name", "Google");
            editor.commit(); // commit changes
            Intent myIntent = new Intent( this, Success.class);
            myIntent.putExtra("myExtra", "Google");
            startActivity(myIntent);
            finish();
        }
    }



    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleGPlusSignInResult(result);
        } else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    handleGPlusSignInResult(googleSignInResult);
                }
            });
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode,
                                    Intent data) {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleGPlusSignInResult(result);
        }else{
            super.onActivityResult(requestCode, responseCode, data);
            callbackManager.onActivityResult(requestCode, responseCode, data);
        }
    }
    public void onClick(View v) {
        if (v == fb) {
            loginButton.performClick();
        }else if(v == google){
            signIn();
        }
    }

}