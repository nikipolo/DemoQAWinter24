import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{

    @Test(groups = {"Smoke","8765"},description = "Frame Test")
    public void switchFrameTest(){
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText()   );
    }
}
