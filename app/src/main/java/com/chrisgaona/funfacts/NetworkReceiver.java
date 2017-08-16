package com.chrisgaona.funfacts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by chrisgaona on 8/9/17.
 */

public class NetworkReceiver extends BroadcastReceiver {
    private static final String TAG = "FunFactsActivity";

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean networkConnect = networkInfo != null && networkInfo.isConnected();
        Log.i(TAG, networkConnect + "");
    }

//    public boolean isOnline() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        return (networkInfo != null && networkInfo.isConnected());
//    }
}
