package com.sparta.myshop.dto;

import com.sparta.myshop.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemResponseDto {
    private Long id;

    private String title;


    private int price;

    private String username;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }

}
