package com.example.comicvine.view.adapter.adapter_characters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.DetailActivity;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;

import java.util.ArrayList;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.MyHolder>
implements Filterable {

    List<ResultsByCharacters> mList;
    List<ResultsByCharacters> searchList;
    Context context;



    public CharactersAdapter(List<ResultsByCharacters> mList,Context context) {
        this.mList = mList;
        this.searchList=new ArrayList<>(mList);
        this.context = context;
    }

    @NonNull
    @Override
    public CharactersAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_characters, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.MyHolder holder, int position) {

        final ResultsByCharacters results = mList.get(holder.getAdapterPosition());

        holder.name.setText(results.getName());
        holder.real_name.setText(results.getReal_name());
        holder.deck.setText(results.getDeck());

        Glide.with(context).load(results.getImage().getMedium_url())
                .into(holder.character_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("NAME", results.getName());
                intent.putExtra("BY","name");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name,real_name,deck;
        ImageView character_image;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.characters_name);
            real_name=itemView.findViewById(R.id.characters_real_name);
            deck=itemView.findViewById(R.id.characters_deck);
            character_image=itemView.findViewById(R.id.characters_image_);

        }
    }

    @Override
    public Filter getFilter() {
        return issuesFilter;
    }

    private Filter issuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ResultsByCharacters> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(searchList);
            } else {

                String filterName = constraint.toString().toLowerCase().trim();

                for (ResultsByCharacters results : searchList) {

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
