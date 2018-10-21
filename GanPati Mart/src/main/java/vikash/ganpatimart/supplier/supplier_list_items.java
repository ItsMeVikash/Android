package vikash.ganpatimart.supplier;
import uk.co.senab.photoview.PhotoViewAttacher;
import vikash.ganpatimart.Product;
import vikash.ganpatimart.R;
import vikash.ganpatimart.customer.List_Items;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class supplier_list_items extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,SearchView.OnQueryTextListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private DatabaseReference mDatabaseRef;
    private List<Product> imgList;
    private ListView lv;
    private CustomAdapter adapter;
    LinearLayout coordinatorLayout;
    private ProgressDialog progressDialog;
    String e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_list_items);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("Ganpati Mart");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        //showing snackbar
        LinearLayout coordinatorLayout = (LinearLayout) findViewById(R.id.coordinatorLayout);
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
        adapter = new CustomAdapter(this, R.layout.supplier_custom_row, imgList);
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
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                imgList.get(position);
                //list items details
                String title= imgList.get(position).getSerial_No();
            }
        });*/
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
        getMenuInflater().inflate(R.menu.supplier_menu_main, menu);
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
                    CustomAdapter adapter1= new CustomAdapter(supplier_list_items.this, R.layout.supplier_custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }
                else
                {
                    CustomAdapter adapter1= new CustomAdapter(supplier_list_items.this, R.layout.supplier_custom_row, newlist);
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
                    CustomAdapter adapter1= new CustomAdapter(supplier_list_items.this, R.layout.supplier_custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }
                else
                {
                    CustomAdapter adapter1= new CustomAdapter(supplier_list_items.this, R.layout.supplier_custom_row, newlist);
                    lv.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }

            }

        }
        return true;
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
        if (item.getItemId()==R.id.edit)
        {
            Intent i=new Intent(this,Edit_Records.class);
            startActivity(i);
        }
        if (item.getItemId()==R.id.view)
        {
            Intent i=new Intent(this,View_Orders.class);
            startActivity(i);
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

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View v = inflater.inflate(resource, null);
            ImageView image  = (ImageView)v.findViewById(R.id.image);
            TextView serialno  = (TextView)v.findViewById(R.id.serialno);
            TextView itemname  = (TextView)v.findViewById(R.id.itemname);
            TextView MRP  = (TextView)v.findViewById(R.id.MRP);
            TextView Marketrate  = (TextView)v.findViewById(R.id.Marketrate);
            TextView Discount  = (TextView)v.findViewById(R.id.Discount);

            serialno.setText("S.No.\t"+listImage.get(position).getSerial_No());
            itemname.setText(listImage.get(position).getItem_Name());
            MRP.setText("MRP\t"+listImage.get(position).getMRP());
            Marketrate.setText("Market Price\t"+listImage.get(position).getMarket_Rate());
            Discount.setText("Discount\t"+listImage.get(position).getDiscount());
            Glide.with(context).load(listImage.get(position).getImage()).into(image);
            final String url=listImage.get(position).getImage();
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(supplier_list_items.this);
                    LayoutInflater inflater = supplier_list_items.this.getLayoutInflater();
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