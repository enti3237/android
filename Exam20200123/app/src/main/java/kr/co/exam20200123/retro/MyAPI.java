package kr.co.exam20200123.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {

    @GET("/data/json/member")
    Call<MemberVO> jsonMember();

    @GET("/data/xml/member")
    Call<MemberVO> xmlMember();

}
