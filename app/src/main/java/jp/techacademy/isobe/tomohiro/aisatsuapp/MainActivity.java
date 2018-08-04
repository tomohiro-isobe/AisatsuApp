package jp.techacademy.isobe.tomohiro.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView1);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 2 && hourOfDay < 10 && minute <= 59) {
                            mTextView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay < 18 && minute <= 59) {
                            mTextView.setText("こんにちは");
                        } else if (hourOfDay <= 1 || hourOfDay >= 18 && minute <= 59 ) {
                            mTextView.setText("こんばんは");
                        }

                        Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                23,
                30,
                true);


        timePickerDialog.show();
    }

}
