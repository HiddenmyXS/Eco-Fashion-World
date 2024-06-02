package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String collectData;

    RelativeLayout view_myHistory_btn;
    RelativeLayout view_myCart_btn;
    RelativeLayout profile_bottom_picture;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_main);

        // Important Data //

        if(savedInstanceState != null){
            collectData = savedInstanceState.getString("importantSave");
        }



        // Functions //

        view_myHistory_btn = (RelativeLayout) findViewById(R.id.view_myHistory);
        view_myCart_btn = (RelativeLayout) findViewById(R.id.view_myCart);
        profile_bottom_picture = (RelativeLayout) findViewById(R.id.profile_bottom_bar);




        // startOnClick //
        view_myHistory_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, HistoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

        view_myCart_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, MyCartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        profile_bottom_picture.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, AccountInformation.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state
        outState.putString("importantSave", collectData);
    }
}
