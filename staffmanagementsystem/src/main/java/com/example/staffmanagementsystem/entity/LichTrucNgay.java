package com.example.staffmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "LichTrucNgay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LichTrucNgay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLichTruc")
    private Integer maLichTruc;

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

    @Column(name = "NgayTruc")
    private LocalDate ngayTruc;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;
}
