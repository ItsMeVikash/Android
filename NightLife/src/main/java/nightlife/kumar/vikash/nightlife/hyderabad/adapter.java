package nightlife.kumar.vikash.nightlife.hyderabad;

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

        if(parentName=="Klub Trinity"){
            address.setText("Malik Solitaire, 5th Floor,, Road Number 36, Jubilee Hills, Aditya Enclave, Venkatagiri, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("klubtrinity.com");phone.setText("090633 35555");
            time.setText("All_Days\t\n" +
                    "11AM–12:01AM");}

        else if(parentName=="10 Downing Street"){
            address.setText("Shop No. 10, 11, Ground Floor, Lifestyle Building, Begumpet, BD Colony, Kundanbagh Colony, Begumpet, Hyderabad, Telangana 500016");
            web.setText("10ds.in");phone.setText("040 6662 9323");
            time.setText("All_Days\t\n" +
                    "12–11PM");}
        else if(parentName=="Playboy Club"){
            address.setText("Novotel Hotel Rd, Izzathnagar, Kothaguda, Hyderabad, Telangana 500084");
            web.setText("playboyindia.co.in");phone.setText("080990 48048");
            time.setText("Monday\n"+"Closed\n"+"Other Days\n"+"8PM–2AM");}
        else if(parentName=="Block 22 Club"){
            address.setText("Hitex Exhibition Centre,Hitech City Road, Kothaguda, Hyderabad, Telangana 500084");
            web.setText("Unavailable");phone.setText("098855 00779");
            time.setText("All_Days\t\n" +
                    "5PM–12AM");}
        else if(parentName=="Fat Pigeon - Bar Hop"){
            address.setText("1335/A, Rd Number 45, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("facebook.com");phone.setText("091006 66101");
            time.setText("All_Days\n"+"12–10:30PM");}
        else if(parentName=="Over The Moon"){
            address.setText("8th Floor, Daspalla Hotel, Road No. 37, Beside Bajaj Electronics, Jubilee Hills, CBI Colony, Jubilee Hills, Hyderabad, Telangana 500081");
            web.setText("overthemoon.in");phone.setText("070326 86862");
            time.setText("All_Days\t\n" +
                    "7PM–12AM");}
        else if(parentName=="Air Cube"){
            address.setText("5th Floor, Sai Vamshi Towers, Road Number 36, Jubilee Hills, Aditya Enclave, Venkatagiri, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("liveinstyle.com");phone.setText("090141 05811");
            time.setText("All_Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Komatose"){
            address.setText("Inside Holiday Inn, Deloitte Road, Wipro Circle, Nanakramguda, Gachibowli, Madhava Reddy Colony, Gachibowli, Hyderabad, Telangana 500008");
            web.setText("curryhousefoods.com");phone.setText("099897 33127");
            time.setText("All_Days\t\n" +
                    "12–11PM");}
        else if(parentName=="Pier 33"){
            address.setText("Road No: 46, Beside Durgam Cheruvu, Opp BR Ambedkar Open University, Jubliee Hills, Masthan Nagar, CBI Colony, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("Unavailable");phone.setText("040 3956 0655");
            time.setText("All_Days\t\n" +
                    "5PM–12:30AM");}
        else if(parentName=="Altitude Lounge Bar Hyderabad Marriott Hotel & Convention Centre"){
            address.setText("Hyderabad Marriott Hotel & Convention Centre, 8th Floor, Tank Bund, Central Hyderabad, Bhagyalaxmi Nagar, Kavadiguda, Hyderabad, Telangana 500080");
            web.setText("marriott.com");phone.setText("095055 08741");
            time.setText("All_Days\t\n" +
                    "5–11PM");}
        else if(parentName=="Spoil"){
            address.setText("8-3-293/82/A/70, 4th Floor, Anshu Colours Building, Road No. 1, Opposite Chiranjeevi Blood & Eye Bank, Jubilee Hills, Park View Enclave, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("facebook.com");phone.setText("087901 55588");
            time.setText("All_Days\t\n" +
                    "12–11:30PM");}
        else if(parentName=="The Sky Lounge"){
            address.setText("Level 11, Plot No. 15, 24, 25 & 26, Survey No. 64, Sector I, Huda Techno Enclave, Madhapur, HUDA Techno Enclave, HITEC City, Hyderabad, Telangana 500081");
            web.setText("hotelavasa.com");phone.setText("040 6728 2828");
            time.setText("All_Days\n"+"6PM–12AM");}
        else if(parentName=="Houz of Blues"){
            address.setText("67, Rd Number 1, Park View Enclave, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("Unavailable");phone.setText("091600 00716");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Aqua"){
            address.setText("22, Raj Bhawan Road, Somajiguda, Somajiguda, Hyderabad, Telangana 500082");
            web.setText("theparkhotels.com");phone.setText("040 2345 6789");
            time.setText("All_Days\t\n" +
                    "7AM–3AM");}
        else if(parentName=="Rendezvous"){
            address.setText("ISB Rd, Financial District, Nanakram Guda, Hyderabad, Telangana 500032");
            web.setText("liveinstyle.com");phone.setText("088975 61111");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Skyhy Terrace & Lounge"){
            address.setText("Floor No: 5 Sri Tirumala Platinum, Janardana Hills, P Janardhan Reddy Nagar, Gachibowli, Hyderabad, Telangana 500081");
            web.setText("skyhy.in");phone.setText("091000 89938");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Air Live, Jubilee Hills, Hyderabad"){
            address.setText("Above Jaguar Showroom, Road Number 36, Jubilee Hills, Hyderabad, Telangana 500034");
            web.setText("Unavailable");phone.setText("095333 76907");
            time.setText("All_Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="MOCHA BAR"){
            address.setText("Rd Number 13, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("mocha.co.in");phone.setText("040 3316 5274");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Drunkyard"){
            address.setText("2-48/P/21, Old Mumbai Hwy, Sri Shyam Nagar, Telecom Nagar Extension, Gachibowli, Hyderabad, Telangana 500081");
            web.setText("zoma.to");phone.setText("080089 23555");
            time.setText("All_Days\n"+"11AM–12AM");}
        else if(parentName=="Cuba Libre"){
            address.setText("Level - 5, GVK One mall, Road No: 1, Banjara Hills, Balapur Basthi, Banjara Hills, Hyderabad, Telangana 500034");
            web.setText("askpl.in");phone.setText("040 6776 7114");
            time.setText("All_Days\t\n" +
                    "2PM–11AM");}
        else if(parentName=="Slounge"){
            address.setText("Phase 2, Madhapur, Hyderabad, Telangana 500081");
            web.setText("lemontreehotels.com");phone.setText("040 4421 2121");
            time.setText("All_Days\t\n" +
                    "5:30–11PM");}
        else if(parentName=="Zyng"){
            address.setText("Chhota Anjaiah Nagar, Gachibowli, Hyderabad, Telangana 500032");
            web.setText("sarovarhotels.com");phone.setText("040 6769 6769");
            time.setText("All_Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Tease"){
            address.setText("1-10-147, Hotel Vivanta by Taj Begumpet, Mayuri Marg, Begumpet, Mayur Marg, Begumpet, Hyderabad, Telangana 500016");
            web.setText("vivanta.tajhotels.com");phone.setText("040 6725 2626");
            time.setText("All_Days\t\n" +
                    "5–11:45PM");}
        else if(parentName=="Tipsy Stories"){
            address.setText("8-2-293/82/A/472, Rd Number 36, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("facebook.com");phone.setText("099666 11197");
            time.setText("All_Days\t\n" +
                    "11:30AM–11:30PM");}
        else if(parentName=="Purple Hazee"){
            address.setText("Country Club, 1st Floor, Begumpet, Hyderabad, Begumpet, Central Hyderabad, Uma Nagar, Begumpet, Hyderabad, Telangana 500016");
            web.setText("Unavailable");phone.setText("098855 03222");
            time.setText("All_Days\n"+"11AM–1AM");}
        else if(parentName=="Sounds & Spirits"){
            address.setText("3rd Floor, Jyothi Elegance, Road No.36, Phase 1, Kavuri Hills ,Madhapur, Kavuri Hills Phase 1, Kavuri Hills, Madhapur, Hyderabad, Telangana 500033");
            web.setText("soundsandspirits.business.site");phone.setText("091000 55543");
            time.setText("All_Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="PlayBoy Beer Garden"){
            address.setText("Plot No: 265 G, Road No: 10, Jubilee Hills, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("Unavailable");phone.setText("081218 00066");
            time.setText("All_Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Glocal Junction"){
            address.setText("First Floor, Signature Towers, Opposite Botanical Garden, Kondapur Junction, HITEC City, Nandagiri Hills, Jubilee Hills, Hyderabad, Telangana 500084");
            web.setText("glocaljunction.com");phone.setText("088866 62600");
            time.setText("All_Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="MOB - Belgium Beer House"){
            address.setText("8-2-293/82/J-III/550-I, Rd Number 92, Film Nagar, Hyderabad, Telangana 500033");
            web.setText("facebook.com");phone.setText("040 3956 5307");
            time.setText("All_Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Beats Per Minute"){
            address.setText("Gowlidoddi Road, Gachibowli, Hyderabad, Telangana 500075");
            web.setText("Unavailable");phone.setText("099662 39143");
            time.setText("All_Days\t\n" +
                    "11AM–10:30PM");}
        else if(parentName=="SHARAAB"){
            address.setText("11-9-4A NH65 SBI Colony, Kothapet, Hyderabad, Laxmi Nagar Colony, Kothapet, Hyderabad, Telangana 500035");
            web.setText("business.google.com");phone.setText("040 4004 5321");
            time.setText("All_Days\t\n" +
                    "11AM–11:45PM");}
        else if(parentName=="Splash"){
            address.setText("HItech City Main Road, Mindspace, HUDA Techno Enclave, HITEC City, Hyderabad, Telangana 500081");
            web.setText("westinhyderabadmindspace.com");phone.setText("040 6767 6828");
            time.setText("All_Days\t\n" +
                    "10AM–10PM");}
        else if(parentName=="The Vue Lounge"){
            address.setText("5th Floor, Gamut Square, Road Number 12, Venkateswara Colony, Banjara Hills, Venkateswara Colony, Banjara Hills, Hyderabad, Telangana 500034");
            web.setText("Unavailable");phone.setText("040 6999 9881");
            time.setText("All_Days\n"+"9AM–1AM");}
        else if(parentName=="The Central Court Hotel"){
            address.setText("6-1-71, Beside HDFC Bank, Lakdikapul, Hyderabad, Telangana 500004");
            web.setText("thecentralcourt.com");phone.setText("040 2323 2323");
            time.setText("24*7");}
        else if(parentName=="Trishul Bar and Restaurant"){
            address.setText("Opposite Indian Oil Petrol Pump Main Road, Hanamkonda- Hyderabad Rd, Owaisi Nagar, Kamshetty Enclave, Akash Nagar, Amberpet, Hyderabad, Telangana 500013");
            web.setText("Unavailable");phone.setText("099593 00300");
            time.setText("All_Days\t\n" +
                    "10:30AM–11:30PM");}
        else if(parentName=="Unwind - Lounge Bar"){
            address.setText("House No. 6-3-563/31/1, Hotel NKM’s Grand, Banjara Hills Main Road, Erramanzil Colony, Khairatabad, Hyderabad, Telangana 500082");
            web.setText("nkmsgrand.com");phone.setText("040 3061 7181");
            time.setText("All_Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="The Pirate Brew"){
            address.setText("5th Floor, Empire Square, Road No. 36, Opposite P.Satyanarayan & Sons Jewellery, Jubilee Hills, Jawahar Colony, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("facebook.com");phone.setText("040 6444 6363");
            time.setText("All_Days\t\n" +
                    "12:30PM–12:30AM");}
        else if(parentName=="The Moonshine Project"){
            address.setText("385, Road Number 82, Film Nagar, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("Unavailable");phone.setText("091009 22708");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Madhushala Bar & Restaurant"){
            address.setText("6-3-1093, Raj Bhavan Rd, Lumbini Classic Apartment, Somajiguda, Hyderabad,, Telangana 500082, Raj Bhavan Road, Lumbini Classic Apartment, Somajiguda, Somajiguda, Hyderabad, Telangana 500082");
            web.setText("liveinstyle.com");phone.setText("040 6617 3637");
            time.setText("All_Days\n"+"12:30–11PM");}
        else if(parentName=="Bar One"){
            address.setText("Shop No.7-1-209/A,1st Floor, Ram Mirra Towers, Beside Satyam Theatre, Slate School Road, Ameerpet, Swathi Avenue, Ameerpet, Hyderabad, Telangana 500016");
            web.setText("liveinstyle.com");phone.setText("090009 74123");
            time.setText("All_Days\t\n" +
                    "12–10:30PM");}
        else if(parentName=="Bar Exchange"){
            address.setText("3rd Floor, Seventh Heaven Building, Road 10, Jubilee Hills, Gayatri Hills, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("barexchangehyd.com");phone.setText("040 6589 2233");
            time.setText("All_Days\t\n" +
                    "6PM–12AM");}
        else if(parentName=="Le Vantage CafeBar"){
            address.setText("195/A, Road Number 13, Jawahar Colony, Jubilee Hills, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("Unavailable");phone.setText("091211 91782");
            time.setText("All_Days\t\n" +
                    "8AM–11PM");}
        else if(parentName=="Harry's Pub"){
            address.setText("Lobby Level, Aditya Trade Centre, Sathyam Theatre Road, Ameerpet, Kumar Basti, Ameerpet, Hyderabad, Telangana 500016");
            web.setText("sarovarhotels.com");phone.setText("040 6678 8888");
            time.setText("All_Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Club8"){
            address.setText("House Block i, Greenlands Flyover, Kundanbagh, Begumpet, BD Colony, Kundanbagh Colony, Begumpet, Hyderabad, Telangana 500016");
            web.setText("Unavailable");phone.setText("Unavailable");
            time.setText("All_Days\t\n" +
                    "10AM–11PM");}
        else if(parentName=="Vertigo The High Life"){
            address.setText("5th Floor, Shiv Shakti Tower,Banjara Hills, Amudi Nagar, Bhola Nagar, Banjara Hills, Hyderabad, Telangana 500034");
            web.setText("Unavailable");phone.setText("099858 18517");
            time.setText("All_Days\t\n" +
                    "11AM–12:30AM");}
        else if(parentName=="Turning 21"){
            address.setText("Hyderabad, HUDA Techno Enclave, HITEC City, Hyderabad, Telangana 500081");
            web.setText("Unavailable");phone.setText("090325 90703");
            time.setText("All_Days\t\n" +
                    "4–11:55PM");}
        else if(parentName=="Amnesia - Lounge Bar"){
            address.setText("1102, 5th Floor 36, Jaya Chambers, Road Number 41, CBI Colony, Jubilee Hills, CBI Colony, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("amnesialoungebar.business.site");phone.setText("099669 98797");
            time.setText("All_Days\n"+"1PM–1AM");}
        else if(parentName=="Carbon"){
            address.setText("The Park Hotel, 22, Raj Bhavan Rd, Lumbini Classic Apartment, Somajiguda, Hyderabad, Telangana 500082");
            web.setText("theparkhotels.com");phone.setText("040 4499 0000");
            time.setText("Friday\t" +
                    "2PM–12AM\n" +
                    "Saturday\t" +
                    "4PM–12AM\n" +
                    "Sunday\t" +
                    "4PM–2AM\n" +
                    "Monday\t" +
                    "2PM–2AM\n" +
                    "Tuesday\t" +
                    "2PM–2AM\n" +
                    "Wednesday\t" +
                    "2PM–2AM\n" +
                    "Thursday\t" +
                    "2PM–2AM");}
        else if(parentName=="Best Western Ashoka"){
            address.setText("6-1-70, Lakdi-ka-pul, Ambedkar Colony, Khairatabad, Hyderabad, Telangana 500004");
            web.setText("bestwesternashoka.com");phone.setText("040 2323 0105");
            time.setText("24*7");}
        else if(parentName=="MRP The Dive Bar"){
            address.setText("R 3, 5th Floor, Zen Building, Plot 237, 238, Kavuri Hills, CBI Colony, Jubilee Hills, Hyderabad, Telangana 500033");
            web.setText("Unavailable");phone.setText("098850 79826");
            time.setText("All_Days\n"+"12PM–12AM");}
        else if(parentName=="Amaravathi Bar and Restaurant"){
            address.setText("Champapet Rd, BN Reddy Nagar, Saroor Nagar East, Champapet, BN Reddy Nagar, Saroor Nagar East, Saroornagar, Hyderabad, Telangana 500079");
            web.setText("liveinstyle.com");phone.setText("040 6451 0019");
            time.setText("All_Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Eagle Bar & Restaurant"){
            address.setText("Near HDFC Bank, Lakdikapul, Ambedkar Colony, Khairatabad, Hyderabad, Telangana 500004");
            web.setText("shreevenkateshwarahotels.com");phone.setText("040 2323 6871");
            time.setText("All_Days\t\n" +
                    "7AM–12AM");}
        else if(parentName=="Cloud 9"){
            address.setText("Motilal Nehru Nagar, Begumpet, Hyderabad, Telangana 500016");
            web.setText("Unavailable");phone.setText("093465 22203");
            time.setText("All_Days");}
        else if(parentName=="La La Land- Shuddh Desi Bar"){
            address.setText("2nd Floor, Cyber Edifice, Above Mathura Vilas, Greenland Colony, P Janardhan Reddy Nagar, Gachibowli, Rajiv gandhi Nagar, Gachibowli, Hyderabad, Telangana 500032");
            web.setText("Unavailable");phone.setText("089787 77022");
            time.setText("All_Days\t\n" +
                    "11:30AM–11:30PM");}
        else if(parentName=="Hashtag"){
            address.setText("Terrace Level, Phoenix Tower A, Opp Trident Hotel, Patrika Nagar, Hitech City, Patrika Nagar, HITEC City, Hyderabad, Telangana 500081");
            web.setText("Unavailable");phone.setText("098857 06978");
            time.setText("All_Days\t\n" +
                    "4:30–11:30PM");}
        else if(parentName=="Bars N Bowls"){
            address.setText("Near Q-city Beside State Bank of India Gachibowli, Gowlidoddy, Hyderabad, Telangana 500032");
            web.setText("Unavailable");phone.setText("040 6544 2727");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Juice Lounge, Himayatnagar"){
            address.setText("Shop No. F-1, Altoo`s A.M Trade Centre, MCH No.3-6-561,, Himayatnagar, Hyderabad, Telangana 500029");
            web.setText("juicelounge.in");phone.setText("099089 67444");
            time.setText("All_Days\t\n" +
                    "10AM–11:30PM");}
        else if(parentName=="Mix Bar"){
            address.setText("Hitech City Road, Mindspace, Vittal Rao Nagar, HITEC City, Hyderabad, Telangana 500081");
            web.setText("westinhyderabadmindspace.com");phone.setText("040 6767 6767");
            time.setText("All_Days\t\n" +
                    "10AM–10PM");}
        else if(parentName=="Plaza Premium Lounge"){
            address.setText("level E, International Departures, Rajiv Gandhi International Airport, After duty free near Board Gate 32 A/B, Shamshabad, Hyderabad, Telangana 501218");
            web.setText("plaza-network.com");phone.setText("040 6660 3727");
            time.setText("24*7");}

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
        if(namee=="Klub Trinity"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/FL78XRO1OdPivn5GObcglnRqYm3hEz2tgqQYo38C_qUrQzzJQNWVK0fP1yg4BdgqaH1fhHA2-3Qis3HUTTdjr7dYtegeVxdEzS6WVAPzQ7NAMP_ptE1ZvDuvu0ARhxs1ZYU-ZlEbhlnPmzWo8yYfXvdVMqwSvQ=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="10 Downing Street"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMTjBkD_CO1Kt5PxZlXOjgI7TV91NoBfh2KtrWM=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Playboy Club"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/9T8tBfQThooIsdXbqPopEx39FPCXtowZdGNB0-1jdWXTKn-5sfKkDoBpuzTCstamHrG-xlfc7t1bOxvxWxP0PtJkZaQUQOm0rHxnziLPD8b_mEZkwA31G1pejcep6Dylazo5tjDgAz5OrjZKYsAqide8GiV-Wz4=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Block 22 Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOcFKufRm8U2ZO-iiDhCh28tTUzD7AtzUe4Ga9M=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Fat Pigeon - Bar Hop"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/kEBtLptfw17Fzha09U2HByHOstWiJ0BYiUR5g7fsoX9AEjvlN3pVyrQf43ACKDwtQYDBBnX53FpGY2qJ82i_p6YMRqUNejDgSKAcXY8Yek9A2L7RDnYsNQI6g5PXsQG8dransxx3x8BEGCMr3x6QR2sHqPPlL_A=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Over The Moon"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPmqqhegUdXDIwTGqwAva-TAPjMN-8jdhOojoYR=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Air Cube"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM2CBPvvhBmJkBXg2IL6EPwM35T8f2CYbA3r6B8=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Komatose"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNFXvGvHB0KYrAhY7vPnK7AncfRHBd76WNyxAo7=w408-h252-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pier 33"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/6JhyQGVXVFWkWEj2DMnGn18L0Tn_7a_67AlNVkYjGt8LAkUHE5ETq4rwojUFMtzyhY6S8U1HcsVcHAQWEX8hfCCnB1E7TFhdg2ToLxjNs_EndCGbGEvFanUzePxnQXDYnOMvlqIFcknXDlYew29ovP6zYc6yTQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Altitude Lounge Bar Hyderabad Marriott Hotel & Convention Centre"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPWQJUe_yheUdsN56aoAtrVHECTfQBzMvRJAxUc=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Spoil"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPPiIfuiEqPClb2ufYu4lN4ZHf3AAihjUnvqtvw=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Sky Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipONW_goTkG_KQscER4wpRNlJkEjOaI1y84SJp6p=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Houz of Blues"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/wk4s0wJ5sX1wlvhxa4ADKlVYXPfUzVLfFwddjlyB7W57_uTjh3q_R1HUI9rlGYzuhOjckCoEX0HLOCuTJ6QKmX5uwzy4YUxHgYGfv2DUZWsOZfnUV6ZWoXZATEOnCj9Byi8x1A_hfqPH9Kc6dK2n8bvRy1RZgg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Aqua"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP9QMJeOZFKYBQC6znJbIL8DrgoCDUd0mQkOsAi=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Rendezvous"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNxCuh61Ik-gAn3y0tjMGLuzkAwMD1aZgENKIt6=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Skyhy Terrace & Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMTErWoO-qliaNf_jVxmHnHYNadIJYo1zhHix5v=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Air Live, Jubilee Hills, Hyderabad"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP8-d3q8wnRrJXidjDl4NB0fc89Izz88UVB-x-Y=w444-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="MOCHA BAR"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/mqbjeKVgtX1FpOeqfH-2LgnVUVsyh4FnXEuaaUyXA9CAoNhEOx_EJClymzIU-4HOD_xTS-GuSii3Ep7ToZbEYLndRRJjvmFeuZ4fw5fkzjxfpac1Oob--1LE7lQx0iyPQtjqpHWTVJER-mp9m3jAkEN18MibH_A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Drunkyard"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/UhQm0ZUJFm4Rz_0is0oz-bS0sFynmlNICy4IEbfxf0qGaChH0RpkSTtLZT6_jFLZ7JLEYfrD1K5E2XnDsXLr5GbvXPXdM3Vmzfv69VL7IExowCEKBGqEZ2btf_Tfc6sBHNiUf18LfI7iUBowmAOWfh9XlB0a1qs=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cuba Libre"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPIleSC3slLDQle5Hk-JbweBtxs_tOrCTu3F8JP=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Slounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMZSgfWhz4XboAepSzwGXc8_vGjWTpruAhPAgJ1=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Zyng"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMgjYTO-qqUsUwfCQ5O557aZ3Dw_2kqBe2Fdy4=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tease"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/gTgtQy43K3DUrWCd3fAiYXOqkYqsiY46Tfsl3R29BNSH_5pJhKD95OC3qHQou6QDBE5zmewGE44WXCdLvmGZ2nKT0MbbdX5sW2p2SCfw_TnuyiUfbEOBQte2T3QmTt-r3veKxqK1gkq8xzRd1dEW6dpUqUT0uh0=w409-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tipsy Stories"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/NzbScIFWtK_sd7oc6tC88c5G0Cll_yNU-D_W1sDgHXt3PpwfDle-Lh3hX8xKTwiRAosBUogfJU90VI5DH28N9uahz5Xgtjva4GKK09-MAssKVhiXms24wNmf5410YTkWdELHj43jIx-4YLC2I6pzfW7qQy-j9CI=w408-h509-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Purple Hazee"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/pTAbLDs9z30_t5mS_Tt2Ja1f1VGbMYESw_FirUBrjZCfjzrBUJPbJFUFZCSqNK22aKQc2wvkGlwy4Swlgxk6zsFcI-StcHA7k_JZcQqJ6jrYJHMQkiL9pBkH1yByI8i15SKzTsrZWeV40NXtHzYor3iPFs5ikHI=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sounds & Spirits"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPfcV_VuQpb_4dkre5MSQJbN6LbRdvw7l8YjJBo=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="PlayBoy Beer Garden"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMth2pIdqUT3SKQObQ4-emKHcsteldY5TK3ob3f=w408-h204-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Glocal Junction"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/g-0ILlAyvr8KhjYrWxtbwuwHxg4bRt7A5ywi61XIVg4RcAgV3OXovrdqqgz2kJbvzsv4CGfzuP65AlpbBzQrUDdI_cIuZOu3IP1iXZ69DuYHDBV3UUFrrBrh1CetAW9nrNpTYl5vP8RhFJgd-rkZeXQ8vZ_la_8=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="MOB - Belgium Beer House"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNdqEfMdamvfaRlUeOD7n0PaoyL8dMX5BsREgoU=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Beats Per Minute"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPSH0WWL8Kqx97ROy1OBEM2gBPmmwxAuvXUGiDu=w408-h278-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="SHARAAB"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNy8LgrXbZUuE2rIDHuY1g0OQCNFAKz29Mz1fud=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Splash"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOX3N_Ilj1rsKwTXpFwyUa5pTIQJN8Zh9aBUfw6=w408-h212-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Vue Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/lIGBJOb3xeyrzjNo9-zUDZ3RlU04hngiIxqPrd-RLlxx3ruBceaJdlVfyDcec3JzNwenQJIuKGbUuG3I48JhLvJrQiRNMtIvXxOzJb8sJY0gWVZZtBJMZ693lklKuwIuWjk7CV7gtEEiqZJRjKHZQOx2UzPBhQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Central Court Hotel"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/4PocqJN0og8MuEZgsnO7MukOC0ju0IPG3ShQF_JgwCxmyLD3K_O4vaMYRWB5qJe1p6sH2TB6qXFvpTj80vuvpKAmq7ZK392DO8mzWsNwo_aBhnFJvJxrrLfqDsX7Vm9VfeMAyAAYUM3nyWVBk74oOjlzqdiizs0=w408-h403-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Trishul Bar and Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNpSu-1s-c7lZhm9csJudwvgpytBImFyn4KTNox=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Unwind - Lounge Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMcM-4d-1Y_Ifa521NO3Dg9ctTtgokquV-3Pxeq=w408-h282-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Pirate Brew"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM-Tmx7_kbHMpPUJV3YzUOELSiWxJTtP2OlXczt=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Moonshine Project"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNwRq-_naAFOPnyuz7i_Kz3akMt6Cyme66h3CQP=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Madhushala Bar & Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOskeR9EeJs8xVjfF4EbueLuMjE0Y-EK19KyGOW=w408-h727-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bar One"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/B-RJRP9nNOaIx9teO4XocTTHn3h2N2qpij-4Fm6-zixj4XP-P-LRvUD7Taj1BBvq-RxytY9YA8rFtVI92BwFlduRi6GE8K-YOSdjs4tvJooHEW2NpYgk50zgCm01bFArHkaXR32xmohiMkr5Fs5444ag4VuVOEo=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bar Exchange"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/-X-biVWghPStdMmuu2u7qfqkAYIxBpBLwisy2K0LKCns6wnUAa2-eiBgqF2tOHUzOaKZtmnLNthenrdvK9Ey2J7b-MAjhhJqHrpHY9izUZHshXrXl3Vpn77nIXtsNIx1caK5pDEnlcLwWpuizRQSdSmHP1Uua9o=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Le Vantage CafeBar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPTCOFaggrszw-8o8OCcoVYJr3XjaKI4hw5Kg2P=w408-h262-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Harry's Pub"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMB-uot4NBLamnVutKwVE1EQCJq6vSfRaRL0ApY=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club8"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/rvDX5rmzZAthzVK5-opsmpXjIWVUcikn0I3WMmZkalq6g0xeqTbAjuqXDvWDtB-BtoNOWVSCLmNyYRkoGstRKs_KTTWWLyNERkm6Z6LeajtHPpC0NuVhCWCjhyTVa7QoXUj4ZMx_yfrghU7mZisseD0kXtXr_A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Vertigo The High Life"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOBJnBQcYyfJGsTf813EqCuPuIiLjmuiyJnHpB6=w408-h407-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Turning 21"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/euho8_61ry3YhkHN2KcRyo4HXeyYw9FiHIRexH-l65vDmorT7kSTJuYCbqHoKqtF051fhg-X3wWJbaikqIQ7Eot2DE-ACbXfjU6m4B70TeMOkzmcjWQuXmpqccRDbsqg1NzWtkSsRtf7_rQ3j8lfv7PHKvD6Lw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Amnesia - Lounge Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/BA6U0_e3C_t2z5B0UBl_NTt5NNMudCbTEU3QkrK0tVnEM_lzY5o-mCNX-MaIQOh6SfcQchF367E0XaOokXjqTmN1wjOtwq5WHWCFNvuU0VNSzkmQwj-WcXR5n15xsO2VYAxgz_Y1IZw7cmhePKghk5C_wWS_mA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Carbon"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOF4_QcY6zm9w6THiIb4O7QPWrml0ojkNFx2zpi=w408-h612-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Best Western Ashoka"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNKhfVgsJyNE7zltEEpLq8HEwjDWbSSG5zIqq0k=w408-h213-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="MRP The Dive Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN1EMOaen59YR_XMOfnQmgkQKUGD0BJZ6EUPry-=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Amaravathi Bar and Restaurant"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/5rDw47auIhb6eGyde5F-PnYdxfJ22apm3vpPFhxT_t5BvvxZa8w6DvXDCSAxRQdBRPy6v6Wb8bnP9UCAd3ADNby-YQjpUqI4g-9O_QUa9gJP3WnGJqdmDLBKDK2hvmuZdoo_Q-SR0NwyMmVUqsZPTRdux5wioA=w408-h448-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Eagle Bar & Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMNqqiLglTAvRjsHz8c6d62Wu5KoZ7Y7SiTKIGf=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cloud 9"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMHruGlIgMst34216rsmrEfcQLa2kLuLF0BJubY=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="La La Land- Shuddh Desi Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOxBecD6l0JfSC0NuyGVtKfHnWlEcD-4wMd-kO1=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hashtag"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/xjK3QgE5IczgX2t07ziypIT-7tAjM76Ki5EittKNYrZCpg71Ps7oBOEYWyosSzMdZS-MHVxb2wudHZSW4U75r5qfLC4EupUq1hQQUqkb_09gD3euR1869-oY2mk_B3WDXWYZi8VpHtWGEeNvpfPsi86qaclWLrI=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bars N Bowls"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMU6ZeaKqEO_2GNnMuCiIBIYww1_TajMqc5ph6c=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Juice Lounge, Himayatnagar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNyNvOFjICchya77yxB1lSoSWQZAWJ_mERwaEMA=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Mix Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPrtATTU1nPf0RUgFk31qBBAp4SkQuwfFMhGtPP=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Plaza Premium Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMAqMuXn5b2GztG2ynZNFXxkhSK18mwAR-B7UF_=w408-h229-k-no").error(R.drawable.nightlife).into(img);}

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