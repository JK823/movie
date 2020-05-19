package com.bw.movie.adapter.dyAdapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.activity.DetailsActivity;
import com.bw.movie.bean.syBean.NowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowAdapter extends RecyclerView.Adapter<NowAdapter.NowViewHolder> {


    private List<NowBean.ResultBean> list;
    private Context context;

    public NowAdapter(List<NowBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_now_layout, parent, false);
        return new NowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowViewHolder holder, int position) {
        //holder.nowImage.setImageURI(list.get(position).getImageUrl());
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.nowImage);
        holder.nowName.setText(list.get(position).getName());
        holder.nowScore.setText(list.get(position).getScore() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //context.startActivity(new Intent(context, DetailsActivity.class));
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movieId",list.get(position).getMovieId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NowViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.now_image)
        SimpleDraweeView nowImage;
        @BindView(R.id.now_Name)
        TextView nowName;
        @BindView(R.id.now_score)
        TextView nowScore;

        public NowViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
