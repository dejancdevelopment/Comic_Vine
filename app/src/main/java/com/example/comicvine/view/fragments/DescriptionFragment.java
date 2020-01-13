package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.comicvine.R;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.view.viewmodel.CharactersViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view=inflater.inflate(R.layout.fragment_description, container, false);
        final TextView nameText=view.findViewById(R.id.text_character_name);
        final TextView descrText=view.findViewById(R.id.text_character_description);

        if (getArguments() != null) {

            String name = getArguments().getString("NAME_");

            CharactersViewModel viewModel1=ViewModelProviders.of(this).get(CharactersViewModel.class);
            viewModel1.getGetCharacterByName(name).observe(this, new Observer<List<ResultsByCharacters>>() {
                @Override
                public void onChanged(List<ResultsByCharacters> resultsByCharacters) {

                    nameText.setText(resultsByCharacters.get(0).getName());
                    descrText.setText(Html.fromHtml(resultsByCharacters.get(0).getDescription(), Html.FROM_HTML_MODE_LEGACY));
                }
            });

        }

        return view;
    }
}
