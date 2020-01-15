package kr.co.ch05.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import kr.co.ch05.R;
import kr.co.ch05.tab.TabActivity;

public class SecondFragment extends Fragment {

    private Button btnTab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_layout_second, container, false);

        // 프래그먼트 내의 버튼을 찾아야하므로 앞에 layout.이 붙는다
        btnTab = layout.findViewById(R.id.btn_tab);

        btnTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //MainActivity 직접지정 안됨 = getActicity()
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);

            }
        });


        return layout;

    }
}
