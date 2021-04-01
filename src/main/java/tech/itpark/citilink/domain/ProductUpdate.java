package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductUpdate extends Product{
    public ProductUpdate(long id, String name, int price, boolean removed) {
        super(id, name, price, removed);
    }

}
