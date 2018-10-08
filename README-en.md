# PLUG SDK

The PLUG SDK is a dedicated in-app community library for mobile games, which lets mobile gamers use community features without leaving games while they are playing. It is easy to apply the PLUG SDK  to your project.

As a proven SDK, which has been used in many mobile games, this lets you simply and quickly add community features in your game.
 
![PLUG SDK](http://static.naver.net/m/cafe/glink/promotion/cafe_sdk_open/img_intro1_20151111.png)

## How To Get Started 

### Become a Partner

You should apply to our partner program to apply the PLUG SDK to your app. Please fill out the form after downloads and send it via email.

- [Downloads of partnership registration form](https://github.com/naver/cafe-sdk-android/raw/master/guide/alliance/%EB%84%A4%EC%9D%B4%EB%B2%84%EC%B9%B4%ED%8E%98SDK_%EC%A0%9C%ED%9C%B4%EC%96%91%EC%8B%9D_%EA%B2%8C%EC%9E%84%EC%82%AC%EB%AA%85_%EA%B2%8C%EC%9E%84%EB%AA%85_ver.2.0.0.xlsx)
- Email address of a partnership contact: <a href="mailto:dl_naverplugpartner@navercorp.com">dl_naverplugpartner@navercorp.com</a>

You can manage the PLUG SDK content on the Settings page from your computer after the partnership process is completed.

### Documentation

- [PLUG documents](https://www.gitbook.com/book/plug/plug-sdk-android/details/en)
- [Downloads of latest library and sample project files](https://github.com/naver/cafe-sdk-android/archive/master.zip)

## Communication

If you have any questions regarding working this SDK, please [visit our issue page for Android](https://github.com/naver/cafe-sdk-android/issues).

## Usages

### 1. Configure the App Manifest

Add permissions and activities in the **AndroidManifest.xml** file.

#### 1.1 Add permission to access the PLUG SDK

Copy and paste the code below to add permission to access the PLUG SDK.

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

#### 1.2 Add permission to record videos

Copy and paste the code below to add permission to record videos.

```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> <!-- Required -->
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>           <!-- Optional -->
```

#### 1.3 Add activities

Copy and paste the code below to add activities for NAVER Login and PLUG SDK.

```xml
    <activity
        android:name="com.nhn.android.naverlogin.ui.OAuthLoginActivity"
        android:screenOrientation="sensorLandscape"
        android:theme="@android:style/Theme.Translucent.NoTitleBar"/>
    <activity
        android:name="com.nhn.android.naverlogin.ui.OAuthLoginInAppBrowserActivity"
        android:screenOrientation="sensorLandscape"
        android:label="OAuth2.0 In-app"/>
```

Add the NeoIdInAppBrowserActivity activity setting to support languages other than Korean.

```xml
      <activity
        android:name="com.naver.glink.android.sdk.login.neoid.NeoIdInAppBrowserActivity"
        android:configChanges="keyboardHidden|screenSize|orientation"
        android:label="NeoId In-app"
        android:screenOrientation="sensor"/>
        
      <activity android:name="com.naver.glink.android.sdk.login.neoid.PlugSchemeActivity">
          <intent-filter>
              <action android:name="android.intent.action.VIEW"/>
              <category android:name="android.intent.category.DEFAULT"/>
              <category android:name="android.intent.category.BROWSABLE"/>
              <data android:scheme="naverplug"/>
          </intent-filter>
      </activity>
```

### 2. Initialize the PLUG SDK

Initializing the PLUG SDK will vary depending on the supported language.

#### 2.1 Support for Korean only (NAVER Cafe)

Configure the initialization information below and call the init() method to initialize the PLUG SDK that supports Korean only.

- ClientId: Client ID you received after registering your application in [NAVER Login Developers](https://developers.naver.com/products/login/api)
- ClientSecret: Client secret you received after registering your application in [NAVER Login Developers](https://developers.naver.com/products/login/api)
- cafeId: Cafe ID you received after creating your Cafe in [NAVER Cafe](http://section.cafe.naver.com/)

The init() method initializes the PLUG SDK.

```java
final int cafeId = 28290504;
final String clientId = "197CymaStozo7X5r2qR5";
final String clientSecret = "evCgKH1kJL";
Glink.init(this, clientId, clientSecret, cafeId);
```

#### 2.2 Support for languages other than Korean

Configure the initialization information below and call the initGlobal() method to initialize the PLUG SDK that supports languages other than Korean.

- consumerKey: Community Key you received after creating your community
- consumerSecretKey: Community Scret Key you received after creating your community
- cummunityNo: Community No received after creating your community
- loungeNo: Lounge No received after creating your lounge

The initGlobal() method initializes the PLUG SDK that supports languages other than Korean.

```java
final String consumerKey = "PLUGTESTKEY";
final String consumerSecretKey = "PLUGTESTSECRET";
final int cummunityNo = 1;
final int loungeNo = 58;
Glink.initGlobal(this, "PLUGTESTKEY", "PLUGTESTSECRET", cummunityNo, loungeNo);
```

> **How to check your community ID and consumer key**  
> Visit http://g.cafe.naver.com/plugsample/manage/consumer and log in to your community using the account with manager privileges.  
> You can find the information in **Settings > Communities > In-App Community Settings** as shown in the image below.  
> ![In-App Community Settings](https://plug.gitbooks.io/plug-sdk-android/content/assets/wiki-plug-setting.png)

### 3. Start the PLUG SDK

Start the PLUG SDK after initialization is completed.

#### 3.1 startHome() method

The startHome() method starts the PLUG SDK with the Home tab selected.

```java
/**
* Start with the Home tab.
*/
Glink.startHome(activity)
```

## Files and Folders 

|Name|Description|
|---|---|
|guide/|Folder for PLUG SDK documentation|
|lib/|Folder for Android PLUG SDK library|
|sample/|Folder for Eclipse and Android Studio sample files|
|NOTICE|License file|
|NAVER-COPYING|NAVER license file|
|CHANGELOG|PLUG SDK change log|
|README.md|Readme file|

## Dependent Libraries

You should add the following libraries to your project and build together with the PLUG SDK in order to use the PLUG SDK. The libraries are included in the sample project.

- Android Support Library v4
- Android Support Custom Tabs
- Android Support RecyclerView
- [NAVER Login](https://nid.naver.com/devcenter/docs.nhn?menu=Android)
- [NAVER Volleyer](http://mvnrepository.com/artifact/com.navercorp.volleyextensions/volleyer) (version 2.0.1)
- Android Volley (version 1.0.0)
- [Google Gson](http://mvnrepository.com/artifact/com.google.code.gson/gson) (version 2.8.0)
- [Glide](http://mvnrepository.com/artifact/com.github.bumptech.glide/glide) (version 3.7.0)
- [Otto](http://mvnrepository.com/artifact/com.squareup/otto) (version 1.3.8)
- hmac (version 2.3.1)

## License 

The intellectual property right of the PLUG SDK is owned by NAVER Corporation.

```
NAVER Cafe SDK for Android

Copyright 2015 NAVER Corp.
All rights reserved.

Unauthorized use, modification and redistribution of this software are strongly prohibited.
```

PLUG SDK 2.x, 3.x versions are no longer supported.

