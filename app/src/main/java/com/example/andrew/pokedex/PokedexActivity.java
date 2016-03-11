package com.example.andrew.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.lang.reflect.Field;

import stanford.androidlib.SimpleActivity;

public class PokedexActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
    }

    public void pokemonClick(View view){

        String tag = view.getTag().toString();

        if(isPortrait()){
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("pokemon_name", tag);
        startActivity(intent);
    } else {
            //Landscape mode; update fragment
            DetailsFragment frag = (DetailsFragment)
                    getFragmentManager()
                    .findFragmentById(R.id.detailsfrag);
            frag.setPokemonName(tag);
        }


}}
