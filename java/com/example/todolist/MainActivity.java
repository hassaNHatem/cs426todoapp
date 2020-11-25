package com.example.todolist;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pair<Boolean,Pair<String,String>>> todos = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         TodoAdaptor todoAdaptor = new TodoAdaptor(this,todos);
         todos.add(new Pair<>(false, new Pair<>("task1","task1 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task2","task2 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task3","task3 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task4","task4 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task5","task5 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task6","task6 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task7","task7 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task8","task8 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task9","task9 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task10","task10 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task11","task11 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task12","task12 discrebtion")));
        todos.add(new Pair<>(false, new Pair<>("task13","task13 discrebtion")));

         recyclerView = findViewById(R.id.rectest);
         recyclerView.setAdapter(todoAdaptor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        todoAdaptor.notifyDataSetChanged();
    }


}