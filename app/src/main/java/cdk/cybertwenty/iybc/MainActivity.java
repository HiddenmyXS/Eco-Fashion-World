package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cdk.cybertwenty.iybc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private String collectData;
    boolean popup_open = false;

    long exitTime = 0;
    RelativeLayout view_myHistory_btn;
    RelativeLayout view_myCart_btn;
    RelativeLayout menu_bottom;
    RelativeLayout profile_bottom_picture;
    RelativeLayout popup_menu_activity;
    RelativeLayout forum, notification, request;
    ImageView photo_profile;
    CardView search_card;
    CardView promo1, promo2, promo3;
    Button btn_product_1, btn_product_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        setContentView(binding.getRoot());

        // Fade //

        Fade fade = new Fade();

        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);


        // Important Data //

        if(savedInstanceState != null){
            collectData = savedInstanceState.getString("importantSave");
        }

        // Functions //

        popup_menu_activity = (RelativeLayout) findViewById(R.id.pop_menu_activities);
        view_myHistory_btn = (RelativeLayout) findViewById(R.id.view_myHistory);
        view_myCart_btn = (RelativeLayout) findViewById(R.id.view_myCart);
        menu_bottom = (RelativeLayout) findViewById(R.id.menu_bottom_bar);
        profile_bottom_picture = (RelativeLayout) findViewById(R.id.profile_bottom_bar);
        photo_profile = (ImageView) findViewById(R.id.photo_main_firebase);
        btn_product_1 = (Button) findViewById(R.id.product_button_1);
        btn_product_2 = (Button) findViewById(R.id.product_button_2);
        search_card = (CardView) findViewById(R.id.search_cardview);
        forum = (RelativeLayout) findViewById(R.id.forum_pop_menu);
        notification = (RelativeLayout) findViewById(R.id.notification_pop_menu);
        request = (RelativeLayout) findViewById(R.id.request_pop_menu);

        // CardView promo //
        promo1 = (CardView) findViewById(R.id.promo_cardview_1);

        // Firebase //

        if (firebaseUser!=null){
            photo_profile.setBackgroundResource(R.drawable.user_profile);
        } else {
            photo_profile.setBackgroundResource(R.drawable.user_profile);
        }

        // Slide Button //

        btn_product_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, Section1.class);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_out_left);
                startActivity(intent);
                finish();
            }
        });



        // startOnClick //
        view_myHistory_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, HistoryActivity.class);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                startActivity(intent);
                finish();
            }
        });

        view_myCart_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, MyCartActivity.class);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                startActivity(intent);
                finish();
            }
        });

        menu_bottom.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (popup_open == false){
                    popup_menu_activity.setVisibility(View.VISIBLE);
                    popup_open = true;
                } else if (popup_open == true){
                    popup_menu_activity.setVisibility(View.INVISIBLE);
                    popup_open = false;
                }
            }
        });

        profile_bottom_picture.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        search_card.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Pop Up Menu Bottom //

        notification.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, NotificationActivity.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);
                finish();
            }
        });



        // Promo CardView //

        binding.promoCardview1.setOnClickListener(view -> {
            Intent intent = new Intent (MainActivity.this, Section1.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, binding.imagePromo1, ViewCompat.getTransitionName(binding.imagePromo1)
            );
            startActivity(intent, optionsCompat.toBundle());
        });

        binding.promoCardview2.setOnClickListener(view -> {
            Intent intent = new Intent (MainActivity.this, Section2.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, binding.imagePromo2, ViewCompat.getTransitionName(binding.imagePromo2)
            );
            startActivity(intent, optionsCompat.toBundle());
        });

        binding.promoCardview3.setOnClickListener(view -> {
            Intent intent = new Intent (MainActivity.this, Section3.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, binding.imagePromo3, ViewCompat.getTransitionName(binding.imagePromo3)
            );
            startActivity(intent, optionsCompat.toBundle());
        });

    }

    public void finish() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state
        outState.putString("importantSave", collectData);
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
