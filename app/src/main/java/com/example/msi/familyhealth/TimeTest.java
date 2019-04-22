package com.example.msi.familyhealth;

import android.util.Log;

public final class TimeTest {
    private static long startTime;
    private static long endTime;

    public static void TimeTestStart() {
        startTime = System.currentTimeMillis();
    }

    public static void TimeTestEnd(String Tag) {
        endTime = System.currentTimeMillis();
        Log.e(Tag, "运行时间：" + startTime + "-" + endTime + "=" + String.valueOf(endTime - startTime) + "ms");
    }
}
