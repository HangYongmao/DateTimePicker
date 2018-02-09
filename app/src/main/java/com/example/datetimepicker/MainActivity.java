package com.example.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取日历对象
        calendar = Calendar.getInstance();
        // 获取年月日时分秒信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        setTitle(year + "-" + month + "-" + day + " " + hour + ":" + minute);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        timePicker = (TimePicker) findViewById(R.id.time_picker);

        // datePicker初始化
        datePicker.init(year, calendar.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        });

        // timePicker
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                setTitle(hourOfDay + ":" + minute);
            }
        });

        // DatePickerDialog
//        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
//            }
//        }, year, calendar.get(Calendar.MONTH), day).show();

        // TimePickerDialog
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                setTitle(hourOfDay + ":" + minute);
            }
        }, hour, minute, true).show();
    }
}
