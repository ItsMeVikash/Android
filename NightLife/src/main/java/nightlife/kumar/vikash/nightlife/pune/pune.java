package nightlife.kumar.vikash.nightlife.pune;
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

public class pune extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pune);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("PUNE");
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
        parent p1=new parent("Penthouze Nightlife");p1.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p2=new parent("Area 51");p2.parents.add("Unique circular and revolving events venue for parties, conferences and weddings.");
        parent p3=new parent("High Spirits Cafe");p3.parents.add("Outdoor party spot with funky design hosting regular guest DJs and serving light Indian meals.");
        parent p4=new parent("Mix@36");p4.parents.add("Sumptuously decorated cocktail bar serving bar snacks with a riverside terrace at a luxury hotel.");
        parent p5=new parent("Hoppipola");p5.parents.add("Hip bar and nightclub drawing an eclectic crowd and offering finger food and music.");
        parent p6=new parent("Sin Envy Pride");p6.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p7=new parent("Swig");p7.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p8=new parent("Apache High Street");p8.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p9=new parent("Paasha Lounge");p9.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p10=new parent("Oak Lounge - Marriott Suites");p10.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p11=new parent("Local Gastro Bar");p11.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p12=new parent("Teddy Boy");p12.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p13=new parent("Lollapalooza");p13.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p14=new parent("Rude Lounge Viman Nagar");p14.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p15=new parent("Chaos");p15.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p16=new parent("Mmyra Lounge");p16.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p17=new parent("Cuba Libre Seasons Mall");p17.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p18=new parent("Culture - Pune");p18.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p19=new parent("Bottlerock");p19.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p20=new parent("Effingut");p20.parents.add("Microbrewery known for its bespoke beers, international pub grub menu and theme nights.");
        parent p21=new parent("Flying Saucer - Skybar");p21.parents.add("Spacious, fashionable 9th floor lounge bar with a terrace, world menu and DJ entertainment.");
        parent p22=new parent("The Irish House");p22.parents.add("Traditional Irish tavern serving draughts beers and pub grub in front of the big TV screen.");
        parent p23=new parent("1 Lounge");p23.parents.add("This fashion conscious bar serves Continental and Indian food in a leafy outdoor space.");
        parent p24=new parent("T.G.I Friday's");p24.parents.add("Casual chain restaurant with a festive vibe serving beer, cocktails & a wide menu of American fare.");
        parent p25=new parent("The Fishbowl");p25.parents.add("Chic hotel lounge with a stylish, contemporary vibe and a menu of freshly prepared cocktails.");
        parent p26=new parent("Hidden Place");p26.parents.add("Cosy sports bar serving Indian and international dishes, cocktails and a range of beers.");
        parent p27=new parent("The Mugshot Lounge");p27.parents.add("Lively bar known for its kebabs, biryanis and karaoke evenings.");
        parent p28=new parent("1000 Oaks");p28.parents.add("Pubby all-day drinking and eating venue with a garden, relaxed interior and northern Indian menu.");
        parent p29=new parent("Replay Sports Bar");p29.parents.add("Relaxed, brick-walled sports bar and diner with TVs serving Indian, Chinese and continental food.");
        parent p30=new parent("Single Malt and Co");p30.parents.add("Luxury hotel's warmly decorated lounge bar known for its whisky collection and water feature views.");
        parent p31=new parent("Merlins");p31.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p32=new parent("Agent Jack's Bar");p32.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p33=new parent("23 East Lounge");p33.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p34=new parent("Elephant & Co. Gastropub");p34.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p35=new parent("HUB- Lounge Cafe Rooftop");p35.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p36=new parent("Hashtag The Lounge");p36.parents.add("Casual, Cosy, Groups, Beer, Wine");
        parent p37=new parent("F Beach House");p37.parents.add("Casual, Cosy, Groups, Beer, Wine");


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