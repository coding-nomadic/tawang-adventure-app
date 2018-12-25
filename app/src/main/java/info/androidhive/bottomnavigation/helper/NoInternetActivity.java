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

/**
 * Created by DELL on 22-12-2018.
 */
public class NoInternetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nointernet);
    }
}
