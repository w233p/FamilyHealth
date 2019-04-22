package com.example.msi.familyhealth.View;

import android.content.Context;
import android.widget.TextView;

import com.example.msi.familyhealth.MyUtils;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.TimeTest;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

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
        TimeTest.TimeTestStart();
        if (e instanceof CandleEntry) {
            CandleEntry candleEntry = (CandleEntry) e;
            textView2.setText("" + MyUtils.formatNumber(candleEntry.getHigh(), 2, true));
        } else {
            textView2.setText("" + MyUtils.formatNumber(e.getY(), 2, true));
        }

        setWaring();
        textView1.setText(item);
        TimeTest.TimeTestEnd("setWaring");
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }


    /**
     * 血糖范围（3.9-7.8）
     * 血压-收缩压90-140-舒张压60-90
     */
    public void setWaring() {
        switch (String.valueOf(item)) {
            case "血糖":
                if (Float.parseFloat(String.valueOf(textView2.getText())) < 3.9 || Float.parseFloat(String.valueOf(textView2.getText())) > 7.8) {
                    textView2.setBackground(getResources().getDrawable(R.drawable.chart_mark_waringbottom));
                } else {
                    textView2.setBackground(getResources().getDrawable(R.drawable.chart_markbottom));
                }
                break;
            case "高压":
                if (Float.parseFloat(String.valueOf(textView2.getText())) < 90 || Float.parseFloat(String.valueOf(textView2.getText())) > 140) {
                    textView2.setBackground(getResources().getDrawable(R.drawable.chart_mark_waringbottom));
                } else {
                    textView2.setBackground(getResources().getDrawable(R.drawable.chart_markbottom));
                }
                break;
            case "低压":
                if (Float.parseFloat(String.valueOf(textView2.getText())) < 60 || Float.parseFloat(String.valueOf(textView2.getText())) > 90) {
                    textView2.setBackground(getResources().getDrawable(R.drawable.chart_mark_waringbottom));
                } else {
                    textView2.setBackground(getResources().getDrawable(R.drawable.chart_markbottom));
                }
                break;
        }
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
