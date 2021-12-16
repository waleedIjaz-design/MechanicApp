package com.example.mechanicside.Common;

import android.location.Location;

import com.example.mechanicside.Model.User;
import com.example.mechanicside.Remote.FCMClient;
import com.example.mechanicside.Remote.IFCMService;
import com.example.mechanicside.Remote.IGoogleAPI;
import com.example.mechanicside.Remote.RetrofitClient;

public class  Common {


    public static final String driver_tbl ="Drivers";
    public static final String user_driver_tbl ="DriversInformation";
    public static final String user_rider_tbl ="RidersInformation";
    public static final String pickup_request_tbl ="PickupRequest";
    public static final String token_tbl ="Tokens";


    public static final int PICK_IMAGE_REQUEST = 9999;

    public static User currentUser;

    public static Location mLastLocation = null;

    public static final String baseURL = "https://maps.googleapis.com";

    public static final String fcmURL = "https://fcm.googleapis.com/";
    public static final String user_field = "usr";
    public static final String pwd_field = "pwd";




    public static double base_fare = 20; //Base on Uber fee in Lahore
    private static double time_rate = 0.35;
    private static double distance_rate = 1.75;


    public static double formulaPrice(double km, double min)
    {
        return base_fare+(distance_rate*km)+(time_rate*min);
    }



    public static IGoogleAPI getGoogleAPI()
    {
        return RetrofitClient.getClient(baseURL).create(IGoogleAPI.class);
    }


    public static IFCMService getFCMService()
    {
        return FCMClient.getClient(fcmURL).create(IFCMService.class);
    }


}
