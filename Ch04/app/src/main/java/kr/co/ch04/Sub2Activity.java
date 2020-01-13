package kr.co.ch04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sub2Activity extends AppCompatActivity {

    private Button btnClose;
    // 추가
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        btnClose = findViewById(R.id.btn_sub2_back);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 현재 액티비티를 종료한다
                finish();

            }
        });


    }
}
