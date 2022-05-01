package com.example.gccoffee.controller;

import com.example.gccoffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String productsPage(Model model) {
        var products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("new-product")
    public String newProductPage(){
        return "new-product";
    }


    @PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest){

        log.info("new product -> {}", createProductRequest);
        productService.createProduct(createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price(),
                createProductRequest.description());
        return "redirect:/products";
    }

}
