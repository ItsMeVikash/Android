package nightlife.kumar.vikash.nightlife.mumbai;

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
        if(parentName=="Trilogy NightClub"){
            address.setText("969, Juhu Tara Rd, Airport Area, Juhu, Airport Area, Juhu, Mumbai, Maharashtra 400049");
            web.setText("trilogy.in");phone.setText("022 2646 9689");
            time.setText("Wednesday, Thrusday & Friday\n"+"\t\n" +
                    "10PM–3AM\n"+"Other day\t"+"Closed");}
        else if(parentName=="Drop"){
            address.setText("No.G1/B, Krystal Building, Below Hakkasan, Waterfield Road, Bandra West, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("dropindia.in");phone.setText("022 4229 6000");
            time.setText("Monday & Tuesday\n"+"Closed\n"+"All Other Days\t\n" +
                    "10PM–1:30AM");}
        else if(parentName=="XXO"){
            address.setText("Level 37, The St. Regis Mumbai, 462, Senapati Bapat Marg, Lower Parel, Mumbai, Maharashtra 400013");
            web.setText("stregismumbai.com");phone.setText("022 6162 8422");
            time.setText("Wednesday,Friday & Saturday"+"\t\n" +
                    "7PM–3AM\n"+"Other Days Closed");}
        else if(parentName=="LIV"){
            address.setText("Plot No. 145, Kala Ghoda, Mahatma Gandhi Road, Kala Ghoda, Fort, Mumbai, Maharashtra 400001");
            web.setText("Unavailable");phone.setText("022 6634 6246");
            time.setText("All_Days\t\n" +
                    "Open 24 hours");}
        else if(parentName=="Tryst"){
            address.setText("Phoenix Mill Compound, High Street Phoenix, Senapati Bapat Marg, Lower Parel West, Lower Parel, Mumbai, Maharashtra 400013");
            web.setText("trystmumbai.com");phone.setText("022 6661 4366");
            time.setText("Sunday,Monday & Tuesday\n"+"Closed\n"+"Other_Days\t\n" +
                    "10PM–1:30AM");}
        else if(parentName=="Baroke"){
            address.setText("Krishna Palace Hotel, Nana Chowk, Zoroastrian Colony, Grant Road, Grant Road, Mumbai, Maharashtra 400007");
            web.setText("krishnapalaceresidency.com");phone.setText("022 6629 3333");
            time.setText("All_Days\t\n" +
                    "8PM–1AM");}
        else if(parentName=="Playboy Club"){
            address.setText("Birla Centurion, Gate 2, PB Marg, Worli, Century Mills, Lower Parel, Mumbai, Maharashtra 400014");
            web.setText("playboyclub.co.in");phone.setText("084548 81609");
            time.setText("Monday & Tuesday\n"+"Closed\n"+"All_Other_Days\n"+"7PM–1:30AM");}
        else if(parentName=="Kitty Su"){
            address.setText("Sahar Airport Road, Navpada, Marol, Andheri East, Mumbai, Maharashtra 400059");
            web.setText("thelalit.com");phone.setText("022 6104 3553");
            time.setText("Unknown");}
        else if(parentName=="Club Sirkus"){
            address.setText("Hotel Sahara Star, Service Rd, Navpada, Chhatrapati Shivaji International Airport Area, Vile Parle, Mumbai, Maharashtra 400099");
            web.setText("clubsirkus.com");phone.setText("090041 88188");
            time.setText("Sunday,Monday & Tuesday\n"+"Closed\n"+"Other_Days\t\n" +
                    "10PM–3AM");}
        else if(parentName=="Club Alibii"){
            address.setText("Ground Floor, 41/44, Mon Repos, Minoo Desai Marg, Colaba, Apollo Bandar, Colaba, Mumbai, Maharashtra 400005");
            web.setText("Unavailable");phone.setText("081085 09866");
            time.setText("Only Wednesday, Friday & Saturday\n"+"24 hours\n"+"rest all days\n"+"Closed");}
        else if(parentName=="China House Lounge"){
            address.setText("Kalina, Santacruz East, Grand Hyatt, Near Western Express Highway, Siddharath Nagar, Vakola, Santacruz East, Mumbai, Maharashtra 400055");
            web.setText("mumbai.grand.hyatt.com");phone.setText("022 4942 5364");
            time.setText("All_Days\t\n" +
                    "12–2AM\n" +
                    "5–11PM");}
        else if(parentName=="Novotel-Premier Lounge"){
            address.setText("Hotel Novotel Mumbai, Balraj Sahni Road, Juhu, Juhu, Mumbai, Maharashtra 400049");
            web.setText("novotel.com");phone.setText("022 6693 4444");
            time.setText("All_Days\t\n" +
                    "2AM–1:30AM");}
        else if(parentName=="AER"){
            address.setText("1/136, 34th Floor, Dr. E. Moses Road, Worli, Gandhi Nagar, Upper Worli, Worli, Mumbai, Maharashtra 400018");
            web.setText("fourseasons.com");phone.setText("022 2481 8444");
            time.setText("All_Days\t\n" +
                    "5PM–2AM");}
        else if(parentName=="Shiro"){
            address.setText("Bombay Dyeing Mill Compound, Pandurang Budhkar Marg, Worli, Kamagar Nagar Number 1, Lower Parel, Mumbai, Maharashtra 400025");
            web.setText("liveinstyle.com");phone.setText("090660 25278");
            time.setText("All_Days\t\n" +
                    "12:30PM–1AM");}
        else if(parentName=="The Bar Stock Exchange"){
            address.setText("1st Floor, Club House, Equinox Business Park, Off Bandra Kurla Complex, LBS Marg, Near Peninsula Technopark, Ambedkar Nagar, Kurla West, Kurla, Mumbai, Maharashtra 400051");
            web.setText("thebarstockexchange.com");phone.setText("084540 58000");
            time.setText("All_Days\t\n" +
                    "12PM–1:30AM");}
        else if(parentName=="Colaba Social"){
            address.setText("24, Ground Floor, B.K.Boman Behram Marg, Apollo Bunder, Colaba, Apollo Bandar, Colaba, Mumbai, Maharashtra 400001");
            web.setText("socialoffline.in");phone.setText("080970 05123");
            time.setText("All_Days\t\n" +
                    "9AM–1AM");}
        else if(parentName=="Hawaiian Shack"){
            address.setText("Plot No: 339, 16th Road, Nr Linking Road, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("hawaiianshackbar.com");phone.setText("099672 11694");
            time.setText("All_Day\t\n" +
                    "7PM–1:30AMs");}
        else if(parentName=="Bombay Cocktail Bar"){
            address.setText("B-38, Veera Desai Industrial Estate Road, Veera Desai Industrial Estate, Andheri West, Veera Desai Industrial Estate, Andheri West, Mumbai, Maharashtra 400047");
            web.setText("Unavailable");phone.setText("083838 38340");
            time.setText("All_Days\t\n" +
                    "7PM–2AM");}
        else if(parentName=="Wink"){
            address.setText("Vivanta by Taj - President, 90, Cuffe Parade, Ganesh Murti Nagar, Cuffe Parade, Mumbai, Maharashtra 400005");
            web.setText("vivanta.tajhotels.com");phone.setText("022 6665 0808");
            time.setText("All_Days\t\n" +
                    "6PM–1AM");}
        else if(parentName=="The Irish House"){
            address.setText("Level 1, Fun Republic, Off New Link Road, Industrial Area, Andheri West, Mumbai, Maharashtra 400053");
            web.setText("theirishhouse.in");phone.setText("088796 60085");
            time.setText("All_Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Opa! Bar & Cafe"){
            address.setText("Peninsula Grand Hotel,, Lokmanya Tilak Nagar, Sakinaka, Lokmanya Tilak Nagar, Sakinaka, Mumbai, Maharashtra 400072");
            web.setText("peninsulagrand.com");phone.setText("022 3015 1670");
            time.setText("All_Days\t\n" +
                    "4PM–1:30AM");}
        else if(parentName=="The Drawing Room"){
            address.setText("The St. Regis Mumbai, 462, Senapati Bapat Marg, Lower Parel, Mumbai, Maharashtra 400013");
            web.setText("stregismumbai.com");phone.setText("022 6162 8000");
            time.setText("All_Days\t\n" +
                    "3:30–7PM");}
        else if(parentName=="Social"){
            address.setText("Rohan Plaza, 5th Rd, Ram Krishna Nagar, Khar West, Mumbai, Maharashtra 400052");
            web.setText("socialoffline.in");phone.setText("022 6522 6324");
            time.setText("All_Days\t\n" +
                    "9AM–1AM");}
        else if(parentName=="Tote On The Turf"){
            address.setText("Gate No. 5 & 6, Mahalaxmi Race Course, Royal Western India Turf Club, Mahalakshmi, Mumbai, Maharashtra 400034");
            web.setText("thetote.in");phone.setText("022 6157 7777");
            time.setText("All_Days\t\n" +
                    "12–3PM\n" +
                    "7PM–12AM");}
        else if(parentName=="Hoppipola"){
            address.setText("1st Floor, Todi Building, Todi Mill Compound, Opposite Kamala Mills Lower, Parel West Lower Parel, BDD Chawl, Lower Parel, Lower Parel, Mumbai, Maharashtra 400013");
            web.setText("Unavailable");phone.setText("082860 89723");
            time.setText("All_Days\n"+"3PM–1AM");}
        else if(parentName=="WE VIP Premium Nightclub And Restro Bar"){
            address.setText("Plot No 50, 7th Floor, Deluxe House, Veera Desai Road, Off New Link Road, Andheri (W), Veera Desai Industrial Estate, Andheri West, Mumbai, Maharashtra 400053");
            web.setText("clubwevip.com");phone.setText("082865 03523");
            time.setText("All_Days\t\n" +
                    "7PM–4AM");}
        else if(parentName=="Ark"){
            address.setText("CTS 215, Opposite Sangam BIG Cinemas, Hanuman Nagar, Andheri East, Mumbai, Maharashtra 400059");
            web.setText("liveinstyle.com");phone.setText("096990 26680");
            time.setText("All_Days\t\n" +
                    "7PM–1AM");}
        else if(parentName=="The Elbo Room"){
            address.setText("No. 500, Sant Kutir Apartments, Khar Linking Road, Behind Vijay, Sales Showroom, Khar, Bandra West, Mumbai, Maharashtra 400052");
            web.setText("theelboroom.in");phone.setText("022 2648 3316");
            time.setText("All_Days\t\n" +
                    "12PM–1:30AM");}
        else if(parentName=="The Bar Stock Exchange"){
            address.setText("Shop No. 28, Ground Floor, Meera Co-Operating Housing Society, Oshiwara, Link Road, Andheri West, Anand Nagar, Andheri West, Mumbai, Maharashtra 400058");
            web.setText("liveinstyle.com");phone.setText("Unknown");
            time.setText("All_Days\t\n" +
                    "6PM–1:30AM");}
        else if(parentName=="Eau Bar"){
            address.setText("The Oberoi, Ramnath Goenka Marg, Nariman Point, Mumbai, Maharashtra 400021");
            web.setText("oberoihotels.com");phone.setText("022 6632 5757");
            time.setText("All_Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Escobar"){
            address.setText("199, 4th Floor, VN Sphere Mall, Linking Road, Bandra West, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("liveinstyle.com");phone.setText("022 2640 7070");
            time.setText("All_Days\t\n" +
                    "7:30PM–1:30AM");}
        else if(parentName=="Geoffrey's"){
            address.setText("No. 29, Marine Plaza Hotel, Marine Drive, Churchgate, Churchgate, Mumbai, Maharashtra 400020");
            web.setText("hotelmarineplaza.com");phone.setText("022 2285 1212");
            time.setText("All_Days\t\n" +
                    "11AM–1:30AM");}
        else if(parentName=="Cavalry"){
            address.setText("2nd Floor,Picasso Commercial Complex, Hira Panna Mall, Adi Shankaracharya Marg, Hiranandani Gardens, Powai, MHADA Colony 19, Powai, Mumbai, Maharashtra 400076");
            web.setText("cavalrythelounge.com");phone.setText("074000 84430");
            time.setText("All_Days\t\n" +
                    "3PM–1:30AM");}
        else if(parentName=="Rock Bottom"){
            address.setText("462, AB Nair Road, Juhu, Juhu, Mumbai, Maharashtra 400049");
            web.setText("rameehotels.com");phone.setText("022 6693 5555");
            time.setText("All_Days\t\n" +
                    "9AM–4AM");}
        else if(parentName=="Cafe Zoe"){
            address.setText("Mathurdas Mills Compound, N.M Joshi Marg, Lower Parel, Lower Parel, Mumbai, Maharashtra 400013");
            web.setText("cafezoe.in");phone.setText("022 2490 2065");
            time.setText("All_Day\t\n" +
                    "7:30AM–1AMs");}
        else if(parentName=="The Little Door"){
            address.setText("Ground Floor, Plot B31, Shree Siddhivanayak Plaza, Opp. Citi Mall, Off New Link Road, Andheri West, Veera Desai Industrial Estate, Andheri West, Mumbai, Maharashtra 400053");
            web.setText("the-little-door.business.site");phone.setText("098999 28776");
            time.setText("All_Days\t\n" +
                    "5PM–1:30AM");}
        else if(parentName=="The Bombay Bronx"){
            address.setText("101, Hub Town, Akriti Sky Bay, Bhulabhai Desai Road, Breach Candy, Cumballa Hill, Breach Candy, Cumballa Hill, Mumbai, Maharashtra 400026");
            web.setText("thebombaybronx.wordpress.com");phone.setText("077100 44666");
            time.setText("All_Days\t\n" +
                    "12PM–1:30AM");}
        else if(parentName=="Copa"){
            address.setText("Anna Building, JVPD 13th Road, Opp. Juhu Gymkhana, Vile Parle, Chand Society, Vithal Nagar, Juhu, Mumbai, Maharashtra 400049");
            web.setText("Unavailable");phone.setText("098206 67766");
            time.setText("All_Days\t\n" +
                    "6:30PM–1:30AM");}
        else if(parentName=="Tonic"){
            address.setText("Ground Floor, Dr E Moses Road, Famous Studio Lane, Mahalakshmi West, Worli, Mumbai, Maharashtra 400011");
            web.setText("auriga.net.in");phone.setText("091679 99239");
            time.setText("All_Days\t\n" +
                    "4PM–1AM");}
        else if(parentName=="Raasta Bombay"){
            address.setText("4th Floor, Rohan Plaza, Road no. 5, Ram Krishan Nagar, Khar, Ram Krishna Nagar, Khar West, Mumbai, Maharashtra 400052");
            web.setText("Unavailable");phone.setText("022 3312 6123");
            time.setText("All_Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Gadda Da Vida"){
            address.setText("Lobby level,Novotel, Balraj Sahani Marg, Juhu Beach, Juhu, Mumbai, Maharashtra 400049");
            web.setText("novotel.com");phone.setText("022 6693 4444");
            time.setText("All_Days\t\n" +
                    "2PM–1AM");}
        else if(parentName=="Atrium Lounge"){
            address.setText("Taj Lands End, Bandstand Fort, BJ Road, Vidyavihar Society, Bandra West, Mount Mary, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("taj.tajhotels.com");phone.setText("022 6668 1234");
            time.setText("All_Days\t\n" +
                    "8AM–12:30PM");}
        else if(parentName=="Razzberry Rhinoceros"){
            address.setText("Hotel Bawa Continental, Juhu Tara Road, Uditi Tarang Housing Colony, Airport Area, Juhu, Uditi Tarang Housing Colony, Juhu Tara, Juhu, Mumbai, Maharashtra 400049");
            web.setText("business.site");phone.setText("074004 02604");
            time.setText("All_Days\t\n" +
                    "12PM–1:30AM");}
        else if(parentName=="Pharaoh Pub & Lounge"){
            address.setText("183 - 184, Shahid Bhagat Singh Road, Opposite Gurudwara, S B Singh Colony, J B Nagar, Andheri East, S B Singh Colony, J B Nagar, Andheri East, Mumbai, Maharashtra 400059");
            web.setText("pharaohlounge.in");phone.setText("090045 65252");
            time.setText("All_Days\t\n" +
                    "12PM–1:30AM");}
        else if(parentName=="Bar Stock Exchange"){
            address.setText("3rd Floor, Kenilworth Building, Above KFC, Off Linking Road, Bandra West, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("thebarstockexchange.com");phone.setText("022 3312 6174");
            time.setText("All_Days\t\n" +
                    "5PM–2:30AM");}
        else if(parentName=="Thyme"){
            address.setText("1st Floor, Huma Mall, Lal Bahadur Shastri Marg, Ambedkar Nagar, Kanjurmarg West, Bhandup West, Ambedkar Nagar, Kanjurmarg West, Bhandup West, Mumbai, Maharashtra 400078");
            web.setText("thymebistro.in");phone.setText("080802 80000");
            time.setText("All_Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Monkey Bar"){
            address.setText("Summerville, 14th & 33rd Road, Ground Floor, Linking Road, Bandra West, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("Unavailable");phone.setText("022 2600 5215");
            time.setText("All_Days\t\n" +
                    "6PM–1AM");}
        else if(parentName=="The Angrezi Pub"){
            address.setText("14, Hilton Towers, Palm Beach Road, Sector 11, CBD Belapur, Sector 15, CBD Belapur, Navi Mumbai, Maharashtra 400001");
            web.setText("facebook.com");phone.setText("091584 43344");
            time.setText("All_Days\t\n" +
                    "6PM–1AM\n"+"Monday\n"+"Closed");}
        else if(parentName=="Baraesti"){
            address.setText("5th Floor, Konarkshram Building, Behind Everest Building, Tardeo, Janata Nagar, Tardeo, Mumbai, Maharashtra 400034");
            web.setText("liveinstyle.com");phone.setText("022 3351 1991");
            time.setText("All_Days\t\n" +
                    "5:30PM–12:30AM");}
        else if(parentName=="145 Bandra"){
            address.setText("1st Floor, HSBC Building, Pali Road, Off. Near Golds Gym, Turner Road, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("liveinstyle.com");phone.setText("096996 74185");
            time.setText("All_Days\t\n" +
                    "9AM–1:30AM");}
        else if(parentName=="Coral Lounge"){
            address.setText("Plot 10, Nirmal Vyapar Kendra, Sector-17, Behind Hotel Navaratna, Vashi, Sector 17, Vashi, Navi Mumbai, Maharashtra 400703");
            web.setText("Unavailable");phone.setText("022 2789 0904");
            time.setText("All_Days");}
        else if(parentName=="The Lobby Lounge"){
            address.setText("The Leela Mumbai, Sahar, Andheri East, Mariyyman Nagar, Greater Indra Nagar, Andheri East, Mumbai, Maharashtra 400059");
            web.setText("Unavailable");phone.setText("022 6691 1234");
            time.setText("All_Days\t\n" +
                    "Open 24 hours");}
        else if(parentName=="A Bar"){
            address.setText("2 & 3B Near Chinmayand Ashram, Powai, Kailash Nagar, Mayur Nagar, Morarji Nagar, Powai, Mumbai, Maharashtra 400087");
            web.setText("marriott.com");phone.setText("022 6692 7570");
            time.setText("All_Days\t\n" +
                    "11AM–12:30AM");}
        else if(parentName=="THE LOCAL"){
            address.setText("Plot No. 111-A, Currimjee Building, MG Road, Opposite Bombay University, Fort, Kala Ghoda, Fort, Mumbai, Maharashtra 400023");
            web.setText("facebook.com");phone.setText("099302 44326");
            time.setText("All_Day\t\n" +
                    "6PM–1AMs");}
        else if(parentName=="Krishna Palace Hotel"){
            address.setText("96/98, Sleater Road, Nana Chowk, Grant Road, Mumbai, Maharashtra 400007");
            web.setText("krishnapalaceresidency.com");phone.setText("022 6629 3333");
            time.setText("All_Days\n"+"24*7");}
        else if(parentName=="Rude"){
            address.setText("Link House, Chincholi Bunder, New Link Rd, Rajan Pada, Mindspace, Malad West, Mumbai, Maharashtra 400064");
            web.setText("rudelounge.co.in");phone.setText("077388 92804");
            time.setText("All_Days\t\n" +
                    "11:30AM–12:30AM");}
        else if(parentName=="PDT Mumbai"){
            address.setText("Kamala Mills, OSS Compound, Pandurang Budhkar Marg, Lower Parel, Lower Parel, Mumbai, Maharashtra 400013");
            web.setText("pdtmumbai.com");phone.setText("080827 38738");
            time.setText("All_Days\t\n" +
                    "6PM–1:30AM\n"+"Monday\n"+"closed");}
        else if(parentName=="Quarter House"){
            address.setText("Green Lawns Building, Kapad Bazar Rd, HP Petrol Pump Lane ,, Opp Mahim Cinema, Mahim West, Mahim, Mumbai, Maharashtra 400016");
            web.setText("Unavailable");phone.setText("022 2445 2517");
            time.setText("All_Days\t\n" +
                    "12PM–1:30AM");}
        else if(parentName=="InterContinental Hotels & Resorts"){
            address.setText("135, B Road, InterContinental Marine Drive, Church Gate, Churchgate, Mumbai, Maharashtra 400020");
            web.setText("ihg.com");phone.setText("022 3987 9999");
            time.setText("Unknown");}
        else if(parentName=="Rude Lounge - Powai"){
            address.setText("Supreme Business Park, B-Wing, 8th Floor, Hiranandani Gardens, Powai, Hiranandani Gardens, Powai, Mumbai, Maharashtra 400076");
            web.setText("rudelounge.co.in");phone.setText("077388 92802");
            time.setText("All_Days\t\n" +
                    "11:30AM–12:30AM");}
        else if(parentName=="Glocal Junction Andheri"){
            address.setText("Plot No B-57, Ground & First Floor, Morya Bluemoon Building, New Link Road, Andheri West, Veera Desai Industrial Estate, Andheri West, Mumbai, Maharashtra 400053");
            web.setText("glocaljunction.com");phone.setText("082919 31537");
            time.setText("All_Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="True Tramm Trunk"){
            address.setText("First Floor, Juhu Vaishali Shopping Complex ,VL Mehta Road , J.V.P.D. Scheme, Next To Options Showroom Juhu, Yamuna Nagar, Nehru Nagar, Airport Area, Juhu, Mumbai, Maharashtra 400049");
            web.setText("Unavailable");phone.setText("022 3371 5958");
            time.setText("All_Days\t\n" +
                    "6:30PM–1:30AM");}
        else if(parentName=="Doolally Taproom - Bandra"){
            address.setText("Shop No. 5 & 6, Geleki, ONGC colony, Bandra Reclamation, Bandra West, HIG Colony, Nityanand Nagar, A Block BKC, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("doolally.in");phone.setText("074001 71684");
            time.setText("All_Days\n"+"7AM–1AM");}
        else if(parentName=="House Of Mirabella"){
            address.setText("Mirabella, Remi BizCourt, Opposite Supreme Chambers, Veera Desai Road, Mumbai,, Maharashtra, Industrial Area, Andheri West, Mumbai, Maharashtra 400102");
            web.setText("Unavailable");phone.setText("082918 24029");
            time.setText("All_Days\t\n" +
                    "11AM–1:30AM");}
        else if(parentName=="Casa Vito"){
            address.setText("3rd Floor, Link Corner Building, Above Starbucks, KFC Lane, Off Linking Road, Bandra West, Bandra West, Mumbai, Maharashtra 400050");
            web.setText("facebook.com");phone.setText("099673 90695");
            time.setText("All_Days\t\n" +
                    "3PM–1:30AM");}
        else if(parentName=="Ghetto Pub"){
            address.setText("30B, Bhulabhai Desai Marg, Breach Candy, Mahalaxmi Temple, Opp Tirupati Apartments, Mahalaxmi West, Breach Candy, Cumballa Hill, Mumbai, Maharashtra 400026");
            web.setText("atoz.city");phone.setText("022 2353 8418");
            time.setText("All_Days\t\n" +
                    "12–3:30PM\n" +
                    "6PM–1AM");}
        else if(parentName=="Zenzibu Da Sky Lounge"){
            address.setText("3RD FLOOR, SHUBHAM PALACE, COMMERCIAL WING, ABOVE HDFC BANK, NEAR D MART, SECTOR 15, KOPAR KHAIRANE, Sector 15, Kopar Khairane, Navi Mumbai, Maharashtra 400709");
            web.setText("zenzibu.com");phone.setText("022 6105 4597");
            time.setText("All_Days\t\n" +
                    "6AM–1:30AM");}
        else if(parentName=="Vikings"){
            address.setText("Level 14, Meridian Business Centre, 27A, Sunshine CHS, Sector 30A, Sanpada, Sector 30A, Sanpada, Navi Mumbai, Maharashtra 400705");
            web.setText("Unavailable");phone.setText("022 2781 6121");
            time.setText("All_Days\t\n" +
                    "11AM–4PM\n" +
                    "7–11PM");}
        else if(parentName=="Aqua"){
            address.setText("The Park, No.1, Sector 10, CBD Belapur, Sector 10, CBD Belapur, Navi Mumbai, Maharashtra 400614");
            web.setText("theparkhotels.com");phone.setText("022 6758 9000");
            time.setText("All_Day\t\n" +
                    "7–11:30PMs");}
        else if(parentName=="Pauva Deck"){
            address.setText("Shop No.1 Royal Residency Plot No.34, Sector 5, Kopar Khairane, Navi Mumbai, Maharashtra 400709");
            web.setText("Unavailable");phone.setText("077388 92811");
            time.setText("All_Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Sangeet Bar and Restaurant"){
            address.setText("Bank Of India Rd, Sector 22, Turbhe, Navi Mumbai, Maharashtra 400703");
            web.setText("Unavailable");phone.setText("079725 48453");
            time.setText("All_Days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Fusion Grill"){
            address.setText("Shop No. 13, Vindhya Commercial Complex, Opp. Bank of India, CBD सेक्टर 11, CBD बेलापुर, Sector 11, CBD Belapur, Navi Mumbai, Maharashtra 400614");
            web.setText("fusiongrillcbdbelapur.co.in");phone.setText("022 2756 4688");
            time.setText("All_Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="270 Degrees West"){
            address.setText("198, Haware Fantasia Commercial Park, Sector 30A, Vashi, Sector 30A, Sanpada, Navi Mumbai, Maharashtra 400705");
            web.setText("Unavailable");phone.setText("098330 44451");
            time.setText("All_Days\n"+"11:30AM–12:30AM");}

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
        if(namee=="Trilogy NightClub"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/cNhIUMqV4YIEgo_Z5giWqbjzP_gSMQJ9oVjnjohWwD1QKhPnsnd2ea-mSH2tEq3ZDL7kTC5h_3laSmjm7yLBfBN-pVSWe5VlFbVZ79N19tConKG0LLHJP1F8fJLSQKx1gHGTWCCRcpCj5HBGBnYwCn_lhhA9NA=w408-h202-k-no").error(R.drawable.nightlife).into(img);}
       else if(namee=="Drop"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMh35O-dUJ3SHQOhWjYImHZOo3PjtzJevhzQ7kc=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="XXO"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/xKISEbMGr1fLbDXbhdO8k0uDW8otKlSxSvYPsnW39Uwnaz_4kp09kxrG5neordzv8OXlgctFDr4iK0TM6e5fQ7vKXlbDgjSr5o8KQfuwI0TO2N3ugbbU8GjyjtdreGEscMgBro82m2IXRz4sCcxM5NwY4NmByfs=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="LIV"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Q0ye73UhqYloCx2IlyxviC97fsgJ0Lf3dt8SGk-FXW41XvVtBKyK6Fkysa9smSDq76eKWmnMYND9g_ZA7ZvalNGYKtommiQt7jTqy5fLWLWR3FQ8dyGO4RA1sK-9J8il-nWFY7DjycLRxttY9ehMZjwnCKU2wQ=w408-h204-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Tryst"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPcHrrUGH5eCTRfwcW07CwJpMrpZVcdYYlwAttA=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Baroke"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/1FZU0K10Din1NNDgo-6clj5fW0AviRmpENPnkc0DJU9UhykTk2uHCwXetT_Kvm49RyYk99Ma1CqVe-88jGkWRAIHu9HEg_LJvuvR7TuwaNkaAnb2CTOFwjKkSUvxLKNEGohRsSuHOtqTsS4oiTaP921RfzsQ1gI=w519-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Playboy Club"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP3NFn_u6Do1ziyZj6ukMljS0AB1iHZip9q4OpV=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Kitty Su"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNhSfCunagmn-lU88um2i-CnA-IUByuX9OfnLTH=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Club Sirkus"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/qEe8mePdEFwtO87Azx6d5a5W_qZR9Ri7QzuLyyHWPb4ieb4jVIbUEd_bSl2xPsvWOSPBao-jqWXYnnJNwEKpA9j2DLMMCBqffc7_cGz4RNMYFqhACSyhhqGWO6LK4xpWbFjkArpJDJp_LdvKYzMmeaGPnkLtNQ=w408-h251-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Club Alibii"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/78huGNCrq6nqx65fejD8sY7-wr0FbLQIio28jpK2fz005BWu45ptyjdxLxWsH8umfUthqB5EwFa8M_qol1aIFGLCsVqu3H4N33OXrlpEblxTws7Zda5beYcR13nFAn9JTj10eST-So-2C48MUAzgIyUGg6dqUHQ=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="China House Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNFQCYgvJq2mGjEOH2VyVTnFKHRqcqxL-WU3G61=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Novotel-Premier Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM5Qmtj7MZn_Bnk8EwmG5zlg4Iu0yCZls4IjWRp=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="AER"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMmiBE4i5xI1iU2n8ebpAiJ8bre3YCDX4APLdaj=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Shiro"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/2FuLoMn0z5iwF-YDZoejCxmz4sPcML_STZDjY6FSJIN2sY8b997yVljX7kxpT3MXwnhqC2pSJz5Zhq7WsHQx0Q2jWeB5RAhq5aSFrLukk5sjlyH5e7D1LipZBurjcm3WL81I6zKAAy7P8FmZK9Xs69PANeknRw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Bar Stock Exchange"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNhZi0UzmgiCEH9wUEpAaI9jNjKTwBx59UZoVBo=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Colaba Social"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNTfVXw_NR-vY1pHrwcsn1gzznUmvmHlajobg9c=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hawaiian Shack"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOXK1Nk7y-GdMJ-8MWGbvcwjhqgXtEaaT7YY_0=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bombay Cocktail Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/GCjVJDxWWCPtPNXxv0_GjCzxie147itGpYU1fIRyeHMaMqttVcpjb2J6UQTM5KpvRMcE2OUKE73XtBGvLJ9rDmPN4PLkoLhWkRG1zN_eXlZipd0Sy8WRGhpBu8JLM55MmWziHWRk2cPQpBjtaDWeOe5n-pQ2-l8=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Wink"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/b2PTmw0TSDDDz7glkVwZrCLte_S2-Wz9_ocS2QPuVRCB0jW5d-jIeKZUFQVBaKghWiRLbdzkMM8y19T6pAgHvcv4F0M-jxmntUsU-BMYItHD7nLUko-yLGN_C1KnfsCv5MRiYds5Ll2hY6B5Tj-TN1cf3ZOd6dw=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Irish House"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN01_5NuPX-AVDdBek5iSKZbS9Dsdpp_ezMgN-K=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Opa! Bar & Cafe"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/v2Dvyk5brPg1339S2S2ZTvUpJyBA0XIr0fP3fb1ZqDb9oF2xIFfUe4Ao0D8nMwm5WKo2p35KngDmkn7yqKD0ua-hajwPHI5Z9trnjYncpaUGDGPW8wKxNY7ydKWklhLQ80FICUe3lrcoEiNl01MvOID4nBHE7w=w408-h217-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Drawing Room"){
        Picasso.with(c).load("https://geo3.ggpht.com/cbk?panoid=-9lGPRNUVM-zP5ppJxtUyQ&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=250.1684&pitch=0&thumbfov=100").error(R.drawable.nightlife).into(img);}
    else if(namee=="Social"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN6oGRvnaReO1jzJ4--oahgdbvpiYqjRNegED5d=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Tote On The Turf"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPEv4DSLN2NPpSM8xdFNwj_GkCBMAYDaQrZH0rK=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hoppipola"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNiM_DqU41Whywyd5pFyNjMD8YHvGam1d7kwQ5S=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="WE VIP Premium Nightclub And Restro Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNO91awfxUZnwdUerf2hr8RPZjXNNCYjeO2bhTr=w408-h236-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Ark"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/fka8cAnJ1GNZMHjhp_RDCDxn79mXVUvHjxgKsLXlSDphvmsqTcIDWe3Wvm7ht5kWI5IZf5hcLMpswBFh3KqRhI0xxncemSWH65YDAyRl2zDKvPuAVulADesG90Xd8fIgFXt_-gyfIPTXtcLL5oocgP_Wc1DpOQ=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Elbo Room"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNus3ZgwI8zc2oVFHvGMA_Rvm0l4CXIVB9KelIq=w408-h268-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Bar Stock Exchange"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNQA5b_zH8jK5oJOfVyT7rwtKlH0rgTcMeApX1-=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Eau Bar"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/e9AjkykzInGgRXCeb8n6IDjr0oussXQ0_Ac8pTbunWakkqjEndItDtmWh4VWWVmxvEaSF32nmpwlEhbLGsdQ4NEy6TWl5IVY2xTCUPEKV_PfpZTn0jUwVX0UP7OjiNiGVyfNfgKpDuyaaekNxq4WHv0v6g7FIQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Escobar"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/dIEhMe0D3vlzzCQ955dg8EUsXSyERvzbLr8TrmFdFAdUo8r5pXo6L5YzUhS9dt7MmtTetlEMWcCRhU_6Zu7Zcy67s8MCkhDoqppwhy8wdvR2AMLLoQ2GRs6OjiIE7UpcfNq0P_X-Vn69IUkooc-FYbq1wacK3A=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Geoffrey's"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/-TUuzHGQxHuGKTGqtp-Busj-GFuQLZDH2ZJVnURYpzp0Pf3mkyB_AKyo3okZjHFFXY7Xa7V_zGdxDk3AmUGX_P20wuqFkdIj-iHmCxIVkNanIx7oiRJ_xZ0ItEGW2cz5tAJZx9qmycm3sD54phGy7Yn2oYeitA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Cavalry"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPdSK9aZUCpdjZ3ed4Kln7xHtg8Suiyz8yq0gem=w411-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Rock Bottom"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/0Rcy4KUDyHI2042O2PlxTxnc78Ra7vfgIF8njRUG6q9diMlNgAicwY3w0Rb0cNgLtpQOcEHCgIFAl1u0CsvOPzZ-v1QBRMzhONX73QOgXsJ5k4fD10T8nDj3LZ1paFW5W1NDJUk106FOGo0mUjwn5TIGFCqiNw=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Cafe Zoe"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPQqBNdllrWyprfutVDNehqn6aoEc8hN_gJsN4c=w408-h301-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Little Door"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/hrRDOl3akCqOmjxiAvUGqfmqFrb9TZZauyIAoElDSTB9p_R6cunFCyuTW5jjocLWszS-F1yHYLY6M6ffq0E2FnJx9dvyS0CYgdYEQtZVZXEJy32r87GIGMVoDQpycIMMGqxcikL526H2vWJVab7ItNujOLeKa2I=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Bombay Bronx"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Nas0mT-An55SFzPfMNIGSo4uisKGljjHl44go-UTPpc5-R_rN9Mul0EKNhzxAVyhe13uV9B83okH0_1WpuIt6drrVijnCtjcBm5Wtc9jY8ZSKd9-hEbMB6w0dj2OeKlwf9-xKpab8dM_D6HQZ667Eex5hxrfGw=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Copa"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/Bih8uHxViEFzJgo7eHhz4yTEGhN-FPcRDx7BUwer70D_tJ7-NvvL9o_-Vy5Sgpt5_FjSqc3qikyPm0s74dfT2hTgGGUJa1modf7gu7OGGyiQb-i7TTysfNjVR_317pIQ6trP6scsNOyG_HpIffkmfWcIKWzv8Q=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Tonic"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/kNElMEhCOy2iL-5CiT7RJ-1ZBQcVA2Dm8MusyyY_YXpo5Xrxt3mJqAP6fJ-biKQ8xL5MZ5bhRVPFrNYxQ-ysCZjR4kaH220UjtG49wlJc8lRirntPsW4DdnU1FeYDNNaIpDgvliIqUSPJr5OUYkg68urmQWgbw=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Raasta Bombay"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/3nrS7iuapnQtXEooCyzSeh3Pbu407Me9iwG1uCwQnUtZONgD-XJN_ZaI0RGDpf4-rFQ4IPVN40vbiGvahTWcT4fk7RMlL53PsLN5eAxXVCsLWtiTeY_Y2pgBaoUXSn6TEwbfOy6lx5YE2pMb9nFwgVCqFVvcAQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Gadda Da Vida"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOgI8h5jCfTuoP8CYn0iW3_ZRAbcUVgqAeRiTB3=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Atrium Lounge"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/7pl5f7iz3htT7jEUS98Lb2wbNGJp6EkstTXFuHlM4BtwLXhWTZg_6Zz2j585IpSzIeVeU709LfLUJ2ktUYPoROE8KObzy3-9nZS_3GAp_XmXxU9-QVJznBe1xV2muOXvPcLqxVUq1YOxoVZHWYhp93h2OHdpow=w459-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Razzberry Rhinoceros"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMMj3d5Axb-cM2ME7_Y1H84E1Q-aWnLnAvKNuDQ=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Pharaoh Pub & Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO6XcBnWyzOSIAMLYbyZ6Lsb0wU6zJFCMacu7ZS=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bar Stock Exchange"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOeprcqqTbWmAYC0EXmJpt9DBrRhAe58o-SCMkh=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Thyme"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/N69pmt7IkCGOZ31r8chXu0sjdOauDq_mTnzXuH9pV8wg4pGOlGbkDfs3hF0JBzpAb-jvVDlDlNPrfpydZMY21ykTsvUcYKlOKchYJez1UYm67RyU38wW0zI7JAr3bpK8vPTplVsZXg1nQ4NeaWRcH8TnPf3LfUE=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Monkey Bar"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/uRkvP8sUK5_UddZbwBogeLxmBeliKQgjS9aa8QMDQT1Qv1f6fJLkFVisKkxB1KJyqeIRbMBLS1HmH8TDvW0t6LAelkW8tWH2kEuGZw9VDYIlo0mJlpmDU2UO1k9zYgBg0yLY-GyXsFfBpi9zWMbGr_VUwBIcGGM=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Angrezi Pub"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/X2lUMSJThDCJCxjiVi747U97sh_ktTDoAOTWrpHrDUuiUdXJthni6hCkNHolS9-i4CLxn6dOueHxSAQ_hN6UCN1DEf_W_ZeDZIFx9bFyfBchIJJw_zgv4ooXxnD-D6lzN3R4x-Kj4gPQlRya-NYBZ34bEg=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Baraesti"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/8fHGVf-3HKqMcg_L2dVACvChtZv2STWthELvIsqrtWknxXN54w6edP7au4qM2wio9zR7u31d3B_mEhPiX-FzztHFdA38-mDclwFmGE_elbxInCeUgcUrj-PjspoQyExlB8cr0c3Zmz7fPbwI-ryHIGFWwXFgsQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="145 Bandra"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPxIuItWioYExMCiI3BMdur5WP_bKpKsL28fDH1=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Coral Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNiboueeQosiMh5KdIeyASEpLSP9MHpoIm8642e=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Lobby Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/6bfqwwiWvKl51ucfBfhgcAIyPhb2BIqigAC3XX9t9qc0cTwNe7SCIePNlLictAzmai01khFPw8bngnVjM0QNT7KobJnnjZ1s-VZDPqts8tetY-GXkafn_-t6VT_kLrFjmpZE-JQfb4VCMm-QgSHVRpi6lMsyL-0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="A Bar"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/uU2LAe5uW1OXFFz6KcaPQyrEiAQaoOwDxcMyfkpGCNhUf67WfzBgENxBteL6LeMRZOQy4oc-hANAXPXsiC6C53yKrRFC-gvAhsZTwdMy7smG6jOiYZEJqmMjEWhRxopWMWyhZ6ztYIuTkCR58qnBdyphnavxCw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="THE LOCAL"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP_iqUbhCzv3N8jmiQojqgRNy5kkmjuz3NPMC0U=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Krishna Palace Hotel"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/R8rs0wqCZStLqEfcO4CNu4OumyXx34yTrkz2kxDBB3Mzrgsu8PSnsE4_TZMLJDO6RmeaOHEjwNodmy9CC03NyjFWSkXTaPuCMYi_4kLE-tcbDeMIRX6PPXdmVH-1xQwwRXTpIQKPK4YESsh8Nmd8H4u1ssvTk88=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Rude"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMBDEoKa38xNMdkd96h1O0zYvWtKwjQTP4JLBOr=w408-h230-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="PDT Mumbai"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOBtsJnn8EQsDfWh62E3J6XWN-qc51TBjZQw4Q7=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Quarter House"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/9Lx8dmhK6qU7SBeS9xKeLScyzIKKeLdDgOSVqLes8s3hZScuRVYA6NS0jiqQzlYTEWwja4957tBkXGVaFTfJCqYltIGk-BQTdZ2HmLhs6sYRhcVwazctfEU8qqP-4Xs4WOb9HV8eUEYowiMUpfGpG2cjIusAqO8=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="InterContinental Hotels & Resorts"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN42bxWclm0iJHw6a3lVVigV149bc1nD7wu2mYu=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Rude Lounge - Powai"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNxhGsP1CaMTPqDS5Y9bwPaQmfnVDdfwsvDEkRD=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Glocal Junction Andheri"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNnNQ8VOU13zglehImx0tE5R2JOp8ALYUYUSO-r=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="True Tramm Trunk"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNxEEGA78CgOvFzvmplM21QDS8Bh07ULvL1tIyr=w411-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Doolally Taproom - Bandra"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMiI9Cd52ReKkjoT3MU4uRS6B9PcKn-39TuxUVB=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="House Of Mirabella"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNjUpUIYUMkQ5z_iy0mmWDwd4FxtbPrWKQzalSL=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Casa Vito"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/0DuC3tCNHH80LtaFx1icmdd2mGspUbgraAlLw8YyV_W3UXjYWR3RL3epnjDqsmHPcnjE0TRM4mgy4_-lvhQctRNh5xQ3KXpuchDSttaR2diYmVY-6xu5TpkM9yCBntG4BCAJqJ5neGzl2ZL9So3nTGZbuIlD-w=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Ghetto Pub"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/tr_KvsPfoPN2UVJjR3DOG0tIw73G5xW35UOn4OcSKQjvuEByNbppiAsb6itsogjUmqBhIJvCXwfEvnVU0ReDaKkF4pjRZ4D3EP769ruokGdA2GD9LcGXfFjC9qRGXwlyp8oDvzMRtZq5enN4_TRIFksEGVnH50g=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Zenzibu Da Sky Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN9uQUZJ4zOow8VLnYbJMWV2QjmoZxJ4CM3Pf8i=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Vikings"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/6NFiKLeOWOz6z_Q6i5pKkuu8wvxowF2y5je1bSgl8BGln5949KqZFiIie5We-syqhxLceHG0evLVdXqrXfs3b5wWY_kERumOlfmwTs6d44wi_rvSWJusiV8BRpVH1-KM5aNFMkc7umEOPrPpcBWVoxKK3m5Qi8E=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Aqua"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/K-eS7rLTlDXQLVOW7pdN2OGO_lEjZ6NkkKT0yTCmyUgmw0BnK9QXagDSzz5AuS_ukI7skAPcR3VWmjJbl24h6LLDpa_s05bImhqCme0UJbbKMBuRriETCPidK1OmDN404iyuq34pDz5Jt5guuMYhHxKZlVFZUA=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Pauva Deck"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNuK29Rds0Xk6VEW2GoukapIloUG41cnb9TDfT_=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Sangeet Bar and Restaurant"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPWhlenqmxHWf-xL4CwQT6eIXncn-VzimE97MTP=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Fusion Grill"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNy6sq8iF9CkR8QLVJvA7WkEVeFaMzTQGXii48z=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="270 Degrees West"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM5Kz9q74s5eW8KEGZa4GnRgj-nNse2C3S8Pmyw=w408-h229-k-no").error(R.drawable.nightlife).into(img);}

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