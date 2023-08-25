package com.asap.android.kalilinuxhackerschoice;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class KaliActivity extends AppCompatActivity {


    Context c;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kali);

        TypedValue tv = new TypedValue();
        if(getTheme().resolveAttribute(android.R.attr.actionBarSize,tv,true))
        {
            int actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources()
                    .getDisplayMetrics());
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statcolor));
        //   window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);


        //  this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Linux Tools");
      //  actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_previous);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#131313")));



        recyclerView = findViewById(R.id.recycleview);

        String arrname[] = {"Installation and Configuration","Armitage","BeEF-Linux Exploit Suggester","Metasploit","Cisco Tools","CMS Scanning Tools","Database Tools Usage"
                ,"Fern Wifi Cracker","Forensics Tools","GISKismet","Kismet","Maintaining Access",
                "NMAP and ZenMAP","Password Cracking Tools","Reporting Tools","Reverse Engineering","Searchsploit",
                "Sniffing & Spoofing","Social Engineering","SSL Scanning Tools","Stressing Tools","Stressing Tools-2",
                "Vega Usage","ZapProxy"};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(this, arrname));





    }


}