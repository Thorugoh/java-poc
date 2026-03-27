package com.vhugo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConversionExample {
     static void main(String[] args) {

        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");

        // Instant -> ZonedDateTime
        Instant instant = Instant.now();
        ZonedDateTime zonedFromInstant = instant.atZone(saoPaulo);
        System.out.println("Instant:           " + instant);
        System.out.println("ZonedDateTime:     " + zonedFromInstant);

        // ZonedDateTime -> Instant
        ZonedDateTime zoned = ZonedDateTime.now(saoPaulo);
        Instant instantFromZoned = zoned.toInstant();
        System.out.println("ZonedDateTime:     " + zoned);
        System.out.println("Back to Instant:   " + instantFromZoned);

        // ZonedDateTime -> LocalDateTime (loses timezone info)
        LocalDateTime local = zoned.toLocalDateTime();
        System.out.println("LocalDateTime:     " + local); // no zone

        // LocalDateTime -> ZonedDateTime
        ZonedDateTime backToZoned = local.atZone(saoPaulo);
        System.out.println("Back to Zoned:     " + backToZoned);

        Instant storedInDatabase = Instant.now();          // always UTC in storage
        ZonedDateTime displayToUser = storedInDatabase.atZone(saoPaulo); // convert to sP
        System.out.println("\nStored (UTC):      " + storedInDatabase);
        System.out.println("Shown to user:     " + displayToUser);
    }
}