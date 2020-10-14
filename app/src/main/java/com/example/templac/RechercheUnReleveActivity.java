package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RechercheUnReleveActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher_un_releve);
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
    }
}
