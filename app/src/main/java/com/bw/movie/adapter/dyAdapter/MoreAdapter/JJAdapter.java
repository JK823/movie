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
import com.bw.movie.bean.syBean.GGBean;
import com.bw.movie.util.AppContext;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/23
 * author:王成虎(13671)
 * time:16:34
 * day:23
 * month:四月
 * function:
 */
public class JJAdapter extends RecyclerView.Adapter<JJAdapter.JJViewHolder> {


    private List<GGBean.ResultBean> list;
    private Context context;

    public JJAdapter(List<GGBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public JJViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gdjj_layout, parent, false);
        return new JJViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JJViewHolder holder, int position) {
        holder.recomImage.setImageURI(list.get(position).getImageUrl());
        //Glide.with(context).load(list.get(position).getImageUrl()).into(holder.recomImage);
        holder.textName.setText(list.get(position).getName());
        Date date = new Date(list.get(position).getReleaseTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        String[] split = format.split("-");
        ((JJViewHolder)holder).textTime.setText(split[1]+"月"+split[2]+"日"+"上映");
        holder.textRs.setText(list.get(position).getWantSeeNum()+"人想看");
        holder.btnJjYy.setText("预约");
        holder.btnJjYy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(list.get(position));
            }
        });
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

    class JJViewHolder extends RecyclerView.ViewHolder {
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
        /* @BindView(R.id.gg_image)
         ImageView ggImage;
         @BindView(R.id.gg_Name)
         TextView ggName;*/
        public JJViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
