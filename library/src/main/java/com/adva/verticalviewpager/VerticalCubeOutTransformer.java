package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalCubeOutTransformer extends VerticalBaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        view.setPivotY(position < 0f ? view.getHeight() : 0f);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setRotationX(90f * position);
    }

    @Override
    public boolean isPagingEnabled() {
        return true;
    }
}
