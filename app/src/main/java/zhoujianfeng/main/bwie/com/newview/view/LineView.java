package zhoujianfeng.main.bwie.com.newview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zhoujianfeng.main.bwie.com.newview.R;

public class LineView extends View {
    private float width_04;
    private float width_03;
    private float width_02;
    private float width_01;
    private Paint mPaint;

    public LineView(Context context) {
        super(context);
        init(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.LineView);
        width_01 = type.getFloat(R.styleable.LineView_width_01, 0);
        width_02 = type.getFloat(R.styleable.LineView_width_02, 0);
        width_03 = type.getFloat(R.styleable.LineView_width_03, 0);
        width_04 = type.getFloat(R.styleable.LineView_width_04, 0);
        type.recycle();
        init(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.parseColor("#222222"));
        //初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        DrawXY(canvas);

        DrawLines(canvas);

    }

    private void DrawLines(Canvas canvas) {
        mPaint.setStrokeWidth(50);

        int mX = (getRight() - 100) / 4;

        canvas.drawLine(50 + mX / 2, width_01, 50 + mX / 2, getBottom() - 50, mPaint);
        canvas.drawLine(50 + mX / 2 + mX, width_02, 50 + mX / 2 + mX, getBottom() - 50, mPaint);
        canvas.drawLine(50 + mX / 2 + mX * 2, width_03, 50 + mX / 2 + mX * 2, getBottom() - 50, mPaint);
        canvas.drawLine(50 + mX / 2 + mX * 3, width_04, 50 + mX / 2 + mX * 3, getBottom() - 50, mPaint);
    }

    private void DrawXY(Canvas canvas) {
        //X轴
        canvas.drawLine(50, getBottom() - 50, getRight() - 50, getBottom() - 50, mPaint);
        //Y轴
        canvas.drawLine(50, 50, 50, getBottom() - 50, mPaint);


        int mX = (getRight() - 100) / 4;
        mPaint.setTextSize(25);
        canvas.drawText("徐家辉", 50 + mX / 2, getBottom() - 20, mPaint);
        canvas.drawText("徐晓辉", 50 + mX / 2 + mX, getBottom() - 20, mPaint);
        canvas.drawText("小徐", 50 + mX / 2 + mX * 2, getBottom() - 20, mPaint);
        canvas.drawText("徐铁蛋", 50 + mX / 2 + mX * 3, getBottom() - 20, mPaint);
    }
}
