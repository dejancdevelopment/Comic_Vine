package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.comicvine.view.fragment.DetailFragment;
import com.example.comicvine.view.fragment.FragmentAllIssues;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent=getIntent();

        if(getIntent() != null){

            String allIssues=intent.getStringExtra("ISSUES");
            String id=intent.getStringExtra("ID");

            if(id != null){

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new DetailFragment(id))
                        .commit();

            }
            else if (allIssues != null && allIssues.contains("allIssues")) {

                FragmentAllIssues allIssuesFragment=new FragmentAllIssues();
                Bundle bundle=new Bundle();
                bundle.putString("ALL","allIssues");
                allIssuesFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, allIssuesFragment)
                        .commit();

            }else if(allIssues != null && allIssues.contains("venom")){

                FragmentAllIssues allIssuesFragment=new FragmentAllIssues();
                Bundle bundle=new Bundle();
                bundle.putString("ALL","allVenom");
                allIssuesFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, allIssuesFragment)
                        .commit();
            }
        }
    }
}
