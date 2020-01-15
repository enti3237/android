package kr.co.ch06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

import kr.co.ch06.drawer.DrawerLayoutActivity;
import kr.co.ch06.viewpager.ViewPagerActivity;

/*
    날짜 : 2020-01-15
    이름 : 이지영
    내용 : ViewContainer 실습
 */

public class MainActivity extends AppCompatActivity {

    private Button btnDrawerLayout;
    private Button btnViewPager;
    private Button btnListView;
    private Button btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDrawerLayout = findViewById(R.id.btn_drawer_layout);
        btnViewPager = findViewById(R.id.btn_view_pager);
        btnListView = findViewById(R.id.btn_list_view);
        btnRecyclerView = findViewById(R.id.btn_recycler_view);

        //서랍처럼 여닫기 - 좌우방향만 가능함
        btnDrawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawerLayoutActivity.class);
                startActivity(intent);
            }
        });

        //슬라이드뷰 (스스로 움직이진 않음)
        btnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    } // onCreate end

}
