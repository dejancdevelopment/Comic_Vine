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
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.view.adapter.adapter_characters.CharactersAdapter;
import com.example.comicvine.view.viewmodel.CharactersViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText filter_text;
    private CharactersAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        filter_text = view.findViewById(R.id.filter_text_characters);
        filter_text.setCursorVisible(false);
        filter_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_text.setCursorVisible(true);
            }
        });
        recyclerView = view.findViewById(R.id.characters_recycler_view);

        CharactersViewModel viewModel1=ViewModelProviders.of(this).get(CharactersViewModel.class);
        viewModel1.getGetAllCharacters().observe(this, new Observer<List<ResultsByCharacters>>() {
            @Override
            public void onChanged(List<ResultsByCharacters> resultsByCharacters) {

                adapter = new CharactersAdapter(resultsByCharacters, getContext());
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
