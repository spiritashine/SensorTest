package com.hujie.sensortest;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        SensorManager manager;
        Sensor sensor;
        ImageView image;
        View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor=manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        image=(ImageView)findViewById(R.id.iv);
        view=findViewById(R.id.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(listener,sensor,manager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private SensorEventListener listener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            if (values[0]<20){
                view.setBackgroundColor(Color.BLACK);
            }else if (values[0]>=20&&values[0]<40){
                view.setBackgroundColor(Color.CYAN);
            }else if (values[0]>=40&&values[0]<60){
                view.setBackgroundColor(Color.BLUE);
            }else if (values[0]>=60&&values[0]<80){
                view.setBackgroundColor(Color.GREEN);
            }else {
                view.setBackgroundColor(Color.RED);

            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
