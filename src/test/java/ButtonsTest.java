import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    @Test(description = "Verify double click button is working properly")
    public void doubleClickTest() {
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.scrollToElement(demoQAPages.getButtonsPage().doubleClickBtn);
        webElementActions.doubleCLick(demoQAPages.getButtonsPage().doubleClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");
    }

    @Test(groups = {"Smoke","3456"},description = "Button Test")
    public void rightClickBtn() {
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.scrollToElement(demoQAPages.getButtonsPage().doubleClickBtn);
        webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
//        Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickBtn.getText(),"doubleClickMessage");
//        Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(), "You have done a right click");
    }
}
