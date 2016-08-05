# FruitLoadView
This widget can be used as a load view.Enjoy it!

**Usage**
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.xf.fruitloadview.RedAppleActivity">

    <com.xf.fruitloadview.widget.FruitLoadView
        android:id="@+id/fruit"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:fruitDrawable="@drawable/red_apple"
        app:shadowColor="@color/red_apple" />
</RelativeLayout>
```
```
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
        mFruitLoadView.hideLoading();//ensure you call this method or it will cause leak memory
        super.onDestroy();
    }
}
```
if you don't set some params,it will be set some default params in FruitLoadView

**Attrs**

you can custom some params in xml
```
    <declare-styleable name="FruitLoadView">
        <!--阴影的颜色-->
        <attr name="shadowColor" format="color" />
        <!--弹起的最大高度-->
        <attr name="maxHeight" format="dimension" />
        <!--图片的高度-->
        <attr name="fruitHeight" format="dimension" />
        <!--图片的宽度-->
        <attr name="fruitWidth" format="dimension" />
        <!--一次循环的动画时间-->
        <attr name="animatorDuration" format="integer" />
        <!--指定一个drawable-->
        <attr name="fruitDrawable" format="reference" />
        <!--指定一组drawable-->
        <attr name="fruitDrawableArray" format="reference" />
    </declare-styleable>
```

**Gif**
 attr:fruitDrawable
![Alt Text](https://github.com/X-FAN/resource/blob/master/gif/fruit.gif)
 attr:fruitDrawableArray
![Alt Text](https://github.com/X-FAN/resource/blob/master/gif/multi.gif)
