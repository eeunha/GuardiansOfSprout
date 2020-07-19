package kr.angelhackseoul.guardiansofsprout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.search_act_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
//
//        Toolbar toolbar = findViewById(R.id.myToolbar2);
//        toolbar.setTitle("");
//        toolbar.inflateMenu(R.menu.search);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        })
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home: {    // toolbar의 back이 눌렸을 때 동작
//                finish();
//                return true;
//            }
//            case android.R.id.action_search: {
//                // 검색시쿼리 구현
//                return true;
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
