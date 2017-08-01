package id.developer.agungaprian.learn_retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.developer.agungaprian.learn_retrofit.BuildConfig;
import id.developer.agungaprian.learn_retrofit.R;
import id.developer.agungaprian.learn_retrofit.model.Movie;

/**
 * Created by agungaprian on 01/08/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> mData;
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> data){
        mData = data;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //image url
        String imageUrl = BuildConfig.IMAGE_URL+"/w342"+
                mData.get(position).getPoster_path() +
                "?api_key?="+BuildConfig.API_KEY;

        //load image to image view
        Picasso.with(mContext)
                .load(imageUrl)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}
