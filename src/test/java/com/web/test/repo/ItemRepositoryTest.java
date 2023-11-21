package com.web.test.repo;

import com.web.test.constant.ItemStatus;
import com.web.test.entity.Items;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.time.LocalDateTime;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    @DisplayName("product sample testing")

    public void productSampleTest(){
        Items items = new Items();
        items.setName("testP");
        items.setPrice(50000);
        items.setItemDetail("detail explain");
        items.setItemStatus(ItemStatus.SOLD_OUT);
        items.setHowMany(50);
        items.setRegTime(LocalDateTime.now());
        items.setUpdateTime(LocalDateTime.now());

        Items savedItem = itemRepository.save(items);
        System.out.println(savedItem.toString());
    }

    public void createItemsList(){
        for(int i=1;i<=10;i++){
            Items items = new Items();
            items.setName("product"+i);
            items.setPrice(10000+i);
            items.setItemDetail("상품 설명"+i);
            items.setItemStatus(ItemStatus.SELL);
            items.setHowMany(50+i);
            items.setRegTime(LocalDateTime.now());
            items.setUpdateTime(LocalDateTime.now());

            Items savedItems2 = itemRepository.save(items);
        }
    }

    @Test
    @DisplayName("상품 조회")
    public void findByName(){
        this.createItemsList();
        List<Items> itemsList = itemRepository.findByName("product2");
        for(Items items: itemsList){
            System.out.println(items.toString());
        }
    }

    @Test
    @DisplayName("상품명, 상품 설명 or test")
    public void findByNameOrDetail(){
       this.createItemsList();
       List<Items> itemsList = itemRepository.findByNameOrItemDetail("product6", "상품 설명6");
       for(Items items : itemsList){
           System.out.println(items.toString());
       }
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

//JPA가 내부적으로 사용하는 규칙에 따라 메서드 이름을 분석할 때 itemDetail로 인식하는 문제 (대소문자) 왜지?