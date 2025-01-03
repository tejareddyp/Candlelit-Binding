package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsDAO extends JpaRepository<Products, Long> {

     @Query(value = "select * from products order by stock desc", nativeQuery = true)
     List<Products> findAllProducts();
}
