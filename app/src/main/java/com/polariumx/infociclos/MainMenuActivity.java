package com.polariumx.infociclos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.polariumx.infociclos.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

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
        if (item.getItemId() == R.id.main_menu_item_list) {
            //TODO: Show in list mode
            return true;
        } else if (item.getItemId() == R.id.main_menu_item_grid) {
            //TODO: Show in grid mode
            return true;
        } else if (item.getItemId() == R.id.main_menu_item_spinner) {
            //TODO: Show in spinner mode
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    private void setupUI() {
        binding.activityMainMenuListMode.mainMenuContentListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return null;
            }
        });
    }

}
