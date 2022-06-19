package com.test.a050_009_036_34_uas_ga.MODEL;

import com.google.gson.annotations.SerializedName;
import com.test.a050_009_036_34_uas_ga.MODEL.LocationMode;

import java.util.List;

public class ListLocationModel {
    @SerializedName("data")
    private List<LocationMode> mData;

    public ListLocationModel(List<LocationMode>mData){
        this.mData = mData;}

    public ListLocationModel(){
    }
    public List<LocationMode> getmData(){
        return mData;
    }
    public void setmData(List<LocationMode>mData){
        this.mData = mData;}
}
