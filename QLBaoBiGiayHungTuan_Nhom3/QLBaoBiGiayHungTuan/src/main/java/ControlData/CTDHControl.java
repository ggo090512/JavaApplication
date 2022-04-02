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
public class CTDHControl {
    ConnectDB cn = new ConnectDB();

    public ResultSet showData() throws SQLException {
        cn.connectSQL();
        String sql = "select MaCTDH, TenSP, TenGiay, TenMuc, SoLuong, DonGia from CHITIETDONHANG c, "
                + "SANPHAM s, GIAY g, MUC m where c.MaSP=s.MaSP and c.MaGiay=g.MaGiay and c.MaMuc=m.MaMuc ";
        return cn.LoadData(sql);
    }

    public ResultSet show1CTHD(String maPhieu) throws SQLException {
        String sql = "select *  from CHITIETDONHANG c, SANPHAM s, GIAY g, MUC m where c.MaSP=s.MaSP and c.MaGiay=g.MaGiay "
                + "and c.MaMuc=m.MaMuc and c.MaCTDH='" + maPhieu + "'";
        return cn.LoadData(sql);
    }

    public void InsertData(String maSp, String maGiay, String maMuc, String soLuong, String donGia) throws SQLException {
        String sql = "INSERT INTO CHITIETDONHANG VALUES(" + maSp + ", " + maGiay + ", " + maMuc + ", " + soLuong + ", " + donGia + ")";
        cn.UpdateData(sql);
    }
    //Dieu chinh 1 dong du lieu vao table LoaiSP

    public void EditData(String maPhieu,String maSp, String maGiay, String maMuc, String soLuong, String donGia ) throws SQLException {
        String sql = "Update CHITIETDONHANG set MaSP=" + maSp + ",MaGiay=" + maGiay + ", MaMuc=" + maMuc + ", Soluong="+soLuong+", Dongia="+donGia+" where MaCTDH=" + maPhieu + "";
        cn.UpdateData(sql);
    }
    //Xoa 1 dong du lieu vao table LoaiSP

    public void DeleteData(String maPhieu) throws SQLException {
        String sql = "Delete from CHITIETDONHANG where MaCTDH='" + maPhieu + "'";
        cn.UpdateData(sql);
    }
}
