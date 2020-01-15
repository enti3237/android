package kr.co.userevent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_event);

        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.edittext);
        button   = findViewById(R.id.button);

    }

    public void onButtonClicked(View v) {
        // 버튼을 누르면 이 메소드가 호출됩니다.
        EditText input = (EditText) editText.getText();
        textView.setText((CharSequence) input);
    }
}
