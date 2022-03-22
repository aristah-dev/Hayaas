package com.example.safarirides;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_book,new BookFragment()).commit();
    }


    private final NavigationBarView.OnItemSelectedListener nav =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.menu_item_book_car:
                            showFragment(new BookFragment());
                            Toast.makeText(getApplicationContext(), "Home Selected", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.menu_item_hire_car:
                            showFragment(new HireFragment());
                            break;
                        case R.id.menu_item_movers:
                            showFragment(new MoversFragment());
                            break;

                    }
                    return true;
                }
            };


    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_book, fragment)
                .commit();
    }
}