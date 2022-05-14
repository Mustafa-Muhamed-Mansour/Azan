package com.azan.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.azan.checkInternet.NetworkChangeListen;

public class SplashViewModel extends ViewModel
{

    private MutableLiveData<Boolean> booleanMutableLiveData;

    public SplashViewModel()
    {
        booleanMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<Boolean> counterSplash()
    {
        new Handler()
                .postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        booleanMutableLiveData.postValue(true);
                    }
                }, 3500);

        return booleanMutableLiveData;
    }
}