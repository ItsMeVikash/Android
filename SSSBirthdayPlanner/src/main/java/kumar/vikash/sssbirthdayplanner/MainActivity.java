package kumar.vikash.sssbirthdayplanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kumar.vikash.sssbirthdayplanner.flavours.Chocolate;
import kumar.vikash.sssbirthdayplanner.flavours.Eggless;
import kumar.vikash.sssbirthdayplanner.flavours.Fruit;
import kumar.vikash.sssbirthdayplanner.flavours.Non_Veg;
import kumar.vikash.sssbirthdayplanner.flavours.Others;
import kumar.vikash.sssbirthdayplanner.flavours.Trending;
import kumar.vikash.sssbirthdayplanner.flavours.Vanilla;

public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth auth;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar as actionBar
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("SSS BIRTHDAY PLANNER");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //tabs
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //login FIREBASEUI
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // already signed in
            //send to admin page for adding new items
            String s="ownplanner.sss@gmail.com";
            if (auth.getCurrentUser().getProviders().toString().equalsIgnoreCase("[google.com]"))
            {
                if(auth.getCurrentUser().getEmail().toString().equalsIgnoreCase(s))
                {
                    Intent i = new Intent(this, Admin.class);
                    startActivity(i);
                }
            }
        } else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(
                            Arrays.asList(
                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                            ))
                    .setIsSmartLockEnabled(false, true)
                    .setTheme(R.style.LoginTheme)
                    .build(), RC_SIGN_IN);
        }

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Trending(), "Trending");
        adapter.addFragment(new Fruit(), "Fruit");
        adapter.addFragment(new Chocolate(), "Chocolate");
        adapter.addFragment(new Vanilla(), "Vanilla");
        adapter.addFragment(new Non_Veg(), "Non-Veg");
        adapter.addFragment(new Eggless(), "Eggless");
        adapter.addFragment(new Others(), "Others");

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int myColor;
                switch (position) {
                    case 0:
                        myColor = Color.parseColor("#bf0000");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    case 1:
                        myColor = Color.parseColor("#8B0000");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    case 2:
                        myColor = Color.parseColor("#B22222");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    case 3:
                        myColor = Color.parseColor("#DC143C");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    case 4:
                        myColor = Color.parseColor("#FF4500");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    case 5:
                        myColor = Color.parseColor("#A52A2A");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    case 6:
                        myColor = Color.parseColor("#800000");
                        toolbar.setBackgroundColor(myColor);
                        tabLayout.setBackgroundColor(myColor);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                //user logged in
                //send to admin page for adding new items
                String s="ownplanner.sss@gmail.com";
                if (auth.getCurrentUser().getProviders().toString().equalsIgnoreCase("[google.com]"))
                {
                    if(auth.getCurrentUser().getEmail().toString().equalsIgnoreCase(s))
                    {
                        Intent i = new Intent(this, Admin.class);
                        startActivity(i);
                    }
                }
            } else {
                //user not authenticated
                Log.d("AUTH", "NOT AUTHENTICATED");
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.cart)
        {
            Intent i=new Intent(this,Cart.class);
            startActivity(i);
        }
        if (item.getItemId()==R.id.other_app)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
            alertDialogBuilder.setIcon(R.mipmap.logo);
            alertDialogBuilder.setTitle("Other App");
            String link1 = "<a href=\"https://play.google.com/store/apps/details?id=com.collegemania&hl=en\">College Mania</a>";
            String link2 = "<a href=\"https://play.google.com/store/apps/details?id=nightlife.kumar.vikash.nightlife&hl=en\">NightLife</a>";
            String message = "<br>Check Out Our Other Apps :<br>"+
                    "<br><br>Nightlife is the best place to drink down your sorrows and happiness. It lets you discover places where you can drink and party till late night. Browse through various pubs, bar, nightclub to decide your favorite place and use the inbuilt map features to guide you.<br>"+link2+
                    "<br><br>An application consisting of information related to engineering and polytechnic colleges in India. Our motto is to guide students to best universities around India.<br>"+link1;
            Spanned myMessage = Html.fromHtml(message);
            alertDialogBuilder.setMessage(myMessage);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
            msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (item.getItemId()==R.id.contact_us)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
            alertDialogBuilder.setIcon(R.mipmap.logo);
            alertDialogBuilder.setTitle("Contact Us");
            String link1 = "<a href=\"http://www.smilingsingingsuccess.com/\">smilingsingingsuccess</a>";
            String link2 = "<a href=\"tel:+91-8789009420\">8789009420</a>";
            String link3 = "<a href=\"mailto:ownplanner.sss@gmail.com\">ownplanner.sss@gmail.com</a>";
            String link4 = "<a href=\"https://www.facebook.com/Sss-Birthday-Planner-250872692144291/\">Facebook</a>";
            String link5 = "<a href=\"https://api.whatsapp.com/send?phone=919431201780\">Whatsapp</a>";
            String message = "<br>Check Our Website:<br>"+link1+
                            "<br><br>Call Us:<br>"+link2+
                             "<br><br>Send Feedback:<br>"+link3+
                             "<br><br>Follow Us At:<br>"+link4+
                             "<br><br>Chat With Us At:<br>"+link5;
            Spanned myMessage = Html.fromHtml(message);
            alertDialogBuilder.setMessage(myMessage);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
            msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (item.getItemId()==R.id.about_us)
        {
            //showing confirmation dialog box
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
            alertDialogBuilder.setIcon(R.mipmap.logo);
            alertDialogBuilder.setTitle("About Us");
            String link1 = "<a href=\"http://www.smilingsingingsuccess.com/\">smilingsingingsuccess</a>";
            String link2 = "<a href=\"tel:+91-8789009420\">8789009420</a>";
            String message = "Hey!!  First of all introducing sss. Its not just three word itself a great concept of life to live. From three years we are regularly working in the field of literature which you can check by visiting our website : "+link1
                                +"<br><br>Now its to time to work in  field of event planning management which is initiated with small steps as birthday planner."+
                                "<br><br>Its aim to manage your birthday by providing everything which is required in your celebration. You can go through its best plans which is mentioned  in this application, also you can prepare your plan and talk to us and we will try to satisfy you and according to its success and review it can be much  improved further. A great thanks for becoming our part."
                                +"<br><br> Call us at:  "+link2;
            Spanned myMessage = Html.fromHtml(message);
            alertDialogBuilder.setMessage(myMessage);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
            msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (item.getItemId()==R.id.how_to_use)
        {
            //showing confirmation dialog box
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
            alertDialogBuilder.setIcon(R.mipmap.logo);
            alertDialogBuilder.setTitle("How To Use");
            String link1 = "<a href=\"tel:+91-8789009420\">8789009420</a>";
            String message="Welcome to SSS Birthday Planner."+
                    "<br><br>1. \tChoose Flavours." +
                    "<br>2. \tSelect Cake." +
                    "<br>3. \tAdd It To Cart." +
                    "<br>4. \tSelect Quantity." +
                    "<br>5. \tProceed For Checkout." +
                    "<br>6. \tSelect Payment Mode." +
                    "<br>7. \t Your Order Placed." +
                    "<br><br> Call us at:  "+link1;
            Spanned myMessage = Html.fromHtml(message);
            alertDialogBuilder.setMessage(myMessage);
           /* alertDialogBuilder.setMessage("");*/
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
            msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        LinearLayout coordinatorLayout = (LinearLayout) findViewById(R.id.coordinatorLayout);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Want To Close App?",1)
                .setDuration(3000)
                .setAction("\n\nYes", new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                });
        snackbar.setActionTextColor(Color.parseColor("#FF9900"));
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.logo, 0, 0, 0);
        textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }
}
