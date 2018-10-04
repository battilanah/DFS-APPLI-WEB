package com.dfs.nahoum.applicationdfs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.dfs.nahoum.applicationdfs.Service.BoundService;

public class BoundActivity extends AppCompatActivity {

    BoundService myService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

    }

    private ServiceConnection myConnection = new ServiceConnection()
    {

        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
        }

        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };

    public void showTime(View view)
    {
        String currentTime = myService.getCurrentTime();
        TextView myTextView =
                (TextView)findViewById(R.id.viewboundtext);
        myTextView.setText(currentTime);
    }

}
