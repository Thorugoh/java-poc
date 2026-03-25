package com.vhugo;

import java.time.ZoneId;
import java.util.Set;
import java.util.TreeSet;

public class ZoneIdExample {
    static void main() {

        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId newYork  = ZoneId.of("America/New_York");
        ZoneId london   = ZoneId.of("Europe/London");
        ZoneId tokyo    = ZoneId.of("Asia/Tokyo");
        ZoneId utc      = ZoneId.of("UTC");

        System.out.println("Sao Paulo: " + saoPaulo);
        System.out.println("New York:  " + newYork);
        System.out.println("London:    " + london);
        System.out.println("Tokyo:     " + tokyo);
        System.out.println("UTC:       " + utc);

        ZoneId systemZone = ZoneId.systemDefault();
        System.out.println("System zone: " + systemZone);

        Set<String> allZones = new TreeSet<>(ZoneId.getAvailableZoneIds());
        System.out.println("Total available zones: " + allZones.size());

        // Filtering only American zones
        allZones.stream()
                .filter(z -> z.startsWith("America/"))
                .limit(10)
                .forEach(z -> System.out.println("  " + z));
    }
}