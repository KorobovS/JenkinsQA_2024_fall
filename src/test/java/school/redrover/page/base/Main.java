package school.redrover.page.base;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();

        WebDriver driver = null;

        NewBaseModel baseModel = new NewBaseModel(driver);
        baseModel.getDriver();
        baseModel.getWait2();
        baseModel.getWait5();
        baseModel.getWait10();

        NewBasePage basePage = new NewBasePage(driver);
        basePage.getDriver();
        basePage.getWait2();
        basePage.getWait5();
        basePage.getWait10();
        basePage.gotoHomePage();

        NewBaseProjectPage baseProjectPage = new NewBaseProjectPage(driver);
        baseProjectPage.getDriver();
        baseProjectPage.getWait2();
        baseProjectPage.getWait5();
        baseProjectPage.getWait10();
        baseProjectPage.gotoHomePage();
        baseProjectPage.editDescription("text");

        NewBaseConfigPage baseConfigPage = new NewBaseConfigPage(driver);
        baseConfigPage.getDriver();
        baseConfigPage.getWait2();
        baseConfigPage.getWait5();
        baseConfigPage.getWait10();
        baseConfigPage.gotoHomePage();
        baseConfigPage.enterDescription("new text");
        baseConfigPage.clickSaveButton();
        baseConfigPage.createProjectPage();

        NewBaseCreatePage baseCreatePage = new NewBaseCreatePage(driver);
        baseCreatePage.getDriver();
        baseCreatePage.getWait2();
        baseCreatePage.getWait5();
        baseCreatePage.getWait10();
        baseCreatePage.gotoHomePage();
        baseCreatePage.clickOkButton();
        baseCreatePage.selectTypeProject("type project");
    }

    static class NewBaseModel extends BaseModel {
        public NewBaseModel(WebDriver driver) {
            super(driver);
        }
    }

    static class NewBasePage extends BasePage {
        public NewBasePage(WebDriver driver) {
            super(driver);
        }
    }

    static class NewBaseProjectPage extends BaseProjectPage<NewBaseProjectPage, Object> {
        public NewBaseProjectPage(WebDriver driver) {
            super(driver);
        }

        @Override
        protected Object createProjectConfigPage() {
            return null;
        }
    }

    static class NewBaseConfigPage extends BaseConfigPage<NewBaseConfigPage, NewBaseProjectPage> {
        public NewBaseConfigPage(WebDriver driver) {
            super(driver);
        }

        @Override
        protected NewBaseProjectPage createProjectPage() {
            return new NewBaseProjectPage(getDriver());
        }
    }

    static class NewBaseCreatePage extends BaseCreatePage<NewBaseCreatePage> {
        public NewBaseCreatePage(WebDriver driver) {
            super(driver);
        }
    }
}