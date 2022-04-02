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
public class QLKhachHang {
    public ConnectDB cn = new ConnectDB();
    //Truy van tat ca du lieu trong table LoaiSP
        public ResultSet ShowKhachHang() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT * FROM dbo.KHACHHANG";
            return cn.LoadData(sql);
        }
        //Truy van cac dong du lieu trong table LoaiSP theo Maloai
        public ResultSet ShowKhachHang(String mkh) throws SQLException{
            String sql = "SELECT * FROM dbo.KHACHHANG where MaKH='"+mkh+"'";
            return cn.LoadData(sql);
        }
        //Them moi 1 dong du lieu vao table LoaiSP
        public void InsertData(String tkh, String ct, String dc, String sdt, String email) throws SQLException{
            String sql = "INSERT INTO dbo.KHACHHANG VALUES(N'"+tkh+"',N'"+ct+"',N'"+dc+"','"+sdt+"','"+email+"')";
            cn.UpdateData(sql);
        }
        //Dieu chinh 1 dong du lieu vao table LoaiSP
        public void EditData(int mkh, String tkh, String ct, String dc, String sdt, String email) throws SQLException{
            String sql = "Update KHACHHANG set TenKH=N'"+tkh+"',CongTy=N'"+ct+"',DiaChi=N'"+dc+"',SDT='"+sdt+"', Email='"+email+"' where MaKH="+mkh+"";
            cn.UpdateData(sql);
        }
        //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(String mkh) throws SQLException{
            String sql = "Delete from KHACHHANG where MaKH='"+mkh+"'";
            cn.UpdateData(sql);
        }
        // tim khach hang theo them
        public ResultSet FindKhachHang(String tenKH) throws SQLException{
            String sql = "SELECT * FROM dbo.KHACHHANG where TenKH like N'%"+tenKH+"%'";
            return cn.LoadData(sql);
        }
}
