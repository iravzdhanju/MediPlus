package com.example.mediplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.apointment;

public class appointmentPage2 extends AppCompatActivity implements View.OnClickListener {

    EditText editTextMultiLine;
    Button btn ;
    String Name;
    String desease;
    DatabaseReference apointmentdatabase;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_page2);
        initialize();
    }

    private void initialize() {

        btn=findViewById(R.id.searchAndBookButton_btn);
        editTextMultiLine=findViewById(R.id.editTextTextMultiLine);
        Name=getIntent().getStringExtra("Name");
      desease=getIntent().getStringExtra("desease");
      date=getIntent().getStringExtra("date");
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.searchAndBookButton_btn:
                desease=desease+" "+editTextMultiLine.getText().toString();
                apointment apoint=new apointment(Name,desease,date);
                apointmentdatabase= FirebaseDatabase.getInstance().getReference("apointment");
                apointmentdatabase.child(Name).setValue(apoint);




        }
        Intent i = new Intent(this,finalPage.class);
        i.putExtra("desease",desease);
        i.putExtra("date",date);
        i.putExtra("Name",Name);
        startActivity(i);


    }
}