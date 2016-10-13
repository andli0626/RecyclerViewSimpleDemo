package com.md.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.md.demo.recyclerview.GridRecyclerActivity;
import com.md.demo.recyclerview.LineRecyclerActivity;
import com.md.demo.recyclerview.StaggeredRecyclerActivity;

/**
 * author andli
 * create at 16/10/12 下午5:19
 * 导航窗口
 **/

public class MainActivity extends Activity {

    private Button mToLinearRvPageBtn;

    private Button mToGridRvPageBtn;

    private Button mToStaggeredRvPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAction();
    }

    private void initView() {
        mToLinearRvPageBtn      = (Button) findViewById(R.id.to_linear_rv_page_btn);
        mToGridRvPageBtn        = (Button) findViewById(R.id.to_grid_rv_page_btn);
        mToStaggeredRvPageBtn   = (Button) findViewById(R.id.to_staggered_rv_page_btn);
    }

    private void initAction() {

        // 线性
        mToLinearRvPageBtn      .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LineRecyclerActivity.class);
                startActivity(intent);
            }
        });

        // 网格
        mToGridRvPageBtn        .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridRecyclerActivity.class);
                startActivity(intent);
            }
        });

        // 瀑布
        mToStaggeredRvPageBtn   .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaggeredRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
