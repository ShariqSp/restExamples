package admin;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {
	    public MyTestListener() {
	        // You can add initialization logic here if needed
	    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
      String str =result.getClass().toString();
     
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    // Implement other methods...
}
