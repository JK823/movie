package com.bw.movie.adapter.dyAdapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.activity.DetailsActivity;
import com.bw.movie.bean.syBean.GGBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GGAdapter extends RecyclerView.Adapter<GGAdapter.GGViewHolder> {

    public int OnClickItem = 0;
    private List<GGBean.ResultBean> list;
    private Context context;

    public GGAdapter(List<GGBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gg_layout, parent, false);
        return new GGViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GGViewHolder holder, int position) {
        holder.recomImage.setImageURI(list.get(position).getImageUrl());
        //Glide.with(context).load(list.get(position).getImageUrl()).into(holder.recomImage);
        holder.textName.setText(list.get(position).getName());
        Date date = new Date(list.get(position).getReleaseTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        String[] split = format.split("-");
        ((GGViewHolder)holder).textTime.setText(split[1]+"月"+split[2]+"日"+"上映");
        holder.textRs.setText(list.get(position).getWantSeeNum()+"人想看");
        holder.btnJjYy.setText("预约");
        if (position == OnClickItem) {
            holder.btnJjYy.setBackgroundColor(Color.RED);
        } else {
            holder.btnJjYy.setBackgroundColor(Color.YELLOW);
            holder.btnJjYy.setText("已预约");
            holder.btnJjYy.setTextColor(Color.WHITE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //context.startActivity(new Intent(context, DetailsActivity.class));
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movieId", list.get(position).getMovieId() + "");
                context.startActivity(intent);
            }
        });
        holder.btnJjYy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickItem = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GGViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recom_Image)
        SimpleDraweeView recomImage;
        @BindView(R.id.text_Name)
        TextView textName;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.text_rs)
        TextView textRs;
        @BindView(R.id.btn_jj_yy)
        Button btnJjYy;
        public GGViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
