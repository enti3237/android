package kr.co.ch04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
* 날짜 : 2020-01-13
* 이름 : 이지영
* 내용 : 안드로이드 액티비티 실습하기
*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnsub1, btnsub2, btnsub3, btnsub4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsub1 = findViewById(R.id.btn_sub1);
        btnsub2 = findViewById(R.id.btn_sub2);
        btnsub3 = findViewById(R.id.btn_sub3);
        btnsub4 = findViewById(R.id.btn_sub4);


        // 직접 버튼에 대한 이벤트 리스터 구현
        btnsub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 명시적 인텐트 선언 (이동)
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);

            }
        });

        // 독립된 형태의 리스너 구현
        btnsub2.setOnClickListener(btnSub2Listner);

        // 리스너 인터페이스의 메서드 구현방식
        btnsub3.setOnClickListener(this);
        btnsub4.setOnClickListener(this);

        // 로그출력 : i - 정보출력 / d - 디버깅 / e - 에러확인
        Log.i("life", "onCreate...");
    }

    private View.OnClickListener btnSub2Listner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getBaseContext(), "버튼2 터치!", Toast.LENGTH_SHORT).show();

            // 명시적 인텐트 선언 (이동)
            Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
            startActivity(intent);

        }
    };


    // 리스너 인터페이스 구현
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_sub3:

                Intent intent = new Intent(getBaseContext(), Sub3Activity.class);
                intent.putExtra("name", "홍길동");     // 액티비티로 데이터 전달
                intent.putExtra("age", 25);
                intent.putExtra("married", false);
                startActivity(intent);

                break;

            case R.id.btn_sub4:

                Intent intent_sub4 = new Intent(getBaseContext(), Sub4Activity.class);
                startActivity(intent_sub4);


                break;

        }

    }




    @Override
    protected void onStart() {
        super.onStart();

        Log.i("life", "onStart...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life", "onrestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life", "onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life", "onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life", "onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life", "onDestroy...");
    }

}
