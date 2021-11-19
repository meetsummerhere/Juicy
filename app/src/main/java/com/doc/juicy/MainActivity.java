package com.doc.juicy;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.doc.juicy.fragment.FragmentSlider;
import com.doc.juicy.adapter.SliderPagerAdapter;
import com.doc.juicy.decoration.SliderIndicator;
import com.doc.juicy.decoration.BannerSlider;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private BannerSlider bannerSlider;
    private LinearLayout mLinearLayout;
    private BottomNavigationView menu_bawah;
    private TextView tulisan;
    private FirebaseAuth mAuth;
    ImageView imguser;
    TextView textName, textEmail, textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bannerSlider = findViewById(R.id.sliderView);
        mLinearLayout = findViewById(R.id.pagesContainer);
        setupSlider();

        menu_bawah = findViewById(R.id.menu_bawah);
        tulisan = findViewById(R.id.tulisan);
        menu_bawah.setOnNavigationItemSelectedListener(this);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();
        imguser = findViewById(R.id.userphoto);
        textName = findViewById(R.id.namauser);
        textEmail = findViewById(R.id.emailuser);
        textPhone = findViewById(R.id.phoneuser);

        if (account !=null) {
            textName.setText(account.getDisplayName());
            textEmail.setText(account.getEmail());
            textPhone.setText("08821136788");
//            Glide.with(this).load(account.getPhotoUrl()).into(imguser);
        }else{

        }
    }
    private void setupSlider() {
        bannerSlider.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        //link image
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/19/85531617/85531617_17b56894-2608-4509-a4f4-ad86aa5d3b62.jpg"));
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/19/85531617/85531617_7da28e4c-a14f-4c10-8fec-845578f7d748.jpg"));
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/18/85531617/85531617_87a351f9-b040-4d90-99f4-3f3e846cd7ef.jpg"));
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/20/85531617/85531617_03e76141-3faf-45b3-8bcd-fc0962836db3.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        bannerSlider.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, bannerSlider, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                Intent home = new Intent(MainActivity.this, MainActivity.class);
                startActivity(home);
                break;
//            case R.id.btnsetting:
//                Intent btnsetting = new Intent(MainActivity.this, SettingActivity.class);
//                startActivity(btnsetting);
//                break;
            case R.id.artikel:

                break;
            case R.id.akun:
                Intent i = new Intent(MainActivity.this, AkunActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }
}