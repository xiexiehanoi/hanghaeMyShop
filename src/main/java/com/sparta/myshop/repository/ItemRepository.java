package com.sparta.myshop.repository;

import com.sparta.myshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAll();
}
