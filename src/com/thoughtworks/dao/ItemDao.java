package com.thoughtworks.dao;

import com.thoughtworks.util.DbUtil;
import com.thoughtworks.vo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements ItemIDao {

    private DbUtil dbUtil = new DbUtil();

    public static void main(String[] args){
        ItemDao itemDao = new ItemDao();
//        Item item = new Item("ITEM000002","香蕉","斤",10.0);
//        itemDao.getItem();
//        itemDao.updateItem(item);
//        itemDao.deleteItemByCode("ITEM000005");
        System.out.print(itemDao.getItems());
    }

    @Override
    public Item getItemBycode(String barcode){
        Item item = null;

        String sql = "SELECT * FROM items WHERE barcode = '"+barcode+"'";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();//将迭代器往下一个，返回true或false

            item = new Item(rs.getString("barcode"),rs.getString("name"),rs.getString("unit"),rs.getDouble("price"));
            rs.close();
            stmt.close();
            dbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> getItems(){
        List<Item> items = new ArrayList<Item>();

        String sql = "SELECT * FROM items";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
              Item  item = new Item(rs.getString("barcode"),rs.getString("name"),rs.getString("unit"),rs.getDouble("price"));
                items.add(item);
            }
            rs.close();
            stmt.close();
            dbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void deleteItemByCode(String barcode){
        String sql = "delete from items where barcode='"+barcode+"'";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            if (result>0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
            stmt.close();
            dbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(Item item){
        String sql = "update items set name='"+item.getName()+
                "',unit ='"+item.getName()+"',price="+item.getPrice()+
                " where barcode='"+item.getBarcode()+"'";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            if (result>0){
                System.out.println("修改成功");
            }
            else{
                System.out.println("修改失败");
            }
            stmt.close();
            dbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertItem(Item item){
        String sql = "insert into items values('"+item.getBarcode()+"','"
                +item.getName()+"','"+item.getName()+"',"
                +item.getPrice()+")";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            // DML(数据操纵语言insert、update、detele)操作使用executeUpdate()
            int result = stmt.executeUpdate(sql);
            if (result>0){
                System.out.println("插入成功");
            }
            else{
                System.out.println("插入失败");
            }
            stmt.close();
            dbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

