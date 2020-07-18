package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

        public void onClick(View v) {
            Class classObj = null;
            switch (v.getId()) {
                case R.id.loginBtn: classObj = LoginActivity.class; break;
                case R.id.findId_Btn: classObj = Find_IdActivity.class; break;
                case R.id.findPassword_Btn: classObj = Find_PasswordActivity.class; break;
                case R.id.joinBtn: classObj = SignupActivity.class; break;
            }
            Intent intent = new Intent(this, classObj);
            startActivity(intent);
        }
}
