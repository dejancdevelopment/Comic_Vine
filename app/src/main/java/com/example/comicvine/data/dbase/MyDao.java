package com.example.comicvine.data.dbase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.comicvine.data.model_issues.IssuesResults;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setAllIssuesToDao(List<IssuesResults> allIssuesToDao);

    @Query("select * from issues_")
    LiveData<List<IssuesResults>> getAllIssuesFromDao();

}
