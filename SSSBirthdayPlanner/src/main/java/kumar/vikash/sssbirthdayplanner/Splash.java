package kumar.vikash.sssbirthdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        TextView splash_Textview=(TextView)findViewById(R.id.splash_textview);
        TranslateAnimation fadeIn = new TranslateAnimation(0.0f, 0.0f, -600.0f, 0.0f);
        fadeIn.setDuration(1500);
        splash_Textview.startAnimation(fadeIn);

         TextView splash_Textview1=(TextView)findViewById(R.id.splash_textview1);
        TranslateAnimation fadeIn1 = new TranslateAnimation(0.0f, 0.0f, 600.0f, 0.0f);
        fadeIn1.setDuration(1500);
        splash_Textview1.startAnimation(fadeIn1);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        ImageView img_animation = (ImageView) findViewById(R.id.image);
        img_animation.startAnimation(rotateAnimation);

        Thread t=new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
