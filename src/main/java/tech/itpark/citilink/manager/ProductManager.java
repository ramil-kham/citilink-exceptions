package tech.itpark.citilink.manager;

import tech.itpark.citilink.domain.*;

import java.util.ArrayList;

public class ProductManager {
    //private long nextId = 1;
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
                continue;
            }
        }
        return result;
    }

    public void add(Product product) {
        items.add(product);
    }

    public Product update(String type, Product product) {
        //ArrayList<Product> result = new ArrayList<>();
        for (Product item : items) {
            if (type.equals("caps") && item instanceof Cap) {
                Cap cap = (Cap) item;
                ((Cap) item).setColor(cap.getColor());
                ((Cap) item).setSize(cap.getSize());
                return item;
            }
            if (type.equals("books") && item instanceof Book) {
                Book book = (Book) item;
                ((Book) item).setAuthor(book.getAuthor());
                ((Book) item).setPagesCount(book.getPagesCount());
                return item;
            }
            if (type.equals("iphones") && item instanceof Iphone) {
                Iphone iphone = (Iphone) item;
                ((Iphone) item).setOperatingSystem(iphone.getOperatingSystem());
                ((Iphone) item).setMemorySize(iphone.getMemorySize());
                return item;
            }
            if (type.equals("laptops") && item instanceof Laptop) {
                Laptop laptop = (Laptop) item;
                ((Laptop) item).setCapacitySSD(laptop.getCapacitySSD());
                ((Laptop) item).setProcessor(laptop.getProcessor());
                return item;
            }
        }
        return null;
    }


    public void removed(String type) {
        for (Product item : items) {
            if (type.equals("books") && item instanceof Book) {
                Book book = (Book) item;
                item.setRemoved(true);
            }
        }
    }
}
