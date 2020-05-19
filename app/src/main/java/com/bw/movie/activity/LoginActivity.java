package com.bw.movie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.myBean.LoginBean;
import com.bw.movie.mvp.wd.Contract.LoginContract;
import com.bw.movie.mvp.wd.Presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {


    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.iv_return)
    ImageView ivReturn;
    @BindView(R.id.login_email)
    EditText loginEmail;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.tv_switch_login)
    TextView tvSwitchLogin;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.huo)
    TextView huo;
    @BindView(R.id.iv_login)
    ImageView ivLogin;
    @BindView(R.id.ll_login)
    LinearLayout llLogin;
    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_captcha)
    EditText registerCaptcha;
    @BindView(R.id.tv_get_captcha)
    TextView tvGetCaptcha;
    @BindView(R.id.tv_switch_register)
    TextView tvSwitchRegister;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.ll_register)
    LinearLayout llRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvSwitchLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "立即注册", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void success(LoginBean bean) {

    }


}
