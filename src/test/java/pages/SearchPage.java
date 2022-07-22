package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    public final By NAME_OF_CITY = By.cssSelector("[placeholder=\"Куда вы хотите поехать?\"]");
    public final By DATE_START = By.cssSelector("[data-testid=\"date-display-field-start\"]");
    public final By DATE_END = By.cssSelector("[data-testid=\"date-display-field-end\"]");
    public final By CARD = By.cssSelector("[data-testid=\"property-card\"]");
    public final By COLUMN_NAME = By.cssSelector(".d8eab2cf7f.e2a710e162");
    public final By COUNT_PEOPLE_ROOMS = By.cssSelector("[data-testid=\"occupancy-config\"]");

    public SearchPage cityCheck(String nameCity){
        $(NAME_OF_CITY).shouldHave(attribute("value", nameCity));
        return this;
    }

    public SearchPage startDateCheck(LocalDate date1){
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String correctDate = date1.format(formatter).toString();
        $(DATE_START).shouldHave(text(correctDate.substring(0, correctDate.length() - 3)));
        return this;
    }

    public SearchPage finishDateCheck(LocalDate date2){
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String correctDate = date2.format(formatter).toString();
        $(DATE_END).shouldHave(text(correctDate.substring(0, correctDate.length() - 3)));
        return this;
    }

    public SearchPage countPeopleAndRoomsCheck (int countAdults, int countChildren, int countRooms){
        $(COUNT_PEOPLE_ROOMS).shouldHave(text(String.format("%s взрослый · %s детей · %s номер",
                Integer.toString(countAdults), Integer.toString(countChildren), Integer.toString(countRooms))));
        return this;
    }

    public SearchPage countOfNightCheck(int countOfNight){
        $$(COLUMN_NAME).last().shouldHave(text(String.format("%s ночей", Integer.toString(countOfNight))));
        return this;
    }

    public SearchPage notNullCardsCheck(){
        $$(CARD).shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }


}
