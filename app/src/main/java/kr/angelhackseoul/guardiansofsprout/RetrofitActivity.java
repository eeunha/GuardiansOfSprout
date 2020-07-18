package kr.angelhackseoul.guardiansofsprout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }

    public void onSearch(View view) {
//        String id = editText.getText().toString();
//
//        if (!id.isEmpty()) {
//            Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().getListRepos(id);

        Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().getListRepos();    // 안에 들은 전체 리스트
        res.enqueue(new Callback<ArrayList<JsonObject>>() {
            @Override
            public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                Log.d("Retrofit", response.toString());
                if (response.body() != null)
                    textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                Log.e("Err", t.getMessage());
            }
        });
//        } else {
//            Toast.makeText(this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
//        }
    }

    public void onStoreSearch(View view) {
        Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().getStoreRepos();    // 안에 들은 전체 리스트
        res.enqueue(new Callback<ArrayList<JsonObject>>() {
            @Override
            public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                Log.d("Retrofit", response.toString());
                if (response.body() != null)
                    textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                Log.e("Err", t.getMessage());
            }
        });
    }

}
