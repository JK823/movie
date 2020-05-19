package com.bw.movie.adapter.dyAdapter.DetailsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.syBean.Details.PingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/5/8
 * author:王成虎(13671)
 * time:21:10
 * day:08
 * month:五月
 * function:影评
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<PingBean.ResultBean> list;
    private Context context;

    public ReviewAdapter(List<PingBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_details_review_layout, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.sdvImage.setImageURI(list.get(position).getCommentHeadPic());
        holder.pingName.setText(list.get(position).getCommentUserName());
        holder.pingScore.setText(list.get(position).getScore()+""+"分");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd hh:mm");
        String format = simpleDateFormat.format(list.get(position).getCommentTime());
        holder.pingData.setText(format);
        holder.pingNr.setText(list.get(position).getCommentContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv_image)
        SimpleDraweeView sdvImage;
        @BindView(R.id.ping_Name)
        TextView pingName;
        @BindView(R.id.ping_score)
        TextView pingScore;
        @BindView(R.id.ping_data)
        TextView pingData;
        @BindView(R.id.ping_nr)
        TextView pingNr;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
