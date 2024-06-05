package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountInformation extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
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

        // Functions //
        home_btn = (RelativeLayout) findViewById(R.id.home_bottom_bar);
        btn_return = (ImageView) findViewById(R.id.btn_return_account);

        // Firebase Current //
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Firebase //
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser userName = mAuth.getCurrentUser();


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
