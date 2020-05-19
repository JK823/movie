package com.bw.movie.util;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class ToastShow {
    private static boolean isToast;
    private static Toast toast;
    private static String lastText;

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                toast.cancel();
                isToast = false;
            }
        }
    };

    public static void makeText(String text, int duration) {
        if (!isToast) {
            toast = Toast.makeText(AppContext.context, text, Toast.LENGTH_LONG);
            toast.show();
            lastText = text;
            isToast = true;
            handler.sendEmptyMessageDelayed(0, duration);
        } else if (isToast && !text.equals(lastText)) {
            handler.removeMessages(0);
            toast.cancel();
            toast = Toast.makeText(AppContext.context, text, Toast.LENGTH_LONG);
            toast.show();
            lastText = text;
            handler.sendEmptyMessageDelayed(0, duration);
        }
    }
}
