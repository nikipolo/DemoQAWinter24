import org.testng.annotations.Test;

public class PracticeFormPageCalendarTest extends BaseTest{
    @Test(description = "calendar")
    public void test123() throws InterruptedException {
        browserHelper.open("https://demoqa.com/automation-practice-form");
        demoQAPages.getPracticeFormPageCalendar().selectDateMonthYear("30 June 2020");
        Thread.sleep(4000);
    }
}
