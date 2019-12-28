package com.example.comicvine.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.comicvine.R;
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.List;

public class DetailFragment extends Fragment {

    String id;

    public DetailFragment(String id) {
        this.id=id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_detail,container,false);

        IssuesViewModel viewModel= ViewModelProviders.of(this).get(IssuesViewModel.class);

        viewModel.getIssueById(id);

        viewModel.getByIdLiveData().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {


            }
        });


        return view;
    }
}
