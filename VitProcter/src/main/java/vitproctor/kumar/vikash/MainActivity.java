package vitproctor.kumar.vikash;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import vitproctor.kumar.vikash.notification.Notification;

public class MainActivity extends AppCompatActivity {

    DatabaseReference dreference,dreference1;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    String teacher_name;
    LinearLayout coordinatorLayout;
    //faculty details
    String id,mobile,remarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebar);
        toolbar.setTitle("Vit Proctor");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //showing snackbar
        coordinatorLayout = (LinearLayout) findViewById(R.id.coordinatorLayout);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Welcome to Vit Bhopal", Snackbar.LENGTH_LONG);
        snackbar.getView().setMinimumHeight(100);
        // Changing  text and background  color
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
        dreference = FirebaseDatabase.getInstance().getReference().child("Faculty_Name");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                map2list((Map) dataSnapshot.getValue());
                //formats the datasnapshot entries to strings
                adapter.notifyDataSetChanged();
                //makes the ListView realtime
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println(databaseError.toException());
                // ...
            }
        };
        dreference.addValueEventListener(listener);
        adapter=new ArrayAdapter<String>(this,R.layout.faculty_name,list);
        GridView gridView = (GridView) findViewById(R.id.facultyname);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Student_list.class);
                String teacher = adapter.getItem(position);
                i.putExtra("Teacher", teacher);
                startActivity(i);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting faculty details from database
                dreference1 = FirebaseDatabase.getInstance().getReference();
                final Query query =  dreference1.child("Faculty_Details").child(adapter.getItem(i));
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        id=dataSnapshot.child("ID").getValue().toString();
                        remarks=dataSnapshot.child("REMARKS").getValue().toString();
                        mobile=dataSnapshot.child("MOBILE").getValue().toString();
                        query.keepSynced(true);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        System.out.println(databaseError.toException());
                        // ...
                    }
                });
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.faculty_details, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setTitle(adapter.getItem(i));
                TextView facid=(TextView)dialogView.findViewById(R.id.faculty_id);
                facid.setText(id);
                TextView facmobile=(TextView)dialogView.findViewById(R.id.faculty_mobile);
                facmobile.setText(mobile);
                TextView facremarks=(TextView)dialogView.findViewById(R.id.faculty_remarks);
                facremarks.setText(remarks);
                final AlertDialog b = dialogBuilder.create();
                Button ok=(Button)dialogView.findViewById(R.id.ok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        b.dismiss();
                    }
                });
                b.show();
                return true;
            }
        });

    }

    public void map2list(Map<String,Long> map){

        list.clear();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            teacher_name= entry.getKey().toString();
            list.add(teacher_name);
            Collections.sort(list);
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
        switch (item.getItemId()) {
            case R.id.feedback:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","vitpgprocter@gmail.com", null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                break;
            case R.id.rate:
                Toast.makeText(getApplicationContext(), "Thanks For your Support", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=vitproctor.kumar.vikash")));
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
                    sAux = sAux + "https://play.google.com/store/apps/details?id=vitproctor.kumar.vikash";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "It's Our Pleasure\n"+"\nPlease Choose One"));
                } catch(Exception e) {
                    //e.toString();
                }
                break;
            case R.id.exit:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);
                break;
            case R.id.notification:
                Intent i = new Intent(MainActivity.this, Notification.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Want To Close App?",1)
                .setDuration(3000)
                .setAction("\n\nYes", new View.OnClickListener() {
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
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.button_default));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.logo, 0, 0, 0);
        textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.parseColor("#3F51B5"));
        snackbar.show();
    }


}