package com.dfs.nahoum.applicationdfs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestIntentActivity1 extends AppCompatActivity {

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

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
