package com.bw.movie.adapter.dyAdapter.DetailsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.syBean.Details.DetailsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/5/8
 * author:王成虎(13671)
 * time:21:01
 * day:08
 * month:五月
 * function:演员
 */
public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private List<DetailsBean.ResultBean.MovieActorBean> list;
    private Context context;

    public ActorAdapter(List<DetailsBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_actor_layout, parent, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        holder.yanyuanSdv.setImageURI(list.get(position).getPhoto());
        holder.yanyuanName.setText(list.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class ActorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.yanyuan_sdv)
        SimpleDraweeView yanyuanSdv;
        @BindView(R.id.yanyuan_name)
        TextView yanyuanName;
        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
