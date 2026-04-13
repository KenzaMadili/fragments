package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView tvResult;
    private SeekBar slider;
    private int currentValue = 0;
    private static final String KEY_VALUE = "key_value";

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvResult = view.findViewById(R.id.tvResult);
        slider = view.findViewById(R.id.sliderValue);

        // Restaurer l’état après rotation
        if (savedInstanceState != null) {
            currentValue = savedInstanceState.getInt(KEY_VALUE, 0);
            slider.setProgress(currentValue);
            tvResult.setText("Valeur actuelle : " + currentValue);
        }

        // Listener pour suivre les changements
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                currentValue = value;
                tvResult.setText("Valeur actuelle : " + value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_VALUE, currentValue);
    }
}