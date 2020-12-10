package com.example.mediplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class finalPage extends AppCompatActivity {
    TextView finalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        finalId=findViewById(R.id.finalid);
        String desease=getIntent().getStringExtra("desease");
      String  date=getIntent().getStringExtra("date");
      String  Name=getIntent().getStringExtra("Name");
      finalId.setText("Hi, "+Name+"\n Your Appointment Details have been successfully received by us. As soon as the window opens, your earliest possible appointment will be booked  ");

    }
}