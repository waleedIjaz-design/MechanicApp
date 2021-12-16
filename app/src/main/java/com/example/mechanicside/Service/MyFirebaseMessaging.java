package com.example.mechanicside.Service;

import android.content.Intent;
import android.util.Log;

import com.example.mechanicside.Common.Common;
import com.example.mechanicside.CustommerCall;
import com.example.mechanicside.Model.Token;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

public class MyFirebaseMessaging extends FirebaseMessagingService {

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        updateTokenToServer(s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

    //  if (remoteMessage.getData() != null) {

            Log.d("EDMTDEV", remoteMessage.getNotification().getBody());

         //   Map<String, String> data = remoteMessage.getData(); // Get data from notification
         //   String customer = data.get("customer");
         //   String lat = data.get("lat");
         //   String lng = data.get("lng");

            //Because I will send the firebase message with contain Lat and Lng from rider app
            // So i need convert message to LatLng
            LatLng customer_location = new Gson().fromJson(remoteMessage.getNotification().getBody(),LatLng.class);

            Intent intent = new Intent(getBaseContext(), CustommerCall.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("lat",customer_location.latitude);
            intent.putExtra("lng",customer_location.longitude);
            intent.putExtra("customer",remoteMessage.getNotification().getTitle());

            startActivity(intent);

     }

   // }

    private void updateTokenToServer(String refreshedToken) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference(Common.token_tbl);


        Token token = new Token(refreshedToken);
        if(FirebaseAuth.getInstance().getCurrentUser() !=null)//if already login, must update token
            tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .setValue(token);

    }



}
