package com.bw.movie.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bw.movie.R;
import com.bw.movie.fragment.CinemaFragment;
import com.bw.movie.fragment.HomeFragment;
import com.bw.movie.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.home_false)
    ImageView homeFalse;
    @BindView(R.id.home_true)
    LinearLayout homeTrue;
    @BindView(R.id.home)
    LinearLayout home;
    @BindView(R.id.cinema_false)
    ImageView cinemaFalse;
    @BindView(R.id.cinema_true)
    LinearLayout cinemaTrue;
    @BindView(R.id.cinema)
    LinearLayout cinema;
    @BindView(R.id.my_false)
    ImageView myFalse;
    @BindView(R.id.my_true)
    LinearLayout myTrue;
    @BindView(R.id.my)
    LinearLayout my;
    private boolean timer;
    private Unbinder bind;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentManager manager;
    private CinemaFragment cinemaFragment = new CinemaFragment();
    private boolean searchCinemas;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                timer = false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bind = ButterKnife.bind(this);
        fragmentList.add(new HomeFragment());
        fragmentList.add(cinemaFragment);
        fragmentList.add(new MyFragment());
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.frame, fragmentList.get(0))
                .add(R.id.frame, fragmentList.get(1))
                .add(R.id.frame, fragmentList.get(2))
                .show(fragmentList.get(0))
                .hide(fragmentList.get(1))
                .hide(fragmentList.get(2))
                .commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {

    }

    @OnClick({R.id.home, R.id.cinema, R.id.my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                homeTrue.setVisibility(View.VISIBLE);
                homeFalse.setVisibility(View.GONE);
                cinemaFalse.setVisibility(View.VISIBLE);
                cinemaTrue.setVisibility(View.GONE);
                myFalse.setVisibility(View.VISIBLE);
                myTrue.setVisibility(View.GONE);
                manager.beginTransaction().show(fragmentList.get(0)).hide(fragmentList.get(1)).hide(fragmentList.get(2)).commit();
                break;
            case R.id.cinema:
                cinemaTrue.setVisibility(View.VISIBLE);
                cinemaFalse.setVisibility(View.GONE);
                homeFalse.setVisibility(View.VISIBLE);
                homeTrue.setVisibility(View.GONE);
                myFalse.setVisibility(View.VISIBLE);
                myTrue.setVisibility(View.GONE);
                manager.beginTransaction().show(fragmentList.get(1)).hide(fragmentList.get(0)).hide(fragmentList.get(2)).commit();
                break;
            case R.id.my:
                myTrue.setVisibility(View.VISIBLE);
                myFalse.setVisibility(View.GONE);
                homeFalse.setVisibility(View.VISIBLE);
                homeTrue.setVisibility(View.GONE);
                cinemaFalse.setVisibility(View.VISIBLE);
                cinemaTrue.setVisibility(View.GONE);
                manager.beginTransaction().show(fragmentList.get(2)).hide(fragmentList.get(1)).hide(fragmentList.get(0)).commit();
                break;
        }
    }


}
