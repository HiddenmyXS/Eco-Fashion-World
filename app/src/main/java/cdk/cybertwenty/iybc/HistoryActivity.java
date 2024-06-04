package cdk.cybertwenty.iybc;

import android.accounts.Account;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    ImageView btn_back;
    RelativeLayout home_btn_bar;
    RelativeLayout account_btn_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_history);

        // Functions //

        account_btn_bar = (RelativeLayout) findViewById(R.id.profile_bottom_bar);
        home_btn_bar = (RelativeLayout) findViewById(R.id.home_bottom_bar);
        btn_back = (ImageView) findViewById(R.id.btn_return_history);

        // onClicked //

        home_btn_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HistoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        account_btn_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HistoryActivity.this, AccountInformation.class);
                startActivity(intent);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HistoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(HistoryActivity.this, MainActivity.class);
        startActivity(backIntent);
        finish();
    }
}
