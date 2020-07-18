package com.example.myapplication;
import android.os.Message;

import com.google.gson.JsonObject;

import org.json.JSONObject;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    //@GET("user/findBy/{id}")
        //Call<ArrayList<JsonObject>> getData(@Query("id") String id);
   /* @FormUrlEncoded
    @POST("/user/signup")
    Call<UserDTO> getPost(
            @Field("id") String id,
            @Field("password") String password,
            @Field("name") String name,
            @Field("nickname") String nickname,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("userType") String userType
    );*/

        @POST ("user/signup")
        Call<UserDTO> post(@Body UserDTO user);

        //<JsonObject>getList(@Field("id") String id);
    //Call<JsonObject> getList(@Path("id") String id);
//}

}
