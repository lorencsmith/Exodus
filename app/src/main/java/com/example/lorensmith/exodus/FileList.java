package com.example.lorensmith.exodus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lorensmith.exodus.adapter.ListViewAdapter;

import java.util.ArrayList;

public class FileList extends BaseActivity implements View.OnTouchListener {
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
        ListViewAdapter fileViewAdapter = new ListViewAdapter(this, fileList);
        TextView header = new TextView(this);
        TextView footer = new TextView(this);
        header.setText("Files");
        header.setTextSize(36);
        header.setGravity(Gravity.CENTER);
        fileView.addHeaderView(header);
        footer.setText("EOF");
        footer.setTextSize(36);
        footer.setGravity(Gravity.CENTER);
        fileView.addFooterView(footer);
        fileView.setAdapter(fileViewAdapter);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return mGestureDetector.onTouchEvent(event);
    }
    /*onDown ->onShowPress->onLongPress*/
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {
//            UtilLog.logD("MyGesture", "onDown");

            toastShort("onDownPress");
            return true;
        }
        public void onShowPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }
        public void onLongPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
//            UtilLog.logD("MyGesture","onSingleTap");
            toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
//            UtilLog.logD("MyGesture","onSingleTapConfirmed");
            toastShort("onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
//            UtilLog.logD("MyGesture", "onScroll:" +(e2.getX()-e1.getX())+ "  " + distanceX );
            toastShort("onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            toastShort("onFling");
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
//            UtilLog.logD("MyGesture","onDoubleTap");
            toastShort("onDoubleTap");
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
//            UtilLog.logD("MyGesture","onDoubleTapEvent");
            toastShort("onDoubleTapEvent");
            return true;
        }
    }

}
