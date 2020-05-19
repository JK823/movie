package com.bw.movie.seatselection.zuo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


public class LeftZheGaiVIew extends View {

    Paint paint = new Paint();
    public LeftZheGaiVIew(Context context) {
        super(context);
    }

    public LeftZheGaiVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftZheGaiVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#141931"));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0, 0);// 此点为多边形的起点
        path.lineTo(canvas.getWidth(), canvas.getHeight());
        path.lineTo(0,canvas.getHeight());
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, paint);
        /*canvas.drawLine(0,0,0,canvas.getHeight(),paint);
        canvas.drawLine(0,0,canvas.getWidth(),canvas.getHeight(),paint);
        canvas.drawLine(0,canvas.getHeight(),canvas.getWidth(),canvas.getHeight(),paint);*/
    }
}
