package kr.co.ch09.retro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import kr.co.ch09.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/*
    Retrofit Library
    안드로이드 서버통신과 Json, xml 파싱 처리까지 일원화 작업을 지원하는 라이브러리

 */

public class RetrofitTestActivity extends AppCompatActivity {

    Button btnHtml, btnJson1, btnXml1, btnJson2, btnXml2;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);

        btnHtml  = findViewById(R.id.btn_http);
        btnJson1 = findViewById(R.id.btn_json1);
        btnXml1  = findViewById(R.id.btn_xml1);
        btnJson2 = findViewById(R.id.btn_json2);
        btnXml2  = findViewById(R.id.btn_xml2);

        txtResult = findViewById(R.id.txt_result);


        btnHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitClient.htmlService().request("http://naver.com").enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String result = response.body();
                        txtResult.setText(result);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {}
                });

            }
        });



        btnJson1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RetrofitClient.jsonService().jsonMembers().enqueue(new Callback<List<MemberVO>>() {
                    @Override
                    public void onResponse(Call<List<MemberVO>> call, Response<List<MemberVO>> response) {

                        List<MemberVO> members = response.body();

                        // 이전 데이터를 클리어할 방법을 못 찾아서 setText를 먼저 한번 불러서 리셋시킴
                        txtResult.setText("============================\n");

                        for(MemberVO member : members){

                            txtResult.append("아이디: " + member.getUid() + "\n");
                            txtResult.append("이  름: " + member.getName() + "\n");
                            txtResult.append("휴대폰: " + member.getHp() + "\n");
                            txtResult.append("직  급: " + member.getPos() + "\n");
                            txtResult.append("부  서: " + member.getDep() + "\n");
                            txtResult.append("입사일: " + member.getRdate() + "\n");
                            txtResult.append("============================\n");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MemberVO>> call, Throwable t) {}
                });
            }
        });


        btnJson2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RetrofitClient.jsonService().jsonMember().enqueue(new Callback<MemberVO>() {
                    @Override
                    public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {

                        MemberVO member = response.body();

                        txtResult.setText("아이디: " + member.getUid() + "\n");
                        txtResult.append("이  름: " + member.getName() + "\n");
                        txtResult.append("휴대폰: " + member.getHp() + "\n");
                        txtResult.append("직  급: " + member.getPos() + "\n");
                        txtResult.append("부  서: " + member.getDep() + "\n");
                        txtResult.append("입사일: " + member.getRdate() + "\n");

                    }

                    @Override
                    public void onFailure(Call<MemberVO> call, Throwable t) {}
                });
            }
        });



        btnXml1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnXml2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.xmlService().xmlMember().enqueue(new Callback<MemberVO>() {
                    @Override
                    public void onResponse(Call<MemberVO> call, Response<MemberVO> response) {
                        MemberVO member = response.body();

                        txtResult.setText("아이디: " + member.getUid() + "\n");
                        txtResult.append("이  름: " + member.getName() + "\n");
                        txtResult.append("휴대폰: " + member.getHp() + "\n");
                        txtResult.append("직  급: " + member.getPos() + "\n");
                        txtResult.append("부  서: " + member.getDep() + "\n");
                        txtResult.append("입사일: " + member.getRdate() + "\n");
                    }

                    @Override
                    public void onFailure(Call<MemberVO> call, Throwable t) {}
                });
            }
        });

    } //onCreate end

}
