package com.thoughtworks.service;

import com.thoughtworks.vo.Item;

import java.util.List;

public interface ItemIService {
    Item getItemById(int id);

    List<Item> getItems();

    void deleteItemByCode(String barcode);

    void updateItem(Item item);

    void insertItem(Item item);
}
