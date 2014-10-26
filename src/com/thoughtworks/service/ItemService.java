package com.thoughtworks.service;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.vo.Item;

import java.util.List;

public class ItemService implements ItemIService {

    private ItemDao itemDao = new ItemDao();

    @Override
    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public void deleteItemById(int id) {
        itemDao.deleteItemById(id);
    }

    @Override
    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }

    @Override
    public void insertItem(Item item) {
        itemDao.insertItem(item);
    }



}
