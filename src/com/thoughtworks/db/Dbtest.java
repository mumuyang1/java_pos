package com.thoughtworks.db;

import com.thoughtworks.vo.Item;

import java.sql.*;

public class Dbtest {

    String driveName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/pet";
    String userName = "root";
    String password = "lyz123";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


//    使用JDBC操作Mysql数据库

    /*
        1.加载驱动 导入JDBC包
        2.定义连接的URL
        3.建立连接
        4.创建statement对象
        5.执行查询或更新操作
        6.
        7.
     */

    public void  getItem() {

        String sql = "SELECT * FROM items";         //执行查询或更新操作

        try {
            Class.forName(driveName);
            conn = DriverManager.getConnection(url,userName,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            String barcode = rs.getString("barcode");
            String name = rs.getString("name");
            String unit = rs.getString("unit");
            double price = rs.getDouble("price");

            System.out.print("条形码："+barcode+" 名称："+name+" unit:"+unit+" 单价："+price+"元");

            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertItem(Item item) {
        String sql = "INSERT INTO items VALUES('"+item.getBarcode()+
                "','"+item.getName()+"','"+item.getUnit()+"',"+item.getPrice()+")";
        try {
            Class.forName(driveName);
            conn = DriverManager.getConnection(url,userName,password);
            stmt = conn.createStatement();
            //DML（数据操纵语言insert,update,delete）操作使用executeUpdate()；
            int result = stmt.executeUpdate(sql);
            if(result > 0){
                System.out.print("插入成功");
            }
            else {
                System.out.print("插入失败");
            }
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItemByCode(String barcode) {
        String sql = "DELETE FROM items WHERE barcode = '"+barcode+"'";
        try {
            Class.forName(driveName);
            conn = DriverManager.getConnection(url,userName,password);
            stmt = conn.createStatement();
            //DML（数据操纵语言insert,update,delete）操作使用executeUpdate()；
            int result = stmt.executeUpdate(sql);
            if(result > 0){
                System.out.print("删除成功");
            }
            else {
                System.out.print("删除失败");
            }
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Item item) {
        String sql = "update items set name = '"+item.getName()+
                "',unit = '"+item.getUnit()+"',price="+item.getPrice()+" where barcode = '"+item.getBarcode()+"'";
        try {
            Class.forName(driveName);
            conn = DriverManager.getConnection(url,userName,password);
            stmt = conn.createStatement();
            //DML（数据操纵语言insert,update,delete）操作使用executeUpdate()；
            int result = stmt.executeUpdate(sql);
            if(result > 0){
                System.out.print("修改成功");
            }
            else {
                System.out.print("修改失败");
            }
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
