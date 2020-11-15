package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoyenneMensuelleActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moyenne);



        Button btnQuitter = findViewById(R.id.btnQuitterMoyenne);
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MoyenneMensuelleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnQuitter.setOnClickListener(ecouteur1);


        final DAOBDD releveBDD = new DAOBDD(this);
        releveBDD.open();
/*
        TextView nomLac = findViewById(R.id.NomLacAfficher);
        TextView pos = findViewById(R.id.positionGPS);
        TextView heure = findViewById(R.id.tempAfficherHeure);
        final TextView temp = findViewById(R.id.tempAfficher);



        int str = Integer.parseInt(temp.getText().toString());
        Intent intent = new Intent(this, MoyenneMensuelleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("Temp", str);
        intent.putExtras(bundle);
        startActivity(intent);
*/
        final String[] lelac = new String[1];
        final Spinner listeLac = (Spinner) findViewById(R.id.listeNomLacMoyenne);
        final String[] lesLacs = {"Sainte-Croix", "Bourget", "Allos"};
        RadioButton btnFahr = findViewById(R.id.btnFahr);
        final RadioButton btnCelcius = findViewById(R.id.btnCelcius);
        final RadioGroup Choix = findViewById(R.id.btnChoix1);
        final TextView afficheMoyenne = findViewById(R.id.textViewMoyenne);
        final EditText dateTxt = findViewById(R.id.dateMoyenne);
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
             date = sdf.parse(String.valueOf(dateTxt.getText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        final String mois = String.valueOf(date.getMonth());
        final String annee = String.valueOf(date.getYear());
        Button btnAfficherMoyenne = findViewById(R.id.btnAfficherMoyenne);

        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesLacs);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listeLac.setAdapter(dataAdapterR);
        listeLac.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lelac[0] = String.valueOf(listeLac.getSelectedItem());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        btnAfficherMoyenne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int moyenne = releveBDD.getMoyenne(mois, annee, lelac[0]);
                if (Choix.getCheckedRadioButtonId() == R.id.btnCelcius) {
                    afficheMoyenne.setText(String.valueOf(moyenne) + " C.");
                } else {
                    moyenne = moyenne *(9/5)+32;
                    afficheMoyenne.setText(String.valueOf(moyenne) + " F.");
                }
            }

        });
    }
}