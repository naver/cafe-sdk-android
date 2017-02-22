# PLUG SDK

![http://static.naver.net/m/cafe/glink/promotion/cafe_sdk_open/img_intro1_20151111.png](http://static.naver.net/m/cafe/glink/promotion/cafe_sdk_open/img_intro1_20151111.png)

PLUG SDK는 모바일 게임에서 이탈하지 않고 커뮤니케이션이 가능한 IN-GAME COMMUNITY 라이브러리 입니다. 간단한 조작으로 프로젝트에 PLUG SDK를 추가 할 수 있습니다.

이미 많은 게임에 적용되어 검증되어 있는 PLUG SDK는 손쉽게 커뮤니케이션 기능을 게임 안에 넣을 수 있습니다.

# How To Get Started
- 제휴신청을 위해 [첨부된 파일](https://github.com/naver/cafe-sdk-android/raw/master/guide/alliance/%EB%84%A4%EC%9D%B4%EB%B2%84%EC%B9%B4%ED%8E%98SDK_%EC%A0%9C%ED%9C%B4%EC%96%91%EC%8B%9D_%EA%B2%8C%EC%9E%84%EC%82%AC%EB%AA%85_%EA%B2%8C%EC%9E%84%EB%AA%85_ver.2.0.0.xlsx)을 작성하여
[PLUG_제휴 dl_naverplugpartner@navercorp.com](dl_naverplugpartner@navercorp.com)로 메일을 보낸다.
- 최신 버전을 [다운로드](https://github.com/naver/cafe-sdk-android/archive/master.zip)하면 샘플 프로젝트를 실행할 수 있다.
- 프로젝트에 적용하기 위한 [위키 가이드](https://www.gitbook.com/book/plug/plug-sdk-android/details)가 작성 되어 있다.

# Communication
- [개발 문의 사항](http://cafe.naver.com/ArticleList.nhn?search.clubid=28285034&search.menuid=13&search.boardtype=L)에 있는 질문과 답변이 적용하는데 도움이 될 수 있다.
- 문의 사항이 있는 경우 [카페](http://cafe.naver.com/navercafesdk)를 사용한다.


# Usages
## 1. AndroidManifest 설정
#### 네이버 카페 SDK 접근 권한

네이버 카페 SDK에 필요한 접근 권한을 추가한다.

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

#### 동영상 녹화 접근 권한

동영상 녹화 기능을 사용할 때 필요한 접근 권한을 추가한다.

```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> <!-- 필수-->
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>           <!-- optional -->
```

#### 액티비티 추가

네이버 아이디로 로그인에서 사용하는 액티비티와 네이버 카페 SDK에서 사용하는 액티비티를 추가한다.

```xml
    <activity
        android:name="com.nhn.android.naverlogin.ui.OAuthLoginActivity"
        android:screenOrientation="sensorLandscape"
        android:theme="@android:style/Theme.Translucent.NoTitleBar"/>
    <activity
        android:name="com.nhn.android.naverlogin.ui.OAuthLoginInAppBrowserActivity"
        android:screenOrientation="sensorLandscape"
        android:label="OAuth2.0 In-app"/>
    <activity
       android:name="com.naver.glink.android.sdk.ui.VideoPlayActivity"
       android:screenOrientation="sensorLandscape"
       android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen"/>
```


> 글로벌 카페를 사용할 경우 아래의 NeoIdAppBrowserActivity가 추가되어야 한다



```xml
      <activity
        android:name="com.naver.glink.android.sdk.login.neoid.NeoIdInAppBrowserActivity"
        android:configChanges="keyboardHidden|screenSize|orientation"
        android:label="NeoId In-app"
        android:screenOrientation="sensor"/>
```


## 2. Initialize

### 2-1. 한국 채널(네이버 카페) - 글로벌 채널만 사용하는 경우 세팅하지 않는다.

[네이버 아이디로 로그인](https://developers.naver.com/products/login/api)에 애플리케이션을 등록하고 받은 ClientId, ClientSecret 값을 세팅한다.

[네이버 카페를 개설](http://section.cafe.naver.com/)하고 얻은 카페 ID를 세팅한다.

init을 호출한다


```java
final int cafeId = 28290504;
final String clientId = "197CymaStozo7X5r2qR5";
final String clientSecret = "evCgKH1kJL";
Glink.init(this, clientId, clientSecret, cafeId);
```

### 2-2. 글로벌 채널 - 한국 채널만 사용하는 경우 세팅하지 않는다.

개설된 커뮤니티에 매니저 권한으로 접속한 후, [setting > Communities > In-App Community Setting](http://g.cafe.naver.com/plugsample/manage/consumer)으로 진입하여 '커뮤니티 ID 및 Consumer Key, Consumer Secret'를 발급받는다.


ConsumerKey, communityId 값을 세팅한다.
![](https://plug.gitbooks.io/plug-sdk-android/content/assets/wiki-plug-setting.png)

initGlobal을 호출한다

```java
final int globalCafeId = 1013329;
final String neoIdConsumerKey = "IHCd_HmSiMcXOMC37xZ8";
final String defaultChannel = "";
Glink.initGlobal(this, neoIdConsumerKey, globalCafeId, defaultChannel);
```



## 3. startHome

기본 세팅이 완료되었으면 다음 static 메소드로 PLUG를 실행 시킨다.

### startHome() 메서드

홈 탭이 선택된 상태로 네이버 카페 PLUG 화면을 연다.


```java
/**
* 홈 탭으로 시작
*/
Glink.startHome(activity)
```



# 폴더 구조


file      | 설명 		
---			| ---		
guide/			| 가이드 문서 및 CafeSDK 설명
lib/		 	| Android용 CafeSDK 라이브러리 파일
sample/		| eclipse 및 android studio 용 sample project
NOTICE     | 라이선스 파일
NAVER-COPYING    |  네이버 라이선스 
CHANGELOG   |  CafeSDK 버전 업데이트 내역
README.md   | readme 파일


# 의존 라이브러리 - 샘플 프로젝트에 포함되어 있다.


1. [네이버 아이디 로그인](https://nid.naver.com/devcenter/docs.nhn?menu=Android)
2. android support library v4
3. [naver volleyer](http://mvnrepository.com/artifact/com.navercorp.volleyextensions/volleyer)   (2.0.1 사용 중)
4. [volley](http://mvnrepository.com/artifact/com.mcxiaoke.volley/library/) (1.0.2 사용 중)
5. [google gson](http://mvnrepository.com/artifact/com.google.code.gson/gson)  (2.8.0 사용 중)
6. [glide](http://mvnrepository.com/artifact/com.github.bumptech.glide/glide)  (3.7.0 사용 중)
7. [otto](http://mvnrepository.com/artifact/com.squareup/otto)  (1.3.8 사용 중)
8. hmac (2.3.1 사용중)

# License

NAVER Cafe SDK for Android

Copyright 2015 NAVER Corp.
All rights reserved.

Unauthorized use, modification and redistribution of this software are strongly prohibited.
