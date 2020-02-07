package kr.co.jcinema;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.jcinema.fragment.FragmentEvent;
import kr.co.jcinema.fragment.FragmentMain;
import kr.co.jcinema.fragment.FragmentMy;
import kr.co.jcinema.fragment.FragmentVod;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;

    // 탭버튼
    private Button btnVod;
    private Button btnEvent;
    private Button btnMy;

    private Button btnReserve;

    // DrawerLayout 관련위젯
    private Button btnMenu;
    private DrawerLayout drawerLayout;
    private View drawerLayoutMenu;
    private Button btnDrawerClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVod = findViewById(R.id.btn_vod);
        btnReserve = findViewById(R.id.btn_reserve);
        btnMy = findViewById(R.id.btn_my);
        btnEvent = findViewById(R.id.btn_evet);
        btnMenu = findViewById(R.id.btn_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayoutMenu = findViewById(R.id.drawer_layout_menu);
        btnDrawerClose = findViewById(R.id.btn_drawer_close);

        // 프래그먼트 관리자 생성
        fm = getSupportFragmentManager();

        // 첫번째 메인 프래그먼트 현재 액티비티에 생성
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, FragmentMain.newInstance());
        ft.commit();

        btnVod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame_layout, FragmentVod.newInstance()).commit();
            }
        });

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame_layout, FragmentEvent.newInstance()).commit();
            }
        });

        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame_layout, FragmentMy.newInstance()).commit();
            }
        });



        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerLayoutMenu);
            }
        });

        btnDrawerClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(drawerLayoutMenu);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {

        //스마트폰의 뒤로가기 버튼 이벤트
        Fragment frg = getSupportFragmentManager().findFragmentById(R.id.frame_layout);

        if(frg instanceof FragmentMain){
            //종료액티비티로 이동
            Intent intent = new Intent(MainActivity.this, CloseActivity.class);
            startActivityForResult(intent, 101);
        } else {
            //메인프래그먼트로 전환
            fm.beginTransaction().replace(R.id.frame_layout, FragmentMain.newInstance()).commit();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 101){
            finish();
        }

    }
}
