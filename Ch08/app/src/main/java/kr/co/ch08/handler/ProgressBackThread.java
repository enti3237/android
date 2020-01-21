package kr.co.ch08.handler;

import android.app.Notification;
import android.os.Handler;
import android.os.Message;


public class ProgressBackThread extends Thread {

    private Handler handler;
    private int value;

    public ProgressBackThread(Handler handler){
        this.handler = handler;
        value = 0;
    }


    @Override
    public void run() {

        for(int i=1 ; i<=100 ; i++){

            value++;

            Message msg = new Message();
            msg.what = 1;
            msg.arg1 = value;

            handler.sendMessage(msg);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
