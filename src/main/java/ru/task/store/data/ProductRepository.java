package ru.task.store.data;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM PRODUCT WHERE DISCOUNT_ID = ?1",
        nativeQuery = true)
    List<Product> findAllByDiscountId(Long id);

}