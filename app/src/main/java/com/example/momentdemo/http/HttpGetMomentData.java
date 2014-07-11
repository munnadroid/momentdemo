package com.example.momentdemo.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.example.momentdemo.MainActivity;
import com.example.momentdemo.adapter.MomentListAdapter;
import com.example.momentdemo.datamodel.MomentData;
import com.example.momentdemo.util.Constants;
import com.example.momentdemo.util.Util;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by munnadroid on 7/10/14.
 */
public class HttpGetMomentData {
    private final static String MOMENT_GET_URL = "http://momentage-api-staging.herokuapp.com/v1/moments/featured";

    private Context mContext;
    private ListView mListView;
    private List<MomentData> mMomentList = new ArrayList<MomentData>();
    private MomentListAdapter mAdapter;
    private ProgressDialog mDialog;

    private List<Integer> photoCountList;
    private List<Integer> videoCountList;
    private List<Integer> audioCountList;

    public HttpGetMomentData(Context context, ListView listView) {
        this.mContext = context;
        this.mListView = listView;
    }


    public void getHttpMomentData() {
        AsyncHttpClient myClient = new AsyncHttpClient();
        myClient.setTimeout(60 * 1000);
        myClient.get(MOMENT_GET_URL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                mDialog = new ProgressDialog(mContext);
                mDialog.setMessage("loading data...");
                mDialog.setTitle("");
                mDialog.show();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (mDialog != null)
                    mDialog.dismiss();
            }

            @Override
            public void onSuccess(int x, Header[] headers, byte[] bytes) {

                String response = new String(bytes);
//                Log.v(MainActivity.TAG, "moment success response: " + response);


                try {
                    JSONObject mainObject = new JSONObject(response);
                    JSONArray momentArray = mainObject.getJSONArray(Constants.KEY_MOMENTS);
                    Log.v(MainActivity.TAG, "moment array: " + momentArray.toString());

                    for (int a = 0; a < momentArray.length(); a++) {

                        photoCountList = new ArrayList<Integer>();
                        videoCountList = new ArrayList<Integer>();
                        audioCountList = new ArrayList<Integer>();

                        JSONObject object = momentArray.getJSONObject(a);

                        //get moment id and title
                        int momentId = object.getInt(Constants.KEY_MOMENT_ID);
                        String momentTitle = object.getString(Constants.KEY_TITLE);
                        JSONArray momentItemArray = object.getJSONArray(Constants.KEY_MOMENT_ITEMS);

                        //get moment items title and item type
                        for (int b = 0; b < momentItemArray.length(); b++) {
                            JSONObject itemObject = momentItemArray.getJSONObject(b);

                            int momentItemId = itemObject.getInt(Constants.KEY_MOMENT_ITEMS_ID);
                            String momentItemType = itemObject.getString(Constants.KEY_MOMENT_ITEMS_TYPE);

                            if (momentItemType.equalsIgnoreCase(Constants.TAG_PHOTO_TYPE))
                                photoCountList.add(momentItemId);
                            else if (momentItemType.equalsIgnoreCase(Constants.TAG_VIDEO_TYPE))
                                videoCountList.add(momentItemId);
                            else if (momentItemType.equalsIgnoreCase(Constants.TAG_AUDIO_TYPE))
                                videoCountList.add(momentItemId);

                        }


                        //get user id and other user details
                        JSONObject userObject = object.getJSONObject(Constants.KEY_USER);

                        int userId = userObject.getInt(Constants.KEY_USER_ID);
                        String userName = userObject.getString(Constants.KEY_USER_NAME);
                        String profileImageUrl = userObject.getString(Constants.KEY_USER_AVATAR);
                        String backgroundImageUrl = userObject.getString(Constants.KEY_BACKGROUND);


                        mMomentList.add(new MomentData(momentId, userName, momentTitle, profileImageUrl, backgroundImageUrl
                                , photoCountList.size(), videoCountList.size(), audioCountList.size()));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if (mMomentList.size() > 0)
                    populateListView();


            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                try {
                    Util.showToast(mContext, "Error while fetching data...");
                    String response = new String(bytes);
                    Log.v(MainActivity.TAG, "moment failure response: " + response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void populateListView() {

        mAdapter = new MomentListAdapter(mContext, mMomentList);
        mListView.setAdapter(mAdapter);
    }
}
