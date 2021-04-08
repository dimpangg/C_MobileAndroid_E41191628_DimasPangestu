package com.tugas.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button firstFragment;
    private Button secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Proses inisialisasi object button
        firstFragment = findViewById(R.id.btn_first_page);
        secondFragment = findViewById(R.id.btn_second_page);

        // Pemberian fungsi onClick pada Button
        firstFragment.setOnClickListener(v -> loadFragment(new FirstFragment()));
        secondFragment.setOnClickListener(v -> loadFragment(new SecondFragment()));
    }

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Mengecek fragment yang di replace memiliki isi atau tidak
        if (fragment != null) {
            transaction.replace(R.id.frame_layout, fragment);
            transaction.commit();
        }
    }
}