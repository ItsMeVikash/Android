package nightlife.kumar.vikash.nightlife.kolkata;
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

public class kolkata extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolkata);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("KOLKATA");
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
        parent p1=new parent("Someplace Else");p1.parents.add("Wood-paneled hotel bar with a heritage vibe and a regular calendar of live musical acts.");
        parent p2=new parent("Nocturne");p2.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p3=new parent("Club Boudoir");p3.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p4=new parent("Privy Ultra Lounge");p4.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p5=new parent("UG Reincarnated");p5.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p6=new parent("Bakstage");p6.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p7=new parent("Black Lounge Bar");p7.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p8=new parent("Raize The Bar");p8.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p9=new parent("Pour House");p9.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p10=new parent("Shisha Bar Exchange");p10.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p11=new parent("What's In d Name");p11.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p12=new parent("Xrong Place");p12.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p13=new parent("Bluzz");p13.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p14=new parent("Urban Desi");p14.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p15=new parent("Masque Lounge & Bar");p15.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p16=new parent("Oval Lounge");p16.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p17=new parent("Chilis Kolkata");p17.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p18=new parent("Sam's Pub");p18.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p19=new parent("Illusion lounge");p19.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p20=new parent("Go Where");p20.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p21=new parent("Roxy");p21.parents.add("Contemporary hotel bar with a wide cocktail and wine menu and funky, design-conscious decor.");
        parent p22=new parent("The Myx");p22.parents.add("Nightclub featuring futuristic silver dominated decor and hosting regular DJ sessions.");
        parent p23=new parent("Smoke Shack");p23.parents.add("Stylish rooftop lounge bar and restaurant with a dance floor and pool serving international dishes.");
        parent p24=new parent("Afraa");p24.parents.add("Mediterranean, Asian and Indian dishes are served with DJ music at this contemporary restaurant.");
        parent p25=new parent("M Bar And Kitchen");p25.parents.add("Happening bar and restaurant with a global menu and a range of alcoholic and non-alcoholic drinks.");
        parent p26=new parent("10 DOWNING STREET");p26.parents.add("Typical wood and leather decorated English-style pub with a full bar and regular events.");
        parent p27=new parent("Blue Nile");p27.parents.add("Chinese and Indian restaurant with ancient Egypt art and TV screens on the walls.");
        parent p28=new parent("The Irish House");p28.parents.add("Typical Irish and Celtic design in a pub and restaurant serving a varied finger food menu.");
        parent p29=new parent("Badshah Bar & Restaurant");p29.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p30=new parent("Sagar Bar & Restaurant");p30.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p31=new parent("WILSON'S");p31.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p32=new parent("Café Montecarlo");p32.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p33=new parent("Wall Street Bar");p33.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p34=new parent("Ozora");p34.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p35=new parent("Scrapyard");p35.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p36=new parent("Opium Bar And Restaurant");p36.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p37=new parent("Mocambo Restaurant & Bar");p37.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p38=new parent("OlyPub");p38.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p39=new parent("Country Roads Micro Brewery And Restaurant");p39.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p40=new parent("The Drunken Monkey (O2 Hotel)");p40.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p41=new parent("On The Rockz");p41.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p42=new parent("H2O Resto Pub");p42.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p43=new parent("Beer Republic");p43.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p44=new parent("One Sports Lounge");p44.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p45=new parent("Titos");p45.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p46=new parent("Hing");p46.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p47=new parent("Rocks");p47.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p48=new parent("Damurs Bar and Restaurant");p48.parents.add("Minimalist Indian and Chinese restaurant and bar with a function room.");
        parent p49=new parent("Nirvana");p49.parents.add("Relaxed lounge bar at a hotel presided by a giant Buddha statue serving traditional Asian dishes.");
        parent p50=new parent("The Big Ben");p50.parents.add("Traditional-feeling Victorian pub within a hotel and serving English ales and global dishes.");
        parent p51=new parent("Tandoor Park");p51.parents.add("Casual restaurant for an Indian menu utilising a tandoor oven. Home delivery also available.");
        parent p52=new parent("High Street Bar");p52.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p53=new parent("Evergreen Bar & Restaurant");p53.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p54=new parent("Moulin Rouge");p54.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p55=new parent("Addiction Bar & Restaurant");p55.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p56=new parent("Preach");p56.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p57=new parent("A Step Up");p57.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p58=new parent("Bistro Y, Restro Pub");p58.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p59=new parent("The Shack Lounge");p59.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p60=new parent("Swastik Bar");p60.parents.add("Casual, Cosy, group, Beer, Wine");
        parent p61=new parent("Zion Lounge");p61.parents.add("Casual, Cosy, group, Beer, Wine");

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
        allParent.add(p34);
        allParent.add(p35);
        allParent.add(p36);
        allParent.add(p37);
        allParent.add(p38);
        allParent.add(p39);
        allParent.add(p40);
        allParent.add(p41);
        allParent.add(p42);
        allParent.add(p43);
        allParent.add(p44);
        allParent.add(p45);
        allParent.add(p46);
        allParent.add(p47);
        allParent.add(p48);
        allParent.add(p49);
        allParent.add(p50);
        allParent.add(p51);
        allParent.add(p52);
        allParent.add(p53);
        allParent.add(p54);
        allParent.add(p55);
        allParent.add(p56);
        allParent.add(p57);
        allParent.add(p58);
        allParent.add(p59);
        allParent.add(p60);
        allParent.add(p61);


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
