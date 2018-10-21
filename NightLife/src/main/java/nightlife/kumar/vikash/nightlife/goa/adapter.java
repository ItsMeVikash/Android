package nightlife.kumar.vikash.nightlife.goa;

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
        if(parentName=="Club Cubana"){
            address.setText("Calangute - Arpora Road, Arpora, Goa 403507");
            web.setText("clubcubanagoa.com");phone.setText("91582 57000");
            time.setText("All_Days\t\n" +
                    "9:30PM–3:30AM");}
        else if(parentName=="Leopard Valley"){
            address.setText("Palolem-Agonda Road, Canacona, Goa 403702");
            web.setText("Unavailable");phone.setText("077986 80978");
            time.setText("All_Days\t\n" +
                    "9PM–4AM");}
        else if(parentName=="Cafe Mambos"){
            address.setText("Titos Lane, Baga Beach, Goa, 403516");
            web.setText("titosgoa.com");phone.setText("083800 65002");
            time.setText("All_Days\t\n" +
                    "6PM–4AM");}
        else if(parentName=="Kamaki"){
            address.setText("Titos Lane, Saunta Vaddo, Baga, Goa 403516");
            web.setText("Unavailable");phone.setText("098229 87725");
            time.setText("All_Days\t\n" +
                    "6PM–4AM");}
        else if(parentName=="LPK Waterfront"){
            address.setText("Road Opposite Bank of India, Bhatiwado, Nerul, Goa 403114");
            web.setText("lpkwaterfront.in");phone.setText("093267 33295");
            time.setText("All_Days\t\n" +
                    "9:30PM–3:30AM");}
        else if(parentName=="Cape Town Cafe"){
            address.setText("Tito's Lane, Baga Calangute Rd, Saunta Vaddo, Bardez, Goa 403516");
            web.setText("capetowncafe.com");phone.setText("099233 25638");
            time.setText("All_Days\t\n" +
                    "6PM–4AM");}
        else if(parentName=="Nyex Beach Club"){
            address.setText("Anjuna Cliff (Old Paradiso) , Bardez , Goa, India 403509, Dmello Vaddo, Anjuna, Goa 403202");
            web.setText("facebook.com");phone.setText("098200 71009");
            time.setText("Monday\t"+"Closed\n"+"Other Days\t"+" 24hours");}
        else if(parentName=="Red Square"){
            address.setText("Titos Lane 2, Baga, Goa 403518");
            web.setText("titos.in");phone.setText("098227 65002");
            time.setText("Unknown");}
        else if(parentName=="Tito's Pub"){
            address.setText("Baga Blues Beach, Titos Lane, Calangute, Goa 403516");
            web.setText("titosgoa.com");phone.setText("098227 65002");
            time.setText("All_Days\t\n" +
                    "9PM–3AM");}
        else if(parentName=="Shiva Valley"){
            address.setText("Anjuna Beach, Monteiro Vaddo, Monteiro Vaddo, Anjuna, Goa 403509");
            web.setText("Unavailable");phone.setText("095661 78132");
            time.setText("Tuesday\n" +
                    "9PM–4AM\n"+"Other Days\n"+"Closed");}
        else if(parentName=="Sinq Night Club"){
            address.setText("Opposite Taj Holiday Village, Aguada Rd, Candolim, Goa 403515");
            web.setText("sinq.co.in");phone.setText("083080 00080");
            time.setText("All_Days\t\n" +
                    "9PM–3AM");}
        else if(parentName=="Club Titos- The Original- Where Else!"){
            address.setText("Titos Lane, Baga Calangute, Bardez, Goa 403516");
            web.setText("titosgoa.com");phone.setText("083800 65002");
            time.setText("All_Days\n"+"8AM–3AM");}
        else if(parentName=="Mr. Toff Toff's Pub"){
            address.setText("Calangute - Baga Rd, Behind Our Lady Of Piety Chapel, Bardaz, Calangute, Goa 403516");
            web.setText("Unavailable");phone.setText("098232 09555");
            time.setText("All_Days\t\n" +
                    "9AM–1AM");}
        else if(parentName=="Curlies Beach Shack Anjuna"){
            address.setText("Near Flea Market, Monteiro Vaddo, Monteiro Vaddo, Anjuna, Goa 403509");
            web.setText("curliesgoa.com");phone.setText("095524 71720");
            time.setText("All_Days\t\n" +
                    "8:30AM–3AM");}
        else if(parentName=="COCKTAILS AND DREAMS"){
            address.setText("TITOS LANE,BAGA, Calangute, Goa 403516");
            web.setText("cocktailsanddreams.co.in");phone.setText("097642 69027");
            time.setText("All_Days\t\n" +
                    "7PM–3:30AM");}
        else if(parentName=="The World Famous Decades Bar"){
            address.setText("Agar Vaddo, Calangute, Goa 403516");
            web.setText("jacbrad2000.wix.com");phone.setText("0832 227 5128");
            time.setText("All_Days\t\n" +
                    "9AM–1PM\n" +
                    "5PM–1AM");}
        else if(parentName=="Cohiba Bar & Kitchen"){
            address.setText("Aguada - Siolim Rd, Sinqurim, Aguada Fort Area, Candolim, Goa 403515");
            web.setText("Unavailable");phone.setText("077220 31222");
            time.setText("All_Days\t\n" +
                    "4PM–2AM");}
        else if(parentName=="Cafe Lilliput"){
            address.setText("Anjuna Beach, Monteiro Vaddo, Monteiro Vaddo, Anjuna, Goa 403509");
            web.setText("cafelilliput.com");phone.setText("098221 37767");
            time.setText("All_Days\t\n" +
                    "8AM–5AM");}
        else if(parentName=="UV Bar"){
            address.setText("Near Anjuna Market, North Anjuna Beach, Dmello Vaddo, Near St Anthony Chapel, Monteiro Vaddo, Anjuna, Goa 403509");
            web.setText("Unavailable");phone.setText("091120 12018");
            time.setText("All_Days\t\n" +
                    "10AM–11:30PM");}
        else if(parentName=="Ivy"){
            address.setText("Baga Lane, House No. 7/11B, Shop No.9, Sauntawaddo, Calangute, Goa 403515");
            web.setText("map5hotels.com");phone.setText("083800 35815");
            time.setText("All_Days\t\n" +
                    "9PM–3AM");}
        else if(parentName=="9 Bar Club"){
            address.setText("Small Vagator, Vagator, Goa, Goa, 403509");
            web.setText("Unavailable");phone.setText("096231 02102");
            time.setText("Open 24 hours");}
        else if(parentName=="Praia de Luz"){
            address.setText("Park Hyatt Goa Resort and Spa, Arossim Beach, Arossim, Goa 403712");
            web.setText("goa.park.hyatt.com");phone.setText("0832 272 1234");
            time.setText("All_Days\t\n" +
                    "3PM–12AM");}
        else if(parentName=="Montego Bay Beach Village"){
            address.setText("Vithaldas Waddo, Morjim, Pernem, Goa 403512");
            web.setText("montegobaygoa.com");phone.setText("098221 50847");
            time.setText("24*7");}
        else if(parentName=="Café Mojo Pub & Bistro"){
            address.setText("A/6, Skylark Apartments, M. B. Road, Ozari, Panaji, Goa 403001");
            web.setText("cafemojo.in");phone.setText("077740 54353");
            time.setText("All_Days\t\n" +
                    "11AM–5AM");}
        else if(parentName=="Hard Rock Hotel Goa"){
            address.setText("370/14, Near KFC, Porba Vaddo, Calangute, Bardez, Goa 403516");
            web.setText("hardrockhotels.com");phone.setText("0832 674 5555");
            time.setText("24*7");}
        else if(parentName=="Club Lounge"){
            address.setText("2nd Floor,South Wing ,Near Bambolim Beach,Goa, Aldeia de Goa, Bambolim, Goa 403201");
            web.setText("pune.regency.hyatt.com");phone.setText("0832 301 1234");
            time.setText("All_Days\t\n" +
                    "12AM–11:30PM");}
        else if(parentName=="Club Fresh"){
            address.setText("Morjim, Goa 403512");
            web.setText("facebook.com");phone.setText("097647 05421");
            time.setText("\t\n" +
                    "Open 24 hours");}
        else if(parentName=="Kandy Club"){
            address.setText("Next to Royal Goan Beach Club, Marinha Dourada Rd, Baga, Goa 403509");
            web.setText("Unavailable");phone.setText("098850 88318");
            time.setText("Saturday & Sunday\t"+"Closed\n"+"Other days\t"+"\n" +
                    "7PM–4AM");}
        else if(parentName=="Capiz Bar"){
            address.setText("Floor Level, North Wing, Grand Hyatt Goa, P.O. Goa University,, Aldeia de Goa, Bambolim, Goa 403201");
            web.setText("goa.grand.hyatt.com");phone.setText("0832 301 1234");
            time.setText("All_Days\t\n" +
                    "4PM–1AM");}
        else if(parentName=="Bora Bora Life"){
            address.setText("Morjim Beach, Vithaldas Vaddo, Morjim, Goa 403512");
            web.setText("Unavailable");phone.setText("096572 10443");
            time.setText("All_Days\n"+"Open 24 hours");}
        else if(parentName=="Cavala"){
            address.setText("614, Calangute - Baga Rd, Baga, Goa 403509");
            web.setText("cavala.com");phone.setText("0832 227 6090");
            time.setText("All_Days\t\n" +
                    "11AM–2AM");}
        else if(parentName=="Guru Bar"){
            address.setText("H.no 721, St Anthony Prais, Waddo, Anjuna, Dmello Vaddo, Bardez, Goa 403509");
            web.setText("gurubargoa.business.site");phone.setText("098233 83257");
            time.setText("All_Days\t\n" +
                    "7AM–12AM");}
        else if(parentName=="Down The Road River Front"){
            address.setText("H. No 99, Old Patto Bridge Rua de Ourém, Altinho, Panaji, Goa 403001");
            web.setText("Unavailable");phone.setText("098231 73757");
            time.setText("All_Days\t\n" +
                    "11:30AM–3AM");}
        else if(parentName=="Bubble Brunch Club"){
            address.setText("Chapora Market Rd, Vagator, Dmello Vaddo, Anjuna, Goa 403509");
            web.setText("Unavailable");phone.setText("093720 27752");
            time.setText("All_Days\n"+"11AM–12AM");}
        else if(parentName=="The Leela Goa"){
            address.setText("Mobor, Cavelossim, Salcette, Goa 403731");
            web.setText("theleela.com");phone.setText("0832 662 1234");
            time.setText("24*7");}
        else if(parentName=="Keys Select Ronil Resort"){
            address.setText("Baga, Calangute, Bardez, Near Tito's Night Club, Goa, 403516");
            web.setText("keyshotels.com");phone.setText("0832 227 5033");
            time.setText("24*7");}
        else if(parentName=="Firefly Goan Bistro Bar"){
            address.setText("Vasvaddo Beach Road, Benaulim, Goa 403716");
            web.setText("facebook.com");phone.setText("098221 23535");
            time.setText("Thursday\t" +
                    "11:30AM–11:30PM\n" +
                    "Friday\t" +
                    "11:30AM–11:30PM\n" +
                    "Saturday\t" +
                    "11:30AM–11:30PM\n" +
                    "Sunday\t" +
                    "11:30AM–11:30PM\n" +
                    "Monday\t" +
                    "Closed\n" +
                    "Tuesday\t" +
                    "6:30–11:30PM\n" +
                    "Wednesday\t" +
                    "11:30AM–11:30PM");}
        else if(parentName=="St. Anthony's"){
            address.setText("Baga Beach, Calangute-Baga Rd, Calangute, Goa 403516");
            web.setText("Unavailable");phone.setText("0832 645 2396");
            time.setText("All_Days\t\n" +
                    "10:30AM–4AM");}
        else if(parentName=="Taste of India Goa"){
            address.setText("Calangute, Near St. Anthony's Chapel,, Gauravaddo, Goa, 403516");
            web.setText("Unavailable");phone.setText("089752 02344");
            time.setText("All_Days\n"+"11AM–11:30PM");}
        else if(parentName=="Flying Dolphin"){
            address.setText("Holiday St, Calangute, Goa 403516");
            web.setText("Unavailable");phone.setText("098221 32850");
            time.setText("All_Days\n"+"8AM–11:59PM");}
        else if(parentName=="Roof Top Lounge"){
            address.setText("La Ben Resort, Colva Beach Road, Colva, Goa 403708");
            web.setText("laben.net");phone.setText("083790 43188");
            time.setText("All_Days\t\n" +
                    "3PM–1AM");}
        else if(parentName=="The Mango Tree"){
            address.setText("Vagator Beach Rd, Gumal Vaddo, Coutinho Vaddo, Vagator, Goa 403509");
            web.setText("Unavailable");phone.setText("0832 227 4703");
            time.setText("All_Days\t\n" +
                    "9AM–4AM");}
        else if(parentName=="Lounge Terminal"){
            address.setText("Level-6, 5th floor, Caculo Mall, Opp Fire services H. Q, Santa Inez, Panaji, Goa 403001");
            web.setText("Unavailable");phone.setText("070660 40138");
            time.setText("All_Days\n"+"12–3PM\n" +
                    "7:30PM–12AM");}
        else if(parentName=="Flor Do Mar"){
            address.setText("Morgim beach Road, Bagwada, Tembavaddo, Morjim, Goa 403512");
            web.setText("flordomar.in");phone.setText("099303 00131");
            time.setText("All_Days\t\n" +
                    "5PM–12AM");}
        else if(parentName=="Cafe Cotinga"){
            address.setText("1286, Kumar Vaddo, Opposite St. Michael's Church, Bouta Waddo, Anjuna, Goa 403509");
            web.setText("cafecotinga.com");phone.setText("0832 651 9999");
            time.setText("All_Days\n"+"Open 24 hours");}
        else if(parentName=="Goa Woodlands Hotel"){
            address.setText("Opp City Bus Stand, Rua Miguel de Loyola Furtado, Margao, Goa 403601");
            web.setText("goawoodlandshotel.com");phone.setText("083800 86724");
            time.setText("24*7");}
        else if(parentName=="Heritage Village Club, Goa"){
            address.setText("Arossim Beach Road, Cansaulim, Arossim, Goa 403712");
            web.setText("selecthotels.co.in");phone.setText("0832 669 4444");
            time.setText("24*7");}
        else if(parentName=="Butter Lounge"){
            address.setText("Shop No. 6, patto, Gera Imperium 2, Patto Centre, Patto Centre, Panaji, Goa 403001");
            web.setText("Unavailable");phone.setText("083088 38888");
            time.setText("All_Days\n"+"5PM–4AM");}
        else if(parentName=="Soul Souffle Goa Cocktail Bar And Restaurant"){
            address.setText("Udear Spring, Ambulor lake, Off The Old Verna Highway, Verna, Goa 403722");
            web.setText("soulsouffle.com");phone.setText("097646 94321");
            time.setText("Unknown");}


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
        });//google button
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
        if(namee=="Club Cubana"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMJZmgmUzmoiLrcUWuRi0rfFkwA5hkcqROVjqgS=w408-h331-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Leopard Valley"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/GgaJo8Gx_dbN81UBd-PvHxWLWXE_Hdq1HodBWgL9KOLZkA5BEQpQlJ2dgmKspjjl3oiy0SIkfpZ0wwN4-yjky0RftnjR_geQt38-1ZP_L9OE_S-ZiHqXbrNE7aNX_ZuJrEVQLobZjNAsyYyiMeq8cCPaBUfXxg=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cafe Mambos"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/DPMSezdzSWfQ4eYI4AcJ2gN5pAC7O4HKKjyZ8ILtkg3f_6rJzzc6eQ_nhyv-saIyvJDglFPO9kjAhR0Gh6WjyZ7HZwZ92oErPxNH6JwmsJyMkR1xF2P2dOWdiOFbKADxxHEbqM41IXNUiIKsQQVriuVui4cPPg=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Kamaki"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/zj-wskUEW7Z9va11_DBI_4WeF5t2koK-fHgfBRFKLBYWwbsmNWISwXgObIyPEn7o4tfzTLzWM5xpOAaAXgBya9_4HQPzCPHycvsITwfb8UdUQvs8X23tUebrIxrkdHw7CybJNZbJLCsC9TmhA2x3yojiuD_6wl4=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="LPK Waterfront"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOdqRYGwSNLxHrXHjd7XYAcWIYP26qh5NCfT27H=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cape Town Cafe"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/L_uoE88RjXGG6MsKiRPaVkt7TwBxpjBVjd5ZuYfQbf3N7ykfYZXwLsU-1_LnSFGMiOeX3kGLmQXotE7ZUEoBiw9aNJjgAJIwYAErS8URqmI_07qinnyA_HiJULf_t2seKLVDWtP_ibbsqwQZnuetESz4ZmZOXlo=w408-h226-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Nyex Beach Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOwskzux787mGaS8whJS3sWOTrEoZDhg-g6TPBP=w408-h266-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Red Square"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/0eLPAslTORyoZCZcQIM1Dxrb7q0ieJHghw2bjUIJW_A9yINnFbcWVUgXUwaR8l9B2BRIv1AHNPBeFY9NndH7et-j10jqHcDpCriJJallnXzRIyLpg0K7J-MKh2TkOeXQXXLL23xotHhlOil4AU2A7a-M8X6ReQ=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Tito's Pub"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN76ASifbfvDq2Wc86lQ6UKaGEWLYKfb5MuYqbj=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Shiva Valley"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/2RpVKlQdihlKYVClLMUAm_HHHRoCZVmKzwBiBsL3k-gchT1P44z93QJty1lZySDPOL4Xr718swoIdy-hs4clVm9c03rwQOvVqLxiYn9DQg_XOwpwPDTCFYA-IE0ab9sOZPzAEKMSCDu0kwMYMt49ofWtY5of4l4=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Sinq Night Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMqhHkrd4QNWWy59wyJBGExnlo0nwMymIlGXP3f=w469-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club Titos- The Original- Where Else!"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNvT7BkC50xx82DCqKmffs8wpVsfwRPZm6V7F7l=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Mr. Toff Toff's Pub"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNqlg6qsvLy-TBNHVU9qfn2oQyb-QfILJnb7HdZ=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Curlies Beach Shack Anjuna"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOpzRdhcpTm8LhAD2dIQIQcWgxGFldpfymkYHPc=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="COCKTAILS AND DREAMS"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPFheF2sXuQkg7rBq4eaB6USAMcuaaPwH5JA7Ho=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The World Famous Decades Bar"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/HmhE3z8wk2NoweZg52kc_z4VQ94p3mDrbXmbc4-CaWV1ecQVsQM3mewQyP4HcMdo6LSfoMZqJgqniBCgXG_xaKn5PZlTihr8h8ldoatagp-KaWWhgfQtMcX066A4dUubEkTM7Su2_kQyvhU5gunYICd8_vwvVOA=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cohiba Bar & Kitchen"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/oVSPYxZnRpK1YAhoxJVarygqizenlCZI132prQ9Tl9tXFSppV-eruM0JANMvyL1iTXcEHBHbL0mSxHnNSh0yZfzr8-j_u7yVlXwpM-KV-NGn37whDTaqUvKD-Mw5bz40E1nusFmIh90DeLGlVTFtmv15KzSe1c4=w408-h233-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cafe Lilliput"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMJ_iyvMCvDnOUk22xPx8ZYmoHCGhQxOrqlP6C5=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="UV Bar"){
            Picasso.with(c).load("https://lh4.googleusercontent.com/proxy/D0SRjSo24sFPbe1-OnTLvWe6h2YRHFtBKHBvoqwNfBgmBCF9DgTguEJwgy-eeuzj2gKMtzQB1L6Wi1-g3UhOtnjFkfr_x7O0XuOwwR3b2VQ8WvTEGvsOrNBePSCM_9FN8hDHXUyUziX7sY_j_QHXlrYcNzZEn6g=w408-h305-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Ivy"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMT5MyhJ_XubswTqkIXm5IjCDXz0yPAV25CPYJt=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="9 Bar Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPZ-f7k-0jXH8tzkKL_wsPe9op3DpfjJrFobAre=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Praia de Luz"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMSiGILEX0qV_4pdUbiAyZl1dTaXQLOY7g4w89y=w408-h407-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Montego Bay Beach Village"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO3JUkDe3J1TNJdnRqhL_WoCVh2uBj3uW6P7zFj=w578-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Café Mojo Pub & Bistro"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOLwxZg2LlvOg64HOdC7hPpHO6wlVlafTgC1N_s=w526-h200-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Hard Rock Hotel Goa"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/UZADUP-BceHHNT9s_VEeJPtJKyqbswlASddZefFte4GGDuJXoTJArMrpy0OMWZ6DUt8Jh_yK8wYjQkjfqRyI2rdb3zEpbTPsFtfJ5vT-fDPWhuMDMZl1VUIXGlYYT7e7ihRiVm-nt_ApZUxWz6lROB2evyXo2g=w408-h223-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMWQcgMr1qdE4DrjAP080KvQ5n9V-f1h6VORWnE=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Club Fresh"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/proxy/FZxw1rksiSGek7Ve6szEFj674DQNoXD5mZw9JElepklDwTBNnE0MZHWRyq5UwA3_-43i8Z7FYJM7QzdWSI-29ssfCQMyDdF2A7UhP4R1yW9jqdweIjjcAnJgMepQHugG9Gl55OXBCqxq-sYyC0QDvbAe7UzQSQ=w408-h228-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Kandy Club"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMnoo8lSPAjMMuhfIXce0lmjEzJ97THtExD_s67=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Capiz Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM5u_n2Jyu9C0FAdvDE7cbUH8DwFF5hqxEsDDRb=w408-h272-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bora Bora Life"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipN_dCVHAQjH4Qd5ONO4tnE_1jhsjeDAwdMk26HR=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cavala"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNbpVnQLDlRLA5icvoO7E2gnI__bW1JyPDy8Tmg=w408-h301-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Guru Bar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPuNpxoOlCjAMweItShftLLJs91cw8syiO5tui3=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Down The Road River Front"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipO29qdPUEzOKfy-DjjyKV6F7Bn4huK7OSOQeA7M=w408-h408-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Bubble Brunch Club"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/KuNArzFO2vq-02AUJTmcmIbaoq7CNMXaWUnA0Z2EaIAM_NBwiBsCiAQ8ezolKVqGNCT0ycr3YE2R8T18dAlF7OFM5Ig9dcfafDvnfKIKeLdjJ-M1E2I7UcaTN8jJHWMnK8yd7mdmpGBaetITC1Cw5cmRag=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Leela Goa"){
            Picasso.with(c).load("https://lh3.googleusercontent.com/proxy/pZUDcIfT2Y9IsTdjygDAufQ62TK2FEpXdujjZ-7zjuIYySMfZL5TwJDynfQ1dam8uyBOAaHF9Gab0Be_xiVylLmonSrWcG9sQNmkXWaqVsYvigH_FB2SNh7WpEeEM2jUn04qYFnbKZh-6IG3YSPjUhFjRXZfAQ=w408-h223-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Keys Select Ronil Resort"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMbYcGDmOMIwj-1MxYHFjX_5SNuhvhkRXeY6_5O=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Firefly Goan Bistro Bar"){
            Picasso.with(c).load("https://lh6.googleusercontent.com/proxy/bl4w0x0N3T8yv378Q0sGwOq8kV_KzsKmwPiqItC_haAAeWAB-LALmU56eiVGpWfASG2sMgrvssVD81rk1eU_KCb8R4ZhwPuz0Y6gb_3CDMISTrDwWnC-1cgIhBDhUELWI7bDWQN291XSY6I3Ps--hqQX2l4bSHE=w408-h304-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="St. Anthony's"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOV2WMGNs465GvOSkdDowLa42F-ek_1Z1tvbQBk=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Taste of India Goa"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMxjk8Qy1xIWDZ1jZB1UA3GtOFuvKuaxXHnb7Sq=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Flying Dolphin"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOlc4O3RSpnRp0h_2asBenvEqvJknq9GIagAIG0=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Roof Top Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPksVOl4k38LqU5FCQkxhcGVnGwp7Zro8dfHvcm=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="The Mango Tree"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMTpVm_NCPZsyHUYpdCjwqAAK6bP6i-VUKad7AI=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Lounge Terminal"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMJz2jTB36CziMCSNWzJdbLGi0QPgl6gSyxTfbS=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Flor Do Mar"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipPNenpfAi9onuZBHu1C9naLI9CxhQMNnsH6lxV0=w408-h229-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Cafe Cotinga"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipOrt-Ix1jX6Dgjca6ozIGdzbhHJeYFVB6_J6ofI=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Goa Woodlands Hotel"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipMi0hYLLE3-Ova8_AeaskQmVYcAa2nqnheGM6mm=w408-h271-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Heritage Village Club, Goa"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM56Fc9in6uGKlIWE1F8PR89rNXL6Gs7WPHW2_p=w408-h306-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Butter Lounge"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipM2JJwhneoXXSbxtagJNcqAANMxGHHExMDJRx0m=w408-h270-k-no").error(R.drawable.nightlife).into(img);}
        else if(namee=="Soul Souffle Goa Cocktail Bar And Restaurant"){
            Picasso.with(c).load("https://lh5.googleusercontent.com/p/AF1QipNHuVbssS4WefqH1JD5th1ulT-_nJtIXVAEf_9F=w408-h272-k-no").error(R.drawable.nightlife).into(img);}

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