package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HelpAndSupportModule {
    WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
    SelenideElement emailField = $("input[placeholder='Your email']");
    SelenideElement messageField = $( "textarea[maxlength='2000']");
    SelenideElement homeTab = $("a[class='wZhsh3W inapphelp-tab']");
    SelenideElement contactSupportMessage = $(".inapphelp-card__description");

    SelenideElement charactersNumbers = $(By.xpath("//*[@class='PN66Kz+ inapphelp-textarea-counter']"));
    WebElement iframe1 = $(By.xpath("(*//div[@class='xlvBa4A CIIo+ZN']//*)[4]"));
    SelenideElement captchaVerification = $(By.xpath("(//div[@class='rc-anchor-center-container']//*)[3]"));
    SelenideElement sendButton = $(By.xpath("*//div[@class='xlvBa4A CIIo+ZN']/following-sibling::*"));
    SelenideElement inputAlert = $(By.xpath("//div[contains(text(), 'Input your email')]"));

    public HelpAndSupportModule sendEmail(String email){
        emailField.shouldBe(Condition.enabled);
        emailField.click();
        emailField.sendKeys(email);
        return this;
    }

    public HelpAndSupportModule sendMessage(String message){
        messageField.shouldBe(Condition.enabled);
        messageField.click();
        messageField.sendKeys(message);
        return this;
    }

    public boolean CheckEmailandMessage(String expectedEmail, String expectedMessage) {
        return (emailField.getValue().contains(expectedEmail))&(messageField.getValue().contains(expectedMessage));

    }

    public boolean IsDisplayEmailandMessage(){
        return emailField.isDisplayed()&messageField.isDisplayed();
    }

    public HelpAndSupportModule switchToIframe(){
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        return this;
    }

    public HelpAndSupportModule switchToIframe1(){
        WebDriverRunner.getWebDriver().switchTo().frame(iframe1);
        return this;
    }

    public HelpAndSupportModule returnToIframe(){
        WebDriverRunner.getWebDriver().switchTo().parentFrame();
        return this;
    }

    public HelpAndSupportModule HomeTab(){
        homeTab.shouldBe(visible,Duration.ofSeconds(5));
        homeTab.click();
        return this;
    }

    public HelpAndSupportModule CaptchaVerification(){
        captchaVerification.shouldBe(visible,Duration.ofSeconds(5));
        captchaVerification.click();
        return this;
    }

    public HelpAndSupportModule SendButton(){
        sendButton.shouldBe(visible,Duration.ofSeconds(5));
        sendButton.click();
        return this;
    }

    public String InputAlertGetText(){
        inputAlert.shouldBe(visible,Duration.ofSeconds(5));
        return inputAlert.getText();
    }

    public HelpAndSupportModule ContactSupportMessage(){
        contactSupportMessage.shouldBe(visible,Duration.ofSeconds(5));
        contactSupportMessage.click();
        return this;
    }

    public String GetContactSupportMessage() {
        contactSupportMessage.shouldBe(visible,Duration.ofSeconds(5));
        return contactSupportMessage.getText();
    }

    public String GetTextCharacterNumber() {
        return charactersNumbers.getText();
    }



}
