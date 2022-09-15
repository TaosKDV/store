package ru.task.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.task.store.data.DiscountsRepository;
import ru.task.store.data.Product;
import ru.task.store.data.ProductRepository;

@SpringBootTest
class StoreApplicationTests {

    @Test
    void searchForProductsByParameter() {
        String discountName = "Name-1";
        long discountId = 11L;
        Product product = new Product(2L, "Продукт", 12.23, 11L);
        List<Product> list = Collections.singletonList(product);

        HttpServletRequest mockHttpServletRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockHttpServletRequest.getParameter(Mockito.eq("discount"))).thenReturn(discountName);

        DiscountsRepository mockDiscountsRepository = Mockito.mock(DiscountsRepository.class);
        Mockito.when(mockDiscountsRepository.findIdByName(discountName)).thenReturn(discountId);

        ProductRepository mockProductRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(mockProductRepository.findAllByDiscountId(Mockito.eq(discountId))).thenReturn(list);

        StoreController storeController = new StoreController();
        storeController.productRepository = mockProductRepository;
        storeController.discountsRepository = mockDiscountsRepository;

        Assertions.assertEquals(list, storeController.products(mockHttpServletRequest));
    }

    @Test
    void searchAllProducts() {
        Product product1 = new Product(1L, "Продукт", 19.23, 1L);
        Product product2 = new Product(2L, "Продукт", 12.23, 11L);
        Product product3 = new Product(3L, "Продукт", 13.23, null);
        Product product4 = new Product(4L, "Продукт", 14.23, null);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        HttpServletRequest mockHttpServletRequest = Mockito.mock(HttpServletRequest.class);

        ProductRepository mockProductRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(mockProductRepository.findAll()).thenReturn(productList);

        StoreController storeController = new StoreController();
        storeController.productRepository = mockProductRepository;

        Assertions.assertEquals(productList, storeController.products(mockHttpServletRequest));
    }
}
