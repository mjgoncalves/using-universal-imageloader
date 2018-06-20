package com.example.marcelo.usinguniversalimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<String> {

    private Context context;
    private String append;
    private LayoutInflater layoutInflater;
    private int layoutResource;
    private ArrayList<String> imgURLs;

    public GridAdapter(Context context,  int layoutResource, String append, ArrayList<String> imgURLs) {
        super(context, layoutResource, imgURLs);
        this.context = context;
        this.append = append;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutResource = layoutResource;
        this.imgURLs = imgURLs;
    }

    private class ViewHolder{

        SquareImageView images;
        ProgressBar progressBar;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null){
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.progressBar = convertView.findViewById(R.id.gridProgressBar);
            viewHolder.images = convertView.findViewById(R.id.gridImages);
            convertView.setTag(viewHolder);

        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        String imgURL = getItem(position);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(append + imgURL, viewHolder.images, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (viewHolder.progressBar != null){

                    viewHolder.progressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                if (viewHolder.progressBar != null){

                    viewHolder.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (viewHolder.progressBar != null){

                    viewHolder.progressBar.setVisibility(View.GONE);
                }
            }
            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (viewHolder.progressBar != null){

                    viewHolder.progressBar.setVisibility(View.GONE);
                }

            }

        });
        return convertView;
    }
}



























