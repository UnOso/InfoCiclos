package com.polariumx.infociclos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.polariumx.infociclos.databinding.ActivityLogInBinding;
import com.polariumx.infociclos.models.UserModel;
import com.polariumx.infociclos.sampleData.SampleData;

public class LogInActivity extends AppCompatActivity {

    private ActivityLogInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }


    @Override
    protected void onStart() {
        super.onStart();
        setupUI();
    }

    private void setupUI(){
        binding.activityLogInLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCredentials()){
                    Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                    intent.putExtra("data", getData());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else{
                    Snackbar myS = Snackbar.make(binding.getRoot(), "Introduzca las Credenciales", 5000);
                    myS.show();
                }
            }
        });
    }

    private boolean checkCredentials(){
        return binding.activityLogInEmailEditText.getText().toString().equalsIgnoreCase("luis") && binding.activityLogInPasswordEditText.getText().toString().equals("123456");
    }

    private UserModel getData(){
        UserModel userdata = new UserModel();
        userdata.setUsername("Luis");
        userdata.setPassword("123456");
        userdata.setGrado(SampleData.DAM2);
        userdata.setTiempo("Completo");
        userdata.setHora("Mañana");
        return userdata;
    }
}