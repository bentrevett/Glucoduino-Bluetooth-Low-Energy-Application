package com.redbear.chat;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.redbear.chat.models.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bentr_000 on 11/03/2015.
 */
public class DataListActivity extends ListActivity {

    private ArrayAdapter dataItemArrayAdapter;
    List<Data> datas = new ArrayList<Data>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();

        String[] readings = i.getStringArrayExtra("KEY");

        if(readings!=null) {
            int y=20;
            for (int x = 0; x < 20; x++) {
                Data data = new Data();
                //data.setDate(y + " August 2014");
                //if(x%3==0)
                //y++;
                data.setBody(readings[x]);
                datas.add(data);
            }
        }
        else{
            for (int x = 0; x < 1; x++) {
                Data data = new Data();
                data.setBody("No readings on device!");
                datas.add(data);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        dataItemArrayAdapter = new DataAdapter(this,datas);
        setListAdapter(dataItemArrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, DataDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data_list, menu);
        return true;
    }
}
