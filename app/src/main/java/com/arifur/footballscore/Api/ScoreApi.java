package com.arifur.footballscore.Api;

import com.arifur.footballscore.Model.FootballScoreLiveBaseModel;
import com.arifur.footballscore.Model.RoundsModel.FootballRoundsModel;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ScoreApi {


    private static final String live_fixtures="https://v2.api-football.com//fixtures/";
    private static final String api_token="a08d8f10a09686bb388e5e8b51d0beab";
    private static final String round_score_url="https://raw.githubusercontent.com/openfootball/football.json/master/2019-20/";

    private static FixtureInPlay fixtureInPlay;
    private static RoundScore sRoundScore;


    public static FixtureInPlay getFixtureInPlay() {

        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request mainrequest=chain.request();
                Request request=mainrequest.newBuilder()
                        .addHeader("x-rapidapi-key", api_token)
                        .build();

                return chain.proceed(request);
            }
        });
        OkHttpClient client=httpClient.build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(live_fixtures)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        fixtureInPlay=retrofit.create(FixtureInPlay.class);


        return fixtureInPlay;
    }

    public  static  RoundScore getScoreRounded(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(round_score_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sRoundScore=retrofit.create(RoundScore.class);

        return  sRoundScore;
    }

    public interface RoundScore{
        @GET("en.1.json")
        Call<FootballRoundsModel> getRoundScore();
    }

    public interface FixtureInPlay {
        @GET("live/524")
        Call<FootballScoreLiveBaseModel> getLiveFixture();

        @GET("league/524/next/10")
        Call<FootballScoreLiveBaseModel> getNextFixtures();

        @GET("lineups/{fixture_id}")
        Call<FootballScoreLiveBaseModel> getLineUps();

        @GET("events/{fixture_id}")
        Call<FootballScoreLiveBaseModel> getEvents(@Path("fixture_id") String mfixture_id);
    }
}
