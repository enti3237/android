package kr.co.ch09.http;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionThread extends Thread {

    private Handler handler;
    private String addr;

    public HttpConnectionThread(Handler handler, String addr){
        this.handler = handler;
        this.addr = addr;
    }


    @Override
    public void run() {

        String response = request(addr);

        Message msg = new Message();
        msg.what = 1;
        msg.obj = response;

        handler.sendMessage(msg);

    }


    //Http 요청 메서드
    //MainActivity 내에서는 실행할 수 없다

    public String request(String addr){

        String response = null;

        try {

            URL url = new URL(addr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if(conn != null){

                conn.setConnectTimeout(3000);
                conn.setUseCaches(false);

                if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                    // 페이지 요청 성공

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    while(true){

                        String line = br.readLine();

                        if(line == null){
                            break;
                        }

                        response += line+"\n";

                    }

                } else if(conn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND){
                    // 페이지 찾을 수 없음

                    response = "요청한 페이지를 찾을 수 없습니다.";
                }

                // 접속해제
                conn.disconnect();
            }

        } catch (Exception e) {

            return "Error : " + e.getMessage();

        }

        return response;
    }






}
