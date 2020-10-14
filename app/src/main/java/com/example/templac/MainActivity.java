package com.example.templac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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
    }
}