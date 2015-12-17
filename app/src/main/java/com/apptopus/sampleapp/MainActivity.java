package com.apptopus.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.apptopus.progressive.Progressive;

public class MainActivity extends AppCompatActivity {


    Button btnToggle;
    ImageView imgDummy;
    boolean progress = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToggle = (Button)findViewById(R.id.btnToggle);
        imgDummy = (ImageView)findViewById(R.id.imageView);
        Progressive.showProgress(imgDummy);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(progress){
                    Progressive.hideProgress(imgDummy);
                    progress = false;
                }
                else{
                    Progressive.showProgress(imgDummy);
                    progress = true;
                }
            }
        });
    }
}
