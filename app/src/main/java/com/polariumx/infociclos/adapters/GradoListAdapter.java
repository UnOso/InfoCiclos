package com.polariumx.infociclos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.polariumx.infociclos.databinding.MainMenuContentListViewItemBinding;
import com.polariumx.infociclos.models.GradoModel;
import com.polariumx.infociclos.models.ModuloModel;

public class GradoListAdapter extends BaseAdapter {
    private MainMenuContentListViewItemBinding binding;
    private GradoModel grado;

    private LayoutInflater layoutInflater;


    public GradoListAdapter(GradoModel grado) {
        this.grado = grado;
    }

    public GradoModel getGrado() {
        return grado;
    }

    public void setGrado(GradoModel grado) {
        this.grado = grado;
    }

    @Override
    public int getCount() {
        return grado.getModules().length;
    }

    @Override
    public ModuloModel getItem(int i) {
        return grado.getModules()[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            if (layoutInflater == null) {
                layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }

            binding = MainMenuContentListViewItemBinding.inflate(layoutInflater, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (MainMenuContentListViewItemBinding) view.getTag();
        }

        ModuloModel item = getItem(i);

        binding.mainMenuContentListViewItemTitle.setText(item.getTitle());
        binding.mainMenuContentListViewItemDescription.setText(item.getDescription());
        binding.mainMenuContentListViewItemRadioButton.setChecked(item.getValidated());
        binding.mainMenuContentListViewItemRadioButton.setEnabled(false);

        return binding.getRoot();
    }
}
