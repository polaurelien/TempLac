package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfficherUnReleveActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        //Bundle b = getIntent().getExtras();
        //int x  = b.getInt("unevariable");
        //int NomLac  = b.getInt("NomLacAfficher");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_afficher_un_releve);
        Button btnQuitter = findViewById(R.id.btnQuitterAfficher);
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = 1;
                Intent intent = new Intent(AfficherUnReleveActivity.this, MainActivity.class);
                //intent.putExtra("NomLacAfficher", "TEST 1");
                //intent.putExtra("unevariable", x);
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

        DAOBDD releveBDD = new DAOBDD(this);

        TextView nomLac = findViewById(R.id.NomLacAfficher);
        TextView pos = findViewById(R.id.positionGPS);
        TextView heure = findViewById(R.id.tempAfficherHeure);
        TextView temp = findViewById(R.id.tempAfficher);

        releveBDD.open();
        Releve releve = new Releve()
        Cursor c = releveBDD.getDataReleve();
        nomLac.setText(DAOBDD.NUM_COL_NOM);

    }

}
