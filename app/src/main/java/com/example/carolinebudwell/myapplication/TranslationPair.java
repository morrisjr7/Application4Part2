package com.example.carolinebudwell.myapplication;


public class TranslationPair {
    private String englishWord;
    private String spanishWord;

    public TranslationPair() {
    }

    public TranslationPair(String englishWord, String spanishWord) {
        this.englishWord = englishWord;
        this.spanishWord = spanishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    public void setSpanishWord(String spanishWord) {
        this.spanishWord = spanishWord;
    }
}
