package com.md.demo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.md.demo.R;
import com.md.demo.recyclerview.adapter.RecyclerAdapter;
import com.md.demo.recyclerview.decoration.GridDividerDecoration;
import com.md.demo.recyclerview.mock.MDMockData;

/**
 * grid {@link RecyclerView} page
 *
 * Created by wangkegang on 2016/07/05 .
 */
public class GridRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);

        initData();
        initView();
    }

    private void initData() {
        // 竖直方向的网格样式，每行四个Item
        mLayoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);

        mAdapter = new RecyclerAdapter(MDMockData.getRvData());
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new GridDividerDecoration(this));

    }
}
