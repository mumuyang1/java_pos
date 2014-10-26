package com.thoughtworks.dao;

import com.thoughtworks.vo.Item;

import java.util.List;

public interface ItemIDao {
    Item getItemById(int id);

    List<Item> getItems();

    void deleteItemByCode(String barcode);

    void updateItem(Item item);

    void insertItem(Item item);
}
