package com.example.comicvine.data.dbase;

import androidx.room.TypeConverter;

import com.example.comicvine.data.model.ImageIssues;
import com.example.comicvine.data.model.Volume;

public class Converters {

    @TypeConverter
    public static ImageIssues fromImages(String value){

        return value==null ? null : new ImageIssues(value);
    }

    @TypeConverter
    public static String dataToImages(ImageIssues imageIssues){
        return imageIssues==null ? null : imageIssues.getMedium_url();
    }


    @TypeConverter
    public static Volume fromVolume (String value){

        return value==null ? null : new Volume(value);
    }

    @TypeConverter
    public static String dataToVolume(Volume volume){
        return volume==null ? null : volume.getName();
    }
}
