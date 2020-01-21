package kr.co.ch08.async;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressAsyncTask extends AsyncTask {

    private Context context;
    private ProgressBar progress;

    public ProgressAsyncTask(Context context, ProgressBar progress){
        this.context = context;
        this.progress = progress;
    }

    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "onPreExecute!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        int value = 0;

        for(int i=1 ; i<=100 ; i++){

            value++;
            publishProgress(value);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {

        int value = (int) values[0];
        progress.setProgress(value);
    }

    @Override
    protected void onPostExecute(Object o) {

    }

}
