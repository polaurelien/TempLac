package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class RechercheUnReleveActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher_un_releve);
        final DAOBDD bdd = new DAOBDD(this);
        bdd.open();
        final String[] lheure = new String[1];
        final String[] lelac = new String[1];
        String date;
        final CalendarView vueCalendrier = findViewById(R.id.calendrierRecherche);
        vueCalendrier.setOnDateChangerListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2){
                date = i+"-"+i1+"-"+i2;
            }
        });
        final Spinner heure = (Spinner) findViewById(R.id.listeHeureRecherche);
        final String[] lesHeures = {"00h", "6h", "12h", "18h"};
        final String[] lesLacs = {"Sainte-Croix", "Bourget", "Allos"};

        ArrayAdapter<String> dataAdapterR1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesHeures);
        dataAdapterR1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure.setAdapter(dataAdapterR1);
        heure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lheure[0] = String.valueOf(heure.getSelectedItem());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        ArrayAdapter<String> dataAdapterR2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesLacs);
        dataAdapterR2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure.setAdapter(dataAdapterR2);
        heure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lelac[0] = String.valueOf(heure.getSelectedItem());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        Button btnQuitter = findViewById(R.id.buttonQuitterRechercheReleve1);
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(RechercheUnReleveActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        btnQuitter.setOnClickListener(ecouteur1);

        Button btnRechercher = findViewById(R.id.btnRechercherUnReleve);
        View.OnClickListener ecouteur2 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(RechercheUnReleveActivity.this, AfficherUnReleveActivity.class);
                i.putExtra("EXTRA_HEURE",lheure[0]);
                i.putExtra("EXTRA_LAC",lelac[0]);
                i.putExtra("EXTRA_DATE",date);
                startActivity(intent);
                break;
            }
        };
        btnRechercher.setOnClickListener(ecouteur2);
    }
}
