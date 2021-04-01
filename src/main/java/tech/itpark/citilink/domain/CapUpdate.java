package tech.itpark.citilink.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CapUpdate extends Cap{
    public CapUpdate(long id, String name, int price, boolean removed, String color, String size) {
        super(id, name, price, removed, color, size);
    }

}
