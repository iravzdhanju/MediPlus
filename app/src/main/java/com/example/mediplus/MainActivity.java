package com.example.mediplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//onClickListener to work with mouse and clicks
//valueEventListener to work with values going through Firebase
public class MainActivity extends AppCompatActivity implements View.OnClickListener, ValueEventListener {

    //to link it with XML document
    EditText username_editTxt, password_editTxt;
    Button login_btn, signUp_btn;
    //ImageView mainLogoPicture;

    DatabaseReference clientDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() //to initialize
    {
        //to initialize objects with the objects of XML file so that they connect with java class
        username_editTxt=findViewById(R.id.username_editTxt);
        password_editTxt=findViewById(R.id.password_editTxt);
        login_btn=findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);//to set onClickListener on objects
        signUp_btn=findViewById(R.id.signUp_btn);
        signUp_btn.setOnClickListener(this);
      //  mainLogoPicture=findViewById(R.id.mainLogoPicture);

    }

//switch case to work with onClickListener on any id on the entire view
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.login_btn: // when clicked on login button, login() function will initiate

                login();break;
            case R.id.signUp_btn: // when clicked on sign up button, signUp() function will initiate
               signUp();break;

            default:
                break;
        }
    }

    private void login() {
        //to get value from username text box
        String id=username_editTxt.getText().toString();
        //to connect with the table in firebase database
        clientDatabase=FirebaseDatabase.getInstance().getReference().child("client/"+id);
        //to catch values from the database
        clientDatabase.addValueEventListener(this);

    }


    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        String id=username_editTxt.getText().toString();
        String pass=password_editTxt.getText().toString();
        if (snapshot.exists()) //if value exists in the database
        {


            if (snapshot.child("healthCardNumber").getValue().toString().equalsIgnoreCase(id) )
            {
                if (snapshot.child("password").getValue().toString().equals(pass))
                {


                    Intent i = new Intent(this,homePage.class);
                    i.putExtra("id",id);

                    //if health card number and password match with the database, new homePage activity will open

                    startActivity(i);
                }


                else{
                    //if incorrect, a message will display as follows
                Toast.makeText(this,"The health Card Number or the Password entered is wrong. Please try again.",Toast.LENGTH_LONG).show();
            }



                }
                else{
                Toast.makeText(this,"The health Card Number or the Password entered is wrong. Please try again.",Toast.LENGTH_LONG).show();
            }
        }

    }

    private void signUp(){

        //to go to signUp page activity
        Intent i = new Intent(this,signUp.class);
        startActivity(i);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}