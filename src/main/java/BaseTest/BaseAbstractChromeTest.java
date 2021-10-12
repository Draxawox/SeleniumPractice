package BaseTest;

import Entities.WebDriverType;

public class BaseAbstractChromeTest extends BaseAbstractTest {
    public BaseAbstractChromeTest() {
        super(WebDriverType.CHROME.getDriverName());
    }
}
