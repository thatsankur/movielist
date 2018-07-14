package loot.newspoint.indiatimes.com.demo;

import java.util.Random;

public class CartoonMovie implements Movie {
    private int index;

    public CartoonMovie(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Movie" + index;
    }

    @Override
    public String getSynopsys() {
        return "This is Movie Description " + index;
    }

    @Override
    public String getPosterUrl() {
        return "http://image.tmdb.org/t/p/w500/6u85CuvnbrzWMhKbGk4Bm5RnO3V.jpg";
    }

    @Override
    public float getRaiting() {
        return randFloat(0.0f, 5.0f);
    }

    public float randFloat(float min, float max) {
        Random rand = new Random();
        float result = rand.nextFloat() * (max - min) + min;
        return result;
    }

    @Override
    public int getRank() {
        return index;
    }
}
