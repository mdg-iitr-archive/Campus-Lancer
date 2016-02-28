package com.aka.campus_lancer.data;

import com.aka.campus_lancer.BuildConfig;
import com.aka.campus_lancer.Persons;
import com.aka.campus_lancer.data.model.FeedsResponse;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * @author akshayaggarwal
 * @since 27-02-2016
 */
public interface Api {


    @GET("feeds")
    Call<FeedsResponse> hire();


}
