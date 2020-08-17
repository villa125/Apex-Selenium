package com.apex.selenium.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderSummary {
    private WebDriver webDriver;
    public OrderSummary(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @FindBy(how= How.XPATH, using = "/html/body/div[1]/div[1]/div[3]/div[2]/form[1]/div/input")
    WebElement completeAdoption;

    @FindBy(how= How.XPATH, using = "/html/body/div[1]/div[1]/div[3]/div[2]/form[2]/div/input[1]")
    WebElement anotherPuppy;

    @FindBy(how= How.XPATH, using = "/html/body/div[1]/div[1]/div[3]/div[2]/form[3]/div/input[2]")
    WebElement changeMind;

    public void completeAdoption(){
        completeAdoption.click();
    }

    public void addAnotherPuppy(){
        anotherPuppy.click();
    }

    public void changeMind(){
        changeMind.click();
    }
}
