package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    EditText login;
    EditText password;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        login = findViewById(R.id.rlogin);
        password = findViewById(R.id.rpassword);
        button = findViewById(R.id.rbutton);
        textView = findViewById(R.id.textwarning);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString();
                String loginstr = login.getText().toString();
                String[] passwds = {"12345678", "password", loginstr};
                boolean flag = false;

                for (int i = 0; i < passwds.length; i++){
                    if (pass.equals(passwds[i]) || pass.length() < 8){
                        flag = false;
                        break;
                    }
                    else {
                        flag = true;
                    }
                }

                if (!flag){
                    textView.setText(getApplicationContext().getString(R.string.warning));
                }
                else if (login.getText().toString().equals(Login.loginADMIN)){
                    textView.setText(getApplicationContext().getString(R.string.logs));
                }
                else {
                    Login.setLogin(login.getText().toString());
                    Login.setPassword(password.getText().toString());
                    Intent intent = new Intent(Register.this, Login.class);
                    intent.putExtra("login", login.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }
}
