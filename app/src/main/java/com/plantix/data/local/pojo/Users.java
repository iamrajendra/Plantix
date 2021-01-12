package com.plantix.data.local.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.plantix.data.database.dbpojo.Datum;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {

    private final static long serialVersionUID = -7734875689727979600L;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


}
