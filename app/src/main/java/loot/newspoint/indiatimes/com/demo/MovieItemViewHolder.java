package loot.newspoint.indiatimes.com.demo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {
     TextView name;
     TextView synopsys;
     RatingBar ratingBar;
     ImageView imageView;
    public MovieItemViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        synopsys = itemView.findViewById(R.id.synopsis);
        ratingBar = itemView.findViewById(R.id.rating);
        imageView = itemView.findViewById(R.id.image);
    }
}
