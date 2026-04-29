package com.vhugo.patterns.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Email {

    public static class Builder {
        private final String recipient;
        private final String subject;
        private final String body;

        private List<String> cc = new ArrayList<>();
        private List<String> attachments = new ArrayList<>();

        public Builder(String recipient, String subject, String body) {
            this.recipient = recipient;
            this.subject = subject;
            this.body = body;
        }
    }

}
