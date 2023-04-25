package model;

public class ThuNhap {
    private int maThu;
    private String moTa;
    private double soTie;

    public ThuNhap() {
    }

    public ThuNhap(int maThu, String moTa, double soTie) {
        this.maThu = maThu;
        this.moTa = moTa;
        this.soTie = soTie;
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

    public double getSoTie() {
        return soTie;
    }

    public void setSoTie(double soTie) {
        this.soTie = soTie;
    }
}
