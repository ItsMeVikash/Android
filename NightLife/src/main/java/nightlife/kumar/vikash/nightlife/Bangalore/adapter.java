package nightlife.kumar.vikash.nightlife.Bangalore;
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
 * Created by vikash kumar on 16-12-2017.
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
       final  TextView address=(TextView)convertview.findViewById(R.id.address);
        final TextView phone=(TextView)convertview.findViewById(R.id.phone);
        final TextView description=(TextView)convertview.findViewById(R.id.description);
        final TextView web=(TextView)convertview.findViewById(R.id.web);
        final TextView time=(TextView)convertview.findViewById(R.id.Time);
        address.setText(child);
        description.setText(child);
        phone.setText(child); web.setText(child); time.setText(child);
        final String parentName=getGroup(parentpos).toString();
        if(parentName=="Gilly’s Resto Bar, Bangalore") {
            address.setText("91, Jyoti Nivas College Road, 5th Block, Koramangala, 5th Block, Koramangala, Bengaluru, Karnataka 560034");
            time.setText("Saturday\t" + "12PM–1AM\n" +
                    "Sunday\t" + "12PM–1AM\n" +
                    "Monday\t" + "12PM–1AM\n" +
                    "Tuesday\t" + "12PM–1AM\n" +
                    "Wednesday\t" + "12PM–1AM\n" +
                    "Thursday\t" + "12PM–1AM\n" +
                    "Friday\t" + "12PM–1AM\n");
            phone.setText("081052 31584");web.setText("gillys.in");}
        else if(parentName=="High Ultra Lounge"){
            address.setText("Rooftop, World Trade Center, Bangalore Brigade Gateway Campus, 26/1, Dr. Rajkumar Road, Malleswaram, Rajaji Nagar, Bengaluru, Karnataka 560055");
            phone.setText("080 4567 4567");web.setText("highultralounge.com");
            time.setText("Saturday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n" +
                    "Sunday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n" +
                    "Monday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n" +
                    "Tuesday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n" +
                    "Wednesday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n" +
                    "Thursday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n" +
                    "Friday\t" + "12:30–3:30PM\t" + "5:30PM–1AM\n");}
        else if(parentName=="The Black Rabbit"){
            address.setText("770, 12th Main Rd, HAL 2nd Stage, Doopanahalli, Indiranagar, Bengaluru, Karnataka 560008");
            phone.setText("090660 31156");web.setText("bars-pubs.liveinstyle.com");
            time.setText("Saturday\t" + "12PM–12:30AM\n" +
                    "Sunday\t" + "12–11:30PM\n" +
                    "Monday\t" + "12–11:30PM\n" +
                    "Tuesday\t" + "12–11:30PM\n" +
                    "Wednesday\t" + "12–11:30PM\n" +
                    "Thursday\t" + "12–11:30PM\n" +
                    "Friday\t" + "12PM–12:30AM\n");}
        else if(parentName=="Sanctum"){
            address.setText("135, Chancery Pavilion 3rd Floor, Residency Road, Central Business District, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("096114 11122");web.setText("facebook.com");
            time.setText("Saturday\t" + "12PM–1AM\n" +
                    "Sunday\t" + "12–11:30PM\n" +
                    "Monday\t" + "12–11:30PM\n" +
                    "Tuesday\t" + "12–11:30PM\n" +
                    "Wednesday\t" + "12–11:30PM\n" +
                    "Thursday\t" + "12–11:30PM\n" +
                    "Friday\t" + "12PM–1AM\n");}
        else if(parentName=="Skyye"){
            address.setText("24, 16th Floor, Uber level, Canberra Block, UB City, Vittal Mallya Road, KG Halli, D' Souza Layout, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4909 0000");web.setText("skyye.in");
            time.setText("Saturday\t" + "5:30PM–12:30AM\n" +
                    "Sunday\t" + "5PM–2:30AM\n" +
                    "Monday\t" + "5:30–11PM\n" +
                    "Tuesday\t" + "5:30–11PM\n" +
                    "Wednesday\t" + "5:30–11PM\n" +
                    "Thursday\t" + "5:30–11PM\n" +
                    "Friday\t" + "5:30PM–12:30AM\n");}
        else if(parentName=="Nolimmits Lounge & Club"){
            address.setText("8, 2nd Floor, Allied Grande Plaza, Magrath Road, Above Nalli Silks, Diagonally Opposite Garuda Mall, Near MG Road ,Harsha shetty -9008979977, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("080 4933 3000");web.setText("business.site");
            time.setText("Saturday\t" + "11AM–1AM\n" +
                    "Sunday\t" + "11AM–12:30AM\n" +
                    "Monday\t" + "11AM–12:30AM\n" +
                    "Tuesday\t" + "11AM–12:30AM\n" +
                    "Wednesday\t" + "11AM–12:30AM\n" +
                    "Thursday\t" + "11AM–12:30AM\n" +
                    "Friday\t" + "11AM–1AM\n");}
        else if(parentName=="I Bar"){
            address.setText("14/7, MG Road, Yellappa Garden, Yellappa Chetty Layout, Sivanchetti Gardens, Bengaluru, Karnataka 560042");
            phone.setText("080 2559 4666");web.setText("theparkhotels.com");
            time.setText("Saturday\t" + "6PM–1AM\n" +
                    "Sunday\t" + "6PM–1AM\n" +
                    "Monday\t" + "6PM–1AM\n" +
                    "Tuesday\t" + "6PM–1AM\n" +
                    "Wednesday\t" + "6PM–1AM\n" +
                    "Thursday\t" + "6PM–1AM\n" +
                    "Friday\t" + "6PM–1AM\n");}
        else if(parentName=="Bling"){
            address.setText("244, ITPL Main Road, Whitefield, Maruthi Nagar, KIADB Export Promotion Industrial Area, Krishnarajapura, Bengaluru, Karnataka 560048");
            phone.setText("090660 30525");web.setText("liveinstyle.com");
            time.setText("Saturday\t" + "11AM–11:30PM\n" +
                    "Sunday\t" + "11AM–11:30PM\n" +
                    "Monday\t" + "11AM–11:30PM\n" +
                    "Tuesday\t" + "11AM–11:30PM\n" +
                    "Wednesday\t" + "11AM–11:30PM\n" +
                    "Thursday\t" + "11AM–11:30PM\n" +
                    "Friday\t" + "11AM–11:30PM");}
        else if(parentName=="Big Pitcher"){
            address.setText("4121, LR Arcade, HAL 2nd Stage, Ward 88, HAL 2nd Stage, Kodihalli, Bengaluru, Karnataka 560008");
            phone.setText("080 4553 0000");web.setText("bigpitcher.co.in");
            time.setText("Saturday\t" + "11AM–1AM\n" +
                    "Sunday\t" + "11AM–1AM\n" +
                    "Monday\t" + "11AM–1AM\n" +
                    "Tuesday\t" + "11AM–1AM\n" +
                    "Wednesday\t" + "11AM–1AM\n" +
                    "Thursday\t" + "11AM–1AM\n" +
                    "Friday\t" + "11AM–1AM");}
        else if(parentName=="The 13th Floor"){
            address.setText("Barton Centre, 84 Mahatma Gandhi Road, Shivaji Nagar, Haridevpur, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4178 3355");web.setText("ebonywithaview.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM");}
        else if(parentName=="Sky Lounge"){
            address.setText("56D, Electronics City Phase 1, Svenska Design Hotel, Opp Wipro Gate No 5, Electronics City Phase 1, Electronic City, Bengaluru, Karnataka 560100");
            phone.setText("080 4431 0000");web.setText("svenskahotels.com");
            time.setText(
                    "Saturday\t" +
                    "6:30–11:30PM\n" +
                    "Sunday\t" +
                    "6:30–11:30PM\n" +
                    "Monday\t" +
                    "6:30–11:30PM\n" +
                    "Tuesday\t" +
                    "6:30–11:30PM\n" +
                    "Wednesday\t" +
                    "6:30–11:30PM\n" +
                    "Thursday\t" +
                    "6:30–11:30PM\n" +
                    "Friday\t" +
                    "6:30–11:30PM");}
        else if(parentName=="The Biere Club"){
            address.setText("153/1, Biere Street, Hagadur Main Road,, Whitefield, East Bangalore, Brooke Bond First Cross, Prestige Ozone, Whitefield, Bengaluru, Karnataka 560066");
            phone.setText("098863 53523");web.setText("thebiereclub.com");
            time.setText(
                    "Saturday\t" +
                    "3PM–12AM\n" +
                    "Sunday\t" +
                    "3–10:30PM\n" +
                    "Monday\t" +
                    "3–10:30PM\n" +
                    "Tuesday\t" +
                    "3–10:30PM\n" +
                    "Wednesday\t" +
                    "3–10:30PM\n" +
                    "Thursday\t" +
                    "3–10:30PM\n" +
                    "Friday\t" +
                    "3PM–12AM");}
        else if(parentName=="Toit Brewpub"){
            address.setText("298, 100 Feet Road, Near KFC Restaurant, Indira Nagar II Stage, Binnamangala, Stage 1, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("090197 13388");web.setText("toit.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–12:30AM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12PM–12:30AM\n" +
                    "Thursday\t" +
                    "12PM–12:30AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Shiro"){
            address.setText("222, 3rd Floor, UB City Comet, Vittal Mallya Road, KG Halli, D' Souza Layout, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("090660 25211");web.setText("shiro.co.in");
            time.setText(
                    "Saturday\t" +
                    "12:30–11:30PM\n" +
                    "Sunday\t" +
                    "12:30–11:30PM\n" +
                    "Monday\t" +
                    "12:30–11:30PM\n" +
                    "Tuesday\t" +
                    "12:30–11:30PM\n" +
                    "Wednesday\t" +
                    "12:30–11:30PM\n" +
                    "Thursday\t" +
                    "12:30–11:30PM\n" +
                    "Friday\t" +
                    "12:30–11:30PM");}
        else if(parentName=="Loft 38"){
            address.setText("Shop No.763, 100 Feet Road, Next to Xtreme Sports Bar, HAL 2nd Stage, Indira Nagar, HAL 2nd Stage, Appareddipalya, Indiranagar, Bengaluru, Karnataka 560038\n");
            phone.setText("080 4933 7555");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12PM–12:30AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12PM–12:30AM");}
        else if(parentName=="Pebble The Jungle Lounge"){
            address.setText("3 Princess Academy, Palace Grounds, Ramanna Maharishi Road, Princess Academy, Jayamahal, Bengaluru, Karnataka 560080");
            phone.setText("088842 27447");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "7PM–1AM\n" +
                    "Sunday\t" +
                    "7–11:30PM\n" +
                    "Monday\t" +
                    "7–11:30PM\n" +
                    "Tuesday\t" +
                    "7–11:30PM\n" +
                    "Wednesday\t" +
                    "7–11:30PM\n" +
                    "Thursday\t" +
                    "7–11:30PM\n" +
                    "Friday\t" +
                    "7PM–1AM");}
        else if(parentName=="The Biere Club"){
            address.setText("20, Vittal Mallya Road, 2nd Stage, D' Souza Layout, Ashok Nagar, D' Souza Layout, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4212 4383");web.setText("thebiereclub.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–12AM");}
        else if(parentName=="The Sugar Factory"){
            address.setText("Le Meridien Hotel, 28, Sankey Road, Palace Cross Rd, Vasanth Nagar, Vasanth Nagar, Bengaluru, Karnataka 560052");
            phone.setText("080 4131 5566");web.setText("thesugarfactory.club");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Bootlegger"){
            address.setText("36, Vittal Mallya Road, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4146 2747");web.setText("facebook.com");
            time.setText(
                    "Saturday\t" +
                    "10:30AM–1AM\n" +
                    "Sunday\t" +
                    "10:30AM–1AM\n" +
                    "Monday\t" +
                    "10:30AM–1AM\n" +
                    "Tuesday\t" +
                    "10:30AM–1AM\n" +
                    "Wednesday\t" +
                    "10:30AM–1AM\n" +
                    "Thursday\t" +
                    "10:30AM–1AM\n" +
                    "Friday\t" +
                    "10:30AM–1AM");}
        else if(parentName=="TGI Friday's"){
            address.setText("4th Floor, Bannerghatta Road, Hulimavu, Hulimavu, Bengaluru, Karnataka 560076");
            phone.setText("090660 35003");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "12–11:30PM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12–11:30PM");}
        else if(parentName=="HashTag Bangalore"){
            address.setText("39/3 & 40, Bannerghatta Main Rd, Bhavani Nagar, Suddagunte Palya, Bengaluru, Karnataka 560029");
            phone.setText("096632 94171");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–12:30AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–12:30AM\n" +
                    "Tuesday\t" +
                    "11AM–12:30AM\n" +
                    "Wednesday\n" +
                    "11AM–12:30AM\n" +
                    "Thursday\t" +
                    "11AM–12:30AM\n" +
                    "Friday\t" +
                    "11AM–12:30AM");}
        else if(parentName=="Hoppipola"){
            address.setText("4032, Terrace Mainland China Building, HAL, 2nd Stage, Off 100 Feet Road, Indiranagar, HAL 2nd Stage, Indiranagar, Bengaluru, Karnataka 560038\n");
            phone.setText("090660 21781");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–12:30AM\n" +
                    "Sunday\t" +
                    "12PM–12:30AM\n" +
                    "Monday\t" +
                    "12PM–12:30AM\n" +
                    "Tuesday\t" +
                    "12PM–12:30AM\n" +
                    "Wednesday\t" +
                    "12PM–12:30AM\n" +
                    "Thursday\t" +
                    "12PM–12:30AM\n" +
                    "Friday\t" +
                    "12PM–12:30AM");}
        else if(parentName=="Vapour Pub and Brewery"){
            address.setText("No. 773, HAL 2nd Stage, 100 Feet Road, Indiranagar, HAL 2nd Stage, Doopanahalli, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("099000 88192");web.setText("vapour.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Sanchez"){
            address.setText("24, Vittal Mallya Rd, KG Halli, D' Souza Layout, Sampangi Rama Nagar, Bengaluru, Karnataka 560001");
            phone.setText("085530 77550");web.setText("bars-pubs.liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Bangalore Brew Works"){
            address.setText("10th Floor , Prestige Towers, Residency Rd, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("080 2222 5581");web.setText("facebook.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Gotcha"){
            address.setText("11-12/49, 14th Main, Puttenahalli Road, Kothnur Main Road, 7th Stage, JP Nagar, Jagruthi Colony, Puttenahalli, JP Nagar 7th Phase, JP Nagar, Bengaluru, Karnataka 560078");
            phone.setText("080 4965 2630");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "12–11:30PM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12–11:30PM");}
        else if(parentName=="Koramangala Social"){
            address.setText("118, 3rd Floor, Koramangala Industrial Area, 7th Block, Above Bodyworks Spa, 7th Block, Koramangala, Bengaluru, Karnataka 560095");
            phone.setText("080 6565 1595");web.setText("socialoffline.in");
            time.setText(
                    "Saturday\t" +
                    "9AM–1AM\n" +
                    "Sunday\t" +
                    "9AM–1AM\n" +
                    "Monday\t" +
                    "9AM–1AM\n" +
                    "Tuesday\t" +
                    "9AM–1AM\n" +
                    "Wednesday\t" +
                    "9AM–1AM\n" +
                    "Thursday\t" +
                    "9AM–1AM\n" +
                    "Friday\t" +
                    "9AM–1AM");}
        else if(parentName=="Russh Gastropub Bangalore"){
            address.setText("29, Church St, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 3069 5514");web.setText("atoz.city");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Hoot Cafe & Brewery"){
            address.setText("BBMP 2034/69,Sarjapur Main Road, Block 2 Village, Varthur Hobli, Kaikondrahalli, Bengaluru, Karnataka 560035");
            phone.setText("080 6959 5999");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12:30PM–1AM\n" +
                    "Sunday\t" +
                    "12:30PM–1AM\n" +
                    "Monday\t" +
                    "12:30PM–1AM\n" +
                    "Tuesday\t" +
                    "12:30PM–1AM\n" +
                    "Wednesday\t" +
                    "12:30PM–1AM\n" +
                    "Thursday\t" +
                    "12:30PM–1AM\n" +
                    "Friday\t" +
                    "12:30PM–1AM");}
        else if(parentName=="Shimmer"){
            address.setText("Vivanta by Taj Bangalore, 2275, Tumkur Main Rd, Yeshwanthpur Industrial Area, Phase 1, Yeshwanthpur, Bengaluru, Karnataka 560022");
            phone.setText("080669 00111");web.setText("vivanta.tajhotels.com");
            time.setText(
                    "Saturday\t" +
                    "6:30–11:30PM\n" +
                    "Sunday\t" +
                    "6:30–11:30PM\n" +
                    "Monday\t" +
                    "6:30–11:30PM\n" +
                    "Tuesday\t" +
                    "6:30–11:30PM\n" +
                    "Wednesday\t" +
                    "6:30–11:30PM\n" +
                    "Thursday\t" +
                    "6:30–11:30PM\n" +
                    "Friday\t" +
                    "6:30–11:30PM");}
        else if(parentName=="Skywaft"){
            address.setText("53/1-2, S V Arcade, 4th Floor, Bilekahalli, Off Bannerghatta Rd Bangalore,, India, Thayappa Garden, Ranka Colony, Bilekahalli, Bengaluru, Karnataka 560076");
            phone.setText("085499 99901");web.setText("skywaft.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–11:30PM\n" +
                    "Sunday\t" +
                    "11AM–11:30PM\n" +
                    "Monday\t" +
                    "11AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11AM–11:30PM\n" +
                    "Thursday\t" +
                    "11AM–11:30PM\n" +
                    "Friday\t" +
                    "11AM–11:30PM");}
        else if(parentName=="Pool Bar"){
            address.setText("Sheraton Bangalore Hotel At Brigade Gateway, Subramanyanagar,2 State, Rajaji Nagar, Bengaluru, Karnataka 560055");
            phone.setText("080 4252 0188");web.setText("sheratonbangalore.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–7PM\n" +
                    "Sunday\t" +
                    "11AM–7PM\n" +
                    "Monday\t" +
                    "11AM–7PM\n" +
                    "Tuesday\t" +
                    "11AM–7PM\n" +
                    "Wednesday\t" +
                    "11AM–7PM\n" +
                    "Thursday\t" +
                    "11AM–7PM\n" +
                    "Friday\t" +
                    "11AM–7PM");}
        else if(parentName=="The Warehouse"){
            address.setText("3, Sir CV Raman Rd, Indira Nagar 1st Stage, H Colony, Indiranagar, Bengaluru, Karnataka 560075\n");
            phone.setText("080886 64206");web.setText("kpgroups.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Church Street Social"){
            address.setText("46/1, Cobalt Building, Church Street, Haridevpur, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4162 2755");web.setText("socialoffline.in");
            time.setText(
                    "Saturday\t" +
                    "9AM–1AM\n" +
                    "Sunday\t" +
                    "9AM–1AM\n" +
                    "Monday\t" +
                    "9AM–1AM\n" +
                    "Tuesday\t" +
                    "9AM–1AM\n" +
                    "Wednesday\t" +
                    "9AM–1AM\n" +
                    "Thursday\t" +
                    "9AM–1AM\n" +
                    "Friday\t" +
                    "9AM–1AM");}
        else if(parentName=="Hoppipola"){
            address.setText("14, 3rd Floor, Church Street, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("090660 21785");web.setText("bars-pubs.liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "12:30PM–1AM\n" +
                    "Sunday\t" +
                    "12–11PM\n" +
                    "Monday\t" +
                    "12–11PM\n" +
                    "Tuesday\t" +
                    "12–11PM\n" +
                    "Wednesday\t" +
                    "12–11PM\n" +
                    "Thursday\t" +
                    "12–11PM\n" +
                    "Friday\t" +
                    "12:30PM–1AM");}
        else if(parentName=="Big Brewsky"){
            address.setText("Sarjapur Road, Behind MK Retail, Before WIPRO Corporate Office, Kaikondrahalli, Bengaluru, Karnataka 560035\n");
            phone.setText("080 3951 4766");web.setText("bigbrewsky.com");
            time.setText(
                    "Saturday\t" +
                    "12:30PM–1AM\n" +
                    "Sunday\t" +
                    "12:30PM–1AM\n" +
                    "Monday\t" +
                    "12:30PM–1AM\n" +
                    "Tuesday\t" +
                    "12:30PM–1AM\n" +
                    "Wednesday\t" +
                    "12:30PM–1AM\n" +
                    "Thursday\t" +
                    "12:30PM–1AM\n" +
                    "Friday\t" +
                    "12:30PM–1AM");}
        else if(parentName=="Sharaab Factory"){
            address.setText("#3, 6th Floor, Soul Space Spirit, Bangalore Central Mall, Belandur, Bellandur, Bengaluru, Karnataka 560103");
            phone.setText("080 6444 4448");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="ALT"){
            address.setText("VR Mall, Sky Deck, Itpl Main Road, Whitefield, Bangalore, Whitefield, East Bangalore, Devasandra Industrial Estate, Krishnarajapura, Bengaluru, Karnataka 560048");
            phone.setText("095912 20033");web.setText("vrbengaluru.com");
            time.setText(
                    "Saturday\t" +
                    "5PM–1AM\n" +
                    "Sunday\t" +
                    "5–11:30PM\n" +
                    "Monday\t" +
                    "5–11:30PM\n" +
                    "Tuesday\t" +
                    "5–11:30PM\n" +
                    "Wednesday\t" +
                    "5–11:30PM\n" +
                    "Thursday\t" +
                    "5–11:30PM\n" +
                    "Friday\t" +
                    "5PM–1AM");}
        else if(parentName=="Indigo XP"){
            address.setText("71/72, Jyoti Nivas College Rd, 6th Block, Koramangala, Bengaluru, Karnataka 560095");
            phone.setText("096323 57766");web.setText("theindigoxp.com");
            time.setText(
                    "Saturday\t" +
                    "3PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "3PM–1AM\n" +
                    "Tuesday\t" +
                    "3PM–1AM\n" +
                    "Wednesday\t" +
                    "3PM–1AM\n" +
                    "Thursday\t" +
                    "3PM–1AM\n" +
                    "Friday\t" +
                    "3PM–1AM");}
        else if(parentName=="Easy Tiger"){
            address.setText("A 11/1, Church Street, M.G Road, Off Brigade Road, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 2555 0707");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM");}
        else if(parentName=="Sagar Pub & Bar"){
            address.setText("Shop No.18, S.C Road Cross, Bangalore Bus Station, SC Road, Gandhi Nagar, RK Puram, Gandhi Nagar, Bengaluru, Karnataka 560009");
            phone.setText("Unavailable");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–11:30PM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–11:30PM");}
        else if(parentName=="Watson's Ulsoor"){
            address.setText("Skywalk Building, Assaye Rd, Pulikeshi Nagar, R T Nagar, Sindhi Colony, Pulikeshi Nagar, Bengaluru, Karnataka 560008");
            phone.setText("085530 74847");web.setText("bars-pubs.liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–1AM\n" +
                    "Monday\t" +
                    "11:30AM–1AM\n" +
                    "Tuesday\t" +
                    "11:30AM–1AM\n" +
                    "Wednesday\t" +
                    "11:30AM–1AM\n" +
                    "Thursday\t" +
                    "11:30AM–1AM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="The Studio Bar"){
            address.setText("No 201, 3rd floor, Brigade Orion Mall, Dr Raj Kumar Road, Malleswaram west, Near Yeshwantpur, Rajaji Nagar, Bengaluru, Karnataka 560055");
            phone.setText("080 2268 2181");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11PM\n" +
                    "Monday\t" +
                    "11:30AM–11PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11PM\n" +
                    "Thursday\t" +
                    "11:30AM–11PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Prost"){
            address.setText("749, 10th Main, 80 Feet Road, 4th Block, Near Maharaja Hotel, Koramangala, Koramangala 4th Block, Koramangala, Bengaluru, Karnataka 560035");
            phone.setText("080 2553 4989");web.setText("prost.in");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Banana Beach Bar"){
            address.setText("No.54, 60 Feet Road, Kormangala 6th Block, 5th Block, Koramangala, Bengaluru, Karnataka 560095");
            phone.setText("099000 88511");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="The Boozy Griffin"){
            address.setText("#105, 1st A Cross Rd, 5th Block, Koramangala, Bengaluru, Karnataka 560095");
            phone.setText("090353 08000");web.setText("theboozygriffin.in");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="The Irish House"){
            address.setText("Shop TF - 01A, VR Bengaluru, Whitefield Main Road, Mahadevapura, Devasandra Industrial Estate, Krishnarajapura, Bengaluru, Karnataka 560048");
            phone.setText("080 4652 4251");web.setText("theirishhouse.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Rewind"){
            address.setText("No. 315, HRBR Layout, 2nd Block, 7th Main, Banaswadi, HRBR Layout 2nd Block, HRBR Layout, Kalyan Nagar, Bengaluru, Karnataka 560043");
            phone.setText("098866 53578");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Cirrus"){
            address.setText("No. 765, 5th Floor, 100 Feet Road, (Opposite Forever New), Indira Nagar, HAL 2nd Stage, Appareddipalya, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("097311 54784");web.setText("facebook.com");
            time.setText(
                    "Saturday\t" +
                    "12–11PM\n" +
                    "Sunday\t" +
                    "12–11PM\n" +
                    "Monday\t" +
                    "12–11PM\n" +
                    "Tuesday\t" +
                    "12–11PM\n" +
                    "Wednesday\t" +
                    "12–11PM\n" +
                    "Thursday\t" +
                    "12–11PM\n" +
                    "Friday\t" +
                    "12–11PM");}
        else if(parentName=="The Local"){
            address.setText("No. 467, Terrace Floor, Above Jimi's, 80ft Road, 6th Block, Koramangala, 6th Block, Koramangala, Bengaluru, Karnataka 560095");
            phone.setText("080 2550 5119");web.setText("thelocaldrinkery.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–11:30PM\n" +
                    "Monday\t" +
                    "11AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11AM–11:30PM\n" +
                    "Thursday\t" +
                    "11AM–11:30PM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Sotally Tober"){
            address.setText("769, 80 Feet Rd, Koramangala 4th Block, Koramangala, Bengaluru, Karnataka 560034");
            phone.setText("091084 60486");web.setText("bars-pubs.liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Turquoise The Underground Club"){
            address.setText("Quality Inn Shravanthi,60, 13th Cross, 2nd Main, J.P. Nagar, 3rd Phase,, Dollar Layout, 3rd Phase, JP Nagar, Bengaluru, Karnataka 560078");
            phone.setText("088064 44466");web.setText("qualityinnshravanthi.in");
            time.setText(
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM");}
        else if(parentName=="Le Rock"){
            address.setText("3, Restaurant House Road, Off Brigade Road, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4123 1001");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "10:30AM–1AM\n" +
                    "Sunday\t" +
                    "10:30AM–11:30PM\n" +
                    "Monday\t" +
                    "10:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "10:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "10:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "10:30AM–11:30PM\n" +
                    "Friday\t" +
                    "10:30AM–1AM");}
        else if(parentName=="XU"){
            address.setText("23, Leela Palace Road, HAL 2nd Stage, Kodihalli, HAL 2nd Stage, Kodihalli, Bengaluru, Karnataka 560008");
            phone.setText("095133 44440");web.setText("xubangalore.business.site");
            time.setText(
                    "Saturday\t" +
                    "5PM–1AM\n" +
                    "Sunday\t" +
                    "5PM–1AM\n" +
                    "Monday\t" +
                    "5PM–1AM\n" +
                    "Tuesday\t" +
                    "5PM–1AM\n" +
                    "Wednesday\t" +
                    "5PM–1AM\n" +
                    "Thursday\t" +
                    "5PM–1AM\n" +
                    "Friday\t" +
                    "5PM–1AM");}
        else if(parentName=="Bottle and Glass"){
            address.setText("# 276, 2nd Floor, 100ft Road, Defence Colony, Indiranagar, Stage 3, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("080 4957 6869");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Bang, The Ritz-Carlton Bangalore"){
            address.setText("The Ritz Carlton, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("080 4914 8000");web.setText("ritzcarlton.com");
            time.setText(
                    "Saturday\t" +
                    "6PM–12:30AM\n" +
                    "Sunday\t" +
                    "5AM–12:30AM\n" +
                    "Monday\t" +
                    "6PM–12:30AM\n" +
                    "Tuesday\t" +
                    "6PM–12:30AM\n" +
                    "Wednesday\t" +
                    "6PM–12:30AM\n" +
                    "Thursday\t" +
                    "6PM–12:30AM\n" +
                    "Friday\t" +
                    "6PM–12:30AM");}
        else if(parentName=="Liber - Resto Bar"){
            address.setText("#768 Sri Krishna Mansion 100ft Road ,, 12th Main , Hal 2nd stage ,, HAL 2nd Stage, Appareddipalya, Indiranagar, Bengaluru, Karnataka 560008");
            phone.setText("095386 29288");web.setText("goo.gl");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–1AM\n" +
                    "Monday\t" +
                    "11:30AM–1AM\n" +
                    "Tuesday\t" +
                    "11:30AM–1AM\n" +
                    "Wednesday\t" +
                    "11:30AM–1AM\n" +
                    "Thursday\t" +
                    "11:30AM–1AM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Puma Social Club"){
            address.setText("777/H, 100 Feet Road, HAL 2nd Stage, Above Puma Showroom, HAL 2nd Stage, Doopanahalli, Indiranagar, Bengaluru, Karnataka 560008");
            phone.setText("088614 33660");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–12:30AM\n" +
                    "Sunday\t" +
                    "11:30AM–12:30AM\n" +
                    "Monday\t" +
                    "11:30AM–12:30AM\n" +
                    "Tuesday\t" +
                    "11:30AM–12:30AM\n" +
                    "Wednesday\t" +
                    "11:30AM–12:30AM\n" +
                    "Thursday\t" +
                    "11:30AM–12:30AM\n" +
                    "Friday\t" +
                    "11:30AM–12:30AM");}
        else if(parentName=="Thalassa"){
            address.setText("29, Church Street, Off Brigade Road, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("099168 49811");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Bar Uno"){
            address.setText("24/1, Vittal Mallya Road, Ashok Nagar, KG Halli, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080671 88544");web.setText("marriott.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–11:30PM\n" +
                    "Monday\t" +
                    "11AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11AM–11:30PM\n" +
                    "Thursday\t" +
                    "11AM–11:30PM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Tilt Gastro Lounge"){
            address.setText("No. 99, Ground Floor, 4th B Cross Road, 5th Block, Koramangala, 5th Block, Koramangala, Bengaluru, Karnataka 560095");
            phone.setText("098865 03432");web.setText("tiltgastrolounge.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="On The Edge"){
            address.setText("Barton Center, No. 84, M.G. Road, Haridevpur, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4178 3366");web.setText("ebonywithaview.com");
            time.setText(
                    "Saturday\t" +
                    "12:30–3PM\t" +
                    "7PM–12AM\n" +
                    "Sunday\t" +
                    "12:30–3PM\t" +
                    "7–11PM\n" +
                    "Monday\t" +
                    "12:30–3PM\t" +
                    "7–11PM\n" +
                    "Tuesday\t" +
                    "12:30–3PM\t" +
                    "7–11PM\n" +
                    "Wednesday\t" +
                    "12:30–3PM\t" +
                    "7–11PM\n" +
                    "Thursday\t" +
                    "12:30–3PM\t" +
                    "7–11PM\n" +
                    "Friday\t" +
                    "12:30–3PM\t" +
                    "7PM–12AM");}
        else if(parentName=="Fusion Lounge"){
            address.setText("No 6/1, 1st Floor, Brigade Road, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 4114 2913");web.setText("highape.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Hammered Pub And Grub"){
            address.setText("No.18, Ali Asker Road, Off Next to Dolci Desserts,, Cunningham Road, Vasanth Nagar, Bengaluru, Karnataka 560051");
            phone.setText("095902 10210");web.setText("zoma.to");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "10AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Glocal Junction"){
            address.setText("2986, 12th Main Rd, HAL 2nd Stage, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("090363 64999");web.setText("glocaljunction.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Sherlock's Pub"){
            address.setText("60/1, Coles Rd, Cleveland Town, Pulikeshi Nagar, Bengaluru, Karnataka 560005");
            phone.setText("088803 00600");web.setText("sherlocks.in");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Tippler"){
            address.setText("276, 100 Feet Road, HAL 2nd Stage, Doopanahalli, Indiranagar, Stage 3, Indiranagar, Bengaluru, Karnataka 560038\n");
            phone.setText("088801 07107");web.setText("facebook.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Arbor Brewing Company"){
            address.setText("8 Magrath Road, Allied Grande Plaza 3rd Floor, Ashok Nagar, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("080501 44477");web.setText("arborbrewing.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–12:30AM\n" +
                    "Sunday\t" +
                    "12PM–12:30AM\n" +
                    "Monday\t" +
                    "12PM–12:30AM\n" +
                    "Tuesday\t" +
                    "12PM–12:30AM\n" +
                    "Wednesday\t" +
                    "12PM–12:30AM\n" +
                    "Thursday\t" +
                    "12PM–12:30AM\n" +
                    "Friday\t" +
                    "12PM–12:30AM");}
        else if(parentName=="Xtreme Sports Bar"){
            address.setText("765, 4th Floor, ANZ Family Trust, 100 Feet Road, HAL 2nd Stage, Indira Nagar, HAL 2nd Stage, Appareddipalya, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("096633 12706");web.setText("xtremesportsbar.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Jimi's Beer Cafe"){
            address.setText("Fifth Floor, Swagath Garuda Mall, Tilak Nagar Main Road, 351, Swagath Rd, 3rd Block East, LIC Colony, Jayanagar 3rd Block East, Jayanagar, Bengaluru, Karnataka 560011");
            phone.setText("090660 25246");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM");}
        else if(parentName=="Quench Bar"){
            address.setText("#282-285, Amarajyothi Layout, Domlur 1st Stage, Krishna Reddy Layout, Amarjyoti Layout, Domlur, Bengaluru, Karnataka 560071");
            phone.setText("090660 32204");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "4:30–11:30PM\n" +
                    "Sunday\t" +
                    "4:30–11:30PM\n" +
                    "Monday\t" +
                    "4:30–11:30PM\n" +
                    "Tuesday\t" +
                    "4:30–11:30PM\n" +
                    "Wednesday\t" +
                    "4:30–11:30PM\n" +
                    "Thursday\t" +
                    "4:30–11:30PM\n" +
                    "Friday\t" +
                    "4:30–11:30PM");}
        else if(parentName=="Brewsky"){
            address.setText("4th and 5th Floor, Goenka Chambers, 19th Main Road, Jeewan Griha Colony, 2nd Phase, J P Nagar, 2nd Phase, JP Nagar, Bengaluru, Karnataka 560078");
            phone.setText("076767 96666");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–12AM\n" +
                    "Sunday\t" +
                    "11:30AM–12AM\n" +
                    "Monday\t" +
                    "11:30AM–12AM\n" +
                    "Tuesday\t" +
                    "11:30AM–12AM\n" +
                    "Wednesday\t" +
                    "11:30AM–12AM\n" +
                    "Thursday\t" +
                    "11:30AM–12AM\n" +
                    "Friday\t" +
                    "11:30AM–12AM");}
        else if(parentName=="Glassy Lounge"){
            address.setText("No.24-26, 414/80/2, Outer Ring Road, Green Glen Layout, Bellandur, Green Glen Layout, Bellandur, Bengaluru, Karnataka 560103");
            phone.setText("090363 60000");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Blistering Barnacles"){
            address.setText("No. 54, 3rd Floor, MSK Plaza, 100 Feet Road, 3rd Main, Defence Colony, Indiranagar, Defence Colony, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("080 4126 3331");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "1PM–1AM\n" +
                    "Sunday\t" +
                    "1PM–1AM\n" +
                    "Monday\t" +
                    "1PM–1AM\n" +
                    "Tuesday\t" +
                    "1PM–1AM\n" +
                    "Wednesday\t" +
                    "1PM–1AM\n" +
                    "Thursday\t" +
                    "1PM–1AM\n" +
                    "Friday\t" +
                    "1PM–1AM");}
        else if(parentName=="District 6"){
            address.setText("G-03, G-04, G-05 26/1, Gateway Campus,, Dr Rajkumar Road, Malleshwaram, Rajajinagar, Rajaji Nagar, Bengaluru, Karnataka 560055");
            phone.setText("080 6176 6666");web.setText("thedistrict6.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM");}
        else if(parentName=="Punjabi by Nature"){
            address.setText("Plot no 12, EIOZ Industrial Area, Whitefield Road, Sadaramangala Village, K.R Puram, Hobali, Opposite Prestige Shantiniketan, KIADB Export Promotion Industrial Area, Krishnarajapura, Bengaluru, Karnataka 560066");
            phone.setText("090660 35367");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "12:30–11:30PM\n" +
                    "Sunday\t" +
                    "12:30–11:30PM\n" +
                    "Monday\t" +
                    "12:30–11:30PM\n" +
                    "Tuesday\t" +
                    "12:30–11:30PM\n" +
                    "Wednesday\t" +
                    "12:30–11:30PM\n" +
                    "Thursday\t" +
                    "12:30–11:30PM\n" +
                    "Friday\t" +
                    "12:30–11:30PM");}
        else if(parentName=="Xplode Restobar"){
            address.setText("70, Sarjapur Main Rd, Kaikondrahalli, Bengaluru, Karnataka 560035");
            phone.setText("099003 11999");web.setText("xploderestobar.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–1AM\n" +
                    "Monday\t" +
                    "11:30AM–1AM\n" +
                    "Tuesday\t" +
                    "11:30AM–1AM\n" +
                    "Wednesday\t" +
                    "11:30AM–1AM\n" +
                    "Thursday\t" +
                    "11:30AM–1AM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Brew and Barbeque"){
            address.setText("36/5, Soulspace Arena Mall, 4th Floor, Outer Ring Road, Doddanekunddi, Doddanekundi, Mahadevapura, Bengaluru, Karnataka 560037");
            phone.setText("080 3923 7373");web.setText("thebandb.in");
            time.setText(
                    "Saturday\t" +
                    "12:30PM–1AM\n" +
                    "Sunday\t" +
                    "12:30PM–12AM\n" +
                    "Monday\t" +
                    "12:30PM–12AM\n" +
                    "Tuesday\t" +
                    "12:30PM–12:30AM\n" +
                    "Wednesday\t" +
                    "12:30PM–12:30AM\n" +
                    "Thursday\t" +
                    "12:30PM–12:30AM\n" +
                    "Friday\t" +
                    "12:30PM–1AM");}
        else if(parentName=="612East"){
            address.setText("#612 2nd, 3rd Floor Above Entertainment Store, 12th Main Road, Indiranagar, HAL 2nd Stage, Indiranagar, Bengaluru, Karnataka 560038\n");
            phone.setText("091108 41695");web.setText("612east.com");
            time.setText(
                    "Saturday\t" +
                    "12:30PM–12:30AM\n" +
                    "Sunday\t" +
                    "12:30PM–12:30AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12:30PM–12:30AM");}
        else if(parentName=="Siam Trading Co. Thai Kitchen"){
            address.setText("1079, 12th Main Road, HAL 2nd Stage, Appareddipalya, Indiranagar, Appareddipalya, Indiranagar, Bengaluru, Karnataka 560008");
            phone.setText("099721 48287");web.setText("siambangalore.business.site");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Guzzlers Inn"){
            address.setText("48, Rest House Road, Brigade Road Cross, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001");
            phone.setText("080 2558 7336");web.setText("guzzlers-inn.myindiasite.com");
            time.setText(
                    "Saturday\t" +
                    "10AM–1AM\n" +
                    "Sunday\t" +
                    "10AM–11:30PM\n" +
                    "Monday\t" +
                    "10AM–11:30PM\n" +
                    "Tuesday\t" +
                    "10AM–11:30PM\n" +
                    "Wednesday\t" +
                    "10AM–11:30PM\n" +
                    "Thursday\t" +
                    "10AM–11:30PM\n" +
                    "Friday\t" +
                    "10AM–1AM");}
        else if(parentName=="Lock N' Load"){
            address.setText("14/1, Kodigehalli Main Road, CQAL Layout, Sahakara Nagar, Hebbal, Sahakar Nagar, Bengaluru, Karnataka 560092");
            phone.setText("080 4070 3703");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "10:30AM–11:30PM\n" +
                    "Sunday\t" +
                    "10:30AM–11:30PM\n" +
                    "Monday\t" +
                    "Closed\n" +
                    "Tuesday\t" +
                    "10:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "10:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "10:30AM–11:30PM\n" +
                    "Friday\t" +
                    "10:30AM–11:30PM");}

        else if(parentName=="Bootlegger"){
            address.setText("37, Sir CV Raman Rd, Hal, HAL 3rd Stage, Stage 3, New Tippasandra, Bengaluru, Karnataka 560075");
            phone.setText("080 2520 0099");web.setText("facebook.com");
            time.setText(
                    "Saturday\t" +
                    "10:30AM–1AM\n" +
                    "Sunday\t" +
                    "10:30AM–1AM\n" +
                    "Monday\t" +
                    "10:30AM–1AM\n" +
                    "Tuesday\t" +
                    "10:30AM–1AM\n" +
                    "Wednesday\t" +
                    "10:30AM–1AM\n" +
                    "Thursday\t" +
                    "10:30AM–1AM\n" +
                    "Friday\t" +
                    "10:30AM–1AM");}
        else if(parentName=="Jcubez"){
            address.setText("22nd Cross Rd, Banashankari Stage II, Banashankari, Bengaluru, Karnataka 560070\n");
            phone.setText("Unavailable");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–7PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="The Oak Tavern- Palm Meadows"){
            address.setText("Ramagondana Halli, Varthur Main Road, Whitefield, Palm Meadows, Whitefield, Bengaluru, Karnataka 560066");
            phone.setText("090660 35268");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Boozers Bar & Kitchen"){
            address.setText("1200, 100 Feet Road, HAL 2nd Stage, Doopanahalli, Indiranagar, HAL 2nd Stage, Doopanahalli, Indiranagar, Bengaluru, Karnataka 560008");
            phone.setText("099452 03333");web.setText("boozers.pub");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12PM–1AM\n" +
                    "Monday\t" +
                    "12PM–1AM\n" +
                    "Tuesday\t" +
                    "12PM–1AM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12PM–1AM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Plan B"){
            address.setText("Opposite Hockey Stadium, 3, Rhenius Street, Shanti Nagar, Richmond Town, Bengaluru, Karnataka 560025");
            phone.setText("088800 22737");web.setText("holycowhospitality.com");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12–11:30PM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="Chin Lung Resto Bar"){
            address.setText("30, Residency Road, Shanthala Nagar, Richmond Town, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("080736 06831");web.setText("business.google.com");
            time.setText(
                    "Saturday\t" +
                    "10AM–1AM\n" +
                    "Sunday\t" +
                    "10AM–1AM\n" +
                    "Monday\t" +
                    "10AM–1AM\n" +
                    "Tuesday\t" +
                    "10AM–1AM\n" +
                    "Wednesday\t" +
                    "10AM–1AM\n" +
                    "Thursday\t" +
                    "10AM–1AM\n" +
                    "Friday\t" +
                    "10AM–1AM");}
        else if(parentName=="1522 The Pub"){
            address.setText("1522, 17th Cross Road, Malleshwaram West, A Block, Milk Colony, Subramanyanagar,2 State, Rajaji Nagar, Bengaluru, Karnataka 560055");
            phone.setText("080 2357 4799");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Attic"){
            address.setText("4, Lavelle Road, 1st Block, Shanthala Nagar, Ashok Nagar, Bengaluru, Karnataka 560001\n");
            phone.setText("098860 41111");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–1AM");}
        else if(parentName=="Sly Granny"){
            address.setText("3rd Floor, # 618, Above Chicco, 12th Main, Indiranagar, 7th Cross, HAL 2nd Stage, Indiranagar, Bengaluru, Karnataka 560038");
            phone.setText("080 4853 6712");web.setText("slystorys.in");
            time.setText(
                    "Saturday\t" +
                    "12PM–1AM\n" +
                    "Sunday\t" +
                    "12–11:30PM\n" +
                    "Monday\t" +
                    "12–11:30PM\n" +
                    "Tuesday\t" +
                    "12–11:30PM\n" +
                    "Wednesday\t" +
                    "12PM–1AM\n" +
                    "Thursday\t" +
                    "12–11:30PM\n" +
                    "Friday\t" +
                    "12PM–1AM");}
        else if(parentName=="The Gadang"){
            address.setText("Park Plaza, Marathahalli Village, Marathahalli, Bengaluru, Karnataka 560037");
            phone.setText("092060 73067");web.setText("liveinstyle.com");
            time.setText(
                    "Saturday\t" +
                    "5–11PM\n" +
                    "Sunday\t" +
                    "5–11PM\n" +
                    "Monday\t" +
                    "5–11PM\n" +
                    "Tuesday\t" +
                    "5–11PM\n" +
                    "Wednesday\t" +
                    "5–11PM\n" +
                    "Thursday\t" +
                    "5–11PM\n" +
                    "Friday\t" +
                    "5–11PM");}
        else if(parentName=="Strona - The Poolside bar"){
            address.setText("Hotel Marks Grandeur, Next to RNS Motors, Tumkur Road, Yeshwanthpur, Yeshwanthpur Industrial Area, Phase 1, Yeshwanthpur, Bengaluru, Karnataka 560022");
            phone.setText("080 4357 8900");web.setText("marksgrandeurhotel.com");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "11:30AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM\n" +
                    "Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Twins"){
            address.setText("No.4/1, 2nd Floor, HRBR Layout, 2nd Block, Opposite Jalvayu Vihar, Main, Road., Beside Reliance Trends, Kammanahalli,, 3rd E-F Cross Road, Ramaiah Layout, Kacharakanahalli, Sena Vihar, Kammanahalli, Bengaluru, Karnataka 560084\n");
            phone.setText("080 2542 0099");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–1AM\n" +
                    "Monday\t" +
                    "11:30AM–1AM\n" +
                    "Tuesday\t" +
                    "11:30AM–1AM\n" +
                    "Wednesday\t" +
                    "11:30AM–1AM\n" +
                    "Thursday\t" +
                    "11:30AM–1AM\n" +
                    "Friday\t" +
                    "11:30AM–1AM\t");}
        else if(parentName=="Rasa Restaurant"){
            address.setText("30, 1st Cross, Sampige Road, Near Mantri Mall, Malleshwaram, Malleshwaram West, Bengaluru, Karnataka 560003");
            phone.setText("080 4206 7030");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM");}
        else if(parentName=="Double Decker"){
            address.setText("120, Brigade Road, 4th Floor, Lancer Building, Ashok Nagar, Bengaluru, Karnataka 560025");
            phone.setText("099624 59866");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11:30AM–1AM\n" +
                    "Sunday\t" +
                    "11:30AM–1AM\n" +
                    "Monday\t" +
                    "11:30AM–1AM\n" +
                    "Tuesday\t" +
                    "11:30AM–1AM\n" +
                    "Wednesday\t" +
                    "11:30AM–1AM\n" +
                    "Thursday\t" +
                    "11:30AM–1AM\n" +
                    "Friday\t" +
                    "11:30AM–1AM");}
        else if(parentName=="Pasta Street - Cunningham Road"){
            address.setText("37/2 , Chicago Avenue, Cunningham Road, Opposite Fortis Hospital, Vasanth Nagar, Bengaluru, Karnataka 560052");
            phone.setText("080 4097 6578");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM");}
        else if(parentName=="Fill 'n Chill"){
            address.setText("No:107/2, 80 Feet Road, Koramangala 4th Block, Koramangala, AVS Layout, Koramangala, Bengaluru, Karnataka 560034\n");
            phone.setText("080 4110 0677");web.setText("Unavailable");
            time.setText(
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM");}

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
        if(namee=="Gilly’s Resto Bar, Bangalore") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMDubwh3E4LVjJoYTE6q2odw5cR9yIaK6gLJqIE=w408-h237-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="High Ultra Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMYoNoUbr8rpvRCzfxsOxYNkleUTNMW6tsJqG8_=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Black Rabbit"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO8X6GNvRCG2yaVerwP0eH0ntS3spaI5vGYLCPy=w440-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sanctum"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMp6K-ibp6c5Sh9B7vhVMwlHhmt7G3F71SkX-PM=w540-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Skyye"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/VOvfKUvdVWdDfojTeDTjLm7msNI3hEVJmweCXrRLpA9iwv8wh78rjc1fcFVGcy-gKzI-eGPHfZRFHIRIbg3C1ZH7CFXcCvggWmbqbxyxKvc8HXRZSYUHkQBNUO-CqGFHB8rg0WvpFKwrw7D2Gobwle-2W0QeUmM=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Nolimmits Lounge & Club"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/XhrmWFNbkr8m4zZqgtl9nk6D8mVd29zFMeSVYjsqY3soE4i-j0_leTYPidNR_kSRrn4VyiT79zElGhDcdfqImEpwU-mdNPTw4UI02J0cFQBwl3RMCtuzKO-ccg6Edi0vDM2Wb0EyHmVkmdB4tOdlpSaZEVlFzxE=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="I Bar"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/0XnGw2PYP5LMR6GzVLKNM9CZ5Rd9pUnrMC_zKD8nVyLVJ_MMxp_vfXWAq46T5jdX01ZLbTt8IS4TGIoVzj9R-n2Nnd_JqMMDDaLc8CPTSatsWDr6gh8thO0jiFHPgJTKxgkNPkbQqa8EnfKlNWQoeOBwGd1Eicw=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bling"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/cpVzSAWtr3cFPLMe8M94bvABBI8SAnWiad-G04fFVike7HaWOIxEAwdsFxAV0YnXV7obTtJu7HzuE4UlH1O9DuiWktlnhHlkv54dPPPNrHy9RCsfBNIbRx-5yS7GMawh9_6sLoV3r1WXwH1_Q3iI1xqsp1RBTdQ=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Big Pitcher"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/k2_TQaEuud1hr3ol8nuk7bqzhXWkB_AwgL83ia_KEbvVccRL7jBqGajCyV9Rbs6Wa3xRJ7EEG6Z3YV290EApgi3ntW7DVCFqMFEL6daIurCAPjeKy12lDoLz674YKc0h3GEPkx17zSiGwgo0VRImn8imAtumFo0=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The 13th Floor"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPskH21SPjjC5gzNihhKGoHwi-GFKiKQu9vU6iR=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sky Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPON5lyYu6sDpphXG1CgZIioKY9ZrUpxl4MDVp-=w408-h282-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Biere Club"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/aMu7FI0EeviKqoTPLxowz3H553uvNzjB9KmLNjqUPX_c8tjLgXqG_WikvceAUO47UQviyEibaevTf9CQCuV0TgkzSQNGNbOfEjJnpqo8N1-u6SNRI37eBONFnazgI5Whs8E58ob6oPrL8GrMc_WzpqXVUBT22fI=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Toit Brewpub"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMPxxfbhpOyHLCcgIG62-zb9gKMvaH6PWqWdBk=w408-h255-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Shiro"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMAZ-0z3X2lKq6wE965rDo-R4yzpxmbtB_0cBmY=w408-h216-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Loft 38"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/hubSwIXM4q3tkqp71FIqyCGWOZAKE-oEcUNWt0I0eztZqifn0rarZMqMHp32SZCiTo3rPTN07dGnuo3gajvdL4huzrMoJgbRafNdh09DMBJ9CAWnrNHs4_0mEsAz_LP35y1Z3imYeUponV6h_6x_2iB6zLEw3w=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pebble The Jungle Lounge"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/ZXBFtpGjYhDncijtAFmACFyE39zYNT8owLwVSa87mqyLQmiuWh6s5JY_ASozOIV8dSm7iqmuCnDqgazIRrolB_RHj607tu9w0SJE3IPnwpb-gv4FN3b_QB6P64909IO18v2QLTN0uKRKdQ9bhLEHIUnlnwD4qYA=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Biere Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOOVzciL3aJ9_qGWV744cBZZBkMeprqhRbtkJty=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Sugar Factory"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPkidzWTk8wuPLvA2CS-QzpxAnfSwMs9drMrkUg=w408-h381-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bootlegger"){
            Picasso.with(c).load("https://geo0.ggpht.com/cbk?panoid=Y1sIHVAC3tUAAAQfCcEb1A&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=279.9927&pitch=0&thumbfov=100").error(R.drawable.nightlife).into(img);}
        else if(namee=="TGI Friday's"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNIJk7u_GxU2met9Thd8D2oGIbf33tmUtbRd2xp=w408-h278-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="HashTag Bangalore"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNsVEOnMdJPIjRLHMM6WsueNLtB3ig8YckLOq4l=w408-h725-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hoppipola"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPFXkVUvBEXZ0Ie7hF3_yYFOYl4eZSR6_DfNPCE=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Vapour Pub and Brewery"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNvFNv3DCRfiEIeMFgrafdzjni8k2BQPWQAUpN6=w408-h255-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sanchez"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN2LxvB2SH7d5lKAaZq7eOCgjbtrAwOzVSAaZqo=w408-h375-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bangalore Brew Works"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOxBUkx1F3EFqDVrKNW0V6QEcR9HPzaqsy2YfBD=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Gotcha"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOKFL1Qzv7B_fwPL7jfUwmXqbohPar_170sLDA0=w408-h266-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Koramangala Social"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN5gdQPtXertezM6RLiGKcih3ZEQmMUYqBcRVwi=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Russh Gastropub Bangalore"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMwMmH94p_LYju5mprGAE_Z25cAd-RRFOtISvq6=w534-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hoot Cafe & Brewery"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNQM23QBU3kphQtqz5azxZqNrHpF5ePa9KU_0IO=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Shimmer"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOO2GLn5XplzlPRnCHO7T2iXTzN9KC3kfPgWCt1=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Skywaft"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMpeEaST1t04gEfZkcJ3zsjpv7ON_l9eKDI070R=w517-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pool Bar"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/CQDw4W3kMwoqdSQCQgV5BTTKcSYAi79DcsMx9TbDFPmd3e_9aWBCc0KKcpIdXs2vH-aVmciN0C3cz2__6rm1RSgeziAa_Y5SWCVYb8jtwTgSlsWH9HuUJZeVpI6-dRGke6XuT8KiP3TnZUxNPFKMZpFfflk1W_s=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Warehouse"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOzSc5Bn8Qi8uR98iqHAYEmJg4uGAWLg7IdP5vR=w408-h320-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Church Street Social"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO-yWVxP60NZUTNdIklVfQbBt0qhlz0pchpYNPi=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hoppipola"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMSDv6ce8e1vceoZQtKRZ_3rCpoB0KE8NTv-ua4=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Big Brewsky"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPjFvX-jMPqC4hUYA0mjBxBWvKAEPfye3Vnvv8I=w408-h246-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sharaab Factory"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/V8KrlLnhq6SNqED_hGoOBNUtM-D0C2EOXMsFoo8CzlgwaNpi50asEgisdmKUsUG9LI_26tBz-HJgCunqvJ0H6BfKcmq1iDSrBFZBE9E8050U3FT2J10uHKskQN6wQLE3irs7FaMj5akseqGT0DPinvrPqnnLPg=w408-h313-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="ALT"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN1exoUqaE0fRxGx0Qo3-zK0gcG2msiI1WvNwyo=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Indigo XP"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNZ6YX-TfQdc1hPw1VHWc38VqS2cDnSgPZPNS82=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
         else if(namee=="Easy Tiger"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOuL8eEYISDB9ZGaozRN-baeHEolyftbZcNk_W5=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sagar Pub & Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMhbtDDJF2Vrkom5AfRgVeRovKLFl5xKdt1C_rF=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Watson's Ulsoor"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNa1roqp0jY8sRlZZeRy7NCq7sWyQqoByUASxMv=w408-h391-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Studio Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPWqwsI_pzOtXV5CZQJpN05B2LQJYqYQjvoOo2R=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Prost"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOHzvGh3U3BoLEHt6YHGyz1rlHIyZj7fUg7r4O1=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Banana Beach Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/FFXaRzHqYT_yMKqc1sRQjBSvWKTqwz_loeQw3ns_sWxP85WFH410G8HVoNTeZROIPbqkXj26wF7Nv9dGWMGXg58gqHcPHcqNWROYdg0BYwqmIhls9NOTVmcUwkSYUUq2tKEYuvb0eGi3dFHk0cX_zkfbKPUtbeY=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Boozy Griffin"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOLAbMhoGV6IRSa3JP6ox-yx8EQcfZG5R9u1JmK=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Irish House"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPu7ZoNlhTQ4Hd8L9I_V-lKNHi70dbS4DDEhcU5=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Rewind"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP4Bqtz6dhoKjRo2ZrKjb1Xru4mVeeQOGditwGR=w408-h268-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cirrus"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/VxkTuL-e4nRrTOrkopM6sszPN53aQAYFvYmPduf0mkNyT3OJaaqozZ5kzKQk8XoOC8xuzQKcT5WH1U57z5LGGgdi0bA-rT5IdAjjLXP4mOnlpDbxsDaJ0dj6I0-e3j5kqFm6ZojUH5myXXBdFqa10nqRhCKIjtM=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Local"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOurNDik6J8M3c7qA2KnE4w4ebSfZdu1RlpH85I=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sotally Tober"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOaqFdqTi2h6VriPz9Vs3BsnpdlxDkXoq-UWm-6=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Turquoise The Underground Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/qXq1JgZyh47NfMwVqYjQ_y3KRbLTSv2ZjqUTZIPZnCE8_AH2rfm7GfUZsdzYv69hlQxzaX6mVox360iLUhySv7p42QlsNK1N8GjMHPv6chUH7Wwja3ynvqpS2TH0zRdCQLYBOfuGZ-K1DzAT7y26foCDMaoV5M4=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Le Rock"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO2Fq_xFUsV-zPDsESejzAn43v3EndqQ27T20rA=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="XU"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNyR42dV_nxOy-m63t-9o5dqQPxROcvDuqDZcpT=w471-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bottle and Glass"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOZoL5mDwRnDBqEYs0til7zmvZYcEDyhnwCckdz=w408-h263-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bang, The Ritz-Carlton Bangalore"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM7It2VYlNO5Fq2tQLNEVoq0UCs46LGTfDKV2AR=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Liber - Resto Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/pglK7QXQUM5ROUfH2YNdujWQeEHeVsIOeIbmEpKOx-X86qzdN2mC6JbQZ6gZ4ixWSF0sGiygN-quJYicXE9chpRezAVe_3TZb78npuwmcqzHrsqjS-z7gurhwRJU_7baTl2QpROFIciJL6YMsOm1JtPPmXJm7U8=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Puma Social Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMB5KJQ91_3AiopPlydetmO1zYYSDdx-uxjNIvL=w408-h291-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Thalassa"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/nFeVJgUxLNdHohHZAJyWDoZPQj400E5xNGMLQ-dT2I0c0k2mwKIoaPoyu4inXK1GqrzRqIzwnP8q4QpTf-HhbPpILfluN-8QJB0CXYXWF-yiGDzeumAaKBDu9pz80kIVOLX2qEh3dBDWVk8LuO15xeI6XCcMJw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bar Uno"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPbxxwY61n3gDsQDYxiE-2J6UUPOw-8C_sFeI3O=w408-h235-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tilt Gastro Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPzUPJ0llK46K-cHqqcwxC_GECyqsZWWbN0anzj=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="On The Edge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNjTxB5nXWUqrAt4OlSaCbXmBwOG5cbceBIarQR=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Fusion Lounge"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/pcV3SFhuE6G8_T24v8z9urFickMlKEApyyAyaub1glqkEjVc2r07RGicEfhfBt1DQ5Da2PWCU-Y-rpkQGKyznqMF7gZUwpD355AnFVizjh3KW6Cm37U8ID4Tfm8j1hfmxi5a8S35tL9oJCBBuzo3qQLHIjrI-EE=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hammered Pub And Grub"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOmGWe0H8naKWNUYIuDMpS4xGZiGKCtbaEWd36g=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Glocal Junction"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMaMHx1SrnGOst5kptmceW7zFt6j83ln2SOc8s0=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sherlock's Pub"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/FbIN9DVwKf7n2ReyLQYi1ckRT_T79zPOExMO2w3gMqvTwAoTr87snsGL6YQn3DHfNfaWOYPYzDW9_kTttagH_30Ey6SEhlBqqFAGGW4si2sJApX1ZX3Wx-buAxsT2OjXYNw4Gd30pshHXAfE4wR3u_MzK3rWfM4=w408-h322-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tippler"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/c-w_ds0l74WJdeOVq6KnfrP8rJFHpagDJ_Z85AFAhSjHSeKw-shdWXk5oiXhISoYUgPZbjimvVU7CZq2xiUk1gbBJqaeRIbTZMKNWZv-CQc0HwNZjO2YX8io-bQldUy380hmhwUyNiy4UUlz3K40TZImn8hnB9k=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Arbor Brewing Company"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPX0NWGcce0q2PRMoV7GC9jM3PYwmbGFWdfn_zc=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Xtreme Sports Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPGFamXK1Foo0Nx291j16SzjB9z0Sy45nEdrhL5=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Jimi's Beer Cafe"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/VBBKJpSfc1GCgA-D5Hlq9VjbmLRjzXiZCfY9SeTSugmVv-G8YoAjKYka7RkYorHm4J3xFcgYf-b1ityHumrR1fbsXzJClHAzpQJRC_I_D7CM0YbOODda_aGi0A7bUKPhPjURsKdhdvqmmSgStXrhOktQUmVNZQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Quench Bar"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/AvZywGzv0VGu8UMX5hQvk9R80Nl0So_XHSp1I7yS4-7eaiFRSqB_OYHaCKTcTatgzS4g58RzcSM_tDDEmoxM_dqcqtPuj9FWGJA1bfcGLHNMNtYpTg2sBZsp8sWux8l_44SIj_By5fuxUfB7x774ymWZKhynoQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Brewsky"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMr2HWGGFrEyk1P6N5Tg26EsOkc9pJWRkhEB9nJ=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Glassy Lounge"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/Mev-pim9hZrRKUmnUK5dg9_c6dcuLMmDOQI7wQFbw9Tl39PZdPZgcxCWpcpLMx2st4Jp2CrSY96S7o2RL0ZSHvb0cwcU5HY_fMvNQdb3ORZJqqGKHJBnWdMmSgXt4t7UJc9nRTLm0B4xEm7CklBp6iq2ucyeaQ=w408-h286-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Blistering Barnacles"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/FmnLw48xiXZIZgEcXmGO0v4kYR2AENq6R_jWBG6ER5rrxdLVFK8_tiR9BTHJUUBTsehcvpHgs5nDGC0AWVZlhmaBydzgNkB1P2aCfHNpdBAkBXMr3Ko7OeO-1_9pZquNXzVgGE9h8Go2xtPRL7bfseC-XtP8pAU=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="District 6"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNNrOLBRU2yoOttQv7Rs7XC9QpCOWTQn3RuZ_hh=w464-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Punjabi by Nature"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/7NShLQwX90Hfmc5BYqjWcvhjdjuIhlzA3XU8yoXsjwYtbEC8C1JstFIMOJVVzF-kk1ACd_-0uCfYamTlBwRKuc36zc1e3d5WtrSk7HCYCEagtIfo_kmYaJysQA7u-eihU8E8MACCI2Cp5akQ7oD8-jivyKZHz3M=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Xplode Restobar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/00gFyHYfPX8XvUCYz9SvhkXlpXpljEz43XavUUr8Ehd0bQpmNrYZYnNZWwQqdrNuQKmIYIxo_U5WnUgE5U3cNTswVZ1n-SaYoEls7m7Vh9GWIMtk9IgPuLkR5bhl0TZnumluDY2VHINtK3vjGx8jgB9PUGR3gCs=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Brew and Barbeque"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM-YwfA2r1wM7V_dFwW8jaEDl2fsXWTZZP2sbqa=w480-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="612East"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN2-OhHaFPJJapEYGgrwOpZN0fPaSvW5SIkaW7L=w408-h226-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Siam Trading Co. Thai Kitchen"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNkM5zCm7Dxrw8iCPY8Se5b9lX2DuWpbfBI5A83=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Guzzlers Inn"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNf5p86Q7v4iUaA2Mp2KW2qIpehTgWDTo0zlMHA=w408-h200-k-no-pi-0-ya173.67068-ro0-fo100").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lock N' Load"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMCWbLSVvSmAYwOEWoI9_MKU2txxXPUD6EantxO=w689-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bootlegger"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNzvXdm3IKVkDnXaT_yicLF6Xko70-Crl2JPIXD=w408-h217-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Jcubez"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMk1rCG61zRtKmMQxJanPkLCP4jquxkmoOly08O=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Oak Tavern- Palm Meadows"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/SyX3A8jQo-YUCb9ZtrQPBeAbyQtw9UI-c1KiFoVLbrR4BWHdyt7evoNhk8Dv_38FDRBeabOkIIHZapUzR82VshYP5stumTV0ZxYfHX-bNe3wNRgW8p7W5ypSomJFHUCtJCOPQF1TV-Wa0Q8J42SSCUmHLYb1_g=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Boozers Bar & Kitchen"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/gN_7kk5uBmgxMOuTeTDiGUIaWFXrc-a-ymmnVGzYY0dYpi9leVloMpCRuPpTBRpwHZuWIln8BKLLlC1EUccChmNhctFslMXUV8kHBkKMRGJGSZE-qfDRuDoFzGj6cCZA-NFIxJjKhWYQ26aHvFG3rXprDVinsg=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Plan B"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/OPR2O0N0EYJeih2q4zZs4__5832R2TrNKIibA8Lq0ULZCIiJTdn5Hf6KFfJbL-_hipN3RjeO9PE-EltHJ5NbBFuYSNW7MCAwXm8YWbubKS2h-QFRSJ9xsQvLLi2hyj1uWSA4OlsLXQnxgDC4AmzSNKlCOnwqeQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Chin Lung Resto Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMaSg9H4GuFH6vRGqA_ZMwcv0WUyuybrO0s-QKC=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="1522 The Pub"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPTZFJD1qB1y5-IjfwAbhG6J5vWZdwVbKIdEkj4=w408-h204-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Attic"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/7-CA1LsrRmMc_1y8ifBufwsm1U3FqPgMukae7jpzVnW6_QUj3C0HhhPZhmlN455ktBc53ds-7rpEjo9Ojn5Mcbp5p6Vq1G6FjtyRa7Ug-AmJGxSwjEazaKbQm36un-w_2luheWo8QXokGgTqV5itjJU6ZonH4A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sly Granny"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/2QS2XE6iYI7eMVdl_4XDtjisFWnllKFSNugPVU2Nc9VPrT_0LQc6-gPJzqpwpOV8MPkH4dld6CY_8PyU-FDj6ZjTSCvr0ZGkWEBDGIZfUALnX58Ymi2wy7W-rsMa2Ff8Um0WLndp5yOVrYoWl7x87eJSxcgbNzk=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Gadang"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/F0_rAb2t2CuhAgfhWGO_201CyzckE1rsyFna04w3qc6TOZJi1Lo1E-y-mMahMezwEDiGMBCYw-eVNiyLMT93_bqrOc8Rxo_oc1BQTjAWiXTeZaOZGTxuAWcLTs1bvgTjmMd3A-pGvI-GwUSwUBSvkjVhfEWxhw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Strona - The Poolside bar"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Y-DSlg-0KzoyEiyOVLrpv4HdfdJxTGmM8BO0ZIPg8-n85NGjNr00RsKMo-tyJi6rct5r3zF3Dj6sxzFtj_xKzvXoepVTmaIU6ee6s4Yv0xc8xw6hbV6Mh3_3PmcNDufBgAFxhtkRpC-iNHy5Qe6C6oRY_y7r0Q=w408-h254-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Twins"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNZEpDV3ppoEq1RwqSJQHofQr_MQHHXUSWXhLgK=w408-h200-k-no-pi-2.9338646-ya328.4791-ro-0-fo100").error(R.drawable.nightlife).into(img);}
        else if(namee=="Rasa Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP6gwJts7EsYZurjBYDk-omIwxZkGnlMfd3N0bF=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Double Decker"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNvlOUZMutwl7JZqrFMwWtm8QEC7mC6Pl_rSlBB=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pasta Street - Cunningham Road"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMp3MeEOAFHTWNCWjsmsoVf2hJ34r6WfOVooQ01=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Fill 'n Chill"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/4STkoZEX4YBaSiYKn7LdjYOfTfiEDh-lBlTp0hHIWzaKnSiY1nS1b6mskcmEDGU_49lw3d5HKjNbWkrpQtTjoL-RTh21EfgRcEcZffPD1dj8Y8CzHirzvZbafGiZOjHN5_Tt3bYEcYGEzAdZAyK_qxh9fS1JBpU=w408-h233-k-no").error(R.drawable.nightlife).into(img);}


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