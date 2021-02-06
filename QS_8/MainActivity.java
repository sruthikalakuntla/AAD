package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    databseHelper databaseHelper;
    EditText et_username, et_password;
    Button btn_register, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new databseHelper(this);
        et_username = (EditText)findViewById(R.id.lusername);
        et_password = (EditText)findViewById(R.id.lpassword);
        btn_register = (Button)findViewById(R.id.lregister);
        btn_login = (Button)findViewById(R.id.llogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    String Username = et_username.getText().toString();
                    String Password = et_password.getText().toString();
                    boolean user = databaseHelper.CheckUsernamePassword(Username,Password);
                    if (user)
                    {

                        Toast.makeText(getApplicationContext(), "Login Successful", LENGTH_SHORT).show();
                        /*Intent intent = new Intent(DataBaseActivity.this, MainActivity.class);
                        startActivity(intent);*/

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login Unsuccessful", LENGTH_SHORT).show();
                    }
                }
                catch (SQLiteException ex)
                {
                    Toast.makeText(getApplicationContext(), ""+ex, LENGTH_SHORT).show();
                }

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields Required", LENGTH_SHORT).show();
                }else{

                    if(password.equals(password)){
                        Boolean checkusername = databaseHelper.CheckUsername(username);
                        if(checkusername == true){
                            Boolean insert = databaseHelper.Insert(username, password);
                            if(insert == true){
                                Toast.makeText(getApplicationContext(), "Registered", LENGTH_SHORT).show();
                                et_username.setText("");
                                et_password.setText("");
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Username already taken", LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password does not match", LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
