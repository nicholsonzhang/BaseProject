package com.user.base.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
    }


    public static ViewHolder createViewHolder(View itemView) {

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }
}
