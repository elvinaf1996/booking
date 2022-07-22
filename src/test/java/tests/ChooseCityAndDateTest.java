package tests;

import org.junit.Test;
import pages.HomePage;
import pages.SearchPage;

import java.time.LocalDate;

public class ChooseCityAndDateTest extends BaseTest {
    @Test
    public void chooseCityAndDateTest(){
        String nameOfCity = "Барселона";
        LocalDate dateStart = LocalDate.now();
        LocalDate dateFinish = dateStart.plusDays(6);
        int countAdults = 1;
        int countChildren = 0;
        int countRooms = 1;
        int countOfNight = 6;

        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.chooseACity(nameOfCity);
        homePage.selectDates(dateStart, dateFinish);
        homePage.selectNumberOfPersonAndRooms(countAdults, countChildren, countRooms);

        SearchPage searchPage = new SearchPage();
        searchPage.cityCheck(nameOfCity)
                .startDateCheck(dateStart)
                .finishDateCheck(dateFinish)
                .countPeopleAndRoomsCheck(countAdults, countChildren, countRooms)
                .countOfNightCheck(countOfNight)
                .notNullCardsCheck();

    }
}
