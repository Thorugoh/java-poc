package com.vhugo.patterns.singleton;

public class SingletonDemo {
    static void main() {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        config1.display();

        config1.setAppName("UpdatedApp");
        config2.display();

        System.out.println("Same instance: " + (config1 == config2));
    }
}
