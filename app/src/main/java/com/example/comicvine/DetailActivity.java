package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.example.comicvine.view.fragments.CharactersDetailFragment;
import com.example.comicvine.view.fragments.IssuesDetailFragment;


public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String by=intent.getStringExtra("BY");

        if (by.contains("id")) {

           String id = intent.getStringExtra("ID");

            IssuesDetailFragment issuesDetailFragment = new IssuesDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ID", id);
            issuesDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, issuesDetailFragment)
                    .commit();
        }else if(by.contains("name")){

            String name=intent.getStringExtra("NAME");

            CharactersDetailFragment charactersDetailFragment=new CharactersDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("NAME",name);
            charactersDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, charactersDetailFragment)
                    .commit();
        }
    }
}
