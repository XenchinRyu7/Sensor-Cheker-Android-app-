package com.vsga_xenchinryu.sensorcheck.ui.list_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListSensorViewModel extends ViewModel {

    private final MutableLiveData<List<SensorItem>> mSensorList;

    public ListSensorViewModel() {
        mSensorList = new MutableLiveData<>();
        mSensorList.setValue(new ArrayList<>());
    }

    public LiveData<List<SensorItem>> getSensorList(Context context) {
        List<SensorItem> sensorItems = new ArrayList<>();
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
            for (Sensor sensor : sensors) {
                sensorItems.add(new SensorItem(sensor.getName(), isSensorAvailable(sensor, sensorManager)));
            }
        }
        mSensorList.setValue(sensorItems);
        return mSensorList;
    }

    private boolean isSensorAvailable(Sensor sensor, SensorManager sensorManager) {
        return sensorManager.getDefaultSensor(sensor.getType()) != null;
    }

    public static class SensorItem {
        private final String sensorName;
        private final boolean isAvailable;

        public SensorItem(String sensorName, boolean isAvailable) {
            this.sensorName = sensorName;
            this.isAvailable = isAvailable;
        }

        public String getSensorName() {
            return sensorName;
        }

        public boolean isAvailable() {
            return isAvailable;
        }
    }
}