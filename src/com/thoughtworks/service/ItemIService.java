package com.thoughtworks.service;

import com.thoughtworks.vo.Item;

import java.util.List;

public interface ItemIService {
    Item getItemBycode(String barcode);

    List<Item> getItems();

    void deleteItemByCode(String barcode);

    void updateItem(Item item);

    void insertItem(Item item);
}
