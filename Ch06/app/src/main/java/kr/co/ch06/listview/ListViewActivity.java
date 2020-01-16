package kr.co.ch06.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import kr.co.ch06.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = findViewById(R.id.listview);

        List<MyData> dataList = makeListData();

        ListAdapter adapter = new ListAdapter(this);
        MyAdapter myAdapter = new MyAdapter(this, dataList);

        listView.setAdapter(myAdapter);

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
