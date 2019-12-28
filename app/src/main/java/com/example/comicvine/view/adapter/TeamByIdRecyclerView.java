package com.example.comicvine.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicvine.R;
import com.example.comicvine.data.model_by_id.CharacterCredits;
import com.example.comicvine.data.model_by_id.TeamCredits;

import java.util.List;

public class TeamByIdRecyclerView extends RecyclerView.Adapter<TeamByIdRecyclerView.MyHolder> {

    List<TeamCredits> mList;
    Context context;

    public TeamByIdRecyclerView(List<TeamCredits> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamByIdRecyclerView.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.id_creator_litem_row,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamByIdRecyclerView.MyHolder holder, int position) {

        TeamCredits teamCredits=mList.get(position);

        holder.cName.setText(teamCredits.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView cName;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cName=itemView.findViewById(R.id.id_name_creators);
        }
    }
}
