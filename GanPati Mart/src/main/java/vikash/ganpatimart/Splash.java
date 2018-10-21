package vikash.ganpatimart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView splash_Textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        splash_Textview=(TextView) findViewById(R.id.splash_textview);
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        splash_Textview.startAnimation(fadeIn);
        fadeIn.setDuration(1000);
        fadeIn.setFillAfter(true);
        Thread t=new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent i=new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}