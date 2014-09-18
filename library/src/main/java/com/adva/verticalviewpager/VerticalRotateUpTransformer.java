package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalRotateUpTransformer extends VerticalBaseTransformer {
    private static final float ROT_MOD = -15f;

    protected void onPreTransform(View page, float position) {
        final float width = page.getWidth();
        final float height = page.getHeight();

        page.setRotationX(0);
        page.setRotationY(0);
        page.setRotation(0);
        page.setScaleX(1);
        page.setScaleY(1);
        page.setPivotX(0);
        page.setPivotY(0);
        page.setTranslationX(0);
        page.setTranslationY(isPagingEnabled() ? 0f : -height * position);

        final float normalizedposition = Math.abs(Math.abs(position) - 1);
        page.setAlpha(normalizedposition);
    }

    @Override
    protected void onTransform(View view, float position) {
        final float height = view.getHeight();
        final float rotation = ROT_MOD * position;

        view.setPivotY(height * 0.5f);
        view.setPivotX(0f);
        view.setTranslationY(0f);
        view.setRotation(rotation);
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
