package com.khai.khailqph05639_mob201_assignment.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.khai.khailqph05639_mob201_assignment.R;
import com.khai.khailqph05639_mob201_assignment.news.NewActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imgCourse;
    private ImageView imgMaps;
    private ImageView imgNews;
    private ImageView imgSocial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        imgCourse = (ImageView) findViewById(R.id.imgCourse);
        imgMaps = (ImageView) findViewById(R.id.imgMaps);
        imgNews = (ImageView) findViewById(R.id.imgNews);
        imgSocial = (ImageView) findViewById(R.id.imgSocial);

        imgCourse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( MainActivity.this,HocTapActivity.class );
                startActivity( intent );
            }
        } );
        imgMaps.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission( MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION )!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions( MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},6 );
                }
                else {
                Intent intent= new Intent( MainActivity.this,MapsActivity.class );
                startActivity( intent );
            }}
        } );
        imgNews.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( MainActivity.this,NewActivity.class );
                startActivity( intent );
            }
        } );
        imgSocial.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( MainActivity.this,FacebookActivity.class );
                startActivity( intent );
            }
        } );
    }
}
