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
 * @author Admin
 */
public class QLLoaiSP {
        public ConnectDB cn = new ConnectDB();
        //Truy van tat ca du lieu trong table LoaiSP
        public ResultSet ShowLoaiSP() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT * FROM dbo.LOAISP";
            return cn.LoadData(sql);
        }
        //Truy van cac dong du lieu trong table LoaiSP theo Maloai
        public ResultSet ShowLoaiSP(String ml) throws SQLException{
            String sql = "SELECT * FROM dbo.LOAISP where MaLoai="+ml+"";
            return cn.LoadData(sql);
        }
        //Them moi 1 dong du lieu vao table LoaiSP
        public void InsertData(String tl) throws SQLException{
            String sql = "INSERT INTO dbo.LOAISP VALUES(N'"+tl+"')";
            cn.UpdateData(sql);
        }
        //Dieu chinh 1 dong du lieu vao table LoaiSP
        public void EditData(String ml, String tl) throws SQLException{
            String sql = "Update LOAISP set TenLoaiSP=N'"+tl+"' where MaLoai='"+ml+"'";
            cn.UpdateData(sql);
        }
        //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(String ml) throws SQLException{
            cn.connectSQL();
            String sql = "Delete from LOAISP where MaLoai="+ml+"";
            cn.UpdateData(sql);
        }
    
}
