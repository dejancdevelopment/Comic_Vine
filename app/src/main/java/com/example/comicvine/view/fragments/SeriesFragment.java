package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.comicvine.R;
import com.example.comicvine.data.model.model_series.ResultBySeries;
import com.example.comicvine.view.adapter.adapter_series.SeriesAdapter;
import com.example.comicvine.view.viewmodel.SeriesViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText filter_text;
    private SeriesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_episodes, container, false);

        recyclerView=view.findViewById(R.id.series_recycler_view);
        filter_text=view.findViewById(R.id.filter_text_series);
        filter_text.setCursorVisible(false);
        filter_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_text.setCursorVisible(true);
            }
        });

        SeriesViewModel viewModel=ViewModelProviders.of(this).get(SeriesViewModel.class);
        viewModel.getGetAllSeries().observe(this, new Observer<List<ResultBySeries>>() {
            @Override
            public void onChanged(List<ResultBySeries> resultBySeries) {

                adapter=new SeriesAdapter(resultBySeries,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });

        filter_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }

}
