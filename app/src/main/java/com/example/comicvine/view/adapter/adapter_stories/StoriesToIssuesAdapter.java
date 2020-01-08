package com.example.comicvine.view.adapter.adapter_stories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.DetailActivity;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_story_by_id.IssuesByStory;
import com.example.comicvine.data.model.model_story_by_id.ResultsStoryById;

import java.util.ArrayList;
import java.util.List;

public class StoriesToIssuesAdapter extends RecyclerView.Adapter<StoriesToIssuesAdapter.MyHolder> {

    List<IssuesByStory> mList;
    Context context;

    public StoriesToIssuesAdapter(List<IssuesByStory> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public StoriesToIssuesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sory_links_to_issues, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesToIssuesAdapter.MyHolder holder, int position) {

        final IssuesByStory results = mList.get(holder.getAdapterPosition());

        holder.link.setText(String.valueOf(results.getSite_detail_url()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri=Uri.parse(String.valueOf(results.getSite_detail_url()));
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView link;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            link=itemView.findViewById(R.id.story_to_issues_link_text);

        }
    }

}
