package nightlife.kumar.vikash.nightlife.goa;
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

public class goa extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goa);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("GOA");
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
        parent p1=new parent("Club Cubana");p1.parents.add("Happening neon–lit nightclub with a dance floor and DJs, plus a spacious outdoor area with a pool.");
        parent p2=new parent("Leopard Valley");p2.parents.add("High-octane nightclub in a jungle quarry with a 7-metre high DJ stage, pyrotechnics and laser shows.");
        parent p3=new parent("Cafe Mambos");p3.parents.add("Lively nightclub hosting international DJs and live entertainment by a range of performers.");
        parent p4=new parent("Kamaki");p4.parents.add("Boisterous Goan nightclub with a Greek twist and a menu of international favourites.");
        parent p5=new parent("LPK Waterfront");p5.parents.add("Lively nightclub next to the river with a rock carving-themed interior design.");
        parent p6=new parent("Cape Town Cafe");p6.parents.add("Vibrant bar and nightclub with an outdoor area, loud sound system and menu listing Goan curries.");
        parent p7=new parent("Nyex Beach Club");p7.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p8=new parent("Red Square");p8.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p9=new parent("Tito's Pub");p9.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p10=new parent("Shiva Valley");p10.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p11=new parent("Sinq Night Club");p11.parents.add("Chic nightclub and lounge resort with an outdoor bar, private poolside cabanas and resident DJs.");
        parent p12=new parent("Club Titos- The Original- Where Else!");p12.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p13=new parent("Mr. Toff Toff's Pub");p13.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p14=new parent("Curlies Beach Shack Anjuna");p14.parents.add("Rustic beach shack with rooftop seating offering Goan dishes, cocktails and club nights.");
        parent p15=new parent("COCKTAILS AND DREAMS");p15.parents.add("Vibrant cocktail bar, nightclub and party venue with a neon lit entrance.");
        parent p16=new parent("The World Famous Decades Bar");p16.parents.add("Rustic bar run by Brits, decorated with music memorabilia with karaoke, bingo and football evenings.");
        parent p17=new parent("Cohiba Bar & Kitchen");p17.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p18=new parent("Cafe Lilliput");p18.parents.add("Long-standing beach venue for international food and lively nighttime parties with DJ nights.");
        parent p19=new parent("UV Bar");p19.parents.add("Funky bar hosting a range of party nights in a spave decorated with UV artworks and dark light.");
        parent p20=new parent("Ivy");p20.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p21=new parent("9 Bar Club");p21.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p22=new parent("Praia de Luz");p22.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p23=new parent("Montego Bay Beach Village");p23.parents.add("Laid-back resort with rooms, tents & log cabins, plus beach access, yoga & a restaurant.");
        parent p24=new parent("Café Mojo Pub & Bistro");p24.parents.add("Combo of a British pub and French bistro with Goan hospitality, self-service beer and a jukebox. ");
        parent p25=new parent("Hard Rock Hotel Goa");p25.parents.add("Polished venue offering modern rooms, a stylish restaurant & a poolside bar, plus a pool & a gym.");
        parent p26=new parent("Club Lounge");p26.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p27=new parent("Club Fresh");p27.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p28=new parent("Kandy Club");p28.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p29=new parent("Capiz Bar");p29.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p30=new parent("Bora Bora Life");p30.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p31=new parent("Cavala");p31.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p32=new parent("Guru Bar");p32.parents.add("Tented beach venue with a stage for regular live musicians and a menu of international snacks.");
        parent p33=new parent("Down The Road River Front");p33.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p34=new parent("Bubble Brunch Club");p34.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p35=new parent("The Leela Goa");p35.parents.add("High-end resort featuring luxe rooms & suites, plus a 12 hole golf course, a private beach & a pool.");
        parent p36=new parent("Keys Select Ronil Resort");p36.parents.add("Bright rooms in an informal resort with an outdoor pool, dining & free breakfast, plus live music.");
        parent p37=new parent("Firefly Goan Bistro Bar");p37.parents.add("Casual open-fronted bistro close to the beach offering Goan cuisine and live music.");
        parent p38=new parent("St. Anthony's");p38.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p39=new parent("Taste of India Goa");p39.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p40=new parent("Flying Dolphin");p40.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p41=new parent("Roof Top Lounge");p41.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p42=new parent("The Mango Tree");p42.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p43=new parent("Lounge Terminal");p43.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p44=new parent("Flor Do Mar");p44.parents.add("Moored in the Chapora River, this stylish floating venue serves cocktails and local delicacies.");
        parent p45=new parent("Cafe Cotinga");p45.parents.add("Boutique hotel's bohemian garden cafe for European, Asian and Indian grub, popular with travellers.");
        parent p46=new parent("Goa Woodlands Hotel");p46.parents.add("Low-key property featuring free breakfast, plus 2 restaurants, a trendy bar & a bakery.");
        parent p47=new parent("Heritage Village Club, Goa");p47.parents.add("Refined beach resort with eateries & an Ayurvedic spa, plus a swim-up bar & daily entertainment.");
        parent p48=new parent("Butter Lounge");p48.parents.add("Casual, Cosy, Beer, Wine, Groups");
        parent p49=new parent("Soul Souffle Goa Cocktail Bar And Restaurant");p49.parents.add("Casual, Cosy, Beer, Wine, Groups");

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