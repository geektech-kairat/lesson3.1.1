package com.example.lesson31.domain;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Game<C> {
    private final List<Card<C>> cards = new ArrayList<>();

    public Game(List<C> cardContent) {
        for (int i = 0; i < cardContent.size(); i++) {
            cards.add(new Card<>(i + 1, false, false, cardContent.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, cardContent.get(i)));

        }

    }


    public List<Card<C>> getCards() {
        return cards;
    }

    public void CardClick(Card<C> card, Context context) {
        card.setFaceAUp(!card.isFaceAUp());
        Log.e(TAG, "CardClick: ");
        for (Card<C> currentCard : cards) {
            if (currentCard.getId() != card.getId() && currentCard.isFaceAUp() && currentCard.getCardContent().equals(card.getCardContent())) {
                Toast.makeText(context, "Совпадения карт)\n карты исчезает", Toast.LENGTH_SHORT).show();
                currentCard.setMatched(true);
                card.setMatched(true);
            }
//            else if (currentCard.getCardContent().equals(card.getCardContent())){
//                Toast.makeText(context, "Совпадении карт нет)\n ", Toast.LENGTH_SHORT).show();
//
//            }
        }
        remove();
    }
    private void remove() {
        List<Card<C>> resultCards = new ArrayList<>(cards);
        for (Card<C> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);

    }


}


