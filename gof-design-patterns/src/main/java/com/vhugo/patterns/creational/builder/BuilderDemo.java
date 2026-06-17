package com.vhugo.patterns.creational.builder;

import java.lang.reflect.Array;

public class BuilderDemo {
    static void main() {
        Email simple = new Email.Builder(
                "email@email.com",
                "Meeting tomorrow",
                "Please confirm by 6 PM.")
                .build();

        Email.Builder complex = new Email.Builder(
                "email@email.com",
                "1:1 meeting",
                "Please attend to the agenda");

        Email email = complex.cc("someoneelse@email.com")
                .urgent(true)
                .attachment("file1.png")
                .attachment("file2.pdf")
                .build();


        simple.display();
        System.out.println("---x---x---x---x---x---x---x");
        System.out.println("---x---x---x---x---x---x---x");
        email.display();
    }
}
