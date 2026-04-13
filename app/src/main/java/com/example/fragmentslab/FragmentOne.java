package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView txtMessage;
    private Button btnAction;

    public FragmentOne() {
        super(R.layout.fragment_one); // layout associé
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        txtMessage = view.findViewById(R.id.txtMessageOne);
        btnAction = view.findViewById(R.id.btnActionOne);

        // Action bouton
        btnAction.setOnClickListener(v ->
                txtMessage.setText("Hello depuis Fragment A 🚀")
        );
    }

    // 🔍 Cycle de vie pour debug
    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("FragmentOne", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("FragmentOne", "onPause()");
    }
}