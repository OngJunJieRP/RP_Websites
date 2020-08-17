package sg.edu.rp.c346.id19032110.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class rp_website extends AppCompatActivity {

    WebView wvRP;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rp_website);

        wvRP = findViewById(R.id.webViewRP);

        wvRP.setWebViewClient(new WebViewClient());
        WebSettings websettings = wvRP.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setAllowFileAccess(false);
        websettings.setBuiltInZoomControls(true);

        Intent intentReceived = getIntent();
        String rp_url = intentReceived.getStringExtra("url");
        wvRP.loadUrl(rp_url);
    }

}
