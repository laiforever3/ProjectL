package lai.com.projectl.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import lai.com.projectl.R;

/**
 * Created by admin on 2015/8/24.
 */
public class CustomTitleViewTwo extends View {

    private String mTitleText;
    private int mTitleSize = 30;
    private int mTitleColor = 0xFF666666;

    private Paint mPaint;
    private Rect mBound;

    public CustomTitleViewTwo(Context context) {
        this(context, null);
    }

    public CustomTitleViewTwo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleViewTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleView);

        mTitleText = a.getString(R.styleable.CustomTitleView_titleText);
        mTitleColor = a.getColor(R.styleable.CustomTitleView_titleColor, mTitleColor);
        mTitleSize = a.getDimensionPixelSize(R.styleable.CustomTitleView_titleSize, mTitleSize);

        a.recycle();

        mPaint = new Paint();
        mBound = new Rect();

        mPaint.setTextSize(mTitleSize);
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int w = getContext().getResources().getDimensionPixelSize(R.dimen.wubai_dp);
        Log.e("lai", "w=" + w);
        Log.e("lai", "widthMode=" + widthMode + "widthSize=" + widthSize);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(mTitleSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

            width = getPaddingLeft() + mBound.width() + getPaddingRight();
        }
        Log.e("lai", "width=" + width + "");
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTitleSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            Log.e("lai", "mBound.height=" + mBound.height() + "");
            height = getPaddingTop() + mBound.height() + getPaddingBottom();
        }
        Log.e("lai", "height=" + height + "");
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setColor(getResources().getColor(R.color.red_one));
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        Log.e("lai", "getWidth()=" + getWidth());
        Log.e("lai", "getHeight()=" + getHeight());
        mPaint.setColor(Color.BLUE);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

    }
}
