package TestCases;

import Base.BaseSetup;
import Pages.LoginPage;
import Pages.PopupCredentialsPage;
import junit.framework.TestCase;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Testcase extends BaseSetup {
    BaseSetup base;
    LoginPage page;
    PopupCredentialsPage ppage;
  //   Screen  screen =new Screen();
    public Testcase()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        base=new BaseSetup();
        page=new LoginPage();
        ppage=new PopupCredentialsPage();

        base.initialize();
    }
    @Test
    public void tc1() throws Exception {

screen=new Screen();
        Pattern p=new Pattern("C:\\Users\\venkateswara.G\\Pictures\\1.PNG");

       page.setIpId();
        page.setPortId();
        try
        {
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        screen.wait(p,6000);
        screen.click(p);
       // page.setConnectBtn();
        ppage.setUsername();
        ppage.setPassword();
        ppage.setOkBtn();
        try
        {
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        page.setSwitchToRemote();
    }
}
