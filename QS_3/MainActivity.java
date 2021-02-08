package com.example.a3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity{
    private ListView mListView;
    private ArrayAdapter aAdapter;
    private String[] users = {"Sruthi","sai priya","sreeja","harshika","bhavana","supraja"};
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.userlist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        mListView.setAdapter(aAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView <?>adapterView, View view, int i, long l) {
String num = ((TextView)view).getText().toString();
Toast.makeText(getApplicationContext(),num,Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent(MainActivity.this,MainActivity2.class);
        i1.putExtra("number",(String)mListView.getAdapter().getItem(i));
        startActivity(i1);
        }
        });
        }
        }
