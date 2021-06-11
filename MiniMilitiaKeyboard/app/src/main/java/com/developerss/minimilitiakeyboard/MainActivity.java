package com.developerss.minimilitiakeyboard;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button settings_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);

        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        settings_Btn = findViewById(R.id.go_to_settings_Btn);

        settings_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (inputMethodManager != null) {
                    inputMethodManager.showInputMethodPicker();
                }

//                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            }
        });

    }
}
