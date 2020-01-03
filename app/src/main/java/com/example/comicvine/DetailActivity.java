package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.comicvine.view.fragments.CharacterByIdFragment;
import com.example.comicvine.view.fragments.IssueByIdFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("ID");

        if (id != null && id.contains("4000")) {

            IssueByIdFragment byIdFragment = new IssueByIdFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ID", id);
            byIdFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail_container, byIdFragment)
                    .commit();
        }else if(id != null && id.contains("4005")){

            CharacterByIdFragment byIdFragment = new CharacterByIdFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ID", id);
            byIdFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail_container, byIdFragment)
                    .commit();
        }
    }
}
