package com.example.hf5;

public class ListItem {
    private String text;
    private int colorResId;

    public ListItem(String text, int colorResId) {
        this.text = text;
        this.colorResId = colorResId;
    }

    public String getText() { return text; }
    public int getColorResId() { return colorResId; }
    public void setColorResId(int colorResId) { this.colorResId = colorResId; }
    public void setText(String text) { this.text = text; }
}