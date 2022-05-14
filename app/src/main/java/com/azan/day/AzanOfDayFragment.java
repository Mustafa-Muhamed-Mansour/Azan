package com.azan.day;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azan.databinding.AzanOfDayFragmentBinding;
import com.azan.response.AzanResponse;
import com.azan.response.Items;

import java.util.List;

public class AzanOfDayFragment extends Fragment
{

    private AzanOfDayFragmentBinding binding;
    private AzanOfDayViewModel azanOfDayViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = AzanOfDayFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


        initViewModel();
        clickFab();

    }

    private void initViewModel()
    {
        azanOfDayViewModel = new ViewModelProvider(requireActivity()).get(AzanOfDayViewModel.class);
    }

    private void clickFab()
    {
        binding.fabSearchCity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String cityName = binding.editCity.getText().toString();

                if (TextUtils.isEmpty(cityName))
                {
                    binding.editCity.setError("Please enter city name");
                    binding.editCity.requestFocus();
                    return;
                }

                else
                {

                    azanOfDayViewModel
                            .getAzanOfDay(cityName)
                            .observe(getViewLifecycleOwner(), new Observer<AzanResponse>()
                            {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onChanged(AzanResponse azanResponse)
                                {
                                    if (azanResponse != null)
                                    {
                                        binding.txtCity.setText(azanResponse.getNameOfCity());
                                        List<Items> items = azanResponse.getItems();
                                        binding.txtTimeFagr.setText(items.get(0).getAzanFajr());
                                        binding.txtTimeSunrise.setText(items.get(0).getAzanShurooq());
                                        binding.txtTimeDuhr.setText(items.get(0).getAzanDhuhr());
                                        binding.txtTimeAsr.setText(items.get(0).getAzanAsr());
                                        binding.txtTimeMaghrab.setText(items.get(0).getAzanMaghrib());
                                        binding.txtTimeIsha.setText(items.get(0).getAzanIsha());
                                    }

                                    else
                                    {
                                        Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}