package com.xf.fruitloadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xf.fruitloadview.widget.FruitLoadView;

public class RedAppleActivity extends AppCompatActivity {

    FruitLoadView mFruitLoadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_apple);
        mFruitLoadView = (FruitLoadView) findViewById(R.id.fruit);
        mFruitLoadView.showLoading();
    }

    @Override
    protected void onDestroy() {
        mFruitLoadView.hideLoading();
        super.onDestroy();
    }
}
