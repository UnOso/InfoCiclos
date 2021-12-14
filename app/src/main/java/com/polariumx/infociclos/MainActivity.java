package com.polariumx.infociclos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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

    @Override
    protected void onResume() {
        super.onResume();
        runAnimations();
    }

    private void setupUI(){
        binding.activityMainSignUpButton.setOnClickListener(toNavigate(SignUpActivity.class));
        binding.activityMainLogInButton.setOnClickListener(toNavigate(LogInActivity.class));
    }

    private void runAnimations() {
        Animation fallAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        fallAnim.reset();
        addAnimation(binding.activityMainOnboardingText, fallAnim);
        addAnimation(binding.activityMainImage, fallAnim);
        addAnimation(binding.activityMainButtonsLayout, fallAnim);
    }

    private void addAnimation(View v, Animation anim){
        v.clearAnimation();
        v.startAnimation(anim);
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