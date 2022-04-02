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
public class HoaDonControl {
    ConnectDB cn = new ConnectDB();
    public ResultSet showData () throws SQLException{
        cn.connectSQL();
        String sql = "select MaHoaDon, TenKH, NgayLap from HOADON h, KHACHHANG k where h.MaKH = k.MaKH";
        return  cn.LoadData(sql);
    }
    public void insertKH( String maKH, String maHD) throws SQLException {
        String sql = "update HOADON set MaKH=" + maKH + " where MaHoaDon="+maHD+"";
        cn.UpdateData(sql);
    }
    public void deleteHDmaKHisnull ()throws SQLException{
        cn.connectSQL();
        String sql = "delete from HOADON where MaKH is null";
        cn.UpdateData(sql);
    }
}
