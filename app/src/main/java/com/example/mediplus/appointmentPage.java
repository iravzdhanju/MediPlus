package com.example.mediplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class appointmentPage extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rgDesease;
    RadioButton rBackPain,rbDiabaties,rbAcne,rbCoronaVirus,rbCoughing,rbEarAche,rbAnklePain,rbHeart,rbRegularCheckUp;
    EditText cView;
    String slectedRbutton;
    Button nextButtonBookAppointment_btn;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_page);
        initialize();
    }

    private void initialize()
    {
        rgDesease=findViewById(R.id.radioGroup);
        rBackPain=findViewById(R.id.rBackPain);
        rbDiabaties=findViewById(R.id.rbDiabaties);
        rbAcne=findViewById(R.id.rbAcne);
        rbCoronaVirus=findViewById(R.id.rbCoronaVirus);
        rbCoughing=findViewById(R.id.rbCoughing);
        rbEarAche=findViewById(R.id.rbEarAche);
        rbAnklePain=findViewById(R.id.rbAnklePain);
        rbHeart=findViewById(R.id.rbHeart);
        rbRegularCheckUp=findViewById(R.id.rbRegularCheckUp);
        cView=findViewById(R.id.calendarView);
        nextButtonBookAppointment_btn=findViewById(R.id.nextButtonBookAppointment_btn);
        nextButtonBookAppointment_btn.setOnClickListener(this);

        Name=getIntent().getStringExtra("name");

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.nextButtonBookAppointment_btn:
                String desease="";
                int deseasselected=rgDesease.getCheckedRadioButtonId();
                String date=cView.getText().toString();
                switch (deseasselected)
                {
                    case R.id.rbAcne:
                        desease="Acne";break;

                    case R.id.rbAnklePain:
                        desease="Ankle Pain";break;
                    case R.id.rbCoronaVirus:
                        desease="Coronavirus";break;
                    case R.id.rbCoughing:
                        desease="Coughing";break;
                    case R.id.rbDiabaties:
                        desease="Diabetes";break;
                    case R.id.rbEarAche:
                        desease="EarAche";break;
                    case R.id.rbHeart:
                        desease="Heart Disease";break;

                    case R.id.rbRegularCheckUp:
                        desease="Regular Pain";break;
                    case R.id.rBackPain:
                        desease="Back Pain";break;


                }
                Intent i = new Intent(appointmentPage.this,appointmentPage2.class);
                i.putExtra("disease",desease);
                i.putExtra("date",date);
                i.putExtra("Name",Name);

                startActivity(i);
        }
    }
}