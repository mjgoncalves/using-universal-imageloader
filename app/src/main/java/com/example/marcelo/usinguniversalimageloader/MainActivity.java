package com.example.marcelo.usinguniversalimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    UniversalImageloader universalImageloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        universalImageloader = new UniversalImageloader(this);
        ImageLoader.getInstance().init(universalImageloader.getConfig());
        setupProfileImage();
        setupGridImages();

    }

    private void setupProfileImage(){
        ImageView profilePhoto = findViewById(R.id.profilePhoto);
        String imgURL = "http://www.bitmaniax.com/images/news/musica-android.jpg";
        universalImageloader.setupImage("", imgURL, profilePhoto, null);


    }

    private void setupGridImages(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("https://abrilviagemeturismo.files.wordpress.com/2016/12/11-120241176.jpg?quality=70&strip=info&w=680&h=453&crop=1");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("http://travelzom.com/wp-content/uploads/2017/06/bali-indonesia-2.jpg");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("https://abrilviagemeturismo.files.wordpress.com/2016/12/11-120241176.jpg?quality=70&strip=info&w=680&h=453&crop=1");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("http://1.bp.blogspot.com/-gB55QpVTLW4/VpjLCZOT5FI/AAAAAAAAk8s/kpOjWY5_ec0/s1600/IMG_3075.JPG");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        imgURLs.add("https://abrilviagemeturismo.files.wordpress.com/2016/12/11-120241176.jpg?quality=70&strip=info&w=680&h=453&crop=1");
        imgURLs.add("https://cdn.cheapoguides.com/wp-content/uploads/sites/3/2017/09/Otagi-Nenbutsu-ji-Shrine.jpg");
        setupGridView(imgURLs);
    }

    private void setupGridView(ArrayList<String> imgURLs){

        GridView gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter =  new GridAdapter(this, R.layout.gridview_model, "", imgURLs);
        gridView.setAdapter(gridAdapter);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth / 3;
        gridView.setColumnWidth(imageWidth);
    }
}
