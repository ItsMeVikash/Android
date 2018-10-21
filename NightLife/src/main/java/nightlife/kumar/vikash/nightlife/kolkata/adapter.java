package nightlife.kumar.vikash.nightlife.kolkata;

/**
 * Created by vikash kumar on 28-12-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import nightlife.kumar.vikash.nightlife.GoogleMap.GoogleMaps;
import nightlife.kumar.vikash.nightlife.NoUnderlineSpan;
import nightlife.kumar.vikash.nightlife.R;
import nightlife.kumar.vikash.nightlife.google_floating_button;
import nightlife.kumar.vikash.nightlife.parent;
import nightlife.kumar.vikash.nightlife.web_browser;

/**
 * Created by vikash kumar on 27-12-2017.
 */

public class adapter extends BaseExpandableListAdapter {
    private Context c;
    private ArrayList<parent> parent;
    private LayoutInflater inflater;
    public adapter(Context c, ArrayList<parent> parent)
    {
        this.c=c;
        this.parent=parent;
        inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getChild(int parentpos,int childPos)
    {
        return parent.get(parentpos).parents.get(childPos);
    }
    @Override
    public long getChildId(int arg0,int arg1)
    {
        return 0;
    }
    @Override
    public View getChildView(int parentpos, int childpos, boolean isLastChild, View convertview, ViewGroup parent)
    {
        if(convertview==null)
        {
            convertview=inflater.inflate(R.layout.child,null);
        }
        //child
        final String child=(String)getChild(parentpos,childpos);
        final TextView address=(TextView)convertview.findViewById(R.id.address);
        final TextView phone=(TextView)convertview.findViewById(R.id.phone);
        final TextView description=(TextView)convertview.findViewById(R.id.description);
        final TextView web=(TextView)convertview.findViewById(R.id.web);
        final TextView time=(TextView)convertview.findViewById(R.id.Time);
        address.setText(child);
        description.setText(child);
        phone.setText(child); web.setText(child); time.setText(child);
        final String parentName=getGroup(parentpos).toString();
        if(parentName=="Someplace Else"){
            address.setText("17, Park St, Taltala, Kolkata, West Bengal 700016");
            web.setText("theparkhotels.com");phone.setText("080106 39639");
            time.setText("All_Days\t\n" +
                    "4PM–12AM");}
       else if(parentName=="Nocturne"){
        address.setText("31, Shakespeare Sarani Rd, Mullick Bazar, Park Street area, Kolkata, West Bengal 700017");
        web.setText("liveinstyle.com");phone.setText("085098 53318");
        time.setText("All_Days\t\n" +
                "2PM–12:30AM");}
    else if(parentName=="Club Boudoir"){
        address.setText("Shakespeare Point, 3rd Floor, Near Bhajanlal's, 40 Shakespeare Sarani, Elgin, Kolkata, West Bengal 700017");
        web.setText("liveinstyle.com");phone.setText("081004 32442");
        time.setText("Unknown");}
    else if(parentName=="Roxy"){
        address.setText("17, Park Street, Taltala, Kolkata, West Bengal 700016");
        web.setText("theparkhotels.com");phone.setText("098833 51887");
        time.setText("All_Days\t\n" +
                "6PM–12AM");}
    else if(parentName=="The Myx"){
        address.setText("20G, Park St, Park Street area, Kolkata, West Bengal 700071");
        web.setText("liveinstyle.com");phone.setText("Unknown");
        time.setText("All_Days\t\n" +
                "8PM–12AM");}
    else if(parentName=="Privy Ultra Lounge"){
        address.setText("10/3, 4th Floor, Forum, Lala Lajpat Rai Sarani, Sreepally, Bhawanipur, Sreepally, Bhowanipore, Kolkata, West Bengal 700020");
        web.setText("Unavailable");phone.setText("098049 65669");
        time.setText("All_Days\t\n" +
                "12:30–11:30PM");}
    else if(parentName=="Smoke Shack"){
        address.setText("7th floor, Hotel Park Plaza, 17, Garcha 1st Lane, Ballygunge, Dover Terrace, Ballygunge, Kolkata, West Bengal 700019");
        web.setText("liveinstyle.com");phone.setText("081009 23799");
        time.setText("All_Days\t\n" +
                "5–11:30PM");}
    else if(parentName=="UG Reincarnated"){
        address.setText("Hotel Hindusthan International, A.J.C., 235/1, Acharya Jagadish Chandra Bose Rd, Sreepally, Elgin, Kolkata, West Bengal 700020");
        web.setText("liveinstyle.com");phone.setText("085094 61251");
        time.setText("All_Days\t\n" +
                "6PM–2AM");}
    else if(parentName=="Bakstage"){
        address.setText("1st Floor, EN Block, Sector V, Salt Lake City, EN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("Unavailable");phone.setText("098837 53337");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Black Lounge Bar"){
        address.setText("Aauris Hotel,, 4, Robinson Street, Mullick Bazar, Elgin, Mullick Bazar, Park Street area, Kolkata, West Bengal 700017");
        web.setText("liveinstyle.com");phone.setText("088200 99434");
        time.setText("All_Days\t\n" +
                "6PM–12AM");}
    else if(parentName=="Raize The Bar"){
        address.setText("Block DP, Plot No 5, Godrej Waterside IT Park,, Near College More, Salt Lake City, DP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("liveinstyle.com");phone.setText("096814 76190");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Afraa"){
        address.setText("6th & 7th Floor, City Centre Mall, G-Block, Sector-1, Salt Lake City, DC Block, Sector 1, Salt Lake City, Kolkata, West Bengal 700064");
        web.setText("mochahookah.club");phone.setText("088201 52345");
        time.setText("All_Days\t\n" +
                "12:30–11:30PM");}
    else if(parentName=="Pour House"){
        address.setText("K-1, EP & GP, GP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("liveinstyle.com");phone.setText("096815 63959");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="Shisha Bar Exchange"){
        address.setText("Block D 5th Floor, 22, Camac Street, Kankaria Estates, Park Street area, Kolkata, West Bengal 700016");
        web.setText("shpl.co.in");phone.setText("033 2281 1313");
        time.setText("All_Days\t\n" +
                "3PM–12AM");}
    else if(parentName=="What's In d Name"){
        address.setText("1/1, Camac Street, Park Street Area, Beside Magma House, Park Street area, Kolkata, West Bengal 700016");
        web.setText("Unavailable");phone.setText("081008 88811");
        time.setText("All_Days\t\n" +
                "2:30–11:30PM");}
    else if(parentName=="M Bar And Kitchen"){
        address.setText("24 Park Street, Park Street area, Kolkata, West Bengal 700016");
        web.setText("mbar.wchindia.com");phone.setText("033 4007 8686");
        time.setText("All_Days\t\n" +
                "5:30PM–12AM");}
    else if(parentName=="Xrong Place"){
        address.setText("25, Dr.Sarat Banerjee Rd, Lake Market, Kalighat, Kolkata, West Bengal 700029");
        web.setText("liveinstyle.com");phone.setText("088209 59973");
        time.setText("All_Days\t\n" +
                "2PM–12AM");}
    else if(parentName=="Bluzz"){
        address.setText("9/3B, Ashutosh Chowdary Ave, Ballygunge Place, Ballygunge, Kolkata, West Bengal 700019");
        web.setText("muktigroup.in");phone.setText("033 4060 7380");
        time.setText("All_Days\t\n" +
                "1–11:45PM");}
    else if(parentName=="Urban Desi"){
        address.setText("6, Camac St, 9th Floor, Fort Knox, Elgin, Kolkata, West Bengal 700017");
        web.setText("urban-desi.business.site");phone.setText("098303 20077");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Masque Lounge & Bar"){
        address.setText("3rd Floor, Silver Arcade, Eastern Metropolitan Bypass, Dhapa, Kolkata, West Bengal 700105");
        web.setText("Unavailable");phone.setText("033 2251 7283");
        time.setText("All_Days\t\n" +
                "2–11PM");}
    else if(parentName=="Oval Lounge"){
        address.setText("1st Floor, 101, Tower C, DLF IT Park, Major Arterial Road, Rajarhat New, Town, Ko, AF Block(Newtown), Action Area I, Newtown, Kolkata, West Bengal 700156");
        web.setText("liveinstyle.com");phone.setText("086972 84889");
        time.setText("All_Days\t\n" +
                "12–10:45PM");}
    else if(parentName=="Chilis Kolkata"){
        address.setText("4th Floor, Acropolis Mall, Rajdanga Main Rd, Sector 1, Kolkata, West Bengal, 7001, Shantipally, Sector B, East Kolkata Twp, Kolkata, West Bengal 700107");
        web.setText("liveinstyle.com");phone.setText("089271 51867");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="Sam's Pub"){
        address.setText("13 C, Anandilal Poddar Sarani, Russell Street, A.J.C. Bose Road, Park Street, Kolkata, West Bengal 700071");
        web.setText("Unavailable");phone.setText("Unavailable");
        time.setText("All_Days\t\n" +
                "10AM–12AM");}
    else if(parentName=="Illusion lounge"){
        address.setText("The Metropolis Mall, Eastern Metropolitan Bypass, Hiland Park, 1925, Chak Garia, Santoshpur, Kolkata, West Bengal 700075");
        web.setText("Unavailable");phone.setText("090074 74401");
        time.setText("All_Days\t\n" +
                "9AM–11PM");}
    else if(parentName=="Blue Nile"){
        address.setText("City Centre 2, Shop no C-114, 1st Floor, New Town, Action Area II, Action Area IID, Newtown, Kolkata, West Bengal 700157");
        web.setText("bluenilelounge.com");phone.setText("033 4062 0238");
        time.setText("All_Days\t\n" +
                "12–10:30PM");}
    else if(parentName=="10 DOWNING STREET"){
        address.setText("PS Srijan Corporate Park, Gr. Floor, GP Block, Sector V, Salt Lake City, GP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700106");
        web.setText("liveinstyle.com");phone.setText("033 4005 5933");
        time.setText("All_Days\t\n" +
                "12–11:30PM");}
    else if(parentName=="The Irish House"){
        address.setText("5th Floor, Quest Mall, 33, Syed Ali Beckbagan,, Sayed Amir Ali Avenue, Syed Amir Ali Avenue, Lower Range, Beck Bagan, Ballygunge, Park Circus, Ballygunge, Kolkata, West Bengal 700017");
        web.setText("theirishhouse.in");phone.setText("081002 53778");
        time.setText("All_Days\t\n" +
                "12–11:30PM");}
    else if(parentName=="Go Where"){
        address.setText("Ground Floor, Systron Building, EP & GP Block, Near RDB Cinemas, Sector 5,, Salt, GP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("liveinstyle.com");phone.setText("089272 14785");
        time.setText("All_Days\t\n" +
                "11AM–11:30PM");}
    else if(parentName=="Badshah Bar & Restaurant"){
        address.setText("5, Lindsay St, Fire Brigade Head Quarter, New Market Area, Dharmatala, Taltala, Kolkata, West Bengal 700087");
        web.setText("liveinstyle.com");phone.setText("096815 54944");
        time.setText("All_Days\t\n" +
                "11AM–10:30PM");}
    else if(parentName=="Sagar Bar & Restaurant"){
        address.setText("1, Meredith St, Chowringhee North, Dharamtalla, Kolkata, West Bengal 700072");
        web.setText("liveinstyle.com");phone.setText("085095 53318");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="WILSON'S"){
        address.setText("THE LALIT GREAT EASTERN KOLKATA, 1,2,3, Old Court House Street, Chowringhee North, Bow Barracks, Kolkata, West Bengal 700069");
        web.setText("thelalit.com");phone.setText("033 4444 7777");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Café Montecarlo"){
        address.setText("Kolkata, 3/1, Mangoe Ln, Terita Bazar, Bara Bazar, Bow Barracks, Kolkata, West Bengal 700001");
        web.setText("liveinstyle.com");phone.setText("083888 14785");
        time.setText("All_Days\t\n" +
                "11AM–10:30PM");}
    else if(parentName=="Wall Street Bar"){
        address.setText("10, Shakespeare Sarani Rd, Elgin, Kolkata, West Bengal 700071");
        web.setText("Unavailable");phone.setText("098308 88821");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Damurs Bar and Restaurant"){
        address.setText("GR. & 2nd Floor only - 7, Old Court House Corner, (Radhabazar Street), Behind Lalbazar P.S., Radha Bazar, Barabazar Market, Kolkata, West Bengal 700001");
        web.setText("zomato.com");phone.setText("033 2225 3469");
        time.setText("Thrusday\t"+"Closed\n"+"All_Other_Days\t\n" +
                "11AM–11:30PM");}
    else if(parentName=="Ozora"){
        address.setText("1858 20th floor, Rajdanga Main Road, Shantipally, Sector B, East Kolkata Twp, Kolkata, West Bengal 700107");
        web.setText("Unavailable");phone.setText("033 4067 1147");
        time.setText("All_Days\t\n" +
                "4PM–12AM");}
    else if(parentName=="Nirvana"){
        address.setText("Hotel Park Plaza,17, Garcha 1st Lane, Dover Terrace, Ballygunge, Dover Terrace, Ballygunge, Kolkata, West Bengal 700019");
        web.setText("parkplaza.com");phone.setText("033 4040 9999");
        time.setText("All_Days\t\n" +
                "11AM–11:30PM");}
    else if(parentName=="The Big Ben"){
        address.setText("Kenilworth Hotel,1 & 2 Little Russel Street, Kankaria Estates, Park Street area, Kolkata, West Bengal 700071");
        web.setText("kenilworthhotels.com");phone.setText("033 2282 3939");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Scrapyard"){
        address.setText("12, Camac St, Elgin, Kolkata, West Bengal 700017");
        web.setText("Unavailable");phone.setText("098310 45951");
        time.setText("All_Days\t\n" +
                "1PM–12AM");}
    else if(parentName=="Opium Bar And Restaurant"){
        address.setText("J3,, GP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("Unavailable");phone.setText("33235776411");
        time.setText("All_Days\t\n" +
                "12–10:30PM");}
    else if(parentName=="Mocambo Restaurant & Bar"){
        address.setText("25 B, Park Street, Taltala, Kolkata, West Bengal 700016");
        web.setText("Unavailable");phone.setText("033 2265 4300");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="OlyPub"){
        address.setText("21, Ground Floor, Park Street, Opp. MAGS Restaurant, Taltala, Kolkata, West Bengal 700016");
        web.setText("Unavailable");phone.setText("033 6452 0472");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Country Roads Micro Brewery And Restaurant"){
        address.setText("DEK 226-230, 2nd Floor, The Galleria, Plot No: DGH, Action Area 1B, Near DLF 1, Rajarhat , Newtown, BG Block(Newtown), Action Area I, Newtown, Kolkata, West Bengal 700156");
        web.setText("liveinstyle.com");phone.setText("090660 25279");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="The Drunken Monkey (O2 Hotel)"){
        address.setText("RGM 643, VIP Road, Near Airport, Kaikhalii, Ramkrishna Pally, Dakhin Mart Kaikhalii, Kolkata, West Bengal 700052");
        web.setText("loharukahotels.com");phone.setText("098364 75821");
        time.setText("All_Days\t\n" +
                "11:55AM–11:55PM");}
    else if(parentName=="On The Rockz"){
        address.setText("Plot No. 2, G/1, Centrus Mall, Action Area II, Newtown Rajarhat, Action Area II, Newtown, Kolkata, West Bengal 700156");
        web.setText("facebook.com");phone.setText("033 6503 1999");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="H2O Resto Pub"){
        address.setText("Rajdanga Main Rd, Sector E, East Kolkata Twp, Kolkata, West Bengal 700107");
        web.setText("Unavailable");phone.setText("033 2442 9948");
        time.setText("All_Days\t\n" +
                "1–11:30PM");}
    else if(parentName=="Beer Republic"){
        address.setText("93, Narkeldanga Main Rd, Kadapara, Phool Bagan, Kankurgachi, Kolkata, West Bengal 700054");
        web.setText("Unavailable");phone.setText("033 2320 0084");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="One Sports Lounge"){
        address.setText("Infinity Benchmark, Ground Floor, Sector 5, Salt Lake, GP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("Unavailable");phone.setText("033 6500 5095");
        time.setText("All_Days\t\n" +
                "11AM–12AM");}
    else if(parentName=="Tandoor Park"){
        address.setText("28/4, Gariahat Road South, (Opposite Jodhpur Park Post Office), Dhakuria, Selimpur, Kolkata, West Bengal 700031");
        web.setText("tandoorpark.com");phone.setText("098363 70051");
        time.setText("All_Days\t\n" +
                "12–10:30PM");}
    else if(parentName=="Titos"){
        address.setText("12, Dalahosi, Old House Street, Chowringhee North, BBD Bagh, Kolkata, West Bengal 700001");
        web.setText("titosgoa.com");phone.setText("080170 30876");
        time.setText("All_Days\t\n" +
                "10AM–11PM");}
    else if(parentName=="Hing"){
        address.setText("20 J1/6, EP Block, Sector 5, Salt Lake City, EP Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091");
        web.setText("Unavailable");phone.setText("098833 00000");
        time.setText("All_Days\t\n" +
                "12–11:55PM");}
    else if(parentName=="Rocks"){
        address.setText("9, Crooked Lane, Watreloo Street, Chowringhee North, Bow Barracks, Chowringhee North, Bow Barracks, Kolkata, West Bengal 700069");
        web.setText("Unavailable");phone.setText("033 2231 7619");
        time.setText("All_Days\t\n" +
                "11AM–12AM");}
    else if(parentName=="High Street Bar"){
        address.setText("43/2, V.I.P. Road, 1st Floor, Raghunathpur (North), Baguiati, Sahabagan, Jyangra, Baguiati, Kolkata, West Bengal 700059");
        web.setText("liveinstyle.com");phone.setText("033 7100 0131");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Evergreen Bar & Restaurant"){
        address.setText("9, South Tangra Road, Gobinda Khatik Road, Seal Lane, Tangra, Kolkata, West Bengal 700046");
        web.setText("Unavailable");phone.setText("098303 88952");
        time.setText("All_Days\t\n" +
                "11AM–2:30PM\n" +
                "5–10PM");}
    else if(parentName=="Moulin Rouge"){
        address.setText("31, Park Street, Taltala, Kolkata, West Bengal 700016");
        web.setText("moulinrouge.fr");phone.setText("033 2229 9397");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Addiction Bar & Restaurant"){
        address.setText("Axis mall, Rajarhat New Town, CF Block(Newtown), Action Area I, Newtown, Kolkata, West Bengal 700156");
        web.setText("Unavailable");phone.setText("076998 31429");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="Preach"){
        address.setText("Srijan Corporate Park, Plot 2, Tower 2, Retail unit 3, GP Block, Sector V, Salt Lake City, GP Block, Sector V, Salt Lake City, Bidhannagar, West Bengal 700091");
        web.setText("liveinstyle.com");phone.setText("098360 04071");
        time.setText("All_Days\t\n" +
                "10AM–10PM");}
    else if(parentName=="A Step Up"){
        address.setText("Bidhannagar Rd, Ghose Bagan, Kolkata, West Bengal 700054");
        web.setText("Unavailable");phone.setText("033 4006 4305");
        time.setText("All_Days\t\n" +
                "11AM–1AM");}
    else if(parentName=="Bistro Y, Restro Pub"){
        address.setText("J/1/16, 001, Ground Floor, Shila Tower, Sector V, EP And GP Block, Near Wable Bhavan, Salt Lake City, EP Block, Sector V, Salt Lake City, Bidhannagar, West Bengal 700091");
        web.setText("liveinstyle.com");phone.setText("090079 09328");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="The Shack Lounge"){
        address.setText("19B, Tarak Dutta Rd, Lower Range, Beck Bagan, Ballygunge, Kolkata, West Bengal 700019");
        web.setText("Unavailable");phone.setText("098307 85591");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Swastik Bar"){
        address.setText("4, Moti Sil St, Esplanade, Dharmatala, Taltala, Kolkata, West Bengal 700013");
        web.setText("Unavailable");phone.setText("098612 58578");
        time.setText("All_Days\t\n" +
                "10AM–12AM");}
    else if(parentName=="Zion Lounge"){
        address.setText("City Centre 2, Rajarhat, New Town, Action Area II, Action Area IID, Newtown, New Town, West Bengal 700157");
        web.setText("Unavailable");phone.setText("033 4001 7402");
        time.setText("All_Days\t\n" +
                "12AM–10PM");}


        //remove underline from textview auto link
        NoUnderlineSpan mNoUnderlineSpan = new NoUnderlineSpan();
        if (phone.getText() instanceof Spannable) {
            Spannable s = (Spannable) phone.getText();
            s.setSpan(mNoUnderlineSpan, 0, s.length(), Spanned.SPAN_MARK_MARK);
        }
        //opening web browser
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(c.getApplicationContext(),web_browser.class);
                i.putExtra("message", web.getText().toString());
                c.startActivity(i);
            }
        });
        //opening google map
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), GoogleMaps.class);
                intent.putExtra("message", address.getText().toString());
                c.startActivity(intent);
            }
        });
        //sharing content
        FloatingActionButton but=(FloatingActionButton)convertview.findViewById(R.id.share_content);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "-----NIGHTLIFE-----"
                        +"\nName:-\t"+""+parentName.toString()
                        +"\n\nDescription:-\t"+""+child.toString()
                        +"\n\nAddress:-\t"+""+address.getText().toString()
                        +"\n\nWebsite:-\t"+""+web.getText().toString()
                        +"\n\nPhone:-\t"+""+phone.getText().toString()
                        +"\n\nWorking Hours:-\t"+""+time.getText().toString()
                        +"\n\nIf you enjoy using the app, Please take a moment to download the app\n"
                        +"https://play.google.com/store/apps/details?id=nightlife.kumar.vikash.nightlife");
                sendIntent.setType("text/plain");
                c.startActivity(sendIntent);
            }
        });
        //google button
        FloatingActionButton google=(FloatingActionButton)convertview.findViewById(R.id.google_it);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c.getApplicationContext(), google_floating_button.class);
                i.putExtra("google_search", parentName.toString());
                c.startActivity(i);
            }
        });
        return convertview;
    }
    @Override
    public int getChildrenCount(int parentposW)
    {
        return parent.get(parentposW).parents.size();
    }
    @Override
    public Object getGroup(int parentpos)
    {
        return parent.get(parentpos);
    }
    @Override
    public int getGroupCount()
    {
        return parent.size();
    }
    @Override
    public long getGroupId(int arg0)
    {
        return  0;
    }
    @Override
    public View getGroupView(int parentposition,boolean isExpanded,View convertView,ViewGroup parent)
    {
        //get parent row
        if (convertView==null)
        {
            convertView=inflater.inflate(R.layout.parent,null);
        }
        parent p=(parent) getGroup(parentposition);
        TextView name=(TextView)convertView.findViewById(R.id.name);
        final ImageView img=(ImageView)convertView.findViewById(R.id.hotel_pic);
        String namee=p.Name;
        name.setText(namee);
        if(namee=="Someplace Else"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/QKyNw5tJ8mBL7luk-GzPtP4YO0KfUolRBIUKoL97lw1JwnC2qBtVoHbgklyNtWbzlNluYOy17xDAfJGQM9rskuxBTLMDkgMnQ5N5SYUO_-xki81cy7TR0BCNCSn2KsNHmnYOCys78rWV-oTiK6SzEnmhZu97J2A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Nocturne"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/63kFb1iQpyYQzYVSbRBsy8TBC0qbvN2O176uW0RyS-VFTJeGiPoPyLULu83lofIUuqwFXbE6xIxozd7Omh6QNAS5tGCs0NB5SgsKN6XayIUvgssoSVcfVgBh7PDawrvEu3YA59LISsJegWBZIG3eqKHAiD2r7w=w603-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Club Boudoir"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/guh4lZzNGgBsN96Rc9GTOJC2jT2ZlA4ZIp7kXzzYD7OaUx1G_uXErHH5-KtihiySR-n3YiHkVwvEapelKL9EE7w9p1bHh8cKO5u9XVVdzR8Pm55BRzL0EEzs0hAAZQTEsJ1wGnZs9410zaUF8PPnO9NmKtpfmg=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Roxy"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOEnMbArFcEIKkGRYtEMx5laUfL8OUo-2NUA1lA=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Myx"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOmH4UTlSvo3nYBTz86KMNkIgA6M85tbhbsaiYy=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Privy Ultra Lounge"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Iob8s91tfGEwHuEcFJ6SYY0san5BtPqAnaQOfRAj59o5yZsmG5U2yGQEC4VIB9s91t8GOkR4dmN8hcAWxuKMTHRIXuscXMaW9J49WepxOaVhmC2F6mZa67CKCSLzE4zW3Ytk0T6GY4uJ8m63IXBJCuV_u0_Vtw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Smoke Shack"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMCcmpLuUJ9FYgtdHfdOlFnUTUET8Pj8poq5f6i=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="UG Reincarnated"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNx14zKWxkOGN8e-j5hZtSjZnslw0zUYzy_mBXH=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bakstage"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/8PzfdBVy7Gf6unarIfMne2pvXJA51SNKu5DD_BhzfOV9aCSfwqzvR4zCGPPqUS7Cgus_22wAUP9xj8Xg7GkMPVwxhklpGdN0tj-NoTVQg0hmWSCOAFbaO-bpiIzYoyb3v7PIYbv35d6vIW47Xr4l0nXHjPqgVuU=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Black Lounge Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMFT1pKorqUDdnggS3evmjfywykeYooB6Izhoim=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Raize The Bar"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/FG-zUwpYnrFqJqSXSq_UKulNQjdCKM5K5lBf3ISTZ0Kl6qsyE6xFnyjeqLbcu-f4-R-VOuxVQVAhCqmMR3qXf12yC1oRmQAzcXekqGYi3AA3-gGGMnVeE2xP7ZKq7akPEsxf72TcttqnqjKp6wqxVXxJ21hobg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Afraa"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP5mNhRK7Di0JfiTSQLC3a19JHL5nMFOHu5KTj2=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Pour House"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/k_r-p5_wnSp-0AGaKdFlw0BzhQ6yuNcFDLR1JurxuuVOiJito4oU8de5fM4WPI3cAeZWVTO-L4uHpqR9Pdz9Hx_KS-3WFR-hjy-ElJIY5I5gjYKaLNBTpQUFCc8qdAU3WXRQanALFYxDzGGKVBBffg0gRljEzg=w408-h223-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Shisha Bar Exchange"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/66kO-pd7huWGKk1t_8VjQ3zvYQTRCO1sz3jNHstIhbHnsCWvg1eKhU0msGnzWcp1y6_WkKq8Ltev6Ihcxabb6esXvtAk81grGSKxfj7KbuxagC_6EHOWROiizeTbY-eMWkc6rwWMBiqg30AxqU0SMH8tNGyniLU=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="What's In d Name"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/B8go2OSbu4ftb_VANbN121bLXYC_yJgfh_5dnIw3QuGUbG_j-mNWJ-4OngnDR67PGdZ5ZsA8C5o_QQgGt0Sxl-jUJ9FBet65VikmROvaMnKCK_qzwC-Ac4fVP9Dj_oYmkclkfiYSt4Fm2b3ASNvhIx4VkFcr_sk=w408-h318-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="M Bar And Kitchen"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/9Jr-H8WqwoH2dVC4gMRy8uhOXOpjF0957Zgf_IAvqUKYB-2BFKdRw3dnOOpFNVfr4EkkSHOfvGjrbrkFikTQYRaA-ha0Ka9MKaBXSLiRMJWY3hLEHt8ZluX3uzImUnjJ_-Zc5mOUBw6Y9QL_wpbfCrwyzTp5mls=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Xrong Place"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/NMeKkDSCQa9lotAml923Ukvp34tI7Jn4VkDdlKiashAKnJ9hKhq3DZbDFhrEYOfh3Jm92YXBkPBOoP769ar1s6_NMeJgPKHcAkqtNI_DEd5cgWnvvxSVe59iN7CN4N8eizBjARIe7aHUVOmrKOas3N_N9SbZ7Zc=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bluzz"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM6xmm8eXxFZHDWNAe9KAcDEhBMDWButeX0gXHL=w408-h200-k-no-pi-14.933861-ya169.5-ro0-fo100").error(R.drawable.nightlife).into(img);}
    else if(namee=="Urban Desi"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/P5Iv-dtRi6rZMiky-wJcGs0GomLKIO029VVwVTDIMnoqaGzgI5q7G5U0fV7_-xslVpZ8o6NJb5Pe-HoS9xiFxqLSZq9Z2HtM7iP1z19ei4v6HzqorC22Qnpy7sLwpBY6dzIV-XYubK97urJHjBPhi61xau9fdw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Masque Lounge & Bar"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/ZIjHOAIkKa6QlsQ803i3zVGFG-LWRepnkSuD0PH3wbfXkpRYbL9c6xInzCk-HqdxUfyOwHuAKtYxw1Y0DZRkiTlg450Je4wCJX0Q8TYk6BV4Ftniy1sOGAnIy0hkH-Mrr9nqSkHaOrBPYQh3h7FQ1yti4XllXbo=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Oval Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM4HzcNh6Vd3fcADf4_dD9n-bGF_EJaNm0XIHW_=w408-h293-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Chilis Kolkata"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMRhEyI0eP_kgRG1U3raO7yTGR_v5d0r3bQ-pEs=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Sam's Pub"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/8d1MvZDTZg3Us68o9fs-BZxDR5Whmeav03h6f2ZX_yVfEInrJe2vo2lgmftYCBLVGh3za9JG9Y0JQHo9WAE4E7O4BLV9ZWb_YcayGdDfnctcVGIOGTNrjBZw4toAanQwv5qhQfS-GGMYiWZkivN-b8AUHZ0Hgw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Illusion lounge"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/02hNcZINpbZiRskD6FFYAvp9RZYquGFnryBrmoYwSoVcyli9jVjiBjdPkWI_m9G2I29KWtuFv46t1_n6kyst1OrhoZbcv63LzKPtgDexOn48B72oeIutcFJ7CMPuUPnykfHF200pd8S5MJOu00-mkXT1VD8-kg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Blue Nile"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/3BAdxapvcHebfjiyr2YLr1qFmrIkTS6yxZ909GqQG3pNqulip6NAXadMMGU2GdrY-vLYHqbJUKsrFIHKoRQm0Uc-UsnJheC_zAsEybOGLot0BkegGgcDgrbbBczijUjR6XSZKm-8Ay1fvMkv9AbVsG1J6POELOU=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="10 DOWNING STREET"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/1elqQIoh4xQn5-HIo5VAxmc3wEUoLuiavqO3BkKRx2I6ZF6wF9dRKZIghv52tpuxtn6AGmyQM5duqcAeh_6jl_StOEoabWA5s0I4SDy2y3Tb50G5n5w4cOQJVUspMv8ZGwniqzIe5zLwyegoEhpRYkO2ei1Y4bg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Irish House"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPlPvIs6KKXdUsQKvU1id7Znk13xuVCnRKKTx6M=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Go Where"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/pM170_1IDV5GRLsmhXrd2g2hRZliPVR-j9QCNCIM5DEPHTK_0NFxuQAdo0Hk1bKlhiUqbfT6lpVfM4JoETa6_KJQqdOJqNBucOGkbtGkinG0X6LzsHNnVeGQuBht7ZSepYxeH7BUNQhCZ3rnFAsHpGhSX2wcdME=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Badshah Bar & Restaurant"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/8Z8xFodb9Pf5wU57wrBUIyus4R-K7mg6_lZ_EOa6QEsPuo9JsSycQH2AR7ttMJzihev1_t_ks8egz4_txsH1SpAILXCpkUOW5LveCiglYNYaXiugmDw3JGnhovcSf_9vDOdXaB8f4-avkaS6L85lsD49lVq56oE=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Sagar Bar & Restaurant"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/vNHvv4R9hQjYCEs_ELxTbPvNTiXS50hUQCkfiWpxtjtADyAJGI0CmksaK7l-tdgKsFknvTIIBJRmP_GkH1B-oZrjozFR8deDE9szltJIuViW6UC9uE2LSZ3AwyuRnX9bB-LKfl8J1N1JFoZzreIjBFErgZx0PQ=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="WILSON'S"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNGnsELB2hcy9OL-p6XepSZdZ0DDzNLXBau3z4v=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Café Montecarlo"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOyV00XZ01hQhMOg_Ko98T_wgfZIRV6Yy4XemVT=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Wall Street Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNL_fyZ6CcaSt0ejWYrfoZo1aQekHsjDrKvX1-c=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Damurs Bar and Restaurant"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/gCoqPeQbU0Ahzg-UXi2QrC9qvqvZ2DX654zzh2X666JsGZsokrNrsLeF6s0Fa-X_xcaFhmmL2L-a-NbOALCbkAqX0AykGLJcsVjgYp6s4w_FD3ln5D3kj0j8-ORTdOI5Riddad1r0UKaWtsKOt8uGNof44R4Ww=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Ozora"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMh7Y9Bu82FUdBTYuG4sAndzOPYijImgozv3gSv=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Nirvana"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/owOcsopT5YDkQ4GcoRmUAD6M4glJJZDE3EopvbqvYR9WYNR-DNztfafyHVj1QSBYbNPXWqdpq8Jn164hlIp12Ov7H8sX8SItGjEk40MVsu_5B_PE7opJ8j_WeDvUougVEmaBZq_xnlvBVf5kbJJdYisAPrI1DQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Big Ben"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/KHnePqdr_HSd88DAoEo-deiTiGQyPKKDhWJGA2D2v0Y23CqACGkkSxOVRpO8EcsEinF6sKKjGqNtLe6Q6y2-PnpqU49d3SnSbjAqem5MO2waCkfHHvQ71F880sMfyshKe0PNCZMVLWuu6RF-X1Eam0FlShtakA=w578-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Scrapyard"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNknWoH0TbEoibT7E7ybRrGI5aRLFObB1jH6cIg=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Opium Bar And Restaurant"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOEyuRP_wHgl5ZrOuA5k0ibcmiZ1DVQwMoYbYza=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Mocambo Restaurant & Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNpVs-GD1YAfu_ALQDBL5CpIL1R0WwwMqZP8ITC=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="OlyPub"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/0VQ2PmRHbyPkxPYtaDooo-YZs4j-KsapR5etoMs3_CRrzDFDoPDT2iyO7dMUyU0me17JEnJ9RdCl3j2mtRZWXI2ksxpALW2-DmJsUuNKywQ4HrecM7jyOsUHS-OBOLD5AWuv4-87IlAw-Sao5fkKKlv1bFjCZg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Country Roads Micro Brewery And Restaurant"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/fzLs8fQL8SX2w5ckC6d5qp_kLqLhk0kKh_EbkObcAK5yGWsDfAbzhub04ylpBQbNMdozz6AypFMFIHlOYFvHKvql2jKlW4cF5nKTeqJcHGEhvYxzm32vCA50oJIJFkt1gt5jnvuXuw9vWBhtO4o1i_Gng9-fTQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Drunken Monkey (O2 Hotel)"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMXKq4LCVkkxIlSIVyIkLPeaLyYZvg-wL8CYRc9=w408-h244-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="On The Rockz"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/BHYI_4GpiOaaLgTQB-_XIFM6o0N40f-fNQi7vD1BnRLgXqppFlh5pKVxpWCFsaIV5VbCw7rYX6rylAQjW8KTBMi6vPUVKxQMUHG3dWGYOAV8UrOQ8Rc60J8N-uqkCqJcE3Qc0JsaokVB6bluOPZWccAo5RwQXQk=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="H2O Resto Pub"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/0FqNW_pHUcItj4gUBJOTT3lR63A6Ks5djgpvDIWIBNYL7BfcZZH9t-_Kr5q3zZIV3Zv4bKlxlfGv-wzrXUf57CGE1MBUTW9mP1iQcQjWXrIISk9_yGDKWKfLxMz1DkFUfPNAwLUQuY2EEzKbgD835vsApNgotnA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Beer Republic"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/KYB7vWLpvVlFH7Q8Q52p2nFoHHLTooUDSnw_hNcxQ-iA01V7oVuCFcl6jc4FM8eI1zyRnElur6zgxJpyQx-_P64tkS5lEtK1aUFxRkDAZIxlU_HqDQ5rC8DPtsEzTujpfn0z1gCvfbAxgL9kpahQSiCKQY-Qgw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="One Sports Lounge"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/1YbOk0VVOfxRAclKXeCnqxgJNJ74MUCXorfuSh5moETXcT-q9uC5bQD5DBNL9cC0A2yGrzSoiIhWmTXqFaWyRqdJokcCEMhWPNLhwroGkf7wP4T2UkzpNzYdRPHmmfIK3wOQwC7cA6zHAPXknkO18g46ynKLTg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Tandoor Park"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMV6f9AV3f901xiwL0g5Jepfwn84ROtlMvBEAPU=w408-h274-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Titos"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/zu9-XJ3Rut8-J-qh5J9WO58eIkQIFIw-H2yfTBkYjhiL0rQ4M1d3YXYrxfsN4MKf3GOL93ZxOIcoMIuhUvtjEt4S36LFLkjLRGM8XDI2wph_oc0gnuQo40n29FFhuShZ34xig2HeZn8bPYbw2ZmkYl4gXRJxJQ=w408-h214-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hing"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNMaLGjBqBYcYZ992Va__FO2SOXfuAzsA4lNus=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Rocks"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNJS2xfE626FIbEF8q6RufIbYjksp2g2WpLJ9Is=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="High Street Bar"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/2r2lVF5YSKZLZJmRn57My6JjKb_KWsXm8T5HmwXtcnDYxjk6-Jsia1MVlT4fNykW9RZdrJrnQgDseygn358zZIFvKSE900pP5ENlM9upc2wB9FI21Im0L-sWP7ph6rRV0PRGCexBlqBb8ikN2SkaHVl8BuNu9A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Evergreen Bar & Restaurant"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/XQVp6HV01ZOguZpqLrjaSDqte9Z1rZQ14KbMpMoEjAzGkfG2u-HkxFOC6uVIXrnaB6XTjAlVmrD0tpJpDQmJnfMU54ot-ohpI8UzU_Gm8LHOzDJR9qwacZAIuB4Totu5xNs8Zv_v1vsqB_mAZidBSaer8mAZnA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Moulin Rouge"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/RsEf6e3q3dIxQmsQ-7xoMX-aKMp0LSg9gqSjDHwpHhcUFj_Np7YZSkcWmF8v7mRaDqAGvYtgOPm5Qy4D12MkDstmcPXL6_Be1UgXc7XrrU_o_z9Q65dS_GK3RBeRJP9mdz1Hrb5A2qj2bnKOfdZ-y8yDYf_fY-A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Addiction Bar & Restaurant"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/g4TQglSU-iMHx9zd9Lh9cwyt25Ynluq9MwZbym1PWn2YNQqBxrScPV9psoEXrln9_TdXxe5YeHwjz4VuXCvnGxY7zfc26r5psAQqOyYKQRfFn9gzfnwr-rDNO2DrdpB2VOMZZXljUPID_HK01BmDi9F0dUoF0Q=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Preach"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/rVfYefLABKvD6duCjrJQ1Wbt05Ggpfxya_kA6yR6OQRUQrnS_B52B8m1PlbET7U7kU0D8DYCmBhmJeTVqOs8YsdR7FwE_HSBZIVJ5L9J0U-wt3o1jmG3tcq93E4osoAAX29DCBOueXG6IK6O-aVhrTYw1cq1QiI=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="A Step Up"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM-wg_8TpeH7rWz8QGJRsBuX8vrhZuc5XC7u88R=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bistro Y, Restro Pub"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/0DOPzoTu7oJPCyq7De_r7vYd6qw7bjoHy9wD0UamBg6XOOdMkGL12kFoct_E4YsfselVwzg08yAjciN5nDauXp3_2C_H87GlbVDHkeFIicX5mLEJ-t_-_CXfaDInZPLT_mmwM5r-ZEWpUdhbfAD4pIkxBgofrG0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Shack Lounge"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/-Ju6bIk2Nki5W78Qf8JZu606wGfuJ7nG0brPPr1-R8h3_zFU8pxGpSaz9LsSTgIO5aFPDUAaZWmg4BMRe65MG22U_2sl0cBua7ltPXorE6QxS_PGAulbvRwJLTc1-SZ1fQ6-gfDSpckfQ6R8CbuLqCmUWjsHHg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Swastik Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/LYpiYYLeSRjYrTTtAJusVdMrkO7d3-wYPn0tq4N5EHsUfMQansyR1NBfc_03A2Vy9WlVXFNWKelpnkMLD4QRRprkUAJZADC3sLhKHX3e0GkZRQ-9-7l8BAuDR9pTPGH6Ykr09ouI5aN_E34DUqWnDRMHBmqSZc0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Zion Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/F_5auTYGQTkazRSRYhVmZTnzUcc-HKwF-QynUM4XfkrI5DQtJ0jUPyj5sOIyPjMR5T8mlZvFmHFFYoTwEJrxKySiEWMBoGralJ8fxcFv6RocJ0BkstF-sXitr4mklLUMPSEZqL1obHyMEpaEcuiyYlfe0uJduw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    return convertView;
    }
    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }

}