package com.kupriyanov.movies;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEUTRAL = "Нейтральный";

    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewAuthor.setText(review.getAuthorNickname());
        holder.textViewReview.setText(review.getReviewText());
        String type = review.getType();
        int colorResId;
        if (type.equals(TYPE_POSITIVE)){
            colorResId = android.R.color.holo_green_light;
        } else if (type.equals(TYPE_NEUTRAL)){
            colorResId = android.R.color.holo_orange_light;
        } else {
            colorResId = android.R.color.holo_red_light;
        }
        int color = ContextCompat.getColor(
                holder.linearLayoutContainer.getContext(),
                colorResId
        );
        holder.linearLayoutContainer.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewAuthor;
        private final TextView textViewReview;
        private final LinearLayout linearLayoutContainer;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
            linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);
        }
    }
}
