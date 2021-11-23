package com.polariumx.infociclos;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.polariumx.infociclos.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private int progress = 25;

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
        binding.activitySignUpEmailEditText.addTextChangedListener(progressTextWatcher());
        binding.activitySignUpPasswordEditText.addTextChangedListener(progressTextWatcher());
        binding.activitySignUpGradeEditText.addTextChangedListener(progressAutoTextWatcher());
    }


    private TextWatcher progressTextWatcher() {
        return new TextWatcher() {
            private boolean shouldChange = true;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()){
                    binding.activitySignUpProgressBar.setProgress(binding.activitySignUpProgressBar.getProgress() - progress);
                    shouldChange = true;
                } else if(shouldChange){
                    binding.activitySignUpProgressBar.setProgress(binding.activitySignUpProgressBar.getProgress() + progress);
                    shouldChange = false;
                }
            }
        };
    }

    private TextWatcher progressAutoTextWatcher() {
        return new TextWatcher() {
            private boolean shouldReduce = false;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                switch(editable.toString()){
                        case "DAM1":
                        case "DAM2":
                        case "DAW1":
                        case "DAW2":
                            shouldReduce = true;
                            binding.activitySignUpProgressBar.setProgress(binding.activitySignUpProgressBar.getProgress() + progress);
                            break;
                        default:
                            if(shouldReduce)
                            binding.activitySignUpProgressBar.setProgress(binding.activitySignUpProgressBar.getProgress() - progress);
                            shouldReduce = false;
                    }
            }
        };
    }
}
