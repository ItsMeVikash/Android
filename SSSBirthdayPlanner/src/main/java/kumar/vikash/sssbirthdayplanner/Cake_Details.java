package kumar.vikash.sssbirthdayplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Cake_Details extends AppCompatActivity {

    TextView name,price,description;
    ImageView image;
    Button add_to_cart,order_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake__details);
    //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("SSS BIRTHDAY PLANNER");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        name=(TextView)findViewById(R.id.name);
        price=(TextView)findViewById(R.id.price);
        description=(TextView)findViewById(R.id.description);
        image=(ImageView) findViewById(R.id.image);
        order_now=(Button) findViewById(R.id.order_now);
        add_to_cart=(Button) findViewById(R.id.add_to_cart);

        name.setText(getIntent().getStringExtra("name"));
        price.setText(getIntent().getStringExtra("price"));
        description.setText(getIntent().getStringExtra("description"));
        Picasso.with(getApplicationContext()).load(getIntent().getStringExtra("imageurl")).into(image);

        order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cake_Details.this, Cart.class);
                DatabaseReference databaseReference;
                 FirebaseAuth auth;
                //inserting cake to database using user id
                auth = FirebaseAuth.getInstance();
                databaseReference = FirebaseDatabase.getInstance().getReference("Cart").child(auth.getUid()).push();
                databaseReference.child("Name").setValue(getIntent().getStringExtra("name"));
                databaseReference.child("Price").setValue(getIntent().getStringExtra("price"));
                databaseReference.child("Image").setValue(getIntent().getStringExtra("imageurl"));
                i.putExtra("name", getIntent().getStringExtra("name"));
                i.putExtra("imageurl",getIntent().getStringExtra("imageurl"));
                i.putExtra("price", getIntent().getStringExtra("price"));
                startActivity(i);
            }
        });
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cake_Details.this, Cart.class);
                DatabaseReference databaseReference;
                FirebaseAuth auth;
                //inserting cake to database using user id
                auth = FirebaseAuth.getInstance();
                databaseReference = FirebaseDatabase.getInstance().getReference("Cart").child(auth.getUid()).push();
                databaseReference.child("Name").setValue(getIntent().getStringExtra("name"));
                databaseReference.child("Price").setValue(getIntent().getStringExtra("price"));
                databaseReference.child("Image").setValue(getIntent().getStringExtra("imageurl"));
                i.putExtra("name", getIntent().getStringExtra("name"));
                i.putExtra("imageurl",getIntent().getStringExtra("imageurl"));
                i.putExtra("price", getIntent().getStringExtra("price"));
                startActivity(i);
            }
        });
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
