package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalFlipHorizontalTransformer extends VerticalBaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        final float rotation = 180f * position;

        view.setAlpha(rotation > 90f || rotation < -90f ? 0 : 1);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationX(rotation);
    }
}
