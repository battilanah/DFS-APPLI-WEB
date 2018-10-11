package com.dfs.nahoum.applicationdfs.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String value1 = intent.getStringExtra("Value1");
        Toast.makeText(context, "Quelqu'un a cliqué sur ce bouton avec le message suivant :"+value1, Toast.LENGTH_LONG).show();
    }
}
