package cdk.cybertwenty.iybc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText username, password;
    Button btn_click_login;

    TextView create_account;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_login);

        // mAuth //

        mAuth = FirebaseAuth.getInstance();

        // Functions //
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_click_login = (Button) findViewById(R.id.btn_login);
        create_account = (TextView) findViewById(R.id.btn_create_account);


        // onClick //

        btn_click_login.setOnClickListener(v -> {
            if(username.getText().length()>0 && password.getText().length()>0){
                login(username.getText().toString(), password.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "Data form diatas kosong! Isi data dengan benar!",Toast.LENGTH_SHORT).show();
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(LoginActivity.this, RegisterSystem.class);
                startActivity(myintent);
                finish();
            }
        });


    }

    private void login(String emailLogin, String passwordLogin){
        mAuth.signInWithEmailAndPassword(emailLogin, passwordLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null){
                    if (task.getResult().getUser()!=null) {
                        reload();
                    } else {
                        Toast.makeText(getApplicationContext(), "The server cannot handle please wait!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Email or Password invalid!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void reload() {
        Intent reloadPage = new Intent(LoginActivity.this, AccountInformation.class);
        startActivity(reloadPage);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser !=null){
            reload();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (LoginActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
