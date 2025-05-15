import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ActionsTest {
    @Test
    void CheckLoadPageTest (){
        open("https://github.com/");
        $$("button[class^='HeaderMenu-link']").findBy(text("Solutions")).hover();
        $$("a[class^='HeaderMenu-dropdown-link ']").findBy(text("Enterprises")).click();
        withTagAndText("h1","The AI-powered developer platform");
    }

    @Test
    void DragAndDropByActionsTest (){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement blokA = $("#column-a");
        SelenideElement blokB = $("#column-b");
        actions().clickAndHold(blokA).moveToElement(blokB).release().build().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void DragAndDropTestByToElementTest (){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
