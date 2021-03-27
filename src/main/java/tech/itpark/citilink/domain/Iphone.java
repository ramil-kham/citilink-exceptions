package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Iphone extends Product {
    private String operatingSystem;
    private int memorySize;

    public Iphone(long id, String name, int price, boolean removed, String operatingSystem, int memorySize) {
        super(id, name, price, removed);
        this.operatingSystem = operatingSystem;
        this.memorySize = memorySize;
    }
}
