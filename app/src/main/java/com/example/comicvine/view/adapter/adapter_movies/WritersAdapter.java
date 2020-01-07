package com.example.comicvine.view.adapter.adapter_movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicvine.R;
import com.example.comicvine.data.model.model_movies.Writers;

import java.util.ArrayList;

public class WritersAdapter extends RecyclerView.Adapter<WritersAdapter.MyHolder> {

    ArrayList<Writers> mList;
    Context context;

    public WritersAdapter(ArrayList<Writers> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public WritersAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.id_creator_litem_row,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WritersAdapter.MyHolder holder, int position) {

        Writers writers=mList.get(position);

        holder.cName.setText(writers.getName());
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
