package vikash.ganpatimart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vikash.ganpatimart.customer.List_Items;
import vikash.ganpatimart.supplier.MainActivity;

public class Login extends AppCompatActivity {

    DatabaseReference dreference;
    EditText email,password;
    Button login,customer_login;
    String e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        dreference = FirebaseDatabase.getInstance().getReference().child("Login");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    //loop 2 to go through all the child nodes of books node
                    e = dataSnapshot.child("Email").getValue().toString();
                    p = dataSnapshot.child("Password").getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println(databaseError.toException());
                // ...
            }
        };
        dreference.addValueEventListener(listener);
        login=(Button)findViewById(R.id.login);
        customer_login=(Button)findViewById(R.id.customer_login);
        customer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),List_Items.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(email.getText().toString())||!TextUtils.isEmpty(password.getText().toString())) {
                    if (email.getText().toString().toUpperCase().trim().equalsIgnoreCase(e.toUpperCase()) && password.getText().toString().toUpperCase().trim().equalsIgnoreCase(p.toUpperCase())) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        //showing confirmation dialog box
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Login.this);
                        alertDialogBuilder.setMessage("Sorry, The Details are Wrong");
                        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
                else {
                    //showing confirmation dialog box
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Login.this);
                    alertDialogBuilder.setMessage("Enter Email & Password First");
                    alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });

    }
}
