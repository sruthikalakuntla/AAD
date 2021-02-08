package com.example.a3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txt = (TextView)findViewById(R.id.textView2);
        final Intent i = getIntent();
        final String p = i.getStringExtra("number");
        txt.setText(p);
        final Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity2.this,MainActivity.class);
                //i1.putExtra("number",(String)mListView.getAdapter().getItem(txt));
                startActivity(i1);
            }
        });
    }
}