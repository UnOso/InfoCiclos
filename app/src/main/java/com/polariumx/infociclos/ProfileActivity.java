package com.polariumx.infociclos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.polariumx.infociclos.adapters.GradoListAdapter;
import com.polariumx.infociclos.databinding.ActivityListViewBinding;
import com.polariumx.infociclos.databinding.ActivityProfileBinding;
import com.polariumx.infociclos.models.UserModel;
import com.polariumx.infociclos.sampleData.SampleData;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bund = getIntent().getExtras();
        user = (UserModel) bund.getSerializable("data");
        setupUI();
    }

    @SuppressLint("SetTextI18n")
    private void setupUI() {
        binding.profileUsername.setText("Nombre: " + user.getUsername());
        binding.profileGrado.setText("Grado: " + user.getGrado().getName());
        binding.profileJornada.setText("Jornada: " + user.getHora());
        binding.profileTiempo.setText("Tiempo: " + user.getTiempo());
        binding.profileButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}