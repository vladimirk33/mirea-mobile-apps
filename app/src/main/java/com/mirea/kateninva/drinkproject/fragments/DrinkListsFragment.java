package com.mirea.kateninva.drinkproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirea.kateninva.drinkproject.R;
import com.mirea.kateninva.drinkproject.recyclers.RandomDrinkRecyclerAdapter;
import com.mirea.kateninva.drinkproject.viewModels.DrinkListsFragmentViewModel;
import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.drinkproject.viewModels.DrinkListsFragmentViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class DrinkListsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DrinkListsFragment() {

    }

    public static DrinkListsFragment newInstance(String param1, String param2) {
        DrinkListsFragment fragment = new DrinkListsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private DrinkListsFragmentViewModel viewModel;

    private RecyclerView randomDrinkRecyclerView;
    private RandomDrinkRecyclerAdapter randomDrinkRecyclerAdapter;
    private List<Drink> randomDrinkList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        randomDrinkRecyclerView = view.findViewById(R.id.random_drink_recycler);
        randomDrinkRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        randomDrinkList = new ArrayList<>();
        randomDrinkRecyclerAdapter = new RandomDrinkRecyclerAdapter(randomDrinkList);
        randomDrinkRecyclerView.setAdapter(randomDrinkRecyclerAdapter);

        viewModel.getDrinkLiveData().observe(getViewLifecycleOwner(), drink -> {
            setupRandomDrinkDisplay(drink);
        });
        viewModel.getRandomDrink();
    }

    private void setupRandomDrinkDisplay(List<Drink> drinkList) {
        randomDrinkList.clear();
        randomDrinkList.addAll(drinkList);
        randomDrinkRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this, new DrinkListsFragmentViewModelFactory(getContext()))
                .get(DrinkListsFragmentViewModel.class);
        return inflater.inflate(R.layout.fragment_drink_lists, container, false);
    }
}