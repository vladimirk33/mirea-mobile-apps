package com.mirea.kateninva.bottomnavigationapp;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mirea.kateninva.bottomnavigationapp.databinding.FragmentHomeBinding;
import com.mirea.kateninva.bottomnavigationapp.databinding.FragmentInformationBinding;
import com.mirea.kateninva.bottomnavigationapp.ui.home.HomeViewModel;

public class InformationFragment extends Fragment {

    private FragmentInformationBinding binding;

    private InformationViewModel mViewModel;

    public static InformationFragment newInstance() {
        return new InformationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(InformationViewModel.class);

        binding = FragmentInformationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}