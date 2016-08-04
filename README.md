# FruitLoadView
This widget can be used as a load view.Enjoy it!
**Usage**

```
public class RedAppleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_apple);
        FruitLoadView fruitLoadView = (FruitLoadView) findViewById(R.id.fruit);
        fruitLoadView.showLoading();
    }
}
```
**Attrs**
you can custom some params in xml
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
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
        <attr name="fruitDrawable" format="reference" />
    </declare-styleable>
</resources>
```

**Gif**