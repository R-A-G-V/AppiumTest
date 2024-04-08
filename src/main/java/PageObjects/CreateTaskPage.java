package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateTaskPage extends PageBase{
    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "editTextTitre")
    MobileElement TaskNameTxt;
    @AndroidFindBy(id = "editTextNote")
    MobileElement TaskDescTxt;
    @AndroidFindBy(id = "action_save")
    MobileElement SaveBtn;

    public void enterTaskName(String taskName){
        clear(TaskNameTxt);
        sendText(TaskNameTxt, taskName);
    }

    public void enterTaskDesc(String DescText){
        clear(TaskDescTxt);
        sendText(TaskDescTxt, DescText);
    }

    public void clickSaveBtn(){
        click(SaveBtn);
    }
}
