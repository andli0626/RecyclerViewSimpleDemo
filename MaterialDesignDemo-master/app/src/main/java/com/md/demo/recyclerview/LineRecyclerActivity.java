package com.md.demo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.md.demo.R;
import com.md.demo.recyclerview.adapter.RecyclerAdapter;
import com.md.demo.recyclerview.decoration.LineDividerDecoration;

import java.util.ArrayList;

/**
 * author andli
 * create at 16/10/12 下午5:26
 * 线性
 **/

public class LineRecyclerActivity extends AppCompatActivity {

    private Button  mAddItemBtn;
    private Button  mDelItemBtn;

    private RecyclerView                mRecyclerView;
    private RecyclerAdapter             mAdapter;
    private RecyclerView.LayoutManager  mRecyclerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_line);

        setTitle("线性 RecyclerView");

        initData();
        initView();
        initAction();
    }

    private void initData() {

        // 初始化 LinearLayoutManager
        mRecyclerManager    = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // 初始化 适配器
        mAdapter            = new RecyclerAdapter(getData());

        mAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 点击
                Toast.makeText(LineRecyclerActivity.this, "click "        + position + " item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // 长按
                Toast.makeText(LineRecyclerActivity.this, "long click "   + position + " item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 模拟数据
    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " 测试数据";
        for (int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }

    private void initView() {

        mAddItemBtn     = (Button)        findViewById(R.id.rv_add_item_btn);
        mDelItemBtn     = (Button)        findViewById(R.id.rv_del_item_btn);
        mRecyclerView   = (RecyclerView)  findViewById(R.id.my_recycler_view);

        // 设置布局管理器
        mRecyclerView.setLayoutManager(mRecyclerManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
        // 设置Item添加和移除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置Item之间间隔样式
        mRecyclerView.addItemDecoration(new LineDividerDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private void initAction() {
        mAddItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addNewItem();
                mRecyclerManager.scrollToPosition(0);
            }
        });
        mDelItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.deleteItem();
                mRecyclerManager.scrollToPosition(0);
            }
        });
    }



}
