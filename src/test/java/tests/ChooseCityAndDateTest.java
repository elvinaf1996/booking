package tests;

import org.junit.Test;
import pages.HomePage;
import pages.SearchPage;

import java.time.LocalDate;

public class ChooseCityAndDateTest extends BaseTest {
    @Test
    public void chooseCityAndDateTest(){
        String nameOfCity = "Барселона";
        int countAdults = 1;
        int countChildren = 0;
        int countRooms = 1;
        int countOfNight = 6;
        LocalDate dateStart = LocalDate.now();
        LocalDate dateFinish = dateStart.plusDays(countOfNight);

        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.chooseACity(nameOfCity);
        homePage.selectDates(dateStart, dateFinish);
        homePage.selectNumberOfPersonAndRooms(countAdults, countChildren, countRooms);
        homePage.search();

        SearchPage searchPage = new SearchPage();
        searchPage.cityCheck(nameOfCity);
        searchPage.startDateCheck(dateStart);
        searchPage.finishDateCheck(dateFinish);
        searchPage.countPeopleAndRoomsCheck(countAdults, countChildren, countRooms);
        searchPage.countOfNightCheck(countOfNight);
        searchPage.notNullCardsCheck();

    }
}
