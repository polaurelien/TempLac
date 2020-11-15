package com.example.templac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //remplirTableLac();
        //viderTableLac();
        setContentView(R.layout.activity_main);
        Button btnAfficherUnReleve = findViewById(R.id.btnRecherche);
        View.OnClickListener ecouteur1 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, RechercheUnReleveActivity.class);
                startActivity(intent);

            }

        };
        btnAfficherUnReleve.setOnClickListener(ecouteur1);

        Button btnSaisie = findViewById(R.id.btnSaisie);
        View.OnClickListener ecouteur2 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SaisirUnReleveActivity.class);
                startActivity(intent);

            }

        };
        btnSaisie.setOnClickListener(ecouteur2);

        Button btnMoyenne = findViewById(R.id.btnMoyenne);
        View.OnClickListener ecouteur3 = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, MoyenneMensuelleActivity.class);
                startActivity(intent);
            }

        };
        btnMoyenne.setOnClickListener(ecouteur3);
    }

    public void remplirTableLac()
    {
        DAOBDD lacBDD = new DAOBDD(this);
        Lac lac1 = new Lac("Sainte-Croix", "43.771450", "6,189804");
        Lac lac2 = new Lac("Bourget", "45,729632", "5,869561");
        Lac lac3 = new Lac ("Allos", "44,234405","6,707939");
        lacBDD.open();
        lacBDD.insererLac(lac1);
        lacBDD.insererLac(lac2);
        lacBDD.insererLac(lac3);
        Cursor c = lacBDD.getDataLac();
        Toast.makeText(getApplicationContext(), " il y a " + String.valueOf(c.getCount()) + " lacs ", Toast.LENGTH_LONG).show();
    }

    public void afficherNbReleve()
    {
        DAOBDD bdd = new DAOBDD(this);
        bdd.open();
        Cursor c = bdd.getDataReleve();
        Toast.makeText(getApplicationContext(), " il y a " + String.valueOf(c.getCount()) + " releves ", Toast.LENGTH_LONG).show();
    }

    public void viderTableLac()
    {
        DAOBDD lacBDD = new DAOBDD(this);
        lacBDD.open();
        lacBDD.dropLac();
    }
}