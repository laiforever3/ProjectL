package lai.com.projectl.CustomView.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/8/24.
 */
public class CanvasDrawView extends View {

    private RectF mRectF;
    private Paint mPaint;

    public CanvasDrawView(Context context) {
        this(context, null);
    }

    public CanvasDrawView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mRectF = new RectF();
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        mRectF.left = 50;
        mRectF.right = 250;
        mRectF.top = 50;
        mRectF.bottom = 250;

        canvas.drawArc(mRectF, 0, 40, false, mPaint);

        super.onDraw(canvas);
    }
}
