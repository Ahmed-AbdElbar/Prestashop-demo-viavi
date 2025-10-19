package support;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;


public class BrowserActions {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Config.explicitWait());
    }

    protected WebElement isVisible(By by){ return wait.until(
            ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void openUrl(String url){
        driver.get(url);
    }
    public void switchIFrameById(Integer frameID){

        driver.switchTo().frame(frameID);
    }
    public void switchIFrameByName(String frameName){
        driver.switchTo().frame(frameName);
    }
    public void switchToDefaultContentDev(){

        driver.switchTo().defaultContent();
    }

    public boolean isDisplayed(By by){
        try {return isVisible(by).isDisplayed();
    } catch (TimeoutException e){ return false; } }

    public boolean isImageIsRendered(By by) {
        try {
            return wait.until(d -> (Boolean) ((JavascriptExecutor) d).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});"
                            + "return arguments[0].complete && arguments[0].naturalWidth>0;",
                    isVisible(by)
            ));
        } catch (TimeoutException e) {
            return false;
        }
    }


}
