package com.bw.movie.seatselection.zuo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.seatselection.bean.SeatInfoBean;
import com.bw.movie.util.ToastShow;

import java.util.ArrayList;
import java.util.List;


public class ZuoWeiView extends LinearLayout {
    private Context context;
    //记录上一次的座位数
    private int count;
    //每个座位控件
    private List<TextView> textViewList = new ArrayList<>();
    //自定义view宽度
    private int widthMeasure;
    //记录每一排多少个座位
    private List<SeatInfoBean.Result> row_seat = new ArrayList<>();
    //座位bean类
    private SeatInfoBean bean;
    //自己选择座位
    private List<String> seat_buy = new ArrayList<>();
    //接口回调，用于把已选择的座位回调给activity
    private ZuoWei zuoWei;
    //屏幕宽度
    private int widthPixels;
    //把横向滑动view默认显示中间部分
    private Scrollto scrollto;

    public void setScrollto(Scrollto scrollto) {
        this.scrollto = scrollto;
    }

    public List<String> getSeat_buy() {
        return seat_buy;
    }

    public void setZuoWei(ZuoWei zuoWei) {
        this.zuoWei = zuoWei;
    }

    public List<SeatInfoBean.Result> getRow_seat() {
        return row_seat;
    }

    public void setBean(SeatInfoBean bean) {
        this.bean = bean;
    }

    public void setRow_seat(List<SeatInfoBean.Result> row_seat) {
        this.row_seat = row_seat;
    }

    public ZuoWeiView(Context context) {
        super(context);
        this.context = context;
    }

    public ZuoWeiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public ZuoWeiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        widthPixels = getResources().getDisplayMetrics().widthPixels;
        scrollto.to(widthMeasure - widthPixels);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int childCount = getChildCount();
        int ViewWidth = widthPixels / 15;
        int left = 0;
        if (row_seat.size() > 0) {
            left = (widthMeasure - row_seat.get(0).getSeat() * ViewWidth - (row_seat.get(0).getSeat() - 1) * 30) / 2;
        }
        int right;
        int top = 10;
        int bottom;
        for (int i = 0; i < childCount; i++) {
            //i代表的是第多少个座位
            View view = getChildAt(i);
            bottom = top + ViewWidth;
            int seat = 0;
            for (int j = 0; j < row_seat.size(); j++) {
                //代表的是每一行最后一个座位是第几个座位
                seat += row_seat.get(j).getSeat();
                if (i == childCount - 1) {
                    break;
                } else if (i == seat) {//是最后一个座位就换行
                    left = (widthMeasure - row_seat.get(j + 1).getSeat() * ViewWidth - (row_seat.get(j + 1).getSeat() - 1) * 30) / 2;
                    top = bottom + 30;
                    if (row_seat.get(j + 1).getRow() < row_seat.get(j).getRow()) {
                        top = bottom + 50;
                    }
                    bottom = top + ViewWidth;
                }
            }
            right = left + ViewWidth;
            view.layout(left, top, right, bottom);
            left = right + 30;
        }
    }

    public void addView(final int count) {
        //a计算的是上一次的座位个数和这次显示的座位个数的差值
        int a = this.count - count;
        if (a > 0) {
            this.removeViews(textViewList.size() - a, a);
            for (int i = 0; i < a; i++) {
                textViewList.remove(textViewList.size() - 1);
            }
        } else {
            int abs = Math.abs(a);
            for (int i = 0; i < abs; i++) {
                final TextView textView = new TextView(context);
                textView.setBackgroundResource(R.drawable.zuowei_white);
                this.addView(textView);
                textViewList.add(textView);
            }
        }
        this.count = count;
        xuanzuo();
        requestLayout();
    }

    public void xuanzuo() {
        for (int i = 0; i < textViewList.size(); i++) {
            final int j = i;
            textViewList.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bean.getResult().get(j).getStatus() == 1) {
                        textViewList.get(j).setBackgroundResource(R.drawable.zuowei_red);
                        seat_buy.add(bean.getResult().get(j).getRow() + "-" + bean.getResult().get(j).getSeat());
                        ToastShow.makeText(bean.getResult().get(j).getRow() + "排" + bean.getResult().get(j).getSeat() + "座", 500);
                        bean.getResult().get(j).setStatus(3);
                    } else if (bean.getResult().get(j).getStatus() == 3) {
                        textViewList.get(j).setBackgroundResource(R.drawable.zuowei_white);
                        seat_buy.remove(bean.getResult().get(j).getRow() + "-" + bean.getResult().get(j).getSeat());
                        ToastShow.makeText("取消" + bean.getResult().get(j).getRow() + "排" + bean.getResult().get(j).getSeat() + "座", 500);
                        bean.getResult().get(j).setStatus(1);
                    }
                    zuoWei.zuowei(seat_buy);
                }
            });
            if (bean.getResult().get(i).getStatus() == 2) {
                textViewList.get(i).setOnClickListener(null);
                textViewList.get(i).setBackgroundResource(R.drawable.zuowei_yellow);
            } else if (bean.getResult().get(i).getStatus() == 1) {
                textViewList.get(i).setBackgroundResource(R.drawable.zuowei_white);
            }
        }
    }

    public interface ZuoWei {
        void zuowei(List<String> getSeat_buy);
    }

    public interface Scrollto {
        void to(int width);
    }
}
