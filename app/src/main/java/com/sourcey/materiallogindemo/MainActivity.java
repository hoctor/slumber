package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends Activity {

    private TextView xText, yText, zText;
    private Sensor sensor;
    private SensorManager sManager;
    private Button startB,stopB;

    DecimalFormat dx = new DecimalFormat("#.##");
    DecimalFormat dy = new DecimalFormat("#.##");
    DecimalFormat dz = new DecimalFormat("#.##");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create sensor manager
        sManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        // Accelerometer sensor
        sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Register sensor Listener

        // assign Textview
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        sManager.registerListener((SensorEventListener) this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onResume() {
        super.onResume();


                sManager.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
    protected void onPause() {
        super.onPause();

    }

    SensorEventListener accelListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) { }


        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            xText.setText("X : " + dx.format(x));
            yText.setText("Y : " + dy.format(y));
            zText.setText("Z : " + dz.format(z));
        }
    };

}
