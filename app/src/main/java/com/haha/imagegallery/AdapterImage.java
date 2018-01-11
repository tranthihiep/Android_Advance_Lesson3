package com.haha.imagegallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by trant on 11/01/2018.
 */

public class AdapterImage extends RecyclerView.Adapter<AdapterImage.ViewHolder>{
    private ArrayList<Bitmap> mAdapter = new ArrayList<>();
    private Context context;

    public AdapterImage(ArrayList<Bitmap> mAdapter, Context context) {
        this.mAdapter = mAdapter;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.row_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mAdapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
        }
        public void setData(int pos){
            mImageView.setImageBitmap(mAdapter.get(pos));
        }
    }
}
