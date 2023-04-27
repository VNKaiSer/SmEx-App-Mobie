package com.example.smex_app_android.models;

import java.util.Date;

public class KhoanThu {
    private int maThu;
    private String moTa;
    private double soTien;

    private Date ngayThu;

    public KhoanThu() {
    }

    public KhoanThu(int maThu, String moTa, double soTien, Date ngayThu) {
        this.maThu = maThu;
        this.moTa = moTa;
        this.soTien = soTien;
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
    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }
}
