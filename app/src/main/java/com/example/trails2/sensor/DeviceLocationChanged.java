package com.example.trails2.sensor;

import android.location.Location;

/**
 * Created by johnwedgbury on 01/06/2018.
 */


public interface DeviceLocationChanged {
    void onChange(Location location);
}
