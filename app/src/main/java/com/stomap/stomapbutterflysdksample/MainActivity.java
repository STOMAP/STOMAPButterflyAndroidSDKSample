package com.stomap.stomapbutterflysdksample;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stomap.stomapbutterflysdk.STOMAPButterflySDK;


public class MainActivity extends AppCompatActivity {

    private Intent mSTOMAPServiceIntent;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Request for Location Service Permission
        if (this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        // STOMAPButterflyService Intent Setup
        mSTOMAPServiceIntent = new Intent(this, STOMAPButterflySDK.class);
        mSTOMAPServiceIntent.putExtra("APIKEY", "YourAPIKey");
        mSTOMAPServiceIntent.putExtra("ALIASKEY", "test@test.com");
        mSTOMAPServiceIntent.putExtra("ALIASTYPE", STOMAPButterflySDK.AliasType.TYPE.EMAIL);

        // STOMAPButterflyService Intent Start
        this.startService(mSTOMAPServiceIntent);
    }
}
