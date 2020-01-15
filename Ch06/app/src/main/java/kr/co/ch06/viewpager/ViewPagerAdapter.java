package kr.co.ch06.viewpager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import kr.co.ch06.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Log.i("viewPager", "instantiateItem :" + position);
        //뷰페이저에 공급할 레이아웃의 생성담당
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_pager_layout, container, false);

        TextView txtPageTitle = view.findViewById(R.id.txt_page_tit);
        txtPageTitle.setText("PAGE : " + position);

        //뷰페이저에 공급
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        //Log.i("viewPager", "getCount");
        // 공급해주는 뷰페이저레이아웃의 갯수
        return 10;
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
