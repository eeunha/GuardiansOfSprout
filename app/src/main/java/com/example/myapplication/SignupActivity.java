package com.example.myapplication;

import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class SignupActivity extends AppCompatActivity {

    private final  String TAG = getClass().getSimpleName();
    private final String BASE_URL = "http://52.79.67.124:8080/";
    private RetrofitService mMyAPI;

    EditText input_id, input_password, input_name, input_nickname, input_email, input_phone, input_usertype;

    StringBuffer sb = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        input_id = (EditText) findViewById(R.id.input_id);
        input_password = (EditText) findViewById(R.id.input_password);
        input_name = (EditText) findViewById(R.id.input_name);
        input_nickname = (EditText) findViewById(R.id.input_nickname);
        input_email = (EditText) findViewById(R.id.input_email);
        input_phone = (EditText) findViewById(R.id.input_phone);
        input_usertype = (EditText) findViewById(R.id.input_usertype);

        initMyAPI(BASE_URL);

    }

    private void initMyAPI(String baseUrl) {

        Log.d(TAG, "initMyAPI : " + baseUrl);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.79.67.124:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mMyAPI = retrofit.create(RetrofitService.class);
    }

    public void signup(View view) {
        String id = input_id.getText().toString();
        String password = input_password.getText().toString();
        String name = input_name.getText().toString();
        String nickname = input_nickname.getText().toString();
        String email = input_email.getText().toString();
        String phone = input_phone.getText().toString();
        String userType = input_usertype.getText().toString();

        //RetrofitService retrofitService = retrofit.create(RetrofitService.class);
       /*Call<JsonObject> call = NetRetrofit.getInstance().getService().getPost(id, password, name, nickname, email, phone, userType);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject repo = response.body();

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}*/
       //회원가입(signup)
        UserDTO item = new UserDTO();
        item.setId(id);
        item.setPassword(password);
        item.setName(name);
        item.setNickname(nickname);
        item.setEmail(email);
        item.setPhone(phone);
        item.setUserType(userType);
        Call<UserDTO> postCall = mMyAPI.post(item);
        postCall.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "등록 완료");
                    Intent loginIntent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }
            }
            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                    Log.d(TAG,"Fail msg : " + t.getMessage());
            }
        });
    }
}