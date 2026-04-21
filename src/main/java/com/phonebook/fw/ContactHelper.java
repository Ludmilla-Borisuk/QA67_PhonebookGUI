package com.phonebook.fw;

import com.phonebook.core.BaseHelper;
import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[1]"), contact.getName());
        type(By.xpath("//input[2]"), contact.getLastName());
        type(By.xpath("//input[3]"), contact.getPhone());
        type(By.xpath("//input[4]"), contact.getEmail());
        type(By.xpath("//input[5]"), contact.getAddress());
        type(By.xpath("//input[6]"), contact.getDescription());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactCreatedByText(String text) {
        if (verifyText(text, By.cssSelector("h2"))) return true;
        return false;
    }

    public boolean verifyText(String text, By locator) {
        List<WebElement> contacts = driver.findElements(locator);
        for (WebElement element: contacts){
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeContact() {
        // click on card
        click(By.cssSelector(".contact-item_card__2SOIM"));

        // click on Remove button
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public boolean verifyByNamePhone(String text) {
        if (verifyText(text,By.cssSelector("h3"))) return true;
        return false;
    }
}
