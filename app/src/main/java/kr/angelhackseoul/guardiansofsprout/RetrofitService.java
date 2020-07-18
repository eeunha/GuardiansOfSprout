package kr.angelhackseoul.guardiansofsprout;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("user/find")
    Call<ArrayList<JsonObject>> getListRepos();

    @GET("store/list")
    Call<ArrayList<JsonObject>> getStoreRepos();

//    @GET("store/list")
//    Call<ArrayList<JsonObject>> getStoreByName(@Path("storeName") String storeName);
//
//    @GET("users/{user}/repos")
//    Call<ArrayList<JsonObject>> getListRepos(@Path("user") String id);
}
