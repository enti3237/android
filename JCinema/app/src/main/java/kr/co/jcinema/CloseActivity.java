package kr.co.jcinema;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CloseActivity extends AppCompatActivity {

    private Button btnCancel;
    private Button btnConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close);

        getSupportActionBar().hide();

        btnCancel  = findViewById(R.id.btn_cancel);
        btnConfirm = findViewById(R.id.btn_confirm);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CloseActivity.this, MainActivity.class);
                //startActicity가 아님
                setResult(101, intent);
                finish();

            }
        });

    }
}
