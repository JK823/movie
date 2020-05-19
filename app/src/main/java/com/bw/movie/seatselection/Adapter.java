package com.bw.movie.seatselection;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.seatselection.movieSchedule.MovieScheduleBean;
import com.bw.movie.util.AppContext;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter {
    private MovieScheduleBean bean;
    private List<TextView> textViewList = new ArrayList<>();
    private Seat seat;
    private boolean isTrue;
    private int id;
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setBean(MovieScheduleBean bean) {
        this.bean = bean;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(AppContext.context).inflate(R.layout.screeninghall_layout, viewGroup, false);
        Holder holder = new Holder(inflate);
        if (!isTrue) {
            isTrue = true;
            seat.id(bean.getResult().get(i).getHallId(), bean.getResult().get(i).getId(), bean.getResult().get(i).getFare());
        }
        textViewList.add(holder.xuanzhong);
        return holder;
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        final Holder holder = (Holder) viewHolder;
        if (id == i){
            holder.xuanzhong.setBackgroundResource(R.drawable.zuowei_red);
        }else {
            holder.xuanzhong.setBackgroundResource(R.drawable.zuowei_white);
        }
        holder.screeningHall.setText(bean.getResult().get(i).getScreeningHall());
        holder.time.setText(bean.getResult().get(i).getBeginTime() + "——" + bean.getResult().get(i).getEndTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seat.id(bean.getResult().get(i).getHallId(), bean.getResult().get(i).getId(), bean.getResult().get(i).getFare());
                for (int j = 0; j < textViewList.size(); j++) {
                    textViewList.get(j).setBackgroundResource(R.drawable.zuowei_white);
                }
                holder.xuanzhong.setBackgroundResource(R.drawable.zuowei_red);
                id = holder.getPosition();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (bean == null) {
            return 0;
        }
        return bean.getResult().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView xuanzhong;
        private TextView screeningHall;
        private TextView time;

        public Holder(@NonNull View itemView) {
            super(itemView);
            xuanzhong = itemView.findViewById(R.id.xuanzhong);
            screeningHall = itemView.findViewById(R.id.screeningHall);
            time = itemView.findViewById(R.id.time);
        }
    }

    public interface Seat {
        void id(int hallId, int scheduleId, double price);
    }
}
