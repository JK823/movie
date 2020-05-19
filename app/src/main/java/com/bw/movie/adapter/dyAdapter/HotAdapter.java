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
import com.bw.movie.bean.syBean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.HotViewHolder> {

    private List<HotBean.ResultBean> list;
    private Context context;

    public HotAdapter(List<HotBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hot_layout, parent, false);
        return new HotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.hotImage);
        holder.hotName.setText(list.get(position).getName());
        holder.hotScore.setText(list.get(position).getScore() + "");
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

    class HotViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_image)
        SimpleDraweeView hotImage;
        @BindView(R.id.hot_Name)
        TextView hotName;
        @BindView(R.id.hot_score)
        TextView hotScore;

        public HotViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
