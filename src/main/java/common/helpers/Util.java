package common.helpers;

import common.framework.BaseConfiguration;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Util {

    public static String getProperty(String property) {
        BaseConfiguration baseConfiguration = new BaseConfiguration();

        return baseConfiguration.getProperty(property);
    }

    public static String getProductId(Target thirdProductFav) {
        String id = "";
        WebElement element = thirdProductFav.resolveAllFor(theActorInTheSpotlight()).get(0);
        id = element.getAttribute("data-productid");
        return id;
    }
}
