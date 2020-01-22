package kr.co.ch09.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyApi {

    @GET()
    Call<String> request(@Url String url);


    @GET("/data/json/members")
    Call<List<MemberVO>> jsonMembers();

    @GET("/data/json/member")
    Call<MemberVO> jsonMember();


    @GET("/data/xml/members")
    Call<List<MemberVO>> xmlMembers();

    @GET("/data/xml/member")
    Call<MemberVO> xmlMember();

}
