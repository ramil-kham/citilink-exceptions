package tech.itpark.citilink.manager;

import tech.itpark.citilink.domain.*;

import java.util.ArrayList;

public class ProductManager {
    private long nextId = 1;
    private ArrayList<Product> items = new ArrayList<>();


    public ArrayList<Product> getAll() {
        return items;
    }

    public ArrayList<Product> search(String text) {
        ArrayList<Product> result = new ArrayList<>();
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
    }

    private boolean contains(String field, String target) {
        return field.toLowerCase().contains(target);
    }

    public ArrayList<Product> filter(String type) {
        ArrayList<Product> result = new ArrayList<>();
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
        return null;
    }

    public void removed(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setRemoved(true);
                return;
            }
        }
    }

    public Product getById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
