package com.bw.movie.adapter.dyAdapter.XqAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.bean.syBean.Details.DetailsBean;

import java.util.List;

/**
 * date:2020/4/28
 * author:王成虎(13671)
 * time:9:24
 * day:28
 * month:四月
 * function:
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetaViewHolder> {

    private List<DetailsBean.ResultBean.MovieActorBean> list;
    private Context context;

    public DetailsAdapter(List<DetailsBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DetaViewHolder extends RecyclerView.ViewHolder {
        public DetaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
