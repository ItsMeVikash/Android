package nightlife.kumar.vikash.nightlife.chandigarh;
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
        if(parentName=="Score Chandigarh") {
            address.setText("S.C.O 177 & 178, Sector - 8C, Madhya Marg, Sector 8C, Sector 8, Chandigarh, 160009");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–7PM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–7PM\n" +
                    "Tuesday\t" +
                    "11AM–7PM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("095928 81868");web.setText("scorechandigarhclub.blogspot.in");}
        else if(parentName=="Paara"){
            address.setText("T-6, 3rd Floor, Central Mall, Industrial Area, Phase-1, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM\n" +
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n");
            phone.setText("095691 78596");web.setText("liveinstyle.com");}
        else if(parentName=="Orchid Lounge"){
            address.setText("SCO 230-231, Sector 34A, Sub. City Center, Sector 34A, Sector 34, Chandigarh, 160022");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11:45PM\n" +
                    "Friday\t" +
                    "11AM–11:45PM\n" +
                    "Saturday\t" +
                    "11AM–11:45PM\n" +
                    "Sunday\t" +
                    "11AM–11:45PM\n" +
                    "Monday\t" +
                    "11AM–11:45PM\n" +
                    "Tuesday\t" +
                    "11AM–11:45PM\n" +
                    "Wednesday\t" +
                    "11AM–11:45PM\n");
            phone.setText("098559 66479");web.setText("thewhisperingwillows.com");}
        else if(parentName=="S Lounge"){
            address.setText("S.C.O 7, Sector 26, Sector 26, Chandigarh, 160001");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM\n" +
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n");
            phone.setText("070872 19997");web.setText("liveinstyle.com");}
        else if(parentName=="Kitty Su Chandigarh"){
            address.setText("The Lalit Chandigarh, Rajiv Gandhi IT Park, Near DLF Commercial Complex, Chandigarh, 160101");
            time.setText("\n" +
                    "Thursday\t" +
                    "Closed\n" +
                    "Friday\t" +
                    "Closed\n" +
                    "Saturday\t" +
                    "8–11:30PM\n" +
                    "Sunday\t" +
                    "8–11:30PM\n" +
                    "Monday\t" +
                    "Closed\n" +
                    "Tuesday\t" +
                    "Closed\n" +
                    "Wednesday\t" +
                    "Closed");
            phone.setText("0172 300 7777");web.setText("thelalit.com");}
        else if(parentName=="Purple Frog"){
            address.setText("18, Madhya Marg, Sector 26, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11:30PM\n" +
                    "Friday\t" +
                    "11AM–11:30PM\n" +
                    "Saturday\t" +
                    "11AM–11:30PM\n" +
                    "Sunday\t" +
                    "11AM–11:30PM\n" +
                    "Monday\t" +
                    "11AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11AM–11:30PM\n");
            phone.setText("075087 77777");web.setText("zomato.com");}
        else if(parentName=="Underdoggs Sports Bar & Grill"){
            address.setText("178A, 3rd Floor, Elante Mall, Industrial Area Phase 1, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n");
            phone.setText("0172 506 0401");web.setText("underdoggs.com");}
        else if(parentName=="Vintage terrace Lounge Bar"){
            address.setText("Hotel Mountview, D, Sector 10, Sector 10A, Sector 10, Chandigarh, 160011");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11:30PM\n" +
                    "Friday\t" +
                    "11AM–11:30PM\n" +
                    "Saturday\t" +
                    "11AM–11:30PM\n" +
                    "Sunday\t" +
                    "11AM–11:30PM\n" +
                    "Monday\t" +
                    "11AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11AM–11:30PM\n");
            phone.setText("095693 76129");web.setText("liveinstyle.com");}
        else if(parentName=="BUZZ"){
            address.setText("SCO 45, 46 & 47, Near Taj Hotel, Sector 17A, 17D, Sector 17, Chandigarh, 160017\n");
            time.setText("\n" +
                    "Thursday\t" +
                    "1PM–12:45AM\n" +
                    "Friday\t" +
                    "1PM–12:45AM\n" +
                    "Saturday\t" +
                    "1PM–12:45AM\n" +
                    "Sunday\t" +
                    "1PM–12:45AM\n" +
                    "Monday\t" +
                    "1PM–12:45AM\n" +
                    "Tuesday\t" +
                    "1PM–12:45AM\n" +
                    "Wednesday\t" +
                    "1PM–12:45AM\n");
            phone.setText("081960 01115");web.setText("Unavailable");}
        else if(parentName=="Hops n Grains The Microbrewery"){
            address.setText("SCO 358,, Sector - 9, Budanpur, Panchkula, Haryana 134109");
            time.setText("\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM\n" +
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n");
            phone.setText("080549 23857");web.setText("Unavailable");}
        else if(parentName=="Tao- Chandigarh"){
            address.setText("SCO 43, Madhya Marg, Sector 26, Sector 26, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–12AM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–12AM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("0172 500 1717");web.setText("taoindia.com");}
        else if(parentName=="City Cabana"){
            address.setText("Hotel City Heart Premium SCO 202-204, Andhra Bank Building,, Sector 17C, Chandigarh, Shopping Plaza, 17C, Sector 17, Chandigarh, 160017");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11:30PM\n" +
                    "Friday\t" +
                    "11AM–11:30PM\n" +
                    "Saturday\t" +
                    "11AM–11:30PM\n" +
                    "Sunday\t" +
                    "11AM–11:30PM\n" +
                    "Monday\t" +
                    "11AM–11:30PM\n" +
                    "Tuesday\t" +
                    "11AM–11:30PM\n" +
                    "Wednesday\t" +
                    "11AM–11:30PM\n");
            phone.setText("0172 272 4203");web.setText("hotelcityheartpremium.com");}
        else if(parentName=="The Back Room"){
            address.setText("SCO 165-167, 34A, Sub. City Center, Sector 34A, Sector 34, Chandigarh, 160022");
            time.setText("\n" +
                    "Thursday\t" +
                    "12:30PM–12AM\n" +
                    "Friday\t"	 +
                    "12:30PM–12AM\n" +
                    "Saturday\t" +
                    "12:30PM–12AM\n" +
                    "Sunday\t" +
                    "12:30PM–12AM\n" +
                    "Monday\t" +
                    "12:30PM–12AM\n" +
                    "Tuesday\t" +
                    "12:30PM–12AM\n" +
                    "Wednesday\t" +
                    "12:30PM–12AM\n");
            phone.setText("090691 38328");web.setText("liveinstyle.com");}
        else if(parentName=="The Brew Estate - Chandigarh's Largest MicroBrewery"){
            address.setText("#308, 3rd Floor, Elante Mall, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–12AM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t"	 +
                    "11AM–12AM\n" +
                    "Tuesday\t" +
                    "11AM–12AM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("098887 88887");web.setText("brewestate.in");}
        else if(parentName=="Buzzczar"){
            address.setText("Maya Hotel|G.J.Hotels Pvt. Ltd., Sco 325-328, Himalaya Marg, 35B, Sector 35, 35B, Sector 35, Chandigarh, 160022");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM\n" +
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n");
            phone.setText("0172 468 8700");web.setText("mayahotels.in");}
        else if(parentName=="NABOBS"){
            address.setText("SCS 2, Inner Market, Sector 9D, 9D, Sector 9, Chandigarh, 160009");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–12AM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–12AM\n" +
                    "Tuesday\t" +
                    "11AM–12AM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("0172 274 3255");web.setText("nabobs.co.in");}
        else if(parentName=="THE BEER CAFE"){
            address.setText("178-178A, Purv Marg, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–12AM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–12AM\n" +
                    "Tuesday\t" +
                    "11AM–12AM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("0172 501 7588");web.setText("thebeercafe.com");}
        else if(parentName=="Wild West Pub and Bar"){
            address.setText("SCO: 333 & 334, 35B, Sector 35, 35B, Sector 35, Chandigarh, 160022");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM\n" +
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n");
            phone.setText("0172 260 7728");web.setText("business.site");}
        else if(parentName=="Peddlers"){
            address.setText("Chandigarh Rd, Industrial Area Phase I, Chandigarh, 160002");
            web.setText("Unavailable");
            phone.setText("092164 92021");time.setText("\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM\n" +
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n");}
        else if(parentName=="Tandoori Nites"){
            address.setText("Block B, CSIO Colony, 30C, Sector 30, Chandigarh, 160030");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM\n" +
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n");
            phone.setText("097818 00004");web.setText("Unavailable");}
        else if(parentName=="Whistling Duck"){
            address.setText("SCO 10, Back Lane, Sector 26, Sector 26, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "12–11:45PM\n" +
                    "Friday\t" +
                    "12–11:45PM\n" +
                    "Saturday\t" +
                    "12–11:45PM\n" +
                    "Sunday\t" +
                    "12–11:45PM\n" +
                    "Monday\t" +
                    "12–11:45PM\n" +
                    "Tuesday\t" +
                    "12–11:45PM\n" +
                    "Wednesday\t" +
                    "12–11:45PM\n");
            phone.setText("090236 91893");web.setText("whistlingduck.in");}
        else if(parentName=="Pyramid Lounge & Club"){
            address.setText("310-A,3rd Floor Inside Elante Mall,178, Industrial Area, Phase 1, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–12AM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–12AM\n" +
                    "Tuesday\t" +
                    "11AM–12AM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("076793 00001");web.setText("pyramidcafe.in");}
        else if(parentName=="Ministry Of Bar Exchange"){
            address.setText("SCO 41, Sector 26, Madhya Marg, Sector 26, Chandigarh, 160022");
            time.setText("\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM\n" +
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t"	 +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n");
            phone.setText("073470 47005");web.setText("Unavailable");}
        else if(parentName=="Playground Bar & Cafe"){
            address.setText("Elante Mall, 178-178A, Purv Marg, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–1AM\n" +
                    "Friday\t" +
                    "11AM–1AM\n" +
                    "Saturday\t" +
                    "11AM–1AM\n" +
                    "Sunday\t" +
                    "11AM–1AM\n" +
                    "Monday\t" +
                    "11AM–1AM\n" +
                    "Tuesday\t" +
                    "11AM–1AM\n" +
                    "Wednesday\t" +
                    "11AM–1AM\n");
            phone.setText("098320 80000");web.setText("Unavailable");}
        else if(parentName=="Mermaid Pub and Restaurant"){
            address.setText("Uttar Marg, Sector 5-A, Chandigarh, 160005");
            time.setText("\n" +
                    "Thursday\t" +
                    "10AM–9:45PM\n" +
                    "Friday\t" +
                    "10AM–9:45PM\n" +
                    "Saturday\t" +
                    "10AM–9:45PM\n" +
                    "Sunday\t" +
                    "10AM–9:45PM\n" +
                    "Monday\t" +
                    "10AM–9:45PM\n" +
                    "Tuesday\t" +
                    "10AM–9:45PM\n" +
                    "Wednesday\t" +
                    "10AM–9:45PM\n");
            phone.setText("0172 274 1266");web.setText("Unavailable");}
        else if(parentName=="Blue Nite Beer Bar & Restaurant"){
            address.setText("Shop No. 88, Sector 47 D, Sector 47, Chandigarh, 160047");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM\n" +
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n");
            phone.setText("094645 65879");web.setText("Unavailable");}
        else if(parentName=="KINGDOM OF BEER - MICROBREWERY & WINE CAFE"){
            address.setText("sco 28, Madhya Marg, Sector 26, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM\n" +
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t"	 +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n");
            phone.setText("098880 14440");web.setText("kingdomofbeer.in");}
        else if(parentName=="Pashtun Restaurant"){
            address.setText("SCO 333-334, Sector 35-B, 35B, Sector 35, Chandigarh, 160035");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–11PM\n" +
                    "Friday\t" +
                    "11AM–11PM\n" +
                    "Saturday\t" +
                    "11AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "11AM–11PM\n" +
                    "Tuesday\t" +
                    "11AM–11PM\n" +
                    "Wednesday\t" +
                    "11AM–11PM\n");
            phone.setText("0172 260 7728");web.setText("pashtun.in");}
        else if(parentName=="SMAAASH Chandigarh"){
            address.setText("Plot No.178-178A, 3rd Floor, Elante Mall, Chandigarh Industrial Area, Phase 1, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "10AM–11:30PM\n" +
                    "Friday\t" +
                    "10AM–11:30PM\n" +
                    "Sunday\t" +
                    "10AM–11:30PM\n" +
                    "Monday\t" +
                    "10AM–11:30PM\n" +
                    "Tuesday\t" +
                    "10AM–11:30PM\n" +
                    "Wednesday\t" +
                    "10AM–11:30PM\n");
            phone.setText("0172 521 3555");web.setText("smaaash.in");}
        else if(parentName=="Ice Cube"){
            address.setText("SCO 35, Madhya Marg, Sector 7C, Sector 7-C, Sector 7, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "10AM–11PM\n" +
                    "Friday\t" +
                    "10AM–11PM\n" +
                    "Saturday\t" +
                    "10AM–11PM\n" +
                    "Sunday\t" +
                    "11AM–11PM\n" +
                    "Monday\t" +
                    "10AM–11PM\n" +
                    "Tuesday\t" +
                    "10AM–11PM\n" +
                    "Wednesday\t" +
                    "10AM–11PM\n");
            phone.setText("098552 28888");web.setText("icecubechandigarh.com");}
        else if(parentName=="Space"){
            address.setText("SCO 202-203-204, Andhra Bank Building, Bridge Road, C, Sector 17, Shopping Plaza, 17C, Sector 17, Chandigarh, 160017");
            time.setText("\n" +
                    "Thursday\t" +
                    "11:30AM–12AM\n" +
                    "Friday\t" +
                    "11:30AM–12AM\n" +
                    "Saturday\t" +
                    "11:30AM–12AM\n" +
                    "Sunday\t" +
                    "11:30AM–12AM\n" +
                    "Monday\t" +
                    "11:30AM–12AM\n" +
                    "Tuesday\t" +
                    "11:30AM–12AM\n" +
                    "Wednesday\t" +
                    "11:30AM–12AM\n");
            phone.setText("0172 272 4203\n");web.setText("hotelcityheartpremium.com");}
        else if(parentName=="Stage"){
            address.setText("Hyatt Regency Chandigarh, 178 Industrial and Business Park, Phase I, First Floor, Industrial Area Phase I, Chandigarh, 160002");
            time.setText("\n" +
                    "Thursday\t" +
                    "4PM–12:30AM\n" +
                    "Friday\t" +
                    "4PM–12:30AM\n" +
                    "Saturday\t" +
                    "4PM–12:30AM\n" +
                    "Sunday\t" +
                    "4PM–12:30AM\n" +
                    "Monday\t" +
                    "4PM–12:30AM\n" +
                    "Tuesday\t" +
                    "4PM–12:30AM\n" +
                    "Wednesday\t" +
                    "4PM–12:30AM\n");
            phone.setText("070870 33596");web.setText("chandigarh.regency.hyatt.com");}
        else if(parentName=="Satva"){
            address.setText("SCO 40, Basement,, Sector 26, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "7PM–12AM\n" +
                    "Friday\t" +
                    "7PM–12AM\n" +
                    "Saturday\t" +
                    "7PM–12AM\n" +
                    "Sunday\t" +
                    "7PM–12AM\n" +
                    "Monday\t" +
                    "7PM–12AM\n" +
                    "Tuesday\t" +
                    "7PM–12AM\n" +
                    "Wednesday\t" +
                    "7PM–12AM\n");
            phone.setText("093569 83456");web.setText("facebook.com");}
        else if(parentName=="VoiZe Lounge Bar"){
            address.setText("SCO 22, Madhya Marg, Sector-26, Sector 26, Chandigarh, 160019");
            time.setText("\n" +
                    "Thursday\t" +
                    "11AM–12AM\n" +
                    "Friday\t" +
                    "11AM–12AM\n" +
                    "Saturday\t" +
                    "11AM–12AM\n" +
                    "Sunday\t" +
                    "11AM–12AM\n" +
                    "Monday\t" +
                    "11AM–12AM\n" +
                    "Tuesday\t" +
                    "11AM–12AM\n" +
                    "Wednesday\t" +
                    "11AM–12AM\n");
            phone.setText("084370 23150");web.setText("facebook.com");}
        else if(parentName=="MIAMI (Club & Lounge)"){
            address.setText("SCO 18-19, Madhya Marg, 9D, Sector 9, Chandigarh, 160017");
            time.setText("\n" +
                    "Thursday\t" +
                    "12PM–12AM\n" +
                    "Friday\t" +
                    "12PM–12AM\n" +
                    "Saturday\t" +
                    "12PM–12AM\n" +
                    "Sunday\t" +
                    "12PM–12AM\n" +
                    "Monday\t" +
                    "12PM–12AM\n" +
                    "Tuesday\t" +
                    "12PM–12AM\n" +
                    "Wednesday\t" +
                    "12PM–12AM\n");
            phone.setText("098158 57330");web.setText("Unavailable");}
        else if(parentName=="lava bar"){
            address.setText("Taj Chandigarh, Block No. 9, Sector 17, Chandigarh 160017, India");
            time.setText("All days of the week\n" +
                    "11:00 AM - 12:30 AM");
            phone.setText("+91-172-6613000 ");web.setText("Unavailable");}
        else if(parentName=="crystal lounge bar"){
            address.setText("SCO 18, Madhya Marg, Sector 26, Chandigarh 160019, India");
            time.setText("All days of the week\n" +
                    "11:00 AM - 11:00 PM");
            phone.setText("+91-172-4621382 ");web.setText("");}


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
        if(namee=="Score Chandigarh") {
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPIGmlqnjLO5b-6E-4dAEX5-N0MDixiyFSrAsd4=w408-h283-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Paara"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMgkJavb1PmHgOP24ABjP6mhGbj2PaGmr7mFA8=w408-h612-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Orchid Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOzjT-lE4AkXYB4JZ7EkgC1RPZ4kyG4j_4i5Mg=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="S Lounge"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/dODtsNYjA7vCzt7QEvyeUDAzG2smCpCXt4v2smPm_PU5-6WsdVpoBdaB_c-htf3nOw0SlbLVCwdS8200mzLpn9aQnasHHbR01fRlJ_OttagtQccjAul5eF1F5Dyw5fcy6J3fIHi6B3_k_Mq8I0QJadqIrqUFBBk=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Kitty Su Chandigarh"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipP9N5Y8hZf06HAbmppukUFvwpBPcslgEmr-Z5px=w592-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Purple Frog"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOGYFc4q_TTZhWiu3iusJoWK77Q1GEFkZTj_9p5=w408-h725-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Underdoggs Sports Bar & Grill"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNMyome9QX9xaisZGD6Hdc9_sK6wHd1I_md9g3I=w408-h221-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Vintage terrace Lounge Bar"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/Nxy020gQurRbug6TyErti8NwDM6hG1hfXRPeb_V8-8LiK8E-YU6eaTPOz2zFj8WiHh_axvzoEuCHGcstkHjjZrPBF272o3v_f5nV2Kj9GN_zkcHmCeKGbN5wzvRRxo2wVvzC41xEX5rAaDaREHBs__btqZzfEA=w612-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="BUZZ"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMA4C_8UK0pkajGq4Rc7g_rV2qr2Oy6bwznLqY3=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hops n Grains The Microbrewery"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMnjqogyxrHT9BEcjxXFICXq3y-p02whziJczFQ=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tao- Chandigarh"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/7RpwX_NOayIBR0oPw2tekbQxIaCF5e0PlbYc97jizXlNBfBoTQOVPo0wU37hfzbP4B0nPqDkgW4irYBQKhBvIEL2KEnksfX4dfKVbKn19MyQjVb4rPP-F1mmnWKws81QixNSMxPbvAL22lx263CzzW7ICfzSJw=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="City Cabana"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/IoCD1P4sswKO_nLToO1Fju5H9QjUDsNhIeVYrki8HLGxCKS0qj3IRsUsnv9m2FEGdEs3Oc8jX5yE7zQaclsMUef_PCdzjGmNRuq32S4G-n-r6QJtzAeUxjnj3lMryF75VPkYvW3UuSWeYra7Wfqrx0I1IypqGw=w408-h353-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Back Room"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/8cFIu9pYK8migDUgr-ahPwCFZwJwRPhLKTkTxcQVdnX0I2vgBY2968Uy9_yCoC9g2zgMXv6OSxFkXERGVWgrWYt0PB1YSem2X7rgkhomYJ9R1l0NatJd6S4IyK8yvy8t0uixn0UDfz-0ecKCE0-AnQTUMerzvA=w577-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Brew Estate - Chandigarh's Largest MicroBrewery"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMx5lRqxBRYZR2TRKkXtLdPR8do9cdYpAsqdpBv=w537-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Buzzczar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNY13XgB_u57dPcXkXl6ka3oVErJ0UZt7giKRrt=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="NABOBS"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO0V6ENis1ES7krKAcpS47z7_uQfJ3wVsGEZ1qT=w444-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="THE BEER CAFE"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPYBSAXTtia29_pu81roG4irhcC-m7Akk5xaFWB=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Wild West Pub and Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNmx9jZs079QmTjDLvEcYdzNBQz8a6GhnaEbSdp=w408-h544-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Peddlers"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/l1ekIXTqV78X26aDG67h5sWB1-P6Dpu5qaN5JCEonaRhrsl-L8zLU0GHiMTQPg_F94KtmYM2EiYz4j_UbD5kHcNEZhL32jlZppQMnvuq1TdE3QAXSiISWCi49KoFiK57LycnkAsF84tiA3NnIXTjyIMPy0g0CA=w414-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tandoori Nites"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOQBv7j82pQ-M9rsIPXskaAspfYNGcB6riKclf_=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Whistling Duck"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMe5G9kN0leqsX-M0-LCVqB6fEwvsWf0amufR_k=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pyramid Lounge & Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMYI8z7O_aOTIJyGtOfPVvrmF8vYd9i58E5AcUd=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ministry Of Bar Exchange"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/BohU9fMipQPAGyPnM-GAmt7hnvpwLxMsY8rW6X1XFWCKnfaevM9tluGQsdbLORM-Ih7D9151iuRajIiciKBSqC4L5N7efexUbMwUiChEQsUnoI0PwZio6iGPHTyNt8FCyk7oZuTg5JdRcfavzknTsf4-YzBp9AM=w408-h273-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Playground Bar & Cafe"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPPtjz3DvW0GsKg0_Vx-rKUtG3Jg2YXYXk-9Gua=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Mermaid Pub and Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOkydgrOS9arv_xiKYkmOFPRv6jZ95qFA13SoEm=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Blue Nite Beer Bar & Restaurant"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/nozjkVZV9WYZjvdmEj7g3xQyig1CgchZ17uJdV82tnFWSbHorp6IgKU1N8bZBYj-WQrKrlsImRPz5rah8gBXFnLIXYr0yIr0FM54qBZTnUGYE59zhlu8paGxlL2Ft2ip-8gUd-yEOps85HpKu8gM7LncwLQcWw=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="KINGDOM OF BEER - MICROBREWERY & WINE CAFE"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMIpGUiawWBUfmTW3FPuuyCyA_LeBXUd7Qpfoss=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Pashtun Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM5vk1Y6qVXxTxoBnRv78zgCeVgBTbCQarZ0BAP=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="SMAAASH Chandigarh"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/_J_tisszyNS9uuUcESJbpUjJ4dvhjS-97T8hyKj86L-x6Aa4VxrST4snCIcBHbcOgZUa7sPCaW34mt8QzIDhH6-P_h1Fcj_Brj_3acjdc4erD_m7rLzR4NUZc2VsglhahsjftfWoo75e7iNNzXUTOsuxWhBvHj8=w498-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ice Cube"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/7OcO05KnIvhH2pm1MdPt8edeMQx0nT-OcAkhGqzNl_yoLARTHx2rDK_2EHf3KmONv1_1JyRGQcqy-fnsHnW-7r-tZO0iz-TUlZ1V9LtXynwL_yU0eu6MDxtuzhu0Mg1_c5KZXmVU_hm_W8R_QyBzEtXezsb6RA=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Space"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOI6lFSVYZnjw_cLgjUXhWFp-F8Jsw7fKKDFUZv=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Stage"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPC9xC17OiDERamjiJoJe3onpUbC9KBHtzA5XB7=w408-h261-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Satva"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/yBA5gOXiDkqYOfdJorGsQBR-Ius7qsFHe5rJj2yDE1zoFdKbd7ZzBD9yKHXmLHk7wzW19b0h8cZetGJV4i-OsG9VvgzCp72zW5Oig4RZgu9bubrb3eryUcYVLq9CQb1NIVHDtqrmOjZ6WfIwZyGlK1b8C9eQayY=w408-h268-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="VoiZe Lounge Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPqI7iQYf-JFLHeR6QMf7tUdgfVpnvfLDzug0Eh=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="MIAMI (Club & Lounge)"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/8FFurwpGaX310K8IMYqWrEW9FN5NOW0VcVXD4fr7fNfNCYd-zCs4zYdrvgxleSv18OZY1J_KJDzZ8wSsh3Yl-xWmhrh2R3wnSvCQRiaY04kAzODLHZhOI7viUvjZljoozQQSF_onUosjpVDSHtGEjdIkHbDs0Ew=w408-h301-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="lava bar"){
            Picasso.with(c).load("https://images.ixigo.com/image/upload/t_thumb,f_auto/lava-bar-images-photos-56e9436dbad3eb0246f86930.jpg").error(R.drawable.nightlife).into(img);}
        else if(namee=="crystal lounge bar"){
            Picasso.with(c).load("https://images.ixigo.com/image/upload/t_thumb,f_auto/crystal-lounge-and-bar-images-photos-53211f78ca06ff4b5fc73b42.jpg").error(R.drawable.nightlife).into(img);}

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