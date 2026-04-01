package com.vhugo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PatternSymbolsExample {
     static void main() {

        LocalDateTime dt = LocalDateTime.of(2026, 4, 1, 8, 5, 9);

        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy"))); // 2026 — 4 digit year
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yy")));   // 26   — 2 digit year

        System.out.println(dt.format(DateTimeFormatter.ofPattern("MM")));   // 04   — zero-padded
        System.out.println(dt.format(DateTimeFormatter.ofPattern("M")));    // 4    — no padding
        System.out.println(dt.format(DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH)));  // Apr  — abbreviated
        System.out.println(dt.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH))); // April — full name

        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd"))); // 01 — zero-padded
        System.out.println(dt.format(DateTimeFormatter.ofPattern("d")));  // 1  — no padding

        System.out.println(dt.format(DateTimeFormatter.ofPattern("E", Locale.ENGLISH)));    // Wed  — abbreviated
        System.out.println(dt.format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH))); // Wednesday — full

        System.out.println(dt.format(DateTimeFormatter.ofPattern("HH"))); // 08 — 24h, zero-padded
        System.out.println(dt.format(DateTimeFormatter.ofPattern("H")));  // 8  — 24h, no padding
        System.out.println(dt.format(DateTimeFormatter.ofPattern("hh"))); // 08 — 12h, zero-padded
        System.out.println(dt.format(DateTimeFormatter.ofPattern("a")));  // AM — AM/PM marker

        System.out.println(dt.format(DateTimeFormatter.ofPattern("mm"))); // 05 — zero-padded
        System.out.println(dt.format(DateTimeFormatter.ofPattern("ss"))); // 09 — zero-padded

        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'at' HH:mm", Locale.ENGLISH)));
        // 01/04/2026 at 08:05
    }
}