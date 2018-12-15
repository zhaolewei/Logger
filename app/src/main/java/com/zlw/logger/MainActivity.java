package com.zlw.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zlw.loggerlib.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.d("MainActivity", "test ");
    }
}
