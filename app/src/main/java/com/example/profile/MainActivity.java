package com.example.profile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new Firstgragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_opt) {
                    setFragment(new BlankFragment());
                    return true;
                } else if (item.getItemId() == R.id.second_opt) {
                    setFragment(new Firstgragment());
                    return true;
                } else if (item.getItemId() == R.id.third_opt) {
                    setFragment(new ThirdFragment());
                    return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment, int itemId) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.selectedmenu, fragment)
                .commit();


        bottomNavigationView.setSelectedItemId(itemId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id ==R.id.action_settings){
            Toast.makeText(this, "Настройки выполнены", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.firstFrag){
            setFragment(new BlankFragment());
            bottomNavigationView.setSelectedItemId(R.id.first_opt);
            return true;
        }else if(id == R.id.twoFrag) {
            setFragment(new Firstgragment());
            bottomNavigationView.setSelectedItemId(R.id.second_opt);
            return true;
        }else if(id == R.id.thirdFrag){
                setFragment(new ThirdFragment());
            bottomNavigationView.setSelectedItemId(R.id.third_opt);
                return true;
        }else{
            return super.onContextItemSelected(item);
        }



    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.selectedmenu, fragment,
                null).commit();
    }
}