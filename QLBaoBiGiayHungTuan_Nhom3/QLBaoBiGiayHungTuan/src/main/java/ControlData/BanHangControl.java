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
public class BanHangControl {
    public ConnectDB cn = new ConnectDB();
    public void createHD() throws SQLException{
        cn.connectSQL();
        String sql ="insert HOADON values (" + "GETDATE()" + ", null)";
        cn.UpdateData(sql);
    }
    public void deleteHDnull() throws SQLException{
        cn.connectSQL();
        String sql = "delete from HOADON where MaKH is null";
        cn.UpdateData(sql);
    }
    public ResultSet showMaHD() throws SQLException{
        cn.connectSQL();
        String sql = "select * from HOADON where MaKH is null";
        return cn.LoadData(sql);
    }
    public void addDetailtoCTHD(String maSP, String maGiay, String maMuc, String maHD, String Soluong)throws SQLException{
        String sql ="insert CHITIETDONHANG values ("+maHD+","+maSP+","+maGiay+","+maMuc+","+Soluong+") ";
        cn.UpdateData(sql);
    }
    public ResultSet showDetailstoHD (String maHD) throws SQLException{
        cn.connectSQL();
        String sql = "select s.TenSP, g.TenGiay, m.TenMuc, c.Soluong as SLSP ,(GiaSP*Soluong)+GiaMuc+GiaGiay as Gia, c.MaSP, c.MaGiay, c.MaMuc\n"
                + "from SANPHAM s, GIAY g, MUC m, CHITIETDONHANG c\n"
                + "where s.MaSP=c.MaSP and m.MaMuc=c.MaMuc and	g.MaGiay=c.MaGiay and c.MaHoaDon="+maHD+" ";
        return cn.LoadData(sql);
    }
    public void editSoluong(int soLuong, String maHD) throws SQLException {
        String sql = "Update CHITIETDONHANG set Soluong=" + soLuong + " where MaHoaDon=" + maHD + "";
        cn.UpdateData(sql);
    }
    public ResultSet getDataCTHD(String tenSP, String tenGiay, String tenMuc, String maHD) throws SQLException{
        String sql = "select  c.MaSP, c.MaGiay, c.MaMuc\n"
                + "from SANPHAM s, GIAY g, MUC m, CHITIETDONHANG c\n"
                + "where s.MaSP=c.MaSP and m.MaMuc=c.MaMuc and	g.MaGiay=c.MaGiay and c.MaHoaDon="+maHD+" and s.TenSP='"+tenSP+"' and g.TenGiay='"+tenGiay+"' and m.TenMuc='"+tenMuc+"' ";
        return cn.LoadData(sql);
    }
    public void deleteSPfromCTHD(String maSP, String maGiay, String maMuc, String maHD) throws SQLException{
        cn.connectSQL();
        String sql = "delete from CHITIETDONHANG where MaHoaDon="+maHD+" and MaSP="+maSP+" and MaGiay="+maGiay+" and MaMuc="+maMuc+" ";
        cn.UpdateData(sql);
    }
    public void deleteCTHD(String maHD) throws SQLException {
        cn.connectSQL();
        String sql = "delete from CHITIETDONHANG where MaHoaDon = " + maHD + "";
        cn.UpdateData(sql);
    }
}
