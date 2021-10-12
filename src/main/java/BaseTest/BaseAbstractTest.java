package BaseTest;

import Core.TAEBaseObject;
import Core.TAEDriver;
import Entities.WebDriverType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseAbstractTest extends TAEBaseObject {
    private static TAEDriver driver;

    public BaseAbstractTest(String browser) {
        if (browser.equalsIgnoreCase(WebDriverType.CHROME.getDriverName())) {
            driver = new TAEDriver(WebDriverType.CHROME);
        } else if (browser.equalsIgnoreCase(WebDriverType.FIREFOX.getDriverName())) {
            driver = new TAEDriver(WebDriverType.FIREFOX);
        }
    }

    public TAEDriver getDriver() {
        return driver;
    }

    private String getClassName() {
        String[] nameLines = this.getClass().toString().split("\\.");
        return nameLines[nameLines.length - 1];
    }

    @BeforeClass
    public void beforeClass(ITestContext iTestContext) {
        iTestContext.setAttribute("driver", driver);
        getLogger().info(String.format("     ***** Start executing class '%s' *****     ", getClassName()));
    }

    /*
    ITestContext ---> This class defines a test context which contains
                      all the information for a given test run. An instance
                      of this context is passed to the test listeners, so
                      they can query information about their environment.
     */

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();

            /*
            quit ---> stronger than close
            */
        }
    }
}
