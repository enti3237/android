package kr.co.jcinema.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.co.jcinema.R;

public class FragmentMy extends Fragment {

    private static FragmentMy instance = new FragmentMy();
    public static FragmentMy newInstance(){
        return instance;
    }

    private FragmentMy(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_my, container, false);

        return layout;
    }
}
