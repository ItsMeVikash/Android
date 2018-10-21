package nightlife.kumar.vikash.nightlife.chennai;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import nightlife.kumar.vikash.nightlife.chennai.adapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import nightlife.kumar.vikash.nightlife.R;
import nightlife.kumar.vikash.nightlife.parent;

public class chennai extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chennai);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("CHENNAI");
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
        parent p1=new parent("Gatsby 2000");p1.parents.add("Contemporary, neon-night nightspot offering drinks, DJ music & a vibrant dance floor.");
        parent p2=new parent("Pasha");p2.parents.add("Persian-style nightspot in the The Park Chennai Hotel featuring creative cocktails & a dance floor.");
        parent p3=new parent("Flying Bottles");p3.parents.add("Casual, Cosy, Beer, Wine");
        parent p4=new parent("10 Downing Street");p4.parents.add("Chain of British pubs offering Western fare & cocktails, plus DJs & a wide range of theme nights");
        parent p5=new parent("Cheroot Malt And Cigar Lounge - Restaurants In Chennai");p5.parents.add("Grand lounge bar known for its world cigars and whiskeys at a high-end, palatial hotel.");
        parent p6=new parent("Big Bang Theory - Bar & Kitchen");p6.parents.add("Lively gastro pub and restaurant offering burgers and pints plus live music and DJs.");
        parent p7=new parent("Urban Lounge");p7.parents.add("Casual, Cosy, Beer, Wine");
        parent p8=new parent("365 A.S");p8.parents.add("Luxury hotel's light and airy lounge bar with al fresco seating, city views and happy hours.");
        parent p9=new parent("The B Bar");p9.parents.add("Casual, Cosy, Beer, Wine");
        parent p10=new parent("Illusions - The Madras Pub");p10.parents.add("Casual, Cosy, Beer, Wine");
        parent p11=new parent("Blend");p11.parents.add("Swanky, neon-line wine bar in the Taj Club House featuring live music & dancing.");
        parent p12=new parent("Elixir Lounge Bar");p12.parents.add("Stylish bar in a boutique business hotel serving cocktails, nibbles and international fare.");
        parent p13=new parent("Diff 42 Resto Lounge");p13.parents.add("Beer, cocktails & creative global eats in a relaxed space with dim lights & TVs tuned into sports.");
        parent p14=new parent("Leather Bar");p14.parents.add("Martinis and finger food served in a sophisticated, urban space with a terrace at The Park hotel.");
        parent p15=new parent("Unlock Bar");p15.parents.add("Casual, Cosy, Beer, Wine");
        parent p16=new parent("Hoppipola");p16.parents.add("Casual, Cosy, Beer, Wine");
        parent p17=new parent("The Flying Elephant");p17.parents.add("This multi-level hotel restaurant features opulent design and a menu taking dishes from all over.");
        parent p18=new parent("Aura - The Lounge Bar");p18.parents.add("Art deco design lounge bar serving beverages and bar snacks located in a business hotel.");
        parent p19=new parent("Grand By GRT Hotels");p19.parents.add("Modern quarters in a contemporary hotel with dining options & a bar, plus 2 pools & a spa.");
        parent p20=new parent("Paddington Sports Pub");p20.parents.add("Brick-walled space for a international menu of pub classics, large-screen sport and a full bar.");
        parent p21=new parent("Distil");p21.parents.add("An elegant cocktail bar shaking up signature martinis and mocktails at a luxury hotel.");
        parent p22=new parent("Shastri Nagar Sharks");p22.parents.add("Casual, Cosy, Beer, Wine");
        parent p23=new parent("The Regency Club Lounge");p23.parents.add("Casual, Cosy");
        parent p24=new parent("Plan B");p24.parents.add("Branch of urban style bar/diner serving hearty international grills and light bar food.");
        parent p25=new parent("Sera");p25.parents.add("Buzzy tapas place offering Spanish & Asian small plates, cocktails & frequent live bands or DJs.");
        parent p26=new parent("Zodiac - The Accord Metropolitan");p26.parents.add("Clubby hotel lounge open until midnight for a range of drinks, cold canapes and dancing.");
        parent p27=new parent("Swirl");p27.parents.add("Casual, Cosy, Beer, Wine");
        parent p28=new parent("US 101 - Be A Sport");p28.parents.add("International dishes and cocktails are on offer at this bustling venue for watching live sport.");
        parent p29=new parent("The Vault Bar Stock Exchange");p29.parents.add("Casual, Cosy, Beer, Wine");
        parent p30=new parent("TITOAS RESTO BAR");p30.parents.add("Casual, Cosy, Beer, Wine");
        parent p31=new parent("Based On A True Story");p31.parents.add("Casual, Cosy, Beer, Wine");
        parent p32=new parent("Bamboo Bar");p32.parents.add("Relaxed lounge/bar in a business hotel decked out with rattan chairs and bamboo plants.");
        parent p33=new parent("Radio Room");p33.parents.add("A bar made of whitewashed radios gives a cool edge to this stylish bar serving international food.");
        parent p34=new parent("Chill & Grill");p34.parents.add("Casual, Cosy, Beer, Wine");
        parent p35=new parent("Salt lick by Gallop");p35.parents.add("Global hotel dining with gourmet sea salts and an international menu cooked on volcanic lava stones.");
        parent p36=new parent("Phoenix Bar & Restaurant");p36.parents.add("Casual, Cosy, Beer, Wine");
        parent p37=new parent("SUDAKA - South American Restobar");p37.parents.add("Casual, Cosy, Beer, Wine");
        parent p38=new parent("The Moon And Sixpence");p38.parents.add("Lively pub with cosy, UK-inspired decor offering beer, whisky, hearty eats & regular live bands.");
        parent p39=new parent("Durrant's Bar");p39.parents.add("Named after the Madras Presidency's first wine merchant, this hotel bar has a refined vibe.");
        parent p40=new parent("Ink 303");p40.parents.add("Casual, Cosy, Beer, Wine");
        parent p41=new parent("Turf pub- Eldoris Hotel");p41.parents.add("Casual, Cosy, Beer, Wine");
        parent p42=new parent("Associted Brothers Club");p42.parents.add("Casual, Cosy, Beer, Wine");
        parent p43=new parent("B Side");p43.parents.add("Casual, Cosy, Beer, Wine");
        parent p44=new parent("Library Blu - The Leela Palace");p44.parents.add("Casual, Cosy, Beer, Wine");
        parent p45=new parent("Glass hopper");p45.parents.add("Casual, Cosy, Beer, Wine");
        parent p46=new parent("Tranz Bar");p46.parents.add("Casual, Cosy, Beer, Wine");
        parent p47=new parent("Lava Bar & Lounge");p47.parents.add("Casual, Cosy, Beer, Wine");
        parent p48=new parent("submarine bar");p48.parents.add("Casual, Cosy, Beer, Wine");
        parent p49=new parent("Spice Bar");p49.parents.add("Casual, Cosy, Beer, Wine");
        parent p50=new parent("Tranquebar");p50.parents.add("Casual, Cosy, Beer, Wine");
        parent p51=new parent("Arcot Bar");p51.parents.add("Functional, upmarket lodging with an international restaurant, a contemporary bar & a formal cafe.");
        parent p52=new parent("The Velveteen Rabbit");p52.parents.add("Casual, Cosy, Beer, Wine");
        parent p53=new parent("The Cycle Gap");p53.parents.add("Casual, Cosy, Beer, Wine");
        parent p54=new parent("Chap Chay");p54.parents.add("Modern hotel's chic Asian dining room offering Thai and Chinese options and a DIY wok station.");
        parent p55=new parent("Watson's Chennai");p55.parents.add("Casual, Cosy, Beer, Wine");
        parent p56=new parent("Secret Society Bar");p56.parents.add("Casual, Cosy, Beer, Wine");
        parent p57=new parent("Mississippi Bar");p57.parents.add("Casual, Cosy, Beer, Wine");
        parent p58=new parent("Xzubarance");p58.parents.add("Pub fare, cocktails and wine offered in warm surroundings with a small bar at the Raj Park Hotel.");
        parent p59=new parent("The Irish House");p59.parents.add("Casual, Cosy, Beer, Wine");
        parent p60=new parent("Microbrewery - Prodebbrewery Brewery Belgium");p60.parents.add("Casual, Cosy, Beer, Wine");
        parent p61=new parent("Hot Pot China");p61.parents.add("Casual, Cosy, Beer, Wine");
        parent p62=new parent("Black Pearl");p62.parents.add("Casual, Cosy, Beer, Wine");
        parent p63=new parent("Chikku Bukku Restaurant");p63.parents.add("Casual, Cosy, Beer, Wine");
        parent p64=new parent("Elite Tasmac");p64.parents.add("Casual, Cosy, Beer, Wine");
        parent p65=new parent("Bronx Sea View Resto Bar");p65.parents.add("Casual, Cosy, Beer, Wine");
        parent p66=new parent("Black & White, The Residency Hotel");p66.parents.add("Casual, Cosy, Beer, Wine");
        parent p67=new parent("KINGS BAR");p67.parents.add("Casual, Cosy, Beer, Wine");
        parent p68=new parent("Above Sea Level Restaurant");p68.parents.add("Sophisticated rooftop space looking over the city serving as an upmarket Indian hotel restaurant.");
        parent p69=new parent("Anchor Bar");p69.parents.add("Special house cocktails and classics served in an open hotel bar with a tropical vibe.");


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
        allParent.add(p62);
        allParent.add(p63);
        allParent.add(p64);
        allParent.add(p65);
        allParent.add(p66);
        allParent.add(p67);
        allParent.add(p68);
        allParent.add(p69);


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