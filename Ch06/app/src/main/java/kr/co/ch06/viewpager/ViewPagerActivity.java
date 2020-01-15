package kr.co.ch06.viewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import kr.co.ch06.R;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPagerTop;
    private ViewPager viewPagerBottom;
    private ViewPagerAdapter adapter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPagerTop = findViewById(R.id.view_pager_top);
        viewPagerBottom = findViewById(R.id.view_pager_bottom);

        //데이터 생성
        List<MyViewPagerData> dataList = new ArrayList<>();
        dataList.add(new MyViewPagerData(R.drawable.movie_poster_0001, "겨울왕국", "디즈니"));
        dataList.add(new MyViewPagerData(R.drawable.movie_poster_0002, "포드V페라리", "헐리우드"));
        dataList.add(new MyViewPagerData(R.drawable.movie_poster_0003, "나이브스아웃", "폭스"));
        dataList.add(new MyViewPagerData(R.drawable.movie_poster_0004, "조커", "DC"));
        dataList.add(new MyViewPagerData(R.drawable.movie_poster_0005, "라스트크리스마스", "폭스"));

        adapter = new ViewPagerAdapter(this);

        myAdapter = new MyAdapter(this, dataList);

        // 뷰페이저와 어댑터를 연결
        viewPagerTop.setAdapter(adapter);
        viewPagerBottom.setAdapter(myAdapter);

    }
}
