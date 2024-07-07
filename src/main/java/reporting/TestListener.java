package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TestListener {
    protected WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        String methodName = scenario.getName().replaceAll(" ", "_");
        ExtentReports extent = ExtentManager.createInstance("reports/" + methodName + "_report.html");
        ExtentTest test = extent.createTest(methodName);
        ExtentManager.setTest(test);

        // Set the path to your WebDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ExtentManager.getTest().log(Status.FAIL, "Test Failed");
            ExtentManager.getTest().log(Status.FAIL, scenario.getStatus().toString());

            String screenshotPath = captureScreenshot(scenario.getName());
            ExtentManager.addScreenshot(screenshotPath);
        } else {
            ExtentManager.getTest().log(Status.PASS, "Test Passed");
        }

        ExtentManager.flush();
        if (driver != null) {
            driver.quit();
        }
    }

    private String captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
