package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfficherUnReleveActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_afficher_un_releve);
        Button btnQuitter = findViewById(R.id.btnQuitterAfficher);
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfficherUnReleveActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnQuitter.setOnClickListener(ecouteur1);

        Button btnRetour = findViewById(R.id.btnRetourAfficher);
        View.OnClickListener ecouteur2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfficherUnReleveActivity.this, RechercheUnReleveActivity.class);
                startActivity(intent);
            }
        };
        btnRetour.setOnClickListener(ecouteur2);
    }
}
