package com.arifur.footballscore.Api;

import com.arifur.footballscore.Model.StatModels.LeagueStatisticsModel;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Statistics_Api {
    private static final String url = "https://v2.api-football.com//leagueTable/";
    private static final String api_token = "a08d8f10a09686bb388e5e8b51d0beab";


    private static StatService statService;

    public static StatService getscoreService() {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request mainrequest = chain.request();
                    Request request = mainrequest.newBuilder()
                            .addHeader("x-rapidapi-key", api_token)
                            .build();

                    return chain.proceed(request);
                }
            });
            OkHttpClient client = httpClient.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            statService = retrofit.create(StatService.class);


            return statService;
        }
        public interface StatService {
            @GET("524")
            Call<LeagueStatisticsModel> getStandings();
        }

    }
