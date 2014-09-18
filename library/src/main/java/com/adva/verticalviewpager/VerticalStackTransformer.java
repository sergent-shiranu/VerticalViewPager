package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalStackTransformer extends VerticalBaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        page.setTranslationY(position < 0 ? 0f : -page.getHeight() * position);
    }
}
