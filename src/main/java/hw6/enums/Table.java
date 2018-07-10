package hw6.enums;

/**
 * Created by Ekaterina on 05.07.2018.
 */
public enum Table {

    Number(0), Type(1), User(2), Desciption(3);

    public int index;

    Table(int index) {
        this.index = index;
    }
}
