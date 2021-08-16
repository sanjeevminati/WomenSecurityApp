package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class third extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "Myconts";
    private static final String Key_num = "number";
    private static final String Key_message = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);




    }

    public void Alert(View view) {

        String number = getIntent().getStringExtra("keynumber");
        String message = getIntent().getStringExtra("keymessage");
        String san = second.adrr;
        smsmini(number, message, san);
    }

    public void logout(View view) {
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String str = sharedPreferences.getString(Key_num, null);
        String msg = sharedPreferences.getString(Key_message, null);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        finish();


    }


    private void smsmini(String value, String value2, String san) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(value, null, value2 + " \n " + san, null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
    }


}