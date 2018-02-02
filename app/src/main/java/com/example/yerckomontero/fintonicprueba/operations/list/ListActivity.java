package com.example.yerckomontero.fintonicprueba.operations.list;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yerckomontero.fintonicprueba.R;
import com.example.yerckomontero.fintonicprueba.adapters.HeroesAdapter;
import com.example.yerckomontero.fintonicprueba.adapters.IHeroesAdapter;
import com.example.yerckomontero.fintonicprueba.api.Repositories;
import com.example.yerckomontero.fintonicprueba.data.UserData;
import com.example.yerckomontero.fintonicprueba.models.Heroe;
import com.example.yerckomontero.fintonicprueba.operations.detail.DetailActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity implements IListView, IHeroesAdapter{
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private HeroesAdapter heroesAdapter;
    private ArrayList<Heroe> heroes;
    LinearLayout linlaHeaderProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }

    @Override
    protected void onResume() {
        super.onResume();

        initViews();
    }

    public void initViews() {
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        heroes = new ArrayList<Heroe>();

        linlaHeaderProgress = (LinearLayout) findViewById(R.id.linlaHeaderProgress);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list_heroes);
        heroesAdapter = new HeroesAdapter(this,heroes,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(heroesAdapter);

        linlaHeaderProgress.setVisibility(View.VISIBLE);
        new Repositories().heroesRequest(this, this);

    }




    @Override
    public void onLoadSuccess(boolean result) {
        ArrayList<Heroe> temp = new ArrayList<Heroe>(Arrays.asList(UserData.getInstance(this).getHeroes().getSuperheroes()));
        for (int i=0;i<temp.size();i++){
            heroes.add(temp.get(i));
        }

        recyclerView.getAdapter().notifyDataSetChanged();
        linlaHeaderProgress.setVisibility(View.GONE);

    }

    @Override
    public void onItemClick(Heroe item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_DATA, item);
        startActivity(intent);
    }



}
