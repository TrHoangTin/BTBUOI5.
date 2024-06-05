package com.example.BTBUOI5.Service;

import com.example.BTBUOI5.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> listProduct = new ArrayList<>();

    public ProductService(){
        // Adding initial products to the list
//        listProduct.add(new Product(1, "san pham 1","1.jpg",29312));
//        listProduct.add(new Product(2, "san pham 2","1.jpg",12345));
    }

    public void add(Product newProduct){
        // Adding a new product to the list
        listProduct.add(newProduct);
    }

    public List<Product> getAll() {
        // Returning all products
        return listProduct;
    }

    public Product get(int id) {
        // Finding product by id
        Optional<Product> productOptional = listProduct.stream().filter(p -> p.getId() == id).findFirst();
        return productOptional.orElse(null);
    }

    public void edit(Product editProduct){
        // Editing a product (not implemented yet)
    }
}
