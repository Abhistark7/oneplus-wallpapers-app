package com.whiteturtlestudio.oneplus5twalls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(Splash_activity.this, MainActivity.class));

        // close splash activity
        finish();
    }
}
