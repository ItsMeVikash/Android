package nightlife.kumar.vikash.nightlife.jaipur;

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
        if(parentName=="Blackout"){
            address.setText("D38A, 8th & 9th Floor, Golden Oak Hotel, Landmark Building, Ahinsa Circle, C Scheme, Panch Batti, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
            web.setText("thedoghousesportsbareatery.club");phone.setText("099281 16900");
            time.setText("All_Days\n"+"2PM–2AM");}
       else if(parentName=="Bar Palladio Jaipur"){
        address.setText("Kanota Bagh, Narain Singh Road, Rambagh, Jaipur, Rajasthan 302004");
        web.setText("bar-palladio.com");phone.setText("0141 256 5556");
        time.setText("All_Days\t\n" +
                "6–11PM");}
    else if(parentName=="3Ds Restro Lounge"){
        address.setText("A2, 8th & 9th Floor, UDB Corporate Tower, Near Jawahar Circle, Malviya Nagar, Sector 8, Malviya Nagar, Jaipur, Rajasthan 302017");
        web.setText("Unavailable");phone.setText("091660 85000");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="100% ROCK"){
        address.setText("Hotel Shikha, R-14, Yudhishthir Marg, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
        web.setText("hotelshikha.com");phone.setText("095711 11456");
        time.setText("All_Days\t\n" +
                "11AM–12AM");}
    else if(parentName=="Duplay"){
        address.setText("Khasa Kothi Swimming Pool, MI Road, Gopalbari, Jaipur, Rajasthan 302001");
        web.setText("liveinstyle.com");phone.setText("098285 00981");
        time.setText("Saturday & Friday\t\n" +
                "9:30PM–1AM\n"+"Other Days\n"+"Closed");}
    else if(parentName=="F Bar And Lounge"){
        address.setText("5th floor, Hotel Golden Tulip, MI Road, Opposite GPO, Panch Batti, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
        web.setText("fbarjaipur.in");phone.setText("0141 426 8730");
        time.setText("All_Days\t\n" +
                "2PM–3AM");}
    else if(parentName=="Lounge-18"){
        address.setText("Ashram Marg, Near Jawahar Circle, Jai Jawan-2, Choti Chopad, Chandrakala Colony, Durgapura, Jaipur, Rajasthan 302015");
        web.setText("marriott.com");phone.setText("0141 456 7777");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="House of People"){
        address.setText("A1, Sehkar Marg, Bais Godam, Jyothi Nagar, Lalkothi, Jaipur, Rajasthan 302005");
        web.setText("hotellasvegasjaipur.com");phone.setText("0141 339 1479");
        time.setText("All_Days\t\n" +
                "11AM–1AM");}
    else if(parentName=="District 9 Lounge"){
        address.setText("E-20, 2nd Floor,Prem Plaza, Girdhar Marg, Opposite Reliance Fresh, Malviya Nagar, Siddharth Nagar, Sector 9, Malviya Nagar, Jaipur, Rajasthan 302017");
        web.setText("Unavailable");phone.setText("0141 255 3903");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="Club Naila"){
        address.setText("Moti Doongri Road, Anand Puri, Gangawal Park, Adarsh Nagar, Jaipur, Rajasthan 302007");
        web.setText("Unavailable");phone.setText("078230 24851");
        time.setText("All_Days\n"+"6PM–1AM");}
    else if(parentName=="Scorpian- A Pub City"){
        address.setText("SUNNY PARADISE 6TH FLOOR , TONK ROAD NEAR KAMAL AND COMPANY, New Light Colony, Bajaj Nagar, Jaipur, Rajasthan 302001");
        web.setText("liveinstyle.com");phone.setText("098286 66638");
        time.setText("All_Days\t\n" +
                "12PM–2AM");}
    else if(parentName=="The Dragon Club (T.D.C.)"){
        address.setText("K-12, Aarcade Mall, 8th Floor, Malviya Marg, C Scheme, Ashok Nagar, Panch Batti, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
        web.setText("Unavailable");phone.setText("095099 66625");
        time.setText("All_Days\t\n" +
                "5PM–2AM");}
    else if(parentName=="DND Bar and Lounge"){
        address.setText("SINDHI CAMP BUS STAND, Shri Ram Colony, Sindhi Camp, Jaipur, Rajasthan 302001");
        web.setText("liveinstyle.com");phone.setText("098283 32994");
        time.setText("All_Days\t\n" +
                "2PM–2AM");}
    else if(parentName=="Sky Lounge"){
        address.setText("Raja Park, Jaipur, Rajasthan 302004");
        web.setText("hotelkingscorner.com");phone.setText("096020 20111");
        time.setText("All_Days\n"+"5–11:30PM");}
    else if(parentName=="WTF Sports Cafe & Bar"){
        address.setText("3rd Floor, Man Upasana Plaza, C-44, Sardar Patel Rd, C Scheme, Ashok Nagar, Panch Batti, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
        web.setText("thehotelierz.com");phone.setText("0141 411 4049");
        time.setText("All_Days\t\n" +
                "11AM–1AM");}
    else if(parentName=="Drop Zone The Bar"){
        address.setText("14/82 & 83, Niti Nagar, Opposite Capt Amit Bhardwaj Petrol Pump, Malviya Nagar, Sector 12, Malviya Nagar, Jaipur, Rajasthan 302017");
        web.setText("liveinstyle.com");phone.setText("088240 84579");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="60ML Disc & Lounge"){
        address.setText("HOTEL ROCKLAND ,263, Frontier Colony, Adarsh Nagar, Frontier Colony, Adarsh Nagar, Jaipur, Rajasthan 302004");
        web.setText("Unavailable");phone.setText("0141 261 1347");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Bottles & Chimney Bar"){
        address.setText("Gayatri Marg, Sen Colony, Bani Park, Jaipur, Rajasthan 302016");
        web.setText("traditionalheritagehaveli.com");phone.setText("0141 400 3300");
        time.setText("Unknown");}
    else if(parentName=="Steam"){
        address.setText("Rambagh Palace, Bhawani Singh Rd, Rambagh, Rambagh, Jaipur, Rajasthan 302005");
        web.setText("taj.tajhotels.com");phone.setText("0141 238 5700");
        time.setText("All_Days\t\n" +
                "6–11PM");}
    else if(parentName=="Mayaa Lounge"){
        address.setText("m.i.Road Opp g.p.o, Panch Batti, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
        web.setText("mayagroupjaipur.com");phone.setText("098290 67776");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="Blue Ice"){
        address.setText("F-399, Pareek College Rd, Kanti Nagar, Bani Park, Jaipur, Rajasthan 302012");
        web.setText("liveinstyle.com");phone.setText("074278 88320");
        time.setText("All_Days\t\n" +
                "6–11PM");}
    else if(parentName=="Lounge"){
        address.setText("Khasa Kothi Swimming Pool, MI Road, Gopalbari, Jaipur, Rajasthan 302004");
        web.setText("liveinstyle.com");phone.setText("1800 108 0333");
        time.setText("\t\n" +
                "Open 24 hours");}
    else if(parentName=="Playa By Zone"){
        address.setText("Madho Singh Rd, Sindhi Colony, Bani Park, Jaipur, Rajasthan 302016");
        web.setText("zonebythepark.com");phone.setText("0141 423 1000");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Jaipour Cafe & Bar"){
        address.setText("Devraj Niwas, Khasa Kothi Crossing, Barodia Scheme, Gopalbari, Jaipur, Rajasthan 302016");
        web.setText("jaipour.com");phone.setText("090012 77666");
        time.setText("All_Days\t\n" +
                "6PM–1AM");}
    else if(parentName=="Sukh Suvidha"){
        address.setText("E-19, Gautam Marg, Vaishali Nagar, Block E, Vaishali Nagar, Jaipur, Rajasthan 302021");
        web.setText("Unavailable");phone.setText("083859 10938");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Holywood Pub and Lounge"){
        address.setText("SB-54, Sawai Mansingh Rd, Bapu Nagar, Jaipur, Rajasthan 302007");
        web.setText("facebook.com");phone.setText("070739 77712");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Le Gourmet Lounge"){
        address.setText("3, Airport Plaza, Tonk Road, Chandrakala Colony, Mata colony, Jaipur, Rajasthan 302 018");
        web.setText("fernhotels.com");phone.setText("0141 412 1212");
        time.setText("All_Days\t\n" +
                "10AM–10PM");}
    else if(parentName=="Cloud Seven"){
        address.setText("Opp. Central Polo Victory Road, Sindhi Camp, Jaipur, Rajasthan 302006");
        web.setText("Unavailable");phone.setText("091665 57777");
        time.setText("All_Days\t\n" +
                "7PM–12AM");}
    else if(parentName=="Beer Bar"){
        address.setText("MI Road, Panch Batti, C Scheme, Ashok Nagar, Jaipur, Rajasthan 302001");
        web.setText("Unavailable");phone.setText("098290 12345");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Kabana Resto Bar"){
        address.setText("Ground Floor, Prabha Tower, Nursery Circle, Vaishali Nagar, Nemi Nagar Extension, Block A, Vaishali Nagar, Jaipur, Rajasthan 302021");
        web.setText("liveinstyle.com");phone.setText("098871 45319");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Hotel Acacia Inn(Xing Bar)"){
        address.setText("218, M I Road, Opposite All India Radio Station, Near Ganpati Plaza, Sindhi Camp, Jaipur, Rajasthan 302001");
        web.setText("acaciainn.in");phone.setText("0141 237 0063");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}
    else if(parentName=="Asteria"){
        address.setText("7th Floor, B2, Tonk Rd, Shopping Centre, Choti Chopad, Sitabari, Durgapura, Jaipur, Rajasthan 302018");
        web.setText("Unavailable");phone.setText("081122 76592");
        time.setText("All_Days\t\n" +
                "1PM–2AM");}
    else if(parentName=="Firangi Paani Resto Bar"){
        address.setText("Near Hotel Mansarovar Palace, New Sanganer Road, Mansarovar, Ward 27, Mansarovar Sector 8, Mansarovar, Jaipur, Rajasthan 302020");
        web.setText("liveinstyle.com");phone.setText("088242 07759");
        time.setText("All_Days\t\n" +
                "11AM–11PM");}

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
        if(namee=="Blackout"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPq2-Ka4OQIcdVM2wYAbk7iLutGtWP5BBFU8V6W=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
       else if(namee=="Bar Palladio Jaipur"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM8b1ptELERUBRP5wYs_Id8AKbq9tout4GSEHRz=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="3Ds Restro Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO7Es_MyVUiFy3DHmE0nI-wDsF8AdSZsVeGngx_=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="100% ROCK"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMSeh1hFJDbrxQQf3JgzixIBWYAIGR8yE1Gf9Tr=w408-h259-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Duplay"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/9KBdRM3_1bKd9O1iv01paxyTkpik88QRxeGyEU75nz1CHry6kFuCrcTOL9l_Yer-yH9g5w8Y9snaF9koCcv7uTHXgQHl80TsbG9ky1KqRQXOXjlmujzU9yPuVVoWxXLQHRVLVjG3cCC4woEfOnRDmnHhFyp2UA=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="F Bar And Lounge"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/knyiTXW2huLtlueJbmTNVfnEDPAtFXiF7Wz7M_CIa6KWCbQaYdWo2m3FHTQBkVXEsT3jHx2qOLM_A9mD3-hjZQUaE2Z2fzF4syIqgoBrnj00BR6E7TZSIaYAg860p3tBYOH4KBmZHziEWWH29PYzfp069e9HqA=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Lounge-18"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOwfATmhrE_5Nq1raJlRsJk2ImKQKOdYwXNqQAh=w408-h406-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="House of People"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/uT9FsHQozfofZF71vrUY9Ov2W8pjvLubI_wBlji8iCxPhGOQILH-3zAqGsCvT1Oo3_-ft0lm7H1DT6A3xmIUsItLgZt0vqZM7IYwF4gQ2TjLAA2Do1JNWqlo2ENq797GosiaB0IrbXjhzuzaOBDn--ddNplP2cE=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="District 9 Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNGqc0krrg5vIuJO2oxeZeOI_rShrCFfyN-SLwH=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Club Naila"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/sRgJ7lxuJSACUn4tNuDtv5MrI1okyrO54pn0TfnrotxVlnVaGYvaxmIn6cUjHYsjGvcfDROKJGhL0bnaUPkxaULZnfwz9Yt9x0WRGDivmw-20P0uYgn0gNbp8WC5ZQql2bZazHZww-l4sNMf_J6lVtKF1SPDgA=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Scorpian- A Pub City"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOlwgxjbvFEFjxF4Gj_PsTiXH60Yr1xhOvv1vvq=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Dragon Club (T.D.C.)"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/M00hx3g69w1L3TvAYN3rJgg0oEoSMFKnWtHDNhMF_9EKCx19KVTdVZZeB85v-9wKxnvo3FM32pqTweTTsf9nK2zTTNWVUHiR-z1qHwMFBWU-gj2jAwk0YGctYG7xSVE2YTqLeuJECS3XdcaA1Gi3kl3PZNzQvQ=w408-h214-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="DND Bar and Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMHnYwBNaEAnSLu8OtFIym6yMbVJefh1Lpw0oqr=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Sky Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPRfHq5f83wcqZp8yy9VoVRH4_OfGM_YG1kCkS1=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="WTF Sports Cafe & Bar"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/_NvW5JZVz3FXhNr-xH_kSKjFhl8bX6tSEKp_7wWM1MLdGr0WBYN_iWDmwCQYSQXcy3VAI49j1eMKEx4x84C5mEsu89pxMlpYNXA5UlnGSCi3E_wNo4luQwgri1aJlWLTa7PyLcWn4sttwKyNVj18XAE7OGGmNQ=w519-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Drop Zone The Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNsjLdXfMQtldFQNF_rltn_FEGQlHIe8mc5xJcd=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="60ML Disc & Lounge"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/i4yslqaJpVXqrMIFqj0xcLXK7_iYUFC6LCjdwIAZk2eqlbvVja7iMT2SeLXqmUW9HQCoRbNIHSJKsik8ABK3SNcfcmnEZ3Y2q3iTfvEF3aNZpbu4OTNZHM65-yKHjHQM8g2D5g7heZjCxuhOdn2RHx1XIz9nhW4=w408-h656-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bottles & Chimney Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMspyR0HGf7bVb9JlQNiaScCWWifHAe-6dr2OJf=w408-h725-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Steam"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/Srp38fa8_3Tvazo8OBSFfI1Eljo8z5wlpsn60r1db_yB7nzhWa871ys2hZm3ivSIg0EKDbgk5QsXOrSPTlEjyjvfKSoJz4GdrJGs7HDXV50CCd8f0HJGVzNdsNrRckUViTBqgRrUuPOVAZM3z_sl1u_A6FX6eA=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Mayaa Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMdPgUSSSX_oxa0n9qO55CvVN8YqtflupHNm3t5=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Blue Ice"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNZMJbJhCrcdyEYpkbSF4IJ8OS7FwI6W7IMTdt7=w408-h725-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Lounge"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/7g20tGkXZ7-RXNLy4z2J5lpDwFifRs-pjVshN-xyUofsG8yzK7B-AXSlTf1vuMIy79X4ZLiM0YuR3qXfv9uCFfqwek9W6dx1YERGU1SA3Xkjj9wxJ2MVq1zCADVKk7DUPxJ_CbcYbX7zYDRDUVjradBHfRxvxA=w425-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Playa By Zone"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOLKzfF-xIqxzTEz38aTiOtOINw1Lq2lF8PcIly=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Jaipour Cafe & Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNuU3GjJHr4aV4q5gEpHYqwmA-iVOIHM-5vqHBR=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Sukh Suvidha"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOXnL4aqgka7krW7RXo9LZyTppsGczkFQZ_6YaC=w408-h204-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Holywood Pub and Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPf5UcKyHab79uHXIXIfNZf0tUBd82IF2jNthTw=w408-h407-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Le Gourmet Lounge"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/5S6uwnbhmxU3ZLmZRg0zBpqtiKeXLWyYlaoAG1Xzcd3IYqPGHGj41ksRJY5NgO_pzh4l_dBMxX6XQYFCd3uzpNV_NqEYZ5i3UbwKn6Xgkwba8760Xy_dt9MN7LCaR9EMZKSs6qUSCZrZAeH098i9GFkWSEvLejQ=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Cloud Seven"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOPDDAHpuYzT1d601HfXnNt2GwxHKymZcXyPUJF=w408-h404-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Beer Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOTQwz-0O7I-Lj4uwGD5qE8-pM1kSyVvjl6AWEw=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Kabana Resto Bar"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/QmLu8-Mi2ic-XSdsXg6n9xpvjzjN_1UwaANfm4HbsSpRhsZd6SvYXggmply_x3C9hkEuqvO8CbIiOzdQkYMpDop7WkwzZkDxLqPvZ4N8WFbxW_eg6cH9RIFy-RMnqrpZRekH_LJBALkoUqtmWRrZDF7ZWa2ViA=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hotel Acacia Inn(Xing Bar)"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO4Bp-ZXYwoctlNyXxASSkBt_fNuMrXAc_RArGr=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Asteria"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOxBttbz91F2058BJ6eVz76AF3v5WIkvdC-JTSK=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Firangi Paani Resto Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP_UTDBtEAe3pdV7z1-CUEAiHHop03Fa_QKRnbl=w408-h519-k-no").error(R.drawable.nightlife).into(img);}

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