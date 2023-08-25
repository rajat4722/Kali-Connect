package com.asap.android.kalilinuxhackerschoice;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.asap.android.kalilinuxhackerschoice.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Kaliitems_Activity extends AppCompatActivity {

    TextView txt;
    PDFView pdfView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaliitems);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
                //Toast.makeText(Kaliitems_Activity.this, "ads loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.

            }
        });

        // Window window = getWindow();
        Window window = getWindow();
        //window.getStatusBarColor();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statcolor));
        // window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Topics");
        actionBar.setHomeAsUpIndicator(R.drawable.ic_previous);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#131313")));





        pdfView = findViewById(R.id.pdfView);

        //txt = findViewById(R.id.showofff);

        String getItem = getIntent().getStringExtra("title");

        if(getItem.equals("Installation and Configuration")) {
            pdfView.fromAsset("Installation.pdf").load();

        }
        if(getItem.equals("Armitage")) {
            pdfView.fromAsset("Armitage.pdf").load();

        }
        if(getItem.equals("BeEF-Linux Exploit Suggester")) {
            pdfView.fromAsset("BeEF-Linux Exploit Suggester.pdf").load();

        }
        if(getItem.equals("Metasploit")) {
            pdfView.fromAsset("Metasploit.pdf").load();

        }
        if(getItem.equals("Cisco Tools")) {
            pdfView.fromAsset("Cisco Tools.pdf").load();

        }
        if(getItem.equals("CMS Scanning Tools")) {
            pdfView.fromAsset("CMS Scanning Tools.pdf").load();

        }
        if(getItem.equals("Database Tools Usage")) {
            pdfView.fromAsset("Database Tools Usage.pdf").load();

        }
        if(getItem.equals("Fern Wifi Cracker")) {
            pdfView.fromAsset("Fern Wifi Cracker.pdf").load();

        }
        if(getItem.equals("Forensics Tools")) {
            pdfView.fromAsset("Forensics Tools.pdf").load();

        }
        if(getItem.equals("GISKismet")) {
            pdfView.fromAsset("GISKismet.pdf").load();

        }
        if(getItem.equals("Kismet")) {
            pdfView.fromAsset("Kismet.pdf").load();

        }
        if(getItem.equals("Maintaining Access")) {
            pdfView.fromAsset("Maintaining Access.pdf").load();

        }
        if(getItem.equals("NMAP and ZenMAP")) {
            pdfView.fromAsset("NMAP and ZenMAP.pdf").load();

        }
        if(getItem.equals("Password Cracking Tools")) {
            pdfView.fromAsset("Password Cracking Tools.pdf").load();

        }
        if(getItem.equals("Reporting Tools")) {
            pdfView.fromAsset("Reporting Tools.pdf").load();

        }
        if(getItem.equals("Reverse Engineering")) {
            pdfView.fromAsset("Reverse Engineering.pdf").load();

        }
        if(getItem.equals("Searchsploit")) {
            pdfView.fromAsset("Search.pdf").load();

        }
        if(getItem.equals("Sniffing & Spoofing")) {
            pdfView.fromAsset("Sniffing & Spoofing.pdf").load();

        }
        if(getItem.equals("Social Engineering")) {
            pdfView.fromAsset("Social Engineering.pdf").load();

        }
        if(getItem.equals("SSL Scanning Tools")) {
            pdfView.fromAsset("SSL Scanning Tools.pdf").load();

        }
        if(getItem.equals("Stressing Tools")) {
            pdfView.fromAsset("Stressing Tools.pdf").load();

        }
        if(getItem.equals("Stressing Tools-2")) {
            pdfView.fromAsset("Stressing Tools-2.pdf").load();

        }
        if(getItem.equals("Vega Usage")) {
            pdfView.fromAsset("Vega Usage.pdf").load();

        }
        if(getItem.equals("ZapProxy")) {
            pdfView.fromAsset("ZapProxy.pdf").load();

        }



    }

}