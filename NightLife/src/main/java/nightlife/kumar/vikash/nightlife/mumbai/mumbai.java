package nightlife.kumar.vikash.nightlife.mumbai;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mumbai extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("MUMBAI");
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
        parent p1=new parent("Trilogy NightClub");p1.parents.add("Sprawling 2-floor nightclub with dazzling crystal lighting and Arabian Sea views serving Asian food.");
        parent p2=new parent("Drop");p2.parents.add("Chandelier-lit nightspot with speakeasy-style bars, a champagne lounge and dance floor, plus DJs.");
        parent p3=new parent("XXO");p3.parents.add("Lavishly decorated hotel venue with a fully-stocked bar offering modern and classic cocktails.");
        parent p4=new parent("LIV");p4.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p5=new parent("Tryst");p5.parents.add("Modern, neon-lit nightspot with private tables and a long bar offering bar bites and cocktails.");
        parent p6=new parent("Baroke");p6.parents.add("Glitzy, mock Italian nightclub/lounge bar in a business hotel.");
        parent p7=new parent("Playboy Club");p7.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p8=new parent("Club Sirkus");p8.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p9=new parent("Club Alibii");p9.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p10=new parent("Novotel-Premier Lounge");p10.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p11=new parent("Colaba Social");p11.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p12=new parent("Bombay Cocktail Bar");p12.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p13=new parent("Opa! Bar & Cafe");p13.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p14=new parent("Hoppipola");p14.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p15=new parent("WE VIP Premium Nightclub And Restro Bar");p15.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p16=new parent("The Bar Stock Exchange");p16.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p17=new parent("Escobar");p17.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p18=new parent("Geoffrey's");p18.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p19=new parent("Cavalry");p19.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p20=new parent("Rock Bottom");p20.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p21=new parent("Kitty Su");p21.parents.add("Industrial chic nightspot with contemporary lighting, a full bar and a calendar of DJ parties.");
        parent p22=new parent("China House Lounge");p22.parents.add("Multi-level hotel lounge & bar serving pre-dinner drinks & late night cocktails & a varied menu.");
        parent p23=new parent("AER");p23.parents.add("Luxe open-air rooftop bar at the Four Seasons hotel with cocktails, champagne and tapas, plus DJs.");
        parent p24=new parent("Shiro");p24.parents.add("Large, high-ceilinged bohemian restaurant serving Asian dishes with a bar, private dining and club.");
        parent p25=new parent("The Bar Stock Exchange");p25.parents.add("Drinks pricing reflects demand at this contemporary bar with a comfort food selection.");
        parent p26=new parent("Hawaiian Shack");p26.parents.add("Bi-level joint with DJs, a boat-shaped bar and bamboo accents offering cocktails and global fare.");
        parent p27=new parent("Wink");p27.parents.add("An updated Indian aesthetic gives this chic hotel's bar a refined, modern atmosphere.");
        parent p28=new parent("The Irish House");p28.parents.add("Influenced by the classical Irish pub, this themed venue serves bar snacks and international faves.");
        parent p29=new parent("The Drawing Room");p29.parents.add("Upscale hotel's lavishly decorated contemporary bar with an afternoon tea service and live piano.");
        parent p30=new parent("Social");p30.parents.add("Dishes from all over appear on the menu of this laid-back venue within a collaborative work space.");
        parent p31=new parent("Tote On The Turf");p31.parents.add("A trendy bar and elegant Indian dining room contained within a landmark building on a race course.");
        parent p32=new parent("Ark");p32.parents.add("Luxury airport hotel's atmospheric bar furnished in dark colours offering snacks and music.");
        parent p33=new parent("The Elbo Room");p33.parents.add("Global comfort food dishes and a full bar served in a stylish bar with a garden and big screen TV.");
        parent p34=new parent("Eau Bar");p34.parents.add("Upscale hotel bar with views over the ocean and a large art installation with over 500 glass tubes.");
        parent p35=new parent("Cafe Zoe");p35.parents.add("European fare and creative cocktails served in spacious industrial surrounds with live jazz music.");
        parent p36=new parent("The Little Door");p36.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p37=new parent("The Bombay Bronx");p37.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p38=new parent("Tonic");p38.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p39=new parent("Raasta Bombay");p39.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p40=new parent("Razzberry Rhinoceros");p40.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p41=new parent("Pharaoh Pub & Lounge");p41.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p42=new parent("Bar Stock Exchange");p42.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p43=new parent("Thyme");p43.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p44=new parent("The Angrezi Pub");p44.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p45=new parent("Baraesti");p45.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p46=new parent("145 Bandra");p46.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p47=new parent("Rude");p47.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p48=new parent("Quarter House");p48.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p49=new parent("Rude Lounge - Powai");p49.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p50=new parent("True Tramm Trunk");p50.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p51=new parent("Doolally Taproom - Bandra");p51.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p52=new parent("House Of Mirabella");p52.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p53=new parent("Casa Vito");p53.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p54=new parent("Copa");p54.parents.add("Creative cocktails and finger foods served in a cool space with dramatic decor and patio seating.");
        parent p55=new parent("Gadda Da Vida");p55.parents.add("Cushioned rattan chairs are positioned for Arabian Sea views at this serene al fresco hotel lounge.");
        parent p56=new parent("Atrium Lounge");p56.parents.add("Ornately decorated lounge with sea views at a high-end hotel serving light meals & cocktails.");
        parent p57=new parent("Monkey Bar");p57.parents.add("International light meals and cocktails are served at this relaxed gastro pub chain outlet.");
        parent p58=new parent("Coral Lounge");p58.parents.add("Bar serving wines, cocktails, shots and more at an Indian and Chinese restaurant.");
        parent p59=new parent("The Lobby Lounge");p59.parents.add("Grand lounge in a luxury hotel overlooking the gardens adorned with statues and tapestries.");
        parent p60=new parent("A Bar");p60.parents.add("An extensive cocktail and Scotch list is served at this lowlit hotel bar with an upscale vibe.");
        parent p61=new parent("THE LOCAL");p61.parents.add("Lively music and DJ venue with a full bar hosting regular karaoke sessions and pub-style food.");
        parent p62=new parent("Krishna Palace Hotel");p62.parents.add("Modern lodging offering refined rooms & suites, plus 2 restaurants, a flashy nightclub & a gym.");
        parent p63=new parent("PDT Mumbai");p63.parents.add("Urban 1920s-style speakeasy pub and restaurant serving international cuisine and cocktails.");
        parent p64=new parent("InterContinental Hotels & Resorts");p64.parents.add("Panoramic views of the city are offered from this upscale hotel cocktail bar with north Indian food.");
        parent p65=new parent("Glocal Junction Andheri");p65.parents.add("Chic design-conscious venue serving global breakfast, lunch and dinner menus in a fashionable space.");
        parent p66=new parent("Ghetto Pub");p66.parents.add("Dark, unfussy bar known for its rock-inspired atmosphere of neon lights, graffiti & pool tables.");
        parent p67=new parent("Zenzibu Da Sky Lounge");p67.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p68=new parent("Pauva Deck");p68.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p69=new parent("Sangeet Bar and Restaurant");p69.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p70=new parent("Fusion Grill");p70.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p71=new parent("270 Degrees West");p71.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p72=new parent("Vikings");p72.parents.add("Modern restaurant serving veg and non-veg world cuisine and a spacious bar for music and cocktails.");
        parent p73=new parent("Aqua");p73.parents.add("Luxury hotel's poolside al fresco dining space offering Mediterranean and barbecued food.");

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
        allParent.add(p70);
        allParent.add(p71);
        allParent.add(p72);
        allParent.add(p73);

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