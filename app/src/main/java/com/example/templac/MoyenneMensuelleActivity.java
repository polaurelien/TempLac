package com.example.templac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
