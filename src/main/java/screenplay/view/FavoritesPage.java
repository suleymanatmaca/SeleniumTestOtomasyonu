package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;

public class FavoritesPage {
    public final static Target FAVORITES =
            Target.the("FAVORITES").locatedBy("//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a/h4");
    public final static Target POPUP =
            Target.the("POPUP").locatedBy("//*[@class=\"btnHolder\"]/span");
}
