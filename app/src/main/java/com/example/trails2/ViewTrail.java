package com.example.trails2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewTrail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trail);
    }

    public void openTrailMenu(View view) {
        // TODO: this should connect to our database and open a menu of trails for the use to view
    }
}
