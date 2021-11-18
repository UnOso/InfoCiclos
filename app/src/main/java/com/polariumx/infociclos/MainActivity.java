package com.polariumx.infociclos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.polariumx.infociclos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupUI();
    }

    private void setupUI(){
        binding.activityMainSignUpButton.setOnClickListener(toNavigate(SignUpActivity.class));
        binding.activityMainLogInButton.setOnClickListener(toNavigate(LogInActivity.class));
    }

    private View.OnClickListener toNavigate(Class c){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), c);
                startActivity(intent);
            }
        };

    }
}