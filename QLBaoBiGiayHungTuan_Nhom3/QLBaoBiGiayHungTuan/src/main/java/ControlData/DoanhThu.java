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
public class DoanhThu {
    ConnectDB cn = new ConnectDB();
    public ResultSet ShowDoanhThu() throws SQLException{
        cn.connectSQL();
        String sql = "select h.MaHoaDon, NgayLap, h.MaKH, k.TenKH , s.TenSP, m.TenMuc, g.TenGiay,SoLuong,(GiaSP*Soluong)+GiaMuc+GiaGiay as Gia \n" +
                     "from SANPHAM s, MUC m, GIAY g, KHACHHANG k, HOADON h, CHITIETDONHANG c\n" +
                     "where s.MaSP=c.MaSP and m.MaMuc=c.MaMuc and g.MaGiay=c.MaGiay and k.MaKH=h.MaKH";
        return cn.LoadData(sql);
    }
    public ResultSet ShowDoanhThu(String ngl) throws SQLException{
        cn.connectSQL();
        String sql = "select h.MaHoaDon, NgayLap, h.MaKH, k.TenKH , s.TenSP, m.TenMuc, g.TenGiay,SoLuong,(GiaSP*Soluong)+GiaMuc+GiaGiay as Gia \n" +
                     "from SANPHAM s, MUC m, GIAY g, KHACHHANG k, HOADON h, CHITIETDONHANG c\n" +
                     "where s.MaSP=c.MaSP and m.MaMuc=c.MaMuc and g.MaGiay=c.MaGiay and k.MaKH=h.MaKH and NgayLap='" + ngl + "'";
        return cn.LoadData(sql);
    }
}
