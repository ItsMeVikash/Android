package nightlife.kumar.vikash.nightlife.jaipur;
import nightlife.kumar.vikash.nightlife.R;
import nightlife.kumar.vikash.nightlife.parent;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class jaipur extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaipur);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("JAIPUR");
        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        elv=(ExpandableListView)findViewById(R.id.expandableListView1);
        //close other expanded item when other expands
        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    elv.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });
        final ArrayList<parent> parent = getData();
        adapter = new adapter(this, parent);
        elv.setAdapter(adapter);
        //setListener for group or child
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_item_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setBackgroundColor(Color.parseColor("#ffffff"));
        searchView.setQueryHint("Search");
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onQueryTextChange(String query)
    {
        // this is your adapter that will be filtered
        query=query.toLowerCase();
        if (query.isEmpty())
        {
            elv.setAdapter(adapter);
        }
        else {
            ArrayList<parent> newlist=new ArrayList<parent>();
            for (parent p: allParent)
            {
                if (p.getName().toLowerCase().contains(query))
                {
                    newlist.add(p);
                    adapter adapter1= new adapter(this, newlist);
                    elv.setAdapter(adapter1);
                }

            }

        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        query=query.toLowerCase();
        if (query.isEmpty())
        {
            elv.setAdapter(adapter);
        }
        else {
            ArrayList<parent> newlist=new ArrayList<parent>();
            for (parent p: allParent)
            {
                if (p.getName().toLowerCase().contains(query))
                {
                    newlist.add(p);
                    adapter adapter1= new adapter(this, newlist);
                    elv.setAdapter(adapter1);
                }
            }
        }
        return true;
    }

    private ArrayList<parent> getData()
    {
        parent p1=new parent("Blackout");p1.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p2=new parent("Bar Palladio Jaipur");p2.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p3=new parent("100% ROCK");p3.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p4=new parent("F Bar And Lounge");p4.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p5=new parent("Lounge-18");p5.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p6=new parent("House of People");p6.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p7=new parent("Club Naila");p7.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p8=new parent("Scorpian- A Pub City");p8.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p9=new parent("3Ds Restro Lounge");p9.parents.add("3-in-1 venue with an Indian and international restaurant, rooftop tables and a disco/lounge.");
        parent p10=new parent("Duplay");p10.parents.add("Stylish neon-lit nightclub in a hotel with comfortable seating and a large dance floor.");
        parent p11=new parent("District 9 Lounge");p11.parents.add("Asian, European, Mexican and American grub is served at this casual, brick-walled lounge.");
        parent p12=new parent("The Dragon Club (T.D.C.)");p12.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p13=new parent("DND Bar and Lounge");p13.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p14=new parent("Sky Lounge");p14.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p15=new parent("Drop Zone The Bar");p15.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p16=new parent("60ML Disc & Lounge");p16.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p17=new parent("Bottles & Chimney Bar");p17.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p18=new parent("Steam");p18.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p19=new parent("Blue Ice");p19.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p20=new parent("Playa By Zone");p20.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p21=new parent("Jaipour Cafe & Bar");p21.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p22=new parent("Sukh Suvidha");p22.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p23=new parent("Holywood Pub and Lounge");p23.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p24=new parent("Le Gourmet Lounge");p24.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p25=new parent("WTF Sports Cafe & Bar");p25.parents.add("Leading sports events are shown on big screens at this funky bar with a global food and drink menu.");
        parent p26=new parent("Mayaa Lounge");p26.parents.add("Simple dining with private booth seating, a full bar and a varied international menu.");
        parent p27=new parent("Lounge");p27.parents.add("Contemporary hotel venue with a fully stocked bar that is open until midnight.");
        parent p28=new parent("Cloud Seven");p28.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p29=new parent("Beer Bar");p29.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p30=new parent("Kabana Resto Bar");p30.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p31=new parent("Hotel Acacia Inn(Xing Bar)");p31.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p32=new parent("Asteria");p32.parents.add("Casual, Cosy, Group, Beer, Wine");
        parent p33=new parent("Firangi Paani Resto Bar");p33.parents.add("Casual, Cosy, Group, Beer, Wine");

        allParent=new ArrayList<parent>();
        allParent.add(p1);
        allParent.add(p2);
        allParent.add(p3);
        allParent.add(p4);
        allParent.add(p5);
        allParent.add(p6);
        allParent.add(p7);
        allParent.add(p8);
        allParent.add(p9);
        allParent.add(p10);
        allParent.add(p11);
        allParent.add(p12);
        allParent.add(p13);
        allParent.add(p14);
        allParent.add(p15);
        allParent.add(p16);
        allParent.add(p17);
        allParent.add(p18);
        allParent.add(p19);
        allParent.add(p20);
        allParent.add(p21);
        allParent.add(p22);
        allParent.add(p23);
        allParent.add(p24);
        allParent.add(p25);
        allParent.add(p26);
        allParent.add(p27);
        allParent.add(p28);
        allParent.add(p29);
        allParent.add(p30);
        allParent.add(p31);
        allParent.add(p32);
        allParent.add(p33);

        Collections.sort(allParent, new Comparator<parent>(){
            public int compare(parent obj1, parent obj2)
            {
                // TODO Auto-generated method stub
                return obj1.Name.compareToIgnoreCase(obj2.Name);
            }
        });
        return allParent;
    }

}