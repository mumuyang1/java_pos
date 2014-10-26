package com.thoughtworks.dao;

import com.thoughtworks.service.ItemIService;
import com.thoughtworks.util.DbUtil;
import com.thoughtworks.vo.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements ItemIService {

    private DbUtil dbUtil = new DbUtil();


    @Override
    public Item getItemById(int id){
        Item item = null;

        String sql = "SELECT * FROM items WHERE id = '"+id+"'";
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
    public void deleteItemById(int id){
        String sql = "delete from items where id ='"+id+"'";
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
        String sql = "insert into items values(null,'"+item.getBarcode()+"','"
                +item.getName()+"',"+item.getPrice()+",'"
                +item.getUnit()+"')";
        Connection conn = dbUtil.getConnection();
        System.out.println(sql);
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

