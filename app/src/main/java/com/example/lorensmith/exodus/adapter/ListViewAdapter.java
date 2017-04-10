package com.example.lorensmith.exodus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lorensmith.exodus.R;
import com.example.lorensmith.exodus.util.UtilDensity;

import java.util.ArrayList;

/**
 * Created by Loren Smith on 4/7/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private final LayoutInflater mInflater;
    private final ArrayList<String> fileList;


    public ListViewAdapter(Context context, ArrayList<String> listResult){
        this.mContext = context;
        this.fileList = listResult;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return fileList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView== null){
            convertView = mInflater.inflate(R.layout.file_item, parent, false);
            holder = new ViewHolder();
            holder.textView1 = (TextView) convertView.findViewById(R.id.list_view_tv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
            holder.textView1.setText(fileList.get(position));
            holder.textView1.setVisibility(View.VISIBLE);
            holder.lp.setMargins(UtilDensity.dip2px(mContext,50), 0, 0, 0);
            holder.lp.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        return convertView;
    }
}

class ViewHolder{
    TextView textView1;

    RelativeLayout.LayoutParams lp = new
            RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
}

