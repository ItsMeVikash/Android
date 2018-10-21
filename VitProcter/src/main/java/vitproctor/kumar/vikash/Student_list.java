package vitproctor.kumar.vikash;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import vitproctor.kumar.vikash.details.student_details;


public class Student_list extends AppCompatActivity implements SearchView.OnQueryTextListener{
    String teacher_name;
    DatabaseReference dreference;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        //getting teacher name
        teacher_name= getIntent().getStringExtra("Teacher");

        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle(teacher_name);
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        dreference = FirebaseDatabase.getInstance().getReference().child("Faculty_Name").child(teacher_name);
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
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        listView = (ListView) findViewById(R.id.student_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Student_list.this, student_details.class);
                String student = adapter.getItem(position);
                i.putExtra("Teacher", teacher_name);
                i.putExtra("student", student);
                startActivity(i);
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
        searchView.setQueryHint("Search Students");
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextChange(String query)
    {
        // this is your adapter that will be filtered
        Student_list.this.adapter.getFilter().filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        Student_list.this.adapter.getFilter().filter(query);
        return true;
    }
    public void map2list(Map<String,Long> map){

        list.clear();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String stu_name= entry.getKey();
            list.add(stu_name);
            Collections.sort(list);
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}