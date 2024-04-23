package org.example.controller;


import org.example.model.Product;
import org.example.model.ProductSearchRequest;
import org.example.model.Rating;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(required = true) int pageSize,
                                        @RequestParam(required = true) int pageNumber,
                                        @RequestParam(required = false) String sortOrder,
                                        @RequestParam(required = false) String sortBy) {
        return productService.getAllProducts(pageNumber, pageSize, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<Product> updateProductRating(@PathVariable String id, @RequestBody Rating rating) {
        Product updatedProduct = productService.updateProductRating(id, rating);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Product>> searchProducts(@RequestBody ProductSearchRequest productSearchRequest) {
        System.out.println(productSearchRequest);
        Page<Product> searchProducts = productService.searchProducts(productSearchRequest.getName(),
                productSearchRequest.getCategories(),
                productSearchRequest.getAttributes(),
                productSearchRequest.getPageNumber(),
                productSearchRequest.getPageSize(),
                productSearchRequest.getSortBy(),
                productSearchRequest.getSortOrder());

        return new ResponseEntity<>(searchProducts, HttpStatus.OK);
    }


}
