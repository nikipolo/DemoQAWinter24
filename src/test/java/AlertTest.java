
import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test(groups = {"Regression","1721"},description = "Alert Test")
    void alertTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();
        webElementActions.pause(5);
    }




}
