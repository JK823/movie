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
import com.bw.movie.bean.yyBean.LeftBean;
import com.bw.movie.util.Event;

import org.greenrobot.eventbus.EventBus;

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
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {

    public int OnClickItem = 0;
    private List<LeftBean.ResultBean> list;
    private Context context;

    public LeftAdapter(List<LeftBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left_layout, parent, false);
        return new LeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        holder.leftName.setText(list.get(position).getRegionName());
        if (position == OnClickItem) {
            holder.itemView.setBackgroundColor(Color.BLUE);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
        holder.leftName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event();
                int regionId = list.get(position).getRegionId();
                event.id = regionId;
                EventBus.getDefault().post(event);
                OnClickItem = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.left_name)
        TextView leftName;
        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
