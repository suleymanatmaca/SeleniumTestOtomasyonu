package steps;

import common.helpers.DataHelper;
import common.helpers.Util;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import screenplay.questions.Favorites;
import screenplay.questions.PageCount;
import screenplay.questions.Products;
import screenplay.view.FavoritesPage;
import screenplay.view.HomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class UrunSecimi {

    public static String productId;
    ;

    @Then("^Search alanına ([^\\\"]*) yazar$")
    public void search_Alanına_Search_Yazar(String search) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(DataHelper.getDataParameter(search)).into(HomePage.SEARCH_TEXTBOX)
        );
    }

    @And("^Ara butonuna basar$")
    public void ara_Butonuna_Basar() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.SEARCH_BUTTON)
        );
    }

    @And("^Ürünleri görür$")
    public void ürünleri_Görür() {
        Assert.assertTrue(Products.getProductsCount().answeredBy(theActorInTheSpotlight()) > 0);
    }

    @Then("^2. sayfaya tıklar")
    public void sayfaya_Tıklar() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.SELECTED_PAGE_BUTTON, isVisible()),
                Click.on(HomePage.SECOND_PAGE_BUTTON)
        );
    }

    @And("^([^\\\"]*). sayfanın açık olduğunu görür")
    public void sayfanın_Açık_Olduğunu_Görür(String text) {
        theActorInTheSpotlight().should(
                seeThat(PageCount.information(),
                        displays("pageCount", equalTo(text)))
        );
    }


    @Then("^Ustten 3. ürünün içindeki 'favorilere ekle' butonuna tıklar")
    public void ustten_Ürünün_Içindeki_Favorilere_Ekle_Butonuna_Tıklar() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.THIRD_PRODUCT_FAV, isVisible()),
                Click.on(HomePage.THIRD_PRODUCT_FAV)
        );
        productId = Util.getProductId(HomePage.THIRD_PRODUCT_FAV);
    }


    @And("^Ekranın en üstündeki 'favorilerim' linkine tıklar$")
    public void ekranın_En_Üstündeki_Favorilerim_Linkine_Tıklar() {
        theActorInTheSpotlight().attemptsTo(
                Hover.over(HomePage.MY_ACCOUNT),
                WaitUntil.the(HomePage.FAVORITE_LINK, isVisible()),
                Click.on(HomePage.FAVORITE_LINK)
        );
    }

    @And("^Açılan sayfada ilgili ürünün bulunduğunu doğrular$")
    public void açılan_Sayfada_Ilgili_Ürünün_Bulunduğunu_Doğrular() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(FavoritesPage.FAVORITES),
                WaitUntil.angularRequestsHaveFinished()
        );

        Assert.assertTrue(
                Favorites.isExistent(productId).
                        answeredBy(theActorInTheSpotlight()
                        )
        );
    }

    @Then("^'Kaldir' butonuna basar$")
    public void kaldir_Butonuna_Basar() {
        theActorInTheSpotlight().attemptsTo(
                Click.on("#p-"+productId+" .deleteProFromFavorites"),
                WaitUntil.the(FavoritesPage.POPUP,isVisible()),
                Click.on(FavoritesPage.POPUP)
        );
    }

    @And("^Ilgili ürünün favorilerimden çıkarılğını görür$")
    public void ilgili_Ürünün_Favorilerimden_Çıkarılğını_Görür() {
        Assert.assertFalse(
                Favorites.isExistent(productId).
                        answeredBy(theActorInTheSpotlight()
                        )
        );
    }
}
