package com.example.ch03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        // 기본방식
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼1 클릭!", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼2 클릭!", Toast.LENGTH_LONG).show();
            }
        });

        // 리스너를 외부객체로 구현해서 버튼과 연결하는 방식
        btn3.setOnClickListener(btn3Listener);
        btn4.setOnClickListener(btn4Listener);

    } // onCreate End

    View.OnClickListener btn3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("알림")
                    .setMessage("버튼3을 눌렀습니다.")
                    .show();

        }
    };

    View.OnClickListener btn4Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("알림");
            dialog.setMessage("버튼4를 눌렀습니다.");
            dialog.setNegativeButton("취소", null);
            dialog.setPositiveButton("확인", null);
            dialog.show();
        }
    };


    // onClick 속성을 사용하여 레이아웃에 직접 연결
    public void btn5Listener(View v) {
        Toast.makeText(MainActivity.this, "버튼5 클릭!", Toast.LENGTH_SHORT).show();
    }

    public void btn6Listener(View v) {

        AlertDialog.Builder dia = new AlertDialog.Builder(MainActivity.this);
        dia.setTitle("알림");
        dia.setMessage("버튼6를 눌렀습니다.");
        dia.setNegativeButton("취소", null);
        dia.setPositiveButton("확인", null);
        dia.show();

    }


} // MainActivity End
