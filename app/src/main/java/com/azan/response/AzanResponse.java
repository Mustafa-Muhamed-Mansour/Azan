package com.azan.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AzanResponse
{
    @SerializedName("query")
    private String nameOfCity;
    @SerializedName("items")
    private List<Items> items = null;

    public AzanResponse()
    {
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public List<Items> getItems() {
        return items;
    }
}
