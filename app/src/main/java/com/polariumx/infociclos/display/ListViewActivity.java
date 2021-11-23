package com.polariumx.infociclos.display;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.polariumx.infociclos.adapters.GradoListAdapter;
import com.polariumx.infociclos.databinding.ActivityListViewBinding;
import com.polariumx.infociclos.databinding.ActivityLogInBinding;
import com.polariumx.infociclos.models.UserModel;
import com.polariumx.infociclos.sampleData.SampleData;

public class ListViewActivity extends AppCompatActivity {

    private ActivityListViewBinding binding;
    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bund = getIntent().getExtras();
        user = bund.getParcelable("data");
        setupUI();
    }

    private void setupUI() {
        binding.mainListViewList.setAdapter(new GradoListAdapter(SampleData.DAM2));
        binding.mainListViewButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}