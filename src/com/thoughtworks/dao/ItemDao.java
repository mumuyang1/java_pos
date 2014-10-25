package com.thoughtworks.dao;

import com.thoughtworks.util.DbUtil;
import com.thoughtworks.vo.Item;

import java.sql.*;

/**
 * Created by Administrator on 2014/10/25.
 */
public class ItemDao {

    private DbUtil dbUtil = new DbUtil();

    public static void main(String[] args){
        ItemDao itemDao = new ItemDao();
        Item item = new Item("ITEM000002","香蕉","斤",10.0);
//        itemDao.getItem();
//        itemDao.updateItem(item);
//        itemDao.deleteItemByCode("ITEM000005");
        itemDao.insertItem(item);
    }

    public void getItem(){
        String sql = "SELECT * FROM items";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            String barcode = rs.getString("barcode");
            String name = rs.getString("name");
            String unit = rs.getString("unit");
            double price = rs.getDouble("price");
            System.out.println("条形码："+barcode+"，名称:"+name+"，数量："+unit+"，单价："+price+"(元)");
            rs.close();
            stmt.close();
            dbUtil.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItemByCode(String barcode){
        String sql = "delete from items where barcode='"+barcode+"'";
        Connection conn = dbUtil.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            // DML(数据操纵语言insert、update、detele)操作使用executeUpdate()
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

