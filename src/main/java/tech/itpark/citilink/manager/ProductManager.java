package tech.itpark.citilink.manager;

import tech.itpark.citilink.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private long nextId = 1;
    private List<Product> items = new ArrayList<>();


    public List<Product> getAll() {
        return items;
    }

    public List<Product> search(String text) {
        List<Product> result = new ArrayList<>();
        String target = text.trim().toLowerCase();
        for (Product item : items) {
            if (contains(item.getName(),target)) {
                result.add(item);
                continue;
            }
            if (item instanceof Book) {
                Book book = (Book) item;
                if (contains(book.getAuthor(),target)) {
                    result.add(item);
                }
            }
            if (item instanceof Cap) {
                Cap cap = (Cap) item;
                if (contains(cap.getColor(), target)) {
                    result.add(item);
                }
            }
            if (item instanceof Iphone) {
                Iphone iphone = (Iphone) item;
                if (contains(iphone.getOperatingSystem(), target)) {
                    result.add(item);
                }
            }
            if (item instanceof Laptop) {
                Laptop laptop = (Laptop) item;
                if (contains(laptop.getProcessor(), target)) {
                    result.add(item);
                }
            }
        }
        return result;
        //throw new RuntimeException("Product not found");
    }

    private boolean contains(String field, String target) {
        return field.toLowerCase().contains(target);
    }

    public List<Product> filter(String type) {
        List<Product> result = new ArrayList<>();
        for (Product item : items) {
            if (type.equals("caps") && item instanceof Cap) {
                result.add(item);
                continue;
            }
            if (type.equals("books") && item instanceof Book) {
                result.add(item);
                continue;
            }
            if (type.equals("iphones") && item instanceof Iphone) {
                result.add(item);
                continue;
            }
            if (type.equals("laptops") && item instanceof Laptop) {
                result.add(item);
//                continue;
            }
        }
        return result;
    }

    public void add(Cap product) {
        Cap cap = new Cap(
                nextId++,
                product.getName(),
                product.getPrice(),
                false,
                product.getColor(),
                product.getSize()
        );
        items.add(cap);
    }

    public void add(Book product) {
        Book book = new Book(
                nextId++,
                product.getName(),
                product.getPrice(),
                false,
                product.getAuthor(),
                product.getPagesCount()
        );
        items.add(book);
    }

    public void add(Iphone product) {
        Iphone iphone = new Iphone(
                nextId++,
                product.getName(),
                product.getPrice(),
                false,
                product.getOperatingSystem(),
                product.getMemorySize()
        );
        items.add(iphone);
    }

    public void add(Laptop product) {
        Laptop laptop = new Laptop(
                nextId++,
                product.getName(),
                product.getPrice(),
                false,
                product.getProcessor(),
                product.getCapacitySSD()
        );
        items.add(laptop);
    }

    public Product updateById(long id, ProductUpdate dto) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setName(dto.getName());
                item.setPrice(dto.getPrice());
                return item;
            }
        }
        throw new RuntimeException("Product not founf");
    }

    public void removed(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setRemoved(true);
                return;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public Product getById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new RuntimeException("Product not found");
    }
}
