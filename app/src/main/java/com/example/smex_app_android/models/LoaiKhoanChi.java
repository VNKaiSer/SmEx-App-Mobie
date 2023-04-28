package com.example.smex_app_android.models;

public enum LoaiKhoanChi {
    AN("Ăn uống"),
    SINHHOAT("Sinh hoạt"),
    DILAI("Di chuyển"),
    TRANGPHUC("Trang phục"),
    HUONGTHU("Hưởng thụ"),
    CONCAI("Con cái"),
    HIEUHI("Hiếu hỉ"),
    NHACUA("Nhà cửa"),
    SUCKHOE("Sức khỏe"),
    BANTHAN("Bản thân"),
    KHAC("Khác");

    private String khoanChi;

    private LoaiKhoanChi(String khoanChi) {
        this.khoanChi = khoanChi;
    }

    public String getKhoanChi() {
        return khoanChi;
    }

}
