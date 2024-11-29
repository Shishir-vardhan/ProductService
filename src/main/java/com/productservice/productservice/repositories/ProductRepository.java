package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAll();

    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleAndDescription(String title, String description);

    List<Product> findAllByCategoryName(String categoryName);

    List<Product> findAllByPrice_ValueEquals(double price);

    // You can create a your own query and run it in place of jpa queries. Using below method.
//    @Query(value = " ", nativeQuery = true)
//    List<Product> findAllByPrice_ValueEquals(double price);

}
