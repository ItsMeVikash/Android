package nightlife.kumar.vikash.nightlife.delhi;

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
        if(parentName=="RSVP") {
            address.setText("19 Ashok Road, The Royal Plaza Hotel, Connaught Place, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("facebook.com");phone.setText("079999 99069");
            time.setText("Wednesday\t" +
                    "9:15PM–1AM\n" +
                    "Thursday\t" +
                    "9:15PM–1AM\n" +
                    "Friday\t" +
                    "9:15PM–3:15AM\n" +
                    "Saturday\t" +
                    "9:15PM–3:15AM\n" +
                    "Sunday\t" +
                    "9:15PM–1AM\n" +
                    "Monday\t" +
                    "Closed\n" +
                    "Tuesday\t" +
                    "9:15PM–1AM");}
        else if(parentName=="Privee") {
            address.setText("Shangri-La's Eros Hotel, Connaught Place, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("priveetheclub.com");phone.setText("085952 02020");
            time.setText("Saturday\t" +
                    "Closed\n"+"All Other Days\t"+"9PM-2AM");}
        else if(parentName=="Kitty Su") {
            address.setText("The Lalit Hotel ,Barakhamba Road, Opp Modern school ,Connaught Place, Fire Brigade Lane, Barakhamba, New Delhi, Delhi 110001");
            web.setText("kittysu.com");phone.setText("011 4444 7666");
            time.setText("Monday & Tuesday\t"+"Closed\n"+"All Other Days\t"+" 10PM-1:30AM");}
        else if(parentName=="Playboy Club New Delhi") {
            address.setText("Samrat hotel, Kautilya Marg, Chanakyapuri, Chanakyapuri, New Delhi, Delhi 110021");
            web.setText("business.site");phone.setText("079999 97792");
            time.setText("Wednesday\t" +
                    "Closed\n" +
                    "Thursday\t" +
                    "10PM–3AM\n" +
                    "Friday\t" +
                    "10PM–3AM\n" +
                    "Saturday\t" +
                    "10PM–3AM\n" +
                    "Sunday\t" +
                    "Closed\n" +
                    "Monday\t" +
                    "Closed\n" +
                    "Tuesday\t" +
                    "Closed");}
        else if(parentName=="Keya") {
            address.setText("122-124, Ground Floor, Vasant Kunj, Vasant Kunj II, Vasant Kunj, New Delhi, Delhi 110016");
            web.setText("Unavailable");phone.setText("096502 55777");
            time.setText("All Days\t" +
                    "12:30PM–1AM");}
        else if(parentName=="i-Kandy") {
            address.setText("Le Meridien Delhi NCR, Sector 26, Sikanderpur, Sector 26, Gurugram, Haryana 122002");
            web.setText("liveinstyle.com");phone.setText("088606 09374");
            time.setText("Monday\t"+"Closed\n"+"All Other Days\t" +
                    "7PM–12AM");}
        else if(parentName=="Agni") {
            address.setText("15 Parliament Street, Connaught Place, Hanuman Road Area, Connaught Place, New Delhi, Delhi 110001");
            web.setText("theparkhotels.com");phone.setText("011 2374 3000");
            time.setText("All Days\t\n" +
                    "3PM–12AM");}
        else if(parentName=="Hype") {
            address.setText("Welcome Hotel,, Sector 10 Dwarka, Dwarka, Delhi, 110075");
            web.setText("hypetheclub.com");phone.setText("099999 98973");
            time.setText("Monday & tuesday\t\n" +
                    "Closed\n"+"Other Days\n"+"8PM–1AM");}
        else if(parentName=="Club London") {
            address.setText("GF-3 & 4, D2, Ground Floor, Southern Park Mall, Pamposh Enclave, District Centre, Sector 6, Pushp Vihar, New Delhi, Delhi 110017");
            web.setText("Unavailable");phone.setText("099997 86897");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Summer House Cafe") {
            address.setText("1st Floor, Aurobindo Place Market, Hauz Khas, Block C 2, Bhim Nagri, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("facebook.com");phone.setText("011 3310 6147");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Club BW") {
            address.setText("Surya Hotel, New Friends Colony East, Friends Colony West, New Friends Colony, New Delhi, Delhi 110065");
            web.setText("clubbw.com");phone.setText("088266 98561");
            time.setText("Sunday & Monday \t\n" +
                    "Closed\n"+"Other Days\t\n" +
                    "9PM–3AM");}
        else if(parentName=="Imperfecto") {
            address.setText("1A/1, Near Deer Park, Hauz Khas Village, Imperfecto HKV, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("liveinstyle.com");phone.setText("096430 02717");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Hauz Khas Social") {
            address.setText("9A & 12, Hauz Khas Village, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("socialoffline.in");phone.setText("078386 52814");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Lord of the Drinks") {
            address.setText("G-72, Radial Road Number 2, Connaught Place, Block G, Connaught Place, New Delhi, Delhi 110001");
            web.setText("lordofthedrinks.in");phone.setText("099998 27144");
            time.setText("All Days\t\n"+"12PM–12:45AM");}
        else if(parentName=="G Bar - The Grand") {
            address.setText("Nelson Mandela Road, Vasant Kunj - Phase II, Vasant Kunj II, Vasant Kunj, New Delhi, Delhi 110070");
            web.setText("liveinstyle.com");phone.setText("011 4766 1234");
            time.setText("All Days\t\n" +
                    "6PM–4AM");}
        else if(parentName=="Tamasha") {
            address.setText("A 28, Anand House,, KG Marg, Connaught Place, New Delhi, Delhi 110001");
            web.setText("tamasha.com");phone.setText("099994 77661");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="PCO Bar, Delhi, Vasant Vihar") {
            address.setText("D-4, D Block Market,, Block A, Vasant Vihar, New Delhi, Delhi 110057");
            web.setText("liveinstyle.com");phone.setText("097111 08482");
            time.setText("All Days\n"+"5PM–1AM");}
        else if(parentName=="Cafe MRP") {
            address.setText("C-39, First Floor, Radial Road 5, Block C, Connaught Place, Opp. Odeon Cinema, Block C, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("099998 01454");
            time.setText("All Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Kabooze") {
            address.setText("Gk-2, Building No:4, 2 nd Floor, M Block Main Market, Greater Kailash II, Block M, Greater Kailash II, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("clubkabooze.com");phone.setText("095608 18632");
            time.setText("All Days\n"+"11:30AM–12:30AM");}
        else if(parentName=="Zaradise NightClub") {
            address.setText("A-3, Kailesh Park, Opp. Metro Pillar no. 329, Kirti Nagar, New Delhi, Block H, Kirti Nagar, New Delhi, Delhi 110015");
            web.setText("business.site");phone.setText("096432 71414");
            time.setText("All Days\n"+"12:30PM–4AM");}
        else if(parentName=="TGI Fridays") {
            address.setText("2nd Floor, Courtyard, DLF Place Saket, Saket District Centre, District Centre, Sector 6, Pushp Vihar, New Delhi, Delhi 110017");
            web.setText("liveinstyle.com");phone.setText("070531 27466");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Raasta Delhi") {
            address.setText("A2/A, SECOND FLOOR, AUROBINDO MARG, GREEN PARK, Block A, Green Park Extension, Green Park, New Delhi, Delhi 110016");
            web.setText("facebook.com");phone.setText("011 4942 4501");
            time.setText("All days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Soi 7") {
            address.setText("Unit No. No.205 To 208 & 209 A, Cyberhub, DLF Cyber City, DLF Phase 2, Sector 24, DLF Cyber City, DLF Phase 2, Sector 24, Gurugram, Haryana 122002");
            web.setText("liveinstyle.com");phone.setText("070531 28385");
            time.setText("All Days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="HouseA Club Delhi") {
            address.setText("Housea, Hyatt Regency Delhi,, Bhikaji Cama Place, RK Puram, New Delhi, Delhi 110066");
            web.setText("houseaclub.com");phone.setText("011 6677 1308");
            time.setText("Monday & tuesday\t\n" +
                    "Closed\n"+"Other Days\t\n" +
                    "7PM–4AM");}
        else if(parentName=="The Roxy Club") {
            address.setText("G-11 To 17, Fround Floor, Mangalam Paradise Mall, Sector-3, Rohini, Mangalam Place, Sector 3, Rohini, New Delhi, Delhi 110085");
            web.setText("theroxyclub.in");phone.setText("097186 02784");
            time.setText("All Days\t\n" +
                    "10AM–11PM");}
        else if(parentName=="Rick's") {
            address.setText("The Taj Mahal Hotel, No.1, Mansingh Road,, Near Khan Market, India Gate, South Block, Man Singh Road Area, New Delhi, Delhi 110011");
            web.setText("taj.tajhotels.com");phone.setText("011 6656 6162");
            time.setText("All Days\t\n" +
                    "12AM–12:30PM\n" +
                    "4PM–12AM");}
        else if(parentName=="Nero Le Meridien, Delhi, CP") {
            address.setText("Le Meridien, Windsor Place, Connaught Place, Windsor Place, New Delhi, Delhi 110001");
            web.setText("bars-pubs.liveinstyle.com");phone.setText("070531 27486");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="S Bar") {
            address.setText("N 10, First Floor, N Block Market, Greater Kailash 1, N Block, Greater Kailash I, New Delhi, Delhi 110048");
            web.setText("Unavailable");phone.setText("098999 33440");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Regency Club Lounge") {
            address.setText("6th Floor, Hyatt Regency Delhi, Bhikaiji Cama Place, Ring Road, Bhikaji Cama Place, RK Puram, New Delhi, Delhi 110022");
            web.setText("delhi.regency.hyatt.com");phone.setText("011 2679 1241");
            time.setText("All Days\t\n" +
                    "11AM–10PM");}
        else if(parentName=="TC Restaurant & Bar") {
            address.setText("81, Sri Aurobindo Marg, Adhchini Village, MMTC Colony, Adchini, New Delhi, Delhi 110017");
            web.setText("Unavailable");phone.setText("098107 08296");
            time.setText("All Days\t\n" +
                    "7:30PM–12AM");}
        else if(parentName=="Ssky Bar & Lounge") {
            address.setText("Floor No. 25, Antariksh Bhavan, KG Marg, Connaught Place, Connaught Place, New Delhi, Delhi 110001");
            web.setText("parikramarestaurant.com");phone.setText("011 3310 5027");
            time.setText("All Days\t\n" +
                    "7:30PM–12:30AM");}
        else if(parentName=="Office Office") {
            address.setText("48, Tolstoy Ln, Atul Grove Road, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("officeoffice.co");phone.setText("088265 94667");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Zygo") {
            address.setText("Shop No:46 Mgf Mall, MG Rd, DLF Phase 2, Sector 25, Sarhol, Haryana 122002");
            web.setText("zygo.com");phone.setText("099713 83999");
            time.setText("All Days\t\n" +
                    "10AM–10PM");}
        else if(parentName=="We2 Pub") {
            address.setText("M-43, M Block Market, Greater Kailash 1, M Block, Greater Kailash I, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("we2pub.wordpress.com");phone.setText("070396 81541");
            time.setText("All Days\t\n" +
                    "12:30–1AM\n" +
                    "11:30AM–12AM");}
        else if(parentName=="Ardor 2.1") {
            address.setText("No. 55, 56 & 88, 89, Outer Circle, Block N, Connaught Place, Block N, Connaught Place, New Delhi, Delhi 110001");
            web.setText("liveinstyle.com");phone.setText("011 4515 2266");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="7 Barrel Brew Pub") {
            address.setText("242A & 242B, 1st & 2nd Floor, DLF DLF Mega Mall, DLF Golf Course Road, DLF Phase, 1, Near Sikanderpur Metro Station, A Block, DLF Phase 1, Sector 28, Gurugram, Haryana 122002");
            web.setText("liveinstyle.com");phone.setText("011 3310 6482");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Ice Cube") {
            address.setText("Third Floor, 313, Great India Place Mall, Adjacent to Big Cinemas, Foot Over Bridge, Sector 38A, Sector 38, Noida, Uttar Pradesh 201301");
            web.setText("Unavailable");phone.setText("098993 70004");
            time.setText("All Days\t\n" +
                    "12–9:45PM");}
        else if(parentName=="Ssky Bar & Lounge") {
            address.setText("Floor No. 25, Antariksh Bhavan, KG Marg, Connaught Place, Connaught Place, New Delhi, Delhi 110001");
            web.setText("parikramarestaurant.com");phone.setText("011 3310 5027");
            time.setText("All Days\t\n" +
                    "7:30PM–12:30AM");}
        else if(parentName=="RPM Pub") {
            address.setText("RPM, 40, Priya Complex, Munirka Marg, Basant Lok, Vasant Vihar, Basant Lok, Vasant Vihar, New Delhi, Delhi 110057");
            web.setText("facebook.com");phone.setText("098997 32761");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="AM PM Café & Bar") {
            address.setText("J 2/5, 3rd & 4th Floor, B.K. Dutt Market, Najafgarh Rd, Block J, Rajouri Garden, Block J, Rajouri Garden, New Delhi, Delhi 110027");
            web.setText("ampm.in");phone.setText("011 3310 6012");
            time.setText("All Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="STORY CLUB AND LOUNGE") {
            address.setText("Number 1, Mehrauli-Gurgaon Rd, Sector 29, Gurugram, Haryana 122002");
            web.setText("thestory.club");phone.setText("0124 497 7777");
            time.setText("All Days\t\n" +
                    "4PM–12AM");}
        else if(parentName=="IKKA THE ACE BAR") {
            address.setText("A 19, Najafgarh Rd, Block A, Vishal Enclave, Rajouri Garden, New Delhi, Delhi 110027");
            web.setText("Unavailable");phone.setText("098212 39996");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Oval Bar") {
            address.setText("Aerocity, Indira Gandhi International Airport, New Delhi, Delhi 110037");
            web.setText("marriott.com");phone.setText("011 4521 2121");
            time.setText("All Days\t\n" +
                    "12PM–2AM");}
        else if(parentName=="Informal") {
            address.setText("52, Tolstoy Ln, Atul Grove Road, Janpath, Connaught Place, Atul Grove Road, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("bars-pubs.liveinstyle.com");phone.setText("099991 23201");
            time.setText("All Days\t\n" +
                    "12:30PM–1AM");}
        else if(parentName=="Monkey Bar") {
            address.setText("Plot No 11, Local Shopping Complex, Next to Mini Cooper Showroom, Pocket C 6 & 7, Vasant Kunj, Pocket 6, Sector C, Vasant Kunj, New Delhi, Delhi 110070");
            web.setText("monkeybarindia.com");phone.setText("011 3310 6238");
            time.setText("All Days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="Bulldogs") {
            address.setText("T6B, Second Floor, Hauz Khas Village, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("Unavailable");phone.setText("011 4352 4216");
            time.setText("All Days\t\n" +
                    "3PM–12:30AM");}
        else if(parentName=="Big Banana Restaurant and Bar") {
            address.setText("15 & 16, 1st Floor, J block Market,, Block N, Saket, New Delhi, Delhi 110017");
            web.setText("Unavailable");phone.setText("011 2956 2550");
            time.setText("All Days\t\n" +
                    "11:30AM–11:30PM");}
        else if(parentName=="Caffe 9 Restaurant & Lounge") {
            address.setText("P15, Ground Floor, Outer Circle, Connaught Place, Block P, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("098730 95720");
            time.setText("All Days\t\n" +
                    "8AM–1AM");}
        else if(parentName=="Urban Hub") {
            address.setText("41-A, Satyawati Marg, Block A, Kamla Nagar, Block 4, Roop Nagar, Delhi, 110007");
            web.setText("Unavailable");phone.setText("097113 11301");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Sutra Gastropub") {
            address.setText("201-202, Second Floor, Cyber Hub, DLF Cyber City, DLF Phase 2, Sector 24, Gurugram, Haryana 122022");
            web.setText("facebook.com");phone.setText("099586 36700");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Raasta") {
            address.setText("203, 204, 2nd Floor, Cyber Hub, NH-8, DLF Cyber City, DLF Phase 2, Sector 24, Gurugram, Haryana 122002");
            web.setText("bars-pubs.liveinstyle.com");phone.setText("011 3310 6200");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Blue Bar") {
            address.setText("Taj Palace, 2, Sardar Patel Marg, Diplomatic Enclave, IB Colony, Chanakyapuri, New Delhi, Delhi 110021");
            web.setText("taj.tajhotels.com");phone.setText("011 2611 0202");
            time.setText("All Days\t\n" +
                    "5PM–1AM");}
        else if(parentName=="A Ta Maison") {
            address.setText("21, First Floor, Market,Near, Khan Market, Sundar Nagar, New Delhi, Delhi 110003");
            web.setText("liveinstyle.com");phone.setText("098218 68288");
            time.setText("All Days\n"+"11AM–1AM");}
        else if(parentName=="Reverb Disc") {
            address.setText("Shop No 305A & 306,Level-3,The Great India Place Mall,Sector 38, Sector 38, Noida, Uttar Pradesh 201301");
            web.setText("Unavailable");phone.setText("0120 454 0204");
            time.setText("All Days\t\n" +
                    "12:30PM–1AM");}
        else if(parentName=="Molecule Air Bar") {
            address.setText("SCO- 53, 4th Floor, Sector 29, Sector 29, Gurugram, Haryana 122018");
            web.setText("liveinstyle.com");phone.setText("088266 77705");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Perch Wine & Coffee Bar") {
            address.setText("18-A Basant Lok Market, Basant Lok, Vasant Vihar, New Delhi, Delhi 110057");
            web.setText("facebook.com");phone.setText("085888 89199");
            time.setText("All Days\n"+"8AM–1AM");}
        else if(parentName=="Lanterns Kitchen & Bar") {
            address.setText("163-164 Rajendra Bhawan, Rehendral Place, Radha Soami Satsang, Prasad Nagar, Rajendra Place, Rajinder Nagar, New Delhi, Delhi 110008");
            web.setText("lanternsdelhi.com");phone.setText("090154 47000");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Open House") {
            address.setText("C 37, C Block, Block C, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("099996 11332");
            time.setText("All Days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="RockStar") {
            address.setText("D-2 Shop no.5&6 ground floor Southern Park, Saket, Pamposh Enclave, District Centre, Sector 6, Pushp Vihar, New Delhi, Delhi 110017");
            web.setText("Unavailable");phone.setText("098701 11955");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Zest") {
            address.setText("K-24, Sector 18, 1St. Floor, Near HSBC Bank, K Block, Pocket E, Sector 18, Noida, Uttar Pradesh 201301");
            web.setText("Unavailable");phone.setText("078400 06029");
            time.setText("All Days\n"+"12PM–12AM");}
        else if(parentName=="Hotel Arpit Palace") {
            address.setText("Hotel Arpit Palace Block 1, West Extension Area, Karol Bagh, Block 1, WEA, Karol Bagh, New Delhi, Delhi 110005");
            web.setText("hotelarpit.com");phone.setText("099999 99374");
            time.setText("All Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Café 27") {
            address.setText("26, Level 2, Kailash Colony Market, Kailash Colony, Greater Kailash, Kailash Colony, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("cafe27.in");phone.setText("011 6451 2727");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="3 Pegs Down") {
            address.setText("11/12/14-A, Ground Floor, Southern Park Mall, District Centre, Saket, Pamposh Enclave, District Centre, Sector 6, Pushp Vihar, New Delhi, Delhi 110017");
            web.setText("Unavailable");phone.setText("011 3958 9448");
            time.setText("All Days\t\n" +
                    "4PM–1AM");}
        else if(parentName=="The Junkyard Cafe") {
            address.setText("N-91, 2nd Floor, Outer Circle, Connaught Place, Opp KG Marg, Block N, Connaught Place, New Delhi, Delhi 110001");
            web.setText("bigfishventures.in");phone.setText("095999 47643");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Uber Lounge") {
            address.setText("M-42, Greater Kailash Phase- 2, Main Market, Block M, Greater Kailash II, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("liveinstyle.com");phone.setText("090691 26895");
            time.setText("All Days\t\n" +
                    "11:30AM–1:30AM");}
        else if(parentName=="Hell 2 Heaven") {
            address.setText("44A, Second Floor, Nehru Nagar, Shivaji Place, Vishal Enclave, Rajouri Garden, Delhi, 110027");
            web.setText("Unavailable");phone.setText("099999 87933");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Dramz Whisky Bar & Lounge") {
            address.setText("1580/1, KD Marg, Near Qutub Minar, Mehrauli, Seth Sarai, Mehrauli, New Delhi, Delhi 110030");
            web.setText("liveinstyle.com");phone.setText("096507 55555");
            time.setText("All Days\t\n" +
                    "12:30PM–12AM");}
        else if(parentName=="38 Barracks") {
            address.setText("M-38,Connaught Place, Outer Circle,Opp. Shanker Market,, Block M, Connaught Place, New Delhi, Delhi 110001");
            web.setText("movidacafe.com");phone.setText("097173 04097");
            time.setText("All Days\n"+"11:30AM–12AM");}
        else if(parentName=="Teddy Boy") {
            address.setText("N-4, Radial Road Number 1, Block N, Connaught Place, New Delhi, Delhi 110001");
            web.setText("teddyboy.co.in");phone.setText("099990 82777");
            time.setText("All days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="House of Commons") {
            address.setText("Block M, M 39 Second Floor, Outer Circle, Connaught Place, Opposite Shankar Market, Block M, Connaught Place, Delhi, 110001");
            web.setText("liveinstyle.com");phone.setText("090691 26483");
            time.setText("All Days\n"+"12PM–12AM");}
        else if(parentName=="The Food & Booze Exchange") {
            address.setText("2/11, Roop Nagar, Kamla Nagar, Block 2, Roop Nagar, Delhi, 110007");
            web.setText("Unavailable");phone.setText("088004 35444");
            time.setText("All Days\t\n" +
                    "10AM–10PM");}
        else if(parentName=="Nofilter Cafe") {
            address.setText("C-18, S.D.A. Market, Opp. IIT Gate, Block C 5, Hauz Khas Enclave, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("liveinstyle.com");phone.setText("098719 53328");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="My Bar Grill") {
            address.setText("3rd Floor, 28, Hauz Khas Village, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("mybardelhi.com");phone.setText("097110 54176");
            time.setText("All Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="Yes Minister Bowling,Bar & Kitchen") {
            address.setText("4, Sri Aurobindo Marg, Vijay Mandal Enclave, Kalu Sarai, Vijay Mandal Enclave, Kalu Sarai, New Delhi, Delhi 110016");
            web.setText("facebook.com");phone.setText("097114 95495");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Filmy Cafe & Bar") {
            address.setText("First Floor, PVR Plaza Building, H Block, Connaught Circus, Rajeev Chowk, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("011 6543 7777");
            time.setText("All Days\n"+"11AM–12AM");}
        else if(parentName=="Zai") {
            address.setText("Building No. 3, Local Shopping Complex, Masjid Moth,, Greater Kailash-2, Greater Kailash Part 3, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("liveinstyle.com");phone.setText("090691 26881");
            time.setText("All Days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="The Electric Room") {
            address.setText("The Lodhi Hotel, Lodhi Road, CGO Complex, Pragati Vihar, New Delhi, Delhi 110003");
            web.setText("thelodhi.com");phone.setText("098114 98074");
            time.setText("Monday\t"+"Closed\n"+"All Other Days\t\n" +
                    "9PM–4AM");}
        else if(parentName=="Farzi Cafe") {
            address.setText("E- 38/39, First Floor, Rajiv Chowk, Connaught Place, Block E, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("095998 89700");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Moon Shine Cafe And Bar") {
            address.setText("30, Second Floor, Hauz Khas Village, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("Unavailable");phone.setText("098998 28004");
            time.setText("All Days\t\n" +
                    "4PM–2AM");}
        else if(parentName=="Quoin") {
            address.setText("Asset No 02 GMR Hospitality District IGI Airport New Delhi, Aerocity,New Delhi-110037- Novotel Lobby Level, Aerocity, Indira Gandhi International Airport, New Delhi, Delhi 110037");
            web.setText("pullman-new-delhi-aerocity.com");phone.setText("011 4608 0838");
            time.setText("All Days\n"+"7AM–1AM");}
        else if(parentName=="Cross Roads Bar Restaurant") {
            address.setText("17A/1. W.E.A. Gurudwara Road, Karol Bagh, Opp. Jessa Ram Hospital Near Metro Station Pillar No.-99, Block 60, Karol Bagh, New Delhi, Delhi 110005");
            web.setText("hotelarpit.com");phone.setText("011 4522 2222");
            time.setText("All Days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Blues") {
            address.setText("N-18, Outer Circle, Connaught Place, Block N, Connaught Place, New Delhi, Delhi 110001");
            web.setText("liveinstyle.com");phone.setText("099990 20102");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="The Piano Man Jazz Club") {
            address.setText("B 6- Commercial Complex,Safdarjung Enclave Opp Deer Pa rk Nr Mother Dairy, Block B6, Humayunpur, Safdarjung Enclave, New Delhi, Delhi 110029");
            web.setText("thepianoman.in");phone.setText("011 4131 5181");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Garage inc.") {
            address.setText("2nd Floor, Building No 30, Hauz Khas Village, Deer Park, Hauz Khas, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("Unavailable");phone.setText("098184 71870");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="My Bar Cafe") {
            address.setText("M-45,1st Floor, M-Block Market, Near Hazoori Lal Jewellers, Greater Kailash, M Block, Greater Kailash I, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("mybardelhi.com");phone.setText("099999 38571");
            time.setText("All Days\n"+"11AM–1AM");}
        else if(parentName=="Grappa Bar") {
            address.setText("19, Ashoka Rd, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("shangri-la.com");phone.setText("011 4119 1030");
            time.setText("All Days\t\n" +
                    "12PM–3AM");}
        else if(parentName=="Uzzuri Deli & Bar") {
            address.setText("1/3, Scindia House, Next to Tribhuvandas Jewellers,, Atul Grove Road, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("011 3958 9646");
            time.setText("All Days\t\n" +
                    "9AM–12AM");}
        else if(parentName=="Sky Lounge Bar & Grill") {
            address.setText("19, Ashoka Road, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("hoteltheroyalplaza.com");phone.setText("011 4355 5555");
            time.setText("All Days\t\n" +
                    "12AM–11:30PM");}
        else if(parentName=="World Art Dining") {
            address.setText("80/1, NORTH WEST AVENUE ROAD, Punjabi Bagh, West Punjabi Bagh, Punjabi Bagh, New Delhi, Delhi 110026");
            web.setText("worldartdining.com");phone.setText("096438 00786");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="My Bar Square") {
            address.setText("No.E 34 & 35, 1st Floor, Inner Circle, Connaught Place, Block E, Connaught Place, New Delhi, Delhi 110001");
            web.setText("mybardelhi.com");phone.setText("096505 00411");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Ek Bar") {
            address.setText("D 17, First Floor, Defence Colony, Shiniwas Puri, Block D, Defence Colony, New Delhi, Delhi 110024");
            web.setText("ekbar.in");phone.setText("011 4168 8811");
            time.setText("Wednesday\t" +
                    "5PM–12:30AM\n" +
                    "Thursday\t" +
                    "5PM–12:30AM\n" +
                    "Friday\t" +
                    "5PM–12:30AM\n" +
                    "Saturday\t" +
                    "5PM–12:30AM\n" +
                    "Sunday\t" +
                    "12–3:30PM\n" +
                    "6PM–12:30AM\n" +
                    "Monday\t" +
                    "5PM–12:30AM\n" +
                    "Tuesday\t" +
                    "5PM–12:30AM");}
        else if(parentName=="The Oberoi") {
            address.setText("Dr. Zakir Hussain Marg, Delhi Golf Club, Golf Links, New Delhi, Delhi 110003");
            web.setText("oberoihotels.com");phone.setText("011 2389 0606");
            time.setText("Opens 24*7");}
        else if(parentName=="Ali Baba Caves") {
            address.setText("Building. No. 30 Village, Hauz Khas Village, Deer Park, Hauz Khas, New Delhi, Delhi 110016");
            web.setText("Unavailable");phone.setText("080101 29484");
            time.setText("All Days\t\n" +
                    "11:30AM–12:30AM");}
        else if(parentName=="My Bar Headquarters") {
            address.setText("N 49, 2nd Floor, Radial Road, Near Dominos, Connaught Place, Block N, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("078382 71741");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Def Col Social") {
            address.setText("28A, Defence Colony Market, Arjun Marg, Block A, Defence Colony, New Delhi, Delhi 110024");
            web.setText("Unavailable");phone.setText("078385 20799");
            time.setText("All days\t\n" +
                    "10:30AM–12AM");}
        else if(parentName=="Club BnB Shooters") {
            address.setText("Level -4, West Gate Mall, Rajouri Garden, Shivaji Place, Vishal Enclave, Tagore Garden Extension, New Delhi, Delhi 110027");
            web.setText("Unavailable");phone.setText("099995 63626");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Masabaa") {
            address.setText("37, NWA, GB Road, Punjabi Bagh, West Punjabi Bagh, Punjabi Bagh, New Delhi, Delhi 110026");
            web.setText("masabaa.com");phone.setText("095606 96920");
            time.setText("All Days\n"+"12–11:30PM");}
        else if(parentName=="Local") {
            address.setText("Ground Floor, Showroom No 11, Atmaram Mansion, Vakil Lane, Kasturba Gandhi Marg, Connaught Place, Atul Grove Road, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("bigfishventures.in");phone.setText("095995 53145");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Allure Bar & Restaurant") {
            address.setText("65- Desh Bandhu Gupta Road, Type 1, Aram Bagh, Paharganj, New Delhi, Delhi 110055");
            web.setText("Unavailable");phone.setText("097171 94109");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Raftaar High Speed Club & Lounge") {
            address.setText("15, Club Rd, West Punjabi Bagh, Punjabi Bagh, Delhi, 110026");
            web.setText("clicktable.com");phone.setText("096433 39742");
            time.setText("All days\t\n" +
                    "12:30PM–12AM");}
        else if(parentName=="Castle 9") {
            address.setText("B 45/47, 1st Floor, Near PVR Plaza, Connaught Place, Block B, Connaught Place, New Delhi, Delhi 110001");
            web.setText("castle9.com");phone.setText("098997 44947");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Indian Accent") {
            address.setText("The Lodhi, Lodhi Road, CGO Complex, Pragati Vihar, New Delhi, Delhi 110003");
            web.setText("indianaccent.com");phone.setText("098711 17968");
            time.setText("All Days\n"+"12–2:30PM\n" +
                    "7–10:30PM");}
        else if(parentName=="The Beer Cafe") {
            address.setText("710, Shivaji Marg, Narang Colony, Janakpuri District Center, Janakpuri, Delhi, 110058");
            web.setText("thebeercafe.com");phone.setText("011 2551 1036");
            time.setText("All Days\t\n" +
                    "11AM–11PM");}
        else if(parentName=="Aroma Restaurant and Bar") {
            address.setText("18, First Floor, Ashish Corporate Tower, Community Centre, Maharshi Valmiki Marg, Karkardooma, Karkar Duma, Karkardooma, Anand Vihar, New Delhi, Delhi 110092");
            web.setText("Unavailable");phone.setText("011 2237 4085");
            time.setText("All Days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Lights Camera Action") {
            address.setText("J2/6B, 3rd & 4th Floor, BK Dutta Market, Rajouri Garden, Block J, Rajouri Garden, New Delhi, Delhi 110021");
            web.setText("facebook.com");phone.setText("011 4704 1334");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="The Suryaa New Delhi") {
            address.setText("New Friends Colony, Friends Colony West, New Friends Colony, New Delhi, Delhi 110025");
            web.setText("thesuryaa.com");phone.setText("011 2683 5070");
            time.setText("Opens 24*7");}
        else if(parentName=="Tapas, Jaypee Vasant Continental") {
            address.setText("Jaypee Vasant Continental, Munirka Marg, Basant Lok, Vasant Vihar, New Delhi, Delhi 110057");
            web.setText("jaypeehotels.com");phone.setText("011 2614 8800");
            time.setText("All Days\t\n" +
                    "12:30–3PM\n" +
                    "7:30–11:30PM");}
        else if(parentName=="Parikrama The Revolving Restaurant") {
            address.setText("25th floor, Antriksh Bhavan, Kasturba Gandhi Marg, Connaught Place, Barakhamba, New Delhi, Delhi 110001");
            web.setText("parikramarestaurant.com");phone.setText("011 2372 1616");
            time.setText("All Days\t\n" +
                    "12:30–11PM");}
        else if(parentName=="Adda by Striker") {
            address.setText("SCO-24, 1st Floor, Sector 29, Gurugram, Haryana 122002");
            web.setText("bars-pubs.liveinstyle.com");phone.setText("082875 67265");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Bombay Bar") {
            address.setText("P, 21/90, Connaught Circus, Block H, Connaught Place, Block P, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("098113 11106");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="The Beer Cafe") {
            address.setText("Tribhovandas House, 1/, Connaught Circus, Atul Grove Road, Janpath, Connaught Place, New Delhi, Delhi 110001");
            web.setText("thebeercafe.com");phone.setText("011 4352 8754");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Lord of the Drinks Chamber") {
            address.setText("A13, Najafgarh Road, Block A, Vishal Enclave, Rajouri Garden, Block A, Vishal Enclave, Rajouri Garden, New Delhi, Delhi 110027");
            web.setText("lordofthedrinks.in");phone.setText("099991 09766");
            time.setText("All Days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="Thugs") {
            address.setText("4/15A, Hotel Broadway, Asaf Ali Road, Chatta lal Miya, Chandni Mahal, Old Delhi, New Delhi, Delhi 110002");
            web.setText("hotelbroadwaydelhi.com");phone.setText("011 4366 3600");
            time.setText("All Days\n"+"12–11:30PM");}
        else if(parentName=="Platinum Lounge") {
            address.setText("Ground Floor, Star City Mall, Mayur Place, Mayur Vihar Phase 1, New Delhi, Delhi 110091");
            web.setText("Unavailable");phone.setText("011 4250 8000");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="1 Cafe Lounge") {
            address.setText("M 89/90, 1st Floor, Outer Circle, Connaught Place, Block M, Connaught Place, New Delhi, Delhi 110001");
            web.setText("Unavailable");phone.setText("098363 78979");
            time.setText("All Days\t\n" +
                    "10AM–9PM");}
        else if(parentName=="Manhattan Bar Exchange And Brewery") {
            address.setText("Global Foyer Mall, Unit 001, First Floor, Golf Course Road, Sector 43, Sector 43, Gurugram, Haryana 122002");
            web.setText("zomato.com");phone.setText("088006 97549");
            time.setText("All Days\t\n" +
                    "1PM–1AM");}
        else if(parentName=="Olive Bar and Kitchen Restaurant") {
            address.setText("Kalkadas Marg , Mehrauli, Seth Sarai, Mehrauli, New Delhi, Delhi 110030");
            web.setText("olivebarandkitchen.com");phone.setText("098102 35472");
            time.setText("All Days\t\n" +
                    "11AM–12AM");}
        else if(parentName=="The Sky High") {
            address.setText("C 306A, 307,T101,102, Ansal plaza mall, hudco place, Hudco Place, Andrews Ganj Extension, Andrews Ganj, New Delhi, Delhi 110049");
            web.setText("theskyhigh.in");phone.setText("011 3958 9598");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="1911 Bar") {
            address.setText("The Imperial Janpath Lane, Connaught Place, Janpath, Connaught Place, Delhi, 110001");
            web.setText("liveinstyle.com");phone.setText("090151 37605");
            time.setText("All Days\t\n" +
                    "11:30AM–12:30AM");}
        else if(parentName=="Tipple") {
            address.setText("Vivanta by Taj - Dwarka, Sector 21, Dwarka, Metro Station Complex, Sector 21, Dwarka, Delhi, 110075");
            web.setText("vivanta.tajhotels.com");phone.setText("011 6600 3000");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Savannah Bar") {
            address.setText("Delhi-Gurgaon Expressway, Near Mahipalpur Extension, Mahipalpur, Block R, Mahipalpur Village, Mahipalpur, New Delhi, Delhi 110037");
            web.setText("radissonblu.com");phone.setText("011 2677 9191");
            time.setText("All Days\n"+"11AM–1AM");}
        else if(parentName=="BED") {
            address.setText("N-17, Greater Kailash-I, N Block, Greater Kailash I, New Delhi, Delhi 110048");
            web.setText("beddelhi.com");phone.setText("098102 26456");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Londoners Bistro & Pub") {
            address.setText("M-25, 1st & 2nd Floor, M Block Market, Greater Kailash 1, M Block, Greater Kailash I, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("facebook.com");phone.setText("099991 26096");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="UpTown Cafe") {
            address.setText("4-5, Satya Niketan Rd, Satya Niketan, South Moti Bagh, New Delhi, Delhi 110021");
            web.setText("Unavailable");phone.setText("072190 80000");
            time.setText("All days\t\n" +
                    "11AM–11:30PM");}
        else if(parentName=="Bohca - Bar & Restaurant") {
            address.setText("Siri Institutional Area, Block A, Siri Fort Institutional Area, Siri Fort, Siri Institutional Area, Siri Fort Institutional Area, Siri Fort, New Delhi, Delhi 110049");
            web.setText("Unavailable");phone.setText("098701 00866");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="True Blue Resto & Bar") {
            address.setText("D.D.A Local Shopping Complex, Behind SBI & HDFC Bank, Kondli, Mayur Vihar, Phase III, Sector C, New Delhi, Delhi 110096");
            web.setText("Unavailable");phone.setText("011 4508 4084");
            time.setText("All days\t\n" +
                    "11:30AM–12AM");}
        else if(parentName=="Jail Behind The Bar") {
            address.setText("B-8, Model Town, Main Market, Block B, Model Town Phase I, Model Town, Delhi, 110009");
            web.setText("Unavailable");phone.setText("011 4758 1459");
            time.setText("All Days\t\n" +
                    "12PM–12AM");}
        else if(parentName=="Sinciti") {
            address.setText("Gopal Heights first floor, Netaji Subash Place, Wazirpur, Delhi, 110034");
            web.setText("Unavailable");phone.setText("099999 66053");
            time.setText("All Days\t\n" +
                    "12PM–3AM");}
        else if(parentName=="Hawalat") {
            address.setText("16 N.W.A, Club Road, Punjabi Bagh, Punjabi Bagh, New Delhi, Delhi 110026");
            web.setText("Unavailable");phone.setText("085279 84567");
            time.setText("All Days\t\n" +
                    "11AM–1AM");}
        else if(parentName=="Boom Box Cafe Reloaded") {
            address.setText("C-10, Tagore Garden, Block A, Vishal Enclave, Tagore Garden Extension, New Delhi, Delhi 110027");
            web.setText("Unavailable");phone.setText("095990 67938");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="HotMess Kitchen & Bar") {
            address.setText("M-11, Middle Circle, Connaught Place, Block M, Connaught Place, New Delhi, Delhi 110001");
            web.setText("hotmess.co.in");phone.setText("011 4365 0782");
            time.setText("All Days\t\n" +
                    "12PM–1AM");}
        else if(parentName=="Gastronomica") {
            address.setText("M-55, Second Floor, Above Citibank ATM, M Block Market, Greater Kailash 1, M Block, Greater Kailash I, Greater Kailash, New Delhi, Delhi 110048");
            web.setText("gastronomica.in");phone.setText("099711 72933");
            time.setText("All Days\t\n" +
                    "12PM–12:30AM");}
        else if(parentName=="The Headquarter") {
            address.setText("C-8, Vishal Enclave, Rajouri Garden, Delhi, Rajouri Garden, West Delhi, Block A, Vishal Enclave, Rajouri Garden, New Delhi, Delhi 110027");
            web.setText("Unavailable");phone.setText("099995 58579");
            time.setText("All days\n"+"12–11PM");}
        else if(parentName=="RDX Fine Drink and Restaurant") {
            address.setText("AB-4, Kamal Cinema Complex, Safdarjung Enclave, Block A 1, Nauroji Nagar, Safdarjung Enclave, New Delhi, Delhi 110029");
            web.setText("Unavailable");phone.setText("011 4102 1400");
            time.setText("All Days\n"+"12PM–1AM");}
        else if(parentName=="Jazbaa Bar & Lounge") {
            address.setText("F-89, Vishal Enclave, Opposite TDI Paragon Mall, Rajouri, Garden, New, Delhi, Shivaji Place, Vishal Enclave, Tagore Garden Extension, New Delhi, Delhi 110027");
            web.setText("facebook.com");phone.setText("011 4955 5777");
            time.setText("All Days\t\n" +
                    "11AM–1:30AM");}
        else if(parentName=="BarShala") {
            address.setText("2, Community Center, Near Sapna Cinema, East of Kailash, D Block, East of Kailash, New Delhi, Delhi 110065");
            web.setText("barshala.com");phone.setText("098918 00000");
            time.setText("All Days\t\n" +
                    "11AM–12:30AM");}
        else if(parentName=="Route 04") {
            address.setText("K2, Middle lane, Near Odeon, Connaught Place, Block K, Connaught Place, New Delhi, Delhi 110001");
            web.setText("facebook.com");phone.setText("097175 90444");
            time.setText("All Days\n"+"11:30AM–1AM");}

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
        if(namee=="RSVP") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNgmpeSRizR_N1BhkkRMJyl9dOuzTQatfU7_XUN=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Privee") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/1A0Nk2r-cl77Q8FAoG2jPxzL3pyxXRkFjVqHZb9XFPxJD0xDU2GAoOy5KYa7CVucGdPBnKlzAHiujBjpgVs3Kox7UfHSLf6uQn2rbuNgjOi2z2-VUIECEVojTaV1O8D2NQRHGLvydNd2pM7e-1cphI6KQJOgxg=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Kitty Su") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/4kbUxNXENdZQH-MqWlVcMkKi2V2WCY-zolBFtt6Ft_BlZ1yjIn_5FGmV3zAem1fwLi_4Gb_j6h5IDCj3uYGwnCVhtUyK1QPQ8CStpNr50zw0Pk97mAQ6e9vk9mS5aTvhqgW57pVul1GRr7seA6W28AkSCHf_iQ=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Playboy Club New Delhi") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMZl5TyhjHbkLfACk-tt-8wq3Rq7aCK9rvWMa4I=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Keya") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/9_OqWCC1tv5pSkbXzUQ2s-nlQ9EwxYpV9roFwTuYknn8Hxuqi1r9rMguM1DsiCFHxZvIL49vO7TAjbgoAB_pOwo_w5yCrGa7Kd6RPEKkieAmk2taMjQzSNCgcSeoQyzJpymI_IX_XN5h_3cChTtjazXK0-qUfbk=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="i-Kandy") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNMcsRxznsrGC5ShF_mutdVEuT1TF08vwDBKayB=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Agni") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/fxNXG5ErEVxUsp9pbKWi1b5zlyjBcKCwdhy35UWEFD5fTXdYguQsKvJviN0PwgdvAOWAjGOJw3xtYGp52uM1spDwStHIWA2MHiJN1jaTI2jHARF6cZOhhhQ9UY80KX3NRlB9NfNkmr9SYf7uF0pcHEs_KB9dWQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hype") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/mEtqrkn4jnF-R2SGv1PKyHVizLp62U879aaDEBnf2HhqtSh81G8wa49tSA04YbX4lZbZjX-GYHd0QqdLIHxg6h7bdpJrSbtvd7JtlIBdMXn9devfy67uFLje8FBuEG9E-adNj6R0NdGt4F5x58OrS_NBpR3fvA=w408-h206-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club London") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/a_VmtcwmWiW3BZNYjPel1mbfEZL4p4zKnnYwMVisHaAwoKsRY-DHT8A9JhGKA0BdYamA9Sgfk2MfdvutoQZ-VJANJRO6tM4W27_-fezqrr-WmVDvnv3dk0D79gXN_ZlEgcGF3BT7d_CdtxcorIJMqykrHSgF3w=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Summer House Cafe") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Twv-fUNUruj_r0plRNej6bX1l0wZbyGIUDbCPDY8Tbq_w_LRNKC4wZVNiS0lXBnHZWNgCAjGetxzdLE1_d3PTJnz2cVV2T7vejBaDOdX3RHoBBa64bktpbDLzyfo7FMvzr5Sn_cVydGX6Vi3bEmNkXLZEFiH6A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club BW") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/FcOSNRfDKQ-qWQI3pwERkG-Bte2VMEwaA0sre_foWtGm4q1MVxW5ExBTjys3qbZXJeopbyOHwpxnRVLi1vA6uT9up4nssapEhJAtOkIgflMspVviNMQyDInzWLcd_6xPJSLr_3zRgqWLjh1TI9LME3BkqWLx5A=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Imperfecto") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOLbA4w0GR1AtHZRmxk-h2MEjRsaD8Rw7TP0D5b=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hauz Khas Social") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/2IsBRhDb9i4EgUEakfqbLOWgtlkMLSubKFJTALoafhcfseXUEiEv7o6k0i_EOYFre9NRkkWuW3Ql3s43DjX60KG64_GUbvP5JksN7aryGlCP0xg6FfIRsE9zSxfAAezeil1lhK6BzWBl6DvamB9GdjkeIA=w408-h212-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lord of the Drinks") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNdSWridXOp1MPamMXBl_Cr3FxQ2eNoC-UNGkVF=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="G Bar - The Grand") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/SCuFHCKv0w_hLf0FbhOny89EF1h-RBZauqhdO2xb297vehu6gp7T7MvYrbImgrUgKXgZyfdObLqhZ0dIJH6DtEajddTqASYohN1I6ct4HoTn9Whr4P15KTUd1A0L2R97qPYRWSumOAqETfXpRmEEto-lxP0wzp0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tamasha") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM_xHFUuq4hgv594E9HKL5xWHFEGOLXl7CN1qQc=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="PCO Bar, Delhi, Vasant Vihar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNydld33-FmhD25X28OUAiVQ7qGucFAv5qZzWgz=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cafe MRP") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOE8GuAoTJNZD1Gkkj9sY3Lk_viWB3_RPkvv-Rq=w408-h260-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Kabooze") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNBAIrgbY57NfrYFxwu-mCZBMLnvorGbtfG88Qq=w408-h343-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Zaradise NightClub") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP7763o4KAC3M7w5TOmql-e9j0H3kctbTs5ecjc=w408-h616-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="TGI Fridays") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOwISisQA38jfh6wx1m381JEBWk-AvUzYshFXa0=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Raasta Delhi") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNzi77l5HC80Mwi_mQuBKPYpFKFz4PEnclsAqQM=w408-h227-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Soi 7") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN4ZnhnskgGy3YtKLJsHAenoHFDSxNzSjvKE4AW=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="HouseA Club Delhi") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMoeUOqVdhcJerEs6ih0V6WBcPjf8Dk3r-e-Xoz=w408-h406-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Roxy Club") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOXzktBzL9rzSVWwsJVQh5v-dp-7PTsvYvxqpgn=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Rick's") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/ezVDQ_Xv5wh6RcawgaNDePM39YnTOpw4YEnABmolo4oGM9DAu5jlMVI2vikdrv7GglisR6xum_PO1aPeoSXnH2exilnWz3OAoWzzN7yz2V_5Y21m1gy5Y6LPVG6tO-pBhlJK_nzgs-Go3amT2pDecGi7pMDYvw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Nero Le Meridien, Delhi, CP") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNdgZiz851vrsVOeHq2SNDd5X9u-lcSPITeDwWS=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="S Bar") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/91DrvtoTWwCjnfYLhQdQLeJvpKgecRHdC1LyNNJIpmOaV6N-GuoeR7IS30kwQYBTbD-GEXrwGXKCVAgAFM9dO94PxHsC62z9c0onUdxMKbBv9-e3tM97VOQz7XuVhLqpiGHgXSMmkqOERAToDVBPjkPNjWyzhg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Regency Club Lounge") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPnKiDqJgCWR4x1qB2i0kDNwZUUEDbt_xBd9PFn=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="TC Restaurant & Bar") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/0-3I58NneWWCPjyxSyaYp4uC8kPlY7D0_xXcs_lo1_18684ia9IHR0boX5dZBh7S_2SQx0TLd230fZSEroaA7VfgtVSMJpKqSwixqJvxptCSEiOxu8U125zs4sL9Ko4x3xm0dOh7Zpvq9xl4Y8UB45YlA6BMqA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ssky Bar & Lounge") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/eh8CVaL2u2oT8aJhPM3G8vrJFQKUp7OWDvugA75HEwoURlACoyLOXM57HOsF-Fez0IzY1mXJSHsLeQmcPd5KNmscYY3B3YDyihzsfLwB8upuumrdT3GKkisuNVsgmWfE0k2Db_rm3l7oen0qaYqrru5S0O-_AJg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Office Office") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/gEkT_wSElv3V33WppVV6YASclATDvfYdJlli0qnnHsRi8EctwzMaaUTFp5Wa4l6OYzS4fL2v2gnpwKR83WT1afRdVfFzTNiHHQg2yhSbgjA7HNxdVlkq0h-JHksv6AA2iznVv-BJf3FAnwlJ4y-chRQtnBcDNzI=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Zygo") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/odul8YHOTyReeo885u4-Vim1muVsLtKZNM_EU5dSk_aw5GobtqzfXkehTMSnUuiVyknKoXw73XwHWKdRm0O_jMLP5c7-827vEqzVGZLpwlzgyjjIFNG88EHHnHL0lsYpoWSF_2OfqQs6qrpxU5_9uXJBPkLeHQ=w408-h206-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="We2 Pub") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOxF6Ft1ZXMIvl7QCdxqtkzUHhep1JtGGHRl9KX=w408-h295-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ardor 2.1") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMkqf7rdRn4S0-YyJvQOtRRuHWfb7fxSiZaAwYb=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="7 Barrel Brew Pub") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNrgJrDa6_shfXLhAwe4I7M1l-GQLyD_ALDF5Lf=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ice Cube") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/60fu7_XHZoGmwKAPtp282RJ-K8dvmNIN1q5W9ZLuTUptXitVg0sqnEdVMAAuT7h9V5tV5ZmzLNJ02WDqL-c1dJTdSjCPnvtpVkLA1sWn1_6LSeUwMBEqnUxqNrQM9hDXCi0oNSDOqNdyZo34J-3Yo2q7ixA1WhE=w408-h251-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ssky Bar & Lounge") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/eh8CVaL2u2oT8aJhPM3G8vrJFQKUp7OWDvugA75HEwoURlACoyLOXM57HOsF-Fez0IzY1mXJSHsLeQmcPd5KNmscYY3B3YDyihzsfLwB8upuumrdT3GKkisuNVsgmWfE0k2Db_rm3l7oen0qaYqrru5S0O-_AJg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="RPM Pub") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOaE-RnyEIaV4fegzf_V3oEABe01g-9ifyKn8TW=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="AM PM Café & Bar") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/vevts5U2j5tkq5pcNwXWWg6U_0ggv7VclPXcfQ-yscYxqAxqqz1sEpcY-CsTZBptUbYtMaRN32i2X9fbb1ZHyJ2WY_NyGBt--RWs3-iv_FVcPPjgFKiHBTquDN-qttx-2QEeoxKPlYIWfsG98YUUgN0mrhqpng=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="STORY CLUB AND LOUNGE") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/PqiL2ZIPYiPw-0iq7bOsPOI5DZAPAUu8Q9Vcnbqxl1ncoxpZN7eUDNTffw-PIGrihfdajfQ73J3ARWkaEdrqNDuwxSHo77bS3Fh-yhkRGxwdpQ2zeIvTuP8wwxB9knUnEyX_k3Y9UKCb_AJ2ZKHR0D0tp_nsNe0=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="IKKA THE ACE BAR") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNfN9t58-AfVU_5SkFajBK2pGuPIDsv6aDlv-Ki=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Oval Bar") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/i6OTGECjqqVfhCpA8ZNCGl8ZVehJqWTpGGBv-ivD8p8Bsi5I38GAcanrr63o6LCkPfId2axxISlwxmG-tABmyb6nsOH527UvsXVhZM8vu4Ii-5Umkgneb-VcXGoLDYeFPbIjOcqsJlRRUdxc-rnuxE7aiIFzsg=w408-h202-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Informal") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/0R63_S5oKjcuyWI6JNVIwMg1_OQwiI279oiwx8yxD5p9ItRuDRVyGm_ihSZDI3ti93I6k5dLjWbIpFUx4Fn70AlrD1BqmwGbI7ar8DIoVjDv2IoaeA8RNQkZ9wdq1K-J0xp4HZ9rpZDuBSNh1Sp-RbCCVR-D1Q=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Monkey Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMatboOctgCWso_NHa1YLFCg1bcGHw2g0ZFkKqA=w458-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bulldogs") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/qHm1fKCFyrWS0E2X2UfVMFVrsFX0ANeFpcAfNCHDUOnqwhschgucVeXvNa44D7Hxgg7kGMbV3Tq1VeihcHg9viC7iHiGjWgn7yJhteDep0ioAz59HdomZAcCNHtPi2U1_RPlc-HXb1i6422dw_JqaM0N7r3sug=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Big Banana Restaurant and Bar") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/J5sJnLCVs1hd8pL2kksGEWwu7wr0w5Yk2y5tOKp62YgJBiydppmkqf71UphYfq6gfvWsrNGk1Ubhun9YUA8_EJ4ZZbeeSi8OvHp6Gd-0yM8h44sXtH315vagiXNzpOe-omHyQKvipgWnC5J8HBa_zN_6ljC5zQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Caffe 9 Restaurant & Lounge") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOQwJlr3gkmb0CwI55qLq82_SHanqk-eM_2ZFUs=w408-h235-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Urban Hub") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/9amcbjYQ2Boj5n8IKB3ReYne8ZFZVZiCVBxEMxhA3xus34zICziKgqAGtkG_HM4eYWcO19f7e0HDTj04ab_fG1T9XaaE4_BfgkIjmECIzPtnPIMUBwh1P4twrAYi8lxCHeeBUswj113nTNWs6isOchMDo7PHmpU=w408-h280-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sutra Gastropub") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM8CtlCPNyLQ77sN9k2F3lLaxR7l2MTTlH_BBoC=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Raasta") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPiA7aTixRP1WcJusBHrh0jfOwBGSvMsG5yqg7J=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Blue Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMR-PGpkDRdq3npuGZzpnos0M3BKnPkTmkffx2k=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="A Ta Maison") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM8CaKS9cFt_LPyHW2-86JlFvYPxC7BkGNzxdjW=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Reverb Disc") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Wr73zt93T39EarQFo-qcCoCVUw4sssCmYv0kRzFi2YxeILJhd4cMi9Zv3aVqysIShWGQh0Ub3B5kHqWrSSXUkZ4O6qBZSCj6umbEYEOu71302ItT-kqs2OgoFdiuFMLO0-G9B5XHWQ64WHK43ylY-ZfVsRLU7g=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Molecule Air Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO7IQBu2TV_qRdqQKXD1H7jiG5uUVIyzYTjWtQX=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Perch Wine & Coffee Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOgi3RD-hlco4hwohFBl9gCzL9coVAhrVu9O82Q=w539-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lanterns Kitchen & Bar") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/8VZvxQJQMjWzsy2uE23LJjnA6fZ7xJvh1jlfoNDjmv_fIzCHAQI99PEjCRGy9K8B6YZCOaa9j0AXBX6py9cmh4i_1DckXZUIi5v4vlMmrEMCl1RdapHSXiWlRRg5xqK1sXM5Qb3FPFlNf9WKkeiQ2uDejAY-jSw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Open House") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/mNSUjdHEAgVcBoDP8MUnfG6a_AWHg_KR4_r_K53wTeSmYDbFuEFbwEweMM86KGFt4nJr-HF7r2asPOh44AEqFfvTpo33O8l-jX3H8nb0WXluy0ixEk3YXC2sBuqOSf-ySInYDvqcoar5V0PJdrkRs3Kmul_SRA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="RockStar") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/MrwcT_Y1EM4VpTuMD-pv3HM68Fzp9NYAfz7iw99a3AbB77t4f2Px1062MAKTbjxA_z4A5NxdUNJxK5QBjaKPNRhgAR8fKfa0CWSccRQvswLJeGvm1kdSqrPm7D3Tl7cLEem1zjKBoSlm675b-3QDbyOnkW9Jvas=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Zest") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/gwMX4mBuXefjT2wuePG7jSVOmjjgRHg-1KURlC6L-lRiqxJRRYH7IGjHsICZJMwBUM9Z5yEPWmpcyyXSIkv50LUrPvnkDo-ONBA7xY1iGiwi9lTKyhCSya1hqMyWT-WARtRFNC5IHjx-yjh-7mE5mr0ZS0q7yg=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hotel Arpit Palace") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO6YYGF9Xgakq5c7zqywQFjO4qYz5K8VRCACXI_=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Café 27") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/JtGUftm0JJT7t3fH-D4TZug-aa57eRqnEGPBotkGFvrm5gEZ5V5qBHgHeoPRY-fvssnjnYLXH9d0pvURXRvD_Exmibe5cIYabaT3DxMkZVU_8eYxlPuOHK7uv1hkP4_JHWQipmIuQgq9I1V8UbeDEMefayMaNA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="3 Pegs Down") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/MSn-j1_g4FNyXSYHBgLSAs_VT1V34dDWYNr9VaRIpzH86QHloaxxilWooQsb78nTYkeIVCNp6NieUkY00u7pBPCqHBVsh-VfzxFCFtOv93wxPowsU6FeOCPGdge831gAAgR9hHW8lJTenTS1FUWqTIiuZAh7SEg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Junkyard Cafe") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Go-tfjwAdiys6-YIfpMJ-0cK9bIxGqMRXh-J6MSycKFoSiufnWsrmJSOzMR3ke5mz8CvlIJvXnq_eon9m9NBd22V5jfTMrmcwyUu5qaP_4WB_pLIVaEY4SjW2lA0YeaLNQtkKTg4tnCxwQGzRQSWj4IRMWfY2vk=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Uber Lounge") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Lo7QDp7ijnY8YSY9_or2CBWZzzxNe34KyUuwywgK2v_7RPvOO4yl40M52f4LIot2QdtH6P_chjCodNNbSA7ZCULtn9FP6mdXkR-zPwf_fKzlc3ZSZtLV_8_zNYuz1wUGA5_FxZtDlahF6Z6xbfodQHRi2SCJTKM=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hell 2 Heaven") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOavANK1RBFQdURS3fMldIvveD5XI8kbMqTTO5r=w408-h203-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Dramz Whisky Bar & Lounge") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/ykR9iDPJzIHeURJX2hLDu6vK7SSeGA_2R1ht95QAGzh9-4kdzCGCXuJosJUI5XWIjPeOjVHchqdTH8M4YpJ9n_LaAUS2OdWssgilBMeAoKDETMDxw0HA9ocAnhjYvKtQwYAlrOWVFmKaQo21ZODnPzrJAVJtzg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="38 Barracks") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Sz4nFR1motmF9RS1CWUkAHOutEHKQGPD21qSfFiKFsBIh854M0z6YQqQ-hqf3lYlEZAMwASBjZd_5b78Y8Nnq2wokjjuG0c2Gzqr5mKeoy11TG9M4B5vR1-8wQTQ7uaQoDe8pk_5N_K1sP8XbYg7d87eqsrvkw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Teddy Boy") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMC79DRh2ha_fENebnR3dbWP7dKLNLMSzkHU1sl=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="House of Commons") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOOXC7--325xfpUskR3KE5QyLL_GtscI5QH-SUQ=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Food & Booze Exchange") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/uuZEfievnYoYKZVw0Se9IA7Ouvy0cptfpMpwQ3E-FC-ohgg2ZlTSFQ2ftQWXy_d6NiuqPiXQ3B8fsmhDU5Tdwz5l9qQz3SB1BaVUZyGlBFANzz46BMK1RbZMfuaEKJm17CCyw6fRZ3UdQlAC4Oe0NZSzj84cqQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Nofilter Cafe") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/xNcbloC_WZIr3uDnqj9YGs0_kQlhpOAn5p3JPWZgvEhHxF0sMUzbMAev4fPcXjVO7GRyKqCctVF4jNSpqardM-UcFHZSQOyZ_QBlDjpiSmM6JDFybQmAMJWw79auV0BlUPDrRFxJcdLKUeJ_a0nRCAKOSvDVfQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="My Bar Grill") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/0KUdJ1IQOqFhhGCNrg1QNaSvsuJ8V2I_aVb6F8vH3YvPsfe0jLsrot6qWK84N36WmLElMUCkPKym71-Rr9p-BwbigJ-R5NPkvmTp3ZJFSE_ZMDALwtkh04jsCwe44YHrReEXCNbCMmB-h8oEaHtX5hc9Y4Lc-00=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Yes Minister Bowling,Bar & Kitchen") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/vAQYzmYe5CBXYHF4SYYRXD2TNafmgt138NDN38J1zb2WeMmrMjxq68QgCDb0N3ziQKoiYqWAS1UyUEn4KYxBYm8giiOb6aJZkfilx0iM4D5yUwNRDSX67zahRfRxW7_RiCh85e6fiPsYsYULY92Z-BG1IXTsrwQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Filmy Cafe & Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNiWOCNfpf20X7Y1jseUTAsk6N2RaSDyvTiiR2V=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Zai") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/m1HY6Jnkwrc9FBj_JED0TLubfWttL98ciOIps1ER7bZM1rHnaNS01BD6mADiOYVWWSrJldfdHuF4oyEqRGiisvqm2YztPAP_SO1kWh0-vke1pF-eGk0--QOmBO9eG3YhtqhrZlw0YpV2TsZCpvbxzr4ZP39kUg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Electric Room") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMjDa3HjeqOL0nuIOtLx28NR2EzASJB47aq1c-h=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Farzi Cafe") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNjmh9iTxh6c9x2aWIG60vnlzDlf4kOJ-BB6eg=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Moon Shine Cafe And Bar") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/KVB-N_yk8fni3ahHqmxU-inVq4s9ARRRjNgFcbGiyNHo1cZK0eXoRJwQCij1gtukD8H7ibP9B6yO7eBZ5a4HntDpl29L9dlNWNkcUXcog6muusICl6BYh0Q8Gvd6Lb_YI-h3v5a4KB6NZ7M8u-_S3nOszYC42Mo=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Quoin") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOUtvfH4jKXUxhjJFxdfm6L-mGbxZ_YeFem4etS=w408-h406-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cross Roads Bar Restaurant") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNuBZrCVYC4rvTsywVl-uY8s_kl26TyOY2LUMoR=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Blues") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOed-cIF8Ji87rR6OH4mFtkPTwIX0BzMAvrr_20=w408-h200-k-no-pi-2.9338646-ya66.99573-ro-0-fo100").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Piano Man Jazz Club") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/WcTCjVpLGqn5txTtKqLEuR_kXdOo7mo9FUHIKzpa9ZItDjn_1erobiZKZh3BePi0TGMFBTfQkdrOA2tv6i5akP2fQiUSp8RwSHVMFdQPtqSUHr71TIcp2wsMP1JtvBk8EJQXhdrzTPRFBr_710I2_Bl3dxs4Eg=w519-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Garage inc.") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/S88N6jX8bZ0mFxMllYkWi_Uwu4OQtkPgNOLdZ9yejhTmd74seNvqTkL_9N-uFOVjWLzhgHxdtHAetgmmBWsBTqofh_1D6-PNWpVNj8mIytTwHoBW4ariXyquIJX0Ft0IbLhuA4OO9Nted52G3QXNssyOSzLJRpg=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="My Bar Cafe") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/dLE0JGWoADzCTMGUMfE10Q-QKsCHjCr6CgTo0yRuflI7U_wjxr_abJF7HmyImEsVmTbThsOyDefHKhiw4441iGlHpTSSRj-_LvVdVUPGT2chZIbmF-1ShizmutBUuAN_hYeMSZl23AYrLhCtGlZs_8zEbNai_Cs=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Grappa Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPqOIgxFVEDUxiXGcUgz-sZEeTEDNIoq6gYlSbi=w614-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Uzzuri Deli & Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/GNIoA76LLtZR_JiTdfIUxwYmqNIOC58_8EcP3JR1bYW6fOVOEiM-nJZ2NO_W5G4ETLiWlrjpxlRnIxS2P9RJvIRXgY69HtBsj4Tsq8AXYEdaca1NiQ3JZd9oazj25hs4-xAK0MNc6mqreiixo71Nik8rob463Q=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sky Lounge Bar & Grill") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/SHeLa0ugX_ekvMjC4LcNZ6UtnwZC59IORHR3M2q9uiBMsEIKB2fRnt0teyvJQw1cTWi1asGwoWSKNdkg7kZWg7nLLcmpoaUO6M0s-wYkgJgVsta3cipHdr0qv7a2zq2ggqOX-WkfV9KFhVmm67JizZrvm56SgA=w408-h309-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="World Art Dining") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/iNjgAiX-gDj6bPx5XMwUJYn7mINqRuB2LxiawueueGsV3sxOzHtIESNZxzAjs_-nzsf0KtfcMcpJoOcHcHz47y7glMiDZtcovERhSPZcz68ojpAR07BF2HCWBPP_AIH6UHkj21AJ314w-rbqeJRw-aYQlJgM7EI=w408-h212-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="My Bar Square") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/kvpv7B1sM6X0tgT-UVnAmTKQFIu2D1Rne7BK3cIp5CkBMphRp0ZQyRCNyHTaZiJI6QrOSNURDh0OfYVGJ8VI05vsHyd5OP9wO6jf5eszkiBlp5PR_WUAGRy4QVHYSDNEPqp-WMdle9_R9udqqdLYJK-Sboe45J4=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ek Bar") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/qW6FV5gyWa27kbiVcpWKQft-9wGY3joq-gwFCh3VYa8HkMNeVr5nsjnFNFX2dokEidm0NiOh8G8Yef4AHMVWmE3Kiv-fgABGjJP2Ju2TtHjgvZpADBWr85s7FN8GFIBfsBrDzQj-lAyBzQ-ItImhpDFnHYRCp2g=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Oberoi") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO7jb_ngCwKhIkb45E6GfSIMj99csHhRdzyMxVr=w408-h278-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ali Baba Caves") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/HjugEmxfR9EYkJy5uz5Z04j08ImuZGAS0MyeYSMQn6gmJSuC9eU5s-oWF8CzP62pL1K-N1MvYgkR_7gjy8sFVG5YEflZ1O5HPeXMNyPpW1EwRlcChxPPRAmrfHlLF463rmyQKpb5j85Zq3ElteSkynMNytfdx4A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="My Bar Headquarters") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMMI71zImSGKYl6Oh2askqqNKEchJ5ArCSfBPGJ=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Def Col Social") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOZC44FrTzTAyqbMZCkoh1phzXRfqpNJB6wJN-D=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club BnB Shooters") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMm9AbNBbqsfd0LtiyUASZ-YLVMcH1OhWmH9m9w=w408-h720-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Masabaa") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM9CRbqUejcBrCurzjWYyLb_cazQ0t76nvgNANI=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Local") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN5dkGCoLx5yPKGa1VcM2p5h89NF4JZEBEzZL4f=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Allure Bar & Restaurant") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMUVWikgle-IJp5LSA5LYzjCGTA0g4ePuoccpyA=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Raftaar High Speed Club & Lounge") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMruRzjin4FoWEasxj8O8dHSUh3_5i533xoGeyS=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Castle 9") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Euzjxt2pKTZPkjxUIyZIc-E92r8Qj4e2qUppFK24lacyNWSHBDbccWeSTT9QpjxNZWIcm2Uh-KniWFLyREj4KLbXR6KZYVq_DYsCl2Oke2jnH7QxBfqLRUSVwdC6eOLsR4TnfuZwI1fnGty9fpoIAK5O-ARAjw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Indian Accent") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM72pZ9frdHt6E5hMBLnusXBwZxYRo0NQQohk3Z=w518-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Beer Cafe") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/Km6KMwqvWzL5yFKKbfhLtruEU28wzgsZJHaNebhI7gJBRFwUb3h4cYfSxXutRKs2feZHVtneqyz3aYcpQRefcDcnZSmBwc5akViiFWnQWBzQ7DafCFgG2E4Oj6Sk0G294fFLylftvpaBvvRM9d4-wX33IZpGxA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Aroma Restaurant and Bar") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/4sytz6WTlKRdJDkznd5Lfs6-TbR4ewslQWnkFMgefs8ht_GqueVxOZGYp2c-QfYRP3QNyiJ1gKRWAbsGK9EUbDIsXTxGaGo6A5ZE_rmb4LLJbVwzHR6RR10kmVhZJZpAdVLk3T1YnON-Ja85ZaaKoTvDTd1svQ=w408-h280-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lights Camera Action") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNcfbohSOOXvs9wRpztR3J0SQFW-MmRd4zawp9F=w496-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Suryaa New Delhi") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM8OV1-mpO6GpVQnBwzjhE6Ff94lGEzZYKHCmVY=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tapas, Jaypee Vasant Continental") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMq9u4WVDtRLRZS8Q0k-hsyUcNhkAFAwc-Smahx=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Parikrama The Revolving Restaurant") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM6fbF-PdZ6Bo__81b-Gqih8gUlCIURhw93v9FS=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Adda by Striker") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMKMzm_j5ghdIlz937DoBTrW7Y__-C5G2b9uSua=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bombay Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipObzTp5fH7Ol2ktBUaVf5Zomo19RhL_b_sl7jEG=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Beer Cafe") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPxh4BIHKvsUqEmhf_T_Evto1rLatcasJFkv0k=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lord of the Drinks Chamber") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/VF4-S0KuVZqZNPcp3gZkzbIfuDFdGyuTlbeFJJF5HTJo9VcUPAG-3qPsoEn1sXmrBYrq1Dl7yirHaXQvT0qh7hdQNZ2LHZz3AYNEvavvSnSaAV-VM_tKTdfz2zjZsMuUsocrl82WukId3skMYt_UodY4-LqogA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Thugs") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/TipKgNp65XJZdCH3lA9tpCvmEKJLX8lXXkWXo6Ncn8jLkvMnYyrddu968bQjg9gvfwGi9fgM0YBQRkmf__1ZI0iY036MfQ9UbZWjyYfsT8e_XkJNqe8B4FyJ5NiK-_8BjYcGLDaq6OEYreG4QLz8CvuOb5kzMjU=w408-h250-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Platinum Lounge") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNTdC6aLXRDWmNxrmsRqLO6KP3fn1xkRd5--rkU=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="1 Cafe Lounge") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/xQi1xCEiFi5MR-koam3avsnFXdKnCXfwR_jykt3klBBxukBP3XwAuj_TO2Q_Ug47DiTUmLLM9InCaMewF8V7lV08lbC3dX_KF1j16YgnwVa_bOyDQMZV-TA8dONy3CUy5YEdJdc94Bf6jNorAtq2TcR8xMRNxA=w408-h268-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Manhattan Bar Exchange And Brewery") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMn9zWV6prKJcwTi94guGqzo0OC4BwZOWX0l-K-=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Olive Bar and Kitchen Restaurant") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/257jwDdJ8tN1L-EArZ_WkffMHGrLKNUEEUXG5ghsPH-qJxUd_0jxnRP4jhIuPN8hgtT_rtT1fXHGiR0T3qNEP-wq_qcHMy7Vn-b0QLR6O-8G0k0XpQXN3E28GX5klJzW49q7zOIv8yY5xjK7rIZ-EKhW7GlDk30=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Sky High") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM_s7t7AdYW5A1O7Ftypnzd8NrPpBAp3O1fdqb3=w408-h204-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="1911 Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/G38TfoRdFrwKDSivIDZQdAVgilvoKr8PlCu4DdKhzenPX92Wrcrwd5ryDDxqGk9GCIgvDyOTeS5-dwCm4ZsWTCIK5zR_3U36ZhtlB_YJ2HdRM49eDIIW5DuooYEAgnwrKn1q-F_p5Qg22cQs_2UScMHcjwHJjg=w408-h230-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tipple") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/ua4nSUvx4VjeIVUpsvgfpf37wpHF_xTTR2jy5YXZoTuIdwaDZlfgk65W2rioH3M39pG-mS_I-ssMMsIWGcw42wogztOGyE--mThOHpR67ySxA4SEmOceu4FK2heG82191HCJq6szqbLFvj8Unj0clNqBlOeMEUM=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Savannah Bar") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/IqG1dzbcJEa9UhvXQNse89LaaD0WgQPo_zF2zlmwRVsZn9M3n87kCz4GfHSo3_m0aviiwrNRpq39AdYNrHYvkkRUpCB8ArTHrRyHKVL3slYG2Q77xRQSrJuHW1N-r-7OcIU_Wgp4yIsDFUnmgzad0pHdKJGWAX0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="BED") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Pf4I9t_HSLowMMQZ11rQTKDpBbE8LtvNO45mrDvRjwMKXDUIiJ9z4gHOauvXjL1fDIeptDeb8GLpSsZYnRYy0tbWRnSJApRmyHYOhRb318J3QF6FR4QzDH3UFCPubr98DOYhsnQOKsMbizlKtQcBHs2Cr1DzWcE=w519-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Londoners Bistro & Pub") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMNujAL1SkYSKw-Aoj_hVI2tQ1Ftag4yB2LBaIb=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="UpTown Cafe") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/RWTj1H3GraEM4OZvqDaSOC77cD4JhAM_-ZK59EPoy6AZeap8X7hp22yHSrrm_-59afHRxLmoR7otC5Hl3QJET4I3o9sU-VZGYlICr4pZpc3R79KaxTpUVUnDBMQSWzoKdspwu6CFeFlruQsIgZ9T6-6UeTo3Eg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bohca - Bar & Restaurant") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/v6n3l-kc51ua1J9ehTLAxKkMGdz5YT4mrULT5XI13V_tQkfvtc8z2mrAo5eh4uVqkqFb_d5p0iKQVr3HI-HHGHI8g6gcll4tp9Z68KPiALHs9_64Xl8IVaLnhBpBm2PRF2TJQxhFyclOaHRIDDhEkVHWs7ie4sA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="True Blue Resto & Bar") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNgacyYBzfeduE6rutAWODfACVT8yahphZJyALQ=w408-h200-k-no-pi-2.9338646-ya189.45648-ro-0-fo100").error(R.drawable.nightlife).into(img);}
        else if(namee=="Jail Behind The Bar") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/7G_XHIQZm9pRNxOpw3TLW39YGZUdB_z6gUVmU8h_68li1E_lVOQ_48C1416wxLng8TKi8MZAzrFSLk3EdX6olR9Xruw1DAebq2IyaMhLe8hysbTmZgisFoC5BemenTE4OHOmTPAnWMMMjMl4qOeRsrzaLiGQTg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sinciti") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/ccxTWCq4mnx8M71mLG0nuyUKxhMa2LntX_W1IvcZ_9Rs0pheZVqRaC2nCtu_6c6os9kAnkS9WLObzmIpJsWzDMVXbL4A9Zw9fv-LNRODH9394-95UvbpHoGJ1I6x9r0MdeKN9fFo-Zw3DBhwHoAyJXgSou5kUA=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hawalat") {
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/HqpmrjUAFr9SfnMKf7tdf0Hz0yhc8wrzkefbeb7J-A3Z_OI4GjpWoNyQZ_QFrYNv7m41OfppCTxLUWOUh9wAsaOhVTf4tDqBvqZGxuUWa8VvnI9LzmqGYT16A3fvJTqsPd9wiQP5QscJg4EEO36xJcm4ePq1vQ=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Boom Box Cafe Reloaded") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/B5Yyw29w9J9jqPrdAEdXudiF-mFOgbWhSMtEbuHHUFe6GMxnknqULkmz-IOKWFPFQrnwb0cNjy4sLsd8twtgGAoN92lYFo3l7_7GiiGgbJ1ifKW5jQLGkL30_JnAL0naTpd5rz1Bo8m_yLslpZns2ur4lk-WHQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="HotMess Kitchen & Bar") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/Y4E4rkCEyBjXIbQaIz49J7HWKJ6YyXRaDjytylaa8J0yxZVClFw3_dHaK5RHw6mNDjmuBC4nzTb_EMjMfH3CukbaqqMqCvwYzTPO2OCSv_fWOp_4rAQbGsywTpFDeRct3RF0CSuho1SoccXQP9Ld8Gu3V1sptA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Gastronomica") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMbO61cbLTjx9kk2IF7oa_cbN-9zkdew58D22Aj=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Headquarter") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/X_A2b40NDYSl0sCcNfN848yhUwDpzsW-pwLlkN20HOGrbPRzzXxKkReTvqFdV0IF5ki6d8z6eB77W568rpQR9HeLFryajSV9zrKJ3xBmUDHT6kfHt1hqvtZyS0763pQHr4MSZjpMHg1dgaG8-h-0MZZ48Ev5vi4=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="RDX Fine Drink and Restaurant") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/x1Te5J4EautDyvvKWfnaCETw-KVNJHkI416SURcvN10bgISTaZZEIBhsWvt9XBbVZ-9sRlrmHyeLZRwMqaN-GHIkuDQ0-TgRxdzt9SJXERYDEzhWld7LIdu2guCjlcW1l8YM2ZLMw_GKqk06TdwtfW18PILPayg=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Jazbaa Bar & Lounge") {
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/-MjsR6Ny2p-F51knJrPyNCvk6_RfKsh1_BdaFR5Wm3OpVrFMnGOp2E7lmL_6nmYaffnyX03Wb76JZlrKfjwja2EI2eaccRwfcb42qDXs5BVSqGd3G2-2MTHDxcJ2BA7m0r0tFqW7qfObMJWRql_0nCNWmaT2tA=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="BarShala") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOnKAOusTTaGzkWVuFQinyB8lajNaffN5OXOWlM=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Route 04") {
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/v7eXgBuvUcWVUL2Is07atrQ80Lb2rjJOwGPBi2CcInIvEXsbh6uyhUkn0_e05_Z6AzD6ihjANfcBqp_SYfrQbrZ5YXzErZIUVxkosvY-7wBjkjI4dnLd03lioY1DyWMn2PEpX71oNSKPQ4PaGm2-GzvvUKMtGAo=w408-h233-k-no").error(R.drawable.nightlife).into(img);}

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