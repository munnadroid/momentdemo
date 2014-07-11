package com.example.momentdemo.http;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.example.momentdemo.MainActivity;
import com.example.momentdemo.adapter.MomentListAdapter;
import com.example.momentdemo.datamodel.MomentData;
import com.example.momentdemo.util.Util;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

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

    public HttpGetMomentData(Context context, ListView listView) {
        this.mContext = context;
        this.mListView = listView;
    }


    public void getHttpMomentData() {
        AsyncHttpClient myClient = new AsyncHttpClient();
        myClient.setTimeout(60 * 1000);
        myClient.get(MOMENT_GET_URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                String response = new String(bytes);
                Log.v(MainActivity.TAG, "moment success response: " + response);

                mMomentList.add(new MomentData(1, "Imurdaian", "Chanelle", "", "", 3, 0, 0));
                mMomentList.add(new MomentData(2, "skeletales", "Pancakes, Salmons and Coffee", "", "", 5, 0, 0));
                mMomentList.add(new MomentData(1, "Imurdaian", "Chanelle", "", "", 3, 0, 0));
                mMomentList.add(new MomentData(2, "skeletales", "Pancakes, Salmons and Coffee", "", "", 5, 0, 0));

                mAdapter = new MomentListAdapter(mContext, mMomentList);
                mListView.setAdapter(mAdapter);


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
}
