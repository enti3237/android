package kr.co.ch04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity {

    EditText editUid, editName, editHp;
    Button btnBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        editUid = findViewById(R.id.edt_uid);
        editName = findViewById(R.id.edt_name);
        editHp = findViewById(R.id.edt_hp);

    }

    public void btnBackListener(View v){

        String uid  = editUid.getText().toString();
        String name = editName.getText().toString();
        String hp   = editHp.getText().toString();

        Intent intent = new Intent(UserActivity.this, Sub4Activity.class);
        intent.putExtra("uid", uid);
        intent.putExtra("name", name);
        intent.putExtra("hp", hp);

        setResult(RESULT_OK, intent);

        finish();

    }


}
