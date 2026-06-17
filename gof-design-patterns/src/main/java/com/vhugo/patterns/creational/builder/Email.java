package com.vhugo.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Email {
    private final String recipient;
    private final String subject;
    private final String body;

    private final List<String> cc;
    private final List<String> attachments;
    private final boolean urgent;

    private Email(Builder builder) {
        this.recipient = builder.recipient;
        this.subject = builder.subject;
        this.body = builder.body;
        this.cc = Collections.unmodifiableList(builder.cc);
        this.attachments = Collections.unmodifiableList(builder.attachments);
        this.urgent = builder.urgent;
    }

    public void display() {
        System.out.println("To: " + recipient);
        if (!cc.isEmpty()) {
            System.out.println("CC: " + String.join(", ", cc));
        }
        System.out.println("Subject: " + (urgent ? "[URGENT] " : "") + subject);
        System.out.println("Body: " + body);
        if (!attachments.isEmpty()) {
            System.out.println("Attachments: " + String.join(", ", attachments));
        }
    }

    public static class Builder {
        private final String recipient;
        private final String subject;
        private final String body;


        private List<String> cc = new ArrayList<>();
        private List<String> attachments = new ArrayList<>();
        private boolean urgent = false;

        public Builder(String recipient, String subject, String body) {
            this.recipient = recipient;
            this.subject = subject;
            this.body = body;
        }

        public Builder cc(String email) {
            this.cc.add(email);
            return this;
        }

        public Builder attachment(String filename) {
            this.attachments.add(filename);
            return this;
        }

        public Builder urgent(boolean urgent) {
            this.urgent = urgent;
            return this;
        }

        public Email build() {
            if (recipient == null || recipient.isBlank()) {
                throw new IllegalStateException("Recipient is required");
            }
            return new Email(this);
        }
    }
}