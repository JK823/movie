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
 * function:介绍
 */
public class IntroductionAdapter extends RecyclerView.Adapter<IntroductionAdapter.IntroductionViewHolder> {

    private List<DetailsBean.ResultBean.MovieDirectorBean> list;
    private Context context;

    public IntroductionAdapter(List<DetailsBean.ResultBean.MovieDirectorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public IntroductionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_details_introduction_layout, parent, false);
        return new IntroductionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroductionViewHolder holder, int position) {
        holder.daoSdv.setImageURI(list.get(position).getPhoto());
        holder.daoName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class IntroductionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dao_sdv)
        SimpleDraweeView daoSdv;
        @BindView(R.id.dao_name)
        TextView daoName;
        public IntroductionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
