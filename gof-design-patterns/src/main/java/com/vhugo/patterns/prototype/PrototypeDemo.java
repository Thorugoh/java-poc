package com.vhugo.patterns.prototype;

public class PrototypeDemo {
    static void main() {
        Circle circle = new Circle("red", 10);
        Circle clonedCircle = (Circle) circle.clone();
        clonedCircle.setColor("blue");

        circle.display();
        clonedCircle.display();
        System.out.println("Same instance: " + (circle == clonedCircle));

        System.out.println("---");

        Rectangle rect = new Rectangle("green", 20, 5);
        Rectangle clonedRect = (Rectangle) rect.clone();
        clonedRect.setColor("yellow");

        rect.display();
        clonedRect.display();
    }
}
