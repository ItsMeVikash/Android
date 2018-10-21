package nightlife.kumar.vikash.nightlife.Splash_Screen;
import nightlife.kumar.vikash.nightlife.Intro_Slider.WelcomeActivity;
import nightlife.kumar.vikash.nightlife.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
TextView splash_Textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        splash_Textview=(TextView)findViewById(R.id.splash_textview);
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        splash_Textview.startAnimation(fadeIn);
        fadeIn.setDuration(800);
        fadeIn.setFillAfter(true);
        Thread t=new Thread(){
            public void run(){
                try {
                    sleep(1000);
                    Intent i=new Intent(getApplicationContext(),WelcomeActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
