package com.example.android.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText billView;
    private EditText dinerView;
    private TextView outputTip;
    private TextView outputBill;
    private CheckBox checkBox;
    private TextView barLabel;
    private SeekBar bar;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billView=findViewById(R.id.billView);
        dinerView=findViewById(R.id.dinerView);
        outputTip=findViewById(R.id.outputTip);
        outputBill=findViewById(R.id.outputBill);
        checkBox=findViewById(R.id.checkBox);
        barLabel=findViewById(R.id.barLabel);
        bar = findViewById(R.id.seekBar);
        layout = findViewById(R.id.layout);

        //layout.setBackgroundColor(0xFFFFFF00);

        bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        barLabel.setText(i+"");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void buttonPressed2(View v) {
        Intent i = new Intent(this, ColorActivity.class);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int color = data.getIntExtra("COLOR", 0xFFFF0000);
        layout.setBackgroundColor(color);
    }



    public void buttonPressed(View v) {
        String inputbill=billView.getText().toString();
        double bill=Double.parseDouble(inputbill);

        String inputdiner=dinerView.getText().toString();
        double diner=Double.parseDouble(inputdiner);

        String tiplabel=barLabel.getText().toString();
        double tip=Double.parseDouble(tiplabel);

        double tiptotal=bill*(tip/100);
        double billresult=bill+tiptotal;
        double result;

        if (checkBox.isChecked()) {
            result=billresult/diner;
        }
        else {
            result=billresult;
        }
        outputBill.setText(String.format("%.2f",result));
        outputTip.setText(String.format("%.2f",tiptotal));

    }

}
