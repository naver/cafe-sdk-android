# PLUG SDK

![http://static.naver.net/m/cafe/glink/promotion/cafe_sdk_open/img_intro1_20151111.png](http://static.naver.net/m/cafe/glink/promotion/cafe_sdk_open/img_intro1_20151111.png)

PLUG SDK는 모바일 게임에서 이탈하지 않고 커뮤니케이션이 가능한 IN-GAME COMMUNITY 라이브러리 입니다. 간단한 조작으로 프로젝트에 PLUG SDK를 추가 할 수 있습니다.

이미 많은 게임에 적용되어 검증되어 있는 PLUG SDK는 손쉽게 커뮤니케이션 기능을 게임 안에 넣을 수 있습니다.


# How To Get Started
- 최신 버전을 [다운로드](https://github.com/naver/cafe-sdk-android/archive/master.zip)하면 샘플 프로젝트를 실행할 수 있다.
- 한국 채널인 네이버 카페를 사용하기 위해 [제휴 신청](https://github.com/naver/cafe-sdk-android/wiki/%5B%ED%95%9C%5D-%EC%84%A0%ED%96%89-%EC%9E%91%EC%97%85)이 필요하다.
- 글로벌 채널을 사용하기 위해 [제휴 신청](https://github.com/naver/cafe-sdk-android/wiki/%5B%ED%95%9C%5D%20%EA%B8%80%EB%A1%9C%EB%B2%8C%20%EB%84%A4%EC%9D%B4%EB%B2%84%20%EC%B9%B4%ED%8E%98%20%EC%82%AC%EC%9A%A9)이 필요하다.
- 프로젝트에 적용하기 위한 [위키 가이드](https://github.com/naver/cafe-sdk-android/wiki)가 작성 되어 있다.

# Communication
- [개발 문의 사항](http://cafe.naver.com/ArticleList.nhn?search.clubid=28285034&search.menuid=13&search.boardtype=L)에 있는 질문과 답변이 적용하는데 도움이 될 수 있다.
- 문의 사항이 있는 경우 [카페](http://cafe.naver.com/navercafesdk) 혹은 [e-mail](dl_navercafesdk@navercorp.com)을 사용한다.




# Usages
## AndroidManifest 설정
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
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>
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


## Initialize

### 한국 채널(네이버 카페)

[네이버 아이디로 로그인](https://developers.naver.com/products/login/api)에 애플리케이션을 등록하고 받은 ClientId, ClientSecret 값을 세팅한다.

[네이버 카페를 개설](http://section.cafe.naver.com/)하고 얻은 카페 ID를 세팅한다.

init을 호출한다


```java
final int cafeId = 28290504;
final String clientId = "197CymaStozo7X5r2qR5";
final String clientSecret = "evCgKH1kJL";
Glink.init(this, clientId, clientSecret, cafeId);
```

### 글로벌 채널 
[제휴 신청](https://github.com/naver/cafe-sdk-android/wiki/%5B%ED%95%9C%5D%20%EA%B8%80%EB%A1%9C%EB%B2%8C%20%EB%84%A4%EC%9D%B4%EB%B2%84%20%EC%B9%B4%ED%8E%98%20%EC%82%AC%EC%9A%A9)을 통해 받은 ConsumerKey, communityId 값을 세팅한다.

initGlobal을 호출한다

```java
final int globalCafeId = 1013329;
final String neoIdConsumerKey = "IHCd_HmSiMcXOMC37xZ8";
final String defaultChannel = "";
Glink.initGlobal(this, neoIdConsumerKey, globalCafeId, defaultChannel);
```


### showWidgetWhenUnloadSdk

PLUG X버튼을 클릭할 때 위젯이 화면에 노출되는 여부를 설정한다.

```java
Glink.showWidgetWhenUnloadSdk(activity, true);

```

### setUseVideoRecord

PLUG 위젯에 녹화 버튼 노출 여부를 설정한다. (Android 5.0 이상)

```java
Glink.setUseVideoRecord(activity, true)
```

### CallBack API
PLUG에서는 PLUG에서 발생하는 사용자 이벤트를 콜백 함수로 전달해 준다.

PLUG 실행/종료, 글작성(이미지/동영상 첨부 개수), 가입, 댓글 작성, 투표 등이 있다.

다음은 댓글 등록 리스너를 구현한 예다.

```java
// 댓글 등록 리스너 설정
Glink.setOnPostedCommentListener(new Glink.OnPostedCommentListener() {
   @Override public void onPostedComment(int articleId) {
      String message = String.format("댓글이 작성되었습니다. (from listener, 게시글: %d)", articleId);
      Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
   }
});
```


폴더 구조
-------------

file      | 설명 		
---			| ---		
guide/			| 가이드 문서 및 CafeSDK 설명
lib/		 	| Android용 CafeSDK 라이브러리 파일
sample/		| eclipse 및 android studio 용 sample project
NOTICE     | 라이선스 파일
NAVER-COPYING    |  네이버 라이선스 
CHANGELOG   |  CafeSDK 버전 업데이트 내역
README.md   | readme 파일


의존 라이브러리
-------------

1. [네이버 아이디 로그인](https://nid.naver.com/devcenter/docs.nhn?menu=Android)
2. android support library v4
3. [naver volleyer](http://mvnrepository.com/artifact/com.navercorp.volleyextensions/volleyer)   (2.0.1 사용 중)
4. [volley](http://mvnrepository.com/artifact/com.mcxiaoke.volley/library/) (1.0.2사용 중)
5. [google gson](http://mvnrepository.com/artifact/com.google.code.gson/gson)  (2.3.1 사용 중)
6. [glide](http://mvnrepository.com/artifact/com.github.bumptech.glide/glide)  (3.6.1 사용 중)
7. [otto](http://mvnrepository.com/artifact/com.squareup/otto)  (1.3.8 사용 중)
8. hmac (2.3.1 사용중)

라이선스
-------------
NAVER Cafe SDK for Android

Copyright 2015 NAVER Corp.
All rights reserved.

Unauthorized use, modification and redistribution of this software are strongly prohibited.
