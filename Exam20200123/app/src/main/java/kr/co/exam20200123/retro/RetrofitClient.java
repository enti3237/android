package kr.co.exam20200123.retro;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://chhak.kr";
    private static Retrofit retrofit = null;

    private static MyAPI myXmlApi  = null;
    private static MyAPI myJsonApi = null;


    public static MyAPI jsonService(){
        if(myJsonApi == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            myJsonApi = retrofit.create(MyAPI.class);
        }
        return myJsonApi;
    }

    public static  MyAPI xmlService(){
        if(myXmlApi == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();

            myXmlApi = retrofit.create(MyAPI.class);
        }
        return myXmlApi;
    }

}
