package com.redbear.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.redbear.chat.models.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bentr_000 on 11/03/2015.
 */
public class MainActivity extends Activity {
    Button connectButton;
    Button dataButton;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectButton = ( Button ) findViewById(R.id.btn_connect);
        dataButton = ( Button ) findViewById(R.id.btn_data);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    startActivity(intent);
                }
        });

        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,
                //"This will connect", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, DataListActivity.class);
                    startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
