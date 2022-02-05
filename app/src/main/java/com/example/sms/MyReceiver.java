package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import android.telephony.SmsManager;

public class MyReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
       Bundle bundle = intent.getExtras();
        if(bundle!=null){
            Object[] obj  = (Object[]) bundle.get("pdus");
            String senderNumber = null;
                for (int i= 0 ; i < obj.length ; i++ ){
                    SmsMessage smsMessage= SmsMessage.createFromPdu((byte[]) obj[i]);
                    senderNumber = smsMessage.getOriginatingAddress();
                    SmsManager sms=SmsManager.getDefault();sms.sendTextMessage(senderNumber,null,"Merci pour ton message, je te répond plus tard",null,null);
                }

        }
    }

}

