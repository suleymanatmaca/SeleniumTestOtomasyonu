package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public final static Target SIGNIN_BUTTON =
            Target.the("SIGNIN_BUTTON").locatedBy("//*[@class=\"btnSignIn\"]");
    public final static Target SEARCH_TEXTBOX =
            Target.the("SEARCH_TEXTBOX").locatedBy("//*[@id=\"searchData\"]");
    public final static Target SEARCH_BUTTON =
            Target.the("SEARCH_BUTTON").locatedBy("//*[@class=\"searchBtn\"]");
    public final static Target SECOND_PAGE_BUTTON =
            Target.the("SECOND_PAGE_BUTTON").locatedBy("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]");
    public final static Target SELECTED_PAGE_BUTTON =
            Target.the("SELECTED_PAGE_BUTTON").locatedBy("//*[@class=\"pagination\"]/a[@class=\"active \"]");
    public final static Target THIRD_PRODUCT_FAV =
            Target.the("THIRD_PRODUCT").locatedBy("//*[@id=\"view\"]/ul/li[3]/div/div[2]/span");
    public final static Target MY_ACCOUNT =
            Target.the("MY_ACCOUNT").locatedBy("//*[@class=\"myAccount\"]");
    public final static Target FAVORITE_LINK =
            Target.the("FAVORITE_LINK").locatedBy("//*[@title=\"İstek Listem / Favorilerim\"]");
    public final static Target SIGNOUT_BUTTON =
            Target.the("SIGNOUT_BUTTON").locatedBy("//*[@title=\"Çıkış Yap\"]");


}
