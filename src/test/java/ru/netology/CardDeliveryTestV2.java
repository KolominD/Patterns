package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTestV2 {
    @Test
    public void shouldReorderCard() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue(DataGenerator.getRandomCiti());
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id=date] input").sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(DataGenerator.generateDate(3));
        $("[data-test-id=name] input").setValue(DataGenerator.generateName());
        $("[data-test-id=phone] input").setValue(DataGenerator.generatePhoneNumber());
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible)
                .shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateDate(3)));
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id=date] input").sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(DataGenerator.generateDate(6));
        $(".button").click();
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldBe(visible).shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $(".notification_status_error .button").click();
        $(withText("Успешно!")).shouldBe(visible);
        $("[data-test-id='success-notification'] .notification__content").shouldBe(visible).shouldHave
                (exactText("Встреча успешно запланирована на " + DataGenerator.generateDate(6)));
    }
}
