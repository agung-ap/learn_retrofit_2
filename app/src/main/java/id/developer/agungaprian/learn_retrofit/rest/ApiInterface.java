package id.developer.agungaprian.learn_retrofit.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by agungaprian on 29/07/17.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call loadMovies( @Query("api_key") String api_key);
}
