package com.azan.day;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.azan.repository.AzanOfDayRepository;
import com.azan.response.AzanResponse;

public class AzanOfDayViewModel extends ViewModel
{

    public AzanOfDayRepository azanOfDayRepository;

    public AzanOfDayViewModel()
    {
        azanOfDayRepository = new AzanOfDayRepository();
    }

    public LiveData<AzanResponse> getAzanOfDay(String city)
    {
        return azanOfDayRepository.getAzanOfDaily(city);
    }
}