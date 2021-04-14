package com.tugas.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MoveForResultActivity extends AppCompatActivity {

    public static final int RESULT_CODE = 110;
    public static final String EXTRA_VALUE = "EXTRA_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);
    }
}