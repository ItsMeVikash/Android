package vikash.ganpatimart.customer;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;
import vikash.ganpatimart.Product;
import vikash.ganpatimart.R;

public class List_Items extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,SearchView.OnQueryTextListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private DatabaseReference mDatabaseRef;
    private List<Product> imgList;
    private ListView lv;
    private CustomAdapter adapter;
    LinearLayout coordinatorLayout;
    private ProgressDialog progressDialog;
    //preparing for cart
    String s,i,m,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__items);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        toolbar.setTitle("Ganpati Mart");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        //showing snackbar
        coordinatorLayout = (LinearLayout) findViewById(R.id.coordinatorLayout);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Ganpati Electricals Welcomes You !!", Snackbar.LENGTH_LONG);
        snackbar.getView().setMinimumHeight(100);
        // Changing  text and background  color
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
        imgList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listview);
        //Init adapter
        adapter = new CustomAdapter(List_Items.this, R.layout.custom_row, imgList);
        //Set adapter for listview
        lv.setAdapter(adapter);
        //Show progress dialog during list image loading
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...Kindly Be On Network");
        progressDialog.show();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Products");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Product img = snapshot.getValue(Product.class);
                    adapter.addElement(img);
                    adapter.notifyDataSetChanged();
                } progressDialog.dismiss();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(this);
    }
    /**
     * This method is called when swipe refresh is pulled down
     */
    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        adapter.clear();
        //Show progress dialog during list image loading
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Products");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Product img = snapshot.getValue(Product.class);
                    adapter.addElement(img);
                    adapter.notifyDataSetChanged();
                } progressDialog.dismiss();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                swipeRefreshLayout.setRefreshing(true);
            }
        });swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_customer, menu);
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_item_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setBackgroundColor(Color.parseColor("#ffffff"));
        searchView.setQueryHint("Search Products");
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        return true;
    }
    @Override
    public boolean onQueryTextChange(String query)
    {
        // this is your adapter that will be filtered
        query=query.toLowerCase();
        if (query.isEmpty())
        {
            lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else {
            ArrayList<Product> newlist=new ArrayList<Product>();
            for (Product p: imgList)
            {
                if (p.getItem_Name().toLowerCase().contains(query)||p.getSerial_No().toLowerCase().contains(query))
                {
                    newlist.add(p);
                    CustomAdapter adapter1= new CustomAdapter(List_Items.this, R.layout.custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }
                else
                {
                    CustomAdapter adapter1= new CustomAdapter(List_Items.this, R.layout.custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }

            }

        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // this is your adapter that will be filtered
        query=query.toLowerCase();
        if (query.isEmpty())
        {
            lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else {
            ArrayList<Product> newlist=new ArrayList<Product>();
            for (Product p: imgList)
            {
                if (p.getItem_Name().toLowerCase().contains(query)||p.getSerial_No().toLowerCase().contains(query))
                {
                    newlist.add(p);
                    CustomAdapter adapter1= new CustomAdapter(List_Items.this, R.layout.custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }
                else
                {
                    CustomAdapter adapter1= new CustomAdapter(List_Items.this, R.layout.custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }

            }

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //showing confirmation dialog box
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(List_Items.this);
        alertDialogBuilder.setMessage("Are You Sure to Close The App?");
        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.cart)
        {
            Intent i=new Intent(this,cart.class);
            startActivity(i);
        }
        if (item.getItemId()==R.id.about_us)
        {
            //showing confirmation dialog box
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(List_Items.this);
            alertDialogBuilder.setIcon(R.mipmap.ic_launcher_round);
            alertDialogBuilder.setTitle("About Us");
            alertDialogBuilder.setMessage("Welcome to Ganpati Electricals your electrical E-store.\n" +
                    "\n" +
                    "If we look around we are surrounded by many things which illuminate our life with happiness electrical products are one of them we BUYELECTRIC with the vision to bring ease in electrical shopping of a common man we have added wide range of electrical products in our basket. Our aim is to bridge the gap between Market and Consumer with Best quality product right prices affordable services at your door step.");
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if (item.getItemId()==R.id.how_to_use)
        {
            //showing confirmation dialog box
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(List_Items.this);
            alertDialogBuilder.setIcon(R.mipmap.ic_launcher_round);
            alertDialogBuilder.setTitle("How To Use");
            alertDialogBuilder.setMessage("Welcome to Ganpati Electricals your electrical E-store.\n" +
                    "\n" +
                    "1.\tSearch Items"
                    +"\n2.\tTap On Add To Cart Icon." +
                    "\n3.\tEnter The Quantity." +
                    "\n4.\tClick On Add To Cart Button." +
                    "\n5.\tEnter Your Details." +
                    "\n6.\tYour Order Is Placed." +
                    "\n\n THANKS FOR SHOPPING WITH US.");
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
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
            final TextView serialno = (TextView)v.findViewById(R.id.serialno);
            final TextView itemname  = (TextView)v.findViewById(R.id.itemname);
            final TextView MRP  = (TextView)v.findViewById(R.id.MRP);
            TextView Marketrate  = (TextView)v.findViewById(R.id.Marketrate);
            final TextView Discount  = (TextView)v.findViewById(R.id.Discount);
            serialno.setText("S.No.\t"+listImage.get(position).getSerial_No());
            itemname.setText(listImage.get(position).getItem_Name());
            MRP.setText("MRP\t"+listImage.get(position).getMRP());
            Marketrate.setText("Market Price\t"+listImage.get(position).getMarket_Rate());
            Discount.setText("Discount\t"+listImage.get(position).getDiscount());
            final ImageButton cart=(ImageButton)v.findViewById(R.id.cart);
            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(List_Items.this);
                    LayoutInflater inflater = List_Items.this.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.cart_preparation, null);
                    dialogBuilder.setView(dialogView);
                    final TextView serial=(TextView)dialogView.findViewById(R.id.serial);
                    final TextView item=(TextView)dialogView.findViewById(R.id.item);
                    final TextView market=(TextView)dialogView.findViewById(R.id.mrpp);
                    final TextView discountt=(TextView)dialogView.findViewById(R.id.discountt);
                    final EditText quantity=(EditText)dialogView.findViewById(R.id.quantity);
                    final TextView total=(TextView)dialogView.findViewById(R.id.total);
                    serial.setText(listImage.get(position).getSerial_No());
                    item.setText(imgList.get(position).getItem_Name());
                    market.setText(imgList.get(position).getMarket_Rate());
                    discountt.setText(imgList.get(position).getDiscount());
                    final AlertDialog b = dialogBuilder.create();
                    Button back=(Button)dialogView.findViewById(R.id.back);
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b.dismiss();
                        }
                    });
                    final Button add_to_cart=(Button)dialogView.findViewById(R.id.add_to_cart);
                    add_to_cart.setVisibility(View.GONE);
                    Button calculate=(Button)dialogView.findViewById(R.id.calculate);
                    calculate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            add_to_cart.setVisibility(View.VISIBLE);
                            Double val1=Double.parseDouble(market.getText().toString()) - Double.parseDouble(discountt.getText().toString());
                            Double val2=Double.parseDouble(quantity.getText().toString());
                            total.setText(String.valueOf(val1*val2));
                            add_to_cart.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(List_Items.this,cart.class);
                                    i.putExtra("S.No",serial.getText().toString());
                                    i.putExtra("Item",item.getText().toString());
                                    i.putExtra("Market_Rate",market.getText().toString());
                                    i.putExtra("Discount",discountt.getText().toString());
                                    i.putExtra("Quantity",quantity.getText().toString());
                                    i.putExtra("Total",total.getText().toString());
                                    startActivity(i);
                                    b.dismiss();
                                }
                            });
                        }
                    });
                    b.show();
                }
            });
            Glide.with(context).load(listImage.get(position).getImage()).into(image);
            final String url=listImage.get(position).getImage();
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(List_Items.this);
                    LayoutInflater inflater = List_Items.this.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.enlrage_imageview, null);
                    dialogBuilder.setView(dialogView);
                    final AlertDialog b = dialogBuilder.create();
                    b.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    ImageView enlarge=(ImageView)dialogView.findViewById(R.id.enlarge);
                    Picasso.with(getApplicationContext()).load(url).resize(Resources.getSystem().getDisplayMetrics().widthPixels,Resources.getSystem().getDisplayMetrics().heightPixels-100).into(enlarge);
                    PhotoViewAttacher pAttacher;
                    pAttacher = new PhotoViewAttacher(enlarge);
                    pAttacher.update();
                    b.show();
                }
            });

            return v;
        }

        public void addElement(Product element) {

            listImage.add(element);
        }

    }

}