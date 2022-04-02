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
public class Giay {
    public ConnectDB cn = new ConnectDB();
    public ResultSet ShowGiay () throws SQLException{
        cn.connectSQL();
        String sql = "select * from GIAY";
        return cn.LoadData(sql);    
    }
    public ResultSet Show1Giay (String MaGiay) throws SQLException{
        cn.connectSQL();
        String sql = "select * from GIAY where MaGiay='"+MaGiay+"'";
        return cn.LoadData(sql);    
    }
    public void ThemGiay(String TenGiay, int Gia) throws SQLException{
        cn.connectSQL();
        String sql = "insert GIAY (TenGiay,GiaGiay)\n" +
                        "values (N'"+TenGiay+"','"+Gia+"')";
        cn.UpdateData(sql);
    }
    public void XoaGiay (String MaGiay) throws SQLException{
        cn.connectSQL();
        String sql = "Delete from GIAY where MaGiay='"+MaGiay+"'";
        cn.UpdateData(sql);
    }
    public void SuaGiay (String MaGiay, String Ten, int Gia) throws SQLException{
        cn.connectSQL();
        String sql = "Update GIAY set TenGiay=N'"+Ten+"', GiaGiay='"+Gia+"' where MaGiay='"+MaGiay+"'";
        cn.UpdateData(sql);
    }
    // show ten va ma
    public ResultSet showMaandTen () throws SQLException{
        cn.connectSQL();
        String sql = "select MaGiay, TenGiay, GiaGiay from GIAY";
        return cn.LoadData(sql);
    }
    public ResultSet FindGiay(String tenGiay) throws SQLException{
            String sql = "SELECT MaGiay, TenGiay, GiaGiay FROM GIAY where TenGiay like N'%"+tenGiay+"%'";
            return cn.LoadData(sql);
        }
    
}
