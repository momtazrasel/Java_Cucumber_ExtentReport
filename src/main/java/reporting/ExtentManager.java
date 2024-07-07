package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

public class ExtentManager {
    private static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setEncoding("utf-8");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentManager.extent.set(extent);

        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void setTest(ExtentTest tst) {
        test.set(tst);
    }

    public static synchronized void logInfo(String message) {
        getTest().info(message);
    }

    public static synchronized void addScreenshot(String path) throws IOException {
        getTest().addScreenCaptureFromPath(path);
    }

    public static synchronized void flush() {
        ExtentReports extent = ExtentManager.extent.get();
        if (extent != null) {
            extent.flush();
        }
    }
}
