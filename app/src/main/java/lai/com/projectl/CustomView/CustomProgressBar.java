package lai.com.projectl.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import lai.com.projectl.R;

/**
 * Created by admin on 2015/8/24.
 */
public class CustomProgressBar extends View {

    private int mFirstColor;
    private int mSecondColor;
    private int mCircleWidth;
    private Paint mPaint;
    private int mProgress;
    private int mSpeed;
    private boolean isNext;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);

        mFirstColor = a.getColor(R.styleable.CustomProgressBar_firstColor, mFirstColor);
        mSecondColor = a.getColor(R.styleable.CustomProgressBar_secondColor, mSecondColor);
        mCircleWidth = a.getDimensionPixelSize(R.styleable.CustomProgressBar_circleWidth, mCircleWidth);
        mSpeed = a.getInt(R.styleable.CustomProgressBar_speed, mSpeed);

        a.recycle();
        mPaint = new Paint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mProgress++;
                if (mProgress == 360) {
                    mProgress = 0;
                    if (!isNext) {
                        isNext = true;
                    } else {
                        isNext = false;
                    }
                }
                postInvalidate();
                try {
                    Thread.sleep(mSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        int center = getWidth() / 2;
        int radius = center - mCircleWidth / 2;
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

        RectF ovl = new RectF();
        ovl.set(center - radius, center - radius, center + radius, center + radius);
        if (!isNext) {
            mPaint.setColor(mFirstColor);
            canvas.drawCircle(center, center, radius, mPaint);
            mPaint.setColor(mSecondColor);
            canvas.drawArc(ovl, -90, mProgress, false, mPaint);
        } else {
            mPaint.setColor(mSecondColor);
            canvas.drawCircle(center, center, radius, mPaint);
            mPaint.setColor(mFirstColor);
            canvas.drawArc(ovl, -90, mProgress, false, mPaint);
        }


        super.onDraw(canvas);
    }
}
