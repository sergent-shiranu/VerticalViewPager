package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalCubeInTransformer extends VerticalBaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        // Rotate the fragment on the left or right edge
        view.setPivotY(position > 0 ? 0 : view.getHeight());
        view.setPivotX(0);
        view.setRotationX(-90f * position);
    }

    @Override
    public boolean isPagingEnabled() {
        return true;
    }
}
