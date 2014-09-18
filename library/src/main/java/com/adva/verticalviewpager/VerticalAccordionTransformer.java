package com.adva.verticalviewpager;

import android.view.View;

/**
 * Created by T530 on 18/09/2014.
 */
public class VerticalAccordionTransformer extends VerticalBaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        page.setPivotY(position < 0 ? 0 : page.getHeight());
        page.setScaleY(position < 0 ? 1f + position : 1f - position);
    }
}
