package com.vhugo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Month;

public class ZonedDateTimeExample {
     static void main(String[] args) {

        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId newYork  = ZoneId.of("America/New_York");
        ZoneId london   = ZoneId.of("Europe/London");
        ZoneId tokyo    = ZoneId.of("Asia/Tokyo");

        // Creating ZonedDateTime
        ZonedDateTime nowInSaoPaulo = ZonedDateTime.now(saoPaulo);
        ZonedDateTime nowInNewYork  = ZonedDateTime.now(newYork);
        ZonedDateTime nowInLondon   = ZonedDateTime.now(london);
        ZonedDateTime nowInTokyo    = ZonedDateTime.now(tokyo);

        System.out.println("Sao Paulo: " + nowInSaoPaulo);
        System.out.println("New York:  " + nowInNewYork);
        System.out.println("London:    " + nowInLondon);
        System.out.println("Tokyo:     " + nowInTokyo);

        LocalDateTime localMeeting = LocalDateTime.of(2026, Month.MARCH, 26, 9, 0);
        ZonedDateTime meetingInSaoPaulo = ZonedDateTime.of(localMeeting, saoPaulo);
        System.out.println("Meeting in Sao Paulo: " + meetingInSaoPaulo);

        // Converting the same meeting to other timezones
        ZonedDateTime meetingInNewYork = meetingInSaoPaulo.withZoneSameInstant(newYork);
        ZonedDateTime meetingInLondon  = meetingInSaoPaulo.withZoneSameInstant(london);
        ZonedDateTime meetingInTokyo   = meetingInSaoPaulo.withZoneSameInstant(tokyo);

        System.out.println("Same meeting viewed from:");
        System.out.println("  Sao Paulo: " + meetingInSaoPaulo);
        System.out.println("  New York:  " + meetingInNewYork);
        System.out.println("  London:    " + meetingInLondon);
        System.out.println("  Tokyo:     " + meetingInTokyo);

        // Extracting offset info
        System.out.println("SP offset: " + meetingInSaoPaulo.getOffset()); // -03:00
        System.out.println("NY offset: " + meetingInNewYork.getOffset());  // -05:00
    }
}