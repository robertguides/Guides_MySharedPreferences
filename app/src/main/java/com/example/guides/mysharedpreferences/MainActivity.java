package com.example.guides.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.editText1);
        etPassword = (EditText) findViewById(R.id.editText2);
        btnSave = (Button) findViewById(R.id.button);
        btnDisplay = (Button) findViewById(R.id.button2);
        tvDisplay = (TextView) findViewById(R.id.wow);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }
    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",etUsername.getText().toString());
        editor.putString("pwd", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view){
        String user = preferences.getString("user","");
        String password = preferences.getString("pwd","");

        tvDisplay.setText("User is " + user + " and the password is " + password);
    }
}
