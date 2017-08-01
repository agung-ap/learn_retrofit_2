package id.developer.agungaprian.learn_retrofit.rest;

import id.developer.agungaprian.learn_retrofit.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by agungaprian on 29/07/17.
 */

public interface ApiInterface {
    @GET("/3/movie/{sort}")
    Call<MovieResponse> loadMovies(@Path("sort") String sort, @Query("api_key") String api_key);
}
