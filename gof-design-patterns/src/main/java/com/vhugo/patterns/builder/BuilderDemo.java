package com.vhugo.patterns.builder;

public class BuilderDemo {
    static void main() {
        Email simple = new Email.Builder(
                "maria@email.com",
                "Meeting tomorrow",
                "Please confirm by 6 PM.")
                .build();

        simple.display();
    }
}
