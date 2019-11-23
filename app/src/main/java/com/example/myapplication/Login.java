package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    public final static String loginADMIN = "admin";
    public final static String passwordADMIN = "admin";

    private static String login;
    private static String password;

    public static void setLogin(String login) {
        Login.login = login;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    EditText textlogin;
    EditText textpassword;
    Button loginbutton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        textlogin = findViewById(R.id.login);
        textpassword = findViewById(R.id.password);
        loginbutton = findViewById(R.id.button);
        textView = findViewById(R.id.textview);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textlogin.getText().toString().equals(Login.loginADMIN) && textpassword.getText().toString().equals(Login.passwordADMIN)){
                    textView.setText(getApplicationContext().getString(R.string.texttrue));
                }
                else if (textlogin.getText().toString().equals(getLogin()) && textpassword.getText().toString().equals(getPassword())){
                    textView.setText(getApplicationContext().getString(R.string.texttrue));
                }
                else {
                    textlogin.setText("");
                    textpassword.setText("");
                    textView.setText("");
                    Intent intent = new Intent(Login.this, Register.class);
                    startActivityForResult(intent, 1);
                }
            }

        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            textlogin.setText(data.getStringExtra("login"));
        }
    }

}
