package kr.angelhackseoul.guardiansofsprout;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("user/find")
    Call<ArrayList<JsonObject>> getListRepos();

    @POST("store/list")
    Call<List<Store>> sendStore(@Body List<StoreDTO> stores);

    @GET("store/{id}")
    Call<Store> send(@Path("id") int id);

}
