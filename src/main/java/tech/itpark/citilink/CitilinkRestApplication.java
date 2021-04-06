package tech.itpark.citilink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.itpark.citilink.domain.Product;
import tech.itpark.citilink.manager.ProductManager;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CitilinkRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(CitilinkRestApplication.class, args);


    }
}