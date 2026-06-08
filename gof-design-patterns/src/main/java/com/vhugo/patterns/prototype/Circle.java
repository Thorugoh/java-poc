package com.vhugo.patterns.prototype;

public class Circle extends Shape {
    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public void display() {
        System.out.println(getType() + " [color=" + getColor() + ", radius=" + radius + "]");
    }
}
