package ru.task.store.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
public class Product {

    protected Product() {
    }

    public Product(Long id, String name, Double price, Long discountId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountId = discountId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "PRICE", nullable = false)
    @Getter
    @Setter
    private Double price;

    @Column(name = "DISCOUNT_ID")
    @Getter
    @Setter
    private Long discountId;

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", discountId=" + discountId +
            '}';
    }
}
