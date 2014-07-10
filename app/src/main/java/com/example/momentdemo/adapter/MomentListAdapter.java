package com.example.momentdemo.adapter;

/**
 * Created by munnadroid on 6/30/14.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.momentdemo.R;
import com.example.momentdemo.datamodel.MomentData;

import java.util.List;

public class MomentListAdapter extends BaseAdapter {

    private static String tag = MomentListAdapter.class.getSimpleName();
    private List<MomentData> listData;
    private Context context;

    public MomentListAdapter(Context context, List<MomentData> listData) {

        this.context = context;
        this.listData = listData;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return listData.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listData.get(arg0);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return listData.indexOf(getItem(position));
    }

    private class ViewHolder {

        ImageView contentImageView;
        ImageView profileImageView;
        TextView contentTextView;
        TextView likeCountTextView;
        TextView commentCountTextView;


    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {

            LayoutInflater mInflator = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = mInflator.inflate(R.layout.moment_list_row, null);
            holder = new ViewHolder();


            rowView.setTag(holder);
        } else
            holder = (ViewHolder) rowView.getTag();


        return rowView;
    }
}