package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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


        DAOBDD releveBDD = new DAOBDD(this);

        TextView nomLac = findViewById(R.id.NomLacAfficher);
        TextView pos = findViewById(R.id.positionGPS);
        TextView heure = findViewById(R.id.tempAfficherHeure);
        final TextView temp = findViewById(R.id.tempAfficher);



        int str = Integer.parseInt(temp.getText().toString());
        Intent intent = new Intent(this, AfficherUnReleveActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("Temp", str);
        intent.putExtras(bundle);
        startActivity(intent);


        RadioButton btnFahr = findViewById(R.id.btnFahr);
        final RadioButton btnCelcius = findViewById(R.id.btnCelcius);
        final RadioGroup Choix = findViewById(R.id.btnChoix1);
        Button btnAfficherMoyenne = findViewById(R.id.btnAfficherMoyenne);


        btnAfficherMoyenne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int s = Integer.parseInt(temp.getText().toString());
                float sValue = Float.valueOf(s);

                if (Choix.getCheckedRadioButtonId() == R.id.btnCelcius) {
                    sValue = sValue*9 / 5 + 32;

                    temp.setText(String.valueOf(sValue) + " F.");
                } else {
                    sValue = (sValue - 32) * 5 / 9;
                    temp.setText(String.valueOf(sValue) + " C.");
                }
            }

        });
    }
}