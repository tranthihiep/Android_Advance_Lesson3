package com.haha.imagegallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Bitmap> mImageGallery = new ArrayList<>();
    @Override
     protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                loadImageFromSD();
                initView(mRecyclerView);
            }
    private void loadImageFromSD() {
        String path = Environment.getExternalStorageDirectory().getPath()+"/Download";
        File file = new File(path);
        File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    Bitmap bitmap = BitmapFactory.decodeFile(files[i].getPath());
                    mImageGallery.add(bitmap);
                   }
            }

    private void initView(RecyclerView recyclerView){
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        AdapterImage adapter = new AdapterImage(mImageGallery,this);
        mRecyclerView.setAdapter(adapter);
        AdapterImage mAdapterHero = new AdapterImage(mImageGallery,getApplicationContext());
        recyclerView.setAdapter(mAdapterHero);
    }
}

