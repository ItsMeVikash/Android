package vikash.ganpatimart.supplier;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

import vikash.ganpatimart.R;
import vikash.ganpatimart.customer.cart;

public class Purchase_Details extends AppCompatActivity {
    String name;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase__details);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("Items Purchased by\t\t"+name);
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        listView=(ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, R.layout.cart_result_for_listview, list);
        //Set adapter for listview
        listView.setAdapter(adapter);
        //Show progress dialog during list image loading
        DatabaseReference dreference = FirebaseDatabase.getInstance().getReference().child("ORDERS");
        dreference.orderByChild("Name").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                    // userSnapshot.child("Serial_No").getRef().setValue(serial_no.getText().toString().trim());
                    list.add(userSnapshot.child("Product_Purchased").getValue().toString()+"\n"+userSnapshot.child("Total_Amount").getValue().toString());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //showing confirmation dialog box
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Purchase_Details.this);
                alertDialogBuilder.setMessage("Sure To Delete Order?");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        DatabaseReference dreference = FirebaseDatabase.getInstance().getReference().child("ORDERS");
                        dreference.orderByChild("Name").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                                    // userSnapshot.child("Serial_No").getRef().setValue(serial_no.getText().toString().trim());
                                    userSnapshot.getRef().removeValue();
                                    list.clear();
                                    Toast.makeText(Purchase_Details.this, "Deleted Successfully", Toast.LENGTH_LONG).show();
                                    adapter.notifyDataSetChanged();
                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                throw databaseError.toException();
                            }
                        });

                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        adapter.notifyDataSetChanged();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
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
