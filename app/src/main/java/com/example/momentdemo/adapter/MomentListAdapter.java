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

import com.example.momentdemo.MainActivity;
import com.example.momentdemo.R;
import com.example.momentdemo.datamodel.MomentData;
import com.makeramen.RoundedImageView;
import com.squareup.picasso.Picasso;

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

        ImageView backgroundImageView;
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

            holder.backgroundImageView = (ImageView) rowView.findViewById(R.id.user_bg_list_row);
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
        int photoCount = data.getPhotoCount();
        int videoCount = data.getVideoCount();
        int audioCount = data.getVideoCount();
        holder.photoCountTextView.setText(String.valueOf(photoCount));
        holder.videoCountTextView.setText(String.valueOf(videoCount));
        holder.audioCountTextView.setText(String.valueOf(audioCount));

        int countEmptyTextColor = mContext.getResources().getColor(R.color.count_empty_text_color);
        int countTextColor = mContext.getResources().getColor(R.color.count_text_color);
        if (photoCount == 0) {
            holder.photoCountTextView.setTextColor(countEmptyTextColor);
            holder.photoCountTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.camera_listrow_empty, 0);
        } else {
            holder.photoCountTextView.setTextColor(countTextColor);
            holder.photoCountTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.camera_listrow, 0);
        }

        if (videoCount == 0) {
            holder.videoCountTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.video_camera_listrow_empty, 0);
            holder.videoCountTextView.setTextColor(countEmptyTextColor);
        } else {
            holder.videoCountTextView.setTextColor(countTextColor);
            holder.videoCountTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.video_camera_listrow, 0);
        }

        if (audioCount == 0) {
            holder.audioCountTextView.setTextColor(countEmptyTextColor);
            holder.audioCountTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.audio_list_row_empty, 0);
        } else {
            holder.audioCountTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.audio_list_row, 0);
            holder.audioCountTextView.setTextColor(countTextColor);
        }

        holder.userNameTextView.setText(data.getUsername());

        Picasso.with(mContext)
                .load(data.getAvatarImageUrl())
                .placeholder(R.drawable.profile_placeholder)
                .into(holder.profileImageView);

        Picasso.with(mContext)
                .load(data.getBackgroundImageUrl())
                .placeholder(R.drawable.background_placeholder)
                .into(holder.backgroundImageView);


        return rowView;
    }
}