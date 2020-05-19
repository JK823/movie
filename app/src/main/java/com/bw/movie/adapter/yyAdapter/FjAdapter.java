package com.bw.movie.adapter.yyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.yyBean.FjBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:22:24
 * day:17
 * month:四月
 * function:
 */
public class FjAdapter extends RecyclerView.Adapter<FjAdapter.FjViewHolder> {

    public int OnClickItem = 0;
    private List<FjBean.ResultBean> list;
    private Context context;

    public FjAdapter(List<FjBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fj_layout, parent, false);
        return new FjViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FjViewHolder holder, int position) {
        //使用Fresco进行将图片圆
        //holder.recomImage.setImageURI(list.get(position).getLogo());
        Glide.with(context).load(list.get(position).getLogo()).into(holder.recomImage);
        holder.recomName.setText(list.get(position).getName());
        holder.recomArdess.setText(list.get(position).getAddress());
        holder.textDimens.setText(list.get(position).getDistance()+""+"km");
        //holder.textDimens.setText(list.get(position).getDistance());
        /*if (position == OnClickItem) {
            holder.itemView.setBackgroundColor(Color.GREEN);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickItem = position;
                notifyDataSetChanged();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FjViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recom_Image)
        SimpleDraweeView recomImage;
        @BindView(R.id.recom_Name)
        TextView recomName;
        @BindView(R.id.recom_Ardess)
        TextView recomArdess;
        @BindView(R.id.text_dimens)
        TextView textDimens;

        public FjViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
