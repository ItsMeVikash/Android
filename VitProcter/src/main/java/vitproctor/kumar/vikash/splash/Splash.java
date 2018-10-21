package vitproctor.kumar.vikash.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import vitproctor.kumar.vikash.MainActivity;
import vitproctor.kumar.vikash.R;
import vitproctor.kumar.vikash.login.Login;
import vitproctor.kumar.vikash.notification.Notification;

public class Splash extends AppCompatActivity {
    TextView splash_Textview;
    String data,data1;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ( getIntent().getExtras() != null) {
            String value = getIntent().getExtras().getString("key");
            if (value != null) {
                mFirebaseInstance = FirebaseDatabase.getInstance();
                mFirebaseDatabase = mFirebaseInstance.getReference("Notification");
                DatabaseReference messageRef = mFirebaseDatabase.push();
                messageRef.child("MESSAGE").setValue(value);
                messageRef.child("timestamp").setValue(ServerValue.TIMESTAMP);

            }
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
         data = prefs.getString("string_id", "no id");
         data1=prefs.getString("string_name","no name");
        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        splash_Textview=(TextView)findViewById(R.id.splash_textview);
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        splash_Textview.startAnimation(fadeIn);
        fadeIn.setDuration(1000);
        fadeIn.setFillAfter(true);
        Thread t=new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    if(data.equals("")|| data.equals(""))
                    {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
