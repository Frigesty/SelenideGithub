import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {
    @Test
    void searchCodeJUnit5test() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("input#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(text("SoftAssertions"));
        $(".filterable-active").$(byText("SoftAssertions")).click();
        $$(".markdown-heading .heading-element").findBy(text("3. Using JUnit5 extend test class:"))
                .closest(".markdown-heading")
                .sibling(0)
                .shouldHave(text(
                        "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}