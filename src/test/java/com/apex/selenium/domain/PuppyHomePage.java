package com.apex.selenium.domain;

import com.sun.org.apache.xpath.internal.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class PuppyHomePage {
    private WebDriver webDriver;

    public PuppyHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @FindBy(how= How.XPATH,using="/html/body/div[1]/div[1]/div[3]/div[2]/div/div[4]/form/div/input")
    WebElement detailsPet1;

    @FindBy(how= How.XPATH,using="/html/body/div[1]/div[1]/div[3]/div[3]/div/div[4]/form/div/input")
    WebElement detailsPet2;

    @FindBy(how= How.XPATH,using="/html/body/div[1]/div[1]/div[3]/div[4]/div/div[4]/form/div/input")
    WebElement detailsPet3;

    @FindBy(how= How.XPATH,using="/html/body/div[1]/div[1]/div[3]/div[5]/div/div[4]/form/div/input\n")
    WebElement detailsPet4;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div[3]/div[2]/div/form/div/input[1]")
    WebElement adopt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"notice\"]")
    WebElement noticeMessage;

    public void lookForPetDetails(int dogNo) throws Throwable{
        Thread.sleep(2000);
        switch (dogNo){
            case 1 :
                detailsPet1.click();
                break;

            case 2 :
                detailsPet2.click();
                break;

            case 3 :
                detailsPet3.click();
                break;

            case 4 :
                detailsPet4.click();
        }

    }

    public void adopt() {
        adopt.click();
    }

    public String getNoticeMessage(){
        return noticeMessage.getText();
    }
}
