package com.example.mechanicside.Remote;

import com.example.mechanicside.Model.FCMResponse;
import com.example.mechanicside.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAL8xLgFE:APA91bH50ovvAD8tYPEuAM81s7fBf_BJtI8Raq93xkcTgJ8Qb_hKreSbusLeTckoeNyw9qkV_eAakyNpgnFfGECOD-firMO52M_JsHzsQo7BIb6kMsL44xbxONMB1V1mVrMJLPI3iT2i"
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);
}
