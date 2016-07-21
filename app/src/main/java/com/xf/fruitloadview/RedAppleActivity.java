package com.xf.fruitloadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xf.fruitloadview.widget.FruitLoadView;

public class RedAppleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_apple);
        FruitLoadView fruitLoadView = (FruitLoadView) findViewById(R.id.fruit);
        fruitLoadView.showLoading();
    }
}
