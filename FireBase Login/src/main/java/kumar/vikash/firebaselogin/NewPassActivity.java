package kumar.vikash.firebaselogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class NewPassActivity extends AppCompatActivity {
    EditText email;
    Button btnNewPass;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
        email = (EditText) findViewById(R.id.userEmail);
        btnNewPass = (Button) findViewById(R.id.newPassword);

        firebaseAuth = FirebaseAuth.getInstance();

        btnNewPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString();

                if(TextUtils.isEmpty(emaill)){
                    email.setError("Enter Email First");
                    return;
                }

                firebaseAuth.sendPasswordResetEmail(emaill)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Password reset link was sent your email address",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Mail sending error",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}