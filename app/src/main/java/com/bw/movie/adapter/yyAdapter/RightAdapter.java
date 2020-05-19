package com.bw.movie.adapter.yyAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.yyBean.RightBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/18
 * author:王成虎(13671)
 * time:9:41
 * day:18
 * month:四月
 * function:
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {

    public int OnClickItem = 0;
    private List<RightBean.ResultBean> list;
    private Context context;

    public RightAdapter(List<RightBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_right_layout, parent, false);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
        holder.rightName.setText(list.get(position).getName());
        if (position == OnClickItem) {
            holder.itemView.setBackgroundColor(Color.RED);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
        holder.rightName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickItem = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.right_name)
        TextView rightName;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
