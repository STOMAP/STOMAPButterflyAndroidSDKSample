STOMAP Butterfly Service SDK Sample
===================================
This repo contains a sample of Android Project which demonstrates how to use STOMAP Butterfly Service

Pre-requisites
--------------
1. A valid API key from STOMAP team
2. A set of locations confirmed by STOMAP team

Getting Started
---------------
1. Include the following uses permission to `AndroidManifest.xml` file
```xml
<uses-permission android:name="android.permission.BLUETOOTH"/>
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
```

2. Add the following service setup to `AndroidManifest.xml` file
```xml
<service
    android:name="com.stomap.stomapbutterflysdk.STOMAPButterflySDK"
    android:exported="false"
    android:enabled="true"/>
```

3. Add `STOMAPButterflySDK-release.aar` file into your `<YOURPROJECT>/app/libs` folder

4. Include the following line in dependencies module in your `build.gradle` file 
```groovy
implementation 'com.google.android.gms:play-services-ads:11.8.0'
compile(name:'STOMAPButterflySDK-release', ext:'aar')
```

5. Add `private Intent mSTOMAPServiceIntent;` in your Activity as a private member

6. Include the following code in `onCreate()` in your Activity to obtain user location permission
```java
// Request for Location Service Permission                                                                    
if (this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { 
    this.requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
}                                                                                                                
```

7. Include the following code in `onCreate()` in your Activity to initialize the SDK
```java
// STOMAPButterflyService Intent Setup
mSTOMAPServiceIntent = new Intent(this, STOMAPButterflySDK.class);
mSTOMAPServiceIntent.putExtra("APIKEY", "YourAPIKey");
mSTOMAPServiceIntent.putExtra("ALIASKEY", "test@test.com");
mSTOMAPServiceIntent.putExtra("ALIASTYPE", STOMAPButterflySDK.AliasType.TYPE.EMAIL);
// STOMAPButterflyService Intent Start
this.startService(mSTOMAPServiceIntent);
```

8. Setup your mobile user alias key and type. Possible types are listed as following:
```java
STOMAPButterflySDK.AliasType.TYPE.OTHER
STOMAPButterflySDK.AliasType.TYPE.EMAIL
STOMAPButterflySDK.AliasType.TYPE.PHONE
STOMAPButterflySDK.AliasType.TYPE.FB_ID
STOMAPButterflySDK.AliasType.TYPE.WEB_COOKIE
```

License
-------
Copyright 2018 Spatial Topology Technology Co., Ltd.

Contact
-------
For sales, please contact
<sales@spatial-topology.com>

For other problems, please contact
<service@spatial-topology.com>

Last Update: March 14, 2018