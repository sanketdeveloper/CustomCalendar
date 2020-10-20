package com.sanketindia.customcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CalendarAdapter adapter;
    ArrayList<ModelDay> data= new ArrayList<>();
    private RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        list.setLayoutManager(new GridLayoutManager(getApplicationContext(),7,RecyclerView.VERTICAL,false));

        adapter =new CalendarAdapter(this,data, new CalenderDateSelectedListener() {
            @Override
            public void OnDateSelected(ModelDay day) {

                Toast.makeText(MainActivity.this, day.getDay()+"/"+(Integer.parseInt(day.getMonth())+1)+"/"+day.getYear(), Toast.LENGTH_SHORT).show();

            }
        });

        list.setAdapter(adapter);
        data.addAll( Utils.getDays(1, 2020));
        list.getAdapter().notifyDataSetChanged();
    }
}
