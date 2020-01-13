package kr.co.ch04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sub4Activity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);

        txtResult = findViewById(R.id.txt_result);

        findViewById(R.id.btn_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 이동하고자 하는 액티비티로부터 데이터를 수신받기 위해
                // srartAcriviryForResult() 메서드로 사용자입력 액티비티로 이동
                // 이때 다시 수신받을 때 사용하기 위한 임의의 코드(101)를 함께 전달함
                Intent intent = new Intent(getBaseContext(), UserActivity.class);
                startActivityForResult(intent, 101);
            }
        });

    } // onCreate end

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 어느 액티비티로부터 데이터를 수신하는지 구분하기 위해
        // 처음 srartAcriviryForResult() 요청을 했을 때
        // 전송한 코드로 데이터를 전송해주는 액티비티 데이터를 확인
        if(requestCode == 101){

            String uid = data.getStringExtra("uid");
            String name = data.getStringExtra("name");
            String hp = data.getStringExtra("hp");

            String result = " 아이디: " + uid + "\n 이름: " + name + "\n 휴대폰: " + hp;

            txtResult.setText(result);

        }
    }
}
