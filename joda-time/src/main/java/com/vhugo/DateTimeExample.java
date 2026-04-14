package com.vhugo;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeExample {

    static void main() {
        DateTime now            = DateTime.now();
        DateTime specificDate   = new DateTime(2026, 4, 10, 14, 30, 0, 0);
        DateTime withTimezone   = new DateTime(2026, 4, 10, 14, 30, 0, 0, DateTimeZone.forID("America/Sao_Paulo"));

        System.out.println("Now: " + now);
        System.out.println("Specific: " + specificDate);
        System.out.println("With timezone: " + withTimezone);

        System.out.println("Year: " + now.getYear());
        System.out.println("Month of year: " + now.getMonthOfYear());
        System.out.println("Day of month: " + now.getDayOfMonth());
        System.out.println("Hour of day: " + now.getHourOfDay());
        System.out.println("Minute of hour: " + now.getMinuteOfHour());
        System.out.println("Second: " + now.getSecondOfMinute());
        System.out.println("Day of week: " + now.getDayOfWeek());
        System.out.println("Day of year: " + now.getDayOfYear());

        DateTime tomorrow = now.plusDays(1);
        DateTime nextMonth = now.plusMonths(1);
        DateTime lastYear = now.minusYears(1);
        DateTime inThreeHours = now.plusHours(3);

        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Next month: " + nextMonth);
        System.out.println("Last year: " + lastYear);
        System.out.println("In three hours: " + inThreeHours);

        DateTimeFormatter brazilianFormatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Formatted: " + now.toString(brazilianFormatter));

        DateTime dateA = new DateTime(2026, 1, 1, 0, 0, 0, 0);
        DateTime dateB = new DateTime(2026, 6, 1, 0, 0, 0, 0);
        System.out.println("dateA isBefore dateB: " + dateA.isBefore(dateB));
        System.out.println("dateA isAfter dateB:  " + dateA.isAfter(dateB));
        System.out.println("dateA isEqual dateB:  " + dateA.isEqual(dateB));
    }
}