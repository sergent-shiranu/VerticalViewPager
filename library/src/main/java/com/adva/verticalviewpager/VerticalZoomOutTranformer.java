package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalZoomOutTranformer extends VerticalBaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        final float scale = 1f + Math.abs(position);
        view.setScaleX(scale);
        view.setScaleY(scale);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
        if(position == -1){
            view.setTranslationY(view.getHeight() * -1);
        }
    }
}
