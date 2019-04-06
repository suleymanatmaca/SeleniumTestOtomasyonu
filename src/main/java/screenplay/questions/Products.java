package screenplay.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Products implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        WebElementFacade producTable;
        List<WebElementFacade> rowProducts;
        int count=0;

        producTable = Target.the("product_table").
                locatedBy("//*[contains(@class, 'listView')]").
                resolveAllFor(theActorInTheSpotlight()).get(0);

        rowProducts = producTable.thenFindAll(By.xpath("//*[@id=\"view\"]/ul/li[@class=\"column \"]"));
        count = rowProducts.size();

        return count;
    }

    public static Products getProductsCount() {
        return new Products();
    }
}