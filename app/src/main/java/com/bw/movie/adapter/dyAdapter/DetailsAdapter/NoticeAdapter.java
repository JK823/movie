package com.bw.movie.adapter.dyAdapter.DetailsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.syBean.Details.DetailsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * date:2020/5/8
 * author:王成虎(13671)
 * time:21:04
 * day:08
 * month:五月
 * function:预告
 */
public class NoticeAdapter  extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private List<DetailsBean.ResultBean.ShortFilmListBean> list;
    private Context context;

    public NoticeAdapter(List<DetailsBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_notice_layout, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        //holder.jcvMv.setUp(list.get(position).getVideoUrl(),"预告"+"("+(position+1)+")");
        //Glide.with(context).load(list.get(position).getVideoUrl()).into(holder.jcvMv.ivThumb);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.jcv_mv)
        JCVideoPlayer jcvMv;
        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
