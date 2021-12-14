package com.polariumx.infociclos;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.polariumx.infociclos.databinding.ActivitySignUpBinding;
import com.polariumx.infociclos.misc.ProgressBarAnimation;
import com.polariumx.infociclos.models.UserModel;
import com.polariumx.infociclos.sampleData.SampleData;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private int progress = 25;
    private int animDurationMult = 5;

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
        binding.activitySignUpGradeEditText.setAdapter(getDropdownAdapter());
        binding.activitySignUpRadioGroup.setOnCheckedChangeListener(progressListener());
        binding.activitySignUpProgressBar.setMax(binding.activitySignUpProgressBar.getMax() * animDurationMult);
        binding.activitySignUpSignUpButton.setOnClickListener(toNavigateConditions(MainMenuActivity.class));
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
                ProgressBarAnimation anim;
                ProgressBar pB = binding.activitySignUpProgressBar;
                if (editable.toString().isEmpty()) {
                    anim = new ProgressBarAnimation(pB, pB.getProgress(), pB.getProgress() - progress * animDurationMult);
                    anim.setDuration(1000);
                    pB.startAnimation(anim);
                    shouldChange = true;
                } else if (shouldChange) {
                    anim = new ProgressBarAnimation(pB, pB.getProgress(), pB.getProgress() + progress * animDurationMult);
                    anim.setDuration(1000);
                    pB.startAnimation(anim);
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
                ProgressBarAnimation anim;
                ProgressBar pB = binding.activitySignUpProgressBar;
                switch (editable.toString()) {
                    case "DAM1":
                    case "DAM2":
                    case "DAW1":
                    case "DAW2":
                        shouldReduce = true;
                        anim = new ProgressBarAnimation(pB, pB.getProgress(), pB.getProgress() + progress * animDurationMult);
                        anim.setDuration(1000);
                        pB.startAnimation(anim);
                        break;
                    default:
                        if (shouldReduce) {
                            anim = new ProgressBarAnimation(pB, pB.getProgress(), pB.getProgress() - progress * animDurationMult);
                            anim.setDuration(1000);
                            pB.startAnimation(anim);
                            shouldReduce = false;
                        }
                }
            }
        };
    }

    private RadioGroup.OnCheckedChangeListener progressListener() {
        return new RadioGroup.OnCheckedChangeListener() {
            boolean canChange = true;

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ProgressBarAnimation anim;
                ProgressBar pB = binding.activitySignUpProgressBar;
                if (canChange) {
                    anim = new ProgressBarAnimation(pB, pB.getProgress(), pB.getProgress() + progress * animDurationMult);
                    anim.setDuration(1000);
                    pB.startAnimation(anim);
                    canChange = false;
                }
            }
        };
    }


    private View.OnClickListener toNavigateConditions(Class c) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.activitySignUpProgressBar.getProgress() == binding.activitySignUpProgressBar.getMax()) {
                    binding.activitySignUpSpinner.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getApplicationContext(), c);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("data", getData());
                    startActivity(intent);
                    finish();
                } else {
                    Snackbar myS = Snackbar.make(binding.getRoot(), getString(R.string.fill_credentials_generic), 5000);
                    myS.show();
                }
            }
        };
    }

    private UserModel getData() {
        UserModel userdata = new UserModel();
        userdata.setUsername(binding.activitySignUpEmailEditText.getText().toString());
        userdata.setPassword(binding.activitySignUpPasswordEditText.getText().toString());

        switch (binding.activitySignUpGradeEditText.getText().toString().toUpperCase()) {
            case "DAM1":
                userdata.setGrado(SampleData.DAM1);
                break;
            case "DAM2":
                userdata.setGrado(SampleData.DAM2);
                break;
            case "DAW1":
                userdata.setGrado(SampleData.DAW1);
                break;
            case "DAW2":
                userdata.setGrado(SampleData.DAW2);
                break;
        }

        String time = binding.activitySignUpTimeSwitch.isChecked() ? getString(R.string.generic_form_partial_time) : getString(R.string.generic_form_full_time);
        userdata.setTiempo(time);

        String shift = binding.activitySignUpRadioGroup.getCheckedRadioButtonId() == 0 ? getString(R.string.form_time_morning) : getString(R.string.form_time_afternoon);
        userdata.setHora(shift);
        return userdata;
    }

    private ArrayAdapter<String> getDropdownAdapter() {
        String[] course = {"DAM1", "DAM2", "DAW1", "DAW2"};
        return new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, course);
    }
}
