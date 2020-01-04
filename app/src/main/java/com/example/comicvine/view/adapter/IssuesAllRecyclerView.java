package com.example.comicvine.view.adapter;

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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.DetailActivity;
import com.example.comicvine.R;
import com.example.comicvine.data.model_issues.IssuesResults;

import java.util.ArrayList;
import java.util.List;

public class IssuesAllRecyclerView extends RecyclerView.Adapter<IssuesAllRecyclerView.MyHolder>
        implements Filterable {

    List<IssuesResults> mList;
    List<IssuesResults> searchList;
    Context context;

    public IssuesAllRecyclerView(List<IssuesResults> mList, Context context) {
        this.mList = mList;
        this.searchList=new ArrayList<>(mList);
        this.context=context;
    }
    @NonNull
    @Override
    public IssuesAllRecyclerView.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_issues,parent,false);

        return new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull IssuesAllRecyclerView.MyHolder holder, int position) {

        final IssuesResults results=mList.get(holder.getAdapterPosition());

        holder.cTitle.setText(results.getVolume().getName()+ "\n\n");
        holder.iNumber.setText(results.getIssue_number());
        Glide.with(context).load(results.getImage().getMedium_url()).into(holder.cImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("ID","4000-"+results.getId());
                context.startActivity(intent);
            }
        });

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

    @Override
    public Filter getFilter() {
        return issuesFilter;
    }

    private Filter issuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<IssuesResults> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(searchList);
            } else {

                String filterName = constraint.toString().toLowerCase().trim();

                for (IssuesResults results : searchList) {

                    if (results.getVolume().getName().toLowerCase().contains(filterName)) {
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
