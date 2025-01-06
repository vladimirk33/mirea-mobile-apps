package com.mirea.kateninva.resultapifragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(click -> {
            String text = ((EditText) view.findViewById(R.id.edit_text)).getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("key", text);
            getChildFragmentManager()
                    .setFragmentResult("requestKey", bundle);
            BottomSheetFragment bottomSheet = new BottomSheetFragment();
            bottomSheet.show(getChildFragmentManager(),
                    "ModalBottomSheet");
        });
        return view;
    }
}