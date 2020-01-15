package kr.co.ch05.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kr.co.ch05.R;

public class Tab3Fragment extends Fragment {

    // 동적 프래그먼트일 경우 싱글톤 객체방식으로 프래그먼트 객체를 생성함
    private static Tab3Fragment instance = new Tab3Fragment();
    public static Tab3Fragment newInstance(){return instance;}
    private Tab3Fragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.tab3_fragment_layout, container, false);

        return layout;
    }
}
