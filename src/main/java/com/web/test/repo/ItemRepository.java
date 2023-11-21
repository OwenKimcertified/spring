package com.web.test.repo;

import com.web.test.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items, Long>{

    List<Items> findByName(String name);

    List<Items> findByNameOrItemDetail(String name, String itemDetail); //change (snippet err)

}
