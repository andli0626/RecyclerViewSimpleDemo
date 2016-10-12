package com.md.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * author andli
 * create at 16/10/12 下午5:09
 * 首页
 **/

public class MDMainActivity extends Activity implements View.OnClickListener {

    private CardView mToRvBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initAction();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.to_rv_page_btn) {
            goToRvPage();
        }
    }

    private void initView() {
        mToRvBtn = (CardView) findViewById(R.id.to_rv_page_btn);
    }

    private void initAction() {
        mToRvBtn.setOnClickListener(this);
    }

    private void goToRvPage() {
        Intent intent = new Intent(this, MDMainSubActivity.class);
        startActivity(intent);
    }
}
