package com.vhugo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadSafeFormatterExample {
    static void main(String[] args) throws InterruptedException {

        List<String> errors = Collections.synchronizedList(new ArrayList<>());

        // SimpleDateFormat — shared instance causes race conditions
        SimpleDateFormat unsafeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        ExecutorService unsafePool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            unsafePool.submit(() -> {
                try {
                    String result = unsafeFormatter.format(new Date());
                    // result may be wrong or throw an exception
                } catch (Exception e) {
                    errors.add("SimpleDateFormat error: " + e.getMessage());
                }
            });
        }
        unsafePool.shutdown();
        unsafePool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("SimpleDateFormat errors: " + errors.size());

        // DateTimeFormatter — safely shared across any number of threads
        DateTimeFormatter safeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<String> results = Collections.synchronizedList(new ArrayList<>());
        ExecutorService safePool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            safePool.submit(() -> {
                String result = LocalDate.now().format(safeFormatter);
                results.add(result);
            });
        }
        safePool.shutdown();
        safePool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("DateTimeFormatter results: " + results.size() + " (all correct)");
    }
}
