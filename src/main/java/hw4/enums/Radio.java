package hw4.enums;

/**
 * Created by Екатерина on 18.06.2018.
 */
public enum Radio {
    GOLD (0, "Gold"),
    SILVER(1,"Silver"),
    BRONZE(2, "Bronze"),
    SELEN(3, "Selen");

    public int index;
    public String name;

    Radio(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
