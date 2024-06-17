package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class AccountInformation extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    RelativeLayout home_btn;
    CardView btn_log_out;
    ImageView btn_return;
    TextView name_account_card, email_account_address;
    RelativeLayout transaction, app_guide, help_center, settings_app;

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
        name_account_card = (TextView) findViewById(R.id.name_account_in_card);
        email_account_address = (TextView) findViewById(R.id.email_account_address);
        home_btn = (RelativeLayout) findViewById(R.id.home_bottom_bar);
        btn_return = (ImageView) findViewById(R.id.btn_return_account);
        btn_log_out = (CardView) findViewById(R.id.btn_logout);
        transaction = (RelativeLayout) findViewById(R.id.btn_transaction_account);
        app_guide = (RelativeLayout) findViewById(R.id.btn_app_tour_account);
        help_center = (RelativeLayout) findViewById(R.id.btn_help_account);
        settings_app = (RelativeLayout) findViewById(R.id.btn_settings_account);

        // Firebase Current //
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Firebase //
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser userName = mAuth.getCurrentUser();

        // Show Display Name //
        name_account_card.setText(firebaseUser.getDisplayName());
        email_account_address.setText(firebaseUser.getEmail());


        // onClick //
        home_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btn_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                FirebaseAuth.getInstance().signOut();
            }
        });

        // Preferences Settings //

        transaction.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, BillTransaction.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        help_center.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, HelpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        settings_app.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent (AccountInformation.this, SettingsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });





    }




    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(AccountInformation.this, MainActivity.class);
        startActivity(backIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
