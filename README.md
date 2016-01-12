# Android용 Cafe SDK 

> 본 저장소는 Cafe SDK를 사용하기위한 library 및 관련 파일들을 포함하고 있습니다.

Cafe SDK에 대하여 자세히 알고싶으시면 [네이버 CafeSDK 공식카페](http://cafe.naver.com/navercafesdk)를 참조해 주세요.




v.1.1.0
-------------
####updated
1. **세로형 app 지원. (세로형 UI가 새로 적용되었습니다)**
2. 전체 게시판 검색 지원.
3. 카페SDK 시작 및 종료 리스너 추가 <br>
    (setOnSdkStartedListener() 와 setOnSdkStoppedListener() 를 통하여 제공)

####fixed
1. android support v13 -> v4로 변경
2. 구조 개선 및 알려진 버그 수정


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


라이선스
-------------
NAVER Cafe SDK for Android

Copyright 2015 NAVER Corp.
All rights reserved.

Unauthorized use, modification and redistribution of this software are strongly prohibited.
