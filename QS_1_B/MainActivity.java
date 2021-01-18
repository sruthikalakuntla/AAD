package com.example.a1b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Button b;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.t1);
        b = (Button) findViewById(R.id.b1);
        e = (EditText) findViewById(R.id.e1);
    }
    public void onClickBtn (View view){
        String o = e.getText().toString();
        t.setText("hello " + o);
    }
}