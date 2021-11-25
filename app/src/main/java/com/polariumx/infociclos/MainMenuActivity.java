package com.polariumx.infociclos;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.polariumx.infociclos.databinding.ActivityMainMenuBinding;
import com.polariumx.infociclos.display.GridViewActivity;
import com.polariumx.infociclos.display.ListViewActivity;
import com.polariumx.infociclos.models.UserModel;

public class MainMenuActivity extends AppCompatActivity {

    private ActivityMainMenuBinding binding;
    private UserModel user;

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
        Bundle bund = getIntent().getExtras();
        user = (UserModel) bund.getSerializable("data");
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
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            intent.putExtra("data", user);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.main_menu_item_log_out) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    private void setupUI() {
         binding.activityMainMenuListButton.setOnClickListener(toNavigate(ListViewActivity.class));
         binding.activityMainMenuGridButton.setOnClickListener(toNavigate(GridViewActivity.class));
    }

    private View.OnClickListener toNavigate(Class c){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), c);
                intent.putExtra("data", user);
                startActivity(intent);
            }
        };
    }
}
