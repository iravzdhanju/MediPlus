package com.example.mediplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

import model.hospital;

import static android.widget.Toast.LENGTH_LONG;

public class homePage extends AppCompatActivity implements ValueEventListener, View.OnClickListener {
ImageView image;
TextView textViewname,healthCardNumberDisplay,bloodGroupTypeDisplay,emergencyContactDisplay;
DatabaseReference clien;
Button btnGo;
String Name;
Map googleMap;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    initialize();

    }

    private void initialize()
    {

        setContentView(R.layout.activity_home_page);
        textViewname=findViewById(R.id.textViewname);
        String id = getIntent().getStringExtra("id");
        healthCardNumberDisplay=findViewById(R.id.healthCardNumberDisplay);
        bloodGroupTypeDisplay=findViewById(R.id.bloodGroupTypeDisplay);
        emergencyContactDisplay=findViewById(R.id.emergencyContactDisplay);
        healthCardNumberDisplay.setText(id.toString());
        btnGo=findViewById(R.id.button);
        btnGo.setOnClickListener(this);
        clien=FirebaseDatabase.getInstance().getReference().child("client").child(id);
        clien.addValueEventListener(this);



    }


    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
    if (snapshot.exists())
    {
        String hC = snapshot.child("healthCardNumber").getValue().toString();
        String bG = snapshot.child("bloodType").getValue().toString();
        String name = snapshot.child("firstName").getValue().toString();
        String phone = snapshot.child("phoneNumber").getValue().toString();
        healthCardNumberDisplay.setText(hC);
        bloodGroupTypeDisplay.setText(bG);
        textViewname.setText(name);
        Name=name;
        emergencyContactDisplay.setText(phone);

    }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.button:
                Intent i = new Intent(homePage.this,appointmentPage.class);
                i.putExtra("name",Name);
                startActivity(i);
        }
}
}