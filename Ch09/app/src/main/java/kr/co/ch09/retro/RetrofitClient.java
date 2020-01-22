package kr.co.ch09.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://chhak.kr";
    private static Retrofit retrofit = null;

    private static MyApi myHtmlApi = null;
    private static MyApi myJsonApi = null;
    private static MyApi myXmlApi = null;

    public static  MyApi htmlService(){
        if(myHtmlApi == null) {
            retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .build();

            myHtmlApi = retrofit.create(MyApi.class);
        }

        return myHtmlApi;
    }

    public static  MyApi jsonService(){
        if(myJsonApi == null) {
            retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

            myJsonApi = retrofit.create(MyApi.class);
        }

        return myJsonApi;
    }

    public static  MyApi xmlService(){
        if(myXmlApi == null) {
            retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(SimpleXmlConverterFactory.create())
                            .build();

            myXmlApi = retrofit.create(MyApi.class);
        }

        return myXmlApi;
    }

}
