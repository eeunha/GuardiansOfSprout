package kr.angelhackseoul.guardiansofsprout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    StoreFragment storeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        homeFragment = new HomeFragment();
        storeFragment = new StoreFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, homeFragment).commitAllowingStateLoss();


        Intent intent = getIntent();
        StoreA storeA = (StoreA) intent.getSerializableExtra("storeData");
//        String pageFlag2 = intent.getExtras().getString("pageFlag");

//        if (pageFlag2.equals("yes")) {
//            Fragment fragment = new DetailStoreFragment();
//            FragmentManager fm = getSupportFragmentManager();
//            final FragmentTransaction fragmentTransaction = fm.beginTransaction();
//            fragmentTransaction.replace(R.id.main_layout, fragment);
//            fragmentTransaction.commit();
//        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_nav: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, homeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.board_nav: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, storeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.feed_nav: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, storeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.mypage_nav: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, storeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }
}
