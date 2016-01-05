package com.apptopus.sampleapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptopus.progressive.Progressive;

public class MainActivity extends AppCompatActivity {
    boolean progress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnToggle = (Button)findViewById(R.id.btnToggle);
        Button btnToggleCustom = (Button)findViewById(R.id.btnToggleCustom);

        final ImageView imgDummy1 = (ImageView)findViewById(R.id.imageView1);
        final ImageView imgDummy2 = (ImageView)findViewById(R.id.imageView2);
        final ImageView imgDummy3 = (ImageView)findViewById(R.id.imageView3);
        final ImageView imgDummy4 = (ImageView)findViewById(R.id.imageView4);

        final TextView customProgress = new TextView(this);
        customProgress.setText("This is a Custom Progress..");
        customProgress.setTextColor(Color.parseColor("#ffffff"));

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (progress) {
                    Progressive.hideProgress(imgDummy1);
                    Progressive.hideProgress(imgDummy2);
                    Progressive.hideProgress(imgDummy3);
                    Progressive.hideProgress(imgDummy4);
                    progress = false;
                } else {
                    Progressive.showProgress(imgDummy1);
                    Progressive.showProgress(imgDummy2);
                    Progressive.showProgress(imgDummy3);
                    Progressive.showProgress(imgDummy4);
                    progress = true;
                }
            }
        });

        btnToggleCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(progress){
                    Progressive.hideProgress(imgDummy1);
                    Progressive.hideProgress(imgDummy2);
                    Progressive.hideProgress(imgDummy3);
                    Progressive.hideProgress(imgDummy4);
                    progress = false;
                }
                else{
                    Progressive.showProgress(imgDummy4, customProgress);
                    progress = true;
                }
            }
        });
    }
}
