package kr.co.ch08.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.ch08.R;
import kr.co.ch08.thread.ThreadTestActivity;

public class HandleTestActivity extends AppCompatActivity {

    private TextView txtMain, txtBack;
    private Button btnStart;
    private ProgressBar progressBar;

    private int mainValue = 0;
    private int backValue = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);

        txtMain = findViewById(R.id.txt_main);
        txtBack = findViewById(R.id.txt_back);
        btnStart = findViewById(R.id.btn_start);
        progressBar = findViewById(R.id.progress);

        // 스레드 실행

        BackThread back = new BackThread();
        back.start();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressBackThread pThread = new ProgressBackThread(handler);
                pThread.start();

            }
        });

    } //onCreater end

    //Handler 정의
    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {

            // msg.what - 메시지 구분 용
            Toast.makeText(HandleTestActivity.this, "msg.what : " + msg.what, Toast.LENGTH_SHORT).show();

            if(msg.what == 0){
                txtBack.setText("BackValue :" +backValue);
            } else if(msg.what == 1){
                progressBar.setProgress(msg.arg1);
            }

        }
    };

    //배경작업을 위한 스레드 정의
    class BackThread extends Thread {

        @Override
        public void run() {

            for(int i=1 ; i<=100 ; i++){

                backValue++;

                // msg.what - 메시지 구분 용 임의값. 고유번호 같은 것.
                handler.sendEmptyMessage(0);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }
    }

}
