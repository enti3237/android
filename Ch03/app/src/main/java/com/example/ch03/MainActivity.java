package com.example.ch03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3, btn4;

    private EditText insertText;
    private Button insertBtn ;
    private TextView selectText;

    private Button btnHobbyConfirm;
    private Set<String> hobbies = new HashSet<>();

    private CheckBox chk1, chk2, chk3, chk4;

    private Switch swcOff;

    private Spinner spnn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        insertText = findViewById(R.id.insertText);
        insertBtn  = findViewById(R.id.insertBtn);
        selectText = findViewById(R.id.selectText);

        chk1 = findViewById(R.id.chk_1);
        chk2 = findViewById(R.id.chk_2);
        chk3 = findViewById(R.id.chk_3);
        chk4 = findViewById(R.id.chk_4);
        btnHobbyConfirm = findViewById(R.id.btn_hobby_confirm);
        btnHobbyConfirm.setOnClickListener(this);

        swcOff = findViewById(R.id.swc_off);

        spnn1 = findViewById(R.id.spnn1);



        spnn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(cities[position] + " 선택되었습니다");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



/* 6. Switch 이벤트 */
        swcOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    swcOff.setText("스위치 켜졌다!!");
                } else {
                    swcOff.setText("스위치 꺼졌다...");
                }
            }
        });

        // 입력완료버튼 클릭
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable text = insertText.getText();
                selectText.setText(text);
            }
        });
        // 6. Switch 이벤트 끝



/* 2. Button 이벤트 기본방식 */
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


/* 5. CheckBox 이벤트 */
    @Override
    public void onClick(View v) {
        // 취미확인을 누를 경우
        String strHobby = "";
        Iterator it = hobbies.iterator();

        while(it.hasNext()){
            strHobby += it.next()+", ";
        }
        Toast.makeText(MainActivity.this, strHobby+" 입니다.", Toast.LENGTH_SHORT).show();
    }

    public void checkListener(View v){
        // 체크박스를 누를 경우
        switch (v.getId()) {
            case R.id.chk_1:

                if(chk1.isChecked()) {
                    hobbies.add("등산");
                } else {
                    hobbies.remove("등산");
                }
                break;
            case R.id.chk_2:
                if(chk2.isChecked()) {
                    hobbies.add("영화");
                } else {
                    hobbies.remove("영화");
                }
                break;
            case R.id.chk_3:
                if(chk3.isChecked()) {
                    hobbies.add("게임");
                } else {
                    hobbies.remove("게임");
                }
                break;
            case R.id.chk_4:
                if(chk4.isChecked()) {
                    hobbies.add("독서");
                } else {
                    hobbies.remove("독서");
                }
                break;
        }
    }

    // CheckBox 이벤트 끝


/* 2. Button 이벤트 추가 */
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

    // Button 이벤트 끝

} // MainActivity End
