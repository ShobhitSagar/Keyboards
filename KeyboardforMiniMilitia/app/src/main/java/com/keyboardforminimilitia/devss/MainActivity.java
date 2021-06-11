package com.keyboardforminimilitia.devss;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGoToSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);

        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        btnGoToSettings = findViewById(R.id.btn_go_to_settings);

        btnGoToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (inputMethodManager != null)
                    inputMethodManager.showInputMethodPicker();
            }
        });

    }
}
