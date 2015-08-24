package lai.com.projectl.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/8/24.
 */
public class CanvasDrawView extends View {
    public CanvasDrawView(Context context) {
        this(context, null);
    }

    public CanvasDrawView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawArc();
        super.onDraw(canvas);
    }
}
