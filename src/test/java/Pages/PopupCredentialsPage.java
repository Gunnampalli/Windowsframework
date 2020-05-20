package Pages;

import Base.BaseSetup;
import org.openqa.selenium.By;

public class PopupCredentialsPage extends BaseSetup {
    By username= By.xpath("//*[@AutomationId='1069']");
    By password=By.xpath("//*[@AutomationId='1070']");
    By okBtn = By.name("OK");
    public void setUsername()
    {
        isElementPresent(username,15);
        clearData(username,15);
        sendkeys(username,15,"bponnada_ctr");

    }
    public void setPassword()
    {
        isElementPresent(password,15);
        clearData(password,15);
        sendkeys(password,15,"Chang3m3!Chang3m3!");

    }
    public void setOkBtn()
    {
        isElementPresent(okBtn,15);
        click(okBtn,15);
    }
}
