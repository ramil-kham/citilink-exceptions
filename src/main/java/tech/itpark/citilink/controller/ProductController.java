package tech.itpark.citilink.controller;

import org.springframework.web.bind.annotation.*;
import tech.itpark.citilink.domain.*;
import tech.itpark.citilink.manager.ProductManager;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")

public class ProductController {
    ProductManager manager = new ProductManager();

    @GetMapping()
    public ArrayList<Product> getAll() {
        return manager.getAll();
    }
    @GetMapping("/search")
    public ArrayList<Product> search(@RequestParam String text) {
        return manager.search(text);
    }
    @GetMapping("/catalog/{type}")
    public ArrayList<Product> filter(@PathVariable String type) {
        return manager.filter(type);
    }
    @PostMapping("/caps")
    public void add(@RequestBody Cap product) {
         manager.add(product);
    }
    @PostMapping("/books")
    public void add(@RequestBody Book product) {
        manager.add(product);
    }
    @PostMapping("/iphones")
    public void add(@RequestBody Iphone product) {
        manager.add(product);
    }
    @PostMapping("/laptops")
    public void add(@RequestBody Laptop product) {
        manager.add(product);
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        return  manager.getById(id);
    }
    @PutMapping("/{id}")
    public Product updateById(@PathVariable long id, @RequestBody ProductUpdate dto) {
        return manager.updateById(id, dto);
    }
    @DeleteMapping("{id}")
    public void removed(@PathVariable long id) {
        manager.removed(id);
    }
}
