package com.example.lorensmith.exodus;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity{
    private final int MSG = 121;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case MSG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    toastShort("Option: "+s);
                    break;
                default:

            }
            super.handleMessage(msg);
        }
    };
    public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.rdb1:
            if (checked)
                toPics();
                break;
        case R.id.rdb2:
            if (checked)
                toFiles();
                break;
        case R.id.rdb3:
            if(checked)
                toAnimation();
                break;
        case R.id.rdb4:
            if(checked)
                toCustom();
                break;

    }
}




    private void toAnimation() {
        toActivity(AnimationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("msg", "To Animation");
        Message msg = Message.obtain();
        msg.what = MSG;
        msg.setData(bundle);
        mHandler.sendMessage(msg);
    }

    private void toFiles() {
        toActivity(FileList.class);
        Bundle bundle = new Bundle();
        bundle.putString("msg", "To Files List");
        Message msg = Message.obtain();
        msg.what = MSG;
        msg.setData(bundle);
        mHandler.sendMessage(msg);
        }

    private void toPics() {
        toActivity(PictureGallery.class);
        Bundle bundle = new Bundle();
        bundle.putString("msg", "To Picture Gallery");
        Message msg = Message.obtain();
        msg.what = MSG;
        msg.setData(bundle);
        mHandler.sendMessage(msg);

    }

    private void toCustom(){

            final Custom dialog = new Custom(this, new Custom.ICustomDialogEventListener() {

                @Override
                public void onClickListener () {
                    Intent intent = new Intent();
                    intent.putExtra("message", "Dialog");
                    setResult(RESULT_OK, intent);
                }
            });
            dialog.show();
        Bundle bundle = new Bundle();
        bundle.putString("msg", "To Custom");
        Message msg = Message.obtain();
        msg.what = MSG;
        msg.setData(bundle);
        mHandler.sendMessage(msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }



}
