package com.polariumx.infociclos.display;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.polariumx.infociclos.databinding.ActivityListViewBinding;
import com.polariumx.infociclos.databinding.ActivityLogInBinding;

public class ListViewActivity extends AppCompatActivity {

    private ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }
}