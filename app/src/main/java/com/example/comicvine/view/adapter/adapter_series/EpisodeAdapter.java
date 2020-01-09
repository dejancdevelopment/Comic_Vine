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
import com.example.comicvine.data.model.model_episodes.EpisodesResult;
import com.example.comicvine.data.model.model_series.ResultBySeries;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.MyHolder> {

    private List<EpisodesResult> mList;
    Context context;

    public EpisodeAdapter(List<EpisodesResult> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public EpisodeAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episode_by_name, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.MyHolder holder, int position) {

        final EpisodesResult results = mList.get(holder.getAdapterPosition());

        holder.name.setText(results.getName());
        holder.description.setText(Html.fromHtml(results.getDescription(),Html.FROM_HTML_MODE_LEGACY));
        Glide.with(context).load(results.getImage()
                .getMedium_url()).into(holder.episode_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,description;
        ImageView episode_image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.episode_title);
            description=itemView.findViewById(R.id.episode_description);
            episode_image=itemView.findViewById(R.id.episode_image);

        }
    }

}
