package com.example.gccoffee.repository;

import com.example.gccoffee.DataSourceConfig;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = DataSourceConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductJdbcRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    private final static Product newProduct = new Product(UUID.randomUUID(), "new-product", Category.COFFEE_BEAN_PACKAGE, 1000L);

    @Test
    @Order(1)
    @DisplayName("상품을 추가할 수 있다.")
    void testProduct(){
        productRepository.insert(newProduct);
        var all = productRepository.findAll();
        assertThat(all.isEmpty()).isFalse();
    }

    @Test
    @Order(2)
    @DisplayName("상품을 이름으로 조회할 수 있다.")
    void testFindByName(){
        var product = productRepository.findByName(newProduct.getProductName());
        assertThat(product.isEmpty()).isFalse();
    }

    @Test
    @Order(3)
    @DisplayName("상품을 아이디로 조회할 수 있다.")
    void testFindById(){
        var product = productRepository.findById(newProduct.getProductId());
        assertThat(product.isEmpty()).isFalse();
    }
    @Test
    @Order(4)
    @DisplayName("상품들을 카테고리로 조회할 수 있다.")
    void testFindByCategory(){
        var product = productRepository.findByCategory(Category.COFFEE_BEAN_PACKAGE);
        assertThat(product.isEmpty()).isFalse();
    }

    @Test
    @Order(5)
    @DisplayName("상품을 수정할 수 있다.")
    void testUpdate(){
        newProduct.setProductName("updated-product");
        productRepository.update(newProduct);
        var product = productRepository.findById(newProduct.getProductId());
        assertThat(product.isEmpty()).isFalse();
        assertThat(product.get()).usingRecursiveComparison().isEqualTo(newProduct);
    }

    @Test
    @Order(6)
    @DisplayName("상품을 전체 삭제한다.")
    void testDeleteAll(){
        productRepository.deleteAll();
        var all = productRepository.findAll();
        assertThat(all.isEmpty()).isTrue();
    }



    @AfterAll
    void cleanUpAfterAll(){
        productRepository.deleteAll();
    }

}