package com.example.lorensmith.exodus;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lorensmith.exodus.adapter.picAdapter;
import com.example.lorensmith.exodus.adapter.picFolder.Chase;
import com.example.lorensmith.exodus.adapter.picFolder.Exodus;
import com.example.lorensmith.exodus.adapter.picFolder.Moses;
import com.example.lorensmith.exodus.adapter.picFolder.overlook;

import java.util.ArrayList;

public class PictureGallery extends AppCompatActivity {
    private ViewPager pics;
    private ArrayList<Fragment> picList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_gallery);
        initial();
    }

    private void initial() {
        pics = (ViewPager) findViewById(R.id.pic_gallery);
        picList.add(new Exodus());
        picList.add(new Moses());
        picList.add(new overlook());
        picList.add(new Chase());
        picAdapter picAdapter= new picAdapter(this.getSupportFragmentManager());
        picAdapter.setContent(picList);
        pics.setAdapter(picAdapter);
    }

    @Override
    public void onStart(){
        super.onStart();
    }
}
