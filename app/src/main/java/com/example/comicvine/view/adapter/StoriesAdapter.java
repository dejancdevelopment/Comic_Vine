package com.example.comicvine.view.adapter;

import android.content.Context;
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
import com.example.comicvine.data.model_characters.ResultsByCharacters;

import java.util.ArrayList;
import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyHolder>
implements Filterable {

    List<ResultsByCharacters> mList;
    List<ResultsByCharacters> searchList;
    Context context;

    public StoriesAdapter(List<ResultsByCharacters> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public StoriesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stories, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesAdapter.MyHolder holder, int position) {

        final ResultsByCharacters results = mList.get(holder.getAdapterPosition());

        holder.name.setText(results.getName());
        holder.publisher.setText(results.getPublisher().getName());
        holder.deck.setText(results.getDeck());

        Glide.with(context).load(results.getImage().getMedium_url())
                .into(holder.stories_image);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,publisher,deck;
        ImageView stories_image;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.stories_name);
            publisher=itemView.findViewById(R.id.stories_by);
            deck=itemView.findViewById(R.id.stories_deck);
            stories_image=itemView.findViewById(R.id.stories_image_);

        }
    }

    @Override
    public Filter getFilter() {
        return issuesFilter;
    }

    private Filter issuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ResultsByCharacters> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(searchList);
            } else {

                String filterName = constraint.toString().toLowerCase().trim();

                for (ResultsByCharacters results : searchList) {

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
