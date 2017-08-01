package id.developer.agungaprian.learn_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import id.developer.agungaprian.learn_retrofit.adapter.MovieAdapter;
import id.developer.agungaprian.learn_retrofit.model.Movie;
import id.developer.agungaprian.learn_retrofit.model.MovieResponse;
import id.developer.agungaprian.learn_retrofit.rest.ApiClient;
import id.developer.agungaprian.learn_retrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.loadMovies("popular", BuildConfig.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movieList = response.body().getResults();
                Log.d(TAG, "number of movie received :" + movieList.size());

                initView();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }

    public void initView(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        adapter = new MovieAdapter(getApplicationContext(),movieList);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
    }
}
