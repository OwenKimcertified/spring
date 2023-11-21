package com.web.test.entity;

import com.web.test.constant.ItemStatus;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="Items")
@Getter
@Setter
@ToString
public class Items {

    @Id
    @Column(name="Item_id")
    @GeneratedValue(strategy = GenerationType.AUTO) //idx of DB MySQL auto.increament
    private Long id; //product code

    @Column(nullable = false, length = 50)
    private String name; //product name

    @Column(nullable = false, name="price")
    private int price;

    @Column(nullable = false)
    private int HowMany;

    @Lob
    @Column(nullable = false)
    private String itemDetail; //change (snippet err)

    @Enumerated(EnumType.STRING)
    private ItemStatus ItemStatus; // sold out or not

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
