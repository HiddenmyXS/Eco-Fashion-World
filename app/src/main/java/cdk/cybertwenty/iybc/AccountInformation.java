package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AccountInformation extends AppCompatActivity {

    RelativeLayout home_btn;
    ImageView btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_account);

        home_btn = (RelativeLayout) findViewById(R.id.home_bottom_bar);
        btn_return = (ImageView) findViewById(R.id.btn_return_account);


        // onClick //
        home_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }




    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(AccountInformation.this, MainActivity.class);
        startActivity(backIntent);
        finish();
    }
}
