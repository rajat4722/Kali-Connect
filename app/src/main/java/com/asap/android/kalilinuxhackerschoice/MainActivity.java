package com.asap.android.kalilinuxhackerschoice;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;

import soup.neumorphism.NeumorphCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView policy;
    ImageView image1,image2,image3,image4;
    ViewFlipper viewFlipper;

    private InterstitialAd mInterstitialAd;

    private ImageButton imageButton;
    private NeumorphCardView neumorphCardView1,neumorphCardView2;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });




        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        viewFlipper = findViewById(R.id.horizon_view);

        policy = findViewById(R.id.policy);


        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pages.flycricket.io/kali-linux-hackers/privacy.html");
            }
        });




        //code for rate us cardview button

        NeumorphCardView rateus = findViewById(R.id.rate_us);
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.asap.android.kalilinuxhackerschoice")));

                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.asap.android.kalilinuxhackerschoice")));

                }
            }
        });
        // ends here rate us code



        //direct email intent into gmailapp
        NeumorphCardView rqst = findViewById(R.id.rqst_topic);
        rqst.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                sendEmail();
            }

            @SuppressLint("IntentReset")
            private void sendEmail() {
                //  String[] TO = {"developerraj0@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

                emailIntent.setData(Uri.parse("mailto:developerraj0@gmail.com"));
                startActivity(Intent.createChooser(emailIntent,"send feedback"));

                //   emailIntent.setData(Uri.parse("mailto:"));
                // emailIntent.setType("text/plain");
                //  emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

                //  emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I have a request for");
                // emailIntent.putExtra(Intent.EXTRA_TEXT,"Hello Sir");

                // try {
                //   startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                //   finish();
                // } finally {

                // }

            }
        });
        //gmail intent ends here

        //image button onclick listner
        imageButton = (ImageButton) findViewById(R.id.kali_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KaliActivity();
            }
        });
        //end



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        setAds();


        //neumorph card view code start
        neumorphCardView1 = (NeumorphCardView) findViewById(R.id.linux_cmd);
        //  neumorphCardView1.setOnClickListener(this);


        neumorphCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);

                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            // Called when fullscreen content is dismissed.
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(MainActivity.this,LinuxActivity.class));

                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            // Called when fullscreen content failed to show.
                            super.onAdFailedToShowFullScreenContent(adError);
                            //  startActivity(new Intent(MainActivity.this,LinuxActivity.class));
                            mInterstitialAd.show(MainActivity.this);
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            // Called when fullscreen content is shown.
                            // Make sure to set your reference to null so you don't
                            // show it a second time.
                            mInterstitialAd = null;

                        }
                    });

                }

                else {
                    startActivity(new Intent(MainActivity.this,LinuxActivity.class));

                }
            }
        });
        //ends


          Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);


        navigationView = (NavigationView) findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.insta){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/night._sight.io/"));
                    startActivity(intent);
                    return true;
                }
                else if (id==R.id.link){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rajat-shukla586942/"));
                    startActivity(intent);
                    return true;
                }

                return true;
            }
        });






        drawerLayout =(DrawerLayout) findViewById(R.id.drawerlayout);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        //navigation bar code end



// recycleview card layout ends


        //displayDialog();

    }

   /* private void displayDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_instruction);

        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();

        View view1 = dialog.findViewById(R.id.view1);
        View view2 = dialog.findViewById(R.id.view2);
        View view3 = dialog.findViewById(R.id.view3);
        View view4 = dialog.findViewById(R.id.view4);
        TextView textView = dialog.findViewById(R.id.text_view);


        textView.setText("This is kali app");

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide view1
                view1.setVisibility(View.INVISIBLE);
                //visible view2
                view2.setVisibility(View.VISIBLE);
                //text for view instruction
                textView.setText("this is show view");
            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide view2
                view2.setVisibility(View.INVISIBLE);
                //visible view3
                view3.setVisibility(View.VISIBLE);
                //text for view instruction
                textView.setText("this is  big view");
            }
        });

        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide view3
                view3.setVisibility(View.INVISIBLE);
                //visible view4
                view4.setVisibility(View.VISIBLE);
                //text for view instruction
                textView.setText("this is happy view");
            }
        });

        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }  */

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    public void KaliActivity(){
        Intent intent = new Intent(this, KaliActivity.class);
        startActivity(intent);
    }

    //cardview of linux command shortcut
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, LinuxActivity.class);
        startActivity(intent);
    }


//ends

    //Toolbar share button Code starts
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this Application ");
        intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.asap.android.kalilinuxhackerschoice");
        startActivity(Intent.createChooser(intent , "Share Via"));
        return super.onOptionsItemSelected(item);
    }
    //Toolbar share button code ends here









    public void setAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        // InterstitialAd.load(this,"ca-app-pub-9156366618801817/8756277638", adRequest, --use this for below
        InterstitialAd.load(this,"\n" + "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        super.onAdFailedToLoad(loadAdError);
                        mInterstitialAd.show(MainActivity.this);

                        //  startActivity(new Intent(MainActivity.this,LinuxActivity.class));
                    }
                });


    }


}