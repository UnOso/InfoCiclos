package com.polariumx.infociclos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.polariumx.infociclos.databinding.MainMenuContentListViewItemBinding;
import com.polariumx.infociclos.models.GradoModel;

public class GradoListAdapter extends BaseAdapter {
    private MainMenuContentListViewItemBinding binding;
    private GradoModel[] grados;
    private itemClickListener listener;


    public GradoListAdapter(GradoModel[] grados, itemClickListener listener) {
        this.grados = grados;
        this.listener = listener;
    }

    public GradoModel[] getGrados() {
        return grados;
    }

    public void setGrados(GradoModel[] grados) {
        this.grados = grados;
    }

    public itemClickListener getListener() {
        return listener;
    }

    public void setListener(itemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return grados.length;
    }

    @Override
    public Object getItem(int i) {
        return grados[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //TODO:Show stuff
        return null;
    }

    public interface itemClickListener{
        void radioButtonClicked();
    }
}
