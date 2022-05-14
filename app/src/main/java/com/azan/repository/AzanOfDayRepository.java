package com.azan.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.azan.network.AzanClient;
import com.azan.network.AzanService;
import com.azan.response.AzanResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AzanOfDayRepository
{
    private AzanService azanService;
    private HashMap<String, String> hashMap;

    public AzanOfDayRepository()
    {
        azanService = AzanClient.getRetrofit().create(AzanService.class);
        hashMap = new HashMap<>();
    }

    public LiveData<AzanResponse> getAzanOfDaily(String city)
    {
        MutableLiveData<AzanResponse> azanResponseMutableLiveData = new MutableLiveData<>();

        hashMap.put("city", city);
        hashMap.put("key", "c7dcfb73c754f6003621dbbc774b97aa");
        hashMap.put("fbclid", "IwAR3n_SnAzZ6L5aylJArJOBthG0ix_UxgdExo8-GQNmY_5GhQiHRIQw5WjhY");


        azanService
                .getAzan(city)
                .enqueue(new Callback<AzanResponse>()
                {
                    @Override
                    public void onResponse(Call<AzanResponse> call, Response<AzanResponse> response)
                    {
                        azanResponseMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<AzanResponse> call, Throwable t)
                    {
                        azanResponseMutableLiveData.postValue(null);
                    }
                });

        return azanResponseMutableLiveData;
    }

}
