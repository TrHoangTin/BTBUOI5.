package com.example.BTBUOI5.Controller;

import com.example.BTBUOI5.Model.Product;
import com.example.BTBUOI5.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product newProduct,
                         BindingResult result,
                         @RequestParam(value = "imageProduct", required = false) MultipartFile imageProduct,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", newProduct);
            return "products/create";
        }

        if (imageProduct != null && !imageProduct.isEmpty()) {
            try {
                File saveFile = new ClassPathResource("static/image").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImage(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        productService.add(newProduct);
        return "redirect:/products";
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("listProduct", productService.getAll());
        return "products/index";
    }
//    public void edit(Product editProduct) {
//        Product find = listProduct.get(editProduct.getId());
//        if (find != null) {
//            find.setName(editProduct.setName());
//            find.setImage(editProduct.getImage());
//            find.setPrice(editProduct.getPrice());
//        }
//    }
}