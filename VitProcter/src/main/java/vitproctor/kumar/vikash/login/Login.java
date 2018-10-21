package vitproctor.kumar.vikash.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import vitproctor.kumar.vikash.MainActivity;
import vitproctor.kumar.vikash.R;


public class Login extends AppCompatActivity {
    Button login;
    EditText id,name;
    String l;
    ArrayList<String> list1=new ArrayList<>();
    ArrayList<String> list2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        id=(EditText)findViewById(R.id.id);
        login=(Button)findViewById(R.id.login);
        name=(EditText)findViewById(R.id.name);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("string_id", id.getText().toString());
        editor.putString("string_name", name.getText().toString());
        editor.commit();

        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2,ref3;
        ref2 = ref1.child("Faculty_Name");
        ref3 = ref1.child("Faculty_Details");
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list1 = new ArrayList<String>();
                // Result will be holded Here
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    list1.add(String.valueOf(dsp.getValue()).toUpperCase());
                    //add result into array list

                }
            }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    System.out.println(databaseError.toException());
                    // ...
                }
            });
        ref3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list2 = new ArrayList<String>();
                // Result will be holded Here
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    list2.add(String.valueOf(dsp.getValue()).toUpperCase());
                    //add result into array list

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println(databaseError.toException());
                // ...
            }
        });
       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(id.getText().toString().matches("") && name.getText().toString().matches("")) {
                    Toast.makeText(Login.this, "You did not enter your Details", Toast.LENGTH_SHORT).show();
                    return;
            }
            if((list1.toString().contains(id.getText().toString().toUpperCase())&& list1.toString().contains(name.getText().toString().toUpperCase()))||
                (list2.toString().contains(id.getText().toString().toUpperCase())&& list2.toString().contains(name.getText().toString().toUpperCase())))
            {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
            else
                Toast.makeText(Login.this, "Sorry We can not verify you !! Contact Administrator Office", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
