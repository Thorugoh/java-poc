package com.vhugo;

import java.time.Period;

public class PeriodExample {
    static void main() {
        Period tenDays = Period.ofDays(10);
        Period threeMonths = Period.ofMonths(3);
        Period twoYears = Period.ofYears(2);
        Period all = Period.of(1, 6,15);

        System.out.println("Ten Days: "+ tenDays);
        System.out.println("Three Months: "+ threeMonths);
        System.out.println("twoYears: "+ twoYears);
        System.out.println("All: " + all);

        /*
            Ten Days: P10D
            Three Months: P3M
            twoYears: P2Y
            All: P1Y6M15D
        *
        */
    }
}
