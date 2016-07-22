package com.xf.fruitloadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xf.fruitloadview.widget.FruitLoadView;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        FruitLoadView redApple = (FruitLoadView) findViewById(R.id.red_apple);
        FruitLoadView lemon = (FruitLoadView) findViewById(R.id.lemon);
        FruitLoadView blue_apple = (FruitLoadView) findViewById(R.id.blue_apple);
        FruitLoadView watermelon = (FruitLoadView) findViewById(R.id.watermelon);
        redApple.showLoading();
        lemon.showLoading();
        blue_apple.showLoading();
        watermelon.showLoading();
    }
}
