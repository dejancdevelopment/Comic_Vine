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
import com.example.comicvine.data.model_by_id.PersonalCredits;

import java.util.List;

public class CharactersByIdRecyclerView extends RecyclerView.Adapter<CharactersByIdRecyclerView.MyHolder> {

    List<CharacterCredits> mList;
    Context context;

    public CharactersByIdRecyclerView(List<CharacterCredits> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public CharactersByIdRecyclerView.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.id_creator_litem_row,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersByIdRecyclerView.MyHolder holder, int position) {

        CharacterCredits characterCredits=mList.get(position);

        holder.cName.setText(characterCredits.getName());
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
