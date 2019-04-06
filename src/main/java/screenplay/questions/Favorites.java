package screenplay.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Favorites implements Question<Boolean> {
    private String productId;

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade favTable;
        List<WebElementFacade> rowFavs;
        Boolean existent = false;

        favTable = Target.the("fav_table").
                locatedBy("//*[@class=\"listView\"]").
                resolveAllFor(theActorInTheSpotlight()).get(0);

        rowFavs = favTable.thenFindAll(By.xpath("//*[@class=\"column wishListColumn \"]/div"));

        for (WebElementFacade rowFav : rowFavs) {
            String getAttributeHref = rowFav.getAttribute("id");
            if (getAttributeHref.contains(productId))
            {
                existent = true;
                return existent;
            }
        }

        return existent;
    }

    public static Favorites isExistent(String productId) {
        return new Favorites(productId);
    }

    public Favorites(String productId) {
        this.productId = productId;
    }
}