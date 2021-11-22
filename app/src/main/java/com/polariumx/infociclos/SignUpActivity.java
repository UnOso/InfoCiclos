package com.polariumx.infociclos;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.polariumx.infociclos.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupUI();
    }

    private void setupUI() {
        binding.activitySignUpEmailEditText.addTextChangedListener(progressWatcher());
    }


    private TextWatcher progressWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty())
                    changeProgress(0);
                else
                    changeProgress(10);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    private void changeProgress(int progress) {
        binding.activitySignUpProgressBar.setProgress(binding.activitySignUpProgressBar.getProgress() + progress);
    }
}
