package com.apex.selenium.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
    private WebDriver webDriver;

    public Checkout(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @FindBy(how= How.XPATH,using="//*[@id=\"order_name\"]")
    WebElement name;

    @FindBy(how= How.XPATH,using="//*[@id=\"order_address\"]")
    WebElement address;

    @FindBy(how= How.XPATH,using="//*[@id=\"order_email\"]")
    WebElement email;

    @FindBy(how= How.XPATH,using="//*[@id=\"order_pay_type\"]")
    WebElement paymentType;

    @FindBy(how= How.XPATH, using = "/html/body/div[1]/div[1]/div[3]/div[2]/fieldset/form/div[6]/input")
    WebElement placeOrder;


    public void completeCheckout(String name, String address, String email, String payType){
        this.name.sendKeys(name);
        this.address.sendKeys(address);
        this.email.sendKeys(email);
        Select payment = new Select(this.paymentType);
        payment.selectByValue(payType);
        placeOrder.click();
    }
}
