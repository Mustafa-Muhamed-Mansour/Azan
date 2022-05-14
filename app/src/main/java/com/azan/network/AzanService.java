package com.azan.network;

import com.azan.response.AzanResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AzanService
{
    @GET("{countryName}.json")
    Call<AzanResponse> getAzan(@Path("countryName") String cityName);
}
