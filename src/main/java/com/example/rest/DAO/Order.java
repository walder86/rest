package com.example.rest.DAO;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "rest", name = "orders")
@JsonIgnoreProperties({"user"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    private User user;

    @JsonIgnoreProperties({"id", "products", "amount"})
    @ManyToMany
    @JoinTable(schema = "rest", name = "dishes_orders",
    joinColumns = @JoinColumn(name = "orders_id"),
    inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishes;

    @Column(name = "date")
    @JsonIgnore
    private Date date;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    public Double getAmount(){
        double summ=0;
        for (Dish d:dishes){
            summ = summ + d.getAmount();
        }
        return summ;
    }

    public String dishes(){
        String dishesNames = null;
        for (Dish d :dishes){
            dishesNames = dishesNames + d.getName() + ",\n";
        }
        return dishesNames;
    }


    /*{
        "user": {
        "id": 1,
                "email": "qwe@mail.ru",
                "password": "1234567890",
                "role": "admin"
    },
        "dishes": [
        {
            "id": 1,
                "name": "Бутерброд",
                "amount": 10,
                "products": [
            {
                "id": 1,
                    "name": "Колбаса",
                    "quantity": 10
            }
        ],
            "inMenu": true
        },
        {
            "id": 2,
                "name": "Бутерброд",
                "amount": 10,
                "products": [
            {
                "id": 1,
                    "name": "Колбаса",
                    "quantity": 10
            },
            {
                "id": 2,
                    "name": "Хлеб",
                    "quantity": 5
            }
        ],
            "inMenu": true
        },
        {
            "id": 3,
                "name": "Нарезка",
                "amount": 10,
                "products": [
            {
                "id": 1,
                    "name": "Колбаса",
                    "quantity": 10
            }
        ],
            "inMenu": true
        },
        {
            "id": 4,
                "name": "Нарезка",
                "amount": 10,
                "products": [
            {
                "id": 1,
                    "name": "Колбаса",
                    "quantity": 10
            },
            {
                "id": 2,
                    "name": "Хлеб",
                    "quantity": 5
            }
        ],
            "inMenu": true
        }
],
        "status": "Создан"
    }*/

}
