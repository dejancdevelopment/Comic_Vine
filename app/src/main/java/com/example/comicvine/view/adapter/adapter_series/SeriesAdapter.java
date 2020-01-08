package com.example.comicvine.view.adapter.adapter_series;

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
import com.example.comicvine.data.model.model_series.ResultBySeries;

import java.util.ArrayList;
import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyHolder>
implements Filterable {

    List<ResultBySeries> mList;
    List<ResultBySeries> searchList;
    Context context;

    public SeriesAdapter(List<ResultBySeries> mList, Context context) {
        this.mList = mList;
        this.searchList=new ArrayList<>(mList);
        this.context = context;
    }

    @NonNull
    @Override
    public SeriesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_series, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesAdapter.MyHolder holder, int position) {

        final ResultBySeries results = mList.get(holder.getAdapterPosition());

        holder.name.setText(results.getName());
        holder.year.setText(results.getStart_year());
        holder.deck.setText(Html.fromHtml(results.getDescription(),Html.FROM_HTML_MODE_LEGACY));
        holder.number_of.setText(results.getCount_of_episodes());
        Glide.with(context).load(results.getImage()
                .getMedium_url()).into(holder.series_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("ID","4075-"+results.getId());
                intent.putExtra("BY","series");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,deck,year,number_of;
        ImageView series_image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.series_title);
            year=itemView.findViewById(R.id.year_series);
            deck=itemView.findViewById(R.id.description_series);
            number_of=itemView.findViewById(R.id.number_of_episodes);
            series_image=itemView.findViewById(R.id.series_image);

        }
    }

    @Override
    public Filter getFilter() {
        return issuesFilter;
    }

    private Filter issuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ResultBySeries> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(searchList);
            } else {

                String filterName = constraint.toString().toLowerCase().trim();

                for (ResultBySeries results : searchList) {

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
