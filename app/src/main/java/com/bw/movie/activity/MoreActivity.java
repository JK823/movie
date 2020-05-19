package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.R;
import com.bw.movie.fragment.HomeFragment;
import com.bw.movie.fragment.dyFragment.gdFragment.JjFragment;
import com.bw.movie.fragment.dyFragment.gdFragment.RmFragment;
import com.bw.movie.fragment.dyFragment.gdFragment.ZzFragment;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {

    private XTabLayout gdt;
    private ViewPager gdv;

    private List<Fragment> fragments = new ArrayList<>();

    private List<String> list = new ArrayList<>();
    private ImageView fh;
    private EditText edss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        fh = findViewById(R.id.gd_fh);
        gdt = findViewById(R.id.gd_tab);
        gdv = findViewById(R.id.gd_vp);
        edss = findViewById(R.id.edit_ss);

        edss.requestFocus();

        fragments.add(new ZzFragment());

        fragments.add(new JjFragment());

        fragments.add(new RmFragment());

        list.add("正在热映");

        list.add("即将上映");

        list.add("热门电影");


        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreActivity.this, HomeFragment.class));
            }
        });


        gdv.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });

        gdt.setupWithViewPager(gdv);

    }
}
