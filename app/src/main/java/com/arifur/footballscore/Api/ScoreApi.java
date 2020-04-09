package com.arifur.footballscore.Api;

import com.arifur.footballscore.Model.Fixtures.LeagueFixtureModel;
import com.arifur.footballscore.Model.LeagueScoreModel;
import com.arifur.footballscore.Model.Round;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ScoreApi {

    private static final String api = "https://raw.githubusercontent.com/openfootball/football.json/master/";
    private static final String live_fixtures = "https://v2.api-football.com//fixtures/live/";
    private static final String api_token = "a08d8f10a09686bb388e5e8b51d0beab";
    private static ScoreService scoreService;
    private static FixtureInPlay fixtureInPlay;

    public static ScoreService getscoreService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        scoreService = retrofit.create(ScoreService.class);

        return scoreService;
    }

    public static FixtureInPlay getFixtureInPlay() {

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
                .baseUrl(live_fixtures)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        fixtureInPlay = retrofit.create(FixtureInPlay.class);


        return fixtureInPlay;
    }

    public interface ScoreService {
        @GET("2019-20/en.1.json")
        Call<LeagueScoreModel> getScoreList();
    }

    public interface FixtureInPlay {
        @GET("524")
        Call<LeagueFixtureModel> getLiveFixture();
    }
}
