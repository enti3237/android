package kr.co.jcinema.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.co.jcinema.R;

public class FragmentMain extends Fragment {

    private static FragmentMain instance = new FragmentMain();
    public static FragmentMain newInstance(){
        return instance;
    }

    private FragmentMain(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_main, container, false);
        return null;
    }
}
