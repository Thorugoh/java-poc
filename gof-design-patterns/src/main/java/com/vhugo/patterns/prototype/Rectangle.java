package com.vhugo.patterns.prototype;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public void display() {
        System.out.println(getType() + " [color=" + getColor() + ", width=" + width + ", height=" + height + "]");
    }
}
