package com.example.rest.Controllers;


import com.example.rest.DAO.Product;
import com.example.rest.Services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    //создание продукта
    @RequestMapping(value = "/create",produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product){
        log.info("Product create - {}", product.getName());
        return productService.createProduct(product);
    }

    //Отображение всех продуктов
    @RequestMapping(produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Product> getProducts(){
        log.info("Get products");
        return productService.getProducts();
    }
}
