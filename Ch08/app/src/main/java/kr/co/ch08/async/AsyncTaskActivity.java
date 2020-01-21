package kr.co.ch08.async;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.ch08.R;

public class AsyncTaskActivity extends AppCompatActivity {

    private TextView txtMain, txtBack;
    private Button btnStart;
    private ProgressBar progress;

    private int mainValue = 0;
    private int backValue = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        txtMain = findViewById(R.id.txt_main);
        txtBack = findViewById(R.id.txt_back);
        btnStart = findViewById(R.id.btn_start);
        progress = findViewById(R.id.progress);

        IncreaseAsyncTask asyncTask = new IncreaseAsyncTask();
        asyncTask.execute();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(AsyncTaskActivity.this, "버튼 클릭!", Toast.LENGTH_SHORT).show();

                // 병행작업을 위해 필요한 명령어... 
                ProgressAsyncTask asyncTask = new ProgressAsyncTask(AsyncTaskActivity.this, progress);
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

            }
        });
    }


    class IncreaseAsyncTask extends AsyncTask<Integer, Boolean, String>{

        @Override
        protected void onPreExecute() {
            // 배경작업이 실행되기 전의 메인스레드(UI스레드)에서 실행

            Toast.makeText(AsyncTaskActivity.this, "배경작업 시작!", Toast.LENGTH_SHORT).show();
            backValue = 0;
        }

        @Override
        protected String doInBackground(Integer... integers) {
            // 배경작업을 실행하며 분리된 서브스레드에서 실행

            for(int i=1 ; i<=100 ; i++) {
                backValue++;

                //Boolean으로 보낸다. 값은 뭘 해도 상관없는 임의값
                publishProgress(true);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;

        }

        @Override
        protected void onProgressUpdate(Boolean... values) {
            // 배경작업doInBackground에서 publishProgress(Handler의 sendMessage)로 호출하는 메서드로 메인스레드에서 실행

            txtBack.setText("BackValue : " + backValue);
        }

        @Override
        protected void onPostExecute(String s) {
            // 배경작업이 끝난 후 실행되는 메서드, 메인스레드에서 실행
            Toast.makeText(AsyncTaskActivity.this, "배경작업 끝!", Toast.LENGTH_SHORT).show();

        }

    }

}
