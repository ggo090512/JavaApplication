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
public class Muc {
    public ConnectDB cn = new ConnectDB();
    public ResultSet ShowMuc() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT * FROM MUC";
            return cn.LoadData(sql);
        }
        //Truy van cac dong du lieu trong table LoaiSP theo Maloai
        public ResultSet Show1Muc(String MaMuc) throws SQLException{
            String sql = "SELECT * FROM MUC where MaMuc='"+MaMuc+"'";
            return cn.LoadData(sql);
        }
        //Them moi 1 dong du lieu vao table LoaiSP
        public void InsertData(String Ten, int Gia) throws SQLException{
            String sql = "INSERT INTO MUC VALUES(N'"+Ten+"','"+Gia+"')";
            cn.UpdateData(sql);
        }
        //Dieu chinh 1 dong du lieu vao table LoaiSP
        public void EditData(String MaMuc, String Ten, int Gia) throws SQLException{
            String sql = "Update MUC set TenMuc=N'"+Ten+"', GiaMuc="+Gia+" where MaMuc="+MaMuc+"";
            cn.UpdateData(sql);
        }
        //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(String MaMuc) throws SQLException{
            String sql = "Delete from MUC where MaMuc='"+MaMuc+"'";
            cn.UpdateData(sql);
        }
        // show ten va ma
        public ResultSet showMaandTen () throws SQLException{
            cn.connectSQL();
            String sql = "select MaMuc, TenMuc, GiaMuc from MUC";
            return cn.LoadData(sql);
        }
        public ResultSet FindMuc(String tenMuc) throws SQLException{
            String sql = "SELECT MaMuc, TenMuc, GiaMuc FROM MUC where TenMuc like N'%"+tenMuc+"%'";
            return cn.LoadData(sql);
        }
}
