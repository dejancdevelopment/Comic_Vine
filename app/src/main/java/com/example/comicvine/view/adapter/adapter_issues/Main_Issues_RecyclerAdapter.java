package com.example.comicvine.view.adapter.adapter_issues;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.DetailActivity;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_issues.IssuesResults;

import java.util.List;

public class Main_Issues_RecyclerAdapter extends RecyclerView.Adapter<Main_Issues_RecyclerAdapter.MyHolder> {

    List<IssuesResults> mList;
    Context context;

    public Main_Issues_RecyclerAdapter(List<IssuesResults> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public Main_Issues_RecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_issues, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Main_Issues_RecyclerAdapter.MyHolder holder, int position) {

        final IssuesResults results = mList.get(holder.getAdapterPosition());

        holder.cTitle.setText(results.getVolume().getName() + "\n\n");
        holder.iNumber.setText(results.getIssue_number());
        Glide.with(context).load(results.getImage().getMedium_url()).into(holder.cImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ID", "4000-" + results.getId());
                intent.putExtra("BY", "id");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView cTitle, iNumber;
        ImageView cImage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            iNumber = itemView.findViewById(R.id.issues_number);
            cImage = itemView.findViewById(R.id.comics_image);
            cTitle = itemView.findViewById(R.id.comics_title);
        }
    }
}
