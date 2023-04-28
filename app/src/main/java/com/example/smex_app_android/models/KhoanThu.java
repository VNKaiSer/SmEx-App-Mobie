package com.example.smex_app_android.models;

import java.util.Date;

public class KhoanThu {
    private int maThu;
    private String moTa;
    private double soTien;

    private String ngayThu;

    public KhoanThu() {
    }

    public KhoanThu( String moTa, double soTien, String ngayThu) {
        this.moTa = moTa;
        this.soTien = soTien;
        this.ngayThu = ngayThu;
    }

    public int getMaThu() {
        return maThu;
    }

    public void setMaThu(int maThu) {
        this.maThu = maThu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTie(double soTie) {
        this.soTien = soTie;
    }
    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }
}
