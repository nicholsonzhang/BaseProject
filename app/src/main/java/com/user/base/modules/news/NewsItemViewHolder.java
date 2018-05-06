package com.user.base.modules.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.user.base.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nichol on 2017/9/16.
 */

public class NewsItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.content)
    ImageView content;


    public NewsItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
