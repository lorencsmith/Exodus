package com.example.lorensmith.exodus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by lorensmith on 4/10/17.
 */

class BaseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void toActivity(Class name){
        Intent intent = new Intent(this, name);
        startActivity(intent);

    }

    public void toastLong(String content){
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void toastShort(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
