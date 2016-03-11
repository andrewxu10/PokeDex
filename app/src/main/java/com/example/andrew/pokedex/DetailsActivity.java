package com.example.andrew.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;

public class DetailsActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Todo: display the relevant pokemons information

        Intent intent = getIntent();
        String pokeName = intent.getStringExtra("pokemon_name");

        //pokename = pikachu
        //-pikachu appear on big font
        TextView nameTextView = (TextView) findViewById(R.id.pokemon_name);
        nameTextView.setText(pokeName);

        //display pikachu image in imageview (r.drawable.pikachu)
        ImageView imageView = (ImageView) findViewById(R.id.pokemon_image);
        int pokeID = getResources().getIdentifier(
                pokeName.toLowerCase(), "drawable", getPackageName() //CHECK THIS LATER
        );
        imageView.setImageResource(pokeID);

        //want details about pikachu to appear in small font (res/raw/pikachu.txt)
        //r.raw.pikachu
        int fileID = getResources().getIdentifier(
                pokeName.toLowerCase(), "raw", getPackageName() //CHECK THIS LATER
        );

        String fileText = readFileText(fileID);
        TextView pokeDetails = (TextView) findViewById(R.id.pokemon_details);
        pokeDetails.setText(fileText);
    }
}
