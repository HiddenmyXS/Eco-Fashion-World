package cdk.cybertwenty.iybc;

import android.content.Intent;
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
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterSystem extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText username_register, email_register, password_register, confirm_password_register;
    TextView login;
    Button btn_register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        View decorView = getWindow().getDecorView();
        int UIOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(UIOptions);
        setContentView(R.layout.activity_register);

        // mAuth //

        mAuth = FirebaseAuth.getInstance();

        // Functions //

        username_register = (EditText) findViewById(R.id.username_register);
        email_register = (EditText) findViewById(R.id.email_register);
        password_register = (EditText) findViewById(R.id.password_register);
        confirm_password_register = (EditText) findViewById(R.id.re_password_register);
        btn_register = (Button) findViewById(R.id.btn_register);
        login = (TextView) findViewById(R.id.btn_login_account);

        // onClick //

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username_register.getText().length() > 0 && password_register.getText().length() > 0 && confirm_password_register.getText().length() > 0) {
                    if (password_register.getText().toString().equals(confirm_password_register.getText().toString())) {
                        Register(username_register.getText().toString(), email_register.getText().toString(), password_register.getText().toString());
                    } else {
                        Toast.makeText(getApplicationContext(),"Silahkan masukan password dengan benar!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Isi semua data anda!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (RegisterSystem.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void Register (String name, String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser!=null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Register Gagal!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), AccountInformation.class));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (RegisterSystem.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
