package kumar.vikash.sssbirthdayplanner.flavours;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kumar.vikash.sssbirthdayplanner.Cake_Details;
import kumar.vikash.sssbirthdayplanner.Product;
import kumar.vikash.sssbirthdayplanner.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Others extends Fragment {
    private DatabaseReference mDatabaseRef;
    private List<Product> imgList;
    private GridView gv;
    private CustomAdapter adapter;

    public Others() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cake_list, container, false);
        imgList = new ArrayList<>();
        gv = (GridView)view.findViewById(R.id.grid_view);
        adapter = new CustomAdapter(getActivity(), R.layout.custom_row, imgList);
        gv.setAdapter(adapter);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Cakes").child("Others");
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
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent i = new Intent(getActivity(), Cake_Details.class);
                final TextView name = (TextView)v.findViewById(R.id.name);
                final TextView imageurl = (TextView)v.findViewById(R.id.imageurl);
                final TextView price = (TextView)v.findViewById(R.id.price);
                final TextView description = (TextView)v.findViewById(R.id.description);
                i.putExtra("name", name.getText().toString());
                i.putExtra("imageurl", imageurl.getText().toString());
                i.putExtra("price", price.getText().toString());
                i.putExtra("description", description.getText().toString());
                startActivity(i);
            }
        });

        return view;
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
            final TextView name = (TextView)v.findViewById(R.id.name);
            final TextView price = (TextView)v.findViewById(R.id.price);
            final TextView description = (TextView)v.findViewById(R.id.description);
            final TextView imageurl = (TextView)v.findViewById(R.id.imageurl);
            name.setText(listImage.get(position).getName());
            price.setText("\u20B9 "+listImage.get(position).getPrice());
            imageurl.setText(listImage.get(position).getImage());
            description.setText(listImage.get(position).getDescription());
            Picasso.with(context).load(listImage.get(position).getImage()).into(image);

            return v;
        }

        public void addElement(Product element) {

            listImage.add(element);
        }

    }
}
