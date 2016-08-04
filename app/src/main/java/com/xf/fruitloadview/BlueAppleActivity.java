package com.xf.fruitloadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xf.fruitloadview.widget.FruitLoadView;

public class BlueAppleActivity extends AppCompatActivity {
    FruitLoadView mFruitLoadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_apple);
        mFruitLoadView = (FruitLoadView) findViewById(R.id.fruit);
        mFruitLoadView.showLoading();
    }

    @Override
    protected void onDestroy() {
        mFruitLoadView.hideLoading();
        super.onDestroy();
    }
}
