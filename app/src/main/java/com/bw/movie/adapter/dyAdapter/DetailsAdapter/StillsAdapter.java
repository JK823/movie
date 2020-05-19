package com.bw.movie.adapter.dyAdapter.DetailsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * time:21:07
 * day:08
 * month:五月
 * function:剧照
 */
public class StillsAdapter extends RecyclerView.Adapter<StillsAdapter.StillsViewHolder> {

    private List<DetailsBean.ResultBean.ShortFilmListBean> list;
    private Context context;


    public StillsAdapter(List<DetailsBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stills_layout, parent, false);
        return new StillsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StillsViewHolder holder, int position) {
        holder.juzhaoSdv.setImageURI(list.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StillsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.juzhao_sdv)
        SimpleDraweeView juzhaoSdv;

        public StillsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
