package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalRotateDownTransformer extends VerticalBaseTransformer {
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
        final float width = view.getWidth();
        final float height = view.getHeight();
        final float rotation = ROT_MOD * position * -1.25f;

        view.setPivotY(height * 0.5f);
        view.setPivotX(width);
        view.setRotation(rotation);

        view.setPivotX(width * 0.5f);
        view.setPivotY(height);
        view.setRotation(rotation);
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
