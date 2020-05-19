package com.bw.movie.adapter.dyAdapter.MoreAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.activity.DetailsActivity;
import com.bw.movie.bean.syBean.NowBean;
import com.bw.movie.util.AppContext;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/23
 * author:王成虎(13671)
 * time:20:19
 * day:23
 * month:四月
 * function:
 */
public class RmAdapter extends RecyclerView.Adapter<RmAdapter.RmViewHolder> {



    private List<NowBean.ResultBean> list;
    private Context context;

    public RmAdapter(List<NowBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gdrm_layout, parent, false);
        return new RmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RmViewHolder holder, int position) {
        holder.recomImage.setImageURI(list.get(position).getImageUrl());
        //Glide.with(context).load(list.get(position).getImageUrl()).into(holder.nowImage);
        holder.textName.setText(list.get(position).getName());
        holder.textDy.setText("导演"+list.get(position).getDirector());
        holder.textZy.setText("主演"+list.get(position).getStarring());
        holder.textPf.setText("评分"+list.get(position).getScore() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppContext.context, DetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movieId",list.get(position).getMovieId()+"");
                AppContext.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RmViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recom_Image)
        SimpleDraweeView recomImage;
        @BindView(R.id.text_Name)
        TextView textName;
        @BindView(R.id.text_dy)
        TextView textDy;
        @BindView(R.id.text_zy)
        TextView textZy;
        @BindView(R.id.text_pf)
        TextView textPf;
        @BindView(R.id.btn_jj_yy)
        Button btnJjYy;
        public RmViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
