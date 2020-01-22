package kr.co.ch09.http;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import kr.co.ch09.R;

public class HttpConnectionActivity extends AppCompatActivity {

    Button btnHtml, btnJson, btnXml;
    TextView txtResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connection);

        btnHtml = findViewById(R.id.btn_http);
        btnJson = findViewById(R.id.btn_json);
        btnXml = findViewById(R.id.btn_xml);

        txtResult = findViewById(R.id.txt_result);

        btnHtml.setOnClickListener(btnHtmlListner);
        btnJson.setOnClickListener(btnJsonLister);
        btnXml.setOnClickListener(btnXmlListner);

    } // onCreate end


    View.OnClickListener btnHtmlListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // Manifest에 INTERNET 퍼미션 지정
            // 메인스레드에서 HTTP 요청을 하면 NetworkOnMainThreadException 에러가 발생. 배경스레드에서 해야함
            HttpConnectionThread httpConnectionThread = new HttpConnectionThread(handler, "http://google.com");
            httpConnectionThread.start();

        }
    };

    View.OnClickListener btnJsonLister = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpConnectionThread httpConnectionThread = new HttpConnectionThread(handler, "http://chhak.kr/data/json/members");
            httpConnectionThread.start();
        }
    };

    View.OnClickListener btnXmlListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpConnectionThread httpConnectionThread = new HttpConnectionThread(handler, "http://chhak.kr/data/xml/members");
            httpConnectionThread.start();
        }
    };


    // Handler

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1){
                String response = (String) msg.obj;
                txtResult.setText(response);

                // 원래라면 response를 문자열이 아니라 List 로 만들어야 함 (for문 돌려서 add)
                // 그걸 위해 Retrofit을 실행함

            }
        }
    };



}


