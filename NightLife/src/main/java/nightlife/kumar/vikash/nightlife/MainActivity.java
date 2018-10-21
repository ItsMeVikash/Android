package nightlife.kumar.vikash.nightlife;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int RC_SIGN_IN=123,REQUEST_CAMERA=1, SELECT_FILE=2;
    private FirebaseAuth auth;
    ImageView profile_pic;
    TextView name,email;
    private String userChoosenTask;
    FloatingActionButton upload;
    SharedPreferences sharedPreferences;
    String encodedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);
        //opening default fragment
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame, new Main_fragment());
        tx.commit();
         //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("NIGHT LIFE");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
       // navMenuView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        navigationView.setNavigationItemSelectedListener(this);
        //setting navigation drawer profile
        View hView =  navigationView.getHeaderView(0);
        profile_pic =(ImageView)hView.findViewById(R.id.profile_pic);
        upload=(FloatingActionButton)hView.findViewById(R.id.upload);
        name =(TextView)hView.findViewById(R.id.name);
        email=(TextView)hView.findViewById(R.id.email);
        //Show saved image when app is open
        sharedPreferences = this.getSharedPreferences("myprefs", 0);
        String img_strr = sharedPreferences.getString("userphoto", BuildConfig.FLAVOR);
        upload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        //login FIREBASEUI
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            //user already signed in
            Log.d("AUTH",auth.getCurrentUser().getEmail());
            name.setText(auth.getCurrentUser().getDisplayName());
            if (!img_strr.equals(BuildConfig.FLAVOR)) {
                byte[] imageAsBytes = Base64.decode(img_strr.getBytes(), 0);
                profile_pic.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));}
             else
                 Picasso.with(getApplicationContext()).load(auth.getCurrentUser().getPhotoUrl()).resize(200, 200).error(R.drawable.profile).into(profile_pic);
            email.setText(auth.getCurrentUser().getEmail());
        } else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(
                            Arrays.asList(
                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                            ))
                    .setIsSmartLockEnabled(false,true)
                    .setTheme(R.style.LoginTheme)
                    .build(), RC_SIGN_IN);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.feedback:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","vikashlashmi@gmail.com", null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                break;
            case R.id.rate:
                Toast.makeText(getApplicationContext(), "Thanks For your Support", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=nightlife.kumar.vikash.nightlife")));
                break;
            case R.id.share:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "NightLife");
                    String sAux = "\nIf you enjoy using the app \n" +
                            "Please take a moment to share the app\n" +
                            "Thank you for your support\n";
                    //link to be given
                    sAux = sAux + "https://play.google.com/store/apps/details?id=nightlife.kumar.vikash.nightlife";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "It's My Pleasure\n"+"\nPlease Choose One"));
                } catch(Exception e) {
                    //e.toString();
                }
                break;
            case R.id.about:
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
                alertDialog.setIcon(R.mipmap.logo);
                alertDialog.setTitle("NightLife");
                alertDialog.setMessage(Html.fromHtml("This app is for entertainment purpose.It include pubs, bars, nightclubs from the early afternoon to the early hours of the morning across all major cities in India. You can mail me at "+"<font color='#673AB7'><b>vikashlashmi@gmail.com</b></font>"));
                alertDialog.setButton(Dialog.BUTTON_POSITIVE,"Back",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                break;
            case R.id.exit:
                Toast.makeText(getApplicationContext(), "The application is closed!!", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.profile:
                final AlertDialog imagedialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
                imagedialog.setTitle("Profile");
                imagedialog.setIcon(R.mipmap.logo);
                LayoutInflater factory= LayoutInflater.from(MainActivity.this);
                final View view=factory.inflate(R.layout.profile_dialog,null);
                ImageView image=(ImageView)view.findViewById(R.id.profile_pic);
                image.setImageDrawable(profile_pic.getDrawable());
                TextView name=(TextView)view.findViewById(R.id.name);
                name.setText(auth.getCurrentUser().getDisplayName());
                TextView email=(TextView)view.findViewById(R.id.email);
                email.setText(auth.getCurrentUser().getEmail());
                imagedialog.setView(view);
                imagedialog.setButton(Dialog.BUTTON_POSITIVE,"Back",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        imagedialog.dismiss();
                    }
                });
                imagedialog.setButton(Dialog.BUTTON_NEGATIVE,"Logout",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivityForResult(AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(
                                        Arrays.asList(
                                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                                new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build(),
                                                new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                                        ))
                                .setIsSmartLockEnabled(false,true)
                                .setTheme(R.style.LoginTheme)
                                .build(), RC_SIGN_IN);
                    }
                });
                imagedialog.show();
                break;
            case R.id.logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.d("AUTH","USER LOGGED OUT!");
                                //go to login screen
                                startActivityForResult(AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setAvailableProviders(
                                                Arrays.asList(
                                                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                                                ))
                                        .setIsSmartLockEnabled(false,true)
                                        .setTheme(R.style.LoginTheme)
                                        .build(), RC_SIGN_IN);
                                //   finish();
                            }
                        });
                Toast.makeText(getApplicationContext(), "You Are Successfully Logged Out", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_FILE)
        {

            if (resultCode == RESULT_OK) {
                onSelectFromGalleryResult(data);
            }
        }
        if (requestCode == REQUEST_CAMERA)
        {
                if (resultCode == RESULT_OK) {
                    onCaptureImageResult(data);
                }
        }
        if (requestCode == RC_SIGN_IN) {
                if (resultCode == RESULT_OK) {
                    //user logged in
                    Log.d("AUTH", auth.getCurrentUser().getEmail());
                    Picasso.with(getApplicationContext()).load(auth.getCurrentUser().getPhotoUrl()).resize(200, 200).error(R.drawable.profile).into(profile_pic);
                    name.setText(auth.getCurrentUser().getDisplayName());
                    email.setText(auth.getCurrentUser().getEmail());
                    Toast.makeText(getApplicationContext(), "Welcome " + auth.getCurrentUser().getDisplayName(), Toast.LENGTH_LONG).show();
                } else {
                    //user not authenticated
                    Log.d("AUTH", "NOT AUTHENTICATED");
                    //  Toast.makeText(getApplicationContext(),"Sorry Your Twitter is not responding!! Try Google", Toast.LENGTH_LONG).show();
                }
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_feeback:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","vikashlashmi@gmail.com", null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                break;
            case R.id.nav_share:
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "NightLife");
                    String sAux = "\nIf you enjoy using the app \n" +
                            "Please take a moment to share the app\n" +
                            "Thank you for your support\n";
                    //link to be given
                    sAux = sAux + "https://play.google.com/store/apps/details?id=nightlife.kumar.vikash.nightlife";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "It's My Pleasure\n"+"\nPlease Choose One"));
                } catch(Exception e) {
                    //e.toString();
                }
                break;
            case R.id.nav_exit:
                Toast.makeText(getApplicationContext(), "The application is closed!!", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.nav_logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.d("AUTH","USER LOGGED OUT!");
                                //go to login screen
                                startActivityForResult(AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setAvailableProviders(
                                                Arrays.asList(
                                                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build(),
                                                        new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                                                ))
                                        .setIsSmartLockEnabled(false,true)
                                        .setTheme(R.style.LoginTheme)
                                        .build(), RC_SIGN_IN);
                                //   finish();
                            }
                        });
                Toast.makeText(getApplicationContext(), "You Are Successfully Logged Out", Toast.LENGTH_LONG).show();
                break;

        }
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setIcon(R.mipmap.logo);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(MainActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }
    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.PNG, 90, stream);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".png");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(stream.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        profile_pic.setImageBitmap(thumbnail);
        String img_str = Base64.encodeToString(stream.toByteArray(), 0);
        String base = img_str;
        SharedPreferences.Editor editor = this.getSharedPreferences("myprefs", 0).edit();
        editor.putString("userphoto", img_str);
        editor.commit();
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profile_pic.setImageBitmap(bm);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 90, stream);
        String img_str = Base64.encodeToString(stream.toByteArray(), 0);
        String base = img_str;
        SharedPreferences.Editor editor = this.getSharedPreferences("myprefs", 0).edit();
        editor.putString("userphoto", img_str);
        editor.commit();


    }

}
