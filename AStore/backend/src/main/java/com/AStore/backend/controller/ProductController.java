package com.AStore.backend.controller;

import com.AStore.backend.model.Product;
import com.AStore.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Product> getPage(
            @RequestParam(name = "page") Integer pageNumber,
            @RequestParam(name = "size") Integer size,
            @RequestParam(name = "category_id", required = false) Long category_id,
            @RequestParam(name = "manager_id", required = false) Long manager_id) {
        Page page;
        if(category_id==null && manager_id!=null)
            page = productService.getOwnPage(pageNumber, size, manager_id);
        else page = productService.getPage(pageNumber, size, category_id);
        return page.getContent();
    }

    @RequestMapping(value = "/total-pages", method = RequestMethod.GET)
    public Integer getTotalPages(
            @RequestParam(name = "size") Integer size,
            @RequestParam(name = "category_id", required = false) Long category_id,
            @RequestParam(name = "manager_id", required = false) Long manager_id) {
        Page page;
        if(manager_id!=null && category_id==null)
            page = productService.getOwnPage(1,size,manager_id);
        else page = productService.getPage(1, size,category_id);

        return page.getTotalPages();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(
            @PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product saveProduct(
            @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(
            @PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
