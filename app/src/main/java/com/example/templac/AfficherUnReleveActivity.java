package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
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

        String heure = "";
        String lac = "";
        String date = "";

        Intent intent = getIntent();
        if (intent != null) {
            heure = intent.getStringExtra("EXTRA_HEURE");
            lac = intent.getStringExtra("EXTRA_LAC");
            date = intent.getStringExtra("EXTRA_DATE");
        }


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
        Releve releve = releveBDD.getReleve();
        final String nomLacBdd = releveBDD.getLacFromReleve(releve.getId());
        final String posLacBdd = releveBDD.getLacWithNom(nomLacBdd).getLatitude() + "," + releveBDD.getLacWithNom(nomLacBdd).getLongitude();
        final String heureBdd = releve.getHeureReleve();
        final String tempBdd = releve.getTempReleve();
        nomLac.setText(nomLacBdd);
        pos.setText(posLacBdd);
        heure.setText
    }
}
