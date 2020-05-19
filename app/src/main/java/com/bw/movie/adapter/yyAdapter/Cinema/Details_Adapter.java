package com.bw.movie.adapter.yyAdapter.Cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bw.movie.R;
import com.bw.movie.bean.yyBean.CineamdeBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/5/10
 * author:王成虎(13671)
 * time:20:51
 * day:10
 * month:五月
 * function:
 */
public class Details_Adapter extends RecyclerView.Adapter<Details_Adapter.DetailsViewHolder>  {

    private CineamdeBean.ResultBean list;
    private Context context;

    public Details_Adapter(CineamdeBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cinema_details_layout, parent, false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        holder.cinemaDetailAddress.setText(list.getAddress());
        holder.cinemaDetailPhone.setText(list.getPhone());
        holder.cinemDetailLuxian.setText(list.getVehicleRoute());
    }

    @Override
    public int getItemCount() {
        return list.getId();
    }

    class DetailsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cinema_detail_address)
        TextView cinemaDetailAddress;
        @BindView(R.id.cinema_detail_phone)
        TextView cinemaDetailPhone;
        @BindView(R.id.cinem_detail_luxian)
        TextView cinemDetailLuxian;
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
