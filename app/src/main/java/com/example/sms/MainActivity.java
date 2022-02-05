package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText numero, message, nbFois;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        numero = findViewById(R.id.numero);
        nbFois=  findViewById(R.id.nbFois);
        sendButton = findViewById(R.id.sendButton);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTextMessage();
            }



        protected void sendTextMessage() {

            try {
                SmsManager smgr = SmsManager.getDefault();

                String nbFoisGet = nbFois.getText().toString();

                int ngFoisInt = Integer.parseInt(nbFoisGet);


                for (int i = 1;i <=ngFoisInt; i++){
                    smgr.sendTextMessage(numero.getText().toString(), null, message.getText().toString(), null, null);
                }

                Toast.makeText(getApplicationContext(), "C'est bon", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "pas bon", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }

        });
    }
}