package com.xf.fruitloadview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.xf.fruitloadview.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by X-FAN on 2016/7/19.
 */
public class FruitLoadView extends View {
    private final String TAG = "Fruit";
    private int mWidth;
    private int mHeight;
    private int mOvalW;
    private int mOvalH;
    private int mStartHeight;
    private int mFruitHeight;
    private int mFruitWidth;
    private int mIndex = 1;
    private int mLength;
    private boolean mIsDraw = false;
    private boolean mIsMutliMode = false;
    private float mMinScale;
    private float mAnimatedValue = 1.0f;
    private List<Drawable> mFruitDrawables;

    private Drawable mFruitDrawable;
    private ValueAnimator mDownAnimator;
    private ValueAnimator mUpAnimator;
    private Paint mPaint;
    private RectF mOvalRectF;


    public FruitLoadView(Context context) {
        this(context, null);
    }


    public FruitLoadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FruitLoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FruitLoadView);
        handleMultiDrawable(a);
        if (!mIsMutliMode) {
            mFruitDrawable = a.getDrawable(R.styleable.FruitLoadView_fruitDrawable);
            if (mFruitDrawable == null) {
                throw new NullPointerException("fruit drawable is null");
            }
        }
        int shadowColor = a.getColor(R.styleable.FruitLoadView_shadowColor, 0xFFE6E6E6);
        int animatorDuration = a.getInt(R.styleable.FruitLoadView_animatorDuration, 1000);
        int maxHeight = a.getDimensionPixelSize(R.styleable.FruitLoadView_maxHeight, 100);
        int fruitHeight = a.getDimensionPixelSize(R.styleable.FruitLoadView_fruitHeight, -1);
        int fruitWidth = a.getDimensionPixelSize(R.styleable.FruitLoadView_fruitWidth, -1);
        if (fruitHeight > 0) {
            mFruitHeight = fruitHeight;
        } else {
            mFruitHeight = mFruitDrawable.getIntrinsicHeight();
        }
        if (fruitWidth > 0) {
            mFruitWidth = fruitWidth;
        } else {
            mFruitWidth = mFruitDrawable.getIntrinsicWidth();
        }
        mOvalW = mFruitWidth / 2;
        mOvalH = (int) (mFruitHeight * 0.5) / 2;
        mStartHeight = mFruitHeight + maxHeight;
        mMinScale = (float) mFruitHeight / (float) mStartHeight;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(shadowColor);
        mOvalRectF = new RectF();
        initAnimator(animatorDuration);
        a.recycle();
    }

    /**
     * 处理多个drawable的情况
     *
     * @param a
     */
    private void handleMultiDrawable(TypedArray a) {
        int resId = a.getResourceId(R.styleable.FruitLoadView_fruitDrawableArray, -1);
        if (resId != -1) {
            Resources resources = getResources();
            TypedArray typedArray = resources.obtainTypedArray(resId);
            mFruitDrawables = new ArrayList<>();
            for (int i = 0; i < typedArray.length(); i++) {
                Drawable drawable = typedArray.getDrawable(i);
                mFruitDrawables.add(drawable);
            }
            if (!mFruitDrawables.isEmpty()) {
                mIsMutliMode = true;
                mFruitDrawable = mFruitDrawables.get(0);
                mLength = mFruitDrawables.size();
            }
            typedArray.recycle();
        }
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mIsDraw) {
            canvas.translate(mWidth / 2, mHeight / 2);// 将画布坐标原点移动到中心位置
            canvas.save();
            canvas.drawOval(mOvalRectF, mPaint);
            mFruitDrawable.setBounds(-mOvalW, (int) (-mStartHeight * mAnimatedValue), mOvalW, (int) (-(mStartHeight * mAnimatedValue - mFruitHeight)));
            mFruitDrawable.draw(canvas);
            canvas.restore();
        }

    }


    private void initAnimator(long duration) {
        mDownAnimator = ValueAnimator.ofFloat(1.0f, mMinScale).setDuration(duration / 2);
        mDownAnimator.setInterpolator(new DecelerateInterpolator());
        mDownAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimatedValue = (float) animation.getAnimatedValue();
                mOvalRectF = new RectF(-mOvalW * mAnimatedValue, -mOvalH * mAnimatedValue, mOvalW * mAnimatedValue, mOvalH * mAnimatedValue);
                invalidate();
            }
        });
        mDownAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mIsMutliMode) {
                    changeDrawable();
                }
                mUpAnimator.start();
            }
        });
        mDownAnimator.start();
        mUpAnimator = ValueAnimator.ofFloat(mMinScale, 1.0f).setDuration(duration / 2);
        mUpAnimator.setInterpolator(new DecelerateInterpolator());
        mUpAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimatedValue = (float) animation.getAnimatedValue();
                mOvalRectF = new RectF(-mOvalW * mAnimatedValue, -mOvalH * mAnimatedValue, mOvalW * mAnimatedValue, mOvalH * mAnimatedValue);
                invalidate();
            }
        });

        mUpAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mDownAnimator.start();
            }
        });
    }

    /**
     * 变更需要绘制的drawable
     */
    private void changeDrawable() {
        mFruitDrawable = mFruitDrawables.get(mIndex);
        if (mIndex < mLength - 1) {
            mIndex++;
        } else {
            mIndex = 0;
        }
    }


    /**
     * 是否正在展示
     *
     * @return
     */
    public boolean isShowing() {
        return mIsDraw;
    }

    /**
     * 展示
     */
    public void showLoading() {
        mIsDraw = true;
        mDownAnimator.start();
    }

    /**
     * 消失
     */
    public void hideLoading() {
        mIsDraw = false;
        mDownAnimator.cancel();
        mDownAnimator.end();
        mUpAnimator.cancel();
        mUpAnimator.end();
    }
}
