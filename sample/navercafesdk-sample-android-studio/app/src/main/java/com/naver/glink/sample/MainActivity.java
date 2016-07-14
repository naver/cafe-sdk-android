package com.naver.glink.sample;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.naver.glink.android.sdk.Glink;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
    Glink.syncGameUserId(this, "id123");

    // 동영상 녹화 기능을 사용합니다.
    Glink.setUseVideoRecord(this, true);

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

    // 카페 가입 리스너를 설정.
    Glink.setOnJoinedListener(new Glink.OnJoinedListener() {
      @Override public void onJoined() {
        Toast.makeText(MainActivity.this, "카페에 가입하였습니다. (from listener)", Toast.LENGTH_SHORT)
            .show();
      }
    });

    /** 게시글 등록 리스너를 설정.
     * @param menuId 게시글이 등록된 menuId
     * @param imageCount 첨부한 image 갯수
     * @param videoCount 첨부한 video 갯수
     **/
    Glink.setOnPostedArticleListener(new Glink.OnPostedArticleListener() {
      @Override public void onPostedArticle(int menuId, int imageCount, int videoCount) {
        String message = String.format("게시글이 작성되었습니다. (from listener, 메뉴: %d)", menuId);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
      }
    });

    // 댓글 등록 리스너를 설정.
    Glink.setOnPostedCommentListener(new Glink.OnPostedCommentListener() {
      @Override public void onPostedComment(int articleId) {
        String message = String.format("댓글이 작성되었습니다. (from listener, 게시글: %d)", articleId);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
      }
    });

    // 투표 완료 리스너를 설정.
    Glink.setOnVotedListener(new Glink.OnVotedListener() {
      @Override public void onVoted(int articleId) {
        String message = String.format("투표가 완료 되었습니다. (from listener, 게시글: %d)", articleId);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
      }
    });


    //위젯 스크린샷 버튼 클릭 리스너 설정.
    Glink.setOnWidgetScreenshotClickListener(new Glink.OnWidgetScreenshotClickListener() {
      @Override public void onScreenshotClick() {
        String path = screenshot(MainActivity.this);
        Glink.startImageWrite(MainActivity.this, -1, "screen shot!", "스크린샷 테스트", path);
      }
    });

    //동영상 녹화 완료 리스너 설정.
    Glink.setOnRecordFinishListener(new Glink.OnRecordFinishListener() {
      @Override public void onRecordFinished(String uri) {
        Glink.startVideoWrite(MainActivity.this, -1, "동영상 녹화", "녹화", uri);
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


  public String screenshot(Activity activity) {
    View view =
        activity.getWindow().getDecorView().findViewById(android.R.id.content).getRootView();

    view.setDrawingCacheEnabled(true);
    view.buildDrawingCache(true);

    Bitmap screenshot = view.getDrawingCache(true);

    String filename = "screenshot" + System.currentTimeMillis() + ".png";
    String fileUri = null;
    try {
      File f = new File(activity.getFilesDir(), filename);

      f.createNewFile();
      fileUri = f.toURI().toString();

      OutputStream outStream = new FileOutputStream(f);
      screenshot.compress(Bitmap.CompressFormat.PNG, 100, outStream);
      outStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    view.setDrawingCacheEnabled(false);
    return fileUri;
  }
}
