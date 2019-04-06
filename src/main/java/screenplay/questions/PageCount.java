package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import screenplay.model.PageCountInformation;
import screenplay.view.HomePage;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class PageCount implements Question<PageCountInformation> {

    @Override
    public PageCountInformation answeredBy(Actor actor) {
        String pageCount = the(Text.of(HomePage.SELECTED_PAGE_BUTTON).viewedBy(actor));

        return new PageCountInformation(pageCount);
    }

    public static PageCount information() {
        return new PageCount();
    }
}