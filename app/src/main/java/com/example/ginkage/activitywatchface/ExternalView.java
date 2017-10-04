package com.example.ginkage.activitywatchface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class ExternalView {
  private FrameLayout rootView;
  private View inflatedView;
  private final LayoutInflater layoutInflater;
  private @LayoutRes int layout;

  public ExternalView(Context context, @LayoutRes int layout) {
    this.rootView = new FrameLayout(context);
    this.layoutInflater = context.getSystemService(LayoutInflater.class);
    this.layout = layout;
  }

  public void draw(Canvas canvas, Rect bounds) {
    if (inflatedView == null && layoutInflater != null) {
      rootView.layout(bounds.left, bounds.top, bounds.right, bounds.bottom);
      inflatedView = layoutInflater.inflate(layout, rootView);
    }
    inflatedView.draw(canvas);
  }
}
