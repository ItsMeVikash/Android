package nightlife.kumar.vikash.nightlife.chandigarh;
import android.support.v7.widget.SearchView;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import nightlife.kumar.vikash.nightlife.R;
import nightlife.kumar.vikash.nightlife.parent;

public class chandigarh extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chandigarh);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("CHANDIGARH");
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
            parent p1 =new parent("Score Chandigarh");p1.parents.add("Lively nightclub, bar and party venue with a dance floor, plus combo platters for hungry revellers.");
            parent p2 =new parent("Paara");p2.parents.add("Contemporary bar, lounge and club with a varied Indian and global menu and a line-up of live DJs.");
            parent p3 =new parent("Orchid Lounge");p3.parents.add("Offerings beer and wine");
            parent p4 =new parent("S Lounge");p4.parents.add("Offerings beer and wine");
            parent p5 =new parent("Kitty Su Chandigarh");p5.parents.add("Flashy, contemporary nightclub with a VIP section and pop art decor at a high-end hotel.");
            parent p6 =new parent("Purple Frog");p6.parents.add("Offerings beer and wine");
            parent p7 =new parent("Underdoggs Sports Bar & Grill");p7.parents.add("Lively bar for watching sports and international food with polished wood floors and American decor.");
            parent p8 =new parent("Vintage terrace Lounge Bar");p8.parents.add("Offerings beer and wine");
            parent p9 =new parent("BUZZ");p9.parents.add("Retro-futuristic lounge bar with live DJ sets and a menu ranging from Indian to international faves.");
            parent p10=new parent("Hops n Grains The Microbrewery");p10.parents.add("Offerings beer and wine");
            parent p11=new parent("Tao- Chandigarh");p11.parents.add("Stylish retro designed Asian restaurant serving Zen-inspired dishes.");
            parent p12=new parent("City Cabana");p12.parents.add("Leafy garden-style hotel rooftop restaurant serving Indian, Chinese and Continental cuisine.");
            parent p13=new parent("The Back Room");p13.parents.add("Offerings beer and wine");
            parent p14=new parent("The Brew Estate - Chandigarh's Largest MicroBrewery");p14.parents.add("Offerings beer and wine");
            parent p15=new parent("Buzzczar");p15.parents.add("Business hotel's comfortable, all-day restaurant and lounge bar serving global bazaar-style food.");
            parent p16=new parent("NABOBS");p16.parents.add("Offerings beer and wine");
            parent p17=new parent("THE BEER CAFE");p17.parents.add("Offerings beer and wine");
            parent p18=new parent("Wild West Pub and Bar");p18.parents.add("Offerings beer and wine");
            parent p19=new parent("Peddlers");p19.parents.add("Offerings beer and wine");
            parent p20=new parent("Tandoori Nites");p20.parents.add("Offerings beer and wine");
            parent p21=new parent("Whistling Duck");p21.parents.add("This stylish contemporary restaurant with a chic patio serves a varied selection of global cuisines.");
            parent p22=new parent("Pyramid Lounge & Club");p22.parents.add("Offerings beer and wine");
            parent p23=new parent("Ministry Of Bar Exchange");p23.parents.add("Offerings beer and wine");
            parent p24=new parent("Playground Bar & Cafe");p24.parents.add("Offerings beer and wine");
            parent p25=new parent("Mermaid Pub and Restaurant");p25.parents.add("Offerings beer and wine");
            parent p26=new parent("Blue Nite Beer Bar & Restaurant");p26.parents.add("Offerings beer and wine");
            parent p27=new parent("KINGDOM OF BEER - MICROBREWERY & WINE CAFE");p27.parents.add("Offerings beer and wine");
            parent p28=new parent("Pashtun Restaurant");p28.parents.add("Rustically decorated dining room with ethnic art and painted walls serving classic Pashtun dishes.");
            parent p29=new parent("SMAAASH Chandigarh");p29.parents.add("Offerings beer and wine");
            parent p30=new parent("Ice Cube");p30.parents.add("Offerings beer and wine");
            parent p31=new parent("Space");p31.parents.add("Glitzy nightclub and lounge bar within a hotel offering live DJs and a compact international menu.");
            parent p32=new parent("Stage");p32.parents.add("Offerings beer and wine");
            parent p33=new parent("Satva");p33.parents.add("Offerings beer and wine");
            parent p34=new parent("VoiZe Lounge Bar");p34.parents.add("Offerings beer and wine");
            parent p35=new parent("MIAMI (Club & Lounge)");p35.parents.add("Offerings beer and wine");
            parent p36=new parent("lava bar");p36.parents.add("Lava Bar is a multi-level bar and lounge at Taj Hotel in Chandigarh's famous Sector 17. The decor is tasteful and done up in a retro style. Lava lights and chic furnishings lend an old world charm to the place.");
            parent p37=new parent("crystal lounge bar");p37.parents.add("As the name suggests, everything is glittery here. From orbs to wallpaper, the place has never let its sheen (read charm) fade. Built in a style to give one a Caribbean feel, the place resonates with the thumping beats in the evenings.");

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