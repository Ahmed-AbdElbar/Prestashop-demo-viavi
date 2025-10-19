package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import support.DriverFactory;

public class ScreenshotHook {

    private int stepIndex;

    @Before
    public void resetIndex() {
        stepIndex = 0;
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        WebDriver driver = DriverFactory.peek();
        if (driver == null) return;
        if (!(driver instanceof TakesScreenshot)) return;

        stepIndex++;

        byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        String name = featureName(scenario) + "__" + scenario.getName() + "__" + stepIndex + ".png";

        scenario.attach(png, "image/png", name);
    }

    private String featureName(Scenario s) {
        String id = s.getId();
        if (id == null) return "feature";
        int slash = Math.max(id.lastIndexOf('/'), id.lastIndexOf('\\'));
        String fn = (slash >= 0) ? id.substring(slash + 1) : id;
        return fn.replace(".feature", "");
    }
}
