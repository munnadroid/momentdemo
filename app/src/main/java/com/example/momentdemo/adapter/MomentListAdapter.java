package com.example.momentdemo.adapter;

/**
 * Created by munnadroid on 6/30/14.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.momentdemo.MainActivity;
import com.example.momentdemo.R;
import com.example.momentdemo.datamodel.MomentData;
import com.makeramen.RoundedImageView;

import java.util.List;

public class MomentListAdapter extends BaseAdapter {

    private static String TAG = MainActivity.TAG;
    private List<MomentData> mListData;
    private Context mContext;

    public MomentListAdapter(Context context, List<MomentData> listData) {

        this.mContext = context;
        this.mListData = listData;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return mListData.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return mListData.get(arg0);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return mListData.indexOf(getItem(position));
    }

    private class ViewHolder {

        RelativeLayout rowRelativeLayout;
        TextView titleTextView;
        TextView photoCountTextView;
        TextView videoCountTextView;
        TextView audioCountTextView;
        RoundedImageView profileImageView;
        TextView userNameTextView;


    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {

            LayoutInflater mInflator = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = mInflator.inflate(R.layout.moment_list_row, null);
            holder = new ViewHolder();

            holder.rowRelativeLayout = (RelativeLayout) rowView.findViewById(R.id.list_layout);
            holder.titleTextView = (TextView) rowView.findViewById(R.id.title_textview_list_row);
            holder.photoCountTextView = (TextView) rowView.findViewById(R.id.camera_textview_list_row);
            holder.videoCountTextView = (TextView) rowView.findViewById(R.id.video_textview_list_row);
            holder.audioCountTextView = (TextView) rowView.findViewById(R.id.audio_textview_list_row);
            holder.profileImageView = (RoundedImageView) rowView.findViewById(R.id.profile_imageview);
            holder.userNameTextView = (TextView) rowView.findViewById(R.id.username_textview_list_row);

            rowView.setTag(holder);
        } else
            holder = (ViewHolder) rowView.getTag();

        MomentData data = mListData.get(position);

        holder.titleTextView.setText(data.getTitle());
        holder.photoCountTextView.setText(String.valueOf(data.getPhotoCount()));
        holder.videoCountTextView.setText(String.valueOf(data.getVideoCount()));
        holder.audioCountTextView.setText(String.valueOf(data.getVideoCount()));
        holder.userNameTextView.setText(data.getUsername());


        return rowView;
    }
}