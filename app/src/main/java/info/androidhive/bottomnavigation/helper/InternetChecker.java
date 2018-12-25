package info.androidhive.bottomnavigation.helper;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import info.androidhive.bottomnavigation.MainActivity;
import info.androidhive.bottomnavigation.R;
import info.androidhive.bottomnavigation.SplashScreenActivity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public enum InternetChecker {
    INSTANCE;
    /*public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }*/
}
