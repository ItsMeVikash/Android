package nightlife.kumar.vikash.nightlife;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class web_browser extends AppCompatActivity {
    private WebView webView;
    private ProgressDialog progDailog;
    String url,urll;
    private EditText editText;
    private static final String LINK_ADDRESS = "LINK_ADDRESS";
    private static final String DEFAULT_ADDRESS = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //getting url
        Bundle bundle = getIntent().getExtras();
        url=bundle.getString("message");
        if(url.equalsIgnoreCase("Unavailable"))
        {
            url="google.com";
        }
        String title=bundle.getString("message");
        //Toolbar as actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        progDailog = ProgressDialog.show(this, "Loading", "Please wait...", true);
        progDailog.setCancelable(true);
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient()
             {
                 public void onPageFinished(WebView view, String url)
                    {
                            progDailog.dismiss();
                    }
             });
        editText = (EditText) findViewById(R.id.edit);
        editText.setText(url);
        Button change = (Button) findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final SharedPreferences.Editor editor = settings.edit();
                editor.putString(LINK_ADDRESS, editText.getText().toString());
                editor.apply();
                reloadWebView();
            }
        });
        reloadWebView();
    }
    private void reloadWebView() {
        progDailog.show();
        webView.loadUrl("http://www." + editText.getText().toString());

    }

}