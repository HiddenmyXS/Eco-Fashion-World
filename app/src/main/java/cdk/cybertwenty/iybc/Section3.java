package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import cdk.cybertwenty.iybc.databinding.ActivityMainBinding;

public class Section3 extends AppCompatActivity {

    ImageView btn_back, display;
    RelativeLayout view_cart, account, search;
    RatingBar rating;
    CardView preview_1, preview_2, preview_3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.section_3);

        // Fade //

        Fade fade = new Fade();

        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        // Functions //

        btn_back = (ImageView) findViewById(R.id.btn_section_back);
        view_cart = (RelativeLayout) findViewById(R.id.view_myCart);
        account = (RelativeLayout) findViewById(R.id.view_my_Account);
        rating = (RatingBar) findViewById(R.id.ratingBar);

        // CardView //

        display = (ImageView) findViewById(R.id.display);
        preview_1 = (CardView) findViewById(R.id.image_preview_3);
        preview_2 = (CardView) findViewById(R.id.image_preview_2);
        preview_3 = (CardView) findViewById(R.id.image_preview_1);

        // CardView Preview Btn //

        preview_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setImageResource(R.drawable.bag_wallpaper);
            }
        });

        preview_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setImageResource(R.drawable.bag_wallpaper_2);
            }
        });

        preview_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setImageResource(R.drawable.bag_wallpaper_3);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Section3.this, LoginActivity.class);
                startActivity(backIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        view_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Section3.this, MyCartActivity.class);
                startActivity(backIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Section3.this, MainActivity.class);
                startActivity(backIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public void onBackPressed(){
        Intent backIntent = new Intent(Section3.this, MainActivity.class);
        startActivity(backIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
