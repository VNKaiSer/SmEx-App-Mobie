package com.example.smex_app_android.models;

public class KhoanChi {
    private int maKhoanChi;
    private LoaiKhoanChi loaiKhoanChi;
    private String ngayChi;
    private String moTa;
    private double soTien;

    public KhoanChi(LoaiKhoanChi loaiKhoanChi, String ngayChi, String moTa, double soTien) {
        this.loaiKhoanChi = loaiKhoanChi;
        this.ngayChi = ngayChi;
        this.moTa = moTa;
        this.soTien = soTien;
    }

    public KhoanChi() {

    }

    public KhoanChi(int maKhoanChi, LoaiKhoanChi loaiKhoanChi, String ngayChi, String moTa, double soTien) {
        this.maKhoanChi = maKhoanChi;
        this.loaiKhoanChi = loaiKhoanChi;
        this.ngayChi = ngayChi;
        this.moTa = moTa;
        this.soTien = soTien;
    }

    public int getMaKhoanChi() {
        return maKhoanChi;
    }

    public void setMaKhoanChi(int maKhoanChi) {
        this.maKhoanChi = maKhoanChi;
    }

    public LoaiKhoanChi getLoaiKhoanChi() {
        return loaiKhoanChi;
    }

    public void setLoaiKhoanChi(LoaiKhoanChi loaiKhoanChi) {
        this.loaiKhoanChi = loaiKhoanChi;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
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

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
}
