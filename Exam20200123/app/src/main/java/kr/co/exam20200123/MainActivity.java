package kr.co.exam20200123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.exam20200123.http.HttpURLConnectionThread;
import kr.co.exam20200123.retro.MemberVO;
import kr.co.exam20200123.retro.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
날짜 : 2020-01-23
이름 : 이지영
내용 : 네트워크 프로그래밍 수행평가
 */

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MyTag";
    private Button btnHttp, btnRetro, btnHttpXml, btnHttpJson, btnRetroXml, btnRetroJson;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: start");

        btnHttp = findViewById(R.id.btn_http);
        btnRetro = findViewById(R.id.btn_retro);
        btnHttpXml = findViewById(R.id.btn_http_xml);
        btnHttpJson = findViewById(R.id.btn_http_json);
        btnRetroXml = findViewById(R.id.btn_retro_xml);
        btnRetroJson = findViewById(R.id.btn_retro_json);
        txtResult = findViewById(R.id.txt_result);

        /* 토스트 메시지 */
        btnHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HttpURLConnection 통신 확인! 아래 버튼을 눌러주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        btnRetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Retrofit 라이브러리 통신 확인! 아래 버튼을 눌러주세요.", Toast.LENGTH_SHORT).show();
            }
        });


        /* Retrofit Library */
        btnRetroXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.xmlService().xmlMember().enqueue(new Callback<MemberVO>() {
                    @Override
                    public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {

                        MemberVO member = response.body();

                        txtResult.setText("Retrofit Library - XmlMember\n");
                        txtResult.append("==========================\n");
                        txtResult.append("아이디: " + member.getUid() + "\n");
                        txtResult.append("이  름: " + member.getName() + "\n");
                        txtResult.append("휴대폰: " + member.getHp() + "\n");
                        txtResult.append("직  급: " + member.getPos() + "\n");
                        txtResult.append("부  서: " + member.getDep() + "\n");
                        txtResult.append("입사일: " + member.getRdate());

                    }

                    @Override
                    public void onFailure(Call<MemberVO> call, Throwable t) {}
                });
            }
        });

        btnRetroJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.jsonService().jsonMember().enqueue(new Callback<MemberVO>() {
                    @Override
                    public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {

                        MemberVO member = response.body();

                        txtResult.setText("Retrofit Library - JsonMember\n");
                        txtResult.append("==========================\n");
                        txtResult.append("아이디: " + member.getUid() + "\n");
                        txtResult.append("이  름: " + member.getName() + "\n");
                        txtResult.append("휴대폰: " + member.getHp() + "\n");
                        txtResult.append("직  급: " + member.getPos() + "\n");
                        txtResult.append("부  서: " + member.getDep() + "\n");
                        txtResult.append("입사일: " + member.getRdate());
                    }

                    @Override
                    public void onFailure(Call<MemberVO> call, Throwable t) {}
                });
            }
        });


        /* HttpURLConnection */
        btnHttpXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: btnHttpXml 시작");
                HttpURLConnectionThread httpURLConnectionThread = new HttpURLConnectionThread(handler, "http://chhak.kr/data/xml/member");
                httpURLConnectionThread.start();
            }
        });

        btnHttpJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: btnHttpJson 시작");
                HttpURLConnectionThread httpURLConnectionThread = new HttpURLConnectionThread(handler, "http://chhak.kr/data/json/member");
                httpURLConnectionThread.start();
            }
        });



    } // onCreate 끝

    /* HttpURLConnectrion 용 Handler */
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            Log.i(TAG, "핸들러 시작");
            if(msg.what == 1){
                String response = (String) msg.obj;
                txtResult.setText(response);

                Log.i(TAG, "handleMessage: setText 출력 끝");

            }
        }
    };
}
