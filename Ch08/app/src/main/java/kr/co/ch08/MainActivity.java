package kr.co.ch08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.ch08.async.AsyncTaskActivity;
import kr.co.ch08.handler.HandleTestActivity;
import kr.co.ch08.thread.ThreadTestActivity;

/*
    날짜 : 2020-01-21
    이름 : 이지영
    내용 : 안드로이드 스레드 실습하기

    스레드
    - 한번의 프로그램 실행으로 하나 이상의 작업을 동시(병행하여)에 실행하는 작업단위
    - 메인스레드와 작업스레드로 분류되며 안드로이드에서는 메인스레드를 UI스레드라고 한다.
    - 안드로이드에서는 기본적인 자바스레드 문법과 동일하고 스레드간의 데이터공류를 위해 핸들러를 사용한다.
    - 안드로이드에서는 스레드와 핸들러를 같이 구현한 AsyncTask 클래스를 많이 이용한다.
*/


public class MainActivity extends AppCompatActivity {

    private Button btnThread, btnHandler, btnAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThread = findViewById(R.id.btn_thread);
        btnHandler = findViewById(R.id.btn_handler);
        btnAsync = findViewById(R.id.btn_btn_async);

        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThreadTestActivity.class);
                startActivity(intent);
            }
        });

        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HandleTestActivity.class);
                startActivity(intent);
            }
        });

        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });



    }
}
