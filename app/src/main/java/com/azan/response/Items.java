package com.azan.response;

import com.google.gson.annotations.SerializedName;

public class Items
{
    @SerializedName("fajr")
    private String AzanFajr;
    @SerializedName("shurooq")
    private String AzanShurooq;
    @SerializedName("dhuhr")
    private String AzanDhuhr;
    @SerializedName("asr")
    private String AzanAsr;
    @SerializedName("maghrib")
    private String AzanMaghrib;
    @SerializedName("isha")
    private String AzanIsha;

    public Items()
    {
    }

    public String getAzanFajr() {
        return AzanFajr;
    }

    public String getAzanShurooq() {
        return AzanShurooq;
    }

    public String getAzanDhuhr() {
        return AzanDhuhr;
    }

    public String getAzanAsr() {
        return AzanAsr;
    }

    public String getAzanMaghrib() {
        return AzanMaghrib;
    }

    public String getAzanIsha() {
        return AzanIsha;
    }
}
