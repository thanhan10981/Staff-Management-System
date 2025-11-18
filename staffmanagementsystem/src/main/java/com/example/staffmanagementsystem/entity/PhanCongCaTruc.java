package com.example.staffmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "PhanCongCaTruc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhanCongCaTruc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhanCong")
    private Integer maPhanCong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhanVien", insertable = false, updatable = false)
    private NhanVien nhanVien;

    @Column(name = "MaNhanVien")
    private Integer maNhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaCa", insertable = false, updatable = false)
    private CaLamViec ca;

    @Column(name = "MaCa")
    private Integer maCa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong", insertable = false, updatable = false)
    private PhongVatLy phong;

    @Column(name = "MaPhong")
    private Integer maPhong;

    @Column(name = "MaKhoa")
    private Integer maKhoa;

    @Column(name = "NgayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "LapLaiHangTuan")
    private Boolean lapLaiHangTuan;

    @Column(name = "NguoiTao")
    private Integer nguoiTao;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;
}
