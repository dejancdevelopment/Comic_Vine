package com.example.comicvine.view.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.comicvine.DetailActivity;
import com.example.comicvine.R;
import com.example.comicvine.data.model.IssuesResults;

import java.util.ArrayList;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.MyHolder>
implements Filterable {

    List<IssuesResults> mList;
    List<IssuesResults> searchList;
    Context context;

    public CharactersAdapter(List<IssuesResults> mList, Context context) {
        this.mList = mList;
        this.searchList = new ArrayList<>(mList);
        this.context = context;
    }

    @NonNull
    @Override
    public CharactersAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_linear_change, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.MyHolder holder, int position) {

        final IssuesResults results = mList.get(holder.getAdapterPosition());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        public MyHolder(@NonNull View itemView) {
            super(itemView);

        }


    }

    @Override
    public Filter getFilter() {
        return issuesFilter;
    }

    private Filter issuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<IssuesResults> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(searchList);
            } else {

                String filterName = constraint.toString().toLowerCase().trim();

                for (IssuesResults results : searchList) {

                    if (results.getVolume().getName().toLowerCase().contains(filterName)) {
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
