package com.example.trails2;

/*  This is the default activity that opens
    when a user opens the application.
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openCreateTrail(View view) {
        Intent intent = new Intent(this, CreateTrail.class);
        startActivity(intent);
    }

    public void openViewTrail(View view) {
        Intent intent = new Intent(this, ViewTrail.class);
        startActivity(intent);
    }
}
