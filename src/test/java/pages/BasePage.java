package pages;

import support.DriverFactory;
import support.UIActions;

public abstract class BasePage extends UIActions {

    protected BasePage() {
        super(DriverFactory.get());
    }



}
