package com.sparta.myshop.controller;


import com.sparta.myshop.dto.ItemRequestDto;
import com.sparta.myshop.dto.ItemResponseDto;
import com.sparta.myshop.dto.ItemUpdateDto;
import com.sparta.myshop.entity.Item;
import com.sparta.myshop.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class ItemController {
    //게시글 작성
    //판매게시글 전체 리스트 조회
    //판매게시글 수정
    //게시글 삭제
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    public ItemResponseDto createMemo(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);

    }

    @GetMapping
    public List<ItemResponseDto> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/{id}")
    public ItemUpdateDto updateMemo(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        Map<String, String> response = new HashMap<>();
        response.put("msg", "삭제완료");
        return ResponseEntity.ok(response);
    }
}
