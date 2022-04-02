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
public class QLSanPham {
    public ConnectDB cn = new ConnectDB();
        //Truy van tat ca du lieu trong table LoaiSP
        public ResultSet ShowLoaiSP() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT * FROM dbo.LoaiSP";
            return cn.LoadData(sql);
        }
        //Truy van cac dong du lieu trong table LoaiSP theo Maloai
        public ResultSet ShowLoaiSP(String ml) throws SQLException{
            String sql = "SELECT * FROM dbo.LoaiSP where MaLoai='"+ml+"'";
            return cn.LoadData(sql);
        }
        
        //Truy van từ tên lấy mã LoaiSP
        //Truy van cac dong du lieu trong table LoaiSP theo Maloai
        public ResultSet ShowTenLoaiSP(String ten) throws SQLException{
            String sql = "SELECT * FROM dbo.LoaiSP where TenLoaiSP='"+ten+"'";
            return cn.LoadData(sql);
        }
        //Show tat ca san pham
        public ResultSet ShowSP() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT MaSP, TenSP, GiaSP, TenLoaiSP FROM dbo.SanPham S, LoaiSP L WHERE L.MaLoai = S.MaLoai";
            return cn.LoadData(sql);
        }
        
        //Truy van du lieu trong table SP
        public ResultSet ShowSPTheoLoai(String msp) throws SQLException
        {
            String sql = "SELECT MaSP, TenSP, GiaSP, TenLoaiSP FROM SANPHAM S, LOAISP L WHERE L.MaLoai = S.MaLoai and MaSP ="+msp+"";
            return cn.LoadData(sql);
        }
        //Them moi 1 dong du lieu vao table LoaiSP
        public void InsertData(String tl, String gia, String ml) throws SQLException{
            cn.connectSQL();
            String sql = "INSERT INTO SANPHAM VALUES(N'"+tl+"',"+gia+","+ml+")";
            cn.UpdateData(sql);
        }
        //Dieu chinh 1 dong du lieu vao table LoaiSP
        public void EditData(String msp, String tensp, int gia, String ml) throws SQLException{
            String sql = "Update SANPHAM set TenSP=N'"+tensp+"',GiaSP='"+gia+"', MaLoai='"+ml+"' where MaSP='"+msp+"'";
            cn.UpdateData(sql);
        }
        //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(String ml) throws SQLException{
            String sql = "Delete from SANPHAM where MaSP='"+ml+"'";
            cn.UpdateData(sql);
        }
        
        // show ma & Ten
        public ResultSet showMaandTen() throws SQLException{
            cn.connectSQL();
            String sql = "SELECT MaSP, TenSP, GiaSP FROM SANPHAM";
            return cn.LoadData(sql);
        }
        public ResultSet show1SP(String msp) throws SQLException
        {
            String sql = "SELECT * FROM SANPHAM WHERE MaSP ='"+msp+"'";
            return cn.LoadData(sql);
        }
        public ResultSet FindSP(String tenSP) throws SQLException{
            String sql = "SELECT MaSP, TenSP, GiaSP FROM SANPHAM where TenSP like N'%"+tenSP+"%'";
            return cn.LoadData(sql);
        }
}
