package com.user.base.modules.mine;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.user.base.utils.ViewHolder;

public class RecyclerViewWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_HEADER = 100000;
    private static final int ITEM_TYPE_FOOTER = 200000;
    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFooterViews = new SparseArrayCompat<>();

    private RecyclerView.Adapter mInnerAdapter;

    public RecyclerViewWrapper(RecyclerView.Adapter adapter) {
        mInnerAdapter = adapter;
    }

    public void addHeadView(View view) {
        mHeaderViews.put(mHeaderViews.size() + ITEM_TYPE_HEADER, view);
    }

    public void addFooterView(View view) {
        mFooterViews.put(mFooterViews.size() + ITEM_TYPE_FOOTER, view);
    }


    private boolean isHeaderView(int position) {
        return position < mHeaderViews.size();
    }

    private boolean isFooterView(int position) {
        return position >= getHeaderCount() + getRealItemCount();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mHeaderViews.get(viewType) != null){

            return ViewHolder.createViewHolder(mHeaderViews.get(viewType));
        }else if (mFooterViews.get(viewType) != null){
            return ViewHolder.createViewHolder(mFooterViews.get(viewType));
        }

        return mInnerAdapter.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (isHeaderView(position)){
            return;
        }
        if (isFooterView(position)){
            return;
        }
        mInnerAdapter.onBindViewHolder(holder,position);

    }

    @Override
    public int getItemViewType(int position) {

        if (isHeaderView(position)) {
            return mHeaderViews.keyAt(position);
        } else if (isFooterView(position)) {
            return mFooterViews.keyAt(position - getHeaderCount() - getRealItemCount());
        }
        return mInnerAdapter.getItemViewType(position - getHeaderCount());
    }

    @Override
    public int getItemCount() {
        return getHeaderCount() + getRealItemCount() + getFooterCount();
    }

    private int getRealItemCount() {
        return mInnerAdapter.getItemCount();
    }

    public int getHeaderCount() {
        return mHeaderViews.size();
    }

    public int getFooterCount() {
        return mFooterViews.size();
    }
}
