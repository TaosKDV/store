package ru.task.store.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DiscountsRepository extends CrudRepository<Discounts, Long> {

    @Query(value = "SELECT ID FROM DISCOUNTS WHERE NAME = ?1",
        nativeQuery = true)
    Long findIdByName(String name);

}