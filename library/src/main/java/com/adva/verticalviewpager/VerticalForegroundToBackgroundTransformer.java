package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalForegroundToBackgroundTransformer extends VerticalBaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        final float height = view.getHeight();
        final float width = view.getWidth();
        final float scale = min(position > 0 ? 1f : Math.abs(1f + position), 0.5f);

        view.setScaleX(scale);
        view.setScaleY(scale);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationY(position > 0 ? height * position : -height * position * 0.25f);
    }
}
