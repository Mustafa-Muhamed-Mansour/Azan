package com.azan.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azan.R;
import com.azan.databinding.SplashFragmentBinding;

public class SplashFragment extends Fragment
{

    private SplashFragmentBinding binding;
    private SplashViewModel splashViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = SplashFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        initViewModel();
        observeViewModel(view);

    }


    private void initViewModel()
    {
        splashViewModel = new ViewModelProvider(requireActivity()).get(SplashViewModel.class);
    }

    private void observeViewModel(View view)
    {
        splashViewModel.counterSplash().observe(getViewLifecycleOwner(), new Observer<Boolean>()
        {
            @Override
            public void onChanged(Boolean aBoolean)
            {
                if (aBoolean)
                {
                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_azanOfDayFragment);
                }

                else
                {
                    Toast.makeText(requireActivity(), "في مشكلة اي هي بقي مش عارف", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}