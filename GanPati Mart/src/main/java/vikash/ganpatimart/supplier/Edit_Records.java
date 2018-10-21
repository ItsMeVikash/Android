package vikash.ganpatimart.supplier;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vikash.ganpatimart.R;

public class Edit_Records extends AppCompatActivity {

    Button search,update,delete;
    EditText serial;
    TextView details;
    DatabaseReference ref;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__records);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("Update/Delete Records");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        search=(Button)findViewById(R.id.search);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.Delete);
        serial=(EditText)findViewById(R.id.serial_no);
        details=(TextView)findViewById(R.id.details);
        ref = FirebaseDatabase.getInstance().getReference("Products");
        progressDialog = new ProgressDialog(Edit_Records.this);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               ref.orderByChild("Serial_No").equalTo(serial.getText().toString().trim()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                           // userSnapshot.child("Serial_No").getRef().setValue(serial_no.getText().toString().trim());
                            details.setText("Serial No.-\t\t"+userSnapshot.child("Serial_No").getValue().toString()
                                            +"\nItem-\t\t"+userSnapshot.child("Item_Name").getValue().toString()
                                            +"\nMRP-\t\t"+userSnapshot.child("MRP").getValue().toString()
                                            +"\nMarket_Rate-\t\t"+userSnapshot.child("Market_Rate").getValue().toString()
                                            +"\nDiscount-\t\t"+userSnapshot.child("Discount").getValue().toString());
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(Edit_Records.this, "item not found", Toast.LENGTH_SHORT).show();
                        throw databaseError.toException();
                    }
                });
               details.setText("");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showing confirmation dialog box
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Edit_Records.this);
                alertDialogBuilder.setMessage("Are You Sure Delete?");
                alertDialogBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        ref.orderByChild("Serial_No").equalTo(serial.getText().toString().trim()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                                    userSnapshot.getRef().removeValue();
                                    Toast.makeText(Edit_Records.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();

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
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Edit_Records.this);
                LayoutInflater inflater = Edit_Records.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.supplier_update_data, null);
                dialogBuilder.setView(dialogView);
                final EditText serial_no=(EditText)dialogView.findViewById(R.id.serial_no);
                final EditText item_name=(EditText)dialogView.findViewById(R.id.item_name);
                final EditText mrp=(EditText)dialogView.findViewById(R.id.mrp);
                final EditText market_rate=(EditText)dialogView.findViewById(R.id.market_rate);
                final EditText descount=(EditText)dialogView.findViewById(R.id.descount);
                final AlertDialog b = dialogBuilder.create();
                Button cancel=(Button)dialogView.findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        b.dismiss();
                    }
                });
                Button Update=(Button)dialogView.findViewById(R.id.Update);
                Update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        b.dismiss();
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Products");
                        ref.orderByChild("Serial_No").equalTo(serial_no.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                                    userSnapshot.child("Item_Name").getRef().setValue(item_name.getText().toString().trim());
                                    userSnapshot.child("Serial_No").getRef().setValue(serial_no.getText().toString().trim());
                                    userSnapshot.child("MRP").getRef().setValue(mrp.getText().toString().trim());
                                    userSnapshot.child("Market_Rate").getRef().setValue(market_rate.getText().toString().trim());
                                    userSnapshot.child("Discount").getRef().setValue(descount.getText().toString().trim());
                                    Toast.makeText(Edit_Records.this, "updated Successfully", Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Toast.makeText(Edit_Records.this, "updation Failed", Toast.LENGTH_SHORT).show();
                                throw databaseError.toException();

                            }
                        });

                    }
                });
                b.show();
            }
        });
        /*final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(supplier_list_items.this);
        LayoutInflater inflater = supplier_list_items.this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.supplier_delete_data, null);
        dialogBuilder.setView(dialogView);
        final EditText serial_no=(EditText)dialogView.findViewById(R.id.serial_no);
        final EditText item_name=(EditText)dialogView.findViewById(R.id.item_name);
        final EditText mrp=(EditText)dialogView.findViewById(R.id.mrp);
        final EditText market_rate=(EditText)dialogView.findViewById(R.id.market_rate);
        final EditText descount=(EditText)dialogView.findViewById(R.id.descount);
        final AlertDialog b = dialogBuilder.create();
        Button Update=(Button)dialogView.findViewById(R.id.Update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.dismiss();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Products");
                ref.orderByChild("Serial_No").equalTo(serial_no.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                            System.out.println(userSnapshot.getKey());
                            System.out.println(userSnapshot.child("Serial_No").getValue(String.class));
                            Toast.makeText(supplier_list_items.this,userSnapshot.child("Item_Name").getValue(String.class) , Toast.LENGTH_SHORT).show();
                            userSnapshot.child("Item_Name").getRef().setValue(item_name.getText().toString().trim());
                            userSnapshot.child("Serial_No").getRef().setValue(serial_no.getText().toString().trim());
                            userSnapshot.child("MRP").getRef().setValue(mrp.getText().toString().trim());
                            userSnapshot.child("Market_Rate").getRef().setValue(market_rate.getText().toString().trim());
                            userSnapshot.child("Discount").getRef().setValue(descount.getText().toString().trim());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        throw databaseError.toException();
                    }
                });

            }
        });
        b.show();*/


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
