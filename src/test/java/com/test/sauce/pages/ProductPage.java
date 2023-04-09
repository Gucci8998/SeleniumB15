package com.test.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class ProductPage {
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a//div")
    List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;

    @FindBy(css = ".inventory_details_price")
    WebElement price;

    @FindBy(xpath = "//button[.='Add to cart']")
    WebElement addtoCart;

    @FindBy(xpath = "//a//span")
    WebElement cart;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement productName;
    public void findProduct(String productNeeded, String descriptionPart,String price){
        for (WebElement product: allProducts){
            if (BrowserUtils.getText(product).equals(productNeeded)){
                product.click();
                break;
            }
        }
        Assert.assertTrue(BrowserUtils.getText(description).contains(descriptionPart));
        Assert.assertTrue(BrowserUtils.getText(this.price).contains(price));
    }

    public void addProductToCart(String productName, String price){
        for (WebElement product: allProducts){
            if (BrowserUtils.getText(product).equals(productName)){
                product.click();
                break;
            }
        }
        Assert.assertEquals(BrowserUtils.getText(this.productName),productName);
        Assert.assertTrue(BrowserUtils.getText(this.price).contains(price));
        addtoCart.click();
        cart.click();
    }
}
