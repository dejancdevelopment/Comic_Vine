package com.example.comicvine.view.adapter;

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
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.data.model_by_id.PersonalCredits;

import java.util.List;

public class CreatorsByIdRecyclerView extends RecyclerView.Adapter<CreatorsByIdRecyclerView.MyHolder> {

    List<PersonalCredits> mList;
    Context context;

    public CreatorsByIdRecyclerView(List<PersonalCredits> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public CreatorsByIdRecyclerView.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.id_creator_litem_row,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatorsByIdRecyclerView.MyHolder holder, int position) {

        PersonalCredits personalCredits=mList.get(position);

        holder.cName.setText(personalCredits.getName());
        holder.cRole.setText(personalCredits.getRole());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView cName,cRole;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cName=itemView.findViewById(R.id.id_name_creators);
            cRole=itemView.findViewById(R.id.id_role_creators);

        }
    }
}
