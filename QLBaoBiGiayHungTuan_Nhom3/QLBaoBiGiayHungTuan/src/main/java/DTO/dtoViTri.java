/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class dtoViTri {


    int MaVT;

    public int getMaVT() {
        return MaVT;
    }

    public void setMaVT(int MaVT) {
        this.MaVT = MaVT;
    }

    public String getTenVT() {
        return TenVT;
    }

    public void setTenVT(String TenVT) {
        this.TenVT = TenVT;
    }

    public dtoViTri(int MaVT, String TenVT) {
        this.MaVT = MaVT;
        this.TenVT = TenVT;
    }

    @Override
    public String toString() {
        return "dtoViTri{" + "MaVT=" + MaVT + ", TenVT=" + TenVT + '}';
    }
    public dtoViTri() {
    }
    String TenVT;
}
