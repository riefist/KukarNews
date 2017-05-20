package com.muhamadarief.kukarnews;

import com.muhamadarief.kukarnews.Model.Berita;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Muhamad Arief on 03/11/2016.
 */
public interface ApiInterface {

    //variabel base url
    public static String baseUrl = "http://kutaikartanegarakab.go.id/";

    //membuat instance retrofit
    Retrofit client = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // melakukan get
    @GET("ws_portal_kukar/index.php/api/webservice/channeltitle_channelid/id/3")
    Call<Berita> getDataBerita();


}
