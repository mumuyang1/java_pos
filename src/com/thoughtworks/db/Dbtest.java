package com.thoughtworks.db;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.vo.Item;

public class Dbtest {

    public static void main(String[] args){
//        ItemIService itemDao = new ItemService();
//        Item item = new Item("ITEM000002","香蕉","斤",10.0);
//        itemDao.getItem();
//        itemDao.updateItem(item);
//        itemDao.deleteItemByCode("ITEM000005");
        ItemDao itemDao = new ItemDao();
        itemDao.deleteItemByCode("ITEM000002");
    }

}
