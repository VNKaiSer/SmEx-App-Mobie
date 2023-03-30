package com.example.entity;

public class App {
    private String icon;
    private String text;

    public App() {

    }

    public App(String icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "App{" + "icon='" + icon + '\'' + ", text='" + text + '\'' + '}';
    }
}
