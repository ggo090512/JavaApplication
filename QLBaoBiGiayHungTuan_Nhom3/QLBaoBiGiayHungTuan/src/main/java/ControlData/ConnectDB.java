/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ConnectDB {
    
    public Connection conn = null;
    //Phuong thuc thuc hien ket noi CSDL
    public void connectSQL() throws SQLException{
        try{
            String userName = "sa";
            String passWord = "dominhhieu090500";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBaoBiGiayHungTuan;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = java.sql.DriverManager.getConnection(url,userName,passWord);
        }
        catch(ClassNotFoundException e){
            System.out.println("Ket noi that bai");
        }
    }
    //Phuong thuc dung de truy van CSDL
    public ResultSet LoadData(String sql) throws SQLException{
        try{
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
        }catch(SQLException e){
        }
        return null;
    }
    //Phuong thuc thuc hien them, xoa, sua du lieu
    public void UpdateData(String sql){
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException e){
        }
    }
}
