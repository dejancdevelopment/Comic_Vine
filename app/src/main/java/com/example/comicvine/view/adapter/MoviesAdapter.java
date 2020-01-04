package com.example.comicvine.view.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model_movies.ResultByMovies;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyHolder>
implements Filterable {

    List<ResultByMovies> mList;
    private List<ResultByMovies> searchList;
    Context context;

    public MoviesAdapter(List<ResultByMovies> mList, Context context) {
        this.mList = mList;
        this.searchList=new ArrayList<>(mList);
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MyHolder holder, int position) {

        final ResultByMovies results = mList.get(holder.getAdapterPosition());

        holder.name.setText(results.getName());
        holder.runtime.setText(results.getRuntime());
        holder.deck.setText(Html.fromHtml(results.getDeck(),Html.FROM_HTML_MODE_LEGACY));
        Glide.with(context).load(results.getImage()
                .getMedium_url()).into(holder.movie_image);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,deck,runtime,writers;
        ImageView movie_image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.movies_title);
            writers=itemView.findViewById(R.id.writers_movies);
            deck=itemView.findViewById(R.id.description_movies);
            movie_image=itemView.findViewById(R.id.movies_image);
            runtime=itemView.findViewById(R.id.runtime_movies);
        }
    }

    @Override
    public Filter getFilter() {
        return issuesFilter;
    }

    private Filter issuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ResultByMovies> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(searchList);
            } else {

                String filterName = constraint.toString().toLowerCase().trim();

                for (ResultByMovies results : searchList) {

                    if (results.getName().toLowerCase().contains(filterName)) {
                        filterList.add(results);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mList.clear();
            mList.addAll((List) results.values);
            notifyDataSetChanged();
        }

    };
}
