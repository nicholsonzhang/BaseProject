package com.user.base.modules.mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.base.library.imageloader.ImageLoader;
import com.user.base.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
//    private String url = "https://static.phi-go.com/data/upload/mall/store/goods/19/19_05769516683302882.png";


    public TestRecyclerViewAdapter(Context context) {

        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_test_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        ImageLoader.display(mContext,url,holder.pic);
        holder.name.setText("迪丽热巴");
        holder.price.setText("27");

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pic)
        ImageView pic;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
