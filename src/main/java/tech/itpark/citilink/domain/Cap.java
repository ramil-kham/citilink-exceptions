package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cap extends Product {
    private String color;
    private String size;

    public Cap(long id, String name, int price, boolean removed, String color, String size) {
        super(id, name, price, removed);
        this.color = color;
        this.size = size;
    }

}
