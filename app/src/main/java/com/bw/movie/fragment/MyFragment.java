package com.bw.movie.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.activity.LoginActivity;

/**
 * date:2020/4/16
 * author:王成虎(13671)
 * time:21:24
 * day:16
 * month:四月
 * function:
 */
public class MyFragment extends Fragment implements View.OnClickListener {

    private ImageView iv_info;
    private ImageView iv_head;
    private TextView tv_name;
    private LinearLayout ll_login;
    private LinearLayout ll_ticket;
    private LinearLayout ll_follow;
    private LinearLayout ll_appointment;
    private LinearLayout ll_record;
    private LinearLayout ll_looked;
    private LinearLayout ll_comment;
    private LinearLayout ll_feedback;
    private LinearLayout ll_setting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        SharedPreferences loginData = getActivity().getSharedPreferences("loginData", Context.MODE_PRIVATE);
        String headPic = loginData.getString("headPic", "");
        String nickName = loginData.getString("nickName", "");
        if (!headPic.equals("") && !nickName.equals("")) {
            tv_name.setText(nickName);
            Glide.with(getActivity()).load(headPic).into(iv_head);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_info:
                //信息
                break;
            case R.id.ll_login:
                //登录
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.tv_name:
                break;
            case R.id.ll_ticket:
                //电影票
                break;
            case R.id.ll_follow:
                //关注
                break;
            case R.id.ll_appointment:
                //预约
                break;
            case R.id.ll_record:
                //记录
                break;
            case R.id.ll_looked:
                //看过的电影
                break;
            case R.id.ll_comment:
                //评论
                break;
            case R.id.ll_feedback:
                //反馈
                break;
            case R.id.ll_setting:
                //设置
                break;
        }
    }

    protected void initView(View view) {
        iv_info = view.findViewById(R.id.iv_info);
        iv_head = view.findViewById(R.id.iv_head);
        tv_name = view.findViewById(R.id.tv_name);
        ll_login = view.findViewById(R.id.ll_login);
        ll_ticket = view.findViewById(R.id.ll_ticket);
        ll_follow = view.findViewById(R.id.ll_follow);
        ll_appointment = view.findViewById(R.id.ll_appointment);
        ll_record = view.findViewById(R.id.ll_record);
        ll_looked = view.findViewById(R.id.ll_looked);
        ll_comment = view.findViewById(R.id.ll_comment);
        ll_feedback = view.findViewById(R.id.ll_feedback);
        ll_setting = view.findViewById(R.id.ll_setting);
        iv_info.setOnClickListener(this);
        ll_login.setOnClickListener(this);
        tv_name.setOnClickListener(this);
        ll_ticket.setOnClickListener(this);
        ll_follow.setOnClickListener(this);
        ll_appointment.setOnClickListener(this);
        ll_record.setOnClickListener(this);
        ll_looked.setOnClickListener(this);
        ll_comment.setOnClickListener(this);
        ll_feedback.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
    }

}
