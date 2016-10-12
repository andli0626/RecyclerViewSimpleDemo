package com.md.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.md.demo.MDBaseActivity;
import com.md.demo.R;
import com.md.demo.recyclerview.MDGridRvActivity;
import com.md.demo.recyclerview.MDLinearRvActivity;
import com.md.demo.recyclerview.MDStaggeredRvActivity;

/**
 * author andli
 * create at 16/10/12 下午5:19
 * 导航窗口
 **/

public class MDMainSubActivity extends MDBaseActivity {

    private TextView mToLinearRvPageBtn;

    private TextView mToGridRvPageBtn;

    private TextView mToStaggeredRvPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_main);

        initView();
        initAction();
    }

    private void initView() {
        mToLinearRvPageBtn      = (TextView) findViewById(R.id.to_linear_rv_page_btn);
        mToGridRvPageBtn        = (TextView) findViewById(R.id.to_grid_rv_page_btn);
        mToStaggeredRvPageBtn   = (TextView) findViewById(R.id.to_staggered_rv_page_btn);
    }

    private void initAction() {

        // 线性
        mToLinearRvPageBtn      .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MDMainSubActivity.this, MDLinearRvActivity.class);
                startActivity(intent);
            }
        });

        // 网格
        mToGridRvPageBtn        .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MDMainSubActivity.this, MDGridRvActivity.class);
                startActivity(intent);
            }
        });

        // 瀑布
        mToStaggeredRvPageBtn   .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MDMainSubActivity.this, MDStaggeredRvActivity.class);
                startActivity(intent);
            }
        });
    }
}
