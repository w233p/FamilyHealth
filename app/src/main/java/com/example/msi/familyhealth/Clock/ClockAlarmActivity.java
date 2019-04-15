package com.example.msi.familyhealth.Clock;

import android.app.Service;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.constraint.solver.LinearSystem;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.msi.familyhealth.Data.DbClockBean;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.SimpleDialog;

import org.litepal.crud.DataSupport;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

public class ClockAlarmActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_alarm);
        String message = this.getIntent().getStringExtra("msg");
        int flag = this.getIntent().getIntExtra("flag", 0);
        showDialogInBroadcastReceiver(message, flag);

        deleteNoRepeatClock(message);
    }

    private void showDialogInBroadcastReceiver(String message, final int flag) {
        if (flag == 1 || flag == 2) {
//            mediaPlayer = MediaPlayer.create(this);
//            mediaPlayer.setLooping(true);
//            mediaPlayer.start();
        }
        //数组参数意义：第一个参数为等待指定时间后开始震动，震动时间为第二个参数。后边的参数依次为等待震动和震动的时间
        //第二个参数为重复次数，-1为不重复，0为一直震动
        if (flag == 0 || flag == 2) {
            vibrator = (Vibrator) this.getSystemService(Service.VIBRATOR_SERVICE);
            vibrator.vibrate(new long[]{100, 10, 100, 600}, 0);
        }

        final SimpleDialog dialog = new SimpleDialog(this, R.style.Theme_dialog);
        dialog.show();
        dialog.setTitle("闹钟提醒");
        dialog.setMessage(message);
        dialog.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog.bt_confirm == v || dialog.bt_cancel == v) {
                    if (flag == 1 || flag == 2) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    if (flag == 0 || flag == 2) {
                        vibrator.cancel();
                    }
                    dialog.dismiss();
                    finish();
                }
            }
        });
    }

    public void deleteNoRepeatClock(String message) {
        List<DbClockBean> dbClockBeanList = DataSupport.where("medOrEventName = ?", message).find(DbClockBean.class);
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < dbClockBeanList.size(); i++) {
            if (dbClockBeanList.get(i).getHour() == calendar.get(Calendar.HOUR_OF_DAY)) {
                if (dbClockBeanList.get(i).getMinute() == calendar.get(Calendar.MINUTE)) {
                    if (dbClockBeanList.get(i).getRepeat() == 0) {
                        dbClockBeanList.get(i).delete();
                    }
                }
            }
        }
    }
}
