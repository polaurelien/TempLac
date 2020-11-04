package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Date;

public class SaisirUnReleveActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisir_un_releve);
        final DAOBDD bdd = new DAOBDD(this);
        bdd.open();
        final EditText nom = findViewById(R.id.editTextNomLac);
        final EditText date = findViewById(R.id.editTextDate);
        final EditText temp = findViewById(R.id.editTextSaisirTemp);
        final Spinner heure = (Spinner) findViewById(R.id.ListeHeureSaisir);

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
