package hw4.enums;

/**
 * Created by Екатерина on 19.06.2018.
 */
public enum Pages {
    HOME_PAGE("Home Page", "https://epam.github.io/JDI/index.html"),
    DATES_PAGE("Dates","https://epam.github.io/JDI/dates.html"),
    DIFFERENT_ELEMENT_PAGE("Different Element", "https://epam.github.io/JDI/different-elements.html"),
    USER_TABLE("User Table", "https://epam.github.io/JDI/user-table.html");
    public String title;
    public String url;
    Pages(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
