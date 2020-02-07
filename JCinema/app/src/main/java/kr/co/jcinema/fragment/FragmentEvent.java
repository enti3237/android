package kr.co.jcinema.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.co.jcinema.R;

public class FragmentEvent extends Fragment {

    private static FragmentEvent instance = new FragmentEvent();
    public static FragmentEvent newInstance(){
        return instance;
    }

    private FragmentEvent(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_event, container, false);

        return layout;
    }
}
