package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Book extends Product {
    private String author;
    private int pagesCount;

    public Book(long id, String name, int price, boolean removed, String author, int pagesCount) {
        super(id, name, price, removed);
        this.author = author;
        this.pagesCount = pagesCount;
    }
}
