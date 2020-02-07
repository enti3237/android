package kr.co.exam20200123.http;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.http.Url;

public class HttpURLConnectionThread extends Thread {

    private static final String TAG = "MyTag";
    private Handler handler;
    private String addr;

    public HttpURLConnectionThread(Handler handler, String addr){
        this.handler = handler;
        this.addr = addr;
    }

    @Override
    public void run() {
        String response = request(addr);

        Log.i(TAG, "run: 스레드의 run 시작");
        Message msg = new Message();
        msg.what = 1;
        msg.obj = response;

        handler.sendMessage(msg);
    }

    /* http 요청 메서드 - MainActinity 내에서는 실행 불가능 */

    public String request(String addr){

        Log.i(TAG, "request: 리퀘스트 메서드 시작");
        String response = null;

        try {

            URL url = new URL(addr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if(conn != null){

                conn.setConnectTimeout(3000);
                conn.setUseCaches(false);

                // 페이지 요청 성공
                if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    while(true){

                        String line = br.readLine();
                        if(line == null){break;}
                        response += line+"\n";

                    }

                    Log.i(TAG, "request: while문 반복 끝");

                // 페이지 찾을 수 없음
                } else if(conn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND){
                    response = "요청한 페이지를 찾을 수 없습니다.";
                }
                // 접속해제
                conn.disconnect();
            }
        } catch (Exception e) {return "Error : " + e.getMessage();}

        return response;
    }



}
