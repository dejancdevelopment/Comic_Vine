package com.example.comicvine.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model.IssuesResults;

import java.util.List;

public class IronManRecyclerView extends RecyclerView.Adapter<IronManRecyclerView.MyHolder> {

    List<IssuesResults> mList;
    Context context;

    public IronManRecyclerView(List<IssuesResults> mList, Context context) {
        this.mList = mList;
        this.context=context;
    }

    @NonNull
    @Override
    public IronManRecyclerView.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_issues,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IronManRecyclerView.MyHolder holder, int position) {

        IssuesResults results=mList.get(holder.getAdapterPosition());

        holder.cTitle.setText(results.getVolume().getName()+ "\n\n");
        holder.iNumber.setText(results.getIssue_number());
        Glide.with(context).load(results.getImage().getMedium_url()).into(holder.cImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView cTitle,iNumber;
        ImageView cImage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            iNumber=itemView.findViewById(R.id.issues_number);
            cImage=itemView.findViewById(R.id.comics_image);
            cTitle=itemView.findViewById(R.id.comics_title);
        }
    }
}
