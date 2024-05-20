package com.sparta.myshop.service;

import com.sparta.myshop.dto.ItemRequestDto;
import com.sparta.myshop.dto.ItemResponseDto;
import com.sparta.myshop.dto.ItemUpdateDto;
import com.sparta.myshop.entity.Item;
import com.sparta.myshop.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository  = itemRepository;
    }


    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = new Item(requestDto);

        // DB 저장
        Item saveItem = itemRepository.save(item);

        // Entity -> ResponseDto
        ItemResponseDto itemResponseDto = new ItemResponseDto(item);

        return itemResponseDto;
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponseDto::new).toList();
    }


    public ItemUpdateDto updateItem(Long id, ItemRequestDto requestDto) {
        Item item = findItem(id);
        // item 내용 수정
        item.update(requestDto);
        return new ItemUpdateDto(item);
    }

    public void deleteItem(Long id) {
        Item item = findItem(id);

        // item 삭제
        itemRepository.delete(item);
    }

    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 아이템은 존재하지 않습니다.")
        );
    }
}
