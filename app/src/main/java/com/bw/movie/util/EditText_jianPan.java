package com.bw.movie.util;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class EditText_jianPan {
    public static boolean Listener(EditText editText, final Activity activity){
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    //收起键盘
                    InputMethodManager imm =  (InputMethodManager)AppContext.context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    if(imm != null) {
                        imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
                    }
                    //如果是回车操作，则返回true，消费掉此次事件
                    return true;
                }
                return false;
            }
        });
        return false;
    }
}
