package com.tesco.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.tesco.driver.BrowserType.*;

public class DriverInitializer {

    public static WebDriver initChrome() {
        return initDriver(CHROME_SELMGR);
    }

    public static WebDriver initFirefox() {
        return initDriver(FIREFOX_SELMGR);
    }

    public static WebDriver initEdge() {
        return initDriver(EDGE_SELMGR);
    }

    private static WebDriver initDriver(BrowserType type) {
        switch(type) {
            case CHROME_SELMGR:
                ChromeOptions options = new ChromeOptions();

                // Inkognitó mód beállítása
                options.addArguments("--incognito");

                // Server ne nézze automata botnak
                options.addArguments("--disable-blink-features=AutomationControlled");

                // letíltja: "Chrome is being controlled by automated test software
                options.addArguments("--disable-infobars");

                // max méretben nyílik meg a böngésző
                options.addArguments("--satrat-maximized");

                return new ChromeDriver(options);
            case FIREFOX_SELMGR:
                return new FirefoxDriver();
            case EDGE_SELMGR:
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Incorrect browser type!");


        }


    }
}
