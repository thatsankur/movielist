package loot.newspoint.indiatimes.com.demo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

class MovieListAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {
    private final int SMALL = 0;
    private final int LARGE = 1;
    private final int DEFAULT = 2;
    private List<Movie> mMovies;

    public MovieListAdapter(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        switch (type) {
            case SMALL:
                return new MovieItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item_layout_small, null));
            case LARGE:
                return new MovieItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item_layout_big, null));
            default:
                return new MovieItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item_layout, null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder movieItemViewHolder, int position) {
        Movie m = mMovies.get(position);
        movieItemViewHolder.name.setText(m.getName());
        movieItemViewHolder.synopsys.setText(m.getSynopsys());
        movieItemViewHolder.ratingBar.setRating(m.getRaiting());
        movieItemViewHolder.imageView.setImageResource(R.drawable.ic_launcher_foreground);
        Picasso.with(movieItemViewHolder.imageView.getContext()).
                load(m.getPosterUrl()).into(movieItemViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 || position == 2 ? SMALL : (position == 1 ? LARGE : DEFAULT);
    }
}
