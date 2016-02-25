package com.naver.glink.sample;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.naver.glink.android.sdk.Glink;

public class MainActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /**
     * "네아로 개발자 센터"에서 받은 정보로 SDK를 초기화 합니다.
     * Glink의 다른 메소드를 호출하기 전에 반드시 초기화를 먼저해야 합니다.
     * 개발자 센터 주소: https://nid.naver.com/devcenter/main.nhn
     */
    final int cafeId = 28290504;
    final String clientId = "197CymaStozo7X5r2qR5";
    final String clientSecret = "evCgKH1kJL";
    Glink.init(clientId, clientSecret, cafeId);

    // 게임 아이디와 카페 아이디를 매핑합니다.
    // 프로필 화면에서 매핑된 게임 아이디를 확인할 수 있습니다.
    Glink.setGameUserId(this, "id123", "게임 ID");

    // SDK 시작 리스너 설정.
    Glink.setOnSdkStartedListener(new Glink.OnSdkStartedListener() {
      @Override public void onSdkStarted() {
        Toast.makeText(MainActivity.this, "SDK 시작", Toast.LENGTH_LONG).show();
      }
    });

    // SDK 종료 리스너 설정.
    Glink.setOnSdkStoppedListener(new Glink.OnSdkStoppedListener() {
      @Override public void onSdkStopped() {
        Toast.makeText(MainActivity.this, "SDK 종료", Toast.LENGTH_LONG).show();
      }
    });

    // 앱스킴 터치 리스너 설정.
    Glink.setOnClickAppSchemeBannerListener(new Glink.OnClickAppSchemeBannerListener() {
      @Override public void onClickAppSchemeBanner(String appScheme) {
        // 카페 관리에서 설정한 appScheme 문자열을 SDK에서 넘겨줍니다.
        // 각 appScheme 처리를 이곳에서 하시면 됩니다.
        Toast.makeText(MainActivity.this, appScheme, Toast.LENGTH_LONG).show();
      }
    });

    findViewById(R.id.home_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // 홈화면으로 시작합니다.
        Glink.startHome(MainActivity.this);
      }
    });

    findViewById(R.id.notice_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // 공지화면으로 시작합니다.
        Glink.startNotice(MainActivity.this);
      }
    });

    findViewById(R.id.event_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // 이벤트화면으로 시작합니다.
        Glink.startEvent(MainActivity.this);
      }
    });

    findViewById(R.id.menu_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // 메뉴화면으로 시작합니다.
        Glink.startMenu(MainActivity.this);
      }
    });

    findViewById(R.id.profile_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // 프로필화면으로 시작합니다.
        Glink.startProfile(MainActivity.this);
      }
    });

    findViewById(R.id.write_button1).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        int menuId = 4; // -1이면 메뉴를 선택하지 않는다.
        String text = "기본 제목, 본문을 넣어서 글쓰기 화면을 시작합니다.";
        Glink.startWrite(MainActivity.this, menuId, "subject", text);
      }
    });

    findViewById(R.id.write_button2).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        int menuId = 4; // -1이면 메뉴를 선택하지 않는다.
        String text = "기본 제목, 본문, 이미지를 넣어서 글쓰기 화면을 시작합니다.\n이미지는 uri 형태로 넣어주시면 됩니다.";
        String imageUri = "http://cafeimgs.naver.net/glink/img/gl_img_copyright.png";
        Glink.startImageWrite(MainActivity.this, menuId, "subject", text, imageUri);
      }
    });

    findViewById(R.id.write_button3).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        int menuId = 4; // -1이면 메뉴를 선택하지 않는다.
        String text = "기본 제목, 본문, 비디오를 넣어서 글쓰기 화면을 시작합니다.\n비디오는 uri 형태로 넣어주시면 됩니다.";
        String videoUri = "file://your_video_path";
        Glink.startVideoWrite(MainActivity.this, menuId, "subject", text, videoUri);
      }
    });

    findViewById(R.id.articles_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // 특정 메뉴의 게시글 목록으로 시작합니다.
        Glink.startMenu(MainActivity.this, 4);
      }
    });

    findViewById(R.id.orientation_button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
          setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
          setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
      }
    });
  }
}
