package Pages;

import Base.BaseSetup;
import org.openqa.selenium.By;

public class LoginPage extends BaseSetup {
   // By ipId = By.id("42.524906");
   // By ipID1=By.className("Edit");
   // By portId = By.id("1002");
    By uID = By.id("1069");
    By pwdID = By.id("1070");
    By close = By.id("Close");
    By save = By.name("Save");
    By saveFile = By.id("1001");
    By name = By.name("8000");
    By connectBtn = By.name("Connect");
    By okBtn = By.name("OK");
    By ipId=By.xpath("//*[@AutomationId='1001' and @IsContentElement='False']");
    By portId=By.xpath("//*[@AutomationId='1001' and @IsContentElement='True']");
By switchToRemote=By.name("Switch to remote view");
By switchEnabled=By.xpath("//*[@Name='Switch to remote view' and @IsEnabled='True']");
    public void setIpId()
    {
        isElementPresent(ipId,15);
       /* String text=driver.findElement(ipId).getAttribute("IsContentElement");
        System.out.println("Text.."+text);*/
       clearData(ipId,15);
        sendkeys(ipId,15,"10.1.40.143");
    }
    public void setPortId()
    {
        isElementPresent(portId,45);
        clearData(portId,15);
        sendkeys(portId,15,"9000");
    }
    public void setConnectBtn()
    {
        isElementPresent(connectBtn,45);
        click(connectBtn,45);
    }

    public void setSwitchToRemote() {
        isElementEnabled(switchEnabled,30);
        String text=driver.findElement(switchEnabled).getAttribute("IsEnabled");
        System.out.println("Text.."+text);
        click(switchToRemote,30);

    }
}
