package kr.co.ch04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sub3Activity extends AppCompatActivity {

    private TextView txtResult;
    private Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        // 전달되는 인텐트 데이터 수신
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);
        boolean married = getIntent().getBooleanExtra("married", true);

        txtResult = findViewById(R.id.txt_result);
        btnBack   = findViewById(R.id.btn_back);

        txtResult.setText("이름: " +name+ ", 나이: " +age+ ", 결혼여부:" + married);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
