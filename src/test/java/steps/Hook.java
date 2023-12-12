package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hook {

    private WebDriver driver;
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

    @AfterStep
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshotTaken =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotTaken,"image/png",scenario.getName());
        }
    }

}
