package com.xf.fruitloadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xf.fruitloadview.widget.FruitLoadView;

public class LemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemon);
        FruitLoadView fruitLoadView = (FruitLoadView) findViewById(R.id.fruit);
        fruitLoadView.showLoading();
    }
}
