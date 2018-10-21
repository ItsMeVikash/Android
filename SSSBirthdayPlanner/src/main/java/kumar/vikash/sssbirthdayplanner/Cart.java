package kumar.vikash.sssbirthdayplanner;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    private List<Product> imgList;
    private ListView listView;
    TextView total;
    Button checkout;
    int t=0;
    //ordering message
    String order_details="",plan="",mode_of_payment="",order_detail="";
    //selecting plan changing price
    int total_price=0;
    private CustomAdapter adapter;
//payment
    String payeeAddress = "8789009420@paytm";
    String payeeName = "Vikash Kumar";
    String transactionNote = "SSS Birthday Planner";
    String amount = "1";
    String currencyUnit = "INR";

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

        total=(TextView)findViewById(R.id.total);
        imgList = new ArrayList<>();
        listView = (ListView)findViewById(R.id.listview);
        adapter = new CustomAdapter(Cart.this, R.layout.custom_row_cart, imgList);
        listView.setAdapter(adapter);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Cart").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Product img = snapshot.getValue(Product.class);
                    adapter.addElement(img);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        checkout=(Button)findViewById(R.id.checkout);
        //empty listview
        View empty = findViewById(R.id.empty_list_view);
        listView.setEmptyView(empty);
       if (listView.getAdapter().getCount()==0)
        {
            checkout.setVisibility(View.GONE);
        }
        else
       {
           checkout.setVisibility(View.VISIBLE);
       }

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Cart.this);
                    LayoutInflater inflater = Cart.this.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.custom_dialog_box_plan, null);
                    dialogBuilder.setView(dialogView);
                    final Button proceed = (Button) dialogView.findViewById(R.id.proceed);
                    final RadioGroup radioGroup_plan=(RadioGroup)dialogView.findViewById(R.id.radioGroup_plan);
                    plan="NO OFFER";
                     radioGroup_plan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                            RadioButton rb = (RadioButton) radioGroup.findViewById(checkedId);
                            int id = radioGroup_plan.getCheckedRadioButtonId();
                             total_price=Integer.parseInt(total.getText().toString().replaceAll("[^0-9]", ""));
                            switch (id) {
                                case R.id.mini:
                                    plan="MINI";
                                   total_price+=85;
                                    proceed.setText("PAY "+"\u20B9 "+String.valueOf(total_price));
                                    break;
                                case R.id.small:
                                    plan="SMALL";
                                    total_price+=175;
                                    proceed.setText("PAY "+"\u20B9 "+String.valueOf(total_price));
                                    break;
                                case R.id.large:
                                    plan="LARGE";
                                    total_price+=425;
                                    proceed.setText("PAY "+"\u20B9 "+String.valueOf(total_price));
                                    break;
                                case R.id.bumper:
                                    plan="BUMPER";
                                    total_price+=860;
                                    proceed.setText("PAY "+"\u20B9 "+String.valueOf(total_price));
                                    break;
                                case R.id.no_offer:
                                    plan="NO OFFER";
                                    total_price+=0;
                                    proceed.setText("PAY "+"\u20B9 "+total.getText().toString().replaceAll("[^0-9]", ""));
                                    break;
                                default:
                                    proceed.setText("PAY "+"\u20B9 "+total.getText().toString().replaceAll("[^0-9]", ""));
                                    break;
                            }

                        }
                    });
                //getting order details for sending message
                order_detail="";
                order_details="";
                for (int i = 0; i < listView.getChildCount(); i++) {
                    View vieww = listView.getChildAt(i);
                    String s=((TextView) vieww.findViewById(R.id.name)).getText().toString();
                    String s1=((TextView) vieww.findViewById(R.id.price)).getText().toString();
                    String s2=((Spinner) vieww.findViewById(R.id.quantity)).getSelectedItem().toString();
                    order_detail=order_detail+s+"\u0009\u0009"+s1+"\u0009\u0009"+s2+"<br>";
                }
                final AlertDialog b = dialogBuilder.create();
                    proceed.setText("PAY "+"\u20B9 "+total.getText().toString().replaceAll("[^0-9]", ""));
                    proceed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b.dismiss();
                            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Cart.this);
                            LayoutInflater inflater = Cart.this.getLayoutInflater();
                            final View dialogView = inflater.inflate(R.layout.custom_dialog_box_payemnt, null);
                            dialogBuilder.setView(dialogView);
                            final Button place_order = (Button) dialogView.findViewById(R.id.place_order);
                            final AlertDialog bb = dialogBuilder.create();
                            final RadioGroup radioGroup_payment=(RadioGroup)dialogView.findViewById(R.id.radioGroup_payment);
                            mode_of_payment="COD";
                            radioGroup_payment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup radioGroup1, int i) {
                                    RadioButton rb1 = (RadioButton) radioGroup1.findViewById(i);
                                    int id1 = radioGroup_payment.getCheckedRadioButtonId();
                                    switch (id1) {
                                        case R.id.cod:
                                            mode_of_payment="COD";
                                            place_order.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    order_details="-----SSS Birthday Planner----<br><br>"+"....Your Invoice....<br>"+"ItemName\u0009\u0009Price\u0009\u0009Quantity<br>"+order_detail+"<br><br>Plan Selected : "+plan+" <br>"+"Payment Mode : "+mode_of_payment+" <br>"+"<br><br>Thanks For Ordering<br>Contact us : 8789009420";
                                                    order_details=""+Html.fromHtml(order_details);
                                                    Toast.makeText(Cart.this, "Your Order Placed Successfully, Please Send us order through Whatsapp", Toast.LENGTH_LONG).show();
                                                    String text = order_details;// Replace with your message.
                                                    String toNumber = "+919431201780"; // Replace with mobile phone number without +Sign or leading zeros.
                                                    Intent intent = new Intent(Intent.ACTION_VIEW);
                                                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                                                    startActivity(intent);
                                                    //deleting orders from firebase i.e cart empty
                                                    mDatabaseRef = FirebaseDatabase.getInstance().getReference("Cart").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                                    mDatabaseRef.addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                            dataSnapshot.getRef().removeValue();
                                                        }
                                                        @Override
                                                        public void onCancelled(DatabaseError databaseError) {
                                                        }
                                                    });
                                                    bb.dismiss();
                                                }
                                            });
                                            break;

                                        case R.id.pay_with_upi:
                                            mode_of_payment="PAID";
                                            place_order.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    order_details="-----SSS Birthday Planner----<br><br>"+"....Your Invoice....<br>"+"ItemName     Price     Quantity<br>"+order_detail+"<br><br>Plan Selected : "+plan+" <br>"+"Payment Mode : "+mode_of_payment+" <br>"+"<br><br>Thanks For Ordering<br>Contact us : 8789009420";
                                                    order_details=""+Html.fromHtml(order_details);
                                                    //payment
                                                    amount = proceed.getText().toString().replaceAll("[^0-9]", "");
                                                    Uri uri = Uri.parse("upi://pay?pa=" + payeeAddress + "&pn=" + payeeName + "&tn=" + transactionNote +
                                                            "&am=" + amount + "&cu=" + currencyUnit);
                                                    //Log.d(TAG, "onClick: uri: "+uri);
                                                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                    startActivityForResult(intent, 1);
                                                   }
                                            });
                                            break;
                                        default:
                                            Toast.makeText(Cart.this, "select mode first", Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                             bb.show();
                        }
                    });
                    b.show();

            }
            });

    }
    //custom adapter
    private class CustomAdapter extends ArrayAdapter<Product> {
        private Activity context;
        private int resource;
        private List<Product> listImage;
        public CustomAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Product> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            listImage = objects;
        }
        @Override
        public int getCount() {
            return listImage.size();
        }

        @Override
        public Product getItem(int location) {
            return listImage.get(location);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource, null);
            final ImageView image  = (ImageView)v.findViewById(R.id.image);
            final ImageView delete  = (ImageView)v.findViewById(R.id.delete);
            final TextView name = (TextView)v.findViewById(R.id.name);
            final TextView price = (TextView)v.findViewById(R.id.price);
            name.setText(listImage.get(position).getName());
            price.setText(listImage.get(position).getPrice());
            Picasso.with(context).load(listImage.get(position).getImage()).into(image);
            String[] items = new String[]{"1", "2", "3","4","5","6","7","8","9","10"};
            final Spinner quantity=(Spinner)v.findViewById(R.id.quantity);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(Cart.this, android.R.layout.simple_spinner_dropdown_item, items);
            quantity.setAdapter(adapter);
            quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int pos, long id) {
                    // your code here
                    price.setText("");
                    int tt=Integer.parseInt(listImage.get(position).getPrice().replaceAll("[^0-9]", ""))
                                *Integer.parseInt(parentView.getItemAtPosition(pos).toString());
                   price.setText("\u20B9 "+String.valueOf(tt));
                   //totalling
                    int itemsCount = listView.getChildCount();
                    t=0;
                    for (int i = 0; i < itemsCount; i++) {
                        View view = listView.getChildAt(i);
                        String total_amount = ((TextView) view.findViewById(R.id.price)).getText().toString();
                        t+=Integer.parseInt(total_amount.replaceAll("[^0-9]", ""));
                        total.setText("Total To Pay "+"\t"+"\u20B9 "+String.valueOf(t));
                    }
                    if (listView.getAdapter().getCount()==0)
                    {
                        checkout.setVisibility(View.GONE);
                    }
                    else
                    {
                        checkout.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code
                    if (listView.getAdapter().getCount()==0)
                    {
                        checkout.setVisibility(View.GONE);
                    }
                    else
                    {
                        checkout.setVisibility(View.VISIBLE);
                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Cart");
                    Query applesQuery = ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).orderByChild("Name").equalTo(name.getText().toString());
                    applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                appleSnapshot.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                    Intent intent = getIntent();
                    //Reload the page after deletion
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    startActivity(intent);
                    listImage.remove(position);
                    notifyDataSetChanged();
                    if (listView.getAdapter().getCount()==0)
                    {
                        checkout.setVisibility(View.GONE);
                    }
                    else
                    {
                        checkout.setVisibility(View.VISIBLE);
                    }
                }
            });
            return v;
        }

        public void addElement(Product element) {

            listImage.add(element);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(data!=null) {
           // Log.d(TAG, "onActivityResult: data: " + data.getStringExtra("response"));
            String res = data.getStringExtra("response");
            String search = "SUCCESS";
            if (res.toLowerCase().contains(search.toLowerCase())) {
                Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
                Toast.makeText(Cart.this, "Your Order Placed Successfully, Please Send us order through Whatsapp", Toast.LENGTH_LONG).show();
                String text = order_details;// Replace with your message.
                String toNumber = "+919431201780"; // Replace with mobile phone number without +Sign or leading zeros.
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                startActivity(intent);
                //deleting orders from firebase i.e cart empty
                mDatabaseRef = FirebaseDatabase.getInstance().getReference("Cart").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().removeValue();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
                finish();

            } else {
                Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
