package com.example.rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    ArrayList<list> word = new ArrayList<list>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word.add(new list("Gaurang", "CS-2"));
        word.add(new list("Anand", "CS-1"));
        word.add(new list("Ripu", "IT-2"));
        word.add(new list("Shashank", "IT-2"));
        word.add(new list("Disha", "IT-1"));
        word.add(new list("Vidhi", "IT-2"));
        word.add(new list("Shivam", "CS-3"));
        word.add(new list("Vibhas", "CS-3"));
        word.add(new list("Shivam", "CS-3"));
        word.add(new list("Ambika", "CS-1"));

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(word, this);
        recyclerView.setAdapter(adapter);
    }
}
