package com.tugas.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private Button btnShowMessage;

    // Dijalankan saat pembuatan view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    // Dijalankan ketika view sudah dibuat
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnShowMessage = view.findViewById(R.id.btn_toast);
        btnShowMessage.setOnClickListener(v -> Toast.makeText(getContext().getApplicationContext(), "Ini Fragment Kedua", Toast.LENGTH_SHORT).show());
    }
}
