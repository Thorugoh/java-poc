package com.vhugo.patterns.singleton;

public class AppConfig {
    private static AppConfig instance;

    private String appName;
    private String version;

    private AppConfig() {
        this.appName = "MyApp";
        this.version = "1.0.0";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void display() {
        System.out.println("App: " + appName + " v" + version);
    }
}
