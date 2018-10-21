package nightlife.kumar.vikash.nightlife.delhi;
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

public class delhi extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ExpandableListView elv;
    adapter adapter;
    ArrayList<parent> allParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi);
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.drawable.titlebarlogo);
        toolbar.setTitle("DELHI");
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
        parent p1=new parent("RSVP");p1.parents.add("Live Music, Beer, Wine,Food");
        parent p2=new parent("Privee");p2.parents.add("Casual,Beer, Wine");
        parent p3=new parent("Kitty Su");p3.parents.add("This luxurious club has a sophisticated feel for all-night DJ parties and private events.");
        parent p4=new parent("Playboy Club New Delhi");p4.parents.add("Outdoor seating, Beer, Wine,Food");
        parent p5=new parent("Keya");p5.parents.add("Casual,Beer, Wine");
        parent p6=new parent("i-Kandy");p6.parents.add("Casual,Beer, Wine");
        parent p7=new parent("Agni");p7.parents.add("Casual,Beer, Wine");
        parent p8=new parent("Hype");p8.parents.add("Contemporary, neon-lit nightspot with clever cocktails featuring DJ music and a lively dance floor.");
        parent p9=new parent("Club London");p9.parents.add("Buzzing nightclub offering a global bar with a global menu and a DJ backing track.");
        parent p10=new parent("Summer House Cafe");p10.parents.add("Relaxed cafe with wooden furnishings and sofas serving a menu of US and western-style dishes.");
        parent p11=new parent("Club BW");p11.parents.add("Casual,Beer, Wine");
        parent p12=new parent("Imperfecto");p12.parents.add("Mediterranean-style bar with a funky mix of furniture, live music and a menu of European cuisine.");
        parent p13=new parent("Hauz Khas Social");p13.parents.add("Cafe doubling up as an alternative office/workplace serving light international meals and cocktails.");
        parent p14=new parent("Lord of the Drinks");p14.parents.add("Casual,Beer, Wine");
        parent p15=new parent("G Bar - The Grand");p15.parents.add("Chic bar with a DJ at the Grand Hotel for select wine, champagne and cocktails, plus finger foods.");
        parent p16=new parent("Tamasha");p16.parents.add("Casual,Beer, Wine");
        parent p17=new parent("PCO Bar, Delhi, Vasant Vihar");p17.parents.add("American style speakeasy cocktail bar with vintage furnishings and a straightforward menu.");
        parent p18=new parent("Cafe MRP");p18.parents.add("Lounge bar and cafe with an al fresco terrace offering international cuisine and live music.");
        parent p19=new parent("Kabooze");p19.parents.add("Chic nightspot with subdued lighting and traditional motifs worked into the decor.");
        parent p20=new parent("Zaradise NightClub");p20.parents.add("Casual,Beer, Wine");
        parent p21=new parent("TGI Fridays");p21.parents.add("Casual chain restaurant with a festive vibe serving beer, cocktails & a wide menu of American fare.");
        parent p22=new parent("Raasta Delhi");p22.parents.add("Casual, Cosy, Beer, Wine");
        parent p23=new parent("Soi 7");p23.parents.add("Happening rooftop venue for a range of dishes from across Asia and beers brewed on-site. ");
        parent p24=new parent("HouseA Club Delhi");p24.parents.add("Casual, Cosy, Beer, Wine");
        parent p25=new parent("The Roxy Club");p25.parents.add("Lively contemporary venue party destination with a multi-cuisine menu, dancefloor and lounge area.");
        parent p26=new parent("Rick's");p26.parents.add("Sophisticated lounge with plush seating at the Taj Hotel for Southeast Asian fare and cocktails.");
        parent p27=new parent("Nero Le Meridien, Delhi, CP");p27.parents.add("Elegant, gothic style lounge bar at a luxury hotel mixing up cocktails with plates of finger food.");
        parent p28=new parent("S Bar");p28.parents.add("Mediterranean lounge with a terrace serving Middle Eastern dishes and varied mocktails.");
        parent p29=new parent("Regency Club Lounge");p29.parents.add("Chic hotel's lounge for light meals and drinks with views over the city from ceiling height windows.");
        parent p30=new parent("TC Restaurant & Bar");p30.parents.add("Casual, Cosy, Beer, Wine");
        parent p31=new parent("Ssky Bar & Lounge");p31.parents.add("Casual, Cosy, Beer, Wine");
        parent p32=new parent("Office Office");p32.parents.add("Innovative cocktails and international light bites in a funky modern venue designed for relaxing.");
        parent p33=new parent("Zygo");p33.parents.add("Casual, Cosy, Beer, Wine");
        parent p34=new parent("We2 Pub");p34.parents.add("Casual, Cosy, Beer, Wine");
        parent p35=new parent("Ardor 2.1");p35.parents.add("Casual, Cosy, Beer, Wine");
        parent p36=new parent("7 Barrel Brew Pub");p36.parents.add("A range of house brewed and guest beers are served at this stylish, rustic chic bar and lounge.");
        parent p37=new parent("Ice Cube");p37.parents.add("Casual, Cosy, Beer, Wine");
        parent p38=new parent("Ssky Bar & Lounge");p38.parents.add("Casual, Cosy, Beer, Wine");
        parent p39=new parent("RPM Pub");p39.parents.add("Casual, Cosy, Beer, Wine");
        parent p40=new parent("AM PM Café & Bar");p40.parents.add("Casual, Cosy, Beer, Wine");
        parent p41=new parent("STORY CLUB AND LOUNGE");p41.parents.add("Casual, Cosy, Beer, Wine");
        parent p42=new parent("IKKA THE ACE BAR");p42.parents.add("Casual, Cosy, Beer, Wine");
        parent p43=new parent("Oval Bar");p43.parents.add("Casual, Cosy, Beer, Wine");
        parent p44=new parent("Informal");p44.parents.add("Warehouse-style nightspot with chic industrial decor, a full bar and a range of signature cocktails.");
        parent p45=new parent("Monkey Bar");p45.parents.add("Indianised global bites are served at this hip lounge bar under a striking glass pyramid.");
        parent p46=new parent("Bulldogs");p46.parents.add("Casual, Cosy, Beer, Wine");
        parent p47=new parent("Big Banana Restaurant and Bar");p47.parents.add("Casual, Cosy, Beer, Wine");
        parent p48=new parent("Caffe 9 Restaurant & Lounge");p48.parents.add("World dishes are served at this elegant restaurant with wooden and bamboo decor.");
        parent p49=new parent("Urban Hub");p49.parents.add("Cozy, contemporary joint with a warm vibe featuring a full bar & pub fare, along with DJ music.");
        parent p50=new parent("Sutra Gastropub");p50.parents.add("A modern gastropub decked out in a wood offering a European, Mediterranean and American menu.");
        parent p51=new parent("Raasta");p51.parents.add("Casual, Cosy, Beer, Wine");
        parent p52=new parent("Blue Bar");p52.parents.add("Casual, Cosy, Beer, Wine");
        parent p53=new parent("A Ta Maison");p53.parents.add("Glamour-filled destination for private members with on-site restaurants, bars and meeting spaces.");
        parent p54=new parent("Reverb Disc");p54.parents.add("Casual, Cosy, Beer, Wine");
        parent p55=new parent("Molecule Air Bar");p55.parents.add("Casual, Cosy, Beer, Wine");
        parent p56=new parent("Perch Wine & Coffee Bar");p56.parents.add("Casual, Cosy, Beer, Wine");
        parent p57=new parent("Lanterns Kitchen & Bar");p57.parents.add("Chic bar and grill open since 2001 plating standard Indian and global dishes.");
        parent p58=new parent("Open House");p58.parents.add("Casual, Cosy, Beer");
        parent p59=new parent("RockStar");p59.parents.add("Casual, Cosy, Beer, Wine");
        parent p60=new parent("Zest");p60.parents.add("Casual, Cosy, Beer, Wine");
        parent p61=new parent("Hotel Arpit Palace");p61.parents.add("Basic lounge and restaurant at a budget hotel serving Indian, Mughlai, Chinese and continental food.");
        parent p62=new parent("Café 27");p62.parents.add("International, Lebanese and Indian food in a spot with outdoor tables and a live music calendar.");
        parent p63=new parent("3 Pegs Down");p63.parents.add("Casual, Cosy, Beer, Wine");
        parent p64=new parent("The Junkyard Cafe");p64.parents.add("Casual, Cosy, Beer, Wine");
        parent p65=new parent("Uber Lounge");p65.parents.add("DJs play at this trendy nightspot offering a range of international dishes.");
        parent p66=new parent("Hell 2 Heaven");p66.parents.add("Lively nightclub and lounge known for its music and DJs offering a grill menu.");
        parent p67=new parent("Dramz Whisky Bar & Lounge");p67.parents.add("Elegant setting for European dining, a whisky bar/lounge and a roof terrace with Qutub Minar views.");
        parent p68=new parent("38 Barracks");p68.parents.add("Casual, Cosy, Beer, Wine");
        parent p69=new parent("Teddy Boy");p69.parents.add("Low lit, brick-walled lounge with a menu of Indian and international snacks and a full bar.");
        parent p70=new parent("House of Commons");p70.parents.add("Casual, Cosy, Beer, Wine");
        parent p71=new parent("The Food & Booze Exchange");p71.parents.add("Casual, Cosy, Beer, Wine");
        parent p72=new parent("Nofilter Cafe");p72.parents.add("Casual, Cosy, Beer, Wine");
        parent p73=new parent("My Bar Grill");p73.parents.add("Elegant, high-ceilinged international grill restaurant with a cocktail and mocktail bar.");
        parent p74=new parent("Yes Minister Bowling,Bar & Kitchen");p74.parents.add("Casual, Cosy, Beer, Wine");
        parent p75=new parent("Filmy Cafe & Bar");p75.parents.add("Global comfort food dishes in a simple cafe with a film vibe and wooden seating.");
        parent p76=new parent("Zai");p76.parents.add("Casual, Cosy, Beer, Wine");
        parent p77=new parent("The Electric Room");p77.parents.add("Casual, Cosy, Beer, Wine");
        parent p78=new parent("Farzi Cafe");p78.parents.add("Bustling cafe creating fusion Indian and international flavours using molecular gastronomy methods.");
        parent p79=new parent("Moon Shine Cafe And Bar");p79.parents.add("Happening nightlife venue and cafe favoured by a hip, young crowd serving international bites.");
        parent p80=new parent("Quoin");p80.parents.add("Casual, Cosy, Beer, Wine");
        parent p81=new parent("Cross Roads Bar Restaurant");p81.parents.add("Hotel's lounge bar and restaurant with a pan-Indian menu with lemongrass scented candles.");
        parent p82=new parent("Blues");p82.parents.add("Casual, Cosy, Beer, Wine");
        parent p83=new parent("The Piano Man Jazz Club");p83.parents.add("Casual, Cosy, Beer, Wine");
        parent p84=new parent("Garage inc.");p84.parents.add("Wood dominated cafe-style dining room for an American and international comfort food menu.");
        parent p85=new parent("My Bar Cafe");p85.parents.add("Indian, Chinese, Lebanese and continental dishes served in a stylish bar with big screen sports.");
        parent p86=new parent("Grappa Bar");p86.parents.add("Casual, Cosy, Beer, Wine");
        parent p87=new parent("Uzzuri Deli & Bar");p87.parents.add("Contemporary dining room and cocktail bar dishing up inventive takes on world food in a chic space.");
        parent p88=new parent("Sky Lounge Bar & Grill");p88.parents.add("High-end venue with free breakfast, plus dining, a bar & a tea room, as well as a nightclub & pools.");
        parent p89=new parent("World Art Dining");p89.parents.add("Funky high-ceilinged restaurant venue with an inventive international menu and an on-site pub venue.");
        parent p90=new parent("My Bar Square");p90.parents.add("Indian, Chinese, Lebanese and continental dishes served in a stylish bar with big screen sports.");
        parent p91=new parent("Ek Bar");p91.parents.add("Casual, Cosy, Beer, Wine");
        parent p92=new parent("The Oberoi");p92.parents.add("Upmarket lodging with 3 chic restaurants, a bar & an outdoor pool, plus a full-service spa.");
        parent p93=new parent("Ali Baba Caves");p93.parents.add("This cave-themed multi-cuisine restaurant takes its design inspiration from the medieval era,");
        parent p94=new parent("My Bar Headquarters");p94.parents.add("Funky nightspot with brick walls and an industrial vibe, plus seating on an outdoor terrace.");
        parent p95=new parent("Def Col Social");p95.parents.add("Contemporary cafe/bar venue and collaborative workspace encouraging engagement with the arts.");
        parent p96=new parent("Club BnB Shooters");p96.parents.add("Casual, Cosy, Beer, Wine");
        parent p97=new parent("Masabaa");p97.parents.add("Opulently decorated fine dining venue with plush private rooms plating Indian and global fare.");
        parent p98=new parent("Local");p98.parents.add("Casual, Cosy, Beer, Wine");
        parent p99=new parent("Allure Bar & Restaurant");p99.parents.add("Casual, Cosy, Beer, Wine");
        parent p100=new parent("Raftaar High Speed Club & Lounge");p100.parents.add("Casual, Cosy, Beer, Wine");
        parent p101=new parent("Castle 9");p101.parents.add("This light-filled contemporary restaurant serves a variety of Indian, Chinese and Continental food.");
        parent p102=new parent("Indian Accent");p102.parents.add("Contemporary twists on Indian cuisine are served at this stylish, prize-winning restaurant.");
        parent p103=new parent("The Beer Cafe");p103.parents.add("Casual, Cosy, Beer, Wine");
        parent p104=new parent("Aroma Restaurant and Bar");p104.parents.add("Casual, Cosy, Beer, Wine");
        parent p105=new parent("Lights Camera Action");p105.parents.add("The music, decor and even the menu reflect popular movies from Bollywood at this casual hangout.");
        parent p106=new parent("The Suryaa New Delhi");p106.parents.add("Relaxed rooms & suites in an upscale venue offering nightlife, 2 restaurants & a spa.");
        parent p107=new parent("Tapas, Jaypee Vasant Continental");p107.parents.add("Hotel cocktail bar and lounge with nightly live music and an international, tapas-style menu.");
        parent p108=new parent("Parikrama The Revolving Restaurant");p108.parents.add("Revolving rooftop restaurant with city views and a menu of Indian and Chinese food, plus a lounge.");
        parent p109=new parent("Adda by Striker");p109.parents.add("Cosy pub with wood-panelled walls, a manicured roof terrace and a north Indian and Mexican menu.");
        parent p110=new parent("Bombay Bar");p110.parents.add("Casual, Cosy, Beer, Wine");
        parent p111=new parent("The Beer Cafe");p111.parents.add("Casual, Cosy, Beer, Wine");
        parent p112=new parent("Lord of the Drinks Chamber");p112.parents.add("Casual, Cosy, Beer, Wine");
        parent p113=new parent("Thugs");p113.parents.add("Hotel bar with booth seating and art celebrating the great film bad guys of Hollywood and Bollywood.");
        parent p114=new parent("Platinum Lounge");p114.parents.add("Casual, Cosy, Beer, Wine");
        parent p115=new parent("1 Cafe Lounge");p115.parents.add("Casual, Cosy, Beer, Wine");
        parent p116=new parent("Manhattan Bar Exchange And Brewery");p116.parents.add("Bustling, modern-rustic locale for house-brewed beer and pub fare, plus DJ music and comedy nights.");
        parent p117=new parent("Olive Bar and Kitchen Restaurant");p117.parents.add("Colonial building decorated in a refined yet relaxed style and serving a mix of Italian favourites.");
        parent p118=new parent("The Sky High");p118.parents.add("Casual, Cosy, Beer, Wine");
        parent p119=new parent("1911 Bar");p119.parents.add("Hotel bar harking back to the days of English colonial power with a range of imported drinks.");
        parent p120=new parent("Tipple");p120.parents.add("Upscale hotel bar with a light and airy feel, live DJs and a menu of international snack food.");
        parent p121=new parent("Savannah Bar");p121.parents.add("Late opening hotel bar with a serene feel, an extensive wine list and a range of beers and spirits.");
        parent p122=new parent("BED");p122.parents.add("Casual, Cosy, Beer, Wine");
        parent p123=new parent("Londoners Bistro & Pub");p123.parents.add("British-influenced pub with a contemporary mismatched design , an outdoor patio and varied menus.");
        parent p124=new parent("UpTown Cafe");p124.parents.add("Casual, Cosy, Beer, Wine");
        parent p125=new parent("Bohca - Bar & Restaurant");p125.parents.add("Casual, Cosy, Beer, Wine");
        parent p126=new parent("True Blue Resto & Bar");p126.parents.add("Casual, Cosy, Beer, Wine");
        parent p127=new parent("Jail Behind The Bar");p127.parents.add("Casual, Cosy, Beer, Wine");
        parent p128=new parent("Sinciti");p128.parents.add("Casual, Cosy, Beer, Wine");
        parent p129=new parent("Hawalat");p129.parents.add("Casual, Cosy, Beer, Wine");
        parent p130=new parent("Boom Box Cafe Reloaded");p130.parents.add("Casual, Cosy, Beer, Wine");
        parent p131=new parent("HotMess Kitchen & Bar");p131.parents.add("Casual, Cosy, Beer, Wine");
        parent p132=new parent("Gastronomica");p132.parents.add("Casual, Cosy, Beer, Wine");
        parent p133=new parent("The Headquarter");p133.parents.add("Casual, Cosy, Beer, Wine");
        parent p134=new parent("RDX Fine Drink and Restaurant");p134.parents.add("This lounge and dining room venue serves a multi-cuisine menu and a full range of cocktails.");
        parent p135=new parent("Jazbaa Bar & Lounge");p135.parents.add("Casual, Cosy, Beer, Wine");
        parent p136=new parent("BarShala");p136.parents.add("Simple Indian dishes are served in an upbeat atmosphere at this fun-filled spot showing sport on TV.");
        parent p137=new parent("Route 04");p137.parents.add("Relaxed American diner with a bar and an array of American and Tex-Mex favourites.");

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
        allParent.add(p84);
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
        allParent.add(p101);
        allParent.add(p102);
        allParent.add(p103);
        allParent.add(p104);
        allParent.add(p105);
        allParent.add(p106);
        allParent.add(p107);
        allParent.add(p108);
        allParent.add(p109);
        allParent.add(p110);
        allParent.add(p111);
        allParent.add(p112);
        allParent.add(p113);
        allParent.add(p114);
        allParent.add(p115);
        allParent.add(p116);
        allParent.add(p117);
        allParent.add(p118);
        allParent.add(p119);
        allParent.add(p120);
        allParent.add(p121);
        allParent.add(p122);
        allParent.add(p123);
        allParent.add(p124);
        allParent.add(p125);
        allParent.add(p126);
        allParent.add(p127);
        allParent.add(p128);
        allParent.add(p129);
        allParent.add(p130);
        allParent.add(p131);
        allParent.add(p132);
        allParent.add(p133);
        allParent.add(p134);
        allParent.add(p135);
        allParent.add(p136);
        allParent.add(p137);


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