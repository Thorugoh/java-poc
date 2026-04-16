package com.vhugo;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class PeriodDurationExample {
     static void main() {

        Period tenDays = Period.days(10);
        Period fourMonths = Period.months(4);
        Period complex = new Period(1, 6, 0, 15, 0, 0, 0, 0); // 1 ano 6mes 15dias

        System.out.println("Ten days: " + tenDays);
        System.out.println("Three months: " + fourMonths);
        System.out.println("Complex: " + complex);

        LocalDate birthDate = new LocalDate(1996, 4, 10);
        LocalDate today = new LocalDate(2026, 4, 10);
        Period age = new Period(birthDate, today);

        System.out.println("Age: " + age);
        System.out.println("Years: " + age.getYears());
        System.out.println("Months: " + age.getMonths());
        System.out.println("Days: " + age.getDays());

        Period daysOnly = new Period(birthDate, today, PeriodType.days());
        System.out.println("Total days: " + daysOnly.getDays());

        DateTime start = new DateTime(2026, 4, 10, 9, 0, 0, 0);
        DateTime end = new DateTime(2026, 4, 10, 17, 30, 0, 0);
        Duration workDay = new Duration(start, end);

        System.out.println("Work day ms: " + workDay.getMillis());
        System.out.println("Work day hours: " + workDay.getStandardHours());
        System.out.println("Work day minutes: " + workDay.getStandardMinutes());
        System.out.println("Work day seconds: " + workDay.getStandardSeconds());

        Interval workInterval = new Interval(start, end);
        DateTime lunchTime    = new DateTime(2026, 4, 16, 12, 0, 0, 0);
        DateTime afterWork    = new DateTime(2026, 4, 16, 18, 0, 0, 0);

        System.out.println("Lunch within work interval: " + workInterval.contains(lunchTime)); // true
        System.out.println("After work in interval: " + workInterval.contains(afterWork)); // false
        System.out.println("Interval duration hours: " + workInterval.toDuration().getStandardHours()); // 8

        LocalDate startDate = new LocalDate(2026, 4, 1);
        LocalDate endDate   = startDate.plus(complex);
        System.out.println("Start: " + startDate);
        System.out.println("End: " + endDate);
    }
}