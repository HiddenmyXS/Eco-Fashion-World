package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageActivity extends AppCompatActivity {
    boolean changed = false;
    ImageView check_en, check_id;
    ImageView return_btn;
    RelativeLayout en, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_language_selection);

        // Check //
        check_en = (ImageView) findViewById(R.id.checklist_english);
        check_id = (ImageView) findViewById(R.id.checklist_indonesia);

        // Language Switch //
        id = (RelativeLayout) findViewById(R.id.indonesia);
        en = (RelativeLayout) findViewById(R.id.english);

        // Button Back //
        return_btn = (ImageView) findViewById(R.id.btn_return_help);

        // Assign SharedPreferences //
        SharedPreferences sharedPreferences =  getSharedPreferences("saved", MODE_PRIVATE);

        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changed == false){
                    check_id.setVisibility(View.VISIBLE);
                    check_en.setVisibility(View.INVISIBLE);
                    changed = true;
                }
            }
        });

        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changed == true){
                    check_id.setVisibility(View.INVISIBLE);
                    check_en.setVisibility(View.VISIBLE);
                    changed = false;
                }
            }
        });

        // Sections //

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LanguageActivity.this, SettingsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (LanguageActivity.this, SettingsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
