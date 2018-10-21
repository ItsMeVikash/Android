package nightlife.kumar.vikash.nightlife.chennai;

/**
 * Created by vikash kumar on 28-12-2017.
 */

import nightlife.kumar.vikash.nightlife.GoogleMap.GoogleMaps;
import nightlife.kumar.vikash.nightlife.R;
import nightlife.kumar.vikash.nightlife.google_floating_button;
import nightlife.kumar.vikash.nightlife.web_browser;
import  nightlife.kumar.vikash.nightlife.parent;
import nightlife.kumar.vikash.nightlife.NoUnderlineSpan;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by vikash kumar on 27-12-2017.
 */

public class adapter extends BaseExpandableListAdapter {
    private Context c;
    private ArrayList<parent> parent;
    private LayoutInflater inflater;
    public adapter(Context c,ArrayList<parent> parent)
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
        if(parentName=="Gatsby 2000") {
            address.setText("No. 132, Crowne Plaza Chennai Adyar Park, T T K Road, Alwarpet, Austin Nagar, Alwarpet, Chennai, Tamil Nadu 600018");
            web.setText("liveinstyle.com"); phone.setText("044 2499 4101");
            time.setText("All day\n" +
                    "8PM–2AM");}
        else if(parentName=="Pasha") {
            address.setText("601, The Park, Near US Embassy, Anna Salai, Gangai Karai Puram, T Nagar, Chennai, Tamil Nadu 600006");
            web.setText("theparkhotels.com"); phone.setText("044 4267 6000");
            time.setText("All day\n" +
                    "7PM–3AM");}
        else if(parentName=="Flying Bottles") {
            address.setText("A Unit of Hotel Jaya Pushpam Pvt. Ltd. 1131 Inner Ring Road Koyambedu, Jai Nagar, Arumbakkam, Chennai, Tamil Nadu 600106");
            web.setText("liveinstyle.com"); phone.setText("044 6688 8000");
            time.setText("All day\n" +
                    "11AM–11PM");}
        else if(parentName=="10 Downing Street") {
            address.setText("Kences Inn, 50, North Boag Road, T Nagar, Parthasarathi Puram, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("Unavailable"); phone.setText("044 2815 2152");
            time.setText("All day\n" +
                    "11AM–11PM");}
        else if(parentName=="Cheroot Malt And Cigar Lounge - Restaurants In Chennai") {
            address.setText("#63 Mount Road, Guindy, Little Mount, Guindy, Chennai, Tamil Nadu 600032");
            web.setText("itchotels.in"); phone.setText("044 2220 0000");
            time.setText("All day\n" +
                    "12PM–1AM");}
        else if(parentName=="Big Bang Theory - Bar & Kitchen") {
            address.setText("Brownstar Boutique Hotel, 2/25, Dr Ambedkar Rd, Ashok Nagar, Dr.Subbaraya Nagar, Kodambakkam, Chennai, Tamil Nadu 600083");
            web.setText("liveinstyle.com"); phone.setText("074015 95473");
            time.setText("All day\n" +
                    "12PM–12AM");}
        else if(parentName=="Urban Lounge") {
            address.setText("286, Old Mahabalipuram Rd, Elcot Sez, Sholinganallur, Chennai, Tamil Nadu 600119");
            web.setText("liveinstyle.com"); phone.setText("074015 78166");
            time.setText("All day\n" +
                    "11AM–12AM");}
        else if(parentName=="365 A.S") {
            address.setText("Hyatt Regency Chennai (Lobby Level), 365, Anna Salai, Teynampet, Rostrevor Garden, Teynampet, Chennai, Tamil Nadu 600018");
            web.setText("hyattrestaurants.com"); phone.setText("044 6100 1234");
            time.setText("All day\n" +
                    "3PM–2AM");}
        else if(parentName=="The B Bar") {
            address.setText("Somerset Greenways Services Residences, No. 94, Sathyadev Avenue, MRC Nagar, Next to Chettinad Vidhyasharam School, MRC Nagar, Raja Annamalai Puram, Chennai, Tamil Nadu 600028");
            web.setText("Unavailable"); phone.setText("044 4900 1010");
            time.setText("All day\n" +
                    "11AM–11PM");}
        else if(parentName=="Illusions - The Madras Pub") {
            address.setText("105, 1st Floor, Radhakrishnan Salai, Mylapore,, Kattukoil Garden, Mylapore, Chennai, Tamil Nadu 600004");
            web.setText("facebook.com"); phone.setText("044 4214 4449");
            time.setText("All day\n" +
                    "12–11:30PM");}
        else if(parentName=="Blend") {
            address.setText("No. 2, Taj Club House Chennai, Woods Rd, Anna Salai, Royapettah, Chennai, Tamil Nadu 600002");
            web.setText("vivanta.tajhotels.com"); phone.setText("044 6631 3131");
            time.setText("All day\n" +
                    "5:30–11PM");}
        else if(parentName=="Elixir Lounge Bar") {
            address.setText("Gate No 1, Express Avenue Mall, Patullos Road, Express Estate, Royapettah, Chennai, Tamil Nadu 600002");
            web.setText("emallhotel.com"); phone.setText("044 2846 3333");
            time.setText("Thursday\n" +
                    "4PM–12AM\n" +
                    "Friday\t" +
                    "4PM–12AM\n" +
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "4PM–12AM\n" +
                    "Tuesday\t" +
                    "4PM–12AM\n" +
                    "Wednesday\n" +
                    "4PM–12AM");}
        else if(parentName=="Diff 42 Resto Lounge") {
            address.setText("7, Opposite Vijaynagar Bus Terminus, Taramani Road, Velachery, Sarathy Nagar, Velachery, Chennai, Tamil Nadu 600042");
            web.setText("liveinstyle.com"); phone.setText("074015 75438");
            time.setText("All day\n" +
                    "12PM–12AM");}
        else if(parentName=="Leather Bar") {
            address.setText("601, The Park Chennai Hotel, Mount Road, Anna Salai, Pudupet, Komaleeswaranpet, Egmore, Chennai, Tamil Nadu 600002");
            web.setText("theparkhotels.com"); phone.setText("044 4267 6000");
            time.setText("All day\n" +
                    "12PM–12AM");}
        else if(parentName=="Unlock Bar") {
            address.setText("Kalakshetra Road, Radhakrishnan Nagar, Thiruvanmiyur, Sri Ram Nagar, Radhakrishnan Nagar, Thiruvanmiyur, Chennai, Tamil Nadu 600041");
            web.setText("keyshotels.com"); phone.setText("044 4900 2050");
            time.setText("TAll day\n" +
                    "10AM–11:30PM");}
        else if(parentName=="Hoppipola") {
            address.setText("The Spring Hotel, Kodambakkam High Rd, Nungambakkam, Tirumurthy Nagar, Nungambakkam, Chennai, Tamil Nadu 600034");
            web.setText("Unavailable"); phone.setText("098846 20070");
            time.setText("All day\n" +
                    "12PM–12AM");}
        else if(parentName=="The Flying Elephant") {
            address.setText("39, Velachery Road, Raj Bhavan Colony, Little Mount, Guindy, Little Mount, Guindy, Chennai, Tamil Nadu 600032");
            web.setText("hyattrestaurants.com"); phone.setText("044 7177 1655");
            time.setText("Thursday\t" +
                    "7–11:30PM\n" +
                    "Friday\t" +
                    "7–11:30PM\n" +
                    "Saturday\t" +
                    "7–11:30PM\n" +
                    "Sunday\t" +
                    "12–3PM\n" +
                    "7–11:30PM\n" +
                    "Monday\t" +
                    "7–11:30PM\n" +
                    "Tuesday\t" +
                    "7–11:30PM\n" +
                    "Wednesday\t" +
                    "7–11:30PM");}
        else if(parentName=="Aura - The Lounge Bar") {
            address.setText("No 171, Jawaharlal Nehru Salai, Arumbakkam, Annai Sathya Nagar, Koyambedu, Chennai, Tamil Nadu 600106");
            web.setText("radhahotels.com"); phone.setText("044 6677 8899");
            time.setText("All day\n" +
                    "11AM–11PM");}
        else if(parentName=="Grand By GRT Hotels") {
            address.setText("120, Sir Thyagaraya Rd, Drivers Colony, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("business.site"); phone.setText("044 2815 0500");
            time.setText("All day 24hr");}
        else if(parentName=="Paddington Sports Pub") {
            address.setText("132, Chamires Road, Near Times of India Building, Nandanam, Nandanam Extension, Nandanam, Chennai, Tamil Nadu 600035");
            web.setText("Unavailable"); phone.setText("044 2434 8440");
            time.setText("All day\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Distil") {
            address.setText("Taj Connemara, Chennai, Binny Rd, Anna Salai, Chennai, Tamil Nadu 600002");
            web.setText("vivanta.tajhotels.com"); phone.setText("044 6600 0000");
            time.setText("All day\t\n" +
                    "6–11PM");}
        else if(parentName=="Shastri Nagar Sharks") {
            address.setText("Gandhi Nagar 1st Main Rd, Gandhi Nagar, Adyar, Chennai, Tamil Nadu 600020");
            web.setText("snsclubchennai.com"); phone.setText("044 2445 5562");
            time.setText("All day\t\n" +
                    "10AM–11PM");}
        else if(parentName=="The Regency Club Lounge") {
            address.setText("365, Anna Salai, Teynampet, Rostrevor Garden, Teynampet, Chennai, Tamil Nadu 600018");
            web.setText("chennai.regency.hyatt.com"); phone.setText("044 6100 1234");
            time.setText("All day\t\n" +
                    "6AM–11PM");}
        else if(parentName=="Plan B") {
            address.setText("65/5 Murugesan Naicker Complex , Greams Road, Thousand Lights, Next to HIL, Thousand Lights West, Thousand Lights, Chennai, Tamil Nadu 600006");
            web.setText("holycowhospitality.com"); phone.setText("098450 96332");
            time.setText("All day\t\n" +
                    "9–10AM");}
        else if(parentName=="Sera") {
            address.setText("71, Cathedral Road, Chokkalingam Nagar, Gopalapuram, Kanakasri Nagar, Gopalapuram, Chennai, Tamil Nadu 600086");
            web.setText("seratapasbar.in"); phone.setText("044 2811 1462");
            time.setText("All day\t\n" +
                    "12:30PM–12AM");}
        else if(parentName=="Zodiac - The Accord Metropolitan") {
            address.setText("35, GN Chetty Road, T Nagar, Lakshimi Colony, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("chennai.theaccordhotels.com"); phone.setText("044 2816 1000");
            time.setText("All days\t\n" +
                    "4PM–12AM");}
        else if(parentName=="Swirl") {
            address.setText("The Gateway Hotel IT Expressway, 309, Old Mahabalipuram Road, Elcot Sez, Sholinganallur, Elcot Sez, Sholinganallur, Chennai, Tamil Nadu 600119\n");
            web.setText("gateway.tajhotels.com"); phone.setText("044 6680 2500");
            time.setText("All days\t\n" +
                    "4PM–12AM");}
        else if(parentName=="US 101 - Be A Sport") {
            address.setText("80A Chevalier Sivaji Ganesan Salai, Opp Amudham Colony, T Nagar, Amudham Colony, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("us101.in"); phone.setText("094440 69520");
            time.setText("All days\t\n" +
                    "12–11:30PM");}
        else if(parentName=="The Vault Bar Stock Exchange") {
            address.setText("Shop No 22/23, Venkatanarayan Street, T Nagar, Parthasarathi Puram, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("Unavailable"); phone.setText("095660 88811");
            time.setText("All days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="TITOAS RESTO BAR") {
            address.setText("128, E Coast Rd, Injambakkam, Chennai, Tamil Nadu 600115");
            web.setText("Unavailable"); phone.setText("044 3304 2928");
            time.setText("All days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Based On A True Story") {
            address.setText("17,, 5th Ave, Urrur Kuppam, Besant Nagar, Chennai, Tamil Nadu 600090");
            web.setText("Unavailable"); phone.setText("044 3123 3123");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Bamboo Bar") {
            address.setText("Jagadambal colony, Mylapore, Chennai, Tamil Nadu");
            web.setText("liveinstyle.com"); phone.setText("072999 38711");
            time.setText("All days\n"+"11AM–11PM");}
        else if(parentName=="Radio Room") {
            address.setText("Hotel 94, Satyadev Ave, Opp Appolo Hospitals, MRC Nagar, Raja Annamalai Puram, Chennai, Tamil Nadu 600028");
            web.setText("radioroom.in"); phone.setText("085000 05672");
            time.setText("All days\t\n" +
                    "6–11:30PM");}
        else if(parentName=="Chill & Grill") {
            address.setText("128, 2nd Floor, Archbishop Arulappa Towers, Santhome High Road,, Opp CCD, Mylapore, Pattinapakkam, Kuil Thoppu, Mylapore, Chennai, Tamil Nadu 600004");
            web.setText("chillandgrill.co.in"); phone.setText("044 2495 7899");
            time.setText("All days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Salt lick by Gallop") {
            address.setText("531, Great Southern Trail, Lobby Level, Kannan Colony, Saint Thomas Mount, Kannan Colony, Pazavanthangal, Chennai, Tamil Nadu 600014");
            web.setText("radissonblu.com"); phone.setText("044 2231 0101");
            time.setText("All days\t\n" +
                    "6:30AM–11:30PM");}
        else if(parentName=="Phoenix Bar & Restaurant") {
            address.setText("Old No.152 New No.371, Konnur High Road, Ayanavaram, United India Nagar, Ayanavaram, Chennai, Tamil Nadu 600023");
            web.setText("Unavailable"); phone.setText("044 6457 8889");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="SUDAKA - South American Restobar") {
            address.setText("The Legends,, 37, North Boag Road, T Nagar, Drivers Colony, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("facebook.com"); phone.setText("044 2815 3625");
            time.setText("All days\t\n" +
                    "12–3PM\n" +
                    "6–11:30PM");}
        else if(parentName=="The Moon And Sixpence") {
            address.setText("Guindy Industrial Estate, SIDCO Industrial Estate, Guindy, Alandur, Chennai, Tamil Nadu 600032");
            web.setText("liveinstyle.com"); phone.setText("044 2233 4000");
            time.setText("All days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Durrant's Bar") {
            address.setText("13, Cathedral Road, Kasturi Estate, Teynampet, Chennai, Tamil Nadu 600086");
            web.setText("fortunehotels.in"); phone.setText("044 2811 0101");
            time.setText("Unknown");}
        else if(parentName=="Ink 303") {
            address.setText("Khader Nawaz Khan Rd, Srirampuram, Thousand Lights West, Nungambakkam, Chennai, Tamil Nadu 600034");
            web.setText("Unavailable"); phone.setText("044 4216 3303");
            time.setText("All days\t\n" +
                    "12–11PM");}
        else if(parentName=="Turf pub- Eldoris Hotel") {
            address.setText("Lakshman Perumal Nagar, Citrus East Coast Road, Kaveri Nagar, Chennai,, Tamil Nad, Valmiki Nagar, Kaveri Nagar, Lakshman Perumal Nagar, Chennai, Tamil Nadu 600041");
            web.setText("eldorishotels.com"); phone.setText("075500 00930");
            time.setText("All days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Associted Brothers Club") {
            address.setText("133, Purasawalkam High Rd, Lumbini Square, Purasaiwakkam, Chennai, Tamil Nadu 600010");
            web.setText("Unavailable"); phone.setText("089392 12099");
            time.setText("All days\t\n" +
                    "11PM–11AM");}
        else if(parentName=="B Side") {
            address.setText("65/5, Murugesan Naicker Complex, Greams Road, Thousand Lights West, Thousand Lights, Chennai, Tamil Nadu 600006");
            web.setText("Unavailable"); phone.setText("075501 12345");
            time.setText("All days\t\n" +
                    "12–11PM");}
        else if(parentName=="Library Blu - The Leela Palace") {
            address.setText("S Beach Avenue 1st St, MRC Nagar, Raja Annamalai Puram, MRC Nagar, Raja Annamalai Puram, Chennai, Tamil Nadu 600028");
            web.setText("theleela.com"); phone.setText("044 3366 1234");
            time.setText("All days\t\n" +"5PM–1AM");}
        else if(parentName=="Glass hopper") {
            address.setText("No 26, 1st Floor, Rajiv Gandhi Salai, Near Toll Gate, Seevaram, Perungudi, Manikkodi Srinivasan Nagar, Perungudi, Chennai, Tamil Nadu 600097");
            web.setText("Unavailable"); phone.setText("044 6542 6542");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Tranz Bar") {
            address.setText("24, Mannar St, Asoka Nagar, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("Unavailable"); phone.setText("Unavailable");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Lava Bar & Lounge") {
            address.setText("Valaiyapathi Salai, Block 1, J J Nagar, Mogappair East, Chennai, Tamil Nadu 600050");
            web.setText("Unavailable"); phone.setText("044 2656 6002");
            time.setText("All days\t\n" +"11AM–12AM");}
        else if(parentName=="submarine bar") {
            address.setText("wallajah Road, mount Raod, Anna Salai, Triplicane, Chennai, Tamil Nadu 600003");
            web.setText("Unavailable"); phone.setText("044 4344 0800");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Spice Bar") {
            address.setText("SH 113, Indira Nagar, Majestic Colony, Valasaravakkam, Chennai, Tamil Nadu 600087");
            web.setText("Unavailable"); phone.setText("098412 43055");
            time.setText("All days\t\n" +"11AM–11PM");}
        else if(parentName=="Tranquebar") {
            address.setText("ITC Grand Chola, Little Mount, Guindy, Chennai, Tamil Nadu 600032");
            web.setText("itchotels.in"); phone.setText("044 4906 5272");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Arcot Bar") {
            address.setText("1/24, GST Road, Meenambakkam, Nangainallur, Kannan Colony, Pazavanthangal, Chennai, Tamil Nadu 600027");
            web.setText("tridenthotels.com"); phone.setText("044 2234 6699");
            time.setText("Unknown");}
        else if(parentName=="The Velveteen Rabbit") {
            address.setText("57, 2nd Main Rd, Govindaswamy Nagar, Raja Annamalai Puram, Chennai, Tamil Nadu 600028");
            web.setText("facebook.com"); phone.setText("044 4282 7882");
            time.setText("All days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="The Cycle Gap") {
            address.setText("Chennai, 600040, W Block, Anna Nagar, Chennai, Tamil Nadu 600040");
            web.setText("samosapedia.com"); phone.setText("044 2620 3828");
            time.setText("All days\t\n" +
                    "12–3PM\n" +
                    "7PM–12AM");}
        else if(parentName=="Chap Chay") {
            address.setText("The Raintree Hotel 120, St Marys Road, Austin Nagar, Alwarpet, Chennai, Tamil Nadu 600018");
            web.setText("raintreehotels.com"); phone.setText("044 4225 2525");
            time.setText("All days\t\n" +
                    "12–3PM\n" +
                    "7–11PM");}
        else if(parentName=="Watson's Chennai") {
            address.setText("No.90, Gopathi Narayanaswami Chetty Rd, Near Jeeva Park, T Nagar, Parthasarathi Puram, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("watsons-chennai.business.site"); phone.setText("078240 01206");
            time.setText("All days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Secret Society Bar") {
            address.setText("55, 2nd Main Rd, RA Puram, Govindaswamy Nagar, Raja Annamalai Puram, Chennai, Tamil Nadu 600028");
            web.setText("facebook.com"); phone.setText("091767 90918");
            time.setText("All days\t\n" +"12PM–12AM");}
        else if(parentName=="Mississippi Bar") {
            address.setText("934, 1st Floor, Poonamallee High Road, EVR Periyar Salai, Purasaiwakkam, Chennai, Tamil Nadu 600084");
            web.setText("Unavailable"); phone.setText("044 2641 2244");
            time.setText("All days\t\n" +
                    "9AM–10PM");}
        else if(parentName=="Xzubarance") {
            address.setText("Raj Park Hotel ,180, T T Krishnamachari Rd, Near Parthasarathy Garden St, Alwarpet, Parthasarathypuram, Teynampet, Chennai, Tamil Nadu 600018");
            web.setText("rajpark.com"); phone.setText("091769 99955");
            time.setText("All days\t\n" +"11AM–11:30PM");}
        else if(parentName=="The Irish House") {
            address.setText("Kamraj International Airport Domestic Terminal, Meenambakkam, Chennai, Tamil Nadu 600016");
            web.setText("theirishhouse.in"); phone.setText("044 2256 2051");
            time.setText("Open 24 hours");}
        else if(parentName=="Microbrewery - Prodebbrewery Brewery Belgium") {
            address.setText("No.149, Poonamallee High Road, (E.V.R Lane) Kilpauk, Chennai-600 010, TN,, India., New Bupathy Nagar, Chetpet, Chennai, Tamil Nadu 600010");
            web.setText("prodebbrewery.com"); phone.setText("044 2836 2468");
            time.setText("sunday closed\n"+"All other days \t\n" +
                    "9AM–7PM");}
        else if(parentName=="Hot Pot China") {
            address.setText("1/1666, MGR Main Road, Kandanchavadi, Perungudi, Tirumalai Nagar, Perungudi, Chennai, Tamil Nadu 600096");
            web.setText("Unavailable"); phone.setText("044 6451 5164");
            time.setText("All days \t\n" +
                    "12–3:30PM\n" +
                    "7–11:30PM");}
        else if(parentName=="Black Pearl") {
            address.setText("Sardar Patel Road, Adyar, Nethaji Colony, Kasturba Nagar, Adyar, Chennai, Tamil Nadu 600020");
            web.setText("Unavailable"); phone.setText("Unavailable");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Chikku Bukku Restaurant") {
            address.setText("No 15, Hotel SRM Central Park, Kovalan Muthu Street, Periyamet, Park Town, Chennai, Tamil Nadu 600007");
            web.setText("hotelsrmcentralpark.com"); phone.setText("091760 28198");
            time.setText("All days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Elite Tasmac") {
            address.setText("Gemini Parsn Complex, No.1, Kodambakkam High Rd, Tirumurthy Nagar, Nungambakkam, Chennai, Tamil Nadu 600006");
            web.setText("tasmac.co.in"); phone.setText("092902 12462");
            time.setText("All days\t\n" +
                    "12–9PM");}
        else if(parentName=="Bronx Sea View Resto Bar") {
            address.setText("1, 5th Floor, Dr. Radha Krishna Salai, Mylapore, Kailasapuram, Mylapore, Chennai, Tamil Nadu 600004");
            web.setText("hotelmanhattanchennai.in"); phone.setText("044 2844 4546");
            time.setText("All days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Black & White, The Residency Hotel") {
            address.setText("The 49, The Residency, Gopathi Narayanaswami Chetty Road, Satyamurthy Nagar, T Nagar, Lakshimi Colony, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("theresidency.com"); phone.setText("044 2825 3434");
            time.setText("All days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="KINGS BAR") {
            address.setText("27, Gopalakrishna Street, Pondy Bazaar, T Nagar, Opp ICICi Bank, Parthasarathi Puram, T Nagar, Chennai, Tamil Nadu 600017");
            web.setText("Unavailable"); phone.setText("044 2815 0211");
            time.setText("All days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Above Sea Level Restaurant") {
            address.setText("The Raintree Hotel,120, St. Marys Road, Alwarpet, Austin Nagar, Alwarpet, Chennai, Tamil Nadu 600018");
            web.setText("raintreehotels.com"); phone.setText("044 2430 4050");
            time.setText("All days\t\n" +
                    "7–11:30PM");}
        else if(parentName=="Anchor Bar") {
            address.setText("Vivanta by Taj Fisherman's Cove, Covelong Beach, Kancheepuram Dist., Chennai, Tamil Nadu 603112");
            web.setText("vivanta.tajhotels.com"); phone.setText("044 6741 3333");
            time.setText("All days\t\n" +"11AM–11PM");}


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
        if(namee=="Gatsby 2000") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/pWXNuJ4aqDsUBjrd22AfsjfHqkZ4MY-F3sl2kKnp31tV_9HupeBqdUXNDnmaJ9HFO__WtKBi529Tcwv9lm7R-DTAhs2hG46DDKLH92F_6p3POV5rX1R-7oxS8LlMOj4X4UXuz0L2eStKmcL19caBo6kNKcKlkA=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pasha") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/tSpgL6oLFOF6rP-oC2AfDTR3G40yDr2zLF5m2NUkdxE7fHUkWuNCy7d9QmfQqCLyAcyGTOGyQleJuh7oseuy1gCPE-6Mb800slrwlmbq6AXgxtuxqnJWCNs-vDAfoFnPYDbgnb5ymnsdR_rdEWCxoG351AWciWU=w520-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Flying Bottles") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/OEEtnf_TRfm6n6-GKCwrdcu16Qj2xpGjB1kxQ8yjLU2AvJ1Qm9fUpzfKrRJujmzmfeYzaFaE9k-3mdzKkwaUijPPLtsMs5b-Jq9Fuo21VwsrDpyq5Ud-9IwpMTCSgm4KPLMAeg6fRbLBRC5X7Thh8zI0b5zJWw=w408-h262-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="10 Downing Street") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/5Kpn99YPiCdyiVMC7fRhzQvQ7MvJZWGzJTxcclH0n2RTSf_kXVsTKrUlcXseHTxhR46aW3q4SEPjlTdQfEG7SZY04z6eyQe1lEj4IBvJof_IMjFtF8kiTimnW1ocPuwylLfs09d1RD2Qrb6LUkKStjx1yO045A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cheroot Malt And Cigar Lounge - Restaurants In Chennai") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/7fXncFErONZ5Zp-unaUVXVLSnwuclwL4yJWKQpN_kPJcpXWcii2pnxFVcA-eevUSlfWupvAW9Yh7WiYVOx1vVMFBOoDNfJxNVQqv2O9xAajCk_ikkNudabJpJaDBxufE7eCROc1C-d9E045rFaLNeLfEdO5vJgo=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Big Bang Theory - Bar & Kitchen") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOuHqruv0iyq9M4BsIatBsF9kgxt8CGWL4K33Bi=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Urban Lounge") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMPI5HY2N96OU18w3itG4FdwSR2mNeC7dQs_7pt=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="365 A.S") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN_qzcTbkAJ0CBfq9fL_DzcSvJwN2z-z0PiGfpe=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The B Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOC77I2CaOU8Ikvoq730IWTC3UIXRNAKE67dKya=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Illusions - The Madras Pub") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/51AOZPlACSzoUS0GV6nBN0PNTsJ45K_8QmR-xNHK3uq_NZevH1wef3xEtTvjQ4w8MmNbuhhwAudsfUNtnj51XD1e77xJLGMwB8AXs0DXZugDB1cSoVLekH2928pfGtRfBPP9sxHVUayOGy0mICPMkA-PXCj4Kg=w408-h363-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Blend") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/nXFQoglaQ6ZBoRngGru1jpq32FUreBww4U1vS0bopa90dA2Ql1r8GGHI7dIEwPH6S5LaDuvaRFtuV8Ew-IlsHyAwZdVkEkQJImjqUdd8LIWDlkOUBYZcQg6TS5VdbnWjddeyLQsnPKNBN769MwbSlus-itB4IA=w408-h202-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Elixir Lounge Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPkvZTZKvu0C5NCRj74PF7Ogvl6_55jQW8gvfZ-=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Diff 42 Resto Lounge") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMKSxo7rq2n7qFJWgUx9f4M1alAqSgrgthKgGcM=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Leather Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/rRjOPc7jyl_rxJyUmaxW8YGEOzM-JhaGepf2yUW22kUbuXUkgEhCfKv9Zt69PFeW1KymfUwuEyoeI3KOmERreNrFKSnqDOctJDSp_0vdINYJfF7NVyV-Cr4X5W7wFFi77lM-6ElMsEKj0vI8ClQW7cCDd8Lx7w=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Unlock Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/oWEpU5jNwiUV_hmfGfE0AwCP7mhdqG-EKGasXvZgi4F_IMFBLgdzw4FLgPIFC924CaEtH2sd9uSSJ4MecZeF8YfUQCTH7xg5eOxkuY1Vxm0snPNe_LHCyvpoQtWbR2o0vc7Ei4XcvP0fK9Pgk3-93SZDqErlx3Q=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hoppipola") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMK3RWp3U9z-3XYPVTP-F0UBQPibynGCNtrnL31=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Flying Elephant") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNsAmg8QL3A9soxzQ0hfh6SOTPeDR6eW_YHrilF=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Aura - The Lounge Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNQqi1dTRpqJpIVSIryQOXLj9ULdgT9bi8dQf2E=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Grand By GRT Hotels") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO3CNt4CaythWH_tcFXZj7yPPMfWS51qS4w5ED0=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Paddington Sports Pub") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/_mUslDS_6tpJz4WEHTcuGgaBmXssiveiYOId141p0iNHikAbdyjMkiu8opvGT9NOgAUv4rND8Goe2gypoBHUz084D0R-EDKryp5RLJDXl9gcBACb4gqdcdXyT5NvRdZfT-aqxhuyQEr3QFm59QlsZ3Bi89VCwQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Distil") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/rnH3UdTesL_9065TpLLQ1191rMyc4Wvc-Dj4Fh0kuDUOPnu3ZftvnAd7VZve4nWaACxhjwfEYyuURMBRKmuUhey0BThN8oRZzfZr-RIgC2w1YKOTV7TEzP_VtNW63uqcHWDktlFRB7ai1BceOfg0kXetA6aebp4=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Shastri Nagar Sharks") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/5r4lFGcd5lRkUO4JlGSsO_DQKNGlNiU1M_E1U24rY9dKqRBiQtgjQRUbhC0uCp4O_nyfK_SDmUxgy5BJwXzUVjQFdwHejA4Y3cD3w3WXIKmt-GaELJzCXMty6UecJZtcfo0ZTuYQrwZzmtkQ8A4CBoM6B2VPSQ=w554-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Regency Club Lounge") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN-z5-S-pHpIm_VdjVLI82R1hiswUasnZAe-dIO=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Plan B") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Ses260pPV4JJHi0weqEbieByEUIhRs2JtwUu6lgzC4z34wfMj3BLQEmRFVgkgdwwl4-PaxU6si7Ih5NnfuvjrJFdqJHLchJu9R2UFHIAC5iYKrRYORDo_BACgwaYMikLzAY5jU_-1iSkwwoW9cSbTLGBWfXYPiY=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sera") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/l5ApRp874Zoyw3cdUQvF_m3DrCDIYSalQ2-4q6zyzxO34HoW2HVDrNBTm9qX4MU5n2Zl0ATSBbBaMWIMPkBWv1lhsQq7wdX45WGs0XZtgerg5EgfgfeRKNsb2x7p0mnfOj-O6BFVQE4sFA6XECwU9u7_tgP6hw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Zodiac - The Accord Metropolitan") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/utDNtLKl3_evO7QDMoEmbtjAKmF5WvhIdeirllOpYLNMfrx7NNOSjt3D5mdpHrfoATq740OV-OGWCCwv3lB9UUENmKTkYplEB0X6s169p0T80tyTc9QUAJiu0l9O6RDjQt5VaZFoOMb_tDiLPWoDCzfb40cISA=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Swirl") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/ASvaXsqaLKjxaxt0T_PzE_guXjOAK0_8Gr-z6_j26jrp-NRXgjDRxh6SRPGoKW7oize6extG0yLT7VrlZCyv8ojczaKl5S-wGeg31tqLCjNtFXndhUH9QW6N8H9yqMzGwBAE7_BIZIaa6eE4AZ7ldV2foP-8QQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="US 101 - Be A Sport") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/IHa1OpxhLzQyv9rVBkvyZc5rY9O97w29uvKCm3-HETrbfMwPxYdXMi5kpAx-nGD3aRgE0r9KtXnN4jjUcY4eZdREw49fD-dju4Pcxo7hcn4nmUdHkTf94y5cj7vm4Gdwn5mYcvCLJIoNg2jzskib7XGdDrWI5A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Vault Bar Stock Exchange") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOH5sxdNNO15fB_eXBaNRtcRxLYnNGBRtBXn8jz=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="TITOAS RESTO BAR") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/hqbb3tZqdX13dlf22DWYgVPir-ucOXf_V5KkdxNIiQkKfe-EFA9WB8z9mv6MgGd1IsgAbKBR-_wv6YvgePivqWUH0toWJqBgdQN5dadrpTYLXe3G1vaqcJq1GkSpPTOLtjqcUXRxcielnoayNrpE0G99U_uNMA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Based On A True Story") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNDgp1RxkDSXP0seZqAnXQLDDyPgZaL9myU1gxW=w408-h221-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bamboo Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/e5T8M3MT9Cz5TlGbAt08ofu9d9ZPOkWY-nt8fIzGSWZP3393S3iT399987Qn5Qc4UmuaGh6dc_rN7Gh0pUWoLJOYbyKSKk_bXAB0WLcU_mh3MSDebsOJjMJAtQn15qx0aCyZV8khqjFMXQ9TA6WUUSgDDYlqKuQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Radio Room") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/jlM8jfcpUjtzfq-jXd5RFFTnLTWiz3fEnZCpQ4vepw0l4_6dFR6tDvu-zvmOm2JV5Ph0gRiWLxtOIsCZDPyfSpkLP1eni_Q4lknbuVoPG2wTnWQ63S6VyzCQE7VPuEMKmaFfi5k8adklWLsH55oa8nxmPfIqVQ=w408-h267-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Chill & Grill") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNYZS2-WLNoBcEzWSxuZ1c4zfsUz19WLQTHUZfw=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Salt lick by Gallop") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/_k4G1tKcSZhrUDIcEAIPo9LHd55CPwR0DgAps7tRPfDv0AIhhVts5hdnhzSXgmiWWWDuScSMw1Y2QZ52QQux7zr2K7mBYjSzjIvRMxKmigw1Wf1uVg4ldMQXrgdgQ2Su0-PzO5TaekWbXBCL_cJyFXYuLhveNgs=w519-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Phoenix Bar & Restaurant") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOmG_VyFCKaR0zhWfriCTElrSnI8bDSlZ2xN_Zu=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="SUDAKA - South American Restobar") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPwM2t9Cy8LsxJGUDCW4x1bjchdjG_WDgYnczzP=w408-h577-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Moon And Sixpence") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/LUfefI1-0GhpjQVBYUBIhzdJT2JxdRU2uwajJ_5iUBEZsmZ5FPX4Ogp4BTZWdS6FBlhbQoUlZEWuZlh8TMaZrKaF8ttyPTcG4yEforuzOX-GAzcvo37mod33Ljp8nHClCzQ67yt91mYvIz5gUoc8-R917aFIkw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Durrant's Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/JLmF2A4Mc_zYUA8tGICoE4g36KXxvF1Z-mANfEkNz8pd84VijvI14QNQLzpR1fMOTR38alyob0nANDS6fELrql82FRkzEwSdwdj-usC4AJepCjxOE5yAe5jHp7yDD3yQOgy3HtTg1ra0dAPEUjDymQNSuSwztV0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ink 303") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/0TA7mPq5GjR1V7F1NiXcdbJvWA4ymcyGOUV9-X5NatnXvhDiR2U6qBlqSheoLAVwl7kzguRdJYT37kTewzIOrljss4-MVXv3MUSdHfShWLJYLdWDGIV1SP500Zj2EbX1BbM8h0-o5WNAqhnEFR__VtMXI4DDnQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Turf pub- Eldoris Hotel") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNl05qMgIhhn-uJbG9qVWLxJOfyL1Q6Mxo5gmfw=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Associted Brothers Club") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNWkVgfcRnujvDHJTdl3WqgPsSqIinCgP6wwJOU=w408-h286-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="B Side") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNqykpnXuC_Kz5kxSrdT09V4xRwI_-WOJf594uH=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Library Blu - The Leela Palace") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/wX7QtAZAp78oQlZ-59E46_IdX5YpD7EN16ZsRmFvyv12fH5bMYSYdcvMd1OVixdjVvQSZZXBbdkcr86bPh7vqHzgNCgH87lCNt_msaGtucgyKCtVPu_zbZ-nltiKydiSNTOwj1wvuFwzbjfdGOAE43pAJ3EVPQ=w408-h202-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Glass hopper") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/lUP_1cq4EGxNSsEh-hfr3NljDOm1LlHW1wukO8kfkMUHcNZNZocce5cK8jBqEzvpRB9uCutIX5pCpulohgec_IcoS3gDzAh4W0YM-3J5QBy9JV5n_IuIVUMPmi_27eK63zrImd5-thI67GpoK3ZVsMKh_csTdvo=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tranz Bar") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/6BqBBmUoXoAi4kFHrp_IOA419tzk6yJdBEAy6mVjbCx1llEqRC5Dl_AfwR1mOzOIPhiH4DGmoUQwLirD3Fouk7ICIP3UMM3_d7AOQdtOINCpjWvSWxxSa_P4mbJmLs1xkMhy4mV73htDbeOuaY3mYK_0bpPxBw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lava Bar & Lounge") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Yh7niA94jmBmnwf5fRRFTom_lTE2IQ8FU3bnaPXG0pFpuziEYC4qVN0ulFcJlhIZ-SijV4n1WkwH59kkSGRnxohuzQ0R8INO7OawdPmR1FAmIACYuf6vyuy4qTkuIPNMwtjLMqX3LtybU0TrMuz3lXEMhutGUw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="submarine bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPWAefUcq2b8_bQ4QyTi48OkX4bP-RJwcjxpZPd=w408-h546-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Spice Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPQP7jTmIsClzrYovTkPjQ_UfkJeyvJNC7mp7wq=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tranquebar") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/gcXits0aBxu1fedR7EmuYMYKvxcnFNKOaRpS_MqtWlGQ8K6QANZyXvdB1XKc59lesNlnYDV6pLmQQpEGEmbr0VJSKycisdQP_Am5NZpXuAOpsstiX0FyzIzBgJ2FmjWtJO5D14jryZPU-IljPS6fjrD_BQ=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Arcot Bar") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/q4KtEcwZ0jqr5i4feBkn7F6Z7RT5uZS-283C-QyLaR39ZdgKnpQSL5Ma678HA6QDkI9lmPW67MKB5231Do25FVCTes6GVdIml78xyjcwRJC2yE8UKGVlmIxD_FSsvTZUpwxCtNQQ9GMiucUbCrpIOxBoBew_f-U=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Velveteen Rabbit") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/7nSn3r23a9yJAASrRPUcdlpRKrWmqxGdRgXDGC83bXedR78zSnaJgewY9sz_irpyQgC1spko9hWsdvrDPnxaZuZD8yl_MB-W7r_vxAWhVzMbdtipX43Dn2E6OiEKOOfVICX-87rwjFKNkwj_sxx_XBzweUM=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Cycle Gap") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOnv7iDjw4Otw5DXMQk4HGy2ROu7CFOjHX7F0fk=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Chap Chay") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNkFBxJKmroLWDp6tJ2hCjpE0tnErco9a--HBr3=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Watson's Chennai") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM1urmyFZvDLsRenfgrnjaseyEgZM_vq1Kko7Br=w408-h200-k-no-pi-0-ya195.95998-ro0-fo100").error(R.drawable.nightlife).into(img);}
        else if(namee=="Secret Society Bar") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/tP8EnkZbYXUNhO0y21RCtSLwskheK3NNexfKxWxDkFeks8oDNsoqiJ9L_kteqYlsP_lwh1mrd4bUkYk1P0Vi-m6Xmz-jqno7LkYTJB_UuNhLGgX5WNpyYxVnn9Igfo7T-jejzNncdg7g37BDO1hAR_BLdcuAlqw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Mississippi Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/x_CB1ecs0JLANFG0BgIBZc-xzVovdHY005u-9FEVuyjX9RgjOTGS4a0QeEFELOydWLW1IC4x-bPVYo4qSa31klQq9DaIkBgErbr-VXWiHz1l9zF_tRH86yQ4Xjqx3IafuZlJ8wuEy_8t2D8gZVAXf5HyIAu_J3U=w408-h308-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Xzubarance") {Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/H-QBdMfPHyOlrUxKydC_Ic61EMx9-2pQv1JD5s8PGKIOvaEs1dggx27ecs8h71UZ7QBQ0dSXDbyCR0GvOPDmqrogS3GbfapWRvIyLgFKb7v-vd10PtxDC86XPA8yTlF6D6ytmlgdkPTInwtgbwS2WQN2AdINfA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Irish House") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM_H36CuAbZeVbI1DtSKy03XtqVHwJj1v4lUqKq=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Microbrewery - Prodebbrewery Brewery Belgium") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOKZolMUPbWgi6HPbQnmWNzu76P_xEUs8dtoms=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hot Pot China") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/763g-8Coer-hFAJD9sFSwe0ECEq0XLW39kqWRUshlIjN6yyDlcFs1kXJ1tgYkOQi8ZGFQe4hGWKJiLIui0q9In5AFKQqEUnMPcdqfQjl68NgCSnVB_sONRoSQEcPtqfU6ZOVS8vgdRNZvpna1psV6SPPg-7obQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Black Pearl") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/RjwIldUD-QTRJ5MHthPdlNF_EkxKsbFqGl0rrIuk4U6uLCqM-ezldwCkV30cLUKTOBvr8DDKB6CNyLYZZ0DwvRLm1KULNtKG69NFA_CesKQqzjWQk5O5hIuS0H78ddM3EBNs3ejF7W3Xu5TvHq-uNAB7BU25Jw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Chikku Bukku Restaurant") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOYzJ4z1827AtHY_XBMHcz-29xUN0d-NkdWyta8=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Elite Tasmac") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO1XR9w6ix2eyL4Gm0GWo6e3x4yRS-TVvmqO_Kj=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bronx Sea View Resto Bar") {Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/FJ8-7OKtuMwA48tl__8K83GeXmbOfOEX2UenlXwkOEszlOt_8D5Xx1-q49RXZYBOMBkWVns5Q9RDJo_0vbQLlG6dwUA7Q6425hPUZ85RPGVMoj0KlSTC5cMj3hSZ-X9WGnMD2wSTI5CkdEFecrgkNSetlVlwGw=w468-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Black & White, The Residency Hotel") {Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/FZNnSOIjtbzDzR3BRFwhY_065C5eHTtnibPXbOCPT51YisQYLVQfk84048-33ovBo0NOSdk-jGcAZQvdTt0crCJcRHLRRey8qtq5bd9qgCuJr01gm9GUQNgNBWOP4tKmezNccJprL-piL_uOnGOR_FzujHYwop8=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="KINGS BAR") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/a2yjZonwlh694f24lit8ubF0tc2w4s8GqcFI40QtqhLSIs52-xf6gWJVtPEwQYQ29tR1uxOWsqE921EUxoY3L3077mb8XEnAfiO3EMuDP2Kqp5udvVznE2J3ilC19cmvI6PmldfJEYFJAj_ybcNPgaSBq1WDeA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Above Sea Level Restaurant") {Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNYSmbPsOaBwewJhS0Ajn88_EVls2PN1xo3Eit_=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Anchor Bar") {Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/jSNyAXBnF-hiPUcT_T3_jefewLf7Iiq8UF9wfKaikLWHMdToklXtdSQ11KOr_op9EibiNZ_EtQXuhRBwv0-Nl9YfXEWKA3WJXiEVNjsl1Mbqf7cdvEQCOQWfyhCmbrrZ_g0qqzDppI5jBukKWm2wSbNSPwAUBg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}

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