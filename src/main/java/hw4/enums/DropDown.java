package hw4.enums;

/**
 * Created by Екатерина on 18.06.2018.
 */
public enum DropDown {
    RED(0, "Red"),
    GREEN(1, "Green"),
    BLUE(2, "Blue"),
    YELLOW(3, "Yellow");

    public int index;
    public String name;

    DropDown(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
