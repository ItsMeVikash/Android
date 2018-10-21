package nightlife.kumar.vikash.nightlife;

import nightlife.kumar.vikash.nightlife.chandigarh.chandigarh;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

import nightlife.kumar.vikash.nightlife.Bangalore.Bangalore;
import nightlife.kumar.vikash.nightlife.R;
import nightlife.kumar.vikash.nightlife.chennai.chennai;
import nightlife.kumar.vikash.nightlife.delhi.delhi;
import nightlife.kumar.vikash.nightlife.goa.goa;
import nightlife.kumar.vikash.nightlife.hyderabad.hyderabad;
import nightlife.kumar.vikash.nightlife.jaipur.jaipur;
import nightlife.kumar.vikash.nightlife.kolkata.kolkata;
import nightlife.kumar.vikash.nightlife.mumbai.mumbai;
import nightlife.kumar.vikash.nightlife.pune.pune;
/**
 * A simple {@link Fragment} subclass.
 */
public class Main_fragment extends Fragment {

    public Main_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.main_fragment, container, false);
        ImageButton button = (ImageButton) rootView.findViewById(R.id.bangalore);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/p/AF1QipN1exoUqaE0fRxGx0Qo3-zK0gcG2msiI1WvNwyo=w408-h273-k-no").into(button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),Bangalore.class);
                startActivity(i);
            }
        });
        ImageButton chandigarh = (ImageButton) rootView.findViewById(R.id.Chandigarh);
        Picasso.with(getContext()).load("https://lh4.googleusercontent.com/proxy/dODtsNYjA7vCzt7QEvyeUDAzG2smCpCXt4v2smPm_PU5-6WsdVpoBdaB_c-htf3nOw0SlbLVCwdS8200mzLpn9aQnasHHbR01fRlJ_OttagtQccjAul5eF1F5Dyw5fcy6J3fIHi6B3_k_Mq8I0QJadqIrqUFBBk=w408-h272-k-no").into(chandigarh);
        chandigarh.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),chandigarh.class);
                startActivity(i);
            }
        });
        ImageButton chennai = (ImageButton) rootView.findViewById(R.id.Chennai);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/p/AF1QipNQqi1dTRpqJpIVSIryQOXLj9ULdgT9bi8dQf2E=w408-h306-k-no").into(chennai);
       chennai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),chennai.class);
                startActivity(i);
            }
        });
        ImageButton delhi = (ImageButton) rootView.findViewById(R.id.Delhi);
        Picasso.with(getContext()).load("https://lh6.googleusercontent.com/proxy/v6n3l-kc51ua1J9ehTLAxKkMGdz5YT4mrULT5XI13V_tQkfvtc8z2mrAo5eh4uVqkqFb_d5p0iKQVr3HI-HHGHI8g6gcll4tp9Z68KPiALHs9_64Xl8IVaLnhBpBm2PRF2TJQxhFyclOaHRIDDhEkVHWs7ie4sA=w408-h233-k-no").into(delhi);
        delhi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),delhi.class);
                startActivity(i);
            }
        });
        ImageButton goa = (ImageButton) rootView.findViewById(R.id.Goa);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/p/AF1QipPNenpfAi9onuZBHu1C9naLI9CxhQMNnsH6lxV0=w408-h229-k-no").into(goa);
        goa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),goa.class);
                startActivity(i);
            }
        });
        ImageButton hyderabad = (ImageButton) rootView.findViewById(R.id.Hyderabad);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/p/AF1QipOX3N_Ilj1rsKwTXpFwyUa5pTIQJN8Zh9aBUfw6=w408-h212-k-no").into(hyderabad);
        hyderabad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),hyderabad.class);
                startActivity(i);
            }
        });
        ImageButton jaipur = (ImageButton) rootView.findViewById(R.id.Jaipur);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/p/AF1QipNuU3GjJHr4aV4q5gEpHYqwmA-iVOIHM-5vqHBR=w408-h306-k-no").into(jaipur);
        jaipur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),jaipur.class);
                startActivity(i);
            }
        });
        ImageButton kolkata = (ImageButton) rootView.findViewById(R.id.Kolkata);
        Picasso.with(getContext()).load("https://lh4.googleusercontent.com/proxy/2r2lVF5YSKZLZJmRn57My6JjKb_KWsXm8T5HmwXtcnDYxjk6-Jsia1MVlT4fNykW9RZdrJrnQgDseygn358zZIFvKSE900pP5ENlM9upc2wB9FI21Im0L-sWP7ph6rRV0PRGCexBlqBb8ikN2SkaHVl8BuNu9A=w408-h233-k-no").into(kolkata);
        kolkata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),kolkata.class);
                startActivity(i);
            }
        });
        ImageButton mumbai = (ImageButton) rootView.findViewById(R.id.Mumbai);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/p/AF1QipOeprcqqTbWmAYC0EXmJpt9DBrRhAe58o-SCMkh=w408-h272-k-no").into(mumbai);
        mumbai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),mumbai.class);
                startActivity(i);
            }
        });
        ImageButton pune = (ImageButton) rootView.findViewById(R.id.Pune);
        Picasso.with(getContext()).load("https://lh5.googleusercontent.com/proxy/6D_NE21nhBYLXoRf7o4wZ9Yhjeg9fdjagltaL0l8FchlxVjxEpubroIpnqf2Vcdr00Xy8YugbLlcCaovARcdZXue03H0grOqoJyyaCnNBzoKHC2BSdGeEg-7X3-EJ2sYLkHHfOnkAvQqbQKcoKhAD80sYg2Z7vM=w408-h233-k-no").into(pune);
        pune.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(),pune.class);
                startActivity(i);
            }
        });

        return rootView;
    }


}

