package com.web.test.repo;

import com.web.test.constant.ItemStatus;
import com.web.test.entity.Items;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    @DisplayName("product sample testing")
    @Test
    public void productSampleTest(){
        Items items = new Items();
        items.setName("testP");
        items.setPrice(50000);
        items.setItem_detail("detail explain");
        items.setItemStatus(ItemStatus.SOLD_OUT);
        items.setHow_many(50);
        items.setRegTime(LocalDateTime.now());
        items.setUpdateTime(LocalDateTime.now());

        Items savedItem = itemRepository.save(items);
        System.out.println(savedItem.toString());
    }
}

// console.log
// Hibernate:
//    call next value for hibernate_sequence
//Hibernate:
//    insert
//    into
//        items
//        (item_status, how_many, item_detail, name, price, reg_time, update_time, item_id)
//    values
//        (?, ?, ?, ?, ?, ?, ?, ?)

// This is JPA
// insert query 없이 인터페이스 작성만으로 db에 데이터를 저장할 수 있음.
// 런타임 시점 자바의 Dynamic Proxy를 이용해 객체를 동적으로 생성.
// DAO와 XML 파일에 쿼리문을 작성하지 않아도 됨.