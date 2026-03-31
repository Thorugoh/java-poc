package com.vhugo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CustomPatternExample {
     static void main() {

        LocalDate date = LocalDate.of(2026, 3, 31);
        LocalTime time = LocalTime.of(14, 30, 45);
        LocalDateTime dateTime = LocalDateTime.of(2026, 3, 31, 14, 30, 45);

        DateTimeFormatter brazilianDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(date.format(brazilianDate)); // 31/03/2026

        DateTimeFormatter brazilianDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dateTime.format(brazilianDateTime)); // 31/03/2026 14:30:45

        DateTimeFormatter amPm = DateTimeFormatter.ofPattern("hh:mm a");
        System.out.println(time.format(amPm)); // 02:30 PM

        DateTimeFormatter fullPortuguese = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
        System.out.println(date.format(fullPortuguese)); // 31 de março de 2026

        DateTimeFormatter fullEnglish = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        System.out.println(date.format(fullEnglish)); // March 31, 2026

        DateTimeFormatter withDayOfWeek = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy", new Locale("pt", "BR"));
        System.out.println(date.format(withDayOfWeek)); // terça-feira, 31/03/2026
    }
}