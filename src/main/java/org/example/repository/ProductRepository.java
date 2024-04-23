package org.example.repository;

import org.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    // You can define custom query methods here if needed
    Page<Product> findByNameContainingIgnoreCaseAndCategoriesInAndAttributesIn(
            @Param("name") String name, @Param("name") List<String> categories, @Param("attributes") List<String> attributes, Pageable pageable);

    @Query("{}")
    Page<Product> getAllProducts(Pageable pageable);

    @Query("{" +
            "$and: [" +
            "{ 'name' : { $regex: ?0, $options: 'i' } }," + // Case-insensitive name search
            "{ 'categories' : { $in: ?1 } }," + // Match categories
            "{ 'attributes' : { $elemMatch: { $in: ?2 } } }" + // Match attributes
            "]" +
            "}")
    Page<Product> findByCustomQuery(@Param("name") String name, @Param("name") List<String> categories, @Param("attributes") List<String> attributes, Pageable pageable);
}