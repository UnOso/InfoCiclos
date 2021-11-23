package com.polariumx.infociclos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.polariumx.infociclos.adapters.GradoListAdapter;
import com.polariumx.infociclos.databinding.ActivityMainMenuBinding;
import com.polariumx.infociclos.display.ListViewActivity;

public class MainMenuActivity extends AppCompatActivity implements GradoListAdapter.itemClickListener {

    private ActivityMainMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        setSupportActionBar(binding.activityMainMenuToolbar.getRoot());

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Modulos");
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupUI();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.main_menu_item_profile) {
            //TODO: Show Profile
            return true;
        } else if (item.getItemId() == R.id.main_menu_item_log_out) {
            //TODO: Go back to Main Screen
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    private void setupUI() {
         binding.activityMainMenuListButton.setOnClickListener(toNavigate(ListViewActivity.class));

    }

    @Override
    public void radioButtonClicked() {

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
