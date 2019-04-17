package com.example.msi.familyhealth.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class OneListView extends ListView {
    public boolean isOnMeasure;

    public OneListView(Context context) {
        super(context);
    }

    public OneListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OneListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        isOnMeasure = true;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        isOnMeasure = false;
        super.onLayout(changed, l, t, r, b);
    }
}
