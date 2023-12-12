package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void initialize() {
        System.out.println("Before - Initialize WebDriver");
        // WebDriver'ı başlatma işlemleri burada yapılabilir
        // Örneğin: DriverFactory.getDriver();
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        System.out.println("After - Quit WebDriver");
        // WebDriver'ı kapatma işlemleri burada yapılabilir
        // Örneğin: DriverFactory.quitDriver();
        DriverFactory.quitDriver();
    }
}
