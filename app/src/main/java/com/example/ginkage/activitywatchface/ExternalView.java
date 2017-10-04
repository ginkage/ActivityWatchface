package com.example.ginkage.activitywatchface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

class ExternalView extends FrameLayout {
    private View inflatedView;
    private final LayoutInflater layoutInflater;
    private @LayoutRes int layout;

    ExternalView(Context context, @LayoutRes int layout) {
        super(context);
        this.layoutInflater = context.getSystemService(LayoutInflater.class);
        this.layout = layout;
    }

    void draw(Canvas canvas, Rect bounds) {
        if (inflatedView == null && layoutInflater != null) {
            inflatedView = layoutInflater.inflate(layout, this);
            measure(
                    MeasureSpec.makeMeasureSpec(bounds.right - bounds.left, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(bounds.bottom - bounds.top, MeasureSpec.EXACTLY));
            layout(bounds.left, bounds.top, bounds.right, bounds.bottom);
        }
        draw(canvas);
    }
}
