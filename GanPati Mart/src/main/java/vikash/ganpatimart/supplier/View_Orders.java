package vikash.ganpatimart.supplier;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import vikash.ganpatimart.Product;
import vikash.ganpatimart.R;

public class View_Orders extends AppCompatActivity {
    DatabaseReference dreference;
    ArrayList<String> list=new ArrayList<>();
    ArrayList<String> list1=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__orders);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listView=(ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, R.layout.view_order_listview, list);
        //Set adapter for listview
        listView.setAdapter(adapter);
        //Show progress dialog during list image loading
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Orders...");
        progressDialog.show();
        dreference = FirebaseDatabase.getInstance().getReference().child("ORDERS");
        dreference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String msg= (String) dataSnapshot.child("Name").getValue();
                    String msg1 = (String) dataSnapshot.child("Address").getValue();
                    String msg3 = (String) dataSnapshot.child("Date").getValue();
                    String msg4 = (String) dataSnapshot.child("Total_Amount").getValue();
                    list.add("Name-\t\t"+msg+"\nAddress-\t\t"+msg1+"\nDate Of Order-\t\t"+msg3+"\n"+msg4);
                    //dummy arraylist
                    list1.add(msg);
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();

                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    String msg= (String) dataSnapshot.child("Name").getValue();
                    String msg1 = (String) dataSnapshot.child("Address").getValue();
                    String msg3 = (String) dataSnapshot.child("Date").getValue();
                    String msg4 = (String) dataSnapshot.child("Total_Amount").getValue();
                    list.add("Name-\t\t"+msg+"\nAddress-\t\t"+msg1+"\nDate Of Order-\t\t"+msg3+"\n"+msg4);
                    list1.add(msg);
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();

                }
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msga=list1.get(i).toString();
                Intent ii=new Intent(View_Orders.this,Purchase_Details.class);
                ii.putExtra("name",msga);
                startActivity(ii);
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
