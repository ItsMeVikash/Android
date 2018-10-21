package nightlife.kumar.vikash.nightlife.pune;

/**
 * Created by vikash kumar on 28-12-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.Html;
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
import nightlife.kumar.vikash.nightlife.google_floating_button;
import nightlife.kumar.vikash.nightlife.GoogleMap.GoogleMaps;
import nightlife.kumar.vikash.nightlife.NoUnderlineSpan;
import nightlife.kumar.vikash.nightlife.R;
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
    public View getChildView(final int parentpos, int childpos, boolean isLastChild, View convertview, final ViewGroup parent)
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
        if(parentName=="Penthouze Nightlife"){
            address.setText("Koregaon Park, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411001");
            web.setText("Unavailable");phone.setText("095119 01812");
            time.setText("All_Days\t\n" +
                    "5PM–3AM");}
       else if(parentName=="Area 51"){
        address.setText("Baner Village, Baner Hills, Javahar, Haveli Taluka, Baner Gaon, Baner, Pune, Maharashtra 411045");
        web.setText("area51india.com");phone.setText("098225 11688");
        time.setText("Only Saturday\t\n" +
                "8PM–2AM\n"+"Other Days\n"+"Closed");}
    else if(parentName=="High Spirits Cafe"){
        address.setText("35A/1, S Main Rd, Parvati Gaon, Koregaon Park, Pune, Maharashtra 411001");
        web.setText("dahigh.com");phone.setText("086000 63174");
        time.setText("All_Days\t\n" +
                "8–11:30PM");}
    else if(parentName=="Mix@36"){
        address.setText("36/3-B, Koregaon Park Annexe, Mundhwa Road, Ghorpadi, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411001");
        web.setText("starwoodhotels.com");phone.setText("020 6721 0000");
        time.setText("All_Days\t\n" +
                "5PM–1AM");}
    else if(parentName=="Hoppipola"){
        address.setText("126/2B, Hotel Shree Nanda Excellency, ITI Road, Aundh, Goodwill Society, Sanewadi, Aundh, Pune, Maharashtra 411045");
        web.setText("liveinstyle.com");phone.setText("090215 55417");
        time.setText("All_Days\t\n" +
                "12–11PM");}
    else if(parentName=="Sin Envy Pride"){
        address.setText("Koregaon Park Annexe, Mundhwa, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411036");
        web.setText("liveinstyle.com");phone.setText("090211 22809");
        time.setText("Monday & Tuesday\n"+"Closed\n"+"All_Other_Days\t\n" +
                "8:30PM–12:30AM");}
    else if(parentName=="Effingut"){
        address.setText("No. 21/A, Plot No. 389, Serene Bay, Lane Number 6, Ashok Chakra Society, Meera Nagar, Koregaon Park, Pune, Maharashtra 411001");
        web.setText("effingut.com");phone.setText("076200 38888");
        time.setText("All_Days\t\n" +
                "12:30PM–1:30AM");}
    else if(parentName=="Swig"){
        address.setText("Senapati Bapat Rd, Sheti Mahamandal, Laxmi Society, Model Colony, Shivajinagar, Pune, Maharashtra 41101");
        web.setText("Unavailable");phone.setText("Unavailable");
        time.setText("All_Days\t\n" +
                "11:30AM–11:30PM");}
    else if(parentName=="Flying Saucer - Skybar"){
        address.setText("9th Floor, Sky Vista Building, New Airport Rd, Mhada Colony, Viman Nagar, Pune, Maharashtra 411014");
        web.setText("liveinstyle.com");phone.setText("090215 45468");
        time.setText("All_Days\t\n" +
                "12PM–12:30AM");}
    else if(parentName=="Apache High Street"){
        address.setText("Shop No 3, Panchsheel business park, Balewadi High Street, Baner, Laxman Nagar, Baner, Pune, Maharashtra 411045");
        web.setText("liveinstyle.com");phone.setText("090211 12816");
        time.setText("All_Days\t\n" +
                "11AM–11:30PM");}
    else if(parentName=="The Irish House"){
        address.setText("Phoenix Market City, Level 2, Viman Nagar Road, Viman Nagar, Clover Park, Viman Nagar, Pune, Maharashtra 411014");
        web.setText("theirishhouse.in");phone.setText("082860 89727");
        time.setText("All_Days\t\n" +
                "10:30AM–12AM");}
    else if(parentName=="1 Lounge"){
        address.setText("81/1, Mundhwa, Koregaon Park Annex, Opp Satellite Towers, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411036");
        web.setText("1loungepune.com");phone.setText("095612 13121");
        time.setText("All_Days\t\n" +
                "7PM–1:30AM");}
    else if(parentName=="Paasha Lounge"){
        address.setText("411016,, Laxmi Society, Model Colony, Shivajinagar, Pune, Maharashtra 411016");
        web.setText("marriott.com");phone.setText("020 6683 3333");
        time.setText("All_Days\t\n" +
                "6PM–12:30AM");}
    else if(parentName=="Oak Lounge - Marriott Suites"){
        address.setText("81, Mundhwa Koregaon Annexure, Koregaon Park Annexe, Mundhwa, Fatima Nagar, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411028");
        web.setText("marriott.com");phone.setText("090490 07096");
        time.setText("Unknown");}
    else if(parentName=="T.G.I Friday's"){
        address.setText("3rd Floor, Seasons Mall, Magarpatta City, Magarpatta Police Station Road,, Hadapsar, Magarpatta City, Hadapsar, Pune, Maharashtra 411013");
        web.setText("liveinstyle.com");phone.setText("095792 39123");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="Local Gastro Bar"){
        address.setText("6th Floor, Kapila Matrix, North Main Road, Koregaon Park Annexe, Mundhwa, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411001");
        web.setText("Unavailable");phone.setText("089565 37796");
        time.setText("All_Days\t\n" +
                "3PM–1:30AM");}
    else if(parentName=="Teddy Boy"){
        address.setText("9th Floor, Deron Heights, Baner, Varsha Park Society, Baner, Pune, Maharashtra 411045");
        web.setText("liveinstyle.com");phone.setText("091686 54499");
        time.setText("All_Days\t\n" +
                "5:30PM–12AM");}
    else if(parentName=="Lollapalooza"){
        address.setText("401/402, Rooftop, Vision Galleria, Kunal Icon Rd, Pimple Saudagar, Pune, Maharashtra 411027");
        web.setText("facebook.com");phone.setText("090750 79303");
        time.setText("All_Days\n"+"11AM–1AM");}
    else if(parentName=="The Fishbowl"){
        address.setText("88 Adjacent to Aga Khan Palace, Nagar Rd, Palace View Society, Nilanjali Society, Kalyani Nagar, Pune, Maharashtra 411006");
        web.setText("pune.hyatthotels.hyatt.com");phone.setText("020 4141 1234");
        time.setText("All_Days\t\n" +
                "1PM–1AM");}
    else if(parentName=="Rude Lounge Viman Nagar"){
        address.setText("5th Floor, Trade Net Building, Next to Phoenix Market city, Pune Nagar Road, Viman Nagar, Clover Park, Viman Nagar, Pune, Maharashtra 411014");
        web.setText("rudelounge.co.in");phone.setText("077388 92808");
        time.setText("All_Days\t\n" +
                "11:30AM–12:30AM");}
    else if(parentName=="Hidden Place"){
        address.setText("2 & 3, Upper Ground Floor, Gera Legend, North Main Road, Koregaon Park, Ragvilas Society, Koregaon Park, Pune, Maharashtra 411001");
        web.setText("hiddenplace.in");phone.setText("020 6621 5922");
        time.setText("All_Days\t\n" +
                "11AM–11:45PM");}
    else if(parentName=="Chaos"){
        address.setText("Unit No. FF 14, 15 and 16, 1st Floor Westend Mall, Harmony Society, Ward No. 8, Wireless Colony, Aundh, Pune, Maharashtra 411007");
        web.setText("thebrewmaster.in");phone.setText("077418 88222");
        time.setText("All_Days\t\n" +
                "12PM–12AM");}
    else if(parentName=="The Mugshot Lounge"){
        address.setText("3rd Floor, Jewel Square Mall,, Vasani Nagar, Koregaon Park, Pune, Maharashtra 411001");
        web.setText("Unavailable");phone.setText("020 3952 0718");
        time.setText("All_Day\t\n" +
                "11:30AM–11PMs");}
    else if(parentName=="Mmyra Lounge"){
        address.setText("G4, Fergusson College Road, Opp Fergusson College Main Gate, Millennium Plaza, Shivajinagar, Pune, Maharashtra 411004");
        web.setText("Unavailable");phone.setText("020 6533 9988");
        time.setText("All_Days\t\n" +
                "11AM–11:30PM");}
    else if(parentName=="1000 Oaks"){
        address.setText("2417, East Street, Camp, Pune, Maharashtra 411001");
        web.setText("1000oaksindia.com");phone.setText("020 2634 3194");
        time.setText("All_Days\t\n" +
                "12:30–11:30PM");}
    else if(parentName=="Cuba Libre Seasons Mall"){
        address.setText("Seasons Mall, Level 2, Shop No-37, Magarpatta City, Magarpatta City, Hadapsar, Pune, Maharashtra 411013");
        web.setText("business.site");phone.setText("077198 80404");
        time.setText("All_Days\n"+"12PM–1AM");}
    else if(parentName=="Replay Sports Bar"){
        address.setText("Shop 1 & 2, Primrose Mall, Baner Road, Baner, Baner, Pune, Maharashtra 411045");
        web.setText("Unavailable");phone.setText("020 3018 9659");
        time.setText("All_Days\t\n" +
                "3PM–12AM");}
    else if(parentName=="Single Malt and Co"){
        address.setText("Ground Floor Hyatt Regency, Sakore Nagar, Viman Nagar, Sakore Nagar, Viman Nagar, Pune, Maharashtra 411014");
        web.setText("Unavailable");phone.setText("020 6645 1620");
        time.setText("All_Days\t\n" +
                "11AM–1:30AM");}
    else if(parentName=="Culture - Pune"){
        address.setText("1195/2C, Fergusson College Road, Shivajinagar, Sud Nagar, Shivajinagar, Pune, Maharashtra 411005");
        web.setText("Unavailable");phone.setText("090670 16701");
        time.setText("All_Days\n"+"12PM–12:30AM");}
    else if(parentName=="Bottlerock"){
        address.setText("Pashan-Sus Road, Behind Audi Showroom, Baner, Pune, Maharashtra 411021");
        web.setText("Unavailable");phone.setText("020 3018 9958");
        time.setText("All_Days\t\n" +
                "6:30PM–1:30AM");}
    else if(parentName=="Merlins"){
        address.setText("The Orchid Hotel,Adjacent to Chhatrapati Shivaji Sports Complex,, National Games Park, Mahalunge, Pune, Maharashtra 411045");
        web.setText("orchidhotelpune.com");phone.setText("077380 76692");
        time.setText("All_Days\t\n" +
                "4–11:59PM");}
    else if(parentName=="Agent Jack's Bar"){
        address.setText("270/1/23, Varsha Park Lane C, Devideep Housing Society, Varsha Park Society, Baner, Pallod Farms, Baner, Pune, Maharashtra 411045");
        web.setText("Unavailable");phone.setText("020 3018 9939");
        time.setText("All_Days\t\n" +
                "10AM–1AM");}
    else if(parentName=="23 East Lounge"){
        address.setText("Keshav Nagar,Manjari Rd,Mundhwa, Pune, Maharashtra 411036");
        web.setText("Unavailable");phone.setText("088058 36255");
        time.setText("All_Days\t\n" +
                "5PM–12AM");}
    else if(parentName=="Elephant & Co. Gastropub"){
        address.setText("Rd Number 8, Princeton Town Society, Pluto Society, Kalyani Nagar, Pune, Maharashtra 411006");
        web.setText("liveinstyle.com");phone.setText("089993 19347");
        time.setText("All_Days\t\n" +
                "12:30PM–12:30AM");}
    else if(parentName=="HUB- Lounge Cafe Rooftop"){
        address.setText("4th floor, Xion Mall and Multiplex, Hinjawadi Road, Hinjawadi, Hinjawadi Village, Hinjawadi, Pune, Maharashtra 411057");
        web.setText("hubpune.com");phone.setText("078880 32931");
        time.setText("All_Days\t\n" +
                "5PM–1:30AM");}
    else if(parentName=="Hashtag The Lounge"){
        address.setText("3rd floor, Power Plaza, Above SBI Bank, Lane Number 7, Meera Nagar, Koregaon Park, Ashok Chakra Society, Meera Nagar, Koregaon Park, Pune, Maharashtra 411001");
        web.setText("Unavailable");phone.setText("020 6580 0010");
        time.setText("All_Days\t\n" +
                "4PM–1AM");}
    else if(parentName=="F Beach House"){
        address.setText("61 1b, Jadhav Nagar, Mundhwa, Jadhav Nagar, Mundhwa, Pune, Maharashtra 411036");
        web.setText("facebook.com");phone.setText("093239 68825");
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
        if(namee=="Penthouze Nightlife"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/xdKzDm9pRxCNNua7do5hVMdKn46suB9TEg2cxTtArSDUiDtp-NCIwZhVcfwck-01BwHBw3bC7PgiZOoF25Uts64Bxas7M2Vv6Bggm4Jy1NxSZ_KZARWAHMwWmRFzFKubHXZQa82Mn9vg00PBZL2cdt7v1wlYtQ=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Area 51"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/PfbPkcg-Fjwk6IWbUyN3zNav2VdNQoQDS4CwaqiVX6AyM-7HoYGW-HSr6oEhS7dd4zbiT5YoVCypY0elSAc7kwNlOQChpf5LPWbazEivemCev1BFE3U8SrcJq4VwCcpLzJ6zix7_tf7JUHd0UGJK_5WpH1WP5vg=w408-h204-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="High Spirits Cafe"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN8O2qnOSrBYs3mnf4OZ8XNeKb2lvQTL-MLb2NZ=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Mix@36"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/AC6RCP7ruBsW8DgAODGWw_YDu7SuDsxXMu-AkcEpz1APe0d_YPh58Iu_SR8rGSzNbzGpMxdkIqtxymoXFsAYj9N2ZI-B19p-FH8zAd_J4ml7ZjHZRB8zkek80MXv6RKyBuXGhpQvEess0gc6hMswxr3UnAj26A=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hoppipola"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMKaLCbrVvqZ8vC3ycV71qp6XjwgKW7dT-coKGg=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Sin Envy Pride"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/LqxgRe7KeIFp3atbIqUejpiULEX7lkz9G3IKx3ihiYzZtfei0Md_AoB1dnnxvU7kOlB3UC0HZ2J1xZnS0DUeqwhrb3ObWeId0r-V6KXejXIvIJzHEH3y0IGahPzxACePoKsQhqCUWHDrcvroZSmaZ6BAJU4VuA=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Effingut"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMnqtTqH3yj6cpI3Jc8mFrsmI8KcZHbb6z-Gn8d=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Swig"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMondGzZf9x2rUg1tbWFwm_nECUyh342MUe6jvp=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Flying Saucer - Skybar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN8TDCN4QOGYwxeJe5ydXXimVxYB8B5XFfJLqfM=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Apache High Street"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNlFct6fI97JiNaJ6eVSM_POZZU_gmQQ5OdwmtV=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Irish House"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/yqZdfxDuMeoSY95avfoDKRrqpS-ZGEq7GLgIolwzG7ysDfMv3NBZTPR3F7rkH4ngVvaAbgNeTv2HHZa08An1heELYCTLhGL9nJwVrgd3-xlzW3In_Lr9mOXWHPrA1yo5hnyj4nf9-HTIt7G7NxBkrtRJP6bNKw=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="1 Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/RNsRc20sbWpoheN41piFGY4cdHzpC9Qce63V7X4MXkUrxOYLg7Eb51vB5ZPkj5eDEA50RrwTBNu6o-K0LQfbY4n7Elg-8oe9x_29pXe6PhWxRDL7Jx4amGiGoFcX2swtMGN9bYD4nDOORuF9Dvpdr2Dujh1JZIk=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Paasha Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO5nHfrsggwH-5b0N7XFeba2adGxFJ5tLMvgnzw=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Oak Lounge - Marriott Suites"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMuFnAC57JHJFPyehsdrGyBvPKN9eFdmRl7c5qB=w408-h255-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="T.G.I Friday's"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM3Lbsb12cAUnauQzMk1QBUj4V4wq_IMTx43udF=w408-h300-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Local Gastro Bar"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/yRFJHjKyxyCkOse-mcUPus8ZX-AIvgH5GPLpr7DK18LlbAMSbpiS71tjCjsX0JkmDrvqU2vR0YQrTxG71BB-VMM_lbzG8aN2D2bjs2Kzm_eZjp88srgHjjIJXaq6GwtyNd4xiW9lz1FEmYeVdEgXfHz1n5oua4I=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Teddy Boy"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/aX9VbMDSziWvRVH_QE1mZ0Wy9cxMmOH0CxzQlYAcWpx-xcEbl26QWxp5j9e1cTlSwjsuRFS6ne2xdGwxus65gY_KZpzSyYTgmIos4aeiwOQj8TqgVBo1-1bb7r913dfq1JVuuNARSEGdJaWRxHCQFMCDPuV9DL4=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Lollapalooza"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/OfaOg6Jc8oy4l-6j5huZHllg_mXXPl24Lq7J1YXyIYsHGVHRP8ekLpuKvp0qKT_JQYVn-zOJz20-Be0TdXZo4FaMxR72R4khGYEAV3r9xVxr6lTrtL_2OPhEr2bn2jPbyR9ONN1GWn58v2OBVZeh1T6LRncz8oU=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Fishbowl"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMzqcI2oaESZobf6WzFC8U254VcgDk6p3tpmOZb=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Rude Lounge Viman Nagar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPmDcLKsRDajk8tmGg9_S_wpg6d69Zqo6ZzNL3n=w408-h268-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hidden Place"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/UHr60WiuY80XfbN44GaLNxH6DpTFmv4J52PvAABEaKVDvR3hfgXPDJFNgOAgFB-N3yafZz-G0qyOtLNAnVWDz2-E4lZRll4hKX4WBXeaB9hfVSbeje2F7ewXZNP5MGs270P3JgKgo7E45EUBPm2qBt5y5WlYrHE=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Chaos"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOvN07OLUshsvpBBfXO_QkG85UGogKgk-EAOflP=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="The Mugshot Lounge"){
        Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/11Mqyq5rLoZIaJkHxxCcCBEi-hW1b4ViG2cGPC3S4MCI_lM7TmwRA_fhhcafuQ2tRqoICKKSsvZ0diaricd7W4Ovhcn85SssM6VOdrA1CMuqYZGhkDhPEEuQn1gTw19KBNVxzQJdBod3SXbPkaLNWDrZigcckQ=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Mmyra Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPmaCphBGG2HxH-DMCPBFoo3x6tWyewlVCqX1Ge=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="1000 Oaks"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMnd91FBNWYCs4g33DUVHQCXla2iw7E9WIwL9s1=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Cuba Libre Seasons Mall"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPcdNF8ZopIeIBNomdyRp5VOYE9PE5XmG84wC0j=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Replay Sports Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPA7njiiDIMfNMUPmJatx4ipPgx5GqCuOUhk-8=w408-h224-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Single Malt and Co"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOsRv8zW_m5GUIPJ3Qc6ryizmS-RHxjWZomlE0G=w408-h219-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Culture - Pune"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOnATCX1LZpR04FVTRQSAzByc5cmYVDjYoDEFOO=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Bottlerock"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/6D_NE21nhBYLXoRf7o4wZ9Yhjeg9fdjagltaL0l8FchlxVjxEpubroIpnqf2Vcdr00Xy8YugbLlcCaovARcdZXue03H0grOqoJyyaCnNBzoKHC2BSdGeEg-7X3-EJ2sYLkHHfOnkAvQqbQKcoKhAD80sYg2Z7vM=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Merlins"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/ECMwfUTSDY1hY-FtkhGGY7uAqOA5J8DOnKJMux76kCvdyneCZA2x4FYIuf_8rzqx6uIk5GDFwpTYdZ3SZttuGR0XuMe7xnX9GG3miI6GQPVYBRgbKCakKwDOI4gyakGz0kM4gaeBLfchXzyM5-rCL2mB8-z0Bzk=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Agent Jack's Bar"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOOP1cliAMlxuRMGMRJ-DH9OJgnj2iJAbll_KIg=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="23 East Lounge"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPafpRcGFa4k2xSeps82RN93u73BbMdT6nyDeT4=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Elephant & Co. Gastropub"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMhrHU-RVgiQ6ZrscleCvda7D-f-ceqDySTRGdO=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="HUB- Lounge Cafe Rooftop"){
        Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMMNdPM_0UAJRNgA9umvHBsyqx1mkd_aJMFNRQ_=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="Hashtag The Lounge"){
        Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/AhhEP_2Xg5z1RjDc2z2B0FQwMyMTfeXyFKbratlDnf80zEUxkpNN6wFOFJ8g63sKoCmJ2jxEvDeHeby7JFkzOR-qPwEmqXzCGnx02r3utPtdDsQS9c4pBL0f_PYG5FRv9Q3Bqh1MZd2HIUxEqUdxf63tYWnpAQ=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
    else if(namee=="F Beach House"){
        Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/S0BVUZTPFqSc7HW8lT63KLSIUk7Eh-NlPI_SQ8jlI4fRk1AZY4IcObQkSYBxfBcYWKgTTWvwvyW5Mr6raZHuthvyS_B1YUjzxBLDhoyVRB6_nMZDWWJ1vzmW45JhLBgz9zUzLhA9o8TPWYaDNpYeqjYpq3e_dg=w408-h270-k-no").error(R.drawable.nightlife).into(img);}

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