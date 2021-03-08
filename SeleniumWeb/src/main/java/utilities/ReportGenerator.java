package utilities;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGenerator {
	String Path;
	String ReportName;
	// builds a new report using the html template
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	// helps to generate the logs in test report.
	ExtentTest Logger;

	public ReportGenerator(String Name, String Path) {
		this.Path = Path;
		this.ReportName = Name;
		CreateReport();
		ConfigReport();
	}

	private void CreateReport() {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TestReport.html");
		// initialize ExtentReports and attach the HtmlReporter
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}

	private void ConfigReport() {
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report DDas");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	public ExtentReports GetExtentReport() {
		return extentReport;
	}

	public ExtentTest GetReportLogger() {
		return Logger;
	}

	public static void LogResult(ITestResult result, ExtentTest Logger) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			Logger.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			Logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			Logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			Logger.skip(result.getThrowable());

		}
	}

}
