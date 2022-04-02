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
public class QLNhanVien {
    public ConnectDB cn = new ConnectDB();
        //Truy van tat ca du lieu trong table ViTri
        public ResultSet ShowViTri() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT * FROM dbo.ViTri";
            return cn.LoadData(sql);
        }
        //Truy van cac dong du lieu trong table ViTri theo MaVT
        public ResultSet ShowViTri(String mvt) throws SQLException{
            String sql = "SELECT TenVT FROM dbo.ViTri where MaViTri='"+mvt+"'";
            return cn.LoadData(sql);
        }
        //Show tat ca nhan vien
        public ResultSet ShowNV() throws SQLException{
            cn.connectSQL();
            String sql= "SELECT MaNV,TenNV,NgaySinh,QueQuan,CMND,GioiTinh,SDT,Email,V.MaViTri,TenVT,LuongCB FROM dbo.NhanVien N, dbo.ViTri V WHERE V.MaViTri = N.MaViTri";
            return cn.LoadData(sql);
        }
        
        public ResultSet ShowNVTheoMaNV(String mnv) throws SQLException{
            cn.connectSQL();
            String sql= "SELECT MaNV,TenNV,NgaySinh,QueQuan,CMND,GioiTinh,SDT,Email,LuongCB,V.MaViTri,TenVT FROM dbo.NhanVien N, dbo.ViTri V WHERE V.MaViTri = N.MaViTri AND MaNV ='"+ mnv +"'";
            return cn.LoadData(sql);
        }
        //Them moi 1 dong du lieu vao table SP
        public void InsertData(String mnv, String tnv, String ns, String qq, String cm, String gt, String sdt, String email, String vt, int lcb) throws SQLException{
            String sql = "INSERT INTO dbo.NhanVien VALUES('"+mnv+"',N'"+tnv+"',N'"+ns+"',N'"+qq+"',N'"+cm+"',N'"+gt+"',N'"+sdt+"',N'"+email+"',N'"+vt+"',N'"+lcb+"')";
            cn.UpdateData(sql);
        }
        //Sua 1 dong
        public void EditData(String mnv, String tnv, String ns, String qq, String cm, String gt, String sdt, String email, String vt, int lcb)throws SQLException{
            String sql = "Update SanPham set TenNV=N'"+tnv+"',NgaySinh=N'"+ns+"',QueQuan=N'"+qq+"',CMND=N'"+cm+"',GioiTinh=N'"+gt+"',SDT=N'"+sdt+"',Email=N'"+email+"',MaViTri=N'"+vt+"',LuongCB=N'"+lcb+"' where MaNV='" + mnv +"'";
            cn.UpdateData(sql);
        }
        //Xoa 1 dong du lieu vao table LoaiSP
        public void DeleteData(String mnv) throws SQLException{
            String sql = "Delete from NhanVien where MaNV='"+mnv+"'";
            cn.UpdateData(sql);
        }
}
