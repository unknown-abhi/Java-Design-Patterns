package HashCode_and_Equals;

import java.util.Objects;

public class HashCodeAndEquals {
    public static void main(String[] args) {

        Pen pen1 = new Pen(9, "Blue");
        Pen pen2 = new Pen(9, "Blue");

        System.out.println(pen1.equals(pen2));

        // It will print hashCode
        System.out.println(pen1);
        System.out.println(pen2);
    }

}

class Pen {
    int price;
    String color;

    Pen(int price, String color) {
        this.price = price;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pen pen = (Pen) obj;
        return this.price == pen.price && this.color.equals(pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, color);
    }
}
