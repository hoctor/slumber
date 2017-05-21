package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends Activity implements SensorEventListener,View.OnClickListener {

    private TextView xText;
    private Sensor sensor;
    private SensorManager sManager;
    private Button startB,stopB;
    private boolean mInitialized;
    DecimalFormat dx = new DecimalFormat("#.##");
    DecimalFormat dy = new DecimalFormat("#.##");
    DecimalFormat dz = new DecimalFormat("#.##");
    public String FILENAME = "motion.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create sensor manager
        sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Accelerometer sensor
        sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Register sensor Listener
        sManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        // assign Textview
        xText = (TextView) findViewById(R.id.xText);

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


        public void onAccuracyChanged(Sensor sensor, int acc) {}



        public void onSensorChanged(SensorEvent event) {
            xText.setText(" X  :"+ Float.toString(event.values[0]) +"\n"+
                    " Y  :"+ Float.toString(event.values[1]) +"\n"+
                    " Z :"+ Float.toString(event.values[2]));

            try {
                writeToCsv(Float.toString(event.values[0]),Float.toString(event.values[1]),Float.toString(event.values[2]));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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

    public void writeToCsv(String x,String y,String z) throws IOException {
       Calendar c = Calendar.getInstance();
        File file = new File(Environment.getDataDirectory () + "/TollCulator");
        boolean success = true;
        if (!file.exists()) {
            success = file.mkdir();
        }
        if (success) {
            String csv = "/storage/emulated/Android/data/com.sourcey.materialloginexample/files/motion.csv";
            FileWriter file_writer = new FileWriter(csv, true);
            String s = c.get(Calendar.HOUR) + "," + c.get(Calendar.MINUTE) + "," + c.get(Calendar.SECOND) + "," + c.get(Calendar.MILLISECOND) + "," + x + "," + y + "," + z + "\n";
            file_writer.append(s);
            file_writer.close();
        }
    }



    }
