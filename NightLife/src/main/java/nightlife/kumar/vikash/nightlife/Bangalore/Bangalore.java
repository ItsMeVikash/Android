package nightlife.kumar.vikash.nightlife.Bangalore;
import nightlife.kumar.vikash.nightlife.parent;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import nightlife.kumar.vikash.nightlife.R;

public class Bangalore extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangalore);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("BANGALORE");
        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
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
                if(groupPosition != previousGroup)
                    elv.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });
        final ArrayList<parent> parent=getData();
        adapter=new adapter(this,parent);
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
            parent p1=new parent("Gilly’s Resto Bar, Bangalore");p1.parents.add("This happening bar serves Continental and Indian food while presenting live music and comedy nights.");
            parent p2=new parent("High Ultra Lounge");p2.parents.add("Slick modern venue with far-reaching views over the city, a full bar and a varied, pan-Asian menu.");
            parent p3=new parent("The Black Rabbit");p3.parents.add("Design-conscious dining room with a funky atmosphere for a range of international dishes.");
            parent p4=new parent("Sanctum");p4.parents.add("Beer,Wine,Casual,Cosy");
            parent p5=new parent("Skyye");p5.parents.add("Upscale, modern rooftop bar with a vibrant scene offering global dishes and inventive cocktails.");
            parent p6=new parent("Nolimmits Lounge & Club");p6.parents.add("Happening nightclub and lounge bar hosting themed-nights, DJs and VIP zones for special events.");
            parent p7=new parent("I Bar");p7.parents.add("Stylish hotel bar serving a range of carefully sourced spirits and freshly mixed cocktails.");
            parent p8=new parent("Bling");p8.parents.add("Classy hotel lounge/bar and weekend nightclub furnished with elegant chandeliers and sofas.");
            parent p9=new parent("Big Pitcher");p9.parents.add("Cool, sizable hangout for bar bites and house-brewed beers, plus pub quizzes and stand-up comedy.");
            parent p10=new parent("The 13th Floor");p10.parents.add("High-level lounge bar serving pan-Asian dishes and cocktails against city panoramas.");
            parent p11=new parent("Sky Lounge");p11.parents.add("Stylish rooftop and poolside bar and restaurant at Svenska Design Hotel, serving international fare.");
            parent p12=new parent("The Biere Club");p12.parents.add("Cosy,Casual,Groups");
            parent p13=new parent("Toit Brewpub");p13.parents.add("Brick-walled microbrewery offering naturally-crafted beers, hearty pub grub and brewery tours.");
            parent p14=new parent("Shiro");p14.parents.add("Japanese, Balinese and Chinese restaurant with lavish decor featuring the Buddha and relief carving.");
            parent p15=new parent("Loft 38");p15.parents.add("Contemporary loft-style space with large windows and raised seating areas, plus a full bar.");
            parent p16=new parent("Pebble The Jungle Lounge");p16.parents.add("Hip lounge/club known for DJs and electronic music with a mellow cafe serving beer and cocktails.");
            parent p17=new parent("The Biere Club");p17.parents.add("Cosy,Casula,Beer");
            parent p18=new parent("The Sugar Factory");p18.parents.add("This lively European-influenced nightclub hosts an array of electronic DJs and live acts.");
            parent p19=new parent("Bootlegger");p19.parents.add("Happy hour food,Cosy,Casual,Beer,Wine");
            parent p20=new parent("TGI Friday's");p20.parents.add("Casual chain restaurant with a festive vibe serving beer, cocktails & a wide menu of American fare.");
            parent p21=new parent("HashTag Bangalore");p21.parents.add("Cosy,Casual,Beer,Wine");
            parent p22=new parent("Hoppipola");p22.parents.add("Bustling all day bar and party venue with a line-up of comedy acts and celebrity parties.");
            parent p23=new parent("Vapour Pub and Brewery");p23.parents.add("This glamour-filled nightspot features a terrace with a DJ booth, a lounge and a global restaurant.");
            parent p24=new parent("Sanchez");p24.parents.add("Light-filled Mexican dining room dishing up classics of the cuisine along with a cocktail menu.");
            parent p25=new parent("Bangalore Brew Works");p25.parents.add("Easygoing, modern-rustic hangout with a terrace doling out global pub fare and beer.");
            parent p26=new parent("Gotcha");p26.parents.add("Cosy,Casula,Beer");
            parent p27=new parent("Koramangala Social");p27.parents.add("Late night food ,Casual,Groups");
            parent p28=new parent("Russh Gastropub Bangalore");p28.parents.add("Late night food ,Casual,Groups");
            parent p29=new parent("Hoot Cafe & Brewery");p29.parents.add("Late night food ,Casual,Groups");
            parent p30=new parent("Shimmer");p30.parents.add("Chic hotel bar with a black and pink colour scheme, mannequins showcasing fashion and live music.");
            parent p31=new parent("Skywaft");p31.parents.add("All you can eat,Beer,Wine");
            parent p32=new parent("Pool Bar");p32.parents.add("Poolside bar area with temple views on the 4th floor of an upmarket hotel serving international far.");
            parent p33=new parent("The Warehouse");p33.parents.add("Offering beer and wine");
            parent p34=new parent("Church Street Social");p34.parents.add("Spacious and stylish cafe, bar and work space serving international bites, beverages and cocktails.");
            parent p35=new parent("Hoppipola");p35.parents.add("Offering beer and wine");
            parent p36=new parent("Big Brewsky");p36.parents.add("Contemporary-design microbrewery with open air poolside seating and a menu of Asian light bites.");
            parent p37=new parent("Sharaab Factory");p37.parents.add("Offering beer and wine");
            parent p38=new parent("ALT");p38.parents.add("Casual,Groups,Beer");
            parent p39=new parent("Indigo XP");p39.parents.add("Casual,Groups,Beer");
            parent p41=new parent("Easy Tiger");p41.parents.add("Casual,Groups,Beer");
            parent p42=new parent("Sagar Pub & Bar");p42.parents.add("Casual,Groups,Beer");
            parent p43=new parent("Watson's Ulsoor");p43.parents.add("Relaxed gastro pub with views over greenery serving international food, wines and cocktails.");
            parent p44=new parent("The Studio Bar");p44.parents.add("Casual,Groups,Beer");
            parent p45=new parent("Prost");p45.parents.add("Fashionable European-style microbrewery serving house beers and an international menu.");
            parent p46=new parent("Banana Beach Bar");p46.parents.add("Casual,Groups,Beer");
            parent p47=new parent("The Boozy Griffin");p47.parents.add("Late night food ,Casual,Groups");
            parent p48=new parent("The Irish House");p48.parents.add("Casual,Groups,Beer");
            parent p49=new parent("Rewind");p49.parents.add("Casual,Groups,Beer");
            parent p50=new parent("Cirrus");p50.parents.add("Late night food ,Casual,Groups");
            parent p51=new parent("The Local");p51.parents.add("This chic nightspot has a Euro-influenced menu and rustic-chic decor in which to enjoy a full bar.");
            parent p52=new parent("Sotally Tober");p52.parents.add("Contemporary design-conscious venue with large windows and a menu of global comfort food classics.");
            parent p53=new parent("Turquoise The Underground Club");p53.parents.add("Casual,Groups,Beer");
            parent p54=new parent("Le Rock");p54.parents.add("Casual,Groups,Beer");
            parent p55=new parent("XU");p55.parents.add("Casual,Groups,Beer");
            parent p56=new parent("Bottle and Glass");p56.parents.add("Casual,Groups,Beer");
            parent p57=new parent("Bang, The Ritz-Carlton Bangalore");p57.parents.add("Casual,Groups,Beer");
            parent p58=new parent("Liber - Resto Bar");p58.parents.add("Casual,Groups,Beer");
            parent p59=new parent("Puma Social Club");p59.parents.add("Casual,Groups,Beer");
            parent p60=new parent("Thalassa");p60.parents.add("Late night food ,Casual,Groups");
            parent p61=new parent("Bar Uno");p61.parents.add("Open for lunch and dinner, this relaxed hotel restaurant serves international small plates.");
            parent p62=new parent("Tilt Gastro Lounge");p62.parents.add("Casual,Groups,Beer");
            parent p63=new parent("On The Edge");p63.parents.add("Huge windows look over the city at this upscale, design-conscious pan-Asian restaurant and lounge.");
            parent p64=new parent("Fusion Lounge");p64.parents.add("Late night food ,Casual,Groups");
            parent p65=new parent("Hammered Pub And Grub");p65.parents.add("Casual,Groups,Beer");
            parent p66=new parent("Glocal Junction");p66.parents.add("Casual,Groups,Beer");
            parent p67=new parent("Sherlock's Pub");p67.parents.add("Casual,Groups,Beer");
            parent p68=new parent("Tippler");p68.parents.add("Casual,Groups,Beer");
            parent p69=new parent("Arbor Brewing Company");p69.parents.add("Casual,Groups,Beer");
            parent p70=new parent("Xtreme Sports Bar");p70.parents.add("Late night food ,Casual,Groups");
            parent p71=new parent("Jimi's Beer Cafe");p71.parents.add("Relaxed music-themed pub named after Jimi Hendrix and serving international light meals and burgers.");
            parent p72=new parent("Quench Bar");p72.parents.add("Casual,Groups,Beer");
            parent p73=new parent("Brewsky");p73.parents.add("A modern microbrewery serving home brew and pub grub in its high-ceilinged, brickwork interior.");
            parent p74=new parent("Glassy Lounge");p74.parents.add("Late night food ,Casual,Groups");
            parent p75=new parent("Blistering Barnacles");p75.parents.add("Late night food ,Casual,Groups");
            parent p76=new parent("District 6");p76.parents.add("German dishes and grill dishes washed down with bespoke beers at a European-style microbrewery.");
            parent p77=new parent("Punjabi by Nature");p77.parents.add("Traditional Punjabi tandooris, curries and biryanis are served at this bohemian outlet.");
            parent p78=new parent("Xplode Restobar");p78.parents.add("Late night food ,Casual,Groups");
            parent p79=new parent("Brew and Barbeque");p79.parents.add("Late night food ,Casual,Groups");
            parent p80=new parent("612East");p80.parents.add("Late night,Reservations required");
            parent p81=new parent("Siam Trading Co. Thai Kitchen");p81.parents.add("Thai bar and restaurant with moody lighting and Eastern decor serving finger food and cocktails.");
            parent p82=new parent("Guzzlers Inn");p82.parents.add("Casual,Groups,Beer");
            parent p83=new parent("Lock N' Load");p83.parents.add("Quirky, Texas-themed hangout with a dance floor, DJ and full bar at Chairman's Club and Resort.");
            parent p85=new parent("Bootlegger");p85.parents.add("Casual,Groups,Beer");
            parent p86=new parent("Jcubez");p86.parents.add("Offering beer and wine");
            parent p87=new parent("The Oak Tavern- Palm Meadows");p87.parents.add("Casual,Groups,Beer");
            parent p88=new parent("Boozers Bar & Kitchen");p88.parents.add("Casual,Groups,Beer");
            parent p89=new parent("Plan B");p89.parents.add("International comfort food and a full bar menu served in a trendy space hung with exposed lights.");
            parent p90=new parent("Chin Lung Resto Bar");p90.parents.add("Happy Houe,Casual,Groups,Beer");
            parent p91=new parent("1522 The Pub");p91.parents.add("Brick-walled, basement style rock music venue, pub and restaurant serving international nibbles.");
            parent p92=new parent("Attic");p92.parents.add("Casual,Groups,Beer,Cosy");
            parent p93=new parent("Sly Granny");p93.parents.add("Casual,Groups,Beer,Cosy");
            parent p94=new parent("The Gadang");p94.parents.add("High-end hotel's chic lounge bar serving international drinks with live music and DJ entertainment.");
            parent p95=new parent("Strona - The Poolside bar");p95.parents.add("Casual,Groups,Beer,Cosy");
            parent p96=new parent("Twins");p96.parents.add("Casual,Groups,Beer,Cosy");
            parent p97=new parent("Rasa Restaurant");p97.parents.add("Late night,Casual,Groups,Beer,Cosy");
            parent p98=new parent("Double Decker");p98.parents.add("Casual,Groups,Beer,Cosy");
            parent p99=new parent("Pasta Street - Cunningham Road");p99.parents.add("Casual,Groups,Beer,Cosy");
            parent p100=new parent("Fill 'n Chill");p100.parents.add("Basic pub and restaurant with neon lighting offering budget bar snacks, Indian and Chinese food.");
    //        parent p1=new parent("");p1.parents.add("");


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
            allParent.add(p74);
            allParent.add(p75);
            allParent.add(p76);
            allParent.add(p77);
            allParent.add(p78);
            allParent.add(p79);
            allParent.add(p80);
            allParent.add(p81);
            allParent.add(p82);
            allParent.add(p83);
            allParent.add(p85);
            allParent.add(p86);
            allParent.add(p87);
            allParent.add(p88);
            allParent.add(p89);
            allParent.add(p90);
            allParent.add(p91);
            allParent.add(p92);
            allParent.add(p93);
            allParent.add(p94);
            allParent.add(p95);
            allParent.add(p96);
            allParent.add(p97);
            allParent.add(p98);
            allParent.add(p99);
            allParent.add(p100);
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