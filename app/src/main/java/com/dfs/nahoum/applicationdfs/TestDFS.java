package com.dfs.nahoum.applicationdfs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestDFS extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dfs);

        Button btn1 = (Button)findViewById(R.id.bouton1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntent = new Intent(TestDFS.this, SecondeActivity.class);
                startActivity(monIntent);
            }
        });

        Button btndateactivity = (Button)findViewById(R.id.buttondateactivity);

        btndateactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dateactivity = new Intent(getApplicationContext(), BoundActivity.class);
                startActivity(dateactivity);
            }
        });

        Button btnbroadcast = (Button)findViewById(R.id.boutonmainbroadcast);

        btnbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent broadcastactivity = new Intent(getApplicationContext(), BroadcastActivity.class);
                startActivity(broadcastactivity);
            }
        });


        Button btncontact = (Button)findViewById(R.id.boutoncontact);

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactactivity = new Intent(getApplicationContext(), ContentAdapter.class);
                startActivity(contactactivity);
            }
        });

        Button btnintenttest1 = (Button)findViewById(R.id.testintent1);

        btnintenttest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TestIntentActivity1 = new Intent(getApplicationContext(), TestIntentActivity1.class);
                TestIntentActivity1.putExtra("1", "Coucou");
                startActivityForResult(TestIntentActivity1, 100);
            }
        });


        Button btnintentdata = (Button)findViewById(R.id.testintentdata);

        btnintentdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("tel:123"));
                startActivity(i);
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            TextView textview1 = (TextView)findViewById(R.id.textintent1);
            textview1.setText(data.getExtras().getString("1"));
        }


    }

    @Override
    protected void onStart() {
        Log.d("onStart","onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("onRestart","onRestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d("onStop","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("onDestroy","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("onPause","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("onResume","onResume");
        super.onResume();
    }
}
