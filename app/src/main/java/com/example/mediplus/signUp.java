package com.example.mediplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import model.client;

public class signUp extends AppCompatActivity implements View.OnClickListener {

    Button SignUpCreateAccountButton_btn;
    EditText SignUpHealthCardNumber_editText,SignUpFirstName_editText,SignUpLastName_editText,SignUpPhoneNumber_editText,SignUpEmail_editText,SignUpAge_editText,SignUpStatus_editText,SignUpBloodGroup_editText,SignUpPassword_editText,SignUpAddress;
    DatabaseReference clientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialize();
    }

    private void initialize() {
        //to initialize
        SignUpCreateAccountButton_btn=findViewById(R.id.SignUpCreateAccountButton_btn);
        SignUpHealthCardNumber_editText=findViewById(R.id.SignUpHealthCardNumber_editText);
        SignUpFirstName_editText=findViewById(R.id.SignUpFirstName_editText);
        SignUpLastName_editText=findViewById(R.id.SignUpPageLastName_editText);
        SignUpPhoneNumber_editText=findViewById(R.id.SignUpPhoneNumber_editText);
        SignUpEmail_editText=findViewById(R.id.SignUpEmail_editText);
        SignUpAge_editText=findViewById(R.id.SignUpAge_editText);
        SignUpStatus_editText=findViewById(R.id.SignUpStatus_editText);
        SignUpBloodGroup_editText=findViewById(R.id.SignUpBloodGroup_editText);
        SignUpPassword_editText=findViewById(R.id.SignUpPassword_editText);
        SignUpAddress=findViewById(R.id.SignUpAddress);
        clientDatabase = FirebaseDatabase.getInstance().getReference("client");
        SignUpCreateAccountButton_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.SignUpCreateAccountButton_btn:
                createAccount();break;
            default:break;

        }

    }

    private void createAccount() {

        try {
            String healthCardNumber = SignUpHealthCardNumber_editText.getText().toString();
            String firstName = SignUpFirstName_editText.getText().toString();
            String lastName = SignUpLastName_editText.getText().toString();
            String phoneNumber = SignUpPhoneNumber_editText.getText().toString();
            String email = SignUpEmail_editText.getText().toString();
            String age = SignUpAge_editText.getText().toString();
            String status = SignUpStatus_editText.getText().toString();
            String bloodGroup = SignUpBloodGroup_editText.getText().toString();
            String password = SignUpPassword_editText.getText().toString();
            String address = SignUpAddress.getText().toString();


            client Client= new client(healthCardNumber,firstName,lastName,address,phoneNumber,email,status,bloodGroup,age,password);
            clientDatabase.child(healthCardNumber).setValue(Client);
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }





    }
}