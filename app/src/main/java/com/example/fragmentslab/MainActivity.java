package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFragA, btnFragB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);

        // Charger le premier fragment par défaut
        if (savedInstanceState == null) {
            switchFragment(new FragmentOne(), false);
        }

        // Gestion des clics
        btnFragA.setOnClickListener(v -> switchFragment(new FragmentOne(), true));
        btnFragB.setOnClickListener(v -> switchFragment(new FragmentTwo(), true));
    }

    // Méthode de remplacement de fragment (même logique)
    private void switchFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.containerFragments, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}