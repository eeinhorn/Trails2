package com.example.trails2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateTrail extends AppCompatActivity {
    boolean isRecording = false;
    Trail trail = new Trail();
    final Button start = findViewById(R.id.ButtonStart);
    final Button stop = findViewById(R.id.ButtonStop);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trail);

        // stop button should be disabled until recording starts
        stop.setEnabled(false);

        // make location manager
        final LocationManager locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);

        // check if we have gps permission
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            //ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  }, LocationService.CONTEXT_INCLUDE_CODE);
        }

        final LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(isRecording)
                    trail.addNode(location.getLongitude(), location.getLatitude(), location.getAltitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 3, locationListener);
    }

    public void startRecording(View view) {
        isRecording = true;
        start.setEnabled(false);
        stop.setEnabled(true);
    }

    public void stopRecording(View view) {
        isRecording = false;
        stop.setEnabled(false);
        start.setEnabled(true);
    }
}
