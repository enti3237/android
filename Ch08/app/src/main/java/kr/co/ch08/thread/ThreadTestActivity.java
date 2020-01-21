package kr.co.ch08.thread;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.ch08.R;

public class ThreadTestActivity extends AppCompatActivity {

    private TextView txtMain, txtBack;
    private Button btnIncrease;

    private int mainValue = 0;
    private int backValue = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);

        txtMain = findViewById(R.id.txt_main);
        txtBack = findViewById(R.id.txt_back);
        btnIncrease = findViewById(R.id.btn_increase);


        //BackThread 실행
        BackThread back = new BackThread();
        back.start();


        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainValue++;

                txtMain.setText("MainValue : " +mainValue);
                txtBack.setText("BackValue : "+backValue);

            }
        });

    } //onCreate end


    // Thread 내장 클래스
    class BackThread extends Thread {

        @Override
        public void run() {

            for(int i=1 ; i<=100 ; i++){

                backValue++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
