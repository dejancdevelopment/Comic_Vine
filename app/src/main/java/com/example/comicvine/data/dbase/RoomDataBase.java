package com.example.comicvine.data.dbase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.comicvine.data.model.IssuesResults;

@Database(entities = IssuesResults.class,version = 1)
@TypeConverters({Converters.class})
public abstract class RoomDataBase extends RoomDatabase {

    public abstract MyDao myDao();

    private static RoomDataBase INSTANCE;

    public  static synchronized RoomDataBase getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,RoomDataBase.class,"db_Issues")
                    .addCallback(new Callback() {
                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
