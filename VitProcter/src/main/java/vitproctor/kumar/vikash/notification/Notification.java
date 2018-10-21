package vitproctor.kumar.vikash.notification;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.SearchView;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import vitproctor.kumar.vikash.MainActivity;
import vitproctor.kumar.vikash.R;

public class Notification extends AppCompatActivity implements android.support.v7.widget.SearchView.OnQueryTextListener{
    DatabaseReference dref;
    ListView listview;
    ArrayAdapter<String> adapter;
    ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("Notifications");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        listview=(ListView)findViewById(R.id.listview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);
        dref= FirebaseDatabase.getInstance().getReference().child("Notification");
        dref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String msg = (String) dataSnapshot.child("MESSAGE").getValue();
                if(!list.contains(msg)) {
                    list.add(msg);
                }else {
                    dataSnapshot.getRef().removeValue();
                }
                adapter.notifyDataSetChanged();

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String msg = (String) dataSnapshot.child("MESSAGE").getValue();
                if(!list.contains(msg))
                {
                    list.add(msg);
                }else {
                    dataSnapshot.getRef().removeValue();
                }
                adapter.notifyDataSetChanged();
               // Collections.reverse(list);

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //remove older values
        long cutoff = new Date().getTime() - TimeUnit.MILLISECONDS.convert(2, TimeUnit.DAYS);
        Query oldItems = dref.orderByChild("timestamp").endAt(cutoff);
        oldItems.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot itemSnapshot: snapshot.getChildren()) {
                    itemSnapshot.getRef().removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_item_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setBackgroundColor(Color.parseColor("#ffffff"));
        searchView.setQueryHint("Search");
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextChange(String query)
    {
        // this is your adapter that will be filtered
        Notification.this.adapter.getFilter().filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        Notification.this.adapter.getFilter().filter(query);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);

    }
}
