package kr.co.ch07.sqlite;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.ch07.R;

public class SQLiteActivity extends AppCompatActivity {

    private Button btnInsert, btnSelect;
    private EditText edtUid, edtName, edtHp;
    private Spinner spnnPos, spnnDep;

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        btnSelect   = findViewById(R.id.btn_select);
        btnInsert   = findViewById(R.id.btn_insert);
        edtUid      = findViewById(R.id.edt_uid);
        edtName     = findViewById(R.id.edt_name);
        edtHp       = findViewById(R.id.edt_hp);
        spnnPos     = findViewById(R.id.spnn_pos);
        spnnDep     = findViewById(R.id.spnn_dep);

        // 데이터베이스 생성
        dbHelper = new DBHelper(this);


        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SQLiteActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uid  = edtUid.getText().toString();
                String name = edtName.getText().toString();
                String hp   = edtHp.getText().toString();
                String pos  = spnnPos.getSelectedItem().toString();
                String dep  = spnnDep.getSelectedItem().toString();

                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO MEMBER VALUES ('"+uid+"', '"+name+"', '"+hp+"', '"+pos+"', '"+dep+"');");
                Toast.makeText(SQLiteActivity.this, "들어갔다네", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
