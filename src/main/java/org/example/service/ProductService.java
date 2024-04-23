package org.example.service;


import io.micrometer.common.util.StringUtils;
import org.example.model.Product;
import org.example.model.Rating;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(int pageNumber, int pageSize, String sortBy, String sortOrder) {
        //Default sorting.
        if (StringUtils.isEmpty(sortOrder)) {
            sortOrder = "asc";
        }

        //Default sorting.
        if (StringUtils.isEmpty(sortBy)) {
            sortBy = "name";
        }

        Pageable pageable;

        if ("asc".equalsIgnoreCase(sortOrder)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        } else if ("desc".equalsIgnoreCase(sortOrder)) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        } else {
            throw new IllegalArgumentException("Invalid sortOrder parameter. It should be 'asc' or 'desc'.");
        }
        return productRepository.getAllProducts(pageable);
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public Product updateProductRating(String id, Rating rating) {
        System.out.println(rating);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            System.out.println("found product with id="+ id);
            Product product = optionalProduct.get();

            boolean isPresent = false;
            //remove existing rating for same user. i.e. 1 rating per user per product;
            product.getRatings().removeIf(r -> r.getUserId().equals(rating.getUserId()));

            product.getRatings().add(rating);

            return productRepository.save(product);
        }
        return null;
    }

    public Page<Product> searchProducts(String name, List<String> categories,
                                        List<String> attributes, int page, int size, String sortBy, String sortOrder) {
        //Default sorting.
        if (StringUtils.isEmpty(sortOrder)) {
            sortOrder = "asc";
        }

        //Default sorting.
        if (StringUtils.isEmpty(sortBy)) {
            sortBy = "name";
        }

        Pageable pageable;

        if ("asc".equalsIgnoreCase(sortOrder)) {
            pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        } else if ("desc".equalsIgnoreCase(sortOrder)) {
            pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        } else {
            throw new IllegalArgumentException("Invalid sortOrder parameter. It should be 'asc' or 'desc'.");
        }

        return productRepository.findByNameContainingIgnoreCaseAndCategoriesInAndAttributesIn(name, categories, attributes, pageable);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}