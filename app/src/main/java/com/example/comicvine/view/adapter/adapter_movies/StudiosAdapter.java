package com.example.comicvine.view.adapter.adapter_movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicvine.R;
import com.example.comicvine.data.model.model_movies.Studios;

import java.util.List;

public class StudiosAdapter extends RecyclerView.Adapter<StudiosAdapter.MyHolder> {

    List<Studios> mList;
    Context context;

    public StudiosAdapter(List<Studios> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudiosAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.id_creator_litem_row,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudiosAdapter.MyHolder holder, int position) {

        Studios studios=mList.get(position);

        holder.cName.setText(studios.getName());
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
