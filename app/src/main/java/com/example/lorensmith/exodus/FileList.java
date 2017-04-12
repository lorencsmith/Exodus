package com.example.lorensmith.exodus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorensmith.exodus.adapter.ListViewAdapter;
import com.example.lorensmith.exodus.util.UtilLog;

import java.util.ArrayList;

/**
 * Created by lorensmith on 4/7/17.
 */

public class FileList extends BaseActivity implements View.OnTouchListener  {
    private ListView fileView;
    private ArrayList<String> fileList;
    private GestureDetector mGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);
        fileList = new ArrayList<String>();
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        createFileList();
        initialView();

    }

    private void createFileList() {
        for(int i = 1; i <= 26; i++){
            fileList.add("File " + String.valueOf(i));
        }
    }

    private void initialView() {
        fileView = (ListView) findViewById(R.id.file_list);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, fileList);
        TextView header = new TextView(this);
        header.setText("File List");
        header.setTextSize(28);
        header.setGravity(Gravity.CENTER);
        header.setTextColor(Color.GREEN);
        fileView.addHeaderView(header);

        TextView footer = new TextView(this);
        footer.setText("EOF");
        footer.setTextSize(28);
        footer.setGravity(Gravity.CENTER);
        footer.setTextColor(Color.RED);
        fileView.addFooterView(footer);
        fileView.setAdapter(listViewAdapter);
        fileView.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            toastShort("FileList");
        }else if(position == 27){
            toastShort("EOF");
        }else {
            toastShort("File # " + String.valueOf(position) + " clicked.");
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return mGestureDetector.onTouchEvent(event);
    }

    /*onDown ->onShowPress->onLongPress*/
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {

            toastShort("onDownPress");
            return true;
        }
        public void onShowPress(MotionEvent e){

            toastShort("onShowPress");
        }
        public void onLongPress(MotionEvent e){

            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){

            toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){

            toastShort("onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){

            toastShort("onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (e1.getX() > e2.getX()) {
                UtilLog.logD("MyGesture", "Swiped Left");
            }
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){

            toastShort("onDoubleTap");
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort("onDoubleTapEvent");
            return true;
        }
    }

}
