package com.dfs.nahoum.applicationdfs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestIntentActivity1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent1);
        Bundle extra = getIntent().getExtras();
        extra.getString("1");

        Button fermer = (Button)findViewById(R.id.fermerintent1);

        fermer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fermeture = new Intent();
                fermeture.putExtra("1", "Intent 1 bien fermé");
                setResult(100, fermeture);
                finish();
            }
        });

        Button bouton1 = (Button)findViewById(R.id.boutonlistener1);
        Button bouton2 = (Button)findViewById(R.id.boutonlistener2);

        bouton1.setOnClickListener(this);
        bouton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();
        Button bouton1 = (Button)findViewById(R.id.boutonlistener1);
        Button bouton2 = (Button)findViewById(R.id.boutonlistener2);
        if(v == bouton1){
            Toast.makeText(context, "Bouton 1", Toast.LENGTH_LONG).show();
        }

        if(v == bouton2){
            Toast.makeText(context, "Bouton 2", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
