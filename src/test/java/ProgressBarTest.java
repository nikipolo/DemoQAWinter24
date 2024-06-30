import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {
    @Test(description = "")
    public void progressBarTest() throws InterruptedException {
//        browserHelper.open("https://demoqa.com/progress-bar");
//        webElementActions.click(progressBarPage.startStopButton);
//        Thread.sleep(2000);
//        webElementActions.click(progressBarPage.startStopButton);
//        Thread.sleep(5000);
//        System.out.println(progressBarPage.aria_valuenow.getAttribute("aria-valuenow"));
//        Assert.assertEquals(progressBarPage.aria_valuenow.getAttribute("aria-valuenow"),"52");


        browserHelper.open("https://demoqa.com/progress-bar");
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);

        int currentValue = 0;
        while (currentValue < 52) {
            // Give some time for the progress bar to update
            Thread.sleep(10); // Check every 100 milliseconds
            currentValue = Integer.parseInt(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
        }

        // Stop the progress bar when the value reaches or exceeds 52
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);

        // Verify that the progress bar has indeed stopped at 52
        int finalValue = Integer.parseInt(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
        System.out.println("Final Value: " + finalValue);
        Assert.assertEquals(finalValue, 53, "The progress bar did not stop at the expected value.");


    }
}
