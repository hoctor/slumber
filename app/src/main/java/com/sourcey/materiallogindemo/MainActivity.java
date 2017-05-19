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
public class MainActivity extends Activity implements SensorEventListener,View.OnClickListener {

    private TextView xText, yText, zText;
    private Sensor sensor;
    private SensorManager sManager;
    private Button startB,stopB;
    private boolean mInitialized;
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
        sManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
        // assign Textview
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        Button startButton = (Button) findViewById(R.id.startB);
        Button stopButton = (Button) findViewById(R.id.stopB);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        mInitialized = false;
    }

    public void onResume() {
        super.onResume();
                sManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
    protected void onPause() {
        super.onPause();
        sManager.unregisterListener(this);
    }


        public void onAccuracyChanged(Sensor sensor, int acc) { }


        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            xText.setText("X : " + dx.format(x));
            yText.setText("Y : " + dy.format(y));
            zText.setText("Z : " + dz.format(z));
        }

        public void onClick (View v){
            switch (v.getId()) {
                case R.id.startB:
                    sManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
                    break;
                case R.id.stopB:
                    sManager.unregisterListener(this);
                    break;
            }
    }
}
