package com.xf.fruitloadview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xf.fruitloadview.widget.FruitLoadView;

public class MultiFruitActivity extends AppCompatActivity {
    private FruitLoadView mFruitLoadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_fruit);
        mFruitLoadView = (FruitLoadView) findViewById(R.id.fruit);
        mFruitLoadView.showLoading();
    }

    @Override
    protected void onDestroy() {
        mFruitLoadView.hideLoading();
        super.onDestroy();
    }
}
