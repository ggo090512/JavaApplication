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
public class QLViTri {
    public ConnectDB cn = new ConnectDB();
        //Truy van tat ca du lieu trong table LoaiSP
        public ResultSet ShowViTri() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT * FROM dbo.ViTri";
            return cn.LoadData(sql);
        }
        //Truy van cac dong du lieu trong table LoaiSP theo Maloai
        public ResultSet ShowViTri(String mvt) throws SQLException{
            String sql = "SELECT * FROM dbo.ViTri where MaViTri='"+mvt+"'";
            return cn.LoadData(sql);
        }
        //Them moi 1 dong du lieu vao table LoaiSP
        public void InsertData(String mvt, String tvt) throws SQLException{
            String sql = "INSERT INTO dbo.ViTri VALUES('"+mvt+"',N'"+tvt+"')";
            cn.UpdateData(sql);
        }
        //Dieu chinh 1 dong du lieu vao table LoaiSP
        public void EditData(String mvt, String tvt) throws SQLException{
            String sql = "Update dbo.ViTri set TenVT=N'"+tvt+"'where MaViTri='"+mvt+"'";
            cn.UpdateData(sql);
        }
        //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(String mvt) throws SQLException{
            String sql = "Delete from ViTri where MaViTri='"+mvt+"'";
            cn.UpdateData(sql);
        }
}
