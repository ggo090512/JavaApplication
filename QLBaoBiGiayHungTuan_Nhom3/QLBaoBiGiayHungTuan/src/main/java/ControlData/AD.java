/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlData;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class AD {

    /**
     *
     */
    public static String ten, user;
    
    public ConnectDB cn = new ConnectDB();
    public ResultSet showData ()throws SQLException{
        cn.connectSQL();
        String sql = "select * from AD";
        return cn.LoadData(sql);
    }
    public void AddUser(String user, String pass, String ten, String phanQuyen) throws SQLException{
        cn.connectSQL();
        String sql ="insert AD (UserName, PassWord, Ten, PhanQuyen )\n" +
                "values ('"+user+"','"+pass+"',N'"+ten+"', '"+phanQuyen+"')";
        cn.UpdateData(sql);
    }
    public void EditUser( String user, String passmoi, String ten ) throws SQLException{
        cn.connectSQL();
        String sql = "update AD set Ten= N'"+ten+"', PassWord='"+passmoi+"'\n"+
                 "where UserName='"+user+"'";
        cn.UpdateData(sql);
    }
    public void DeleteUser(String user) throws SQLException{
        String sql = "delete from AD where UserName='"+user+"'";
        cn.UpdateData(sql);
    }
    public ResultSet ShowAD (String user) throws SQLException{
        cn.connectSQL();
        String sql = "Select* from AD where UserName='"+user+"'";
        return cn.LoadData(sql);            
    }
}

