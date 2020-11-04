package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;

public class SaisirUnReleveActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisir_un_releve);
        final DAOBDD bdd = new DAOBDD(this);
        bdd.open();
        final String[] lheure = new String[1];
        final EditText nom = findViewById(R.id.editTextNomLac);
        final EditText date = findViewById(R.id.editTextDate);
        final EditText temp = findViewById(R.id.editTextSaisirTemp);
        final Spinner heure = (Spinner) findViewById(R.id.ListeHeureSaisir);
        final String[] lesHeures = {"00h", "6h", "12h", "18h"};

        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesHeures);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure.setAdapter(dataAdapterR);
        heure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lheure[0] = String.valueOf(heure.getSelectedItem());
                Toast.makeText(SaisirUnReleveActivity.this, "Vous avez choisie : " + "\nle compteur numéro : " + lheure[0], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*ArrayAdapter<String> dataAdaptaterR = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, lesHeures);
        dataAdaptaterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure.setAdapter(dataAdaptaterR);
        heure.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                lesHeures[0] = String.valueOf(heure.getSelectedItem());
            }

            public void onNothingSelected(AdapterView<?> adapterView)
            {}
        });*/

        Button btnQuitter = findViewById(R.id.btnQuitterSaisir);
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SaisirUnReleveActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnQuitter.setOnClickListener(ecouteur1);

        Button btnEnregistrer = findViewById(R.id.btnEnregistrerSaisir);
        View.OnClickListener ecouteur2 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Lac lac = bdd.getLacWithNom(nom.getText().toString());
                int idLac = lac.getId();
                Releve releve = new Releve(idLac, date.getText().toString(), heure.toString(), temp.getText().toString());
                bdd.insererReleve(releve);
                bdd.close();
                finish();
            }
        };
        btnQuitter.setOnClickListener(ecouteur1);
    }
}
