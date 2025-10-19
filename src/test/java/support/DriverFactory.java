package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {
    static {
        //this is important to mute some warnings regarding chrome version
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium.devtools").setLevel(Level.OFF);
        Logger.getLogger("io.github.bonigarcia.wdm").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }
    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opts = new ChromeOptions();
            if (Config.headless()) opts.addArguments("--headless=new");
            driver = new ChromeDriver(opts);
            driver.manage().timeouts().implicitlyWait(Config.implicitWait());
            try {
                driver.manage().window().maximize();
            } catch (Exception ignore) {
                // headless/Xvfb can't truly maximize so I just set a certain size
                driver.manage().window().setSize(new Dimension(1920, 1080));
            }
        }
        return driver;
    }

    public static WebDriver peek(){ return driver; }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { if (driver != null) driver.quit(); } catch (Exception ignored) {}
        }));
    }
}
