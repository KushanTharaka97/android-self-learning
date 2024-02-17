package com.example.bouncerexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class AnimatedView extends AppCompatImageView implements View.OnTouchListener {
    Context mContext;
    Handler h;
    int x = 21, y = 21;
    int vx = 10, vy = 10;

    public AnimatedView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        h = new Handler();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        p.setColor(Color.BLACK);
        x += vx;
        y += vy;
        if ((x - 20) <= 0 || (x + 20) > getWidth())
            vx = -vx;
        if ((y - 20) <= 0 || (y + 20) > getHeight())
            vy = -vy;

        canvas.drawCircle(x, y, 40, p);
        h.postDelayed(r, 15);
    }
}
