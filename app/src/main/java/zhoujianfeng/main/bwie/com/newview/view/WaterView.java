package zhoujianfeng.main.bwie.com.newview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class WaterView extends View {
    private Path pathTop;
    private Path pathButtom;
    private float φ;
    private Paint mPaintTop;
    private Paint mPaintButtom;

    public WaterView(Context context) {
        super(context);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //初始化画笔
        mPaintTop = new Paint();
        mPaintTop.setColor(Color.parseColor("#d43c3c"));
        mPaintTop.setAntiAlias(true);

        mPaintButtom = new Paint();
        mPaintButtom.setColor(Color.parseColor("#0000ff"));
        mPaintButtom.setAntiAlias(true);
        mPaintButtom.setAlpha(60);

        //初始化路径
        pathTop = new Path();
        pathButtom = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        pathTop.reset();
        pathButtom.reset();

        //初始化起始点
        pathTop.moveTo(getLeft(), getBottom());
        pathButtom.moveTo(getLeft(), getBottom());

        double mY = Math.PI * 2 / getWidth();

        φ -= 0.1f;
        //路径移动的目标
        for (int x = 0; x <= getWidth(); x += 20) {
            float y = (float) (10 * Math.cos(mY * x + φ) + 10);
            pathTop.lineTo(x, y);
            pathButtom.lineTo(x, (float) (10 * Math.sin(mY * x + φ)));
            lisener.getHeight((int) (10 * Math.sin(mY * x + φ)));
        }

        //初始化结束点
        pathTop.lineTo(getRight(), getBottom());
        pathButtom.lineTo(getRight(), getBottom());

        canvas.drawPath(pathTop, mPaintTop);
        canvas.drawPath(pathButtom, mPaintButtom);

        postInvalidateDelayed(20);
    }


    private AnimalLisener lisener;

    public void setLisener(AnimalLisener lisener) {
        this.lisener = lisener;
    }

    public interface AnimalLisener {
        void getHeight(int y);
    }
}