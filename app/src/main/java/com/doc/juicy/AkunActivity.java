package com.doc.juicy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.doc.juicy.fragment.FragmentSlider;
import com.doc.juicy.adapter.SliderPagerAdapter;
import com.doc.juicy.decoration.SliderIndicator;
import com.doc.juicy.decoration.BannerSlider;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AkunActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    Button button;
    private BottomNavigationView menu_bawah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        menu_bawah = findViewById(R.id.menu_bawah);
        menu_bawah.setOnNavigationItemSelectedListener(this);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                Intent home = new Intent(AkunActivity.this, MainActivity.class);
                startActivity(home);
                break;
//            case R.id.btnsetting:
//                Intent i = new Intent(AkunActivity.this, SettingActivity.class);
//                startActivity(i);
//                break;
            case R.id.artikel:

                break;
            case R.id.akun:
                break;
        }
        return true;
    }

    public void setting(View view) {
        Intent i = new Intent(AkunActivity.this, SettingActivity.class);
        startActivity(i);
    }
}