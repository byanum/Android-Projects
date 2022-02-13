package com.example.currentdateandtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker datess;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TimePicker timess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datess = findViewById(R.id.datePicker);
        radioGroup = findViewById(R.id.radiogroup);
        timess= findViewById(R.id.timePicker);
    }

    public void clickBtn(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);


        if(selectedId==-1){
            Toast.makeText(getApplicationContext(),"nothing",Toast.LENGTH_SHORT).show();

        }else
           Toast.makeText(getApplicationContext(),getCurrentDate()+getCurrentTime(),Toast.LENGTH_SHORT).show();

    }

    public String getCurrentDate(){
        StringBuilder builder = new StringBuilder();
        builder.append((datess.getMonth() + 1)+"/");
        builder.append(datess.getDayOfMonth()+"/");
        builder.append(datess.getYear());
        return builder.toString();
    }

    public String getCurrentTime(){
        String current = ("Current "+timess.getCurrentHour()+timess.getCurrentMinute());
        return current;
    }
}