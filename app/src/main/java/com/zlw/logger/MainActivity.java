package com.zlw.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zlw.loggerlib.Logger;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btPrintLog = findViewById(R.id.btPrintLog);
        btPrintLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printLog();
            }
        });

    }

    private void printLog() {
        Exception exception = new Exception("Code Exception!");

        Logger.d(TAG, "-----------------------");
        Logger.v(TAG, "Test log.v");
        Logger.d(TAG, "Test log.d");
        Logger.i(TAG, "Test log.i");
        Logger.w(TAG, "Test log.w");
        Logger.e(TAG, "Test log.e");
        Logger.d(TAG, "-----------------------");

        int a = 100;
        Logger.i(TAG, "Test String format : %s", a);

        Logger.d(TAG, "-----------------------");

        Logger.e(exception, TAG, "Test Exception");

        Logger.d(TAG, "-------------Test Long Log----------");

        String longStr = "aaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbbaaaaaaaaaaaaabbbbbbb" + "end";
        Logger.d(TAG, "len: %s", longStr.length());
        Logger.d(TAG, longStr);
        Logger.d(TAG, "-----------------------");
    }
}
