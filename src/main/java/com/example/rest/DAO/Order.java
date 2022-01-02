package com.example.rest.DAO;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(schema = "rest", name = "order_dishes",
    joinColumns = @JoinColumn(name = "order_id"),
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


    /*{
        "id": 1,
            "user": {
        "id": 1,
                "email": "qwe@mail.ru",
                "password": "1234567890",
                "role": "admin"
    },
        "dishes": [
        {
            "id":1,
                "name":"Бутерброд"
        }
        ],
        "status": "Создан"
    }*/

}
