package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Laptop extends Product {
    private String processor;
    private int capacitySSD;

    public Laptop(long id, String name, int price, boolean removed, String processor, int capacitySSD) {
        super(id, name, price, removed);
        this.processor = processor;
        this.capacitySSD = capacitySSD;
    }
}
