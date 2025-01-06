package com.mirea.kateninva.fragmentmanagerapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;

    public CountryListFragment() {

    }

    public static CountryListFragment newInstance(String param1) {
        CountryListFragment fragment = new CountryListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    private ListView countryListView;
    private Map<String, String> data;

    private ShareViewModel viewModel;

    public static Map<String, String> createCountryMap() {
        Map<String, String> countryMap = new HashMap<>();

        countryMap.put("United States", "A large country in North America known for its diverse landscapes and culture.");
        countryMap.put("Canada", "The second-largest country in the world, located in North America and known for its vast wilderness and friendly people.");
        countryMap.put("France", "A European country famous for its art, cuisine, and fashion.");
        countryMap.put("Japan", "An island nation in East Asia known for its advanced technology and rich cultural traditions.");
        countryMap.put("Brazil", "The largest country in South America, famous for its vibrant culture, beaches, and rainforests.");

        return countryMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);
        countryListView = view.findViewById(R.id.country_list_view);
        data = createCountryMap();
        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        List<String> countryNames = new ArrayList<>(data.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, countryNames);
        countryListView.setAdapter(adapter);
        System.out.println(data.size());

        countryListView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedCountry = countryNames.get(position);
            viewModel.setSomeValue(data.get(selectedCountry));
        });

        return view;
    }
}