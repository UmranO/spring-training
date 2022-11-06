package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String code;
    private String name;

    @ManyToMany  (mappedBy = "itemList")
    private List<Cart> carts;

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
