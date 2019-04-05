package com.example.msi.familyhealth.View;

import android.content.Context;
import android.widget.TextView;

import com.example.msi.familyhealth.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/**
 * 图表中的小提示窗口界面
 */
public class CheckMarkView extends MarkerView {
    private TextView textView1;
    private TextView textView2;
    private String item;

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public CheckMarkView(Context context, int layoutResource) {
        super(context, layoutResource);

        textView1 = findViewById(R.id.chart_markTv1);
        textView2 = findViewById(R.id.chart_markTv2);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        if (e instanceof CandleEntry) {
            CandleEntry candleEntry = (CandleEntry) e;
            textView2.setText("" + Utils.formatNumber(candleEntry.getHigh(), 2, true));
        } else {
            textView2.setText("" + Utils.formatNumber(e.getY(), 2, true));
        }
        textView1.setText(getItem());
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
