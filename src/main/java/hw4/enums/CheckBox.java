package hw4.enums;

/**
 * Created by Екатерина on 18.06.2018.
 */
public enum CheckBox {
    WATER (0, "Water"),
    EARTH (1, "Earth"),
    WIND (2, "Wind"),
    FIRE(3, "Fire");

    public int index;
    public String name;

    CheckBox(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static CheckBox getCheckBox(String string){
        return valueOf(string.toUpperCase());
    }
}
