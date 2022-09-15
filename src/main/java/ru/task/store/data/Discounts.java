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
@Table(name = "DISCOUNTS")
public class Discounts {

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

    @Column(name = "PERCENT", nullable = false)
    @Getter
    @Setter
    private Integer percent;

}
