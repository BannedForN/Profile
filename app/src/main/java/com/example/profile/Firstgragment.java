package com.example.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;



public class Firstgragment extends Fragment {

    private TextView counterTextView;
    private int counter = 0;

    @Nullable
    @NonNull

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment, container, false);
        counterTextView = view.findViewById(R.id.counter);

        // Создаем всплывающее меню
        PopupMenu popupMenu = new PopupMenu(requireContext(), view.findViewById(R.id.counter));
        MenuInflater inflaterMenu = popupMenu.getMenuInflater();
        inflaterMenu.inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.increment) {
                    counter++;
                    counterTextView.setText(String.valueOf(counter));
                    return true;
                } else {
                    return false;
                }
            }
        });
        counterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });
        return view;
}
}
