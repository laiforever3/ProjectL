package lai.com.projectl.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import lai.com.projectl.R;

/**
 * Created by admin on 2015/8/24.
 */
public class CustomImageView extends View {


    public static final int IMAGE_SCALE_FITXY = 0;
    private String mTitleText;
    private int mTitleSize = 30;
    private int mTitleColor = 0xFF666666;
    private Bitmap mImage;
    private int mImageScale;

    private Paint mPaint;
    private Rect mTextBound;
    private Rect mRect;

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        mTitleText = a.getString(R.styleable.CustomImageView_imageTitleText);
        mTitleColor = a.getColor(R.styleable.CustomImageView_imageTitleColor, mTitleColor);
        mTitleSize = a.getDimensionPixelSize(R.styleable.CustomImageView_imageTitleSize, mTitleSize);
        mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(R.styleable.CustomImageView_image, 0));
        mImageScale = a.getInt(R.styleable.CustomImageView_imageScaleType, 0);
        a.recycle();

        mPaint = new Paint();
        mTextBound = new Rect();
        mRect = new Rect();

        mPaint.setTextSize(mTitleSize);
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mTextBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            int desireTextWidth = getPaddingLeft() + mTextBound.width() + getPaddingRight();
            int desireImageHeight = getPaddingLeft() + mImage.getWidth() + getPaddingRight();
//            if (widthMode == MeasureSpec.AT_MOST) {
            int desireWidth = Math.max(desireTextWidth, desireImageHeight);
            width = Math.min(desireWidth, widthSize);
//            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            int desireTextHeight = getPaddingTop() + mTextBound.height() + getPaddingBottom();
            int desireImageHeight = getPaddingTop() + mImage.getHeight() + getPaddingBottom();

            int desireHeight = Math.max(desireImageHeight, desireTextHeight);
            height = Math.min(desireHeight, heightSize);

        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(0 , 0, width , height, mPaint);


        mPaint.setColor(mTitleColor);
        mPaint.setStyle(Paint.Style.FILL);
        if (mTextBound.width() > width) {
            TextPaint textPaint = new TextPaint(mPaint);
            String msg = TextUtils.ellipsize(mTitleText, textPaint, width - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END).toString();
            canvas.drawText(msg, width / 2 - mTextBound.width() / 2, height - getPaddingBottom(), mPaint);
        } else {
            canvas.drawText(mTitleText, width / 2 - mTextBound.width() / 2, height - getPaddingBottom(), mPaint);
        }

        mRect.left = getPaddingLeft();
        mRect.right = width - getPaddingRight();
        mRect.top = getPaddingTop();
        mRect.bottom = height - getPaddingBottom() - mTextBound.height();
        if (mImageScale == IMAGE_SCALE_FITXY) {
            canvas.drawBitmap(mImage, null, mRect, mPaint);
        } else {
            mRect.left = width / 2 - mImage.getWidth() / 2;
            mRect.right = width / 2 + mImage.getWidth() / 2;
            mRect.top = (height - mTextBound.height()) / 2 - mImage.getHeight() / 2;
            mRect.bottom = (height - mTextBound.height()) / 2 + mImage.getHeight() / 2;
            canvas.drawBitmap(mImage, null, mRect, mPaint);
        }

    }
}
