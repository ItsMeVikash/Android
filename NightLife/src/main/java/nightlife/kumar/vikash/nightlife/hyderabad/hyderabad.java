package nightlife.kumar.vikash.nightlife.hyderabad;
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

public class hyderabad extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyderabad);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("HYDERABAD");
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
        parent p1=new parent("Klub Trinity");p1.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p2=new parent("10 Downing Street");p2.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p3=new parent("Playboy Club");p3.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p4=new parent("Block 22 Club");p4.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p5=new parent("Fat Pigeon - Bar Hop");p5.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p6=new parent("Over The Moon");p6.parents.add("Chic open air lounge and bar serving gourmet international food on the Daspalla Hotel's 8th level.");
        parent p7=new parent("Air Cube");p7.parents.add("Wide city views are on offer from the slickly styled seats at this luxury rooftop lounge bar.");
        parent p8=new parent("Komatose");p8.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p9=new parent("Pier 33");p9.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p10=new parent("Altitude Lounge Bar Hyderabad Marriott Hotel & Convention Centre");p10.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p11=new parent("Spoil");p11.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p12=new parent("The Sky Lounge");p12.parents.add("Sophisticated lounge on level 11 of an upscale hotel hosting regular weekend party events.");
        parent p13=new parent("Houz of Blues");p13.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p14=new parent("Aqua");p14.parents.add("Open-air poolside lounge overlooking the lake at an upscale hotel known for barbecues and brunches.");
        parent p15=new parent("Rendezvous");p15.parents.add("Club-style destination with an international menu, sports facilities, a pool and a full bar.");
        parent p16=new parent("Skyhy Terrace & Lounge");p16.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p17=new parent("Air Live, Jubilee Hills, Hyderabad");p17.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p18=new parent("MOCHA BAR");p18.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p19=new parent("Drunkyard");p19.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p20=new parent("Cuba Libre");p20.parents.add("Lively venue for rum-based cocktails, a massive dance floor, Caribbean cuisine and cigars.");
        parent p21=new parent("Slounge");p21.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p22=new parent("Zyng");p22.parents.add("Cocktails, mocktails and international beers and spirits are available at this refined hotel lounge.");
        parent p23=new parent("Tease");p23.parents.add("Atmospheric cocktail bar at an upscale hotel serving Indian, continental, Asian and wok dishes.");
        parent p24=new parent("Tipsy Stories");p24.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p25=new parent("Purple Hazee");p25.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p26=new parent("Sounds & Spirits");p26.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p27=new parent("PlayBoy Beer Garden");p27.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p28=new parent("Glocal Junction");p28.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p29=new parent("MOB - Belgium Beer House");p29.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p30=new parent("Beats Per Minute");p30.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p31=new parent("SHARAAB");p31.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p32=new parent("Splash");p32.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p33=new parent("The Vue Lounge");p33.parents.add("Continental, Chinese and Indian dishes and good coffee are on the menu at this rooftop lounge/cafe.");
        parent p34=new parent("The Central Court Hotel");p34.parents.add("Laid-back, modern accommodation with free breakfast, plus 2 restaurants, a bar & a lounge.");
        parent p35=new parent("Trishul Bar and Restaurant");p35.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p36=new parent("Unwind - Lounge Bar");p36.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p37=new parent("The Pirate Brew");p37.parents.add("Pirate themed restaurant and nightclub with a ship design interior.");
        parent p38=new parent("The Moonshine Project");p38.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p39=new parent("Madhushala Bar & Restaurant");p39.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p40=new parent("Bar One");p40.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p41=new parent("Bar Exchange");p41.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p42=new parent("Le Vantage CafeBar");p42.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p43=new parent("Harry's Pub");p43.parents.add("Large screen TVs and a menu of international snack dishes give this hotel venue a pubby vibe.");
        parent p44=new parent("Club8");p44.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p45=new parent("Vertigo The High Life");p45.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p46=new parent("Turning 21");p46.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p47=new parent("Amnesia - Lounge Bar");p47.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p48=new parent("Carbon");p48.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p49=new parent("MRP The Dive Bar");p49.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p50=new parent("Amaravathi Bar and Restaurant");p50.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p51=new parent("Cloud 9");p51.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p52=new parent("La La Land- Shuddh Desi Bar");p52.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p53=new parent("Hashtag");p53.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p54=new parent("Mix Bar");p54.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p55=new parent("Plaza Premium Lounge");p55.parents.add("Casual,Cosy,Groups,Beer,Wine");
        parent p56=new parent("Best Western Ashoka");p56.parents.add("Contemporary hotel with free WiFi, parking & breakfast, plus a bar, a coffee shop & a restaurant.");
        parent p57=new parent("Eagle Bar & Restaurant");p57.parents.add("Straightforward international dining and a bar pouring global beers and cocktails in a basic hotel.");
        parent p58=new parent("Bars N Bowls");p58.parents.add("Indian, Chinese and continental restaurant with a modern interior, roof garden and function room.");
        parent p59=new parent("Juice Lounge, Himayatnagar");p59.parents.add("Chain for global cuisine prepared using balanced ingredients and sold along with fresh juices.");

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