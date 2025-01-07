package com.casestudy.webapp;

import com.casestudy.webapp.database.dao.ProductsDAO;
import com.casestudy.webapp.database.entity.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductsDAOTest {

    @Autowired
    private ProductsDAO productsDAO;

    @ParameterizedTest
    @CsvSource({
            "1, firestation binder,20",
            "3,mountains binder,20",
            "5,red roses book large, 25"

    })
    public void TestFindProductsById(int productId, String productName, double price) {


        Products actual = productsDAO.findProductsById(productId);

        Assertions.assertEquals(productId, actual.getId());
        Assertions.assertEquals(productName, actual.getName());
        Assertions.assertEquals(price, actual.getPrice());



//        Products products = new Products();
//        products.setName("test");
//        products.setStock(5);
//        products.setPrice(10.0);
//        productsDAO.save(products);
    }
}
