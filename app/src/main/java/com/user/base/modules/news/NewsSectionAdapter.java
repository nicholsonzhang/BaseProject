package com.user.base.modules.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.base.library.imageloader.ImageLoader;
import com.user.base.R;
import com.user.base.modules.news.NewsHeaderViewHolder;
import com.user.base.modules.news.NewsItemViewHolder;
import com.user.base.widget.SectionedRecyclerViewAdapter;

/**
 * Created by nichol on 2017/9/16.
 */

public class NewsSectionAdapter extends SectionedRecyclerViewAdapter<NewsHeaderViewHolder,NewsItemViewHolder,RecyclerView.ViewHolder>{


    private String imageUril = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2434998280,2186154073&fm=26&gp=0.jpg";

    private Context mContext;
    private LayoutInflater mInflater;

    public NewsSectionAdapter(Context context){
       mContext = context;
        mInflater = LayoutInflater.from(mContext);

   }

    @Override
    protected int getSectionCount() {
        return 5;
    }

    @Override
    protected int getItemCountForSection(int section) {
        return section+1;
    }

    @Override
    protected boolean hasFooterInSection(int section) {
        return false;
    }

    @Override
    protected NewsHeaderViewHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        return new NewsHeaderViewHolder(mInflater.inflate(R.layout.item_header_news,parent,false));
    }

    @Override
    protected RecyclerView.ViewHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected NewsItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new NewsItemViewHolder(mInflater.inflate(R.layout.item_news,parent,false));
    }

    @Override
    protected void onBindSectionHeaderViewHolder(NewsHeaderViewHolder holder, int section) {
        holder.section.setText("第"+(section+1)+"分组");

    }

    @Override
    protected void onBindSectionFooterViewHolder(RecyclerView.ViewHolder holder, int section) {

    }

    @Override
    protected void onBindItemViewHolder(NewsItemViewHolder holder, int section, int position) {

        ImageLoader.display(mContext,imageUril,holder.content);

    }
}
