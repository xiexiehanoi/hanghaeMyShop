package com.sparta.myshop.dto;

import com.sparta.myshop.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemUpdateDto {
    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    public ItemUpdateDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.price = item.getPrice();
        this.content = item.getContent();
        this.username = item.getUsername();
    }
}
