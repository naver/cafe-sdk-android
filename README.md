# PLUG SDK

PLUG SDK는 모바일 게임 사용자가 게임 도중 게임을 벗어나지 않고 게임의 커뮤니티와 소통할 수 있도록 제공되는 인앱 커뮤니티 라이브러리입니다. 간단한 조작으로 프로젝트에 PLUG SDK를 추가할 수 있습니다.

이미 많은 게임에 적용돼 검증된 PLUG SDK를 사용하면 손쉽게 커뮤니케이션 기능을 게임 안에 넣을 수 있습니다.
 
![PLUG SDK](http://static.naver.net/m/cafe/glink/promotion/cafe_sdk_open/img_intro1_20151111.png)

## How To Get Started 

### 제휴 신청

PLUG SDK를 앱에 적용하려면 PLUG SDK 제휴를 신청해야 합니다. 제휴 양식을 작성해 PLUG 제휴 담당자에게 메일로 제휴를 신청합니다.

- [제휴 양식 다운로드](https://github.com/naver/cafe-sdk-android/raw/master/guide/alliance/%EB%84%A4%EC%9D%B4%EB%B2%84%EC%B9%B4%ED%8E%98SDK_%EC%A0%9C%ED%9C%B4%EC%96%91%EC%8B%9D_%EA%B2%8C%EC%9E%84%EC%82%AC%EB%AA%85_%EA%B2%8C%EC%9E%84%EB%AA%85_ver.2.0.0.xlsx)
- PLUG 제휴 담당자 메일 주소: <a href="mailto:dl_naverplugpartner@navercorp.com">dl_naverplugpartner@navercorp.com</a>

제휴 신청이 완료되면 PC의 카페 관리 페이지에서 네이버 PLUG SDK 콘텐츠를 관리할 수 있습니다.

### 적용 가이드

- [PLUG 적용 가이드](https://www.gitbook.com/book/plug/plug-sdk-android/details)
- [최신 버전 및 샘플 프로젝트 다운로드](https://github.com/naver/cafe-sdk-android/archive/master.zip)

## Communication 

개발과 관련된 문의 사항은 PLUG 공식 카페를 사용합니다.

- [PLUG 공식 카페](http://cafe.naver.com/navercafesdk)
- [PLUG 공식 카페의 개발 문의 게시판](http://cafe.naver.com/ArticleList.nhn?search.clubid=28285034&search.menuid=13&search.boardtype=L)

## Usages 

### 1. 앱 매니페스트 설정

**AndroidManifest.xml** 파일에 다음과 같이 접근 권한과 액티비티를 추가합니다.

#### 1.1 PLUG SDK 접근 권한

PLUG SDK에 필요한 접근 권한을 추가합니다.

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

#### 1.2 동영상 녹화 접근 권한

동영상 녹화 기능을 사용할 때 필요한 접근 권한을 추가합니다.

```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> <!-- 필수 사항 -->
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>           <!-- 선택 사항 -->
```

#### 1.3 액티비티 추가

네이버 아이디로 로그인에서 사용하는 액티비티와 PLUG SDK에서 사용하는 액티비티를 추가합니다.

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

PLUG SDK가 외국어를 지원할 때는 다음과 같이 NeoIdInAppBrowserActivity 액티비티 설정을 추가해야 합니다.

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

### 2. 초기화

PLUG SDK가 지원하는 언어에 따라 다음과 같이 PLUG SDK를 초기화합니다.

#### 2.1 PLUG SDK 초기화(한국어만 지원 - 네이버 카페)

한국어만 지원하는 PLUG SDK를 초기화할 때는 다음과 같은 초기화 옵션을 설정하고 init() 메서드를 호출합니다.

- ClientId: [네이버 아이디로 로그인 개발자 센터](https://developers.naver.com/products/login/api)에 애플리케이션을 등록하고 받은 클라이언트 아이디 ClientId
- ClientSecret: [네이버 아이디로 로그인 개발자 센터](https://developers.naver.com/products/login/api)에 애플리케이션을 등록하고 받은 클라이언트 시크릿
- cafeId: [네이버 카페](http://section.cafe.naver.com/)에서 카페를 개설하고 받은 카페 ID
init() 메서드는 PLUG SDK를 초기화하는 메서드입니다.

```java
final int cafeId = 28290504;
final String clientId = "197CymaStozo7X5r2qR5";
final String clientSecret = "evCgKH1kJL";
Glink.init(this, clientId, clientSecret, cafeId);
```

#### 2.2 PLUG SDK 초기화(외국어만 지원)

외국어만 지원하는 PLUG SDK를 초기화할 때는 다음과 같은 초기화 옵션을 설정하고 initGlobal() 메서드를 호출합니다.

- globalCafeId: 커뮤니티를 개설하고 받은 커뮤니티 ID(Community ID)
- neoIdConsumerKey: 커뮤니티를 개설하고 받은 컨슈머 키(Consumer Key)

initGlobal() 메서드는 외국어를 지원하는 PLUG SDK를 초기화하는 메서드입니다.

```java
final int globalCafeId = 1013329;
final String neoIdConsumerKey = "IHCd_HmSiMcXOMC37xZ8";
final String defaultChannel = "";
Glink.initGlobal(this, neoIdConsumerKey, globalCafeId, defaultChannel);
```

> **커뮤니티 ID와 컨슈머 키 확인**  
> 커뮤니티를 개설하고 받은 커뮤니티 ID와 컨슈머 키를 확인하려면 [커뮤니티 관리 페이지](http://g.cafe.naver.com/plugsample/manage/consumer)에 매니저 권한으로 접근하십시오.  
> 커뮤니티 관리 페이지에서 **Settings > Communities > In-App Community Settings** 메뉴를 선택하면 커뮤니티 ID와 컨슈머 키를 확인할 수 있습니다.  
> ![In-App Community Settings](https://plug.gitbooks.io/plug-sdk-android/content/assets/wiki-plug-setting.png)

### 3. PLUG SDK 시작

초기화가 완료되면 PLUG SDK를 실행합니다.

#### 3.1 startHome() 메서드

startHome() 메서드는 홈 탭이 선택된 상태로 PLUG SDK를 시작하는 메서드입니다.

```java
/**
* 홈 탭으로 시작
*/
Glink.startHome(activity)
```

### 4. LIVE

PLUG SDK는 사용자가 게임 화면을 실시간 스트리밍 할 수 있는 기능을 제공합니다.

[라이브 상세 가이드](https://plug.gitbooks.io/plug-sdk-android/content/ko/[%ED%95%9C]-%ED%94%8C%EB%9F%AC%EA%B7%B8-%EB%9D%BC%EC%9D%B4%EB%B8%8C.html)

![LIVE](https://cafeptthumb-phinf.pstatic.net/MjAxNzExMTRfMTE3/MDAxNTEwNjQ2MTk3MjM1.7ss4wFV1nGd0Q_Lk8jpQ_HV2pJv_MR_w7FbHg74NSHog.Tc4f5bQ7IWR8Wbnc5xGVVeTPK1lZ7NyyWcMdA4li1qUg.PNG.cafesdksupport/02.PNG?type=w740)


## Files and Folders

|폴더 및 파일 이름|설명|
|---|---|
|guide/|PLUG SDK 적용 가이드가 있는 폴더|
|lib/|Android용 PLUG SDK 라이브러리 파일이 있는 폴더|
|sample/|Eclipse 및 Android Studio용 샘플 프로젝트가 있는 폴더|
|NOTICE|라이선스 파일|
|NAVER-COPYING|네이버 라이선스 파일|
|CHANGELOG|PLUG SDK 버전 업데이트 내역|
|README.md|리드미 파일|

## Dependent Libraries

PLUG SDK를 사용하려면 다음 라이브러리를 프로젝트에 추가해 함께 빌드해야 합니다. 라이브러리는 샘플 프로젝트에 포함돼 있습니다.

- Android Support Library v4
- [네이버 아이디 로그인](https://nid.naver.com/devcenter/docs.nhn?menu=Android)
- [NAVER Volleyer](http://mvnrepository.com/artifact/com.navercorp.volleyextensions/volleyer)(2.0.1 버전 사용 중)
- Android Volley(1.0.0 버전 사용 중)
- [Google Gson](http://mvnrepository.com/artifact/com.google.code.gson/gson)(2.8.0 버전 사용 중)
- [Glide](http://mvnrepository.com/artifact/com.github.bumptech.glide/glide)(3.7.0 버전 사용 중)
- [Otto](http://mvnrepository.com/artifact/com.squareup/otto)(1.3.8 버전 사용 중)
- hmac(2.3.1 버전 사용중)
- android customtabs (23.1.0 버전 사용중)

## License 

PLUG SDK의 저작권은 네이버(주)에 있습니다.

```
NAVER Cafe SDK for Android

Copyright 2015 NAVER Corp.
All rights reserved.

Unauthorized use, modification and redistribution of this software are strongly prohibited.
```
