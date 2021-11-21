package com.polariumx.infociclos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.polariumx.infociclos.databinding.ActivityLogInBinding;

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
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkCredentials(){
        return binding.activityLogInEmailEditText.getText().toString().equalsIgnoreCase("luis") && binding.activityLogInPasswordEditText.getText().toString().equals("123456");
    }
}