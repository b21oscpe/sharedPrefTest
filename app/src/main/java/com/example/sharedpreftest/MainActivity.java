package com.example.sharedpreftest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text_name;
    EditText edit_name;
    SharedPreferences preferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("==>", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_name = findViewById(R.id.text_name);

        preferences = getSharedPreferences("janne", MODE_PRIVATE);

        button = findViewById(R.id.button);
        edit_name = findViewById(R.id.edit_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("==>", "Registered click");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", edit_name.getText().toString());
                editor.apply();
            }
        });
    }

    @Override
    protected void onResume() {
        Log.d("==>", "onResume");
        super.onResume();

        String name = preferences.getString("name", "can't get name XD");
        text_name.setText(name);
    }
}