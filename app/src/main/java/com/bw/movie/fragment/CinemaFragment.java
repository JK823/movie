package com.bw.movie.fragment;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.fragment.YFragment.DqFragment;
import com.bw.movie.fragment.YFragment.NearbyFragment;
import com.bw.movie.fragment.YFragment.RecomFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * date:2020/4/16
 * author:王成虎(13671)
 * time:21:24
 * day:16
 * month:四月
 * function:
 */
public class CinemaFragment extends BaseFragment {


    @BindView(R.id.et_branch)
    EditText etBranch;
    @BindView(R.id.tab)
    XTabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<Fragment> fragmentList  = new ArrayList<>();
    private List<String> list = new ArrayList<>();

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View inflate) {
        fragmentList.add(new RecomFragment());
        fragmentList.add(new NearbyFragment());
        fragmentList.add(new DqFragment());
        list.add("推荐影院");
        list.add("附近影院");
        list.add("地区");
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        vp.setOffscreenPageLimit(3);
        tab.setupWithViewPager(vp);

    }

    @Override
    protected int initLayout() {
        return R.layout.yy_layout;
    }

    @Override
    protected void initData() {

    }
}
