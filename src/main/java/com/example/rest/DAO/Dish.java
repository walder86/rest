package com.example.rest.DAO;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "rest", name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Min(0)
    @Column(name = "amount")
    private Integer amount;

    @ManyToMany
    @JoinTable(schema = "rest", name = "dishes_products",
    joinColumns = @JoinColumn(name = "dish_id"),
    inverseJoinColumns = @JoinColumn(name = "products_id"))
    @JsonManagedReference
    private List<Product> products;

    @ManyToOne
    private TypeDish typeDish;

    @Column(name = "in_menu")
    private Boolean inMenu;

    @ManyToMany
    @JoinTable(schema = "rest", name = "")
    @JsonIgnore
    private List<Order> orders;

}
