package com.example.andrew.pokedex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SimpleActivity myActivity = (SimpleActivity) getActivity();

        //initialization code
        //Todo: display the relevant pokemons information

        Intent intent = myActivity.getIntent();
        String pokeName = intent.getStringExtra("pokemon_name");
        if (pokeName == null) {
            pokeName = "Charmander";
        }

        setPokemonName(pokeName);
    }

    public void setPokemonName(String pokeName) {
        SimpleActivity myActivity = (SimpleActivity) getActivity();

        //pokename = pikachu
        //-pikachu appear on big font
        TextView nameTextView = (TextView) myActivity.findViewById(R.id.pokemon_name);
        nameTextView.setText(pokeName);

        //display pikachu image in imageview (r.drawable.pikachu)
        ImageView imageView = (ImageView) myActivity.findViewById(R.id.pokemon_image);
        int pokeID = getResources().getIdentifier(
                pokeName.toLowerCase(), "drawable", myActivity.getPackageName() //CHECK THIS LATER
        );
        imageView.setImageResource(pokeID);

        //want details about pikachu to appear in small font (res/raw/pikachu.txt)
        //r.raw.pikachu
        int fileID = getResources().getIdentifier(
                pokeName.toLowerCase(), "raw", myActivity.getPackageName() //CHECK THIS LATER
        );

        String fileText = myActivity.readFileText(fileID);
        TextView pokeDetails = (TextView) myActivity.findViewById(R.id.pokemon_details);
        pokeDetails.setText(fileText);
    }
}
