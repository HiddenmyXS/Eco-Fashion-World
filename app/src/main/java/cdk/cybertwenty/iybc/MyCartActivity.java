package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class MyCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_cart);
    }



    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(MyCartActivity.this, MainActivity.class);
        startActivity(backIntent);
        finish();
    }
}
