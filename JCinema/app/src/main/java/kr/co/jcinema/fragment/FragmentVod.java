package kr.co.jcinema.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.co.jcinema.R;

public class FragmentVod extends Fragment {

    private static FragmentVod instance = new FragmentVod();
    public static FragmentVod newInstance(){
        return instance;
    }

    private FragmentVod(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_vod, container, false);

        return layout;
    }
}
