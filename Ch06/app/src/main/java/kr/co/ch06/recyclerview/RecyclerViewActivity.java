package kr.co.ch06.recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.co.ch06.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recycler_view);

        List<MyData> dataList = makeListData();

        RecyclerAdapter adapter = new RecyclerAdapter(this, dataList);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    public List<MyData> makeListData(){

        List<MyData> dataList = new ArrayList<>();
        dataList.add(new MyData(R.drawable.movie_poster_0001, "겨울왕국", "디즈니"));
        dataList.add(new MyData(R.drawable.movie_poster_0002, "포드V페라리", "헐리우드"));
        dataList.add(new MyData(R.drawable.movie_poster_0003, "나이브스아웃", "폭스"));
        dataList.add(new MyData(R.drawable.movie_poster_0004, "조오오오오커", "DC"));
        dataList.add(new MyData(R.drawable.movie_poster_0005, "라스트크리스마스", "폭스"));

        for(int i=0 ; i<100 ; i++){
            dataList.add(dataList.get(i));
        }

        return dataList;
    }

}
