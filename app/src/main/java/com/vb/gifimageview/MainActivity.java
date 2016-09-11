package com.vb.gifimageview;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tarih(View view) {

        Calendar calendar = Calendar.getInstance();

        int year= calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Toast.makeText(MainActivity.this, "İyi bayramlar", Toast.LENGTH_SHORT).show();

        datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                TextView textView= (TextView) findViewById(R.id.textView);
                textView.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
            }
        },year,month,day);

        datePickerDialog.setTitle("Tarih seçiniz");
        datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE,"Ayarla",datePickerDialog);
        datePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE,"İptal",datePickerDialog);
        datePickerDialog.show();


    }
}
