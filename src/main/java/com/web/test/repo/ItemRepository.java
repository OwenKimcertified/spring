package com.web.test.repo;

import com.web.test.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Items, Long>{

}
