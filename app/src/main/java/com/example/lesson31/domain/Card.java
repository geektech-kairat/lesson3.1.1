package com.example.lesson31.domain;

public class Card <T> {
    private int id;
    private boolean isMatched;
    private boolean isFaceAUp;
    private T cardContent;

    public Card(int id, boolean isMatched, boolean isFaceAUp, T cardContent) {
        this.id = id;
        this.isMatched = isMatched;
        this.isFaceAUp = isFaceAUp;
        this.cardContent = cardContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFaceAUp() {
        return isFaceAUp;
    }

    public void setFaceAUp(boolean faceAUp) {
        isFaceAUp = faceAUp;
    }

    public T getCardContent() {
        return cardContent;
    }

    public void setCardContent(T cardContent) {
        this.cardContent = cardContent;
    }
}
