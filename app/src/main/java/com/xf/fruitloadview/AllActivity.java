package com.xf.fruitloadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xf.fruitloadview.widget.FruitLoadView;

public class AllActivity extends AppCompatActivity {
    FruitLoadView mRedApple;
    FruitLoadView mLemon;
    FruitLoadView mBlueApple;
    FruitLoadView mWatermelon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        FruitLoadView mRedApple = (FruitLoadView) findViewById(R.id.red_apple);
        FruitLoadView mLemon = (FruitLoadView) findViewById(R.id.lemon);
        FruitLoadView mBlueApple = (FruitLoadView) findViewById(R.id.blue_apple);
        FruitLoadView mWatermelon = (FruitLoadView) findViewById(R.id.watermelon);
        mRedApple.showLoading();
        mLemon.showLoading();
        mBlueApple.showLoading();
        mWatermelon.showLoading();
    }

    @Override
    protected void onDestroy() {
        mRedApple.hideLoading();
        mLemon.hideLoading();
        mBlueApple.hideLoading();
        mWatermelon.hideLoading();
        super.onDestroy();
    }
}
