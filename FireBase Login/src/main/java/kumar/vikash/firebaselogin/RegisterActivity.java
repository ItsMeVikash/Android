package kumar.vikash.firebaselogin;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {
    EditText email,password;
    Button registerButton,loginButton;
    FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        registerButton = (Button) findViewById(R.id.RegisterButton);
        loginButton = (Button) findViewById(R.id.LoginButton);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString();
                final String passwordd = password.getText().toString();

                if(TextUtils.isEmpty(emaill)){
                    email.setError("Enter Email First");
                    return;
                }
                if(TextUtils.isEmpty(passwordd)){
                    password.setError("Enter Password First");
                }

                if(passwordd.length()<6){
                    password.setError("Password too short, enter minimum 6 characters!");
                }
                if(!(TextUtils.isEmpty(emaill))&&!(TextUtils.isEmpty(passwordd))) {
                    progressBar.setVisibility(View.VISIBLE);
                    //create user
                    firebaseAuth.createUserWithEmailAndPassword(emaill, passwordd)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(RegisterActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        if (passwordd.length() < 6) {
                                            password.setError("Password too short, enter minimum 6 characters!");
                                        } else {

                                            Toast.makeText(RegisterActivity.this, "Authentication failed." , Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                        finish();
                                    }
                                }
                            });
                }

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}