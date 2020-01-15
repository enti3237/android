package kr.co.ch06.viewpager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import kr.co.ch06.R;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private List<MyViewPagerData> dataList;

    public MyAdapter(Context context, List<MyViewPagerData> dataList){

        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("viewPager", "instantiateItem :" + position);

        //뷰페이저에 공급할 레이아웃의 생성담당
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.my_view_pager_layout, container, false);

        ImageView imgPoster = view.findViewById(R.id.img_poster);
        TextView txtTitle = view.findViewById(R.id.txt_tit);
        TextView txtCompany = view.findViewById(R.id.txt_company);

        //데이터셋으로부터 생성할 뷰어데이터를 지정
        MyViewPagerData data = dataList.get(position);
        imgPoster.setImageResource(data.getPoster());
        txtTitle.setText(data.getTitle());
        txtCompany.setText(data.getCompany());

        //뷰페이저에 공급
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        //Log.i("viewPager", "getCount");
        // 공급해주는 뷰페이저레이아웃의 갯수
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //Log.i("viewPager", "isViewFromObject");
        return (view == (View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.i("viewPager", "destroyItem : " +position);
        container.removeView((View) object);

    }

}
