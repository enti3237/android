package kr.co.ch05.tab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kr.co.ch05.R;

public class TabActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;

    private Button btnTab1, btnTab2, btnTab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        btnTab1 = findViewById(R.id.btn_tab1);
        btnTab2 = findViewById(R.id.btn_tab2);
        btnTab3 = findViewById(R.id.btn_tab3);

        btnTab1.setOnClickListener(btnTab1Listener);
        btnTab2.setOnClickListener(btnTab2Listener);
        btnTab3.setOnClickListener(btnTab3Listener);

        // 프래그먼트 관리자 생성
        fm = getSupportFragmentManager();

        // 첫번째 동적프래그먼트 액티비티에 생성
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, Tab1Fragment.newInstance());
        ft.commit();

    }

    private View.OnClickListener btnTab1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ft = fm.beginTransaction();
            ft.replace(R.id.frame_layout, Tab1Fragment.newInstance()).commit();
        }
    };

    private View.OnClickListener btnTab2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ft = fm.beginTransaction();
            ft.replace(R.id.frame_layout, Tab2Fragment.newInstance()).commit();
        }
    };

    private View.OnClickListener btnTab3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ft = fm.beginTransaction();
            ft.replace(R.id.frame_layout, Tab3Fragment.newInstance()).commit();
        }
    };

}
