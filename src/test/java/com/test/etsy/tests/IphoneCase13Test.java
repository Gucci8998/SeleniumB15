package com.test.etsy.tests;

import com.test.blaze.tests.TestBaseBlaze;
import com.test.etsy.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IphoneCase13Test extends TestBaseEtsy {
@Parameters({"searchingItem","keyword1","keyword2","keyword3"})

@Test
    public void validateMainPage(String searchingItem, String keyword1, String keyword2,String keyword3){
    MainPage mainPage = new MainPage(driver);
    mainPage.findIphone13case(searchingItem,keyword1,keyword2,keyword3 );

}

}
