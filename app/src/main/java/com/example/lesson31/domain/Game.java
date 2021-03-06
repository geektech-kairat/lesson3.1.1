package com.example.lesson31.domain;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

public class Game<C> {
    private final List<Card<C>> cards = new ArrayList<>();

    public Game(List<C> cardContent) {
        for (int i = 0; i < cardContent.size(); i++) {
            cards.add(new Card<>(i + 1, false, false, cardContent.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, cardContent.get(i)));
            cards.add(new Card<>((i + 1) * 4, false, false, cardContent.get(i)));
            cards.add(new Card<>((i + 1) * 3, false, false, cardContent.get(i)));
            Collections.shuffle(cards);
        }

    }


    public List<Card<C>> getCards() {
        return cards;
    }

    public void CardClick(Card<C> card, Context context) {

        card.setFaceAUp(!card.isFaceAUp());
        for (Card<C> currentCard : cards) {
            if (currentCard.isFaceAUp() && currentCard.getId() != card.getId()) {
                if (currentCard.getCardContent().equals(card.getCardContent())) {
                    Toast.makeText(context, "Совпадения карт)\n карты исчезает", Toast.LENGTH_SHORT).show();

                    currentCard.setMatched(true);
                    card.setMatched(true);
                } else {
                    currentCard.setFaceAUp(!currentCard.isFaceAUp());
                    card.setFaceAUp(!card.isFaceAUp());
                }
            }

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





