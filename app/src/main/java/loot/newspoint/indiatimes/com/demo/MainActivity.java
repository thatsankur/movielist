package loot.newspoint.indiatimes.com.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Movie> movies = getMovies();
        recyclerView = findViewById(R.id.movie_list);
        MovieListAdapter movieListAdapter = new MovieListAdapter(movies);
        movieListAdapter.setHasStableIds(false);
        recyclerView.setAdapter(movieListAdapter);
        GridLayoutManager g = new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
        g.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position>2?3:1;
            }
        });
        recyclerView.setLayoutManager(g);

    }

    private List<Movie> getMovies() {
        List<Movie> list = new ArrayList<>();
        for(int i=0;i<100;i++) {
            list.add(getMovie(i));
        }
        return list;
    }

    @NonNull
    private Movie getMovie(final int index) {
        return new CartoonMovie(index);
    }
}
