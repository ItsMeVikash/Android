package vikash.ganpatimart.customer;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import vikash.ganpatimart.R;
import vikash.ganpatimart.supplier.MainActivity;

public class cart extends AppCompatActivity {
    static ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    String serial,mrp,item,disc,quantity,total;
    Button remove,order,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("Your Cart");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Intent intent = getIntent();
        serial = intent.getStringExtra("S.No");
        item = intent.getStringExtra("Item");
        mrp =  intent.getStringExtra("Market_Rate");
        disc = intent.getStringExtra("Discount");
        quantity =  intent.getStringExtra("Quantity");
        total = intent.getStringExtra("Total");

        remove=(Button)findViewById(R.id.remove);
        order=(Button)findViewById(R.id.order);
        back=(Button)findViewById(R.id.back);
        order.setVisibility(View.GONE);
        listView = (ListView) findViewById(R.id.listview);
        adapter=new ArrayAdapter<String>(this,R.layout.cart_result_for_listview,list);
        if(serial!=null)
        {
            list.add("S.No\t\t"+serial+"\nItem\t\t"+item+"\nRate\t\t"+mrp+"\nQty.\t\t"+quantity+"\nAmt.\t\t"+total);
            adapter.notifyDataSetChanged();
        }
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int i, long l) {
                //showing confirmation dialog box
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(cart.this);
                alertDialogBuilder.setMessage("Remove This Item ?");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        adapter.remove(adapter.getItem(i));
                        adapter.notifyDataSetChanged();
                        if (list.size()==0)
                        {
                            order.setVisibility(View.GONE);
                            remove.setVisibility(View.GONE);
                        }
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
        if (list.size()==0)
        {
            order.setVisibility(View.GONE);
            remove.setVisibility(View.GONE);
        }
        else
        {
            order.setVisibility(View.VISIBLE);
            remove.setVisibility(View.VISIBLE);
        }
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showing confirmation dialog box
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(cart.this);
                alertDialogBuilder.setMessage("Sure To Empty Cart?");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        list.clear();
                        adapter.notifyDataSetChanged();
                        order.setVisibility(View.GONE);
                        remove.setVisibility(View.GONE);
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
        order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(cart.this);
                    LayoutInflater inflater = cart.this.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.final_order, null);
                    dialogBuilder.setView(dialogView);
                    final EditText name = (EditText) dialogView.findViewById(R.id.name);
                    final EditText address = (EditText) dialogView.findViewById(R.id.address);
                    final TextView details = (TextView) dialogView.findViewById(R.id.details);
                    final TextView total_amount = (TextView) dialogView.findViewById(R.id.total_amount);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < adapter.getCount(); i++) {
                        sb.append(adapter.getItem(i)+"\n\n");
                    }
                    details.setText(sb.toString());
                    Double val=0.0;
                    for (int i = 0; i < adapter.getCount(); i++) {
                        val+=Double.parseDouble(adapter.getItem(i).substring(adapter.getItem(i).indexOf("Amt.") + 4,adapter.getItem(i).length()));
                    }
                    total_amount.setText("Total Amount-\t\t"+val.toString());
                    final AlertDialog b = dialogBuilder.create();
                    Button cancel = (Button) dialogView.findViewById(R.id.cancel);
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b.dismiss();
                        }
                    });
                    Button orderr = (Button) dialogView.findViewById(R.id.order);
                    final ProgressDialog progressDialog = new ProgressDialog(cart.this);
                    orderr.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(!TextUtils.isEmpty(name.getText().toString())&&!TextUtils.isEmpty(address.getText().toString())) {
                                progressDialog.setMessage("Please Wait...");
                                progressDialog.show();
                                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ORDERS").push();
                                databaseReference.child("Name").setValue(name.getText().toString().trim());
                                databaseReference.child("Address").setValue(address.getText().toString().trim());
                                databaseReference.child("Product_Purchased").setValue(details.getText().toString().trim());
                                databaseReference.child("Date").setValue(date.trim());
                                databaseReference.child("Total_Amount").setValue(total_amount.getText().toString().trim());
                                Toast.makeText(cart.this, "Your order placed Successfully", Toast.LENGTH_LONG).show();
                                b.dismiss();
                                list.clear();
                                if (list.size() == 0) progressDialog.dismiss();
                                adapter.notifyDataSetChanged();
                                order.setVisibility(View.GONE);
                                remove.setVisibility(View.GONE);
                                SmsManager smsManager = SmsManager.getDefault();
                                String phoneNumber = "++919931158729";
                                String smsBody = name.getText().toString()+"\n"
                                        +address.getText().toString()+"\n"
                                        +details.getText().toString()+"\n"
                                        +total_amount.getText().toString()+"\n";
                                String SMS_SENT = "SMS_SENT";
                                String SMS_DELIVERED = "SMS_DELIVERED";
                                PendingIntent sentPendingIntent = PendingIntent.getBroadcast(cart.this, 0, new Intent(SMS_SENT), 0);
                                PendingIntent deliveredPendingIntent = PendingIntent.getBroadcast(cart.this, 0, new Intent(SMS_DELIVERED), 0);
                                ArrayList<String> smsBodyParts = smsManager.divideMessage(smsBody);
                                ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
                                ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();

                                for (int i = 0; i < smsBodyParts.size(); i++) {
                                    sentPendingIntents.add(sentPendingIntent);
                                    deliveredPendingIntents.add(deliveredPendingIntent);
                                }
                                smsManager.sendMultipartTextMessage(phoneNumber, null, smsBodyParts, sentPendingIntents, deliveredPendingIntents);


                            }
                            else
                            {
                                //showing confirmation dialog box
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(cart.this);
                                alertDialogBuilder.setMessage("Please Enter Your Details First");
                                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                    }
                                });
                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                            }

                        }
                    });
                    b.show();
                }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
