package com.example.lesson31.presentation;

import android.content.Context;
import android.view.View;

import com.example.lesson31.domain.Card;
import com.example.lesson31.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {
    private final Game<String> game;
    public EmojiGame (){
        List<String> cardContent = new ArrayList<>();
        cardContent.add("😎");
        cardContent.add("😂");
        cardContent.add("😍");
        cardContent.add("🙈");
        game = new Game<>(cardContent);
    }
    public void cardClick(Card<String> card, Context context){
        game.CardClick(card, context);
    }
    public List<Card<String>> getCards(){
        return  game.getCards();
    }


}
