package com.example.momentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.momentdemo.adapter.MomentListAdapter;
import com.example.momentdemo.datamodel.MomentData;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SherlockActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ListView mListView;
    private List<MomentData> mMomentList=new ArrayList<MomentData>();
    private MomentListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionbar();


        //new HttpGetMomentData(MainActivity.this).getHttpMomentData();
        mMomentList.add(new MomentData(1,"raju"));
        mMomentList.add(new MomentData(1,"raju"));
        mMomentList.add(new MomentData(1,"raju"));
        mMomentList.add(new MomentData(1,"raju"));
        mMomentList.add(new MomentData(1,"raju"));
        mMomentList.add(new MomentData(1,"raju"));

        mListView = (ListView) findViewById(R.id.moment_listview);
        mAdapter=new MomentListAdapter(this,mMomentList);
        mListView.setAdapter(mAdapter);


    }

    private void initActionbar() {
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        View customNav = LayoutInflater.from(this).inflate(
                R.layout.custom_actionbar, null);

        getSupportActionBar().setCustomView(customNav);

    }


}
